package com.test.OnlineMonitoring;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

public class StockCheckingHttpUrlConn {
	
    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/83f2649d-f761-4d57-81cf-be1b955c3802/";
    //private static final String urlStr = "https://open.feishu1.cn/open-apis/bot/v2/hook/2aa5f361-f8fd-4808-9865-f39da532d1f8/";


	public static void main(String[] args) throws IOException, ParseException {
		
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
        long todayEnd = zero + 3600*24 - 1;
	    long currentLong = current/1000;
        Calendar calendar = Calendar.getInstance();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format((Date)calendar.getTime());
 
        HttpURLConnection connection = null;
        URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/stock/list/");
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        String groupIds = "164409,181122,193074,183041,179295,195883,192511,187917,175693,185260,178897,185401,178258,177304,178580,189320,159909,160566,175167,177223,175656,170418,146208,175586,171319,196622,193275,181291,158645,180260,168199,194406,161423,165459,187915,180399,191263,192040,114215,190342,185468,187626,192747,176882,178325,166169,164516,187176,180967,195400,121630,159311,160848,178976,182649,182573,195962,181315,169580,187048,174592,188792,185318,177294,183929,183496,183682,173037,195058,195064,195052,138020,190214,174910,190029,194089,170128,183600,182637,192583,179110,180353,177514,172439,145683,168232,180001,164405,164752,176337,187232,189082,171627,196853,170124,170229,138403";
        int groupCnt = groupIds.split(",").length;
        // String params = "{\"group_id\":[164409, 181122, 193074, 183041, 179295, 195883, 192511, 135613],\"sign\": \"41d1c8a9dfbf41b74d74df0a9f0d5642\"}";
        String params = "{\"group_id\":["+ groupIds + "],\"sign\": \"41d1c8a9dfbf41b74d74df0a9f0d5642\"}";
        OutputStream out = connection.getOutputStream();
        out.write(params.getBytes());
        out.flush();
        out.close();
        String groupStockListRaw = "";
        int code = connection.getResponseCode();
        if (code == 200) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            	groupStockListRaw += line + "\n";
            }
            reader.close();
        }
	    connection.disconnect();
           
        HashMap<Integer,String> groupNameMapping = new HashMap<Integer,String>(); 
        HashMap<String,Integer> groupStockMapping = new HashMap<String,Integer>();
        JSONObject groupStockListObj = JSONObject.fromObject(groupStockListRaw);
	    JSONObject groupStockListData = (JSONObject) groupStockListObj.get("data");	    
	    JSONArray groupListArray = (JSONArray) groupStockListData.get("group_list");
	    JSONArray stockListArray = (JSONArray) groupStockListData.get("stock");
	    if(stockListArray.size()>0) {
	    	for(int j=0; j<stockListArray.size(); j++) {
		    	JSONObject stockListInfo = (JSONObject) stockListArray.get(j);
		    	int stockGroupId = (int) stockListInfo.get("group_id");
			    int available = (int) stockListInfo.get("available");
			    int surplus = (int) stockListInfo.get("surplus");
			    int used = (int) stockListInfo.get("used");
			    groupStockMapping.put(stockGroupId + "," + available + "," + used, surplus);
			    	    
		    }
	    }
	       
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

	       // 获取集团名字
	       HashMap<String,Integer> groupNameStockMapping = new HashMap<String,Integer>();
	       if(!groupStockMapping.isEmpty()) {
	           Iterator groupStockMappingIte = groupStockMapping.entrySet().iterator();
	           while(groupStockMappingIte.hasNext()) {
	        	   Entry groupStockMappingEntry = (Entry)groupStockMappingIte.next();
	        	   String grpInfo = (String) groupStockMappingEntry.getKey();
	        	   String groupId = grpInfo.split(",")[0];
	        	   String available = grpInfo.split(",")[1];
	        	   String used = grpInfo.split(",")[2];
				   int surplus = (int) groupStockMappingEntry.getValue();
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
	    	           String query = "text=" + groupId + "&page=1&page_size=10";
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
	    		           JSONObject groupInfo = (JSONObject) grpMsgArray.get(0);
	    		           String groupName = (String) groupInfo.get("name");
	    		           groupNameStockMapping.put(groupId + "," + groupName + "," + available + "," + used, surplus);
	    	           }
	        	   
	           }
	                  
	    
    	// 根据集团剩余量的降序排列    	
	    Map<String,Integer> groupStockMappingDesc= groupNameStockMapping.entrySet()
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

	 	System.out.println(groupStockMsg);
       
	    // 发送飞书通知
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
	            String msgToSend = "截至【" + today + "】，业主验房总用量超过10的集团有" + groupCnt + "家，明细如下：" + "\\n" + groupStockMsg;
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
	}