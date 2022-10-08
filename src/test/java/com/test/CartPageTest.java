package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import com.pages.BasePage;
import com.pages.CartPage;
import com.pages.HomePage;

import DataProvider.ConfigFileReader;

public class CartPageTest extends BasePage {
	Logger logger = LogManager.getLogger("LoginPageTest");
	CartPage cartPage;
	HomePage homepage;

	public CartPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		setup();
		cartPage = new CartPage(null);
		homepage = new HomePage(null);
	}

	@Test(priority = 1)
	public void cartTest1() throws InterruptedException {
		cartPage = new CartPage(driver);
		homepage = new HomePage(driver);
		homepage.searchItem(ConfigFileReader.getProperty("Item"));
		logger.info("Entered item on searchbox");
		homepage.clickSearch();
		logger.info("Clicked on search");
		homepage.SelectItem();
		logger.info("Item Selected");
		cartPage.addtoCart();
		logger.info("Item added to cart");
		logger.info("Verified that user succesfully add item in cart");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void cartTest2() throws InterruptedException {
		cartPage = new CartPage(driver);
		homepage = new HomePage(driver);
		homepage.searchItem(ConfigFileReader.getProperty("Item"));
		logger.info("Searched Item on searchbox");
		homepage.clickSearch();
		logger.info("Clicked on search button");
		homepage.SelectItem();
		logger.info("Item Selected");
		cartPage.addtoCart();
		logger.info("Item added to cart");
		cartPage.Checkout();
		logger.info("Clicked on checkout");
		logger.info("Item succesfully added to cart and proceed to checkout");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 3)
	public void cartTest3() throws InterruptedException {
		cartPage = new CartPage(driver);
		homepage = new HomePage(driver);
		homepage.searchItem(ConfigFileReader.getProperty("Item"));
		homepage.clickSearch();
		logger.info("Clicked on search");
		homepage.SelectItem();
		logger.info("Item Selected");
		cartPage.addtoCart();
		logger.info("Item Selected");
		cartPage.Checkout();
		logger.info("Item proceed to checkout");
		cartPage.enterEmail(ConfigFileReader.getProperty("userId"));
		logger.info("Entered userId for login");
		cartPage.clickContinue();
		logger.info("Clicked on continue");
		cartPage.enterPassword(ConfigFileReader.getProperty("password"));
		logger.info("Clicked on password");
		cartPage.clickOnSubmitBtn();
		logger.info("Clicked on submit");
		logger.info("item succesfully directed for payment");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 4)
	public void cartTest4() throws InterruptedException {
		cartPage = new CartPage(driver);
		cartPage.clickCart();
		logger.info("Clicked on cart");
		cartPage.clicksignin();
		logger.info("Clicked on signIn");
		cartPage.enterEmail(ConfigFileReader.getProperty("userId"));
		logger.info("Entered Email or mobile number");
		cartPage.clickContinue();
		logger.info("Clicked on continue");
		cartPage.enterPassword(ConfigFileReader.getProperty("password"));
		logger.info("Entered password");
		cartPage.clickOnSubmitBtn();
		logger.info("Clicked on submit button");
		logger.info("Verified that user succesfuly view cart option");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
