package com.test.InterfaceTest.Pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.test.InterfaceTest.Util.FileUtil;
import com.test.InterfaceTest.Util.GetConfigProperties;
import com.test.InterfaceTest.Util.ScenarioContext;
import com.test.InterfaceTest.WebDriver.WebUtil;

import cucumber.api.PendingException;
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
	
	@Given("^I login \"([^\"]*)\" by \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_by_and(String env, String usr, String psw) throws Throwable {
		String url = GetConfigProperties.getValue(this.configPath, env);
		this.webUtil.openUrl(url);
		if (env.equals("prod")) {
			String usrNameXPath = GetConfigProperties.getValue(this.configPath, "prodUsrNameXPath");
			String pswXPath = GetConfigProperties.getValue(this.configPath, "prodUsrPswXPath");
			this.webUtil.inputText(usr, usrNameXPath);
			this.webUtil.inputText(psw, pswXPath);		
			String buttonXPath = GetConfigProperties.getValue(this.configPath, "prodLoginBtn");
			this.webUtil.clickButton(buttonXPath);
		} else if (env.equals("longhu")) {
			String usrNameXPath = GetConfigProperties.getValue(this.configPath, "lhUsrNameXPath");
			String pswXPath = GetConfigProperties.getValue(this.configPath, "lhUsrPswXPath");
			this.webUtil.inputText(usr, usrNameXPath);
			this.webUtil.inputText(psw, pswXPath);		
			String buttonXPath = GetConfigProperties.getValue(this.configPath, "lhLoginBtn");
			this.webUtil.clickButton(buttonXPath);			
		} else if (env.equals("zl")) {
			String usrNameXPath = GetConfigProperties.getValue(this.configPath, "zlUsrNameXPath");
			String pswXPath = GetConfigProperties.getValue(this.configPath, "zlUsrPswXPath");
			this.webUtil.inputText(usr, usrNameXPath);
			this.webUtil.inputText(psw, pswXPath);		
			String buttonXPath = GetConfigProperties.getValue(this.configPath, "zlLoginBtn");
			this.webUtil.clickButton(buttonXPath);
		} else if (env.equals("gzb")) {
			String usrNameXPath = GetConfigProperties.getValue(this.configPath, "gzbUsrNameXPath");
			String pswXPath = GetConfigProperties.getValue(this.configPath, "gzbUsrPswXPath");
			this.webUtil.inputText(usr, usrNameXPath);
			this.webUtil.inputText(psw, pswXPath);		
			String buttonXPath = GetConfigProperties.getValue(this.configPath, "gzbLoginBtn");
			this.webUtil.clickButton(buttonXPath);
		}
	    
	}

	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to_of(String tgtPage) throws Throwable {
		String tgtUrl = GetConfigProperties.getValue(this.configPath, tgtPage);
		this.webUtil.openUrl(tgtUrl);
	}

	@Given("^I search \"([^\"]*)\" in the issue list$")
	public void i_search_in_the_issue_list(String keyWord) throws Throwable {
		String searchFieldXPath = GetConfigProperties.getValue(this.configPath, "模糊搜索");
		this.webUtil.inputText(keyWord, searchFieldXPath);
		String filterButtonXPath = GetConfigProperties.getValue(this.configPath, "筛选按钮");
		this.webUtil.clickButton(filterButtonXPath);
	}

	@Given("^I open the details of issue \"([^\"]*)\"$")
	public void i_open_the_details_of_issue(String issueId) throws Throwable {
	    String issueRawXPath = GetConfigProperties.getValue(this.configPath, "issueLink");
	    String tgtIssueXPath = issueRawXPath.replace("issueId", issueId);
	    this.webUtil.clickButton(tgtIssueXPath);
	    
	}

	@When("^I click the floor plan for the issue$")
	public void i_click_the_floor_plan_for_the_issue() throws Throwable {
		String openFloorPlanXPath = GetConfigProperties.getValue(this.configPath, "查看图纸位置");
		this.webUtil.clickTarget(openFloorPlanXPath);
	}

	@Then("^I verify the floorplan can be shown$")
	public void i_verify_the_floorplan_can_be_shown() throws Throwable {
		String floorPlanXPath = GetConfigProperties.getValue(this.configPath, "问题图纸");
		String floorPlanFilePath = this.webUtil.getAttribute(floorPlanXPath, "src");
		String floorPlanDir = floorPlanFilePath.split("=")[1];
		Assert.assertNotNull(floorPlanDir);
		
		String markerXPath = GetConfigProperties.getValue(this.configPath, "问题标注点");
		this.webUtil.isElementPresent(markerXPath);
	}

	@Then("^I close the pop up window$")
	public void i_close_the_pop_up_windown() throws Throwable {
	    this.webUtil.sendKey(Keys.ESCAPE);
	}

	@When("^I click the picture for the issue$")
	public void i_click_the_picture_for_the_issue() throws Throwable {
		String openPicXPath = GetConfigProperties.getValue(this.configPath, "描述图片链接");
		this.webUtil.clickTarget(openPicXPath);
	}

	@Then("^I vefity the picture can be shown$")
	public void i_vefity_the_picture_can_be_shown() throws Throwable {
		String picPopUp = GetConfigProperties.getValue(this.configPath, "描述图片窗口");
		String picFilePath = this.webUtil.getAttribute(picPopUp, "src");
		String picDir = picFilePath.split("=")[1];
		Assert.assertNotNull(picDir);
	}
	
	@Then("^I close the pop up picture$")
	public void i_close_the_pop_up_picture() throws Throwable {
		String picPopUpClose = GetConfigProperties.getValue(this.configPath, "描述图片窗口关闭");
		this.webUtil.clickTarget(picPopUpClose);
	}

	@Given("^I logout the system for \"([^\"]*)\"$")
	public void i_logout_the_system_for(String env) throws Throwable {
		if (env.equals("zl")) {
			String menuXPath = GetConfigProperties.getValue(this.configPath, "zlCurUsrDropDown");
			this.webUtil.clickTarget(menuXPath);
		} else {
			String menuXPath = GetConfigProperties.getValue(this.configPath, "prodCurUsrDropDown");
			this.webUtil.clickTarget(menuXPath);
		}
		Thread.sleep(1000);
		String logOutXPath = GetConfigProperties.getValue(this.configPath, "prodLogout");
		this.webUtil.clickTarget(logOutXPath);
		Thread.sleep(2000);
	}
	
	@Then("^I search \"([^\"]*)\" verify whether floor plan and desc pic can be shown in issue content and capture the screen shots as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_search_verify_whether_floor_plan_and_desc_pic_can_be_shown_in_issue_content_and_capture_the_screen_shots_as_and(String issueIdList, String fileName1Raw, String fileName2Raw) throws Throwable {
	    String issueId[] = issueIdList.split(";");
	    for(int i = 0; i < issueId.length; i++) {
	    	log.info("Testing issue with id: "+ issueId[i]);
	    	
	    	//search id in the list
			String searchFieldXPath = GetConfigProperties.getValue(this.configPath, "模糊搜索");
			this.webUtil.inputText(issueId[i], searchFieldXPath);
			String filterButtonXPath = GetConfigProperties.getValue(this.configPath, "筛选按钮");
			this.webUtil.clickButton(filterButtonXPath);
			
			//open issue details
			String issueRawXPath = GetConfigProperties.getValue(this.configPath, "issueLink");
			String tgtIssueXPath = issueRawXPath.replace("issueId", issueId[i]);
			
			try {
				this.webUtil.clickButton(tgtIssueXPath);
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
				this.webUtil.clickButton(tgtIssueXPath);;
			}
			
			Thread.sleep(1000);
			
			//check the opened issue is correct
			String openedIssueIdXPath = GetConfigProperties.getValue(this.configPath, "问题编号");
			String openedIssueRawText = this.webUtil.getText(openedIssueIdXPath);
			String openedIssueId = openedIssueRawText.split(" ")[1];
			Assert.assertEquals(issueId[i], openedIssueId);
			
			//open floor plan
			String openFloorPlanXPath = GetConfigProperties.getValue(this.configPath, "查看图纸位置");
			this.webUtil.clickTarget(openFloorPlanXPath);
			
			Thread.sleep(1000);
			
			//capture the screen shot
			File currentScreen1 = this.webUtil.captureExplorerScreenShot();
			FileUtil.saveScreenShotToNewName(currentScreen1, fileName1Raw.replace("issueId", issueId[i]));
			
			//verify the floor plan
			String floorPlanXPath = GetConfigProperties.getValue(this.configPath, "问题图纸");
			String floorPlanFilePath = this.webUtil.getAttribute(floorPlanXPath, "src");
			String floorPlanDir = floorPlanFilePath.split("=")[1];
			Assert.assertNotNull(floorPlanDir);
			String markerXPath = GetConfigProperties.getValue(this.configPath, "问题标注点");
			this.webUtil.isElementPresent(markerXPath);
			
			Thread.sleep(1000);
			
			//close floor plan
			this.webUtil.sendKey(Keys.ESCAPE);
			
			Thread.sleep(1000);
			
			//open desc pic
			String openPicXPath = GetConfigProperties.getValue(this.configPath, "描述图片链接");
			this.webUtil.clickTarget(openPicXPath);
			
			Thread.sleep(1000);
			
			//capture the screen shot
			File currentScreen2 = this.webUtil.captureExplorerScreenShot();
			FileUtil.saveScreenShotToNewName(currentScreen2, fileName2Raw.replace("issueId", issueId[i]));
			
			//verify the desc pic
			String picPopUp = GetConfigProperties.getValue(this.configPath, "描述图片窗口");
			String picFilePath = this.webUtil.getAttribute(picPopUp, "src");
			String picDir = picFilePath.split("=")[1];
			Assert.assertNotNull(picDir);
			
			Thread.sleep(1000);
			
			//close the pic
			String picPopUpClose = GetConfigProperties.getValue(this.configPath, "描述图片窗口关闭");
			this.webUtil.clickTarget(picPopUpClose);
			
			Thread.sleep(1000);
			
			//go back to the issue list
			String returnToList = GetConfigProperties.getValue(this.configPath, "返回问题列表");
			this.webUtil.actionToClick(returnToList);   	
	    }
		
	}

}
