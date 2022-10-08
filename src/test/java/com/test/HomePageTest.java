package com.test;

import java.util.concurrent.TimeUnit; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.BasePage;
import com.pages.HomePage;

import DataProvider.ConfigFileReader;

public class HomePageTest extends BasePage {
	Logger logger = LogManager.getLogger("HomePageTestTest");
	HomePage homepage;
	SoftAssert softassert = new SoftAssert();

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		setup();
		homepage = new HomePage(null);
	}

	@Test(priority = 1)
	public void VerifyTitleTest1() {
		homepage = new HomePage(driver);
		homepage.verifyTitle();
		logger.info("Verified that expected and actual title are same");
	}

	@Test(priority = 2)
	public void VerifyTitleTest2() {
		homepage = new HomePage(driver);
		homepage.verifyTitle();
		logger.error("Actual and Expected title are not same");
	}

	@Test(priority = 3)
	public void SearchItem() {
		homepage = new HomePage(driver);
		homepage.searchItem(ConfigFileReader.getProperty("Item"));
		logger.info("Item entered on search box");
		homepage.clickSearch();
		logger.info("Clicked search button");
		logger.info("Verified that item searched succesfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 4)
	public void IsLogoDisplay() {
		homepage = new HomePage(driver);
		boolean logo = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]")).isDisplayed();
		logger.info("Logo displayed");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 5)
	public void IsMenuAvailable() {
		WebElement Menu = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]"));
		logger.info("Menu found and clicked");
		softassert.assertEquals(true, Menu.isDisplayed());
		softassert.assertAll();
		logger.info("Verified that menu displayed on page succesfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
