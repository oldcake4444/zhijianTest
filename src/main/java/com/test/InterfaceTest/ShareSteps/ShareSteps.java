package com.test.InterfaceTest.ShareSteps;

import java.util.logging.Logger;

import cucumber.api.java.en.When;

public class ShareSteps {
	
	Logger log = Logger.getLogger("ShareSteps.class");
	
	@When("^I wait for \"([^\"]*)\" seconds$")
	public void i_wait_for_seconds(String secStr) throws Throwable {
	    log.info("Waiting for " + secStr + " seconds");
	    int second = Integer.parseInt(secStr);
	    Thread.sleep(second * 1000);
	}

}
