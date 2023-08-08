package com.test.GuiTest.WebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
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
	//protected WebDriver driver = SelectBrowser.selectChromeHeadless();
	//protected ScreenCaptureHtmlUnitDriver driver = SelectBrowser.selectGhost();
	
	Actions action = new Actions(driver);
	
	public Boolean isElementPresent(String xPath) throws InterruptedException {
		By path = By.xpath(xPath); 
		Boolean elementExist = false;
		WebElement e = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(path));
		if(e.isDisplayed()) {
			elementExist = true;
		}
		return elementExist;
	}
	
	public Boolean isElementPresent(String xPath, int second) throws InterruptedException {
		By path = By.xpath(xPath); 
		Boolean elementExist = false;
		WebElement e = new WebDriverWait(driver, second).until(ExpectedConditions.presenceOfElementLocated(path));
		if(e.isDisplayed()) {
			elementExist = true;
		}
		return elementExist;
	}
	
	public Boolean isElementPresentNoException(String xPath) throws InterruptedException {
		By path = By.xpath(xPath); 
		Boolean elementExist = false;
		WebElement e = null;
		try {
			e = new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(path));
			if(e.isDisplayed()) {
				elementExist = true;
			}
		} catch (Exception e1) {
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
			// driver.findElement(path).click();
			action.click(driver.findElement(path)).build().perform();
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
	
	public void sendKeyToField(String targetXPath, Keys keyName) throws InterruptedException {
		By path = By.xpath(targetXPath);
		if (this.isElementPresent(targetXPath)) {
			action.sendKeys(driver.findElement(path), keyName).build().perform();;
		}
	}
	
	public void sendKey(Keys keyName) throws InterruptedException {
		action.sendKeys(keyName).build().perform();
	}
	
	public void rightClick(String targetXPath) throws InterruptedException {	
		By path = By.xpath(targetXPath);
		if (this.isElementPresent(targetXPath)) {
			action.contextClick(driver.findElement(path)).build().perform();
		}
	}
	
	public void actionToClick(String targetXPath) throws InterruptedException {	
		By path = By.xpath(targetXPath);
		if (this.isElementPresent(targetXPath)) {
			action.moveToElement(driver.findElement(path)).click().perform();
		}
	}
	
	public void toggleDeviceToolBar() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F12);
		robot.keyRelease(KeyEvent.VK_F12);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(1000);;
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
	}
	
	
}
