package com.test.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;

import com.jayway.restassured.response.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.*;

public class RestassureApiCalling {
	
	static Logger log = Logger.getLogger("ApiTest.class");
	
	/**
	  * 带json的post请求
	  * @param apiPath api地址
	  * @param json    请求json
	  * @return api返回的Response
	  */
	public static Response postMethodWithCookies(String hostName, String apiPath, Map<String, String> cookies, Map<String, String> setParams) {
		//      开始发起post 请求 
		String path = hostName + apiPath;
		log.info(path);
		Response response = given()
		.accept("application/json, text/plain, */*")
		.contentType("application/x-www-form-urlencoded")
        .headers("header1", "value1")
        .cookies(cookies)
        .formParameters(setParams)
        .when().log().all().post(path.trim());          
//		log.info(String.valueOf(response.statusCode()));
//		log.info("response:");
		String responseStr = response.getBody().prettyPrint();
//		log.info(responseStr);
		return response;
	}
	
	public static Response postMethodWithoutCookies(String hostName, String apiPath, Map<String, String> setParams) {
		//      开始发起post 请求 
		String path = hostName + apiPath;
		log.info(path);
		Response response = given()
		.accept("application/json, text/plain, */*")
		.contentType("application/x-www-form-urlencoded")
        .headers("header1", "value1")
        .cookie("cookie1", "value1")
        .formParameters(setParams)
        .when().log().all().post(path.trim());          
//		log.info(String.valueOf(response.statusCode()));
//		log.info("response:");
		String responseStr = response.getBody().prettyPrint();
//		log.info(responseStr);
		return response;
	}
	
	 /**
	  * get 请求
	  * @param apiPath api路径
	  * @return api的response
	  */
	public static String getMethod(String hostName, String apiPath) {
		//      开始发起GET 请求
		String path = hostName + apiPath;
		Response response = given().
           contentType("application/json;charset=UTF-8").
           headers("headers1", "value1").
           cookie("cookie1", "value1").
           when().log().all().get(path.trim());
//		log.info(String.valueOf(response.statusCode()));
//		log.info("reponse:");
		response.getBody().prettyPrint();
		String responeseStr = response.getBody().asString();
		log.info(responeseStr);
		return responeseStr;
	}
	
	public static String getMethodWithCookies(String hostName, String apiPath, Map<String, String> cookies) {
		//      开始发起GET 请求
		String path = hostName + apiPath;
		Response response = given().
           contentType("application/json;charset=UTF-8").
           headers("headers1", "value1").
           cookies(cookies).
           when().log().all().get(path.trim());
//		log.info(String.valueOf(response.statusCode()));
//		log.info("reponse:");
		response.getBody().prettyPrint();
		String responeseStr = response.getBody().asString();
		log.info(responeseStr);
		return responeseStr;
	}
	
	public static Response getMethodResponse(String hostName, String apiPath) {
		//      开始发起GET 请求
		String path = hostName + apiPath;
		Response response = given().
           contentType("application/json;charset=UTF-8").
           headers("headers1", "value1").
           cookie("cookie1", "value1").
           when().log().all().get(path.trim());
		return response;
	}
	
	/**
	 * 获取json中某个key值
	 * @param response  接口返回
	 * @param jsonPath  jsonpath, 例如 a.b.c   a.b[1].c  a
	 * @return
	 */
	public static String getJsonPathValue(Response response, String jsonPath) {
		String reponseJson = String.valueOf(response.jsonPath().get(jsonPath));
		//      String jsonValue = String.valueOf(from(reponseJson).get(jsonPath));
		return reponseJson;
	}
	
	@Test
	public void testApiGetMethod() {
//		Response response = getMethodResponse("https://zj.buildingqm.com", "/uc/user/login/?user_name=kentestgrp10&password=12345678&group_code=&remember_me=0&verify_code=");
//		response.cookies();
		Map<String,String> setParams = new HashMap<>();
		setParams.put("user_name", "kentestgrp10");
		setParams.put("password", "12345678");
		setParams.put("group_code", "");
		setParams.put("remember_me", "0");
		setParams.put("verify_code", "");
		
		String jsonStr = "{\"user_name\":\"kentestgrp10\",\"password\":\"12345678\",\"remember_me\":\"0\"}";
		
		Response response = given().accept("application/json").
				contentType("application/x-www-form-urlencoded")

		         .formParams(setParams).post("https://zj.buildingqm.com/uc/user/login/");    
		
		log.info(response.getBody().prettyPrint());

	}
	




}
