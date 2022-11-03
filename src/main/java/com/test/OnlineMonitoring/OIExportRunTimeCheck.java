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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.text.DecimalFormat;


public class OIExportRunTimeCheck {
	public static void main(String[] args) throws IOException {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
	    long currentLong = current/1000;
        long yesterdayZero = zero - 3600 * 24;
        long yesterdayEnd = zero - 1;
        Calendar calendar = Calendar.getInstance();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format((Date) calendar.getTime());
        
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(calendar2.MINUTE, -2);
        Date twoMinAgo = calendar2.getTime();
        long twoMinAgoLong = twoMinAgo.getTime()/1000;
        
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(calendar3.MINUTE, -15);
        Date fifteenMinAgo = calendar3.getTime();
        long fifteenMinAgoLong = fifteenMinAgo.getTime()/1000;
        
        Calendar calendar4 = Calendar.getInstance();
        calendar4.add(calendar4.MINUTE, -60);
        Date oneHourAgo = calendar4.getTime();
        long oneHourAgoLong = oneHourAgo.getTime()/1000;
        
        Calendar calendar5 = Calendar.getInstance();
        calendar5.add(calendar5.MINUTE, -3);
        Date threeMinAgo = calendar5.getTime();
        long threeMinAgoLong = threeMinAgo.getTime()/1000;
        

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
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=[10,20,30,40]&create_at_start=" 
        + oneHourAgoLong + "&create_at_end=" + threeMinAgoLong
        + "&execute_run_gte_second=30";
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
	    // System.out.println(msg);
	    ArrayList<String> longTimeExecutionList = new ArrayList<String>();
        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
	    JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	
	    JSONArray jsonMsgItem = (JSONArray) jsonMsgData.get("report_export");
	    int longTimeExecuteCnt = (int) jsonMsgData.get("count");
	    // System.out.println(longTimeExecuteCnt);
	    if(longTimeExecuteCnt >= 1) {
	    	for(int i=0; i<jsonMsgItem.size(); i++) {
	    		JSONObject longTimeExecuteInfo = (JSONObject)jsonMsgItem.get(i);
	    		int exportTaskId = (int)longTimeExecuteInfo.get("id");
//	    		String projectNameRaw = (String)longTimeExecuteInfo.get("download_name");
//	    		String projectName = projectNameRaw.substring(0, projectNameRaw.indexOf("_房屋查验报告"));
	    		int status = (int)longTimeExecuteInfo.get("status");
	    		DecimalFormat decimalFormat = new DecimalFormat("0.00");
	    		float fileSizeFloat = (float) ((int)longTimeExecuteInfo.get("file_size")/1024.0/1024.0);	
	    		String fileSize = decimalFormat.format(fileSizeFloat);	    		
	    		int executionTimes = (int)longTimeExecuteInfo.get("times");
	    		int executionTime = 0;
	    		if(status >= 30) {
	    			executionTime = (int)longTimeExecuteInfo.get("update_at") - (int)longTimeExecuteInfo.get("execute_at");
	    		} else {
	    			executionTime = (int)currentLong - (int)longTimeExecuteInfo.get("execute_at");
	    		}
	    		String failReason = "";
	    		if(((String)longTimeExecuteInfo.get("desc")).length()>0) {
	    			failReason = (String)longTimeExecuteInfo.get("desc");
	    		} else {
	    			failReason = "N/A";
	    		}
	    				
	    		String longTimeExecutionItem = "导出ID：" + exportTaskId + "; " 
	    				+ "当前状态：" + status + "; " + "文件大小：" +  fileSize + "M" + "; "
	    				+ "执行时间：" + executionTime + "秒" + "; " + "执行次数：" + executionTimes + "; " + "失败原因：" + failReason + "\\n";

	    		if(!longTimeExecutionList.contains(longTimeExecutionItem)){
	    			longTimeExecutionList.add(longTimeExecutionItem);
		        	}  
	    	}
	    	
	    }
	   //System.out.println(longTimeExecutionList);
        // 发送飞书通，QA群
	    if(longTimeExecuteCnt >= 1) {
	    	URL webHookUrl1 = new URL("https://open.feishu1.cn/open-apis/bot/v2/hook/d63f293b-9438-4c0c-a103-9dec1246d7bd/");
	        connection = (HttpURLConnection)webHookUrl1.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setConnectTimeout(15000);
	        connection.setReadTimeout(15000);
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
	        String msgToSend1 = "过去一个小时有" + longTimeExecuteCnt + "个任务执行超过30秒才结束（或者还在执行中）。"  + "任务详情如下：" + "\\n"
	        + longTimeExecutionList;
	        String postMsg1 = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend1 + "\"}}";        
	        System.out.print(postMsg1);
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
		    
		
		    //发送飞书通知，大群
	        URL webHookUrl2 = new URL("https://open.feishu1.cn/open-apis/bot/v2/hook/c6a7f889-745c-413f-8ee5-cff67f5e0b4c/");
	        connection = (HttpURLConnection)webHookUrl2.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setConnectTimeout(15000);
	        connection.setReadTimeout(15000);
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
	        String msgToSend2 = "过去一个小时有" + longTimeExecuteCnt + "个任务执行超过30秒才结束（或者还在执行中）。"  + "任务详情如下：" + "\\n"
	        + longTimeExecutionList;
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

	    } else {
	    	System.out.print("Nothing happened");
	    }

        } catch (IOException e) {
            System.out.print("请求失败，错误信息："+e.getLocalizedMessage()+";"+e.getClass());
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