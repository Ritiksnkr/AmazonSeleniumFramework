package com.pages;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By signin = By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span");
	By email = By.xpath("//input[@id='ap_email']");
	By cont = By.xpath("//input[@id='continue']");
	By error=By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");
	By password = By.xpath("//*[@id=\"ap_password\"]");
	By submitBtn = By.xpath("//input[@id='signInSubmit']");
	By pswrdError = By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");

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
	
	
	public String errormssg() {
		return driver.findElement(error).getText();
		
	}
	
	public String errormssg2() {
		return driver.findElement(pswrdError).getText();
	}
}
