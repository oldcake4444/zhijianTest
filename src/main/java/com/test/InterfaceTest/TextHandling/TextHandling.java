package com.test.InterfaceTest.TextHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;
import org.junit.Test;
import com.test.Util.ApiShareSteps;
import com.test.Util.FileUtil;

import net.sf.json.JSONObject;




public class TextHandling {
	
	static Logger log = Logger.getLogger("TextHandling.class");
	
	public static HashMap<String, Integer> wordCount(String fileName) {
		String rawText = FileUtil.readFile(fileName).trim();
		String rawTextReplace = rawText.replace("\n", " ").replace("\r", " ").replace("  ", " ");
		String[] wordList = rawTextReplace.split(" ");
		HashMap<String, Integer> wordMapping = new HashMap<String, Integer>();
		int count = 0;
		List<String> wordArray = new ArrayList<String>();
		for (String word : wordList) {
			if(!wordArray.contains(word)){
				wordArray.add(word);
				wordMapping.put(word, 0);
			}
		} 
		for (String word : wordList) {
			for (String key : wordMapping.keySet()) {
				if (word.equals(key)) {
					count = wordMapping.get(key) + 1;
					wordMapping.put(key, count);
				}
			}
		}	
		return wordMapping;
	}
	
	public static HashMap<String, Integer> charCount(String fileName) {
		String rawText = FileUtil.readFile(fileName).trim();
		String rawTextReplace = rawText.replace("\n", "").replace("\r", "");
		String[] charList = new String[rawTextReplace.length()];
		List<String> charArray = new ArrayList<String>();
		HashMap<String, Integer> charMapping = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < rawTextReplace.length(); i++) {
			String singleChar = rawTextReplace.substring(i, i+1);
			charList[i] = singleChar;
		}
		for (String rawChar : charList) {
			if(!charArray.contains(rawChar)) {
				charArray.add(rawChar);
				charMapping.put(rawChar, 0);
			}
		}
		for (String rawChar : charList) {
			for (String key : charMapping.keySet()) {
				if (rawChar.equals(key)) {
					count = charMapping.get(key) + 1;
					charMapping.put(key, count);
				}
			}
		}				
		return charMapping;
	}
	
	public static String stringReverse(String fileName) {
		String rawStr = FileUtil.readFile(fileName).trim();
		String newStr = "";
		for (int i = rawStr.length() - 1; i >= 0; i--) {
			String singleChar = rawStr.substring(i, i+1);
			newStr = newStr + singleChar;
		}
		
		return newStr;
		
		
	}
	
	@Test
	public void dateFormatTest() throws IOException, ParseException {
		long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        long yesterdayNow=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
        long yesterdayZero = zero - 3600 * 24;
        long yesterdayEnd = zero - 1;
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        Date oneHourAgo = calendar.getTime();
        System.out.print(oneHourAgo + "\n");        
        long oneHourAgoLong = oneHourAgo.getTime()/1000;
        System.out.print(oneHourAgoLong + "\n");
        
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(calendar1.MINUTE, -30);
    	Date halfAnHourAgo = calendar1.getTime();
    	System.out.print(halfAnHourAgo + "\n");
        long halfAnHourAgoLong = halfAnHourAgo.getTime()/1000;
        System.out.print(halfAnHourAgoLong + "\n");
        
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(calendar2.MINUTE, -1);
        Date oneMinAgo = calendar2.getTime();
        long oneMinAgoLong = oneMinAgo.getTime()/1000;
        System.out.print(oneMinAgoLong + "\n");
        
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(calendar3.DAY_OF_MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String yesterday = df.format((Date) calendar3.getTime());
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yesterday2 = df1.format((Date) calendar3.getTime());
        long yesterday2Long = df1.parse("2022-08-31 00:00:00").getTime();
        long yesterdayZero2 = (yesterday2Long/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000 - 3600*24;
        long yesterdayEnd2 = (yesterday2Long/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000 - 1;
        System.out.print(yesterdayZero2 + "\n");
        System.out.print(yesterdayEnd2 + "\n");
        System.out.print(zero + "\n");
        System.out.print(current + "\n");
        System.out.print(current/1000 + "\n");

        
        HttpURLConnection connection = null;
        try {
        URL url = new URL("https://zj.buildingqm.com/houseqm/v3/papi/back_door/export_record/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=84&export_type=85&status=30&start_time=" + yesterdayZero + 
        		"&end_time=" + yesterdayEnd
        		+ "&like_params=true";
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
        // System.out.print(msg.indexOf("\"count\":") + keyWord1.length());
        // System.out.print(msg.indexOf(",\"items\":["));
        String exportCnt = msg.substring(msg.indexOf("\"count\":") + keyWord1.length(), msg.indexOf(",\"items\":["));

        System.out.print(yesterday + "导出PDF:" + exportCnt + "\n");
        
        
//        String postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":" + msgToSend + "\"}}";
//        System.out.print(postMsg);
        
        
        
        URL webHookUrl = new URL("https://open.feishu2.cn/open-apis/bot/v2/hook/68350a1c-3bfe-4f3c-95c1-acbabf4ba8e4/");
        connection = (HttpURLConnection)webHookUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        String msgToSend = yesterday + "导出PDF:" + exportCnt;
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
              

        
//        JSONObject responseJson = JSONObject.fromObject(msg); 
//	    JSONObject responseData = (JSONObject) responseJson.get("data");
////	    JSONObject responseDetails = (JSONObject) responseData.get("detail");
//	    String exportCnt = responseData.getString("count");
//	    System.out.print(exportCnt);
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
	
	
	

	public void wordCountTest() {
		HashMap<String, Integer> wordCnt = wordCount("src/main/resources/TextPractice/WordCountText.txt");
		for (String key : wordCnt.keySet()) {
			String wordResult = key + " " + wordCnt.get(key);
			log.info(wordResult);
		}
		
		log.info("**************************************************");
		
		HashMap<String, Integer> charCnt = charCount("src/main/resources/TextPractice/CharCountText.txt");
		for (String key : charCnt.keySet()) {
			String charResult = key + " " + charCnt.get(key);
			log.info(charResult);
		}
		
		log.info("**************************************************");
		String newStr = stringReverse("src/main/resources/TextPractice/WordSequence.txt");
		log.info(newStr);
	}

}
