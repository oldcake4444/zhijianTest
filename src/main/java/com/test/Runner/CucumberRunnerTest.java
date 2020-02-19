package com.test.Runner;

import java.io.IOException;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.cli.Main;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		plugin = {"pretty", "html:src/main/resources/CucumberReports/", "junit:target/junit"}, 
		features = {"src/main/resources/Features/"},
	    glue = {""}
		//tags = {"@gui"}
		)

public class CucumberRunnerTest {
	public static void main(String[] args) throws IOException {  
    }  
	
}
