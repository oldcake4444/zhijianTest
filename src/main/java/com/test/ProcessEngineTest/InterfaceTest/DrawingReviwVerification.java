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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DrawingReviwVerification {
	
	static Logger log = Logger.getLogger("DrawingReviwVerification.class");
	
	private String configPath = "/Configuration/processEngineerInterface.properties";
	private String apiConfigPath = "/Configuration/AppApi_zhijian.properties";
	
	@When("^I call the project_drawings_dataform api of \"([^\"]*)\" for \"([^\"]*)\" with \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_call_the_project_drawings_dataform_api_of_for_with_of_level_for(String env, String testCase, String apiParameters, String lvl, String orgId) throws Throwable {    
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
	    String apiPath = GetConfigProperties.getValue(configPath, "app_drawing_review_form").replace("[form_name]", formName).replace("[formType]", formType);
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
	
	@Then("^Verify the current user privileges are as expected as \"([^\"]*)\" for \"([^\"]*)\" for project_drawings_dataform$")
	public void verify_the_current_user_privileges_are_as_expected_as_for_for_project_drawings_dataform(String expUsrPrivileges, String testCase) throws Throwable {
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
	    JSONObject appResponseDataForm = (JSONObject) appResponseDef.get("dataform");
	    JSONArray appOperationArray = (JSONArray) appResponseDataForm.get("operations");
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
	    JSONObject webResponseDataForm = (JSONObject) webResponseDef.get("dataform");
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
	

	@When("^I commit a drawing review form in \"([^\"]*)\" by inputting \"([^\"]*)\" and assign to \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_commit_a_drawing_review_form_in_by_inputting_and_assign_to_for_of_for(String env, String formDataPath, String reviewer, String projId, String teamId, String testCase) throws Throwable {
	    String tokenId = (String)ScenarioContext.get(testCase + "token");
		@SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String dateStr = dateFormat.format(date);
		
		String reviewerId = reviewer.split("-")[0];
	    
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = GetConfigProperties.getValue(configPath, "app_drawing_review_commit")
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
		
	@When("^I check the project drawing list processform assigned to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_check_the_project_drawing_list_processform_assigned_to_of_for_of_level_for(String reviewer1, String env, String testCase, String lvl, String orgId) throws Throwable {
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = "/app_flow/v1/papi/processform/project_drawings_create_yc/list/search/?form_name=project_drawings_create_yc&form_type=processform&entrance_def_id=list_pc&action=first&limit=10&last_at=&";
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
	
	
	@When("^I check the project drawing list dataFrom assigned to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_check_the_project_drawing_list_dataFrom_assigned_to_of_for_of_level_for(String reviewer1, String env, String testCase, String lvl, String orgId) throws Throwable {
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = "/app_flow/v1/papi/dataform/project_drawings_yc/list/search/?form_name=project_drawings_yc&form_type=dataform&entrance_def_id=list_pc&action=first&limit=10&last_at=&";
	    String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    String projectId = orgId.split(",")[2];
	    String reviewerId = reviewer1.split("-")[0];
	    
	    String webFullApiPath = apiPath + "group_id=" + groupId + "&team_id=" + teamId + "&project_id=" + projectId + "&page_level=" + lvl;
	    @SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
	    String webResponseStr = RestassureApiCalling.getMethodWithCookies(hostName, webFullApiPath, curCookies);
	    ScenarioContext.put(testCase + "dataForm" + "webResponse", webResponseStr);
	    String formTitle = (String) ScenarioContext.get(testCase + reviewerId + "titleName");
	    
	    JSONObject webResponseJson = ApiShareSteps.strToJson(webResponseStr);
		JSONObject webResponseRawDataJson = (JSONObject) webResponseJson.get("data");		
		JSONArray webFormArray = (JSONArray) webResponseRawDataJson.get("data");
	    
		for(int i = 0; i < webFormArray.size(); i++) {
			JSONObject formInfo = webFormArray.getJSONObject(i);
			String returnTitile = (String) formInfo.get("title");
			
			if(returnTitile.equals(formTitle)) {			
				String dataFormId = formInfo.getString("form_id");
				JSONObject formFields = formInfo.getJSONObject("f_fields");
				String dataFormStatus = formFields.getString("status");
				ScenarioContext.put(testCase + "dataFormId", dataFormId);
				ScenarioContext.put(testCase + "dataFormStatus", dataFormStatus);
			} 
		}
	}
	
	@And("^I verify the drawing review process form and data form assigned to \"([^\"]*)\" are in the correct status of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
	public void i_verify_the_drawing_review_process_form_and_data_form_assigned_to_are_in_the_correct_status_of_for_of_level_for(String reviewer1, String env, String testCase, String lvl, String orgId) throws Throwable {
	    String hostName = GetConfigProperties.getValue(configPath, env);
	    String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    String projectId = orgId.split(",")[2]; 
	    String reviewerId = reviewer1.split("-")[0];
		@SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
		String formTitle = (String) ScenarioContext.get(testCase + reviewerId + "titleName");
		
	    String processFormApiPath = "/app_flow/v1/papi/processform/project_drawings_create_yc/list/search/?form_name=project_drawings_create_yc&form_type=processform&entrance_def_id=list_pc&action=first&limit=10&last_at=&";
	    String processFormFullApiPath = processFormApiPath + "group_id=" + groupId + "&team_id=" + teamId + "&project_id=" + projectId + "&page_level=" + lvl;
	    String processFormResponseStr = RestassureApiCalling.getMethodWithCookies(hostName, processFormFullApiPath, curCookies);
	    
	    
	    String dataFormApiPath = "/app_flow/v1/papi/dataform/project_drawings_yc/list/search/?form_name=project_drawings_yc&form_type=dataform&entrance_def_id=list_pc&action=first&limit=10&last_at=&";
	    String dataFormFullApiPath = dataFormApiPath + "group_id=" + groupId + "&team_id=" + teamId + "&project_id=" + projectId + "&page_level=" + lvl;
	    String dataFormResponseStr = RestassureApiCalling.getMethodWithCookies(hostName, dataFormFullApiPath, curCookies);
	    JSONObject dataFormResponseJson = ApiShareSteps.strToJson(dataFormResponseStr);
		JSONObject dataFormResponseRawDataJson = (JSONObject) dataFormResponseJson.get("data");		
		JSONArray dataFormArray = (JSONArray) dataFormResponseRawDataJson.get("data");	    
		for(int i = 0; i < dataFormArray.size(); i++) {
			JSONObject formInfo = dataFormArray.getJSONObject(i);
			String returnTitile = (String) formInfo.get("title");
			
			if(returnTitile.equals(formTitle)) {			
				JSONObject formFields = formInfo.getJSONObject("f_fields");
				String formStatus = formFields.getString("status");
				Assert.assertEquals(String.valueOf(2), formStatus);
			} 
		}
	    
	    
	}
	
	@Then("^verify current user has permission for \"([^\"]*)\" assigned to \"([^\"]*)\" but not \"([^\"]*)\" of the project drawing review request created for \"([^\"]*)\"$")
	public void verify_current_user_has_permission_for_assigned_to_but_not_of_the_project_drawing_review_request_created_for(String flowProcess, String reviewer1, String reviewer2, String testCase) throws Throwable {		
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
			
			if(returnTitile.equals(form1Title)) {
				JSONObject taskInfo = formInfo.getJSONArray("tasks").getJSONObject(0);
				Assert.assertTrue((boolean) taskInfo.get("has_perm"));
				String nodeName = (String) taskInfo.get("node_name");
				Assert.assertEquals(flowProcess, nodeName);
				
				String processId = formInfo.getString("process_id");
				JSONObject formFields = formInfo.getJSONObject("f_fields");
				String initiateAt = formFields.getString("initiate_at");
				String initiator = formFields.getString("initiator");
				ScenarioContext.put(testCase + "processId", processId);
				ScenarioContext.put(testCase + "initiateTime", initiateAt);
				ScenarioContext.put(testCase + "initiator", initiator);
				ScenarioContext.put(testCase + "formTitle", returnTitile);
			} else if(returnTitile.equals(form2Title)) {
				JSONObject taskInfo = formInfo.getJSONArray("tasks").getJSONObject(0);
				Assert.assertEquals("null", taskInfo.get("has_perm").toString());
				String nodeName = (String) taskInfo.get("node_name");
				Assert.assertEquals(flowProcess, nodeName);				
			}
		}
	}
	
	

	
    @Then("^I approve the project drawing review request by inputting \"([^\"]*)\" and assign to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
  	public void i_approve_the_project_drawing_review_request_by_inputting_and_assign_to_of_for_of_level_for(String approveDataPath, String nextReviewer, String env, String testCase, String lvl, String orgId) throws Throwable {
		String form1Title = (String) ScenarioContext.get(testCase + "formTitle");
		String processId = (String) ScenarioContext.get(testCase + "processId");
		String dataFormId = (String) ScenarioContext.get(testCase + "dataFormId");
		String initiateAt = (String) ScenarioContext.get(testCase + "initiateTime");
		String initiator = (String) ScenarioContext.get(testCase + "initiator");
		String reviewerId = nextReviewer.split("-")[0];	
		
		String hostName = GetConfigProperties.getValue(configPath, env);
	    String tokenId = (String)ScenarioContext.get(testCase + "token");
	    String apiPath = "/app_flow/v1/papi/process/project_drawings_create_yc/complete_task/submit/?";
		String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    
		if(lvl.equals("project")) {
		    String projectId = orgId.split(",")[2];
		    String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + teamId + "&project_id=" + projectId
		    		+ "&page_level=" + lvl;
		    String rawtimeStr = String.valueOf(System.currentTimeMillis());
		    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
		    String inputBody = FileUtil.readFile(approveDataPath).replace("[formName]", "\"name\":\"" + form1Title  + "\"")
		    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", "\"audit_at\":" + timeStr)
		    		.replace("[processId]", "\"process_id\":\"" + processId + "\"")
		    		.replace("[initiateAt]", "\"initiate_at\":\"" + initiateAt + "\"")
		    		.replace("[initiator]", "\"initiator\":" + initiator);
		    log.info(inputBody);
		    
		    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
		    String responseStr = response.print();
		    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		    int commitRslt = (int) responseJson.get("result");
		    Assert.assertEquals(0, commitRslt);	
		} else if (lvl.equals("team")) {
		    String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + teamId + "&page_level=" + lvl;
		    String rawtimeStr = String.valueOf(System.currentTimeMillis());
		    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
		    String inputBody = FileUtil.readFile(approveDataPath).replace("[formName]", "\"name\":\"" + form1Title  + "\"")
		    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", "\"audit_at\":" + timeStr)
		    		.replace("[processId]", "\"process_id\":\"" + processId + "\"")
		    		.replace("[initiateAt]", "\"initiate_at\":\"" + initiateAt + "\"")
		    		.replace("[initiator]", "\"initiator\":" + initiator);
		    log.info(inputBody);
		    
		    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
		    String responseStr = response.print();
		    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		    int commitRslt = (int) responseJson.get("result");
		    Assert.assertEquals(0, commitRslt);	
		} else if (lvl.equals("group")) {
			String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + groupId + "&page_level=" + lvl + "&group_id=" + groupId;
		    String rawtimeStr = String.valueOf(System.currentTimeMillis());
		    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
		    String inputBody = FileUtil.readFile(approveDataPath).replace("[formName]", "\"name\":\"" + form1Title  + "\"")
		    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", "\"audit_at\":" + timeStr)
		    		.replace("[processId]", "\"process_id\":\"" + processId + "\"")
		    		.replace("[initiateAt]", "\"initiate_at\":\"" + initiateAt + "\"")
		    		.replace("[initiator]", "\"initiator\":" + initiator).replace("[dataId]", "\"data_id\":\"" + dataFormId + "\"");
		    log.info(inputBody);
		    
		    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
		    String responseStr = response.print();
		    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		    int commitRslt = (int) responseJson.get("result");
		    Assert.assertEquals(0, commitRslt);	
		}    

	}
    
    @And("^I check the drawing review processform assigned to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\" and get the info of \"([^\"]*)\" and update \"([^\"]*)\"$")
    public void i_check_the_drawing_review_processform_assigned_to_of_for_of_level_for_and_get_the_info_of_and_update(String reviewer1, String env, String testCase, String lvl, String orgId, String reviewStage, String approveDataPaths) throws Throwable {
		String processFormId = (String)ScenarioContext.get(testCase + "processFormid");
		
		String hostName = GetConfigProperties.getValue(configPath, env);
	    String apiPath = "/app_flow/v1/papi/processform/project_drawings_create_yc/detail/get/?operation_def_id=detail&form_id=";
		String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    String projectId = orgId.split(",")[2];
	    String fullApiPath = apiPath + processFormId + "&form_def_id=project_drawings_create_yc&group_id=" + groupId 
	    		+ "&team_id=" + teamId + "&project_id=" + projectId + "&page_level=" + lvl;
	    @SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
	    String responseStr = RestassureApiCalling.getMethodWithCookies(hostName, fullApiPath, curCookies);
	    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		JSONObject responseRawDataJson1 = (JSONObject) responseJson.get("data");	
		JSONObject responseRawDataJson2 = (JSONObject) responseRawDataJson1.get("data");
		JSONObject filedDataJson = (JSONObject) responseRawDataJson2.get("f_fields");
		String approveDataFiles[] = approveDataPaths.split(";");
		JSONObject auditDataJson = (JSONObject) filedDataJson.get(reviewStage);
		long dateLong = auditDataJson.getLong("audit_at");
		String dateStr = String.valueOf(dateLong) + ".000";
		
		if(reviewStage.equals("spe_supervision_audit")) {
			if(approveDataFiles.length == 1) {
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[0]);
			} if(approveDataFiles.length == 2) {
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[0]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[1]);
			} if(approveDataFiles.length == 3) {
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[0]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[1]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[2]);
			} if(approveDataFiles.length == 4) {
				System.out.println(approveDataFiles[3]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[0]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[1]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[2]);
				FileUtil.replaceAndwriteFile("[spe_supervision_audit_time]", dateStr, approveDataFiles[3]);	
			} 
		} else if(reviewStage.equals("supervision_audit")) {
			if(approveDataFiles.length == 2) {
				FileUtil.replaceAndwriteFile("[supervision_audit_time]", dateStr, approveDataFiles[1]);				
			} else if(approveDataFiles.length == 3) {
				FileUtil.replaceAndwriteFile("[supervision_audit_time]", dateStr, approveDataFiles[1]);
				FileUtil.replaceAndwriteFile("[supervision_audit_time]", dateStr, approveDataFiles[2]);				
			} else if(approveDataFiles.length == 4) {
				FileUtil.replaceAndwriteFile("[supervision_audit_time]", dateStr, approveDataFiles[1]);
				FileUtil.replaceAndwriteFile("[supervision_audit_time]", dateStr, approveDataFiles[2]);
				FileUtil.replaceAndwriteFile("[supervision_audit_time]", dateStr, approveDataFiles[3]);				
			} 
		} else if(reviewStage.equals("party_a_audit")) {
			if(approveDataFiles.length == 3) {
				FileUtil.replaceAndwriteFile("[party_a_audit_time]", dateStr, approveDataFiles[2]);
			} else if(approveDataFiles.length == 4) {
				FileUtil.replaceAndwriteFile("[party_a_audit_time]", dateStr, approveDataFiles[2]);
				FileUtil.replaceAndwriteFile("[party_a_audit_time]", dateStr, approveDataFiles[3]);
			} 			
		} else if(reviewStage.equals("team_projdept_audit")) {
			FileUtil.replaceAndwriteFile("[team_projdept_audit_time]", dateStr, approveDataFiles[3]);
		}
    }
    

    @Given("^I recover the drawing review approve data of \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_recover_the_drawing_review_approve_data_of_for(String approveDataPaths, String testCase) throws Throwable {
    	String approveDataFiles[] = approveDataPaths.split(";");
    	if(approveDataFiles.length == 1) {
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[0]);    		
    	} else if(approveDataFiles.length == 2) {
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[0]);
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[1]);
    		FileUtil.replaceAllAndwriteFile("\"supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"supervision_audit\":{\"audit_at\":[supervision_audit_time],\"judgment\"", approveDataFiles[1]);    		
    	} else if(approveDataFiles.length == 3) {
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[0]);
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[1]);
    		FileUtil.replaceAllAndwriteFile("\"supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"supervision_audit\":{\"audit_at\":[supervision_audit_time],\"judgment\"", approveDataFiles[1]);
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[2]);
    		FileUtil.replaceAllAndwriteFile("\"supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"supervision_audit\":{\"audit_at\":[supervision_audit_time],\"judgment\"", approveDataFiles[2]);
    		FileUtil.replaceAllAndwriteFile("\"party_a_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"party_a_audit\":{\"audit_at\":[party_a_audit_time],\"judgment\"", approveDataFiles[2]);
    	} else if(approveDataFiles.length == 4) {
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[0]);
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[1]);
    		FileUtil.replaceAllAndwriteFile("\"supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"supervision_audit\":{\"audit_at\":[supervision_audit_time],\"judgment\"", approveDataFiles[1]);
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[2]);
    		FileUtil.replaceAllAndwriteFile("\"supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"supervision_audit\":{\"audit_at\":[supervision_audit_time],\"judgment\"", approveDataFiles[2]);
    		FileUtil.replaceAllAndwriteFile("\"party_a_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"party_a_audit\":{\"audit_at\":[party_a_audit_time],\"judgment\"", approveDataFiles[2]);
    		FileUtil.replaceAllAndwriteFile("\"spe_supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"", approveDataFiles[3]);
    		FileUtil.replaceAllAndwriteFile("\"supervision_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"supervision_audit\":{\"audit_at\":[supervision_audit_time],\"judgment\"", approveDataFiles[3]);
    		FileUtil.replaceAllAndwriteFile("\"party_a_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"party_a_audit\":{\"audit_at\":[party_a_audit_time],\"judgment\"", approveDataFiles[3]);
    		FileUtil.replaceAllAndwriteFile("\"team_projdept_audit\":\\{\"audit_at\":", ",\"judgment\"", "\"team_projdept_audit\":{\"audit_at\":[team_projdept_audit_time],\"judgment\"", approveDataFiles[3]);
    	}
    }
    
    @When("^I reject the project drawing review request by inputting \"([^\"]*)\" and assign to \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
    public void i_reject_the_project_drawing_review_request_by_inputting_and_assign_to_of_for_of_level_for(String rejectDataPath, String nextReviewer, String env, String testCase, String lvl, String orgId) throws Throwable {
		String form1Title = (String) ScenarioContext.get(testCase + "formTitle");
		String processId = (String) ScenarioContext.get(testCase + "processId");
		String dataFormId = (String) ScenarioContext.get(testCase + "dataFormId");
		String initiateAt = (String) ScenarioContext.get(testCase + "initiateTime");
		String initiator = (String) ScenarioContext.get(testCase + "initiator");
		String reviewerId = nextReviewer.split("-")[0];	
		
		String hostName = GetConfigProperties.getValue(configPath, env);
	    String tokenId = (String)ScenarioContext.get(testCase + "token");
	    String apiPath = "/app_flow/v1/papi/process/project_drawings_create_yc/complete_task/submit/?";
		String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    
		if(lvl.equals("project")) {
		    String projectId = orgId.split(",")[2];
		    String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + teamId + "&project_id=" + projectId
		    		+ "&page_level=" + lvl;
		    String rawtimeStr = String.valueOf(System.currentTimeMillis());
		    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
		    String inputBody = FileUtil.readFile(rejectDataPath).replace("[formName]", "\"name\":\"" + form1Title  + "\"")
		    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", "\"audit_at\":" + timeStr)
		    		.replace("[processId]", "\"process_id\":\"" + processId + "\"")
		    		.replace("[initiateAt]", "\"initiate_at\":\"" + initiateAt + "\"")
		    		.replace("[initiator]", "\"initiator\":" + initiator);
		    log.info(inputBody);
		    
		    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
		    String responseStr = response.print();
		    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		    int commitRslt = (int) responseJson.get("result");
		    Assert.assertEquals(0, commitRslt);	
		} else if (lvl.equals("team")) {
		    String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + teamId + "&page_level=" + lvl;
		    String rawtimeStr = String.valueOf(System.currentTimeMillis());
		    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
		    String inputBody = FileUtil.readFile(rejectDataPath).replace("[formName]", "\"name\":\"" + form1Title  + "\"")
		    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", "\"audit_at\":" + timeStr)
		    		.replace("[processId]", "\"process_id\":\"" + processId + "\"")
		    		.replace("[initiateAt]", "\"initiate_at\":\"" + initiateAt + "\"")
		    		.replace("[initiator]", "\"initiator\":" + initiator);
		    log.info(inputBody);
		    
		    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
		    String responseStr = response.print();
		    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		    int commitRslt = (int) responseJson.get("result");
		    Assert.assertEquals(0, commitRslt);	
		} else if (lvl.equals("group")) {
			String fullApiPath = apiPath + "token=" + tokenId + "&team_id=" + groupId + "&page_level=" + lvl + "&group_id=" + groupId;
		    String rawtimeStr = String.valueOf(System.currentTimeMillis());
		    String timeStr = rawtimeStr.substring(0, 10) + "." + rawtimeStr.substring(10,13);
		    String inputBody = FileUtil.readFile(rejectDataPath).replace("[formName]", "\"name\":\"" + form1Title  + "\"")
		    		.replace("[nextAuditor]", reviewerId).replace("[auditTime]", "\"audit_at\":" + timeStr)
		    		.replace("[processId]", "\"process_id\":\"" + processId + "\"")
		    		.replace("[initiateAt]", "\"initiate_at\":\"" + initiateAt + "\"")
		    		.replace("[initiator]", "\"initiator\":" + initiator).replace("[dataId]", "\"data_id\":\"" + dataFormId + "\"");
		    log.info(inputBody);
		    
		    Response response = RestassureApiCalling.postMethodWithoutCookies(hostName, fullApiPath, inputBody);
		    String responseStr = response.print();
		    JSONObject responseJson = ApiShareSteps.strToJson(responseStr);
		    int commitRslt = (int) responseJson.get("result");
		    Assert.assertEquals(0, commitRslt);	
		}   
    }
    
    @When("^I verify the drawing review process form assigned to \"([^\"]*)\" are in the correct \"([^\"]*)\" because of \"([^\"]*)\" in \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\" level for \"([^\"]*)\"$")
    public void i_verify_the_drawing_review_process_form_assigned_to_are_in_the_correct_because_of_in_of_for_of_level_for(String reviewer1, String processStatus, String result, String reviewStage, String env, String testCase, String lvl, String orgId) throws Throwable {
    	String hostName = GetConfigProperties.getValue(configPath, env);
	    String groupId = orgId.split(",")[0];
	    String teamId = orgId.split(",")[1];
	    String projectId = orgId.split(",")[2]; 
		@SuppressWarnings("unchecked")
		Map<String, String> curCookies = (Map<String, String>) ScenarioContext.get(testCase + "cookies");
		String formId = (String) ScenarioContext.get(testCase + "processFormid");
		
	    String processFormApiPath = "/app_flow/v1/papi/processform/project_drawings_create_yc/detail/get/?operation_def_id=detail&form_id=";
	    String processFormFullApiPath = processFormApiPath + formId + "&form_def_id=project_drawings_create_yc&group_id="
	    		+ groupId + "&team_id=" + teamId + "&project_id=" + projectId + "&page_level=" + lvl;
	    String processFormResponseStr = RestassureApiCalling.getMethodWithCookies(hostName, processFormFullApiPath, curCookies);
	    JSONObject processFormResponseJson = ApiShareSteps.strToJson(processFormResponseStr);
		JSONObject processFormResponseRawDataJson = (JSONObject) processFormResponseJson.get("data");		
		JSONObject processFormResponsedataInfoJson = (JSONObject) processFormResponseRawDataJson.get("data");
		String actProcessStatus = processFormResponsedataInfoJson.getString("process_status");
		Assert.assertEquals(processStatus.split("-")[0], actProcessStatus);
		JSONArray taskArray = processFormResponsedataInfoJson.getJSONArray("tasks");
		JSONObject taskJson = taskArray.getJSONObject(0);
		String nodeInfo =  taskJson.getString("node");
		String nodeName =  taskJson.getString("node_name");
		Assert.assertEquals(processStatus.split("-")[1], nodeInfo);
		Assert.assertEquals(processStatus.split("-")[2], nodeName);
		
		JSONObject processFormFieldInfo = (JSONObject) processFormResponsedataInfoJson.get("f_fields");
		JSONObject rejectStageInfo = (JSONObject) processFormFieldInfo.get(reviewStage);
	    int rejectStatus = rejectStageInfo.getInt("result");
	    Assert.assertEquals(result, String.valueOf(rejectStatus));
	    
    }
}
    
