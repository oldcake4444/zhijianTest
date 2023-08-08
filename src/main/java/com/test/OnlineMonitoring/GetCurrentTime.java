package com.test.OnlineMonitoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import java.util.Optional;

import com.jayway.restassured.response.Response;
import com.test.Util.ApiShareSteps;
import com.test.Util.GetConfigProperties;
import com.test.Util.RestassureApiCalling;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetCurrentTime {

	public static void main(String[] args) throws Exception {
		long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=(current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset())/1000;//今天零点零分零秒的毫秒数
	    long currentLong = current/1000;
        long yesterdayZero = zero - 3600 * 24;
        long yesterdayEnd = zero - 1;
        
//        System.out.println(current);
//        System.out.println(zero);
//        System.out.println(currentLong);
//        System.out.println(yesterdayZero);
//        System.out.println(yesterdayEnd);
        
        HttpURLConnection connection = null;
        
        URL urlControlLogin = new URL("https://zj.buildingqm.com/crm/admin/login/?_ct=json");
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
        buffer.append("zhijian");
        buffer.append("\r\n");
        //第二个提交的参数
        buffer.append("--").append(mimeBoundary);
        buffer.append("\r\n");
        buffer.append("Content-Disposition: form-data; name=\"password\"");
        buffer.append("\r\n\r\n");
        buffer.append("213213as");
        buffer.append("\r\n");
        //第三个提交的参数
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
//        Map<String, List<String>> headerFields = connection.getHeaderFields();
//        List<String> cookiesHeader = headerFields.get("Set-Cookie");
//        String cookie = null;
//        String sessionid = null;
//        if(cookiesHeader != null){
//            cookie = cookiesHeader.get(0);
//            HttpCookie httpCookie = HttpCookie.parse(cookie).get(0);
//            String name = httpCookie.getName(); 
//            String value = httpCookie.getValue();
//            String domain = httpCookie.getDomain();
//            sessionid = cookie.substring(0, cookie.indexOf(";"));;
//        }
        // connection.disconnect();
        
        
        String cookieHeader = connection.getHeaderField("Set-Cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookieHeader);
        CookieManager cookieManager = new CookieManager();
        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, 
        		cookie));
        Optional<HttpCookie> usernameCookie = cookies.stream().findAny().filter(cookie -> cookie.getName().equals("username"));
        if (usernameCookie == null) {
            cookieManager.getCookieStore().add(null, new HttpCookie("username", "javanorth"));
        }
        connection.disconnect();

        
//        HttpURLConnection connection2 = null;
        URL urlGrpQuery = new URL("https://zj.buildingqm.com/crm/owner_inspection/group_stock_list/?_ct=json&limit=10&page=1&search=&no_exists=false");
        connection = (HttpURLConnection)urlGrpQuery.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        
        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("Accept", "*/*");
        // 写入cookie
        connection.setRequestProperty("Cookie", "zjsess=MTY3NTkzMzE3OHxJbEpFYXpSU2EwMTRUbFZSTlZWNmJGTlJiRlpLVTNwT1JWUkZlRlZPTUd4UFVXeFJORTE2VlhkT01FMGlDZz09fHnAV4g7COtpE8OjjLbadzOb7MXMd1pSJm9VbDCkyxiO");
        connection.connect(); 
        OutputStream grpQueryOut = connection.getOutputStream();
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
       System.out.println(msgControlLogin);
       System.out.println(grpQueryCode);
       System.out.println(grpQueryMsg);
        




        
        



	}

}
