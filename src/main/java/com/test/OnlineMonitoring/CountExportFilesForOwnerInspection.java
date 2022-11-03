package com.test.OnlineMonitoring;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;


public class CountExportFilesForOwnerInspection {

	public static void main(String[] args) throws IOException {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
	    long currentLong = current/1000;
        long yesterdayZero = zero - 3600 * 24;
        long yesterdayEnd = zero - 1;
        Calendar calendar = Calendar.getInstance();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format((Date) calendar.getTime());

        HttpURLConnection connection = null;
        try {
        URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/report_export/list/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=" + zero + 
                "&create_at_end=" + currentLong;
        // System.out.print(params + "\n");
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
	    // 导出次数
        String keyWord1 = "\"count\":";        
        String exportCnt = msg.substring(msg.indexOf("\"count\":") + keyWord1.length(), msg.indexOf("}}"));
        //System.out.println(exportCnt);
        // 集团id列表
        ArrayList<Integer> groupList = new ArrayList<Integer>();
        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
        JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	    
        JSONArray rptExpArray = (JSONArray) jsonMsgData.get("report_export");
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<rptExpArray.size(); i++) {
	    	JSONObject rptExpInfoJson = (JSONObject) rptExpArray.get(i);
	    	int groupId = (int) rptExpInfoJson.get("group_id");
	        if(!groupList.contains(groupId)){
	        	groupList.add(groupId);
	        	}  
	        
	    	if(!map.containsKey(groupId)) {
	    		map.put(groupId, 0);
	    	}	    	
	    	if(map.containsKey(groupId)) {
	    		map.put(groupId, map.get(groupId) + 1);
	    	}

	    }      
       
       // 登录管控平台并拿到cookie
       URL urlControlLogin = new URL("https://zj.buildingqm.com/control/v1/papi/login/login/?_ct=json&idempotent=" + currentLong);
       connection = (HttpURLConnection)urlControlLogin.openConnection();
       connection.setRequestMethod("POST");
       connection.setConnectTimeout(15000);
       connection.setReadTimeout(15000);;
       connection.setDoOutput(true);
       connection.setUseCaches(false);
       connection.addRequestProperty("Content-Type", "multipart/form-data; boundary=--testsssssss");      
       String mimeBoundary = "--testsssssss";      
       StringBuffer buffer = new StringBuffer();
       buffer.append("--").append(mimeBoundary);
       buffer.append("\r\n");
       buffer.append("Content-Disposition: form-data; name=\"username\"");
       //提交的数据前要有两个回车换行
       buffer.append("\r\n\r\n");
       buffer.append("admin");
       buffer.append("\r\n");
       //第二个提交的参数
       buffer.append("--").append(mimeBoundary);
       buffer.append("\r\n");
       buffer.append("Content-Disposition: form-data; name=\"password\"");
       buffer.append("\r\n\r\n");
       buffer.append("welovezhijianyun123");
       buffer.append("\r\n");
       //第三个提交的参数
       buffer.append("--").append(mimeBoundary);
       buffer.append("\r\n");
       buffer.append("Content-Disposition: form-data; name=\"group_code\"");
       buffer.append("\r\n\r\n");
       buffer.append("");
       buffer.append("\r\n");
       //第四个提交的参数
       buffer.append("--").append(mimeBoundary);
       buffer.append("\r\n");
       buffer.append("Content-Disposition: form-data; name=\"remember_me\"");
       buffer.append("\r\n\r\n");
       buffer.append("0");
       buffer.append("\r\n");         
       //body结束时 boundary前后各需添加两上横线，最添加添回车换行
       buffer.append("--").append(mimeBoundary).append("--").append("\r\n");
       OutputStream outControlLogin = connection.getOutputStream();
       outControlLogin.write(buffer.toString().getBytes());
       connection.connect();      

       String msgControlLogin = "";
       int codeControlLogin = connection.getResponseCode();
       if (codeControlLogin == 200) {
           BufferedReader reader = new BufferedReader(
                   new InputStreamReader(connection.getInputStream()));
           String line;
           while ((line = reader.readLine()) != null) {
        	   msgControlLogin += line + "\n";
           }
           reader.close();
       }
       
       // 获取cookie
       Map<String, List<String>> headerFields = connection.getHeaderFields();
       List<String> cookiesHeader = headerFields.get("Set-Cookie");
       String cookie = null;
       String sessionid = null;
       if(cookiesHeader != null){
           cookie = cookiesHeader.get(0);
           HttpCookie httpCookie = HttpCookie.parse(cookie).get(0);
           String name = httpCookie.getName(); 
           String value = httpCookie.getValue();
           String domain = httpCookie.getDomain();
           sessionid = cookie.substring(0, cookie.indexOf(";"));
       }
       
       // 获取集团名字以及写入导出次数
       HashMap<String,Integer> grpCntMap = new HashMap<String,Integer>();
       String exportDetail = "";
       Iterator ite = map.entrySet().iterator();
	    do {
	    	Entry grpIdCnt = (Entry)ite.next();
	    	int grpId = (int) grpIdCnt.getKey();
	    	URL urlGrpQuery = new URL("https://zj.buildingqm.com/control/v1/papi/customer/list/?");
	           connection = (HttpURLConnection)urlGrpQuery.openConnection();
	           connection.setRequestMethod("GET");
	           connection.setConnectTimeout(15000);
	           connection.setReadTimeout(15000);
	           connection.setUseCaches(false);
	           connection.setDoOutput(true);
	           connection.setDoInput(true);
	           // 写入cookie
	           connection.setRequestProperty("Cookie", sessionid);
	           connection.connect(); 
	           String query = "text=" + grpId + "&page=1&page_size=10";
	           OutputStream grpQueryOut = connection.getOutputStream();
	           grpQueryOut.write(query.getBytes());
	           out.flush();
	           out.close();
	           String grpQueryMsg = "";
	           int grpQueryCode = connection.getResponseCode();
	           if (grpQueryCode == 200) {
	               BufferedReader reader = new BufferedReader(
	                       new InputStreamReader(connection.getInputStream()));
	               String line;
	               while ((line = reader.readLine()) != null) {
	            	   grpQueryMsg += line + "\n";
	               }
	               reader.close();
	           }

	    	   connection.disconnect();
	    	    // 获取集团名
	           JSONObject grpMsgJson = JSONObject.fromObject(grpQueryMsg);
	           JSONObject grpMsgData = (JSONObject) grpMsgJson.get("data");	    
	           JSONArray grpMsgArray = (JSONArray) grpMsgData.get("customer_list");
	           JSONObject grpInfo = (JSONObject) grpMsgArray.get(0);
	           String groupName = (String) grpInfo.get("name");
	           grpCntMap.put(groupName, (Integer) grpIdCnt.getValue());
	           } while(ite.hasNext()); 
	    
	    // 无顺序输出
//	    Iterator grpMapIte = grpCntMap.entrySet().iterator();
//	    do {
//	    	Entry grpNameCnt = (Entry)grpMapIte.next();
//	    	exportDetail = exportDetail + grpNameCnt.getKey() + ": " + grpNameCnt.getValue() + "\\n";
//	    	} while(grpMapIte.hasNext()); 
//	    System.out.println(exportDetail);
	    
	    // 根据value顺序排列
//	    Map<String,Integer> sortedMap = grpCntMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors
//                  .toMap(Map.Entry::getKey,
//                         Map.Entry::getValue,
//                         (e1, e2) -> e1,
//                         LinkedHashMap::new));
	    
	    // 根据value倒序排列
	    Map<String,Integer> sortMapDesc= grpCntMap.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
	    
	    Iterator sortedMapIte = sortMapDesc.entrySet().iterator();
	    do {
	    	Entry grpNameCnt = (Entry)sortedMapIte.next();
	    	exportDetail = exportDetail + grpNameCnt.getKey() + ": " + grpNameCnt.getValue() + "\\n";
	    	} while(sortedMapIte.hasNext()); 
	    System.out.println(exportDetail);


        // 发送飞书通，QA群
        URL webHookUrl1 = new URL("https://open.feishu1.cn/open-apis/bot/v2/hook/d63f293b-9438-4c0c-a103-9dec1246d7bd/");
        connection = (HttpURLConnection)webHookUrl1.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
        String msgToSend1 = today + "新版业主验房导出PDF: " + exportCnt 
        		+ ";" + "\\n导出明细:\\n" + exportDetail;
        String postMsg1 = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend1 + "\"}}";        
        //System.out.print(postMsg1);
        OutputStream feiShuOut1 = connection.getOutputStream();
        feiShuOut1.write(postMsg1.getBytes());
        feiShuOut1.flush();
        feiShuOut1.close();
        String feiShuMsg1 = "";
        int feiShuCode1 = connection.getResponseCode();
        if (feiShuCode1 == 200) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                feiShuMsg1 += line + "\n";
            }
            reader.close();
        }
	    connection.disconnect();
        // 发送飞书通知，大群
        URL webHookUrl2 = new URL("https://open.feishu1.cn/open-apis/bot/v2/hook/c6a7f889-745c-413f-8ee5-cff67f5e0b4c/");
        connection = (HttpURLConnection)webHookUrl2.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
        String msgToSend2 = today + "新版业主验房导出PDF: " + exportCnt 
        		+ ";" + "\\n导出明细:\\n" + exportDetail;
        String postMsg2 = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend2 + "\"}}";        
        //System.out.print(postMsg2);
        OutputStream feiShuOut2 = connection.getOutputStream();
        feiShuOut2.write(postMsg2.getBytes());
        feiShuOut2.flush();
        feiShuOut2.close();
        String feiShuMsg2 = "";
        int feiShuCode2 = connection.getResponseCode();
        if (feiShuCode2 == 200) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                feiShuMsg2 += line + "\n";
            }
            reader.close();
        }
        connection.disconnect();

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
