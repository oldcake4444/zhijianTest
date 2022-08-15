package com.test.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
	static Logger log = Logger.getLogger("JsonTest.class");
	
	@Given("^I call the group project list api for \"([^\"]*)\"$")
	public void i_call_the_group_project_list_api_for(String testCase) throws Throwable {
		String webHostName = "https://gc.zldcgroup.com";
	    String webApiPath = "/uc/user/login/";
	    Map<String,String> setParams = new HashMap<>();
		setParams.put("user_name", "zjzhongliang");
		setParams.put("password", "zhongliang2021");
		setParams.put("group_code", "");
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
		
		
		String jsonResponse = RestassureApiCalling.getMethodWithCookies("https://gc.zldcgroup.com", "/uc/project/group_project_list/?group_id=2&_ct=json", curCookies);
	    
	    JSONObject jsonResponseJson = ApiShareSteps.strToJson(jsonResponse);
	    JSONObject jsonResponseData = (JSONObject) jsonResponseJson.get("data");
	    JSONArray itemsResponse = (JSONArray) jsonResponseData.get("items");   
	    System.out.print(itemsResponse.size());
	}

	@Then("^Verify the count from the return json for \"([^\"]*)\"$")
	public void verify_the_count_from_the_return_json_for(String testCase) throws Throwable {
	    
	}

}
