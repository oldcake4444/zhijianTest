package com.test.InterfaceTest;

import java.io.IOException;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		//plugin = {"pretty", "html:src/main/resources/CucumberReports/html", "json:src/main/resources/CucumberReports/json/cucumber.json", "junit:target/junit"}, 
		plugin = {"pretty", "html:target/cucumber/report.html", "json:target/cucumber.json", "rerun:target/rerun.txt"},
		//features = {"src/main/resources/Features/Interface/AppApi_ZJLogin.feature","src/main/resources/Features/Interface/AppApi_UserRelatedOrgInfo.feature"},
		features = {"src/main/resources/Features/Interface/AppApi_UserRelatedOrgInfo.feature"},
		glue = {"com.test"}
		//tags = {"@AppApiTest"}
		)


public class CucumberRunEntryPoint {
	public static void main(String[] args) throws IOException {  
    }  
	
}
