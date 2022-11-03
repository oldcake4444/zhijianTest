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


public class CountHouseqmExportFiles {
	
	 private static final int threadNumber = 10;
	 
	 private static final int perThreadCreatSnpNumber = 10;
	 
	 private static final String urlStr = "https://open.feishu1.cn/open-apis/bot/v2/hook/e7dcf547-85ca-46ca-bb3f-e6bb7e519549/;https://open.feishu1.cn/open-apis/bot/v2/hook/c6a7f889-745c-413f-8ee5-cff67f5e0b4c/";
     
	 public static void main(String[] args) {
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
        URL url = new URL("https://zj.buildingqm.com/houseqm/v3/papi/back_door/export_record/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=84&export_type=85&status=30&start_time=" + zero + 
                "&end_time=" + currentLong 
                + "&like_params=true";
	    //System.out.print(params);
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

        // 发送飞书通
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
            String msgToSend = today + "导出PDF: " + exportCnt;
            String postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}";        
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
