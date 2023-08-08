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


public class OIExportIssueRunTimesCheck {
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
        URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/export/list/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&create_at_start=" 
        + oneHourAgoLong + "&create_at_end=" + threeMinAgoLong
        + "&times_gte=2";
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
	    ArrayList<String> repeatExecutionList = new ArrayList<String>();
        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
	    JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	
	    JSONArray jsonMsgItem = (JSONArray) jsonMsgData.get("report_export");
	    int repeatExecuteCnt = (int) jsonMsgData.get("count");
	    // System.out.println(longTimeExecuteCnt);
	    if(repeatExecuteCnt >= 1) {
	    	for(int i=0; i<jsonMsgItem.size(); i++) {
	    		JSONObject repeatExecuteInfo = (JSONObject)jsonMsgItem.get(i);
	    		int exportTaskId = (int)repeatExecuteInfo.get("id");
//	    		String projectNameRaw = (String)repeatExecuteInfo.get("download_name");
//	    		String projectName = projectNameRaw.substring(0, projectNameRaw.indexOf("_房屋查验报告"));
	    		int status = (int)repeatExecuteInfo.get("status");
	    		DecimalFormat decimalFormat = new DecimalFormat("0.00");
	    		float fileSizeFloat = (float) ((int)repeatExecuteInfo.get("file_size")/1024.0/1024.0);	
	    		String fileSize = decimalFormat.format(fileSizeFloat);	    		
	    		int executionTimes = (int)repeatExecuteInfo.get("times");
	    		int executionTime = 0;
	    		if(status >= 30) {
	    			executionTime = (int)repeatExecuteInfo.get("update_at") - (int)repeatExecuteInfo.get("execute_at");
	    		} else {
	    			executionTime = (int)currentLong - (int)repeatExecuteInfo.get("execute_at");
	    		}
	    		String failReason = "";
	    		if(((String)repeatExecuteInfo.get("desc")).length()>0) {
	    			failReason = (String)repeatExecuteInfo.get("desc");
	    		} else {
	    			failReason = "N/A";
	    		}
	    				
	    		String repeatExecutionItem = "导出ID：" + exportTaskId + "; "
	    				+ "执行次数：" + executionTimes + "; "
	    				+ "当前状态：" + status + "; " + "文件大小：" +  fileSize + "M" + "; "
	    				+ "执行时间：" + executionTime + "秒" + "; " + "失败原因：" + failReason + "\\n";

	    		if(!repeatExecutionList.contains(repeatExecutionItem)){
	    			repeatExecutionList.add(repeatExecutionItem);
		        	}  
	    	}
	    	
	    }
	   //System.out.println(longTimeExecutionList);
        // 发送飞书通，QA群
	    if(repeatExecuteCnt >= 1) {
	    	URL webHookUrl1 = new URL("https://open.feishu.cn/open-apis/bot/v2/hook/83f2649d-f761-4d57-81cf-be1b955c3802/");
	        connection = (HttpURLConnection)webHookUrl1.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setConnectTimeout(15000);
	        connection.setReadTimeout(15000);
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
	        String msgToSend1 = "过去一个小时有" + repeatExecuteCnt + "个任务执行次数超过1次。"  + "任务详情如下：" + "\\n"
	        + repeatExecutionList;
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