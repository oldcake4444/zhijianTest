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
import net.sf.json.JSONObject;

public class AppApiTest {
	
	static Logger log = Logger.getLogger("InterfaceTest.class");
	
	private String configPath = "/Configuration/AppApi_zhijian.properties";
	
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
//	    	log.info(expValue[i]);
//	    	log.info(usrData.get(usrDataFields[i]).toString());
	    	Assert.assertEquals(expValue[i], usrData.get(usrDataFields[i]).toString());
	    }
	    
	}
}
