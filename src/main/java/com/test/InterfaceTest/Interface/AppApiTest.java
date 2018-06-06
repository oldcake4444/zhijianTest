package com.test.InterfaceTest.Interface;

import java.util.logging.Logger;

import org.junit.Assert;

import com.test.InterfaceTest.Util.ApiShareSteps;
import com.test.InterfaceTest.Util.GetConfigProperties;
import com.test.InterfaceTest.Util.HttpUtil;
import com.test.InterfaceTest.Util.RestassureApiCalling;
import com.test.InterfaceTest.Util.ScenarioContext;
import com.test.InterfaceTest.Util.TextFormat;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppApiTest {
	
	static Logger log = Logger.getLogger("InterfaceTest.class");
	
	private String configPath = "/Configuration/AppApi_zhijian.properties";
	private String acntConfigPath = "/Configuration/accountName.properties";
	
	@Given("^I call the \"([^\"]*)\" api of \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"in \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_api_of_with_and_in(String apiName, String env, String apiParm1, String apiParm2, String apiParms, String testCase) throws Throwable {
		String hostName = GetConfigProperties.getValue(configPath, env);
		
		String device_id = ApiShareSteps.deviceIdGenerator();
	    String[]apiParmList = apiParms.split(";");
	    String apiParmName1 = apiParmList[0];
	    String apiParmName2 = apiParmList[1];
	    String apiParmName3 = apiParmList[2];
	    
	    String apiPath = GetConfigProperties.getValue(configPath, apiName);
	    String fullApiPath = apiPath + apiParmName1 + "=" + device_id + "&" + apiParmName2 + "=" + apiParm1 + "&" + apiParmName3 + "=" + apiParm2;
	    log.info(hostName+fullApiPath);
	    
	    String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    
	    ScenarioContext.put(testCase, response);
	}
	
	@Then("^Verify the calling is successful with \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_calling_is_successful_with_for(String msg, String testCase) throws Throwable {
	    String response = (String) ScenarioContext.get(testCase);
//	    log.info(ApiShareSteps.strToJson(response).toString());
	    JSONObject responseJson = ApiShareSteps.strToJson(response);
//	    log.info(responseJson.get("result").toString());
	    String callResult = responseJson.getString("result").toString();
	    Assert.assertEquals("0", callResult);
	    String callMsg = responseJson.getString("message").toString();
	    Assert.assertEquals(msg, callMsg);
	    
	}

	@Then("^Verify the return message is expected as \"([^\"]*)\" in \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_return_message_is_expected_as_in_for(String expValueList, String returnMsgFieldList, String testCase) throws Throwable {
		String response = (String) ScenarioContext.get(testCase);;
	    JSONObject responseJson = ApiShareSteps.strToJson(response);
	    JSONObject responseData = (JSONObject) responseJson.get("data");
	    JSONObject usrData = (JSONObject) responseData.get("user");
//	    log.info(usrData.toString());
	    String[]usrDataFields = returnMsgFieldList.split(";");
	    String[]expValue = expValueList.split(";");
	    for (int i = 0; i < expValue.length; i++) {
	    	Assert.assertEquals(expValue[i], usrData.get(usrDataFields[i]).toString());
	    }
	    
	}
	
	@When("^I call the login api of \"([^\"]*)\" for the \"([^\"]*)\" new users with \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_login_api_of_for_the_new_users_with_for(String env, String usrCount, String apiParms, String testCase) throws Throwable {
		String hostName = GetConfigProperties.getValue(configPath, env);
		String apiPath = GetConfigProperties.getValue(configPath, "login");
		String device_id = ApiShareSteps.deviceIdGenerator();
	    String[]apiParmList = apiParms.split(";");
	    String apiParmName1 = apiParmList[0];
	    String apiParmName2 = apiParmList[1];
	    String apiParmName3 = apiParmList[2];
	    
	    for(int i = 1; i <= Integer.valueOf(usrCount); i++) {
	    	String usrName = (String)ScenarioContext.get(env + i);
	    	String fullApiPath = apiPath + apiParmName1 + "=" + device_id + "&" + apiParmName2 + "=" + GetConfigProperties.getValue(this.acntConfigPath, "password") + "&" + apiParmName3 + "=" + usrName ;
	    	log.info(hostName+fullApiPath);
	    	String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    	ScenarioContext.put(testCase + env + String.valueOf(i), response);
	    	Thread.sleep(2000);
	    }
	    
	}
	
	@Then("^Verify the \"([^\"]*)\" callings in \"([^\"]*)\" are successful with \"([^\"]*)\" and equal to \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_callings_in_are_successful_with_and_equal_to_for(String usrCount, String env, String msg, String expUsrInfo, String testCase) throws Throwable {
		for(int i = 1; i <= Integer.valueOf(usrCount); i++) {
		    String response = (String) ScenarioContext.get(testCase + env + String.valueOf(i));
//		    log.info(ApiShareSteps.strToJson(response).toString());
		    JSONObject responseJson = ApiShareSteps.strToJson(response);
//		    log.info(responseJson.get("result").toString());
		    String callResult = responseJson.getString("result").toString();
		    Assert.assertEquals("0", callResult);
		    String callMsg = responseJson.getString("message").toString();
		    Assert.assertEquals(msg, callMsg);

		    JSONObject responseData = (JSONObject) responseJson.get("data");
		    JSONObject usrData = (JSONObject) responseData.get("user");		    
		    String tokenId = (String) responseData.get("token");
		    ScenarioContext.put(testCase + env + String.valueOf(i) + "tokenId", tokenId);
		    
		    String expEmail = expUsrInfo.split(",")[4];
		    String expMobile = expUsrInfo.split(",")[3];
		    String expRealName = (String)ScenarioContext.get(env + i + "realName");;
		    String expUsrName = (String)ScenarioContext.get(env + i);
		    Assert.assertEquals(expEmail, usrData.get("email"));
		    Assert.assertEquals(expMobile, usrData.get("mobile"));
		    Assert.assertEquals(expRealName, usrData.get("real_name"));
		    Assert.assertEquals(expUsrName, usrData.get("user_name"));
		    
		    
		    
		}

	}
	
	@Given("^I call the teams and projects api in \"([^\"]*)\" to verify the \"([^\"]*)\" new users are in \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_teams_and_projects_api_in_to_verify_the_new_users_are_in_and_and_for(String env, String usrCount, String expGrpName, String expComName, String expProjName, String testCase) throws Throwable {
		String hostName = GetConfigProperties.getValue(configPath, env);
		String apiPath = GetConfigProperties.getValue(configPath, "teamsAndProjects");
		String device_id = ApiShareSteps.deviceIdGenerator();
	    for(int i = 1; i <= Integer.valueOf(usrCount); i++) {
	    	String tokenId = (String)ScenarioContext.get(testCase + env + String.valueOf(i) + "tokenId");
	    	String fullApiPath = apiPath + "device_id=" + device_id + "&" + "token=" + tokenId;
	    	log.info(hostName+fullApiPath);
	    	String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    	
	    	JSONObject responseJson = ApiShareSteps.strToJson(response);
	    	JSONObject responseData = (JSONObject) responseJson.get("data");
	    	JSONArray teamData = (JSONArray) responseData.get("teams");
	    	JSONArray projectData = (JSONArray) responseData.get("projects");

	    	for(int j = 0; j < teamData.size(); j++) {
	    		JSONObject team = teamData.getJSONObject(j);
	    		String teamName = team.getString("team_name");
   				log.info(team.getString("team_name"));
	    		Assert.assertTrue(teamName.equals(expGrpName) || teamName.equals(expComName));
	    		
	    	}
	    	for(int k = 0; k < projectData.size(); k++) {
	    		JSONObject project = projectData.getJSONObject(k);
	    		String projName = project.getString("name");
	    		log.info(project.getString("name"));
	    		Assert.assertEquals(expProjName, projName);
	    	}
	    	
	    }
	}
	

}
