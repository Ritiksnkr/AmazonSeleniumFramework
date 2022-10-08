package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	WebDriver driver;
	LoginPage login;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By logInSignUpPage = By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span");
	By clickSignUp = By.xpath("//*[@id=\"createAccountSubmit\"]");
	By uname = By.id("ap_customer_name");
	By umob = By.xpath("//*[@id=\"ap_phone_number\"]");
	By pswrd = By.xpath("//*[@id=\"ap_password\"]");
	By submit = By.xpath("//*[@id=\"continue\"]");
	By signUperror = By.xpath("//*[@id=\"auth-phoneNumber-invalid-phone-alert\"]/div/div");
	
	
	public void LogInSignUpPage() {
		driver.findElement(logInSignUpPage).click();
		
	}
	public void clickOnSignUp() {
		driver.findElement(clickSignUp).click();
	}
	
	public void enterName(String ar1) {
		driver.findElement(uname).sendKeys(ar1);
	}
	
	public void enterMobNum(String ar2) {
		driver.findElement(umob).sendKeys(ar2);
	}
	
	public void enterPassword(String ar3) {
		driver.findElement(pswrd).sendKeys(ar3);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public String SignUpError() {
		return driver.findElement(signUperror).getText();
	}

}
