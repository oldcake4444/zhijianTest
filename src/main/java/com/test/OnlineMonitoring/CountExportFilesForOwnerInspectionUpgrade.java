package com.test.OnlineMonitoring;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

public class CountExportFilesForOwnerInspectionUpgrade {
	
    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/83f2649d-f761-4d57-81cf-be1b955c3802/";
//    private static final String urlStr = "https://open.feishu.cn/open-apis/bot/v2/hook/d63f293b-9438-4c0c-a103-9dec1246d7bd/;https://open.feishu1.cn/open-apis/bot/v2/hook/2aa5f361-f8fd-4808-9865-f39da532d1f8/";


	public static void main(String[] args) throws IOException, ParseException {
//		运行过程输出到文件
//        PrintStream ps = new PrintStream("C:\\Users\\oldcake\\Desktop\\log.txt");
//        System.setOut(ps);		
		// 每天23点59分跑，跑今天的数据
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
        long todayEnd = zero + 3600*24 - 1;
	    long currentLong = current/1000;
        long yesterdayZero = zero - 3600 * 24;
        long yesterdayEnd = zero - 1;
        Calendar calendar = Calendar.getInstance();;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format((Date)calendar.getTime());
        
        calendar.add(Calendar.DATE, -1);       
        String yesterday = df.format((Date)calendar.getTime());
               
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdformat.parse("2022-09-14 00:00:00");       
        long dayOneZero = date.getTime()/1000;
        
        // 首先校验历史数据是否正常
        ArrayList<Integer> taskListHistArray = new ArrayList<Integer>();
        String pathStr = "C:\\Users\\oldcake\\Desktop\\定时运行脚本\\TaskHistory.txt";
        Path path = Paths.get(pathStr);
        File fileRead = new File (pathStr);
        StringBuilder result = new StringBuilder();
        try{
            InputStreamReader isr = new InputStreamReader(new FileInputStream(fileRead), "UTF-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }       
        
        
        if(result.toString().split(";")[0].toString().trim().equals(yesterday)) {
        	// 历史数据正常的话把历史数据写入taskListHistArray
        	System.out.println("历史数据正常");
            String[] array = result.toString().split(";")[1].split(",");
            for(int h = 0; h < array.length; h++) {
                int arrayTaskId = Integer.valueOf(array[h]);
                if(arrayTaskId != 146208) {
                	taskListHistArray.add(arrayTaskId);
                }        
            }
        } else {
        	System.out.println("历史数据不正常，正在重新生成");
        	// 历史数据不正常则重跑历史数据
            // 先查除昨天以外的历史数据
            // 如果时间跨度在3个月内，用一次查询
            if(yesterdayZero-dayOneZero <= 7776000) {
                String msgHist = "";
                HttpURLConnection connectionHist = null;
                try {
                URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/report_export/list/");
                connectionHist = (HttpURLConnection)url.openConnection();
                connectionHist.setRequestMethod("POST");
                connectionHist.setConnectTimeout(15000);
                connectionHist.setReadTimeout(15000);;
                connectionHist.setDoOutput(true);
                connectionHist.setDoInput(true);
                connectionHist.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=" + dayOneZero + 
                        "&create_at_end=" + zero;       
                // String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=1673452800&create_at_end=1673539200";
                // System.out.print(params + "\n");
                OutputStream out = connectionHist.getOutputStream();
                out.write(params.getBytes());
                out.flush();
                out.close();
                int code = connectionHist.getResponseCode();
                if (code == 200) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connectionHist.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                    	msgHist += line + "\n";
                    }
                    reader.close();
                }
                connectionHist.disconnect();
                } catch (IOException e) {
                    System.out.print("转发出错，错误信息："+e.getLocalizedMessage()+";"+e.getClass());
                }finally {
                    // 5. 断开连接
                    if (null != connectionHist){
                        try {
                        	connectionHist.disconnect();
                        }catch (Exception e){
                            System.out.print("httpURLConnection 流关闭异常："+ e.getLocalizedMessage());
                        }
                    }
                }

                JSONObject jsonMsgJsonHist = JSONObject.fromObject(msgHist);
                JSONObject jsonMsgDataHist = (JSONObject) jsonMsgJsonHist.get("data");	    
                JSONArray rptExpArrayHist = (JSONArray) jsonMsgDataHist.get("report_export");
                for(int i=0; i<rptExpArrayHist.size(); i++) {
                	JSONObject rptExpInfoJsonHist = (JSONObject) rptExpArrayHist.get(i);
        	    	int groupIdHist = (int) rptExpInfoJsonHist.get("group_id");
        	    	int taskIdHist = (int) rptExpInfoJsonHist.get("task_id");
        	    	if(groupIdHist != 146208) { // 排除测试集团
        	    		if(!taskListHistArray.contains(taskIdHist)) {
        	    			taskListHistArray.add(taskIdHist);
        	    		}
        	    	}
                	
                }
            	
            } else {
                // 如果时间跨度在3个月上，多次查询，因为一次查询无法返回所有数据。每次查3个月的数据
            	long i = dayOneZero;
            	while(i <= yesterdayZero) {
                    String msgElse = "";
            		HttpURLConnection connectionElse = null;
                    try {
                    URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/report_export/list/");
                    connectionElse = (HttpURLConnection)url.openConnection();
                    connectionElse.setRequestMethod("POST");
                    connectionElse.setConnectTimeout(15000);
                    connectionElse.setReadTimeout(15000);;
                    connectionElse.setDoOutput(true);
                    connectionElse.setDoInput(true);
                    connectionElse.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=" + i + 
                            "&create_at_end=" + (i + 7776000);       
                    // String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=1673452800&create_at_end=1673539200";
                    System.out.print(params + "\n");
                    OutputStream out = connectionElse.getOutputStream();
                    out.write(params.getBytes());
                    out.flush();
                    out.close();

                    int code = connectionElse.getResponseCode();
                    if (code == 200) {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connectionElse.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                        	msgElse += line + "\n";
                        }
                        reader.close();
                    }
                    connectionElse.disconnect();
                    } catch (IOException e) {
                        System.out.print("转发出错，错误信息："+e.getLocalizedMessage()+";"+e.getClass());
                    }finally {
                        // 5. 断开连接
                        if (null != connectionElse){
                            try {
                            	connectionElse.disconnect();
                            }catch (Exception e){
                                System.out.print("httpURLConnection 流关闭异常："+ e.getLocalizedMessage());
                            }
                        }
                    }
                    JSONObject jsonMsgJsonElse = JSONObject.fromObject(msgElse);
                    JSONObject jsonMsgDataElse = (JSONObject) jsonMsgJsonElse.get("data");	    
                    JSONArray rptExpArrayElse = (JSONArray) jsonMsgDataElse.get("report_export");
                    for(int j=0; j<rptExpArrayElse.size(); j++) {
                    	JSONObject rptExpInfoJsonElse = (JSONObject) rptExpArrayElse.get(j);
            	    	int groupIdElse = (int) rptExpInfoJsonElse.get("group_id");
            	    	int taskIdElse = (int) rptExpInfoJsonElse.get("task_id");
            	    	if(groupIdElse != 146208) { // 排除测试集团
            	    		if(!taskListHistArray.contains(taskIdElse)) {
            	    			taskListHistArray.add(taskIdElse);
            	    		}
            	    	}
                    	
                    }             
                    i = i + 7776000;
                    if(i+7776000 > yesterdayZero) {
                    	// 最后一次的结束时间是昨天的零点
                        String msgLast = "";
                		HttpURLConnection connectionLast = null;
                        try {
                        URL url = new URL("https://zj.buildingqm.com/app_owner_inspection/v1/gapi/back_door/report_export/list/");
                        connectionLast = (HttpURLConnection)url.openConnection();
                        connectionLast.setRequestMethod("POST");
                        connectionLast.setConnectTimeout(15000);
                        connectionLast.setReadTimeout(15000);;
                        connectionLast.setDoOutput(true);
                        connectionLast.setDoInput(true);
                        connectionLast.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=" + i + 
                                "&create_at_end=" + zero;       
                        // String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=1673452800&create_at_end=1673539200";
                        System.out.print(params + "\n");
                        OutputStream out = connectionLast.getOutputStream();
                        out.write(params.getBytes());
                        out.flush();
                        out.close();
                        int code = connectionLast.getResponseCode();
                        if (code == 200) {
                            BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(connectionLast.getInputStream()));
                            String line;
                            while ((line = reader.readLine()) != null) {
                            	msgLast += line + "\n";
                            }
                            reader.close();
                        }
                        connectionLast.disconnect();
                        } catch (IOException e) {
                            System.out.print("转发出错，错误信息："+e.getLocalizedMessage()+";"+e.getClass());
                        }finally {
                            // 5. 断开连接
                            if (null != connectionLast){
                                try {
                                	connectionLast.disconnect();
                                }catch (Exception e){
                                    System.out.print("httpURLConnection 流关闭异常："+ e.getLocalizedMessage());
                                }
                            }
                        }
                        JSONObject jsonMsgJsonLast = JSONObject.fromObject(msgLast);
                        JSONObject jsonMsgDataLast = (JSONObject) jsonMsgJsonLast.get("data");	    
                        JSONArray rptExpArrayLast = (JSONArray) jsonMsgDataLast.get("report_export");
                        for(int k=0; k<rptExpArrayLast.size(); k++) {
                        	JSONObject rptExpInfoJsonLast = (JSONObject) rptExpArrayLast.get(k);
                	    	int groupIdLast = (int) rptExpInfoJsonLast.get("group_id");
                	    	int taskIdLast = (int) rptExpInfoJsonLast.get("task_id");
                	    	if(groupIdLast != 146208) { // 排除测试集团
                	    		if(!taskListHistArray.contains(taskIdLast)) {
                	    			taskListHistArray.add(taskIdLast);
                	    		}
                	    	}
                        	
                        } 
                    	break;
                    }
            		
            	}      	

            }
            
