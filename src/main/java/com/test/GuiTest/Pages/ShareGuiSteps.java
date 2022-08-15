package com.test.GuiTest.Pages;

import java.io.File;
import java.util.logging.Logger;

import org.junit.Assert;

import com.test.GuiTest.WebDriver.WebUtil;
import com.test.Util.ApiShareSteps;
import com.test.Util.GetConfigProperties;
import com.test.Util.RestassureApiCalling;
import com.test.Util.ScenarioContext;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.json.JSONObject;

public class ShareGuiSteps {

	
	Logger log = Logger.getLogger("ShareGuiSteps.class");
	WebUtil webUtil = new WebUtil();
	
	private String configPath = "/Configuration/AppApi_zhijian.properties";

	


}
