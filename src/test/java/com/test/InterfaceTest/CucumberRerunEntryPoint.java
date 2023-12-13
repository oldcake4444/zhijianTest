package com.test.InterfaceTest;

import java.io.IOException;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import cucumber.api.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions (
		//plugin = {"pretty", "html:src/main/resources/CucumberReports/html", "json:src/main/resources/CucumberReports/json/cucumber.json", "junit:target/junit"},
		plugin = {"pretty", "html:target/cucumber/report.html", "json:target/cucumber.json"},
		features = { "@target/rerun.txt" },
		glue = {"com.test"}
		//tags = {"@AppApiTest"}
)


public class CucumberRerunEntryPoint {
	public static void main(String[] args) throws IOException {
	}

}
