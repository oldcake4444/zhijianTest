package com.test.InterfaceTest.Pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.test.InterfaceTest.Util.FileUtil;
import com.test.InterfaceTest.Util.GetConfigProperties;
import com.test.InterfaceTest.Util.ScenarioContext;
import com.test.InterfaceTest.WebDriver.WebUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class PageOperations {
	
	Logger log = Logger.getLogger("PageOperations.class");
	WebUtil webUtil = new WebUtil();
	
	@FindBy(how = How.ID, id = "su")
	WebElement frontPageSearchButton;
	private String configPath = "/Configuration/GUI_zhijian.properties";
	
//	protected WebDriver driver;
//	
//	@Before
//    public void setUp() {
//		File file_ie = new File("src/main/resources/webDrivers/IEDriverServer.exe");
//		System.setProperty("webdriver.ie.driver", file_ie.getAbsolutePath());
//		driver = new InternetExplorerDriver();
//    }
//
    @After (value = "@gui")
    public void tearDown(Scenario scenario) {
    	if (scenario.isFailed()) {
    		this.webUtil.closeDriver();
    	}
    }
    
	@Given("^I open URL \"([^\"]*)\"$")
	public void i_open_URL(String urlKey) throws Throwable {
//		driver.get(url);
//		driver.manage().window().maximize();
		String url = GetConfigProperties.getValue(this.configPath, urlKey);
		log.info("Opening " + url);
		this.webUtil.openUrl(url);


	}

	@When("^I Get the title of the website for test case \"([^\"]*)\"$")
	public void i_Get_the_title_of_the_website_for_test_case(String testCase) throws Throwable {
		String title = this.webUtil.getTitle();
		ScenarioContext.put(testCase, title);
	}

	@Then("^Verify the title value is correct as expected \"([^\"]*)\" for test case \"([^\"]*)\"$")
	public void verify_the_title_value_is_correct_as_expected_for_test_case(String expTitle, String testCase) throws Throwable {
		String actTitle = (String)ScenarioContext.get(testCase);
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Then("^Verify whether the \"([^\"]*)\" button can be found in the page$")
	public void verify_whether_the_button_can_be_found_in_the_page(String btnName) throws Throwable {
	    switch(btnName){
	    default:
	    	log.info("can't find the button");
	    	break;
	    case "FrontPageSearch":
	    	log.info(this.webUtil.getAttribute("//input[@type='submit' and @id = 'su']", "value"));
//	    	Assert.assertTrue(frontPageSearchButton.isDisplayed());
	    	Assert.assertTrue(this.webUtil.isElementPresent("//input[@type='submit' and @id = 'su']"));
	    }
	}
	
	@Then("^Quit the driver$")
	public void quit_the_driver() throws Throwable {
	    this.webUtil.closeDriver();
	}
	
	@Then("^Capture the current page and save it as \"([^\"]*)\"$")
	public void capture_the_current_page_and_save_it_as(String rawFileName) throws Throwable {
		File currentScreen = this.webUtil.captureExplorerScreenShot();
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String curTime = df.format(day);
		String fileName =rawFileName + "_" + curTime + ".jpg";
		FileUtil.copyFile(currentScreen, new File(GetConfigProperties.getValue(this.configPath, "screenshot.path") + fileName));
	}
	
//	@Then("^Capture the current page by ghost and save it$")
//	public void capture_the_current_page_by_ghost_and_save_it() throws Throwable {
//	    this.webUtil.captureGhostScreenShot();
//	}
	
	@When("^I input \"([^\"]*)\" into \"([^\"]*)\"$")
	public void i_input_into(String inputContent, String textFieldName) throws Throwable {
		String textFieldXPath = GetConfigProperties.getValue(this.configPath, textFieldName);
		this.webUtil.inputText(inputContent, textFieldXPath);
	}

	@When("^I click button \"([^\"]*)\"$")
	public void i_click_button(String buttonName) throws Throwable {
		String buttonXPath = GetConfigProperties.getValue(this.configPath, buttonName);
		this.webUtil.clickButton(buttonXPath);
	}
	
	@Then("^I verify \"([^\"]*)\" can be found in \"([^\"]*)\"$")
	public void i_verify_can_be_found_in(String expText, String locationName) throws Throwable {
		String locationXPath = GetConfigProperties.getValue(this.configPath, locationName);
	    String actText = this.webUtil.getText(locationXPath);
	    log.info("The actual text is " + actText);
	    Assert.assertEquals(expText, actText);
	}
	
	@Given("^I select \"([^\"]*)\" in dropdown \"([^\"]*)\"$")
	public void i_select_in_dropdown(String targetValue, String dropdownName) throws Throwable {
		String dropDownXPath = GetConfigProperties.getValue(this.configPath, dropdownName);
	    this.webUtil.selectInDropDown(targetValue, dropDownXPath);
	}
	
	@Given("^I click menu \"([^\"]*)\"$")
	public void i_click_menu(String menuName) throws Throwable {
		String menuXPath = GetConfigProperties.getValue(this.configPath, menuName);
		this.webUtil.clickTarget(menuXPath);
	}


}
