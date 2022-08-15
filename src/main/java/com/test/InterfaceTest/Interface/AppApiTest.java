package com.test.InterfaceTest.Interface;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Assert;

import com.test.Util.ApiShareSteps;
import com.test.Util.CsvHandler;
import com.test.Util.GetConfigProperties;
import com.test.Util.HttpUtil;
import com.test.Util.RestassureApiCalling;
import com.test.Util.ScenarioContext;
import com.test.Util.TextFormat;

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
	    ScenarioContext.put("loginInfo", response);
	    ScenarioContext.put("deviceId", device_id);
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
	    String apiParmName4 = apiParmList[3]; 
	    
	    for(int i = 1; i <= Integer.valueOf(usrCount); i++) {
	    	String usrName = (String)ScenarioContext.get(env + i);
	    	String fullApiPath = apiPath + apiParmName1 + "=" + device_id + "&" + apiParmName4 + "=" + GetConfigProperties.getValue(this.acntConfigPath, "enterpriseId")  + "&" + apiParmName2 + "=" + GetConfigProperties.getValue(this.acntConfigPath, "password") + "&" + apiParmName3 + "=" + usrName ;
	    	log.info(hostName+fullApiPath);
	    	String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    	ScenarioContext.put(testCase + env + String.valueOf(i), response);
	    	Thread.sleep(2000);
	    }
	    
	}
	
	@When("^I call the login api for the \"([^\"]*)\" with \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_login_api_for_the_with_for(String usrInfoPath, String apiParms, String testCase) throws Throwable {
		String env = (String)ScenarioContext.get(testCase);
		String hostName = GetConfigProperties.getValue(configPath, env);
		String apiPath = GetConfigProperties.getValue(configPath, "login");
		String device_id = ApiShareSteps.deviceIdGenerator();
	    String[]apiParmList = apiParms.split(";");
	    String apiParmName1 = apiParmList[0];
	    String apiParmName2 = apiParmList[1];
	    String apiParmName3 = apiParmList[2];
	    String apiParmName4 = apiParmList[3]; 
	    
		int acntCnt = CsvHandler.getCsvRow(usrInfoPath, ",");
		for(int i = 1; i <= acntCnt; i++) {
			String[] acntInfo = CsvHandler.readFromCsvByRow(usrInfoPath, ",", i);
			String acntName = acntInfo[1];
			String passWord = acntInfo[2];
			String grpCode = acntInfo[7];
	    	String fullApiPath = apiPath + apiParmName1 + "=" + device_id + "&" + apiParmName4 + "=" + grpCode  + "&" + apiParmName2 + "=" + passWord + "&" + apiParmName3 + "=" + acntName;
	    	log.info(hostName+fullApiPath);
	    	String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    	ScenarioContext.put(testCase + acntName, response);
	    	Thread.sleep(2000);
		}
			
	}
	
	@Then("^Verify the response of the login api is the same as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_response_of_the_login_api_is_the_same_as_for(String usrInfoPath, String testCase) throws Throwable {
		int acntCnt = CsvHandler.getCsvRow(usrInfoPath, ",");
		for(int i = 1; i <= acntCnt; i++) {
			String[] acntInfo = CsvHandler.readFromCsvByRow(usrInfoPath, ",", i);
			String acntName = acntInfo[1];
			String realName = acntInfo[3];
			String phone = acntInfo[4];
			String email = acntInfo[5];
			String grpCode = acntInfo[7];
			
			String response = (String) ScenarioContext.get(testCase + acntName);
			JSONObject responseJson = ApiShareSteps.strToJson(response);
			String callResult = responseJson.getString("result").toString();
			
			Assert.assertEquals("0", callResult);
		    String callMsg = responseJson.getString("message").toString();
		    Assert.assertEquals("登录成功", callMsg);
		    
		    JSONObject responseData = (JSONObject) responseJson.get("data");
		    JSONObject usrData = (JSONObject) responseData.get("user");		    
		    String tokenId = (String) responseData.get("token");
		    ScenarioContext.put(testCase + acntName + "tokenId", tokenId);
		    
		    Assert.assertEquals(email, usrData.get("email"));
		    Assert.assertEquals(phone, usrData.get("mobile"));
		    Assert.assertEquals(realName, usrData.get("real_name"));
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
	
	
	@When("^I call the GetSquadMembers api of \"([^\"]*)\" of \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_GetSquadMembers_api_of_of_for(String env, String taskId, String testCase) throws Throwable {
		String hostName = GetConfigProperties.getValue(configPath, env);
		
		String device_id = (String) ScenarioContext.get("deviceId");
		
		String loginResponse = (String) ScenarioContext.get("loginInfo");
		JSONObject responseJson = ApiShareSteps.strToJson(loginResponse);
	    JSONObject responseData = (JSONObject) responseJson.get("data");	    
	    String tokenId = (String) responseData.get("token");
	    
	    String apiPath = GetConfigProperties.getValue(configPath, "getSquadMembers");
	    String fullApiPath = apiPath + "device_id=" + device_id + "&task_ids=" + taskId + "&token=" + tokenId;
	    log.info(hostName+fullApiPath);
	    
	    String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    
	    ScenarioContext.put(testCase, response);
	}

	@Then("^I verify the squad members of \"([^\"]*)\" are correct as \"([^\"]*)\" for \"([^\"]*)\" of \"([^\"]*)\"$")
	public void i_verify_the_squad_members_of_are_correct_as_for_of(String taskId, String squadInfoPath, String testCase, String env) throws Throwable {
		String SquadInfoResponse = (String) ScenarioContext.get(testCase);
		JSONObject responseJson = ApiShareSteps.strToJson(SquadInfoResponse);
		JSONObject responseData = (JSONObject) responseJson.get("data");	    
		JSONArray squadList = (JSONArray) responseData.get("squad_list");
		JSONArray memList = (JSONArray) responseData.get("member_list");
		
		ArrayList<String> expSquadRawList = CsvHandler.readFromCsv(squadInfoPath, ";");	
		
		int expSquadMemCount = 0;
		int actSquadSize = 0;
		int actMemCount = 0;
		for(int i = 0; i < expSquadRawList.size(); i++) {
			String expSquadRawInfo[] = expSquadRawList.get(i).split("-");
			String expSquadId = expSquadRawInfo[0];
			String expSquadName = expSquadRawInfo[1];
			String expSquadType = expSquadRawInfo[2];
			String[] expSquadMemList = expSquadRawInfo[3].split(",");
			String expCantAprlMemRaw = expSquadRawInfo[4];
			String expCantAprlMem = null;
			if(expCantAprlMemRaw.equals("null")) {
				expCantAprlMem = null;
			} else {
				expCantAprlMem = expCantAprlMemRaw;
			}
			
			for(int j = 0; j < squadList.size(); j++) {				
				JSONObject squadInfo = (JSONObject) squadList.get(j);
				String actSquadId = squadInfo.get("id").toString();
				String actSquadName = squadInfo.get("name").toString();
				String actSquadTaskId = squadInfo.get("task_id").toString();
				String actSquadType = squadInfo.get("squad_type").toString();
				
				if (squadInfo.get("delete_at").toString().equals("0") && actSquadTaskId.equals(taskId) && actSquadId.equals(expSquadId)) {
					actSquadSize++;
					Assert.assertEquals(expSquadName, actSquadName);
					Assert.assertEquals(expSquadType, actSquadType);
					
					for(int k = 0; k < memList.size(); k++) {
						JSONObject squadMemInfo = (JSONObject) memList.get(k);
						String memSquadId = squadMemInfo.get("squad_id").toString();
						String usrId = squadMemInfo.get("user_id").toString();
						String memCanApvl = squadMemInfo.get("can_approve").toString();
						String squadTaskId = squadMemInfo.get("task_id").toString();
						String memRoleType = squadMemInfo.get("role_type").toString();
						
						for(int l = 0; l < expSquadMemList.length; l++) {
							if(squadInfo.get("delete_at").toString().equals("0") && memSquadId.equals(expSquadId) && squadTaskId.equals(taskId) && usrId.equals(expSquadMemList[l])) {
								actMemCount++;
								
								Assert.assertEquals(expSquadType, memRoleType);
								
								if (actSquadType.equals("10")) {
									if(usrId.equals(expCantAprlMem)) {
										Assert.assertEquals("20", memCanApvl);
									} else {
										Assert.assertEquals("10", memCanApvl);
									}
									
								} else {
									Assert.assertEquals("20", memCanApvl);
								}

							}
						}

					}
				}
				

			}
			expSquadMemCount = expSquadMemCount + expSquadMemList.length;
		}
		
		Assert.assertEquals(expSquadRawList.size(), actSquadSize);
		Assert.assertEquals(expSquadMemCount, actMemCount);
		
	}
	
	@When("^I call the GetUsrOrg api of \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_GetUsrOrg_api_of_for(String env, String testCase) throws Throwable {
		String hostName = GetConfigProperties.getValue(configPath, env);
		
		String device_id = (String) ScenarioContext.get("deviceId");
		
		String loginResponse = (String) ScenarioContext.get("loginInfo");
		JSONObject responseJson = ApiShareSteps.strToJson(loginResponse);
	    JSONObject responseData = (JSONObject) responseJson.get("data");	    
	    String tokenId = (String) responseData.get("token");
	    
	    String apiPath = GetConfigProperties.getValue(configPath, "GetUsrOrg");
	    String fullApiPath = apiPath + "device_id=" + device_id + "&timestamp=0" + "&token=" + tokenId;
	    log.info(hostName+fullApiPath);
	    
	    String response = RestassureApiCalling.getMethod(hostName, fullApiPath);
	    
	    ScenarioContext.put(testCase, response);
	}

	@Then("^Verify the related product list is expected as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_related_product_list_is_expected_as_for(String expProductInfoPath, String testCase) throws Throwable {
	    ArrayList<String> expAppInfoRawList = CsvHandler.readFromCsv(expProductInfoPath, ";");	
	    log.info(String.valueOf(expAppInfoRawList.size()));
	    
		String relatedProductInfoResponse = (String) ScenarioContext.get(testCase);
		JSONObject responseJson = ApiShareSteps.strToJson(relatedProductInfoResponse);
	    JSONObject responseData = (JSONObject) responseJson.get("data");
	    JSONArray appsArray = (JSONArray) responseData.get("apps");
	    int appsNum = appsArray.size();
	    
	    Assert.assertEquals(expAppInfoRawList.size(), appsNum);
	    for(int i = 0; i < appsNum; i++) {
	    	JSONObject responseApp = (JSONObject)appsArray.getJSONObject(i);
	    	String actAppId = responseApp.getString("app_id");
	    	String actAppName = responseApp.getString("app_name");
	    	String actAppRealName = responseApp.getString("name");
	    	String actAppLogo = responseApp.getString("logo");
	    	String actAppType = responseApp.getString("app_type");
	    	String actAppGrpUrl = responseApp.getString("app_org_url");
	    	String actAppComUrl = responseApp.getString("app_company_url");
	    	String actAppProjUrl = responseApp.getString("app_project_url");
	    	String actAppFoloUrl = responseApp.getString("follow_url");
	    	

			String expAppRawInfo[] = expAppInfoRawList.get(i).split(",");
			Assert.assertEquals(expAppRawInfo[0], actAppId);
			Assert.assertEquals(expAppRawInfo[1], actAppName);
			Assert.assertEquals(expAppRawInfo[2], actAppRealName);
			Assert.assertEquals(expAppRawInfo[3], actAppLogo);
			Assert.assertEquals(expAppRawInfo[4], actAppType);
			Assert.assertEquals(expAppRawInfo[5], actAppGrpUrl);
			Assert.assertEquals(expAppRawInfo[6], actAppComUrl);
			Assert.assertEquals(expAppRawInfo[7], actAppProjUrl);
			Assert.assertEquals(expAppRawInfo[8], actAppFoloUrl);

			log.info("循环了第" + String.valueOf(i) + "次");
				

	    }
	    

		

//			String expSquadRawInfo[] = expSquadRawList.get(i).split("-");
//			String expSquadId = expSquadRawInfo[0];
//			String expSquadName = expSquadRawInfo[1];
//			String expSquadType = expSquadRawInfo[2];
//			String[] expSquadMemList = expSquadRawInfo[3].split(",");
//			String expCantAprlMemRaw = expSquadRawInfo[4];
//			String expCantAprlMem = null;
	    
	    

	}

	@Then("^Verify the related group info is expected as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_related_group_info_is_expected_as_for(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the related company info is expected as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_related_company_info_is_expected_as_for(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the related project info is expected as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_related_project_info_is_expected_as_for(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the follow app info is expected as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_follow_app_info_is_expected_as_for(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^I call app login api of \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_app_login_api_of_with_and_for_for(String env, String usr, String psw, String grpCode, String testCase) throws Throwable {
		String usrName = null;
		if(usr.contains("-")) {
			usrName = usr.split("-")[1];
		} else {
			usrName = usr;
		}		
        String appHostName = GetConfigProperties.getValue(configPath, env);
		String device_id = ApiShareSteps.deviceIdGenerator();	    
	    String appApiPath = GetConfigProperties.getValue(configPath, "appLogin");
	    String fullApiPath = appApiPath + "device_id=" + device_id + "&group_code=" + grpCode + "&password=" + psw + "&source=" + "&username=" + usrName + "&verify_code=";
	    
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
	}



}
