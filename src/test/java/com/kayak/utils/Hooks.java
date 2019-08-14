package com.kayak.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
//this is our global precondition applicable for each and every scenario
//hooks are placed inside step definitions, however they do not provide definition to any of the steps
	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting test:"+scenario.getName());
		BaseClass.setUpApplication();	
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Ending test:"+scenario.getName());
		
//		if (scenario.isFailed()) {
//			byte[]shot = Commons.takeScreenshot();
//			scenario.embed(shot, "image/png");
//		}
		BaseClass.tearDownApplication();
	}
	
}
