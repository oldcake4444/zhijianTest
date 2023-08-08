package com.test.OnlineMonitoring;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Iterator;
import java.util.Map.Entry;;

public class IncorrectStockChecking {
	
    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/83f2649d-f761-4d57-81cf-be1b955c3802/";
//    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/d63f293b-9438-4c0c-a103-9dec1246d7bd/;https://open.feishu1.cn/open-apis/bot/v2/hook/2aa5f361-f8fd-4808-9865-f39da532d1f8/";


	public static void main(String[] args) throws IOException, ParseException {
		
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
        long todayEnd = zero + 3600*24 - 1;
	    long currentLong = current/1000;
 
        HttpURLConnection connection = null;
        try {
        URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/stock/mistake_list/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        String params = "{\"sign\": \"41d1c8a9dfbf41b74d74df0a9f0d5642\"}";
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
	    
	    HashMap<Integer,Integer> groupAvailable = new HashMap<Integer,Integer>();
	    HashMap<Integer,Integer> groupUsed = new HashMap<Integer,Integer>();
	    HashMap<Integer,Integer> groupSurplus = new HashMap<Integer,Integer>();
	    HashMap<Integer,Integer> mistakeGroupTotalAmount = new HashMap<Integer,Integer>();
	    HashMap<Integer,Integer> mistakeGroupUsedTotal = new HashMap<Integer,Integer>();
	    HashMap<Integer,Integer> groupAvailableTotalAmount = new HashMap<Integer,Integer>();
	    HashMap<Integer,Integer> groupUsedUsedTotal = new HashMap<Integer,Integer>();


        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
        JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	    
        JSONArray jsonStockArray = (JSONArray) jsonMsgData.get("stock");
        JSONArray jsonMistakeStockArray = (JSONArray) jsonMsgData.get("stock_mistake");
        for(int i=0; i<jsonStockArray.size(); i++) {
	    	JSONObject msgStockObject = (JSONObject) jsonStockArray.get(i);
	    	int groupId = (int) msgStockObject.get("group_id");
	    	int available = (int) msgStockObject.get("available");
	    	int used = (int) msgStockObject.get("used");
	    	int surplus = (int) msgStockObject.get("surplus");
	    	groupAvailable.put(groupId, available);
	    	groupUsed.put(groupId, used);
	    	groupSurplus.put(groupId, surplus);
        }
    	for(int j=0; j<jsonStockArray.size(); j++) {
    		JSONObject msgMistakeStockObject = (JSONObject) jsonMistakeStockArray.get(j);
	    	int mistakeGroupId = (int) msgMistakeStockObject.get("group_id");
	    	int mistakeTotalAmount = (int) msgMistakeStockObject.get("total_amount");
	    	int mistakeUsedTotal = (int) msgMistakeStockObject.get("used_total");
	    	mistakeGroupTotalAmount.put(mistakeGroupId, mistakeTotalAmount);
	    	mistakeGroupUsedTotal.put(mistakeGroupId, mistakeUsedTotal);			
    	}
    	
 	   Iterator groupAvailableIte = groupAvailable.entrySet().iterator();	   
 	   while(groupAvailableIte.hasNext()) {
 		  Entry groupAvailableEntry = (Entry)groupAvailableIte.next();
 		  int groupId = (int) groupAvailableEntry.getKey();
 		  int amountDiff = (int) groupAvailableEntry.getValue() - mistakeGroupTotalAmount.get(groupId);
 		  if(amountDiff != 0) {
 			 groupAvailableTotalAmount.put(groupId, Math.abs(amountDiff));
 		  }
 	   }
 	   
 	   Iterator groupUsedIte = groupUsed.entrySet().iterator();	   
 	   while(groupUsedIte.hasNext()) {
 		  Entry groupUsedEntry = (Entry)groupUsedIte.next();
 		  int groupId = (int) groupUsedEntry.getKey();
 		  int usedDiff = (int) groupUsedEntry.getValue() - mistakeGroupUsedTotal.get(groupId);
 		  if(usedDiff != 0) {
 			 groupUsedUsedTotal.put(groupId, Math.abs(usedDiff));
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
       buffer.append("12345678");
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
       
       HashMap<String,Integer> groupNameAvailableTotalAmount = new HashMap<String,Integer>();
	   HashMap<String,Integer> groupNameUsedUsedTotal = new HashMap<String,Integer>();
       
	   String amountMsg = "";
       if(!groupAvailableTotalAmount.isEmpty()) {
    	   Iterator groupAvailableTotalAmountIte = groupAvailableTotalAmount.entrySet().iterator();
    	   while(groupAvailableTotalAmountIte.hasNext()) {
        	   Entry groupAvailableTotalAmountEntry = (Entry)groupAvailableTotalAmountIte.next();
        	   int grpId = (int) groupAvailableTotalAmountEntry.getKey();
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
    	       grpQueryOut.flush();
    	       grpQueryOut.close();
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
    	    if(grpMsgArray.size()>0) {
    	    	JSONObject grpInfo = (JSONObject) grpMsgArray.get(0);
    		    String groupName = (String) grpInfo.get("name");
    		    groupNameAvailableTotalAmount.put(groupName+"("+grpId+")", (int)groupAvailableTotalAmountEntry.getValue());
    		    }
    	   }
       }
       Iterator groupNameAvailableTotalAmountIte = groupNameAvailableTotalAmount.entrySet().iterator();
       if(groupNameAvailableTotalAmount.size()>0) {
   	    do {
	    	Entry groupNameAvailableTotalAmountEntry = (Entry)groupNameAvailableTotalAmountIte.next();
	    	amountMsg = amountMsg + "集团" + groupNameAvailableTotalAmountEntry.getKey() + "可用量出错，差异是："
	    			 + groupNameAvailableTotalAmountEntry.getValue() + "\\n";
	    	} while(groupNameAvailableTotalAmountIte.hasNext());    
       }   
       
       String usedMsg = "";
       if(!groupUsedUsedTotal.isEmpty()) {
    	   Iterator groupUsedUsedTotalIte = groupUsedUsedTotal.entrySet().iterator();
    	   while(groupUsedUsedTotalIte.hasNext()) {
        	   Entry groupUsedUsedTotalEntry = (Entry)groupUsedUsedTotalIte.next();
        	   int grpId = (int) groupUsedUsedTotalEntry.getKey();
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
    	    if(grpMsgArray.size()>0) {
    	    	JSONObject grpInfo = (JSONObject) grpMsgArray.get(0);
    		    String groupName = (String) grpInfo.get("name");
    		    groupNameUsedUsedTotal.put(groupName+"("+grpId+")", (int)groupUsedUsedTotalEntry.getValue());
    		    }
    	   }
    	   
       }
       Iterator groupNameUsedUsedTotalIte = groupNameUsedUsedTotal.entrySet().iterator();
       if(groupNameUsedUsedTotal.size()>0) {
   	    do {
	    	Entry groupNameUsedUsedTotalEntry = (Entry)groupNameUsedUsedTotalIte.next();
	    	usedMsg = usedMsg + "集团" + groupNameUsedUsedTotalEntry.getKey() + "使用量出错，差异是："
	    			 + groupNameUsedUsedTotalEntry.getValue() + "\\n";
	    	} while(groupNameUsedUsedTotalIte.hasNext());	   
       }
	    
	    String sendMsg = amountMsg + usedMsg;
       
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
            String postMsg = "";
            if(amountMsg != "" && usedMsg != "") {
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + sendMsg + "\"}}";            
            } if(amountMsg != "" && usedMsg == "") {
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + amountMsg + "\"}}";            
            } if(amountMsg == "" && usedMsg != "") {
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + usedMsg + "\"}}";            
            }
            OutputStream feiShuOut = connection.getOutputStream();
            if(postMsg != "") {
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
