package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	By cart=By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]");
	By signin = By.xpath("//*[@id=\"a-autoid-0-announce\"]/span");
	By email = By.xpath("//input[@id='ap_email']");
	By cont = By.xpath("//input[@id='continue']");
	By password = By.xpath("//*[@id=\"ap_password\"]");
	By submitBtn = By.xpath("//input[@id='signInSubmit']");
	By pswrdError = By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");
	By addCart = By.xpath("//*[@id=\"add-to-cart-button\"]");
	By checkout= By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input");
	By clickcont = By.xpath("//*[@id=\"changeQuantityFormId\"]/div[2]/div[2]/div/div/span/span/input");
	public void clickCart() {
		driver.findElement(cart).click();
	}

	public void clicksignin() {
		driver.findElement(signin).click();
	}

	public void enterEmail(String arg) {

		driver.findElement(email).sendKeys(arg);
	}
	
	public void clickContinue() {
		driver.findElement(cont).click();
	}

	public void enterPassword(String arg) {
		driver.findElement(password).sendKeys(arg);
	}

	public void clickOnSubmitBtn() throws InterruptedException {
		driver.findElement(submitBtn).click();
	}

	public void closeBrowser() {
		driver.close();
	}

	By clickSignUp = By.xpath("//*[@id=\"a-autoid-1-announce\"]/span");
	By uname = By.id("ap_customer_name");
	By umob = By.xpath("//*[@id=\"ap_phone_number\"]");
	By pswrd = By.xpath("//*[@id=\"ap_password\"]");
	By submit = By.xpath("//*[@id=\"continue\"]");
	
	
	public void clickOnSignUp() {
		driver.findElement(clickSignUp).click();
	}
	
	public void enterName(String ar1) {
		driver.findElement(uname).sendKeys(ar1);
	}
	
	public void enterMobNum(String ar2) {
		driver.findElement(umob).sendKeys(ar2);
	}
	
	public void enterPassword2(String ar3) {
		driver.findElement(pswrd).sendKeys(ar3);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public void addtoCart() {
		driver.findElement(addCart).click();
	}
	
	public void Checkout() {
		driver.findElement(checkout).click();
	}
	
	public void ContinueToPayment() {
		driver.findElement(clickcont).click();
	}


}
