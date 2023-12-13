package com.test.hooks;


import io.cucumber.java.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class StepDefBeginEndLogger {

    private int currentStepDefIndex = 0;

    //@BeforeStep
    public void doSomethingBeforeStep(Scenario scenario) throws Exception {

        Field f = scenario.getClass().getDeclaredField("testCase");
        f.setAccessible(true);
        TestCase r = (TestCase) f.get(scenario);

        //You need to filter out before/after hooks
        List<PickleStepTestStep> stepDefs = r.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());


        //This object now holds the information about the current step definition
        //If you are using pico container
        //just store it somewhere in your world state object
        //and to make it available in your step definitions.
        PickleStepTestStep currentStepDef = stepDefs
                .get(currentStepDefIndex);
    }

    //@AfterStep
    public void doSomethingAfterStep(Scenario scenario) {
        currentStepDefIndex += 1;
    }
}