          //重新写入历史数据
          File fileWrite = new File(pathStr);
          if(!fileWrite.exists() && !fileWrite.isDirectory()) {
              System.out.println("文件不存在");
              fileWrite.mkdirs();
              fileWrite.createNewFile();
          }
          Writer writerOut = new FileWriter(fileWrite);
          // BufferedWriter bw = new BufferedWriter(writerOut);
          BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
          
          bw.write(yesterday);
          bw.write(";");
          bw.flush();             
          for(int task: taskListHistArray) {
              bw.write(String.valueOf(task));
              bw.write(",");
              bw.flush();
          }
          bw.close();
          System.out.println("历史数据重新写入成功");
            
            
//          ps.close(); 	
        }
             
        // 查询当天的导出数据
        System.out.println("查询当天数据");
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
                "&create_at_end=" + todayEnd;       
//        String params = "sign=41d1c8a9dfbf41b74d74df0a9f0d5642&export_type=[5,10]&status=30&create_at_start=1674316800&create_at_end=1674403200";
        System.out.print(params + "\n");
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
//        String keyWord1 = "\"count\":";        
//        String exportCnt = msg.substring(msg.indexOf("\"count\":") + keyWord1.length(), msg.indexOf("}}"));
        //System.out.println(exportCnt);
        
        // 集团id列表、任务id列表
        ArrayList<Integer> groupList = new ArrayList<Integer>();
        ArrayList<Integer> taskList = new ArrayList<Integer>();
        JSONObject jsonMsgJson = JSONObject.fromObject(msg);
        JSONObject jsonMsgData = (JSONObject) jsonMsgJson.get("data");	    
        JSONArray rptExpArray = (JSONArray) jsonMsgData.get("report_export");
        HashMap<Integer,Integer> groupMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> groupListMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> taskMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> taskGroupMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> groupTaskCntMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> taskGroupMapNew = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> groupTaskCntMapNew = new HashMap<Integer,Integer>();
        for(int i=0; i<rptExpArray.size(); i++) {
	    	JSONObject rptExpInfoJson = (JSONObject) rptExpArray.get(i);
	    	int groupId = (int) rptExpInfoJson.get("group_id");
	    	int taskId = (int) rptExpInfoJson.get("task_id");
	    	if(groupId != 146208) { // 排除测试集团
	    		if(!groupList.contains(groupId)){
		        	groupList.add(groupId);
		        	}
	    		if(!taskList.contains(taskId)) {
	    			taskList.add(taskId);
	    		}
		    	if(!groupMap.containsKey(groupId)) {
		    		groupMap.put(groupId, 0);
		    	}	    	
		    	if(groupMap.containsKey(groupId)) {
		    		groupMap.put(groupId, groupMap.get(groupId) + 1);
		    	}
		    	if(!groupListMap.containsKey(groupId)) {
		    		groupListMap.put(groupId, 0);
		    	}	 
		    	if(!taskMap.containsKey(taskId)) {
		    		taskMap.put(taskId, 0);
		    	}	    	
		    	if(taskMap.containsKey(taskId)) {
		    		taskMap.put(taskId, taskMap.get(taskId) + 1);
		    	}
		    	if(!taskListHistArray.contains(taskId)) {
		    		taskListHistArray.add(taskId);
		    		taskGroupMapNew.put(taskId, groupId);
		    	}
		    	taskGroupMap.put(taskId, groupId);
		    	
	    	}
	    }
                
        // 集团以及其对应的任务数
        Iterator<Map.Entry<Integer, Integer>> groupListMapIterator = groupListMap.entrySet().iterator();
    	while(groupListMapIterator.hasNext()) {
    	    Entry<Integer, Integer> groupListEntry = groupListMapIterator.next();  
    		int grpId = groupListEntry.getKey();
            Iterator<Map.Entry<Integer, Integer>> taskGroupMapIterator = taskGroupMap.entrySet().iterator();
            while(taskGroupMapIterator.hasNext()) {
        	    Entry<Integer, Integer> taskGroupEntry = taskGroupMapIterator.next();
        	    int groupgrpId = taskGroupEntry.getValue();
        	    if(grpId == groupgrpId) {
    		    	if(!groupTaskCntMap.containsKey(grpId)) {
    		    		groupTaskCntMap.put(grpId, 0);
    		    	}	    	
    		    	if(groupTaskCntMap.containsKey(grpId)) {
    		    		groupTaskCntMap.put(grpId, groupTaskCntMap.get(grpId) + 1);
    		    	}
        	    }
            }    		
    	}
        
        // 当天新任务数
        int taskCntNew = taskGroupMapNew.size();
        Iterator<Map.Entry<Integer, Integer>> taskGroupMapNewIterator = taskGroupMapNew.entrySet().iterator();
    	while(taskGroupMapNewIterator.hasNext()) {
    		Entry<Integer, Integer> taskGroupMapNewEntry = taskGroupMapNewIterator.next();
	    	if(!groupTaskCntMapNew.containsKey(taskGroupMapNewEntry.getValue())) {
	    		groupTaskCntMapNew.put(taskGroupMapNewEntry.getValue(), 0);
	    	}	    	
	    	if(groupTaskCntMapNew.containsKey(taskGroupMapNewEntry.getValue())) {
	    		groupTaskCntMapNew.put(taskGroupMapNewEntry.getValue(), groupTaskCntMapNew.get(taskGroupMapNewEntry.getValue()) + 1);
	    	}
    		
    	}

    	// 根据集团id的升序排列    	
	    Map<Integer,Integer> sortGroupMap= groupMap.entrySet()
        .stream().sorted(Map.Entry.comparingByKey())
        .collect(Collectors
                .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
//    	Iterator sortGroupMapIte = sortGroupMap.entrySet().iterator();
//    	while (sortGroupMapIte.hasNext()){
//            Map.Entry<Integer, Integer> next = (Entry<Integer, Integer>) sortGroupMapIte.next();
//            System.out.println(next.getKey() + ":" + next.getValue());
//        }
    	
	    Map<Integer,Integer> sortGroupTaskCntMap = groupTaskCntMap.entrySet()
	            .stream().sorted(Map.Entry.comparingByKey())
	            .collect(Collectors
	                    .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
//	    Iterator sortGroupTaskCntMapIte = sortGroupTaskCntMap.entrySet().iterator();
//	    while (sortGroupTaskCntMapIte.hasNext()){
//	    	Map.Entry<Integer, Integer> next = (Entry<Integer, Integer>) sortGroupTaskCntMapIte.next();
//	    	System.out.println(next.getKey() + ":" + next.getValue());
//	    }

        // 获取PDF导出总数
        int exportPdfCntExcludeTest = 0;
        Iterator<Map.Entry<Integer, Integer>> groupMapIterator = groupMap.entrySet().iterator();
        while (groupMapIterator.hasNext()){
            Map.Entry<Integer, Integer> next = groupMapIterator.next();
            exportPdfCntExcludeTest = exportPdfCntExcludeTest + next.getValue();
        }
        // System.out.println(exportCntExcludeTest);
        // 有发生导出的集团数
        int groupCnt = groupMap.size();        
        // 获取任务导出总数
        int exportTaskCntExcludeTest = taskMap.size();
        // System.out.println(exportTaskCntExcludeTest);
        

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
       System.out.println("获取集团信息");
       HashMap<String,Integer> grpCntMap = new HashMap<String,Integer>();
       HashMap<String,Integer> grpTaskCntMap = new HashMap<String,Integer>();
       HashMap<String,Integer> grpNewTaskCntMap = new HashMap<String,Integer>();       
       String exportGrpCntDetail = "";
       String exportGrpTaskCntDetail = "";
       String exportGrpNewTaskCntDetail = "";
       if(!groupMap.isEmpty()) {
           Iterator sortGroupMapIte = sortGroupMap.entrySet().iterator();
           Iterator sortGroupTaskCntIte = sortGroupTaskCntMap.entrySet().iterator();
           while(sortGroupMapIte.hasNext() && sortGroupTaskCntIte.hasNext()) {
        	   Entry grpIdCnt = (Entry)sortGroupMapIte.next();
        	   Entry grpTaskCnt = (Entry)sortGroupTaskCntIte.next();
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
    	           if(grpMsgArray.size()>0) {
    		           JSONObject grpInfo = (JSONObject) grpMsgArray.get(0);
    		           String groupName = (String) grpInfo.get("name");
    		           grpCntMap.put(groupName, (Integer)grpIdCnt.getValue());   	
    		           grpTaskCntMap.put(groupName, (Integer)grpTaskCnt.getValue());
    		           
    		           // 如果集团id一致，往新任务中写入集团名
    		           Iterator groupTaskCntMapNewIte = groupTaskCntMapNew.entrySet().iterator();
    		           while(groupTaskCntMapNewIte.hasNext()) {
    		        	   Entry newTaskGrpIdEntry = (Entry)groupTaskCntMapNewIte.next();
    		        	   int newTaskGrpId = (int) newTaskGrpIdEntry.getKey();
    		        	   if(newTaskGrpId == grpId) {
    		        		   grpNewTaskCntMap.put(groupName, (Integer) newTaskGrpIdEntry.getValue());
    		        	   }
    		           }
    		           
    	           }
        	   
           }
                  
  
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
	    Map<String,Integer> sortGrpCntMapDesc= grpCntMap.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
	    Map<String,Integer> grpTaskCntMapDesc= grpTaskCntMap.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
	    Map<String,Integer> grpNewTaskCntMapDesc= grpNewTaskCntMap.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
	    
	    
	    // 构建发送信息
	    Iterator sortGrpCntMapIte = sortGrpCntMapDesc.entrySet().iterator();
	    do {
	    	Entry grpNameCnt = (Entry)sortGrpCntMapIte.next();
	    	exportGrpCntDetail = exportGrpCntDetail + grpNameCnt.getKey() + ": " + grpNameCnt.getValue() + "\\n";
	    	} while(sortGrpCntMapIte.hasNext()); 	   
	    Iterator sortGrpTaskCntMapIte = grpTaskCntMapDesc.entrySet().iterator();
	    do {
	    	Entry grpTaskCnt = (Entry)sortGrpTaskCntMapIte.next();
	    	exportGrpTaskCntDetail = exportGrpTaskCntDetail + grpTaskCnt.getKey() + ": " + grpTaskCnt.getValue() + "\\n";
	    	} while(sortGrpTaskCntMapIte.hasNext());
	    if(!grpNewTaskCntMapDesc.isEmpty()) {
		    Iterator sortGrpNewTaskCntMapIte = grpNewTaskCntMapDesc.entrySet().iterator();  
		    do {
		    	Entry grpNewTaskCnt = (Entry)sortGrpNewTaskCntMapIte.next();
		    	exportGrpNewTaskCntDetail = exportGrpNewTaskCntDetail + grpNewTaskCnt.getKey() + ": " + grpNewTaskCnt.getValue() + "\\n";
		    	} while(sortGrpNewTaskCntMapIte.hasNext());
		    
		    }
	    }
       
       //重新写入最新的历史数据
       System.out.println("正在更新历史数据");
       File fileWrite = new File(pathStr);
       if(!fileWrite.exists() && !fileWrite.isDirectory()) {
           System.out.println("文件不存在");
           fileWrite.mkdirs();
           fileWrite.createNewFile();
       }
       Writer writerOut = new FileWriter(fileWrite);
       // BufferedWriter bw = new BufferedWriter(writerOut);
       BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
       
       bw.write(today);
       bw.write(";");
       bw.flush();             
       for(int task: taskListHistArray) {
           bw.write(String.valueOf(task));
           bw.write(",");
           bw.flush();
       }
       bw.close();
       System.out.println("历史数据更新成功");     
       
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
            if(exportPdfCntExcludeTest == 0) {
                msgToSend = today + "业主验房没有PDF导出";
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}";        
                System.out.print(postMsg);            
            } else if(exportPdfCntExcludeTest > 0 && taskCntNew == 0) {
                msgToSend = today + "业主验房导出" + exportPdfCntExcludeTest + "个PDF文件，"
                		+ "涉及" + groupCnt + "个集团，总共" +  
                		exportTaskCntExcludeTest + "个任务，其中没有涉及新任务" + 
                		"\\n【导出集团和任务数详情】\\n" + exportGrpTaskCntDetail;
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}";  
                System.out.print(postMsg);         	
            } else {
                msgToSend = today + "业主验房导出" + exportPdfCntExcludeTest + "个PDF文件，"
                		+ "涉及" + groupCnt + "个集团，总共" +  
                		exportTaskCntExcludeTest + "个任务，其中包括新导出的任务" + taskCntNew + "个" +  
                		"\\n*****【导出集团和任务数详情】*****\\n" + exportGrpTaskCntDetail + 
                		"*****【新导出任务详情】*****\\n" + exportGrpNewTaskCntDetail;
                postMsg = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + msgToSend + "\"}}";  
                System.out.print(postMsg); 
            }
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
