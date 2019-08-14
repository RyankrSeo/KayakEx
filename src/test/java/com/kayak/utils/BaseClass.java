package com.kayak.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseClass implements Prop{

	public static WebDriver driver;

	public static void setUpApplication() {

//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("window-size=720, 480");
//		
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability(ChromeOptions.CAPABILITY, option);
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Not supported now");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Dimension d = new Dimension(1280, 1024);
		driver.manage().window().setSize(d);
		//driver.manage().window().maximize();
		driver.get(url);
	}

	public static void tearDownApplication() {
		driver.quit();
	}

}