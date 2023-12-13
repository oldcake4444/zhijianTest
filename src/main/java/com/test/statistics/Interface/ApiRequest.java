package com.test.statistics.Interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;

import com.jayway.restassured.response.Response;
import com.mysql.jdbc.Statement;
import com.test.Util.ApiShareSteps;
import com.test.Util.GetConfigProperties;
import com.test.Util.RestassureApiCalling;
import com.test.Util.ScenarioContext;
import com.test.db.Util.DbConnector;
import com.test.db.Util.DbQuery;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
		String responseBody = response.print();
				
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
	    
	    JSONObject responseJson = ApiShareSteps.strToJson(response);
	    JSONObject responseData = (JSONObject) responseJson.get("data");
	    JSONObject responseDetails = (JSONObject) responseData.get("detail");
	    
	    ScenarioContext.put(testCase, responseDetails);
    }
    
    @Then("^I verify the return of module issue percentage stat api is the same as the \"([^\"]*)\" in \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_verify_the_return_of_module_issue_percentage_stat_api_is_the_same_as_the_in_for(String queryPath, String env, String testCase) throws Throwable {
    	JSONObject responseDetails = (JSONObject)ScenarioContext.get(testCase);
	    String houseAvrgeIssueStr = responseDetails.getString("house_average_issue");
	    Float houseAvrgeIssue = Float.parseFloat(houseAvrgeIssueStr);
	    String issueRformAvrgeDurationStr = responseDetails.getString("issue_reform_average_duration");
	    Float issueRformAvrgeDuration = Float.parseFloat(issueRformAvrgeDurationStr);
	    String issueAsignOverDue = responseDetails.getString("issue_assign_overdue");
	    String issueChkRatioStr = responseDetails.getString("issue_check_ratio").replace("%", "");
	    Float issueChkRatio = Float.parseFloat(issueChkRatioStr) / 100;    
	    String[]querySet = queryPath.split(";");
	    Connection conn = null;
	    
	    try {
			if (env.equals("prod")) {
				conn = DbConnector.connectToProdDB();
				if (conn != null && !conn.isClosed()) {
					Statement stmt = (Statement) conn.createStatement();

					String query1 = DbQuery.dbQuery(querySet[0]);
					ResultSet rs1 = stmt.executeQuery(query1);
					while (rs1.next()) {
						String queryResult1 = rs1.getString(1);
						Assert.assertTrue(houseAvrgeIssue-0.1<=Float.parseFloat(queryResult1));
						Assert.assertTrue(houseAvrgeIssue+0.1>=Float.parseFloat(queryResult1));
						}
					
					String query2 = DbQuery.dbQuery(querySet[1]);
					ResultSet rs2 = stmt.executeQuery(query2);
					while (rs2.next()) {
						String queryResult2 = rs2.getString(1);
						Assert.assertTrue(issueRformAvrgeDuration-0.1<=Float.parseFloat(queryResult2));
						Assert.assertTrue(issueRformAvrgeDuration+0.1>=Float.parseFloat(queryResult2));
						}	
						
					String query3 = DbQuery.dbQuery(querySet[2]);
					ResultSet rs3 = stmt.executeQuery(query3);
					while (rs3.next()) {
						String queryResult3 = rs3.getString(1);
						Assert.assertEquals(queryResult3, issueAsignOverDue);
						}
					
					String query4 = DbQuery.dbQuery(querySet[3]);
					ResultSet rs4 = stmt.executeQuery(query4);
					while (rs4.next()) {
						String queryResult4 = rs4.getString(1);
						Assert.assertEquals(queryResult4, String.valueOf(issueChkRatio));
						}	
					
					conn.close();
					log.info("Closing Database Connection");
				}
			} else if (env.equals("test")) {
				conn = DbConnector.connectToTestDB();
				if (conn != null && !conn.isClosed()) {
					Statement stmt = (Statement) conn.createStatement();
					String query = DbQuery.dbQuery("query1Path");
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						String a = rs.getString(1);
						String b = rs.getString(2);
						System.out.println(a + ',' + b);
					}
					conn.close();
					log.info("Closing Database Connection");
					
				}
			} 
		} finally {
			conn.close();
			log.info("Closing Database Connection");
		}
	    }
    }