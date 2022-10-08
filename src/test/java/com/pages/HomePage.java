package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DataProvider.ConfigFileReader;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By item = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By clickSearch = By.xpath("//*[@id=\"nav-search-submit-button\"]");
	By selectItem =By.linkText("Apple iPhone 13 (128GB) - Midnight");
	By buyItem = By.xpath("//*[@id=\"buy-now-button\"]");
	
	public void verifyTitle() {
		driver.get(ConfigFileReader.getProperty("url"));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void verifyTitle2() {
		driver.get(ConfigFileReader.getProperty("url"));
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More ";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void searchItem(String Item) {
		driver.findElement(item).sendKeys(Item);
	}
	
	public void clickSearch() {
		driver.findElement(clickSearch).click();
	}
	
	public void SelectItem() {
		driver.findElement(selectItem).click();
	}
	
	public void BuyItem() {
		driver.findElement(buyItem).click();
	}
	
}