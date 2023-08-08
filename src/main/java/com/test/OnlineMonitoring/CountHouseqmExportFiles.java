package com.test.OnlineMonitoring;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class CountHouseqmExportFiles {
	
	 private static final int threadNumber = 10;
	 
	 private static final int perThreadCreatSnpNumber = 10;
	 
	 private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/83f2649d-f761-4d57-81cf-be1b955c3802/";
//	 private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/d63f293b-9438-4c0c-a103-9dec1246d7bd/;https://open.feishu1.cn/open-apis/bot/v2/hook/2aa5f361-f8fd-4808-9865-f39da532d1f8/";
	 
	 public static void main(String[] args) {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
        long todayEnd = zero + 3600*24 - 1;
	    long currentLong = current/1000;
        long yesterdayZero = zero - 3600 * 24;
        long yesterdayEnd = zero - 1;
        Calendar calendar = Calendar.getInstance();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format((Date) calendar.getTime());    
        calendar.add(Calendar.DATE, -1);       
        String yesterday = df.format((Date)calendar.getTime());       

        HttpURLConnection connection = null;
        try {
        URL url = new URL("https://zj.buildingqm.com/houseqm/v3/papi/back_door/export_record/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=84&export_type=85&status=30&start_time=" + zero + 
                "&end_time=" + todayEnd 
                + "&like_params=true";
//        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=84&export_type=85&status=30&start_time=1673452800&end_time=1673539199"
//                + "&like_params=true";
	    System.out.print(params);
        OutputStream out = connection.getOutputStream();
        out.write(params.getBytes());
        out.flush();
        out.close();
        String msg = "";
        int code = connection.getResponseCode();
        if (code == 200) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                msg += line + "\n";
            }
            reader.close();
        }
	    connection.disconnect();
        // 处理结果
        // System.out.print(msg);
        String keyWord1 = "\"count\":";
        String exportCnt = msg.substring(msg.indexOf("\"count\":") + keyWord1.length(), msg.indexOf(",\"items\":["));
        
        // 从下载URL中截取项目名
        ArrayList<String> projectList = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();   
        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
        JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	    
        JSONArray rptExpArray = (JSONArray) jsonMsgData.get("items");
        for(int i=0; i<rptExpArray.size(); i++) {
	    	JSONObject rptExpInfoJson = (JSONObject) rptExpArray.get(i);
	    	String downloadUrl = (String) rptExpInfoJson.get("down_url");
	        Matcher findMatcher1 = Pattern.compile("/").matcher(downloadUrl);
	        int indexNum1=0;
	        while(findMatcher1.find()) {
	            indexNum1++;
	            if(indexNum1 == 3){
	                break;
	            }
	        }
	        Matcher findMatcher2 = Pattern.compile("_").matcher(downloadUrl);
	        int indexNum2=0;
	        while(findMatcher2.find()) {
	            indexNum2++;
	            if(indexNum2 == 1){
	                break;
	            }
	        }
	        String projectName = downloadUrl.substring(findMatcher1.start()+1, findMatcher2.start());
	        
    		if(!projectList.contains(projectName)){
    			projectList.add(projectName);
	        	}  
	        
	    	if(!map.containsKey(projectName)) {
	    		map.put(projectName, 0);
	    	}	    	
	    	if(map.containsKey(projectName)) {
	    		map.put(projectName, map.get(projectName) + 1);
	    	}	    

	    }
        int projectCnt = map.size();
        // 按项目出现次数的倒序排序
        String exportDetail = "";
        if(!map.isEmpty()) {
    	    Map<String,Integer> sortMapDesc= map.entrySet()
                    .stream()
                    .sorted(Collections
                            .reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors
                            .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
    	    
    	    Iterator sortedMapIte = sortMapDesc.entrySet().iterator();	    
    	    do {
    	    	Entry projectNameCnt = (Entry)sortedMapIte.next();
    	    	exportDetail = exportDetail + projectNameCnt.getKey() + ": " + projectNameCnt.getValue() + "\\n";
    	    	} while(sortedMapIte.hasNext());     	
        }

      

        // 发送飞书通知
        String[] urlString = urlStr.split(";");
        for(int i = 0; i < urlString.length; i++) {
        	URL webHookUrl = new URL(urlString[i]);
        	connection = (HttpURLConnection)webHookUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
            String msgToSend = null;
            String postMsg = null;
            if(Integer.valueOf(exportCnt) == 0) {
                msgToSend = today + "入伙验房没有PDF导出";
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}";  
            	
            } else {
                msgToSend = today + "入伙验房导出PDF: " + exportCnt 
                		+ "，涉及" + projectCnt + "个项目" + "\\n导出项目明细:\\n" + exportDetail;
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}";  
            	
            }
            System.out.print(postMsg);
            OutputStream feiShuOut = connection.getOutputStream();
            feiShuOut.write(postMsg.getBytes());
            feiShuOut.flush();
            feiShuOut.close();
            String feiShuMsg = "";
            int feiShuCode = connection.getResponseCode();
            if (feiShuCode == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                	feiShuMsg += line + "\n";
                }
                reader.close();
            }
    	    connection.disconnect();        	
        }

        } catch (IOException e) {
            System.out.print("转发出错，错误信息："+e.getLocalizedMessage()+";"+e.getClass());
        }finally {
            // 5. 断开连接
            if (null != connection){
                try {
                    connection.disconnect();
                }catch (Exception e){
                    System.out.print("httpURLConnection 流关闭异常："+ e.getLocalizedMessage());
                }
            }
        }

    }
    

}
