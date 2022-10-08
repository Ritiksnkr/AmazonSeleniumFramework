package com.implement.assertions;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DataProvider.ConfigFileReader;


public class hardAssertion {
	WebDriver driver;

	@BeforeTest
	public void SetDriver() {

		System.setProperty("webdriver.chrome.driver","C:/Users/ritiksonker/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void verifyTitle()
	{
		driver.get(ConfigFileReader.getProperty("url"));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert Passed");
	}

	@AfterTest
	public void closedriver() {

		// closes the browser instance
		driver.close();
	}
}