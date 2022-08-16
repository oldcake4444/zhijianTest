package com.test.InterfaceTest;

import java.io.IOException;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.cli.Main;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		//plugin = {"pretty", "html:src/main/resources/CucumberReports/html", "json:src/main/resources/CucumberReports/json/cucumber.json", "junit:target/junit"}, 
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}, 
		features = {"src/main/resources/Features/"},
	    glue = {""},
		tags = {"@houseProRpt"}
		)

public class CucumberRunEntryPoint {
	public static void main(String[] args) throws IOException {  
    }  
	
}
