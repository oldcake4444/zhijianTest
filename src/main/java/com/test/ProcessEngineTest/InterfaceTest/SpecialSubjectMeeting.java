package com.test.ProcessEngineTest.InterfaceTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import com.jayway.restassured.response.Response;
import com.test.Util.ApiShareSteps;
import com.test.Util.FileUtil;
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

public class SpecialSubjectMeeting {
	
	static Logger log = Logger.getLogger("SpecialSubjectMeeting.class");
	
	private String configPath = "/Configuration/processEngineerInterface.properties";
	private String apiConfigPath = "/Configuration/AppApi_zhijian.properties";
	
	@When("^I call the special subject meeting api of \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_call_the_special_subject_meeting_api_of_for_with_of_level_for(String env, String testCase, String apiParameters, String lvl, String orgId) throws Throwable {
	    String tokenId = (String)ScenarioContext.get(testCase + "token");
	    @SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
	    
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String[]apiParmList = apiParameters.split(",");
	    String formName = apiParmList[0];
	    String formType = apiParmList[1];
	    String[]orgIdList = orgId.split(",");
	    String grpId = orgIdList[0];
	    String teamId = orgIdList[1];
	    String projId = orgIdList[2];
	    String apiPath = GetConfigProperties.getValue(configPath, "app_special_subject_meeting_check_form").replace("[form_name]", formName).replace("[formType]", formType);
	    String appFullApiPath = apiPath + "form_name=" + formName + "&form_type=" + formType + "&entrance_def_id=list_mobile" + "&token=" + tokenId
	    		+ "&team_id=" + teamId + "&project_id=" + projId + "&page_level=" + lvl;
	    log.info(appFullApiPath);
	    String appResponse = RestassureApiCalling.getMethod(hostName, appFullApiPath);
	    ScenarioContext.put(testCase + "app", appResponse);
	    
	    String webFullApiPath = apiPath + "form_name=" + formName + "&form_type=" + formType + "&entrance_def_id=list_pc" + "&group_id=" + grpId 
	    		+ "&team_id=" + teamId + "&project_id=" + projId + "&page_level=" + lvl; 
	    log.info(webFullApiPath);
	    String webResponse = RestassureApiCalling.getMethodWithCookies(hostName, webFullApiPath, curCookies);
	    ScenarioContext.put(testCase + "web", webResponse);
	}
	
	@Then("^Verify the current user privileges are as expected as \"([^\"]*)\" for \"([^\"]*)\" for special subject meeting processform$")
	public void verify_the_current_user_privileges_are_as_expected_as_for_for_special_subject_meeting_processform(String expUsrPrivileges, String testCase) throws Throwable {
		// app verification
		ArrayList<String> expUsrPriArray = new ArrayList<>();
		String[]expUsrPriList = expUsrPrivileges.split(",");
		for(int j=0; j<expUsrPriList.length; j++) {
			expUsrPriArray.add(expUsrPriList[j]);
		}
		
		String appResponse = (String) ScenarioContext.get(testCase + "app");
		JSONObject appResponseJson = ApiShareSteps.strToJson(appResponse);
	    JSONObject appResponseData = (JSONObject) appResponseJson.get("data");
	    JSONObject appResponseDef = (JSONObject) appResponseData.get("definition");    
	    JSONObject appResponseProcessForm = (JSONObject) appResponseDef.get("processform");
	    JSONArray appOperationArray = (JSONArray) appResponseProcessForm.get("operations");
	    int appOperationNum = appOperationArray.size();
	    
	    ArrayList<String> appActUsrPriArray = new ArrayList<>();
	    
	    for(int i=0; i<appOperationNum; i++) {
		    JSONObject appOperationInfo = appOperationArray.getJSONObject(i);
		    String appOperationType = appOperationInfo.getString("id");
		    appActUsrPriArray.add(appOperationType);
	    }
	    
	    Assert.assertEquals(expUsrPriArray, appActUsrPriArray);
	    
		// web verification	
		String webResponse = (String) ScenarioContext.get(testCase + "web");
		JSONObject webResponseJson = ApiShareSteps.strToJson(webResponse);
	    JSONObject webResponseData = (JSONObject) webResponseJson.get("data");
	    JSONObject webResponseDef = (JSONObject) webResponseData.get("definition");    
	    JSONObject webResponseDataForm = (JSONObject) webResponseDef.get("processform");
	    JSONArray webOperationArray = (JSONArray) webResponseDataForm.get("operations");
	    int webOperationNum = webOperationArray.size();
	    
	    ArrayList<String> webActUsrPriArray = new ArrayList<>();
	    
	    for(int i=0; i<webOperationNum; i++) {
		    JSONObject webOperationInfo = webOperationArray.getJSONObject(i);
		    String webOperationType = webOperationInfo.getString("id");
		    webActUsrPriArray.add(webOperationType);
	    }
	    
	    Assert.assertEquals(expUsrPriArray, webActUsrPriArray);
	}
	
