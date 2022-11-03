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


public class HouseqmFailedMsg {
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
        calendar2.add(calendar2.MINUTE, -1);
        Date oneMinAgo = calendar2.getTime();
        long oneMinAgoLong = oneMinAgo.getTime()/1000;
        
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(calendar3.MINUTE, -10);
        Date tenMinAgo = calendar3.getTime();
        long tenMinAgoLong = tenMinAgo.getTime()/1000;
        


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
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=84&export_type=85&status=10&status=20&status=25&status=-9999&start_time=" + tenMinAgoLong + 
                "&end_time=" + oneMinAgoLong;
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
	    //System.out.println(msg);
	    
	    ArrayList<String> errorList = new ArrayList<String>();
        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
	    JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	
	    JSONArray jsonMsgItem = (JSONArray) jsonMsgData.get("items");
	    int failCnt = (int) jsonMsgData.get("count");
	    // System.out.println(failCnt);
	    if(failCnt >= 2) {
	    	for(int i=0; i<jsonMsgItem.size(); i++) {
	    		JSONObject failExportMsg = (JSONObject)jsonMsgItem.get(i);
	    		String failReason = (String)failExportMsg.get("error_msg");
	    		//System.out.println(failReason);
	    		if(!errorList.contains(failReason)){
	    			errorList.add(failReason);
		        	}  
	    	}
	    	
	    }
	    // System.out.println(errorList);

        // 发送飞书通，QA群
	    if(failCnt >= 2) {
	    	URL webHookUrl1 = new URL("https://open.feishu1.cn/open-apis/bot/v2/hook/c48f65b2-7000-49e9-93aa-3ccd128306fc");
	        connection = (HttpURLConnection)webHookUrl1.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setConnectTimeout(15000);
	        connection.setReadTimeout(15000);
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 声明格式是json
	        String msgToSend1 = "业主验房有两个或更多任务在队列中或者导出失败，原因: " + errorList;
	        String postMsg1 = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend1 + "\"}}";        
	        System.out.println(postMsg1);
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
