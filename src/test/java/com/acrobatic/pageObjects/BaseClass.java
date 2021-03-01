package com.acrobatic.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	public void setup() {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/Drivers/chromedriver-2");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
