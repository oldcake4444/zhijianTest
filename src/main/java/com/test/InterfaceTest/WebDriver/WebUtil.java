package com.test.InterfaceTest.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {
	
	static Logger log = Logger.getLogger("WebUtil.class");
	
	//protected WebDriver driver = SelectBrowser.selectIE();
	protected WebDriver driver = SelectBrowser.selectChrome();
	//protected ScreenCaptureHtmlUnitDriver driver = SelectBrowser.selectGhost();
	//protected WebDriver driver = SelectBrowser.selectChromeHeadless();
	
	public Boolean isElementPresent(String xPath) throws InterruptedException {
		By path = By.xpath(xPath); 
		Boolean elementExist = false;
		WebElement e = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(path));
		if(e.isDisplayed()) {
			elementExist = true;
		}
		return elementExist;
	}
	
	public void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String getText(String xPath) throws InterruptedException {
		By path = By.xpath(xPath);
		String text = null;
		if (this.isElementPresent(xPath)) {
			text = driver.findElement(path).getText();
		}
		return text;
	}
	
	public String getAttribute(String xPath, String attrName) throws InterruptedException {
		By path = By.xpath(xPath);
		String attribute = null;
		if (this.isElementPresent(xPath)) {
			attribute = driver.findElement(path).getAttribute(attrName);
		}
		return attribute;
	}
	
	public File captureExplorerScreenShot() {
		File img = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		return img;
	}
	
//	public File captureGhostScreenShot() throws IOException {	
//		byte[] zipFileBytes = ((ScreenCaptureHtmlUnitDriver) driver).getScreenshotAs(OutputType.BYTES);
//		FileUtils.writeByteArrayToFile(new File("D:\\te"), zipFileBytes);
//		return null;
//	}
//	

	public void clickButton(String buttonNameXPath) throws InterruptedException {
		By path = By.xpath(buttonNameXPath);
		if (this.isElementPresent(buttonNameXPath)) {
			driver.findElement(path).click();
		}
	}
	
	public void inputText(String inputContent, String textFieldXPath) throws InterruptedException {
		By path = By.xpath(textFieldXPath);
		if (this.isElementPresent(textFieldXPath)) {
			//Actions action = new Actions (driver);
			driver.findElement(path).clear();
			driver.findElement(path).sendKeys(inputContent);
		}
	}
	
	public void selectInDropDown(String targetVal, String dropDownXPath) throws InterruptedException {
		By path = By.xpath(dropDownXPath);
		if (this.isElementPresent(dropDownXPath)) {			
			Select select = new Select(driver.findElement(path));
			select.selectByValue(targetVal);
		}
		
	}
	
	public void clickTarget(String targetXPath) throws InterruptedException {
		By path = By.xpath(targetXPath);
		if (this.isElementPresent(targetXPath)) {
			driver.findElement(path).click();
		}
	}
	
}
