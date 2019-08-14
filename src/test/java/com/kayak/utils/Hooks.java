package com.kayak.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

//this is our global precondition applicable for each and every scenario
public class Hooks {
	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting test:"+scenario.getName());
		BaseClass.setUpApplication();	
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Ending test:"+scenario.getName());
		BaseClass.tearDownApplication();
	}
}
