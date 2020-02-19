package com.test.statistics.Interface;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import com.jayway.restassured.response.Response;
import com.test.Util.ApiShareSteps;
import com.test.Util.GetConfigProperties;
import com.test.Util.RestassureApiCalling;
import com.test.Util.ScenarioContext;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import net.sf.json.JSONObject;

public class ApiRequest {
	
	static Logger log = Logger.getLogger("ApiRequest.class");
	private String configPath = "/Configuration/AppApi_zhijian.properties";
	
    @Given("^I login with \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" by calling web login interface for \"([^\"]*)\"$")
	public void i_login_with_and_for_of_by_calling_web_login_interface(String user, String psw, String grpCode, String env, String testCase) throws Throwable {
        String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = GetConfigProperties.getValue(configPath, "webLogin");
		Map<String,String> setParams = new HashMap<>();
		setParams.put("user_name", user);
		setParams.put("password", psw);
		setParams.put("group_code", grpCode);
		setParams.put("remember_me", "0");
		setParams.put("verify_code", "");
		Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, apiPath, setParams);
		Map<String, String> curCookeis = response.cookies();
		int responseStatus = response.statusCode();
		String responseBody = response.getBody().asString().replace("<html>", "").replace("<body>", "").replace("\n","").replace("  ","").replace("</body></html>", "");
		
		log.info(responseBody);
		log.info(String.valueOf(responseStatus));
		
		JSONObject responseJson = ApiShareSteps.strToJson(responseBody);
		String loginMsg = responseJson.get("message").toString();
		Assert.assertEquals("登录成功", loginMsg);
		Assert.assertEquals(200, responseStatus);
		
		ScenarioContext.put(testCase, curCookeis);
	}
    
    @Given("^I call \"([^\"]*)\" module issue percentage stat api of \"([^\"]*)\" of \"([^\"]*)\" of \"([^\"]*)\" in \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_call_module_issue_percentage_stat_api_of_of_of_in_for(String categoryCls, String projId, String teamId, String grpId, String env, String testCase) throws Throwable {
    	@SuppressWarnings("unchecked")
		Map<String, String> cookies = (Map<String, String>) ScenarioContext.get(testCase);
    	
    	String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = "/ydyf_stat/v1/fb/houseqm_stat/module_issue_percentage_stat/?";
	    
	    String fullApiPath = apiPath + "project_id=" + projId + "&page_level=project&" + "group_id=" + grpId + "&team_id=" + teamId + "&category_cls=" + categoryCls;
	    log.info(hostName+fullApiPath);
	    
	    String response = RestassureApiCalling.getMethodWithCookies(hostName, fullApiPath, cookies);
	    log.info(response);
	    
	    
    }

}
