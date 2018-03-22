package com.test.InterfaceTest.Util;

import java.util.logging.Logger;

import org.junit.Test;

import com.jayway.restassured.response.Response;
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
	public static Response postMethod(String hostName, String apiPath, String json) {
		//      开始发起post 请求 
		String path = hostName + apiPath;
		Response response = given().
           contentType("application/json;charset=UTF-8").
           headers("header1", "value1").
           cookies("cookies1", "value1").
           body(json).
           when().log().all().post(path.trim());
		log.info(String.valueOf(response.statusCode()));
		log.info("reponse:");
		response.getBody().prettyPrint();
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
//		response.getBody().prettyPrint();
		String responeseStr = response.getBody().asString();
//		log.info(responeseStr);
		return responeseStr;
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
		String response = getMethod("http://www.weather.com.cn", "/data/cityinfo/101010100.html");
		log.info(response);
	}



}
