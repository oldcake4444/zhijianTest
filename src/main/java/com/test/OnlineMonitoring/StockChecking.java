package com.test.OnlineMonitoring;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.jayway.restassured.response.Response;
import com.test.Util.RestassureApiCalling;;

public class StockChecking {
	
    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/83f2649d-f761-4d57-81cf-be1b955c3802/";
//    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/d63f293b-9438-4c0c-a103-9dec1246d7bd/;https://open.feishu1.cn/open-apis/bot/v2/hook/2aa5f361-f8fd-4808-9865-f39da532d1f8/";


	public static void main(String[] args) throws IOException, ParseException {
		
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
        long todayEnd = zero + 3600*24 - 1;
	    long currentLong = current/1000;
        Calendar calendar = Calendar.getInstance();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format((Date)calendar.getTime());
 
		Map<String,String> setParams = new HashMap<>();
		setParams.put("username", "zhijian");
		setParams.put("password", "213213as");
		setParams.put("remember_me", "0");
		Response webResponse = RestassureApiCalling.postMethodWithoutCookies("https://zj.buildingqm.com", "/crm/admin/login/?_ct=json", setParams);
		Map<String, String> curCookies = webResponse.cookies();
        // String groupStockListRaw = RestassureApiCalling.getMethod("https://zj.buildingqm.com", "/crm/owner_inspection/group_stock_list/?_ct=json&limit=9999&page=1&search=&no_exists=false");
        String groupStockListRaw = RestassureApiCalling.getMethodWithCookies("https://zj.buildingqm.com", "/crm/owner_inspection/group_stock_list/?_ct=json&limit=9999&page=1&search=&no_exists=false", curCookies);
	    
        HashMap<Integer,String> groupNameMapping = new HashMap<Integer,String>(); 
        HashMap<String,Integer> groupStockMapping = new HashMap<String,Integer>();
        JSONObject groupStockListObj = JSONObject.fromObject(groupStockListRaw);
	    JSONObject groupStockListData = (JSONObject) groupStockListObj.get("data");	    
	    JSONArray groupListArray = (JSONArray) groupStockListData.get("group_list");
	    if(groupListArray.size()>0) {
	    	for(int i=0; i<groupListArray.size(); i++) {
		    	JSONObject groupListInfo = (JSONObject) groupListArray.get(i);
		    	int groupId = (int) groupListInfo.get("group_id");
			    String groupName = (String) groupListInfo.get("group_name");
			    groupNameMapping.put(groupId, groupName);   		
	    	}
		    }
	    JSONArray stockListArray = (JSONArray) groupStockListData.get("stock");
	    if(stockListArray.size()>0) {
	    	for(int j=0; j<stockListArray.size(); j++) {
		    	JSONObject stockListInfo = (JSONObject) stockListArray.get(j);
		    	int stockGroupId = (int) stockListInfo.get("group_id");
			    int available = (int) stockListInfo.get("available");
			    int surplus = (int) stockListInfo.get("surplus");
			    int used = (int) stockListInfo.get("used");
			    	    
			 	Iterator groupNameMappingIte = groupNameMapping.entrySet().iterator();	   
			 	while(groupNameMappingIte.hasNext()) {
			 		Entry groupNameMappingEntry = (Entry)groupNameMappingIte.next();
			 		int groupId = (int) groupNameMappingEntry.getKey();
			 		String groupName = (String) groupNameMappingEntry.getValue();
			 		if(stockGroupId == groupId) {
			 			groupStockMapping.put(groupId + "," + groupName + "," + available + "," + used, surplus);
			 		}
			 		
			 		}
			 	}
		    }
	   
    	// 根据集团剩余量的降序排列    	
	    Map<String,Integer> groupStockMappingDesc= groupStockMapping.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
	    
	    String groupStockMsg = "";
	 	Iterator groupStockMappingDescIte = groupStockMappingDesc.entrySet().iterator();	   
	 	while(groupStockMappingDescIte.hasNext()) {
	 		Entry groupStockMappingDescEntry = (Entry)groupStockMappingDescIte.next();
	 		String groupId = ((String) groupStockMappingDescEntry.getKey()).split(",")[0];
	 		String groupName = ((String) groupStockMappingDescEntry.getKey()).split(",")[1];
	 		String available = ((String) groupStockMappingDescEntry.getKey()).split(",")[2];
	 		String used = ((String) groupStockMappingDescEntry.getKey()).split(",")[3];
	 		int surplus = (int) groupStockMappingDescEntry.getValue();
	
	 		
	 		groupStockMsg = groupStockMsg + groupName + "（" + groupId + "）"
	 				+ "总用量：" + available + "，"
	 				+ "已使用：" + used + "，"
	 				+ "剩余用量：" + surplus + "\\n";
	 	}
	 	int groupCount = groupStockMappingDesc.size();
	 	System.out.println(groupStockMsg);
       
	    // 发送飞书通知
	 	HttpURLConnection connection = null;
	 	try {	 	
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
	            String msgToSend = "截至" + today + "，生产环境一共" + groupCount + "个集团开通了业主验房，用量明细如下" + "\\n" + groupStockMsg;
	            String postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}"; 
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
	 		
	 	}    catch (IOException e) {
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
