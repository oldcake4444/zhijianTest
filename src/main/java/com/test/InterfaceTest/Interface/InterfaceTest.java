package com.test.InterfaceTest.Interface;

import java.util.logging.Logger;

import org.junit.Assert;

import com.test.InterfaceTest.Util.GetConfigProperties;
import com.test.InterfaceTest.Util.HttpUtil;
import com.test.InterfaceTest.Util.ScenarioContext;
import com.test.InterfaceTest.Util.TextFormat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.sf.json.JSONObject;

public class InterfaceTest {
	
	static Logger log = Logger.getLogger("InterfaceTest.class");
	
	private String configPath = "src/main/resources/Configuration/interface.properties";
	
	@Given("^I call the interface \"([^\"]*)\" for city \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_interface_for_city_for(String interfaceName, String cityCode, String testCase) throws Throwable {
		String urlRaw = GetConfigProperties.getValue(this.configPath, interfaceName);
		String url = urlRaw + cityCode + ".html";
		String returnMsg = HttpUtil.sendGet(url, null);
		ScenarioContext.put(testCase, returnMsg);
	}

	@Then("^Verify city \"([^\"]*)\" \"([^\"]*)\" can be found in the return message for \"([^\"]*)\"$")
	public void verify_city_can_be_found_in_the_return_message_for(String cityName, String cityCode, String testCase) throws Throwable {
		String returnMsg = (String) ScenarioContext.get(testCase);
		JSONObject weatherJson = TextFormat.stringToJsonObj(returnMsg);
		Assert.assertEquals(cityName, weatherJson.getJSONObject("weatherinfo").get("city"));
		Assert.assertEquals(cityCode, weatherJson.getJSONObject("weatherinfo").get("cityid"));
	}
	
	@Given("^I call the webservice interface \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_webservice_interface_for(String interfaceName, String testCase) throws Throwable {
	    
	}
	
	@Given("^I call the interface \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_call_the_interface_for(String interfaceName, String testCase) throws Throwable {
		String url = GetConfigProperties.getValue(this.configPath, interfaceName);
		String returnMsg = HttpUtil.sendGet(url, null);
		log.info(returnMsg);
		ScenarioContext.put(testCase, returnMsg);
	}
}
