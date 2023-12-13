package com.test.InterfaceTest.TextHandling;

import java.util.HashMap;
import java.util.logging.Logger;

import com.test.Util.FileUtil;
import com.test.Util.ScenarioContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextHandlingTest {
	
	static Logger log = Logger.getLogger("TextHandlingTest.class");
	
	@Given("^I calculate the word count for file \"([^\"]*)\" for \"([^\"]*)\"$")
	public void i_calculate_the_word_count_for_file_for(String fileName, String testCase) throws Throwable {
		HashMap<String, Integer> wordMapping = TextHandling.wordCount(fileName);
		ScenarioContext.put(testCase, wordMapping);

	}

	@Then("^Verify the result is the same as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_the_result_is_the_same_as_for(String expResultFile, String testCase) throws Throwable {
		HashMap<String, Integer> wordMapping = (HashMap<String, Integer>) ScenarioContext.get(testCase);
		for (String key : wordMapping.keySet()) {
			log.info(key);
			log.info(String.valueOf(wordMapping.get(key)));
		}
		String result = FileUtil.readFile(expResultFile).trim();
		log.info(result);
		
		
	}

}
