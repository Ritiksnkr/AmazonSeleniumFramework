package com.implement.assertions;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertion {
	WebDriver driver;

	SoftAssert softassert = new SoftAssert();
	SoftAssert softassert2 = new SoftAssert();

	@BeforeTest
	public void SetDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/ritiksonker/Downloads/chromedriver_win32 (1)/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void verifyTitle() {
		driver.get("https://amazon.in");
		String ActualTitle = driver.getTitle();
		System.out.println("Actual Title :" + ActualTitle);
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		softassert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assertion 1 is executed");
		softassert.assertAll();

	}

	@Test
	public void verifyElement(){
	WebElement AmazonIcon = driver.findElement(By.xpath("//div[contains(@id,’amazon_icon’)]"));
	softassert2.assertEquals (true, AmazonIcon.isDisplayed());
	softassert2.assertAll();
	System.out.println("Icon is displayed");
	System.out.println("Assertion 2 is executed");
	 
	}

	@AfterTest
	public void closedriver() {
		driver.close();
	}
}