	@Given("^I recover the special subject meeting review data of \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_recover_the_special_subject_meeting_review_data_of_for(String reviewDataPath, String testCase) throws Throwable {
	    log.info("do it later");
	}

	@When("^I commit a special subject meeting form in \"([^\"]*)\" by inputting \"([^\"]*)\" and assign to \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_commit_a_special_subject_meeting_form_in_by_inputting_and_assign_to_for_of_for(String env, String formDataPath, String reviewer, String projId, String teamId, String testCase) throws Throwable {
	    String tokenId = (String)ScenarioContext.get(testCase + "token");
		@SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String dateStr = dateFormat.format(date);
		
		String reviewerId = reviewer.split("-")[0];
	    
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = GetConfigProperties.getValue(configPath, "app_special_subject_meeting_check_commit")
	    		+ "token=" + tokenId + "&team_id=" + teamId + "&project_id=" + projId + "&page_level=project";
	    String inputBody = FileUtil.readFile(formDataPath).replace("[titleName]", testCase + dateStr).replace("[reviwer1]", reviewerId);
	    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, apiPath, inputBody);
	    String responseStr = response.print();
	    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
	    int commitRslt = (int) responseJson.get("result");
	    Assert.assertEquals(0, commitRslt);
	    
	    ScenarioContext.put(testCase + reviewerId +  "titleName", testCase + dateStr);
	    ScenarioContext.put(testCase + "titleName", testCase + dateStr);
	    Thread.sleep(1000);
	}
	
	@When("^I check the special subject meeting list processform assigned to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_check_the_special_subject_meeting_list_processform_assigned_to_of_for_of_level_for(String reviewer1, String env, String testCase, String lvl, String orgId) throws Throwable {
		String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = "/app_flow/v1/papi/processform/special_subject_meeting_check_flow/list/search/?form_name=special_subject_meeting_check_flow&form_type=processform&entrance_def_id=list_pc&action=first&limit=10&last_at=&";
	    String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    String projectId = orgId.split(",")[2];
	    String reviewerId = reviewer1.split("-")[0];
	    
	    String webFullApiPath = apiPath + "group_id=" + groupId + "&team_id=" + teamId + "&project_id=" + projectId + "&page_level=" + lvl;
	    @SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
	    String webResponseStr = RestassureApiCalling.getMethodWithCookies(hostName, webFullApiPath, curCookies);
	    ScenarioContext.put(testCase + "webResponse", webResponseStr);
	    String formTitle = (String) ScenarioContext.get(testCase + reviewerId + "titleName");
	    
	    JSONObject webResponseJson = ApiShareSteps.strToJson(webResponseStr);
		JSONObject webResponseRawDataJson = (JSONObject) webResponseJson.get("data");		
		JSONArray webFormArray = (JSONArray) webResponseRawDataJson.get("data");
	    
		for(int i = 0; i < webFormArray.size(); i++) {
			JSONObject formInfo = webFormArray.getJSONObject(i);
			String returnTitile = (String) formInfo.get("title");
			
			if(returnTitile.equals(formTitle)) {			
				String processId = formInfo.getString("process_id");
				String processFormid = formInfo.getString("form_id");
				JSONObject formFields = formInfo.getJSONObject("f_fields");
				String initiateAt = formFields.getString("initiate_at");
				String initiator = formFields.getString("initiator");
				ScenarioContext.put(testCase + "processId", processId);
				ScenarioContext.put(testCase + "processFormid", processFormid);
				ScenarioContext.put(testCase + "initiateTime", initiateAt);
				ScenarioContext.put(testCase + "initiator", initiator);
				ScenarioContext.put(testCase + "formTitle", returnTitile);
			} 
		}
	}
	
	@Then("^verify current user has permission for \"([^\"]*)\" assigned to \"([^\"]*)\" but not \"([^\"]*)\" of the special subject meeting request created for \"([^\"]*)\"$")
	public void verify_current_user_has_permission_for_assigned_to_but_not_of_the_special_subject_meeting_request_created_for(String flowProcess, String reviewer1, String reviewer2, String testCase) throws Throwable {
		String reviewer1Id = reviewer1.split("-")[0];
		String reviewer2Id = reviewer2.split("-")[0];
		String form1Title = (String) ScenarioContext.get(testCase + reviewer1Id + "titleName");
		String form2Title = (String) ScenarioContext.get(testCase + reviewer2Id + "titleName");
		String webResponseStr = (String) ScenarioContext.get(testCase + "webResponse");
		JSONObject webResponseJson = ApiShareSteps.strToJson(webResponseStr);
		JSONObject webResponseRawDataJson = (JSONObject) webResponseJson.get("data");		
		JSONArray webFormArray = (JSONArray) webResponseRawDataJson.get("data");
		
		for(int i = 0; i < webFormArray.size(); i++) {
			JSONObject formInfo = webFormArray.getJSONObject(i);
			String returnTitile = (String) formInfo.get("title");
			
			if(returnTitile.equals("会议" + form1Title)) {		
				JSONObject taskInfo = formInfo.getJSONArray("tasks").getJSONObject(0);
				Assert.assertTrue((boolean) taskInfo.get("has_perm"));
				String nodeName = (String) taskInfo.get("node_name");
				Assert.assertEquals(flowProcess, nodeName);
				
				String processId = formInfo.getString("process_id");
				JSONObject formFields = formInfo.getJSONObject("f_fields");
				String initiateAt = formFields.getString("initiator_at");
				String initiator = formFields.getString("initiator");
				ScenarioContext.put(testCase + "processId", processId);
				ScenarioContext.put(testCase + "initiateTime", initiateAt);
				ScenarioContext.put(testCase + "initiator", initiator);
				ScenarioContext.put(testCase + "formTitle", returnTitile);
			} else if(returnTitile.equals("会议" + form2Title)) {
				log.info("ZZZZ");
				JSONObject taskInfo = formInfo.getJSONArray("tasks").getJSONObject(0);
				Assert.assertEquals("null", taskInfo.get("has_perm").toString());
				String nodeName = (String) taskInfo.get("node_name");
				Assert.assertEquals(flowProcess, nodeName);				
			}
		}
	}
	
	@Given("^I approve the special subject meeting request by inputting \"([^\"]*)\" and assign to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_approve_the_special_subject_meeting_request_by_inputting_and_assign_to_of_for_of_level_for(String approveDataPath, String nextReviewer, String env, String testCase, String lvl, String orgId) throws Throwable {
		String form1Title = (String) ScenarioContext.get(testCase + "formTitle");
		String processId = (String) ScenarioContext.get(testCase + "processId");
		String dataFormId = (String) ScenarioContext.get(testCase + "dataFormId");
		String initiateAt = (String) ScenarioContext.get(testCase + "initiateTime");
		String initiator = (String) ScenarioContext.get(testCase + "initiator");
		String reviewerId = nextReviewer.split("-")[0];	
		
		String hostName = GetConfigProperties.getValue(configPath, env);
	    String tokenId = (String)ScenarioContext.get(testCase + "token");
	    String apiPath = "/app_flow/v1/papi/process/special_subject_meeting_check_flow/complete_task/submit/?";
		String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    String projectId = orgId.split(",")[2];
	    String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + teamId + "&project_id=" + projectId
	    		+ "&page_level=" + lvl;
	    String rawtimeStr = String.valueOf(System.currentTimeMillis());
	    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
	    String inputBody = FileUtil.readFile(approveDataPath).replace("[formName]", form1Title)
	    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", timeStr)
	    		.replace("[processId]", processId)
	    		.replace("[initiateAt]", initiateAt)
	    		.replace("[initiator]", initiator);
	    log.info(inputBody);
	    
	    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
	    String responseStr = response.print();
	    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
	    int commitRslt = (int) responseJson.get("result");
	    Assert.assertEquals(0, commitRslt);	
	}



}
