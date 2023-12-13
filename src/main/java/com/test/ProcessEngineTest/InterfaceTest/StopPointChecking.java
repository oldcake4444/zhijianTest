package com.test.ProcessEngineTest.InterfaceTest;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;

import com.test.Util.ApiShareSteps;
import com.test.Util.GetConfigProperties;
import com.test.Util.RestassureApiCalling;
import com.test.Util.ScenarioContext;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StopPointChecking {
	
	static Logger log = Logger.getLogger("StopPointChecking.class");
	
	private String configPath = "/Configuration/processEngineerInterface.properties";
	private String apiConfigPath = "/Configuration/AppApi_zhijian.properties";

	@When("^I call the stop_checkpoint_yc_processform api of \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_call_the_stop_checkpoint_yc_processform_api_of_for_with_of_level_for(String env, String testCase, String apiParameters, String lvl, String orgId) throws Throwable {
		String loginResponse = (String) ScenarioContext.get("loginInfo");
		JSONObject responseJson = ApiShareSteps.strToJson(loginResponse);
	    JSONObject responseData = (JSONObject) responseJson.get("data");	    
	    String tokenId = (String) responseData.get("token");
	    
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String[]apiParmList = apiParameters.split(",");
	    String formName = apiParmList[0];
	    String formType = apiParmList[1];
	    String entranceDefId = apiParmList[2];
	    String[]orgIdList = orgId.split(",");
	    String pageLvl = lvl;
	    String apiPath = GetConfigProperties.getValue(configPath, "stop_checkpoint_yc_processform").replace("[formType]", formType);
	    if(orgIdList[0].length()>0) {
		    String fullApiPath = apiPath + "form_name=" + formName + "&" + "form_type=" + formType + "&" + "entrance_def_id=" + entranceDefId + "&" + "token=" + tokenId + "&"
		    		+ "team_id=" + orgIdList[0] + "&" + "page_level=" + pageLvl + "&" + "group_id=" + orgIdList[0];
		    String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
		    ScenarioContext.put(testCase, response);	    	
	    } else if(orgIdList[1].length()>0) {
		    String fullApiPath = apiPath + "form_name=" + formName + "&" + "form_type=" + formType + "&" + "entrance_def_id=" + entranceDefId + "&" + "token=" + tokenId + "&"
		    		+ "team_id=" + orgIdList[1] + "&" + "page_level=" + pageLvl;	    
		    String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
		    ScenarioContext.put(testCase, response);	  
	    } else if(orgIdList[2].length()>0) {
		    String fullApiPath = apiPath + "form_name=" + formName + "&" + "form_type=" + formType + "&" + "entrance_def_id=" + entranceDefId + "&" + "token=" + tokenId + "&"
		    		+ "project_id=" + orgIdList[2] + "&" + "page_level=" + pageLvl;	    
		    String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
		    ScenarioContext.put(testCase, response);
	    } 
	    
	}
	
	@Then("^Verify the current user privileges are as expected as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_current_user_privileges_are_as_expected_as_for(String expUsrPrivileges, String testCase) throws Throwable {
		ArrayList<String> expUsrPriArray = new ArrayList<>();
		String[]expUsrPriList = expUsrPrivileges.split(",");
		for(int j=0; j<expUsrPriList.length; j++) {
			expUsrPriArray.add(expUsrPriList[j]);
		}
		
		String response = (String) ScenarioContext.get(testCase);	
		JSONObject responseJson = ApiShareSteps.strToJson(response);
	    JSONObject responseData = (JSONObject) responseJson.get("data");
	    JSONObject responseDef = (JSONObject) responseData.get("definition");    
	    JSONObject responseProcessForm = (JSONObject) responseDef.get("processform");
	    JSONArray operationArray = (JSONArray) responseProcessForm.get("operations");
	    int operationNum = operationArray.size();
	    
	    ArrayList<String> actUsrPriArray = new ArrayList<>();
	    
	    for(int i=0; i<operationNum; i++) {
		    JSONObject operationInfo1 = operationArray.getJSONObject(i);
		    String operationType = operationInfo1.getString("type");
		    actUsrPriArray.add(operationType);
	    }
	    
	    Assert.assertEquals(expUsrPriArray, actUsrPriArray);
	    
	}
}
