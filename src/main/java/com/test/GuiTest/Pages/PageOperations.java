package com.test.GuiTest.Pages;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.test.GuiTest.WebDriver.WebUtil;
import com.test.Util.CsvHandler;
import com.test.Util.DateUtil;
import com.test.Util.FileUtil;
import com.test.Util.GetConfigProperties;
import com.test.Util.ScenarioContext;
import com.test.Util.TextHandle;

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
	private String configPath = "./src/main/resources/Configuration/GUI_zhijian.properties";
	private String acntConfigPath = "src/main/resources/Configuration/accountName.properties";
	private String acntConfigFullPath = "src/main/resources/Configuration/accountName.properties";
	private String acntRealNameInfo = "src/main/resources/TestData/AcntInfo/acntRealNameInfo.csv";
	
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
	
	@Given("^I am testing in \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_am_testing_in_for(String env, String testCase) throws Throwable {
		ScenarioContext.put(testCase, env);
	}
	
	
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
		} else if (env.equals("test")) {
			String usrNameXPath = GetConfigProperties.getValue(this.configPath, "prodUsrNameXPath");
			String pswXPath = GetConfigProperties.getValue(this.configPath, "prodUsrPswXPath");
			this.webUtil.inputText(usr, usrNameXPath);
			this.webUtil.inputText(psw, pswXPath);		
			String buttonXPath = GetConfigProperties.getValue(this.configPath, "prodLoginBtn");
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
	
	@Given("^I navigate to group statistics page of \"([^\"]*)\" of \"([^\"]*)\" env from front page$")
	public void i_navigate_to_group_statistics_page_of_of_env_from_front_page(String product, String env) throws Throwable {
		if(env.equals("lh") && product.equals("gcjc")) {
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖首页集团入口"));
			Thread.sleep(1000);
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团统计汇总入口"));
			Thread.sleep(1000);
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团工程检查统计入口"));
			Thread.sleep(1000);
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团工程检查统计分析入口"));
			Thread.sleep(1000);
		}

	}
	
	@Given("^I navigate to group statistics page of \"([^\"]*)\" of \"([^\"]*)\" env from group statistics page$")
	public void i_navigate_to_group_statistics_page_of_of_env_from_group_statistics_page(String product, String env) throws Throwable {
		if(env.equals("lh") && product.equals("gxgl")) {
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团工序管理统计入口"));
			Thread.sleep(1000);
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团工序管理统计分析入口"));
			Thread.sleep(1000);
		} else if (env.equals("lh") && product.equals("scsl")) {
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团实测实量统计入口"));
			Thread.sleep(1000);
			this.webUtil.clickTarget(GetConfigProperties.getValue(this.configPath, "龙湖集团实测实量统计分析入口"));
			Thread.sleep(1000);
		}
	}
	
	@Then("^I verify non null \"([^\"]*)\" can be found in the page and the value is larger than zero$")
	public void i_verify_non_null_can_be_found_in_the_page_and_the_value_is_larger_than_zero(String stgStaElement) throws Throwable {
	    if (stgStaElement.equals("工程百平米总问题数")) {
	    	String tgtVal = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工程检查百平米总问题数"));
	    	float tgtNum = Float.parseFloat(tgtVal);
	    	Assert.assertTrue(tgtNum > 0);
	    } else if (stgStaElement.equals("及时整改完结率")) {
	    	String tgtVal = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览及时整改完结率"));
	    	float tgtNum = new Float(tgtVal.substring(0, tgtVal.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum > 0);
	    } else if (stgStaElement.equals("整改完结率")) {
	    	String tgtVal = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览整改完结率"));
	    	float tgtNum = new Float(tgtVal.substring(0, tgtVal.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum > 0);
	    } else if (stgStaElement.equals("工序一次验收合格率")) {
	    	String tgtVal = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工序管理一次验收合格率"));
	    	float tgtNum = new Float(tgtVal.substring(0, tgtVal.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum > 0);
	    } else if (stgStaElement.equals("实测合格率")) {
	    	String tgtVal = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览实测合格率"));
	    	float tgtNum = new Float(tgtVal.substring(0, tgtVal.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum > 0);
	    }
	}
	
	@Then("^I verify the group overall statistics data for \"([^\"]*)\" days can be found for gcjc$")
	public void i_verify_the_group_overall_statistics_data_for_days_can_be_found_for_gcjc(String dayStr) throws Throwable {
		ArrayList<String> dayList = DateUtil.getPreDay(3);
		for(int i = 0; i < dayList.size(); i++) {
	    	String tgtVal1 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工程检查日期百平米总问题").replace("MMdd", dayList.get(i)));
	    	float tgtNum1 = Float.parseFloat(tgtVal1); 
	    	Assert.assertTrue(tgtNum1 > 0);
	    	
	    	String tgtVal2 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工程检查日期及时整改完结率").replace("MMdd", dayList.get(i)));
	    	float tgtNum2 = new Float(tgtVal2.substring(0, tgtVal2.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum2 > 0);
	    	
	    	String tgtVal3 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工程检查日期整改完结率").replace("MMdd", dayList.get(i)));
	    	float tgtNum3 = new Float(tgtVal3.substring(0, tgtVal3.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum3 > 0);
		}
	}
	
	@Then("^I verify the group overall statistics data for \"([^\"]*)\" days can be found for gxgl$")
	public void i_verify_the_group_overall_statistics_data_for_days_can_be_found_for_gxgl(String dayStr) throws Throwable {
		ArrayList<String> dayList = DateUtil.getPreDay(3);
		for(int i = 0; i < dayList.size(); i++) {
	    	String tgtVal1 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工序管理日期一次验收合格率").replace("MMdd", dayList.get(i)));
	    	float tgtNum1 = new Float(tgtVal1.substring(0, tgtVal1.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum1 > 0);
	    	
	    	String tgtVal2 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工序管理日期及时整改完结率").replace("MMdd", dayList.get(i)));
	    	float tgtNum2 = new Float(tgtVal2.substring(0, tgtVal2.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum2 > 0);
	    	
	    	String tgtVal3 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览工序管理日期整改完结率").replace("MMdd", dayList.get(i)));
	    	float tgtNum3 = new Float(tgtVal3.substring(0, tgtVal3.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum3 > 0);
	    	
		}
	}
		
	@Then("^I verify the group overall statistics data for \"([^\"]*)\" days can be found for scsl$")
	public void i_verify_the_group_overall_statistics_data_for_days_can_be_found_for_scsl(String dayStr) throws Throwable {
		ArrayList<String> dayList = DateUtil.getPreDay(3);
		for(int i = 0; i < dayList.size(); i++) {
	    	String tgtVal1 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览实测实量日期实测合格率").replace("MMdd", dayList.get(i)));
	    	float tgtNum1 = new Float(tgtVal1.substring(0, tgtVal1.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum1 > 0);
	    	
	    	String tgtVal2 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览实测实量日期及时整改完结率").replace("MMdd", dayList.get(i)));
	    	float tgtNum2 = new Float(tgtVal2.substring(0, tgtVal2.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum2 > 0);
	    	
	    	String tgtVal3 = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, "集团总览实测实量日期整改完结率").replace("MMdd", dayList.get(i)));
	    	float tgtNum3 = new Float(tgtVal3.substring(0, tgtVal3.indexOf("%"))) / 100;
	    	Assert.assertTrue(tgtNum3 > 0);
	    	
	    	log.info(tgtVal1);
	    	log.info(tgtVal2);
	    	log.info(tgtVal3);
	    	
		}
	}
	
	@When("^I click usr management link for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_click_usr_management_link_for_for(String lvlName, String testCase) throws Throwable {
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "人员管理集团页面通用层级").replace("<lvlName>", lvlName));
	}
	
	@When("^I expand the project list of \"([^\"]*)\" in usr management page for \"([^\"]*)\"$")
	public void i_expand_the_project_list_of_in_usr_management_page_for(String comName, String testCase) throws Throwable {
		this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "人员管理集团页面公司下拉").replace("<comName>", comName));;
	}
	
	@When("^I click the link for \"([^\"]*)\" in \"([^\"]*)\" env$")
	public void i_click_the_link_for_in_env(String btnName, String env) throws Throwable {
		if (btnName.equals("新增人员")) {
			this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, env + "人员管理新增人员"));
		}
		
	}
	
	@When("^I input \"([^\"]*)\" to create \"([^\"]*)\" new accounts in \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_input_to_create_new_accounts_in_for(String usrInfo, String nostr, String env, String testCase) throws Throwable {
		String finalAcntName = null;
		String finalAcntNameFromConfig = GetConfigProperties.getValue(this.acntConfigPath, env + "AcntName");
		String finalAcntNameFromMem = null;
		finalAcntNameFromMem = (String) ScenarioContext.get(env + "LatestAcntName");
		if (finalAcntNameFromMem == null || finalAcntNameFromMem.isEmpty()) {
			finalAcntNameFromMem = finalAcntNameFromConfig.substring(0, Integer.valueOf(GetConfigProperties.getValue(this.acntConfigPath, "nameLen"))) + "0";
		}
	
		int finalAcntNameSeqFromConfig = Integer.valueOf(finalAcntNameFromConfig.substring(Integer.valueOf(GetConfigProperties.getValue(this.acntConfigPath, "nameLen")), finalAcntNameFromConfig.length()));
		int finalAcntNameSeqFromMem =  Integer.valueOf(finalAcntNameFromMem.substring(Integer.valueOf(GetConfigProperties.getValue(this.acntConfigPath, "nameLen")), finalAcntNameFromMem.length()));
		
		HashMap<String, String> acntNameInfo = new HashMap<String, String>();
		
		if(finalAcntNameSeqFromConfig <= finalAcntNameSeqFromMem) {
			for (int i = 1; i <= Integer.valueOf(nostr); i++) {
			    String usrInfoList[] = usrInfo.split(",");
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "人员管理新增人员"));
			    Thread.sleep(1000);
			    
			    String acntNamePart1 = finalAcntNameFromMem.substring(0, Integer.valueOf(GetConfigProperties.getValue(this.acntConfigPath, "nameLen")));
			    String acntNamePart2 = String.valueOf(Integer.valueOf(finalAcntNameFromMem.substring(Integer.valueOf(GetConfigProperties.getValue(this.acntConfigPath, "nameLen")), finalAcntNameFromMem.length())) + i);
			    String acntName = acntNamePart1+ acntNamePart2;
			    String rawRealNameWithoutSeq = GetConfigProperties.getValue(this.acntConfigPath, "realName");
			    String realName = rawRealNameWithoutSeq + acntNamePart2;
			    
			    this.webUtil.inputText(acntName, GetConfigProperties.getValue(this.configPath, "新增人员用户名"));
			    this.webUtil.inputText(GetConfigProperties.getValue(this.acntConfigPath, "password"), GetConfigProperties.getValue(this.configPath, "新增人员密码"));
			    this.webUtil.inputText(realName, GetConfigProperties.getValue(this.configPath, "新增人员真实姓名"));
			    this.webUtil.inputText(usrInfoList[3], GetConfigProperties.getValue(this.configPath, "新增人员手机号码"));
			    this.webUtil.inputText(usrInfoList[4], GetConfigProperties.getValue(this.configPath, "新增人员邮箱地址"));
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员人员角色下拉"));
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员角色选择").replace("<角色名>", usrInfoList[5]));
			    Thread.sleep(1000);
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员手机"));
			    Thread.sleep(1000);
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员确定"));	
			    Thread.sleep(2000);
			    finalAcntName = acntName;
			    log.info(finalAcntName);
			    ScenarioContext.put(env + i, finalAcntName);
			    ScenarioContext.put(env + i + "realName", realName);
			    
			    acntNameInfo.put(acntName, realName);
			}
			
		} else {
			for (int i = 1; i <= Integer.valueOf(nostr); i++) {
			    String usrInfoList[] = usrInfo.split(",");
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "人员管理新增人员"));
			    Thread.sleep(1000);
			    this.webUtil.inputText(TextHandle.getNewAcntName(this.acntConfigPath, this.acntConfigFullPath, i, env)[0], GetConfigProperties.getValue(this.configPath, "新增人员用户名"));
			    this.webUtil.inputText(GetConfigProperties.getValue(this.acntConfigPath, "password"), GetConfigProperties.getValue(this.configPath, "新增人员密码"));
			    this.webUtil.inputText(TextHandle.getNewAcntName(this.acntConfigPath, this.acntConfigFullPath, i, env)[1], GetConfigProperties.getValue(this.configPath, "新增人员真实姓名"));
			    this.webUtil.inputText(usrInfoList[3], GetConfigProperties.getValue(this.configPath, "新增人员手机号码"));
			    this.webUtil.inputText(usrInfoList[4], GetConfigProperties.getValue(this.configPath, "新增人员邮箱地址"));
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员人员角色下拉"));
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员角色选择").replace("<角色名>", usrInfoList[5]));
			    Thread.sleep(1000);
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员手机"));
			    Thread.sleep(1000);
			    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员确定"));	
			    Thread.sleep(2000);
			    finalAcntName = TextHandle.getNewAcntName(this.acntConfigPath, this.acntConfigFullPath, i, env)[0];
			    ScenarioContext.put(env + i, finalAcntName);
			    String realName = TextHandle.getNewAcntName(this.acntConfigPath, this.acntConfigFullPath, i, env)[1];
			    ScenarioContext.put(env + i + "realName", realName);
			    
			    acntNameInfo.put(finalAcntName, realName);
			}
		}
		
		CsvHandler.writeCsv(this.acntRealNameInfo, acntNameInfo, ";");
		
		//log.info(finalAcntName);
		TextHandle.updatePropAcntName(this.acntConfigPath, this.acntConfigFullPath, finalAcntName, env);
		ScenarioContext.put(env + "LatestAcntName", finalAcntName);
		Thread.sleep(3000);
	}
	
	@When("^I search \"([^\"]*)\" and add accounts to project as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_search_and_add_accounts_to_project_as_for(String keyWord, String roleName, String testCase) throws Throwable {
	    this.webUtil.inputText(keyWord, GetConfigProperties.getValue(this.configPath, "新增人员搜索输入"));
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员搜索确定"));
	    Thread.sleep(3000);
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员搜索全选"));
	    Thread.sleep(1000);
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员搜索添加"));
	    Thread.sleep(1000);
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员搜索角色下拉"));
	    Thread.sleep(1000);
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员搜索角色选择").replace("<角色名>", roleName));
	    Thread.sleep(1000);
	    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员搜索添加确定"));
	}
	
	@When("^I go to \"([^\"]*)\" page for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_go_to_page_for_for(String tgtPage, String grpId, String testCase) throws Throwable {
		String env = (String)ScenarioContext.get(testCase);
		String rawTgtUrl = GetConfigProperties.getValue(this.configPath, env) + GetConfigProperties.getValue(this.configPath, tgtPage);
		String tgtUrl = rawTgtUrl.replace("<groupId>", grpId);
		log.info(tgtUrl);
		this.webUtil.openUrl(tgtUrl);
	}
	
	@When("^I login with \"([^\"]*)\" by \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_login_with_by_and_for(String enterpriseId, String usr, String psw, String testCase) throws Throwable {
		String env = (String)ScenarioContext.get(testCase);
		String envIndex = GetConfigProperties.getValue(this.configPath, env);
		this.webUtil.openUrl(envIndex);
		if (env.equals("prod") || env.equals("regression") || env.startsWith("test")) {
			String usrNameXPath = GetConfigProperties.getValue(this.configPath, "prodUsrNameXPath");
			String pswXPath = GetConfigProperties.getValue(this.configPath, "prodUsrPswXPath");
			String enterpriseIdXPath = GetConfigProperties.getValue(this.configPath, "prodEnterpriseIdXPath");
			this.webUtil.inputText(usr, usrNameXPath);
			this.webUtil.inputText(psw, pswXPath);
			this.webUtil.inputText(enterpriseId, enterpriseIdXPath);
			String buttonXPath = GetConfigProperties.getValue(this.configPath, "prodLoginBtn");
			this.webUtil.clickButton(buttonXPath);
		}
	}
	
	
	@When("^I click the link for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_click_the_link_for_for(String btnName, String testCase) throws Throwable {
		this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, btnName));
	}
	
	@When("^I create accounts from file \"([^\"]*)\" in \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_create_accounts_from_file_in_for(String usrInfoPath, String tgtEnv, String testCase) throws Throwable {
		String env = (String)ScenarioContext.get(testCase);
		int acntCnt = CsvHandler.getCsvRow(usrInfoPath, ",");
		for(int i = 1; i <= acntCnt; i++) {
			String[] acntInfo = CsvHandler.readFromCsvByRow(usrInfoPath, ",", i);
			String acntName = acntInfo[1];
			String passWord = acntInfo[2];
			String realName = acntInfo[3];
			String phone = acntInfo[4];
			String email = acntInfo[5];
			String role = acntInfo[6];
		    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "人员管理新增人员"));
		    Thread.sleep(1000);
		    this.webUtil.inputText(acntName, GetConfigProperties.getValue(this.configPath, "新增人员用户名"));
		    this.webUtil.inputText(passWord, GetConfigProperties.getValue(this.configPath, "新增人员密码"));
		    this.webUtil.inputText(realName, GetConfigProperties.getValue(this.configPath, "新增人员真实姓名"));
		    this.webUtil.inputText(phone, GetConfigProperties.getValue(this.configPath, "新增人员手机号码"));
		    this.webUtil.inputText(email, GetConfigProperties.getValue(this.configPath, "新增人员邮箱地址"));
		    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员人员角色下拉"));
		    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员角色选择").replace("<角色名>", role));
		    Thread.sleep(1000);
		    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员手机"));
		    Thread.sleep(1000);
		    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员确定"));	
		    Thread.sleep(1000);
		    if(this.webUtil.isElementPresentNoException(GetConfigProperties.getValue(this.configPath, "用户名重复信息"))) {
		    	log.info("用户名已存在");
		    	this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增人员取消"));
		    	Thread.sleep(2000);
		    }
		}
		
	}
	
	
	@When("^I click the link in organization management page for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_click_the_link_in_organization_management_page_for_for(String comName, String testCase) throws Throwable {
		this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "公司名").replace("<comName>", comName));;
	}

	@When("^I click the link for \"([^\"]*)\" and input project info from file \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_click_the_link_for_and_input_project_info_from_file_for(String btnName, String projInfoPath, String testCase) throws Throwable {
		int projCnt = CsvHandler.getCsvRow(projInfoPath, ",");
		for(int i = 1; i <= projCnt; i++) {
			this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, btnName));
			String[] projInfo = CsvHandler.readFromCsvByRow(projInfoPath, ",", i);
			String projName = projInfo[0];
			String projSquare = projInfo[1];
