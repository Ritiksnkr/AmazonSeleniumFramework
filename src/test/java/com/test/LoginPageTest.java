package com.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.LoginPage;

import DataProvider.ConfigFileReader;
import org.apache.logging.log4j.*;

public class LoginPageTest extends BasePage {
	Logger logger = LogManager.getLogger("LoginPageTest");
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		setup();
		loginPage = new LoginPage(null);
	}

	@Test(priority = 1) // Login with correct mobile number and password.
	public void LoginTest1() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.clicksignin();
		logger.info("Clicked on signIn");
		loginPage.enterEmail(ConfigFileReader.getProperty("userId"));
		logger.info("Entered Valid Email Address or Phone Number");
		loginPage.clickContinue();
		logger.info("Clicked on continue");
		loginPage.enterPassword(ConfigFileReader.getProperty("password"));
		logger.info("Entered password");
		loginPage.clickOnSubmitBtn();
		logger.info("Clicked on submit");
		logger.info("Verified that the user landed on the Home Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2) // Login with wrong mobile number.
	public void LoginTest2() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.clicksignin();
		logger.info("Clicked on signIn");
		loginPage.enterEmail(ConfigFileReader.getProperty("userID2"));
		logger.info("Entered Invalid Email or Phone number");
		loginPage.clickContinue();
		logger.info("Click Continue");
		String actualError = loginPage.errormssg();
		String expectedError = "We cannot find an account with that mobile number";
		Assert.assertEquals(actualError, expectedError);
		logger.warn(expectedError);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 3) // Login with correct mobile number and wrong password.
	public void LoginTest3() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.clicksignin();
		logger.info("Clicked on signIn");
		loginPage.enterEmail(ConfigFileReader.getProperty("userId"));
		logger.info("Entered valid Email or Mobile number");
		loginPage.clickContinue();
		logger.info("Clicked on continue");
		loginPage.enterPassword(ConfigFileReader.getProperty("pswrd"));
		logger.info("entered invalid Password");
		loginPage.clickOnSubmitBtn();
		String actualpswrdError = loginPage.errormssg2();
		String expectedpswrdError = "Your password is incorrect";
		Assert.assertEquals(actualpswrdError, expectedpswrdError);
		logger.info(expectedpswrdError);
		System.out.println("LoginTest3: " + actualpswrdError);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}