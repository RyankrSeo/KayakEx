package com.kayak.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/"
		,glue= {"com/kayak/steps", "com/kayak/utils"}
//		,dryRun=true
		,monochrome=true
		,plugin = "pretty" 
		)
public class TestRunner {

}