//			String projectType = projInfo[2];
//			String leadContractorName = projInfo[3];
//			String supervisorName = projInfo[4];
//			String remark = projInfo[5];
			this.webUtil.inputText(projName, GetConfigProperties.getValue(this.configPath, "新增项目名"));
		    this.webUtil.inputText(projSquare, GetConfigProperties.getValue(this.configPath, "新增项目面积"));
//		    this.webUtil.inputText(projectType, GetConfigProperties.getValue(this.configPath, "新增项目类型"));
//		    this.webUtil.inputText(leadContractorName, GetConfigProperties.getValue(this.configPath, "新增项目总包名称"));
//		    this.webUtil.inputText(supervisorName, GetConfigProperties.getValue(this.configPath, "新增项目监理名称"));
//		    this.webUtil.inputText(remark, GetConfigProperties.getValue(this.configPath, "新增项目概括描述"));
		    this.webUtil.actionToClick(GetConfigProperties.getValue(this.configPath, "新增项目确定"));
		    Thread.sleep(1000);
		}
		
	}

	@When("^I open the house pofessional report page of \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_open_the_house_pofessional_report_page_of_and_and_and_and_for(String groupId, String teamId, String projectId, String taskId, String houseId, String testCase) throws Throwable {
		String token = (String) ScenarioContext.get(testCase + "token");
		String url = "https://zj.buildingqm.com/public/app3/houseqm3/inspection_report.html?token="
				+ token + "&group_id=" + groupId + "&team_id=" + teamId + "&project_id=" + projectId
				+ "&task_id=" + taskId + "&house_id=" + houseId + "#/";
		this.webUtil.openUrl(url);
		Thread.sleep(2000);
		// this.webUtil.toggleDeviceToolBar();		
		
	}
	
	@Then("^I verify \"([^\"]*)\" can be found on the page and the summary contains \"([^\"]*)\"$")
	public void i_verify_can_be_found_on_the_page_and_the_summary_contains(String h5ElementPath, String summaryInfo) throws Throwable {
	    this.webUtil.isElementPresent(GetConfigProperties.getValue(this.configPath, h5ElementPath));
	    String summary = this.webUtil.getText(GetConfigProperties.getValue(this.configPath, h5ElementPath));
	    Assert.assertTrue(summary.contains(summaryInfo));
	}
	
	@Then("^I verify button \"([^\"]*)\" can be found on the page$")
	public void i_verify_button_can_be_found_on_the_page(String buttonElementPath) throws Throwable {
		this.webUtil.isElementPresent(GetConfigProperties.getValue(this.configPath, buttonElementPath));
	}



}
