package com.test.ProcessEngineTest.InterfaceTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import com.jayway.restassured.response.Response;
import com.test.Util.ApiShareSteps;
import com.test.Util.FileUtil;
import com.test.Util.GetConfigProperties;
import com.test.Util.RestassureApiCalling;
import com.test.Util.ScenarioContext;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProcessEngineUtil {
	
	static Logger log = Logger.getLogger("FormViewVerification.class");
	
	private String configPath = "/Configuration/processEngineerInterface.properties";
	private String apiConfigPath = "/Configuration/AppApi_zhijian.properties";
	
	@Given("^I call app login api and web login api of \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_app_login_api_and_web_login_api_of_with_and_for_for(String env, String usr, String psw, String grpCode, String testCase) throws Throwable {
		// app login
		String usrName = null;
		if(usr.contains("-")) {
			usrName = usr.split("-")[1];
		} else {
			usrName = usr;
		}		
        String appHostName = GetConfigProperties.getValue(configPath, env);
		String device_id = ApiShareSteps.deviceIdGenerator();	    
	    String appApiPath = GetConfigProperties.getValue(apiConfigPath, "appLogin");
	    String fullApiPath = appApiPath + "device_id=" + device_id + "&group_code=" + grpCode + "&password=" + psw + "&source=" + "&username=" + usrName + "&verify_code=";
	    log.info(appHostName+fullApiPath);
	    
	    String appResponse = RestassureApiCalling.getMethod(appHostName, fullApiPath);
		JSONObject appResponseJson = ApiShareSteps.strToJson(appResponse);
		String appCallResult = appResponseJson.getString("result").toString();
		Assert.assertEquals("0", appCallResult);
	    String appCallMsg = appResponseJson.getString("message").toString();
	    Assert.assertEquals("登录成功", appCallMsg);
	    
	    JSONObject appResponseData = (JSONObject) appResponseJson.get("data");	    
	    String tokenId = (String) appResponseData.get("token");
	    ScenarioContext.put(testCase + "token", tokenId);   
	    ScenarioContext.put(testCase + "deviceId", device_id);
	    
	    // web login
	    String webHostName = GetConfigProperties.getValue(configPath, env);
	    String webApiPath = GetConfigProperties.getValue(apiConfigPath, "webLogin");
		Map<String,String> setParams = new HashMap<>();
		setParams.put("user_name", usrName);
		setParams.put("password", psw);
		setParams.put("group_code", grpCode);
		setParams.put("remember_me", "0");
		setParams.put("verify_code", "");
		Response webResponse = RestassureApiCalling.postMethodWithoutCookies(webHostName, webApiPath, setParams);
		Map<String, String> curCookies = webResponse.cookies();
		int webResponseStatus = webResponse.statusCode();
		String webResponseBody = webResponse.print();
				
		JSONObject webResponseJson = ApiShareSteps.strToJson(webResponseBody);
		String webLoginMsg = webResponseJson.get("message").toString();
		Assert.assertEquals("登录成功", webLoginMsg);
		Assert.assertEquals(200, webResponseStatus);
		
		ScenarioContext.put(testCase + "cookies", curCookies);
	}	

}
