package com.test.GuiTest.WebDriver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectBrowser {
	
	public static WebDriver selectIE() {
		File file_ie = new File("src/main/resources/webDrivers/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file_ie.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
	
	public static WebDriver selectFireFox() {
		System.setProperty("webdriver.firefox.marionette", "src/main/resources/webDrivers/geckodriver-v0.14.0/geckodriver-v0.14.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver selectChrome() {
		File file_chrome = new File("src/main/resources/webDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file_chrome.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver selectChromeHeadless() {
		File file_chrome = new File("src/main/resources/webDrivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file_chrome.getAbsolutePath());
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
//      设置浏览器窗口打开大小  （非必须）
        chromeOptions.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
		return driver;
	}
	
	public static ScreenCaptureHtmlUnitDriver selectGhost() {		
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.htmlUnit();  
		//DesiredCapabilities desiredCapabilities = DesiredCapabilities.htmlUnitWithJs();  
		desiredCapabilities.setCapability("loadImages", true);    
		ScreenCaptureHtmlUnitDriver driver = new ScreenCaptureHtmlUnitDriver(desiredCapabilities);
		return driver;
	}
	


}
