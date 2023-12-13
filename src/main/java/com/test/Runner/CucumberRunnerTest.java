package com.test.Runner;

import java.io.IOException;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		plugin = {"pretty", "html:src/main/resources/CucumberReports/", "junit:target/junit"}, 
		features = {"src/main/resources/Features/"},
	    glue = {""},
		tags = "@AppApiTest"
		)

public class CucumberRunnerTest {
	public static void main(String[] args) throws IOException {  
    }  
	
}
