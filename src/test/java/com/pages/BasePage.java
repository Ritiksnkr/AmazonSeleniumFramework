package com.pages;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataProvider.ConfigFileReader;
import Utilities.ExtentManager;
import Utilities.Screenshot;

public class BasePage {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void setup() throws IOException {
		if (ConfigFileReader.getProperty("mode").equalsIgnoreCase("non-headless")) {
			if (ConfigFileReader.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (ConfigFileReader.getProperty("browser").equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else if (ConfigFileReader.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(ConfigFileReader.getProperty("url"));
		}
		if (ConfigFileReader.getProperty("mode").equalsIgnoreCase("headless")) {
			if (ConfigFileReader.getProperty("browser").equalsIgnoreCase("chrome")) {

				ChromeOptions chromeOptions = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
				chromeOptions.addArguments("--headless");
				driver = new ChromeDriver(chromeOptions);
			} else if (ConfigFileReader.getProperty("browser").equalsIgnoreCase("edge")) {

				EdgeOptions edgeOptions = new EdgeOptions();
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\msedgedriver.exe");
				edgeOptions.addArguments("--headless");
				driver = new EdgeDriver(edgeOptions);
			} else if (ConfigFileReader.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(ConfigFileReader.getProperty("url"));
		}

	}

	@BeforeSuite
	public void init() throws Exception {
		extent = ExtentManager.getInstance("reports/ExtentReports.html");
	}

	@BeforeMethod
	public void startTest(Method method) throws Exception {
		test = extent.startTest(method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test case got passed");
		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = Screenshot.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP)
			test.log(LogStatus.SKIP, result.getThrowable());
		extent.endTest(test);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	@AfterSuite
	public void reportFlush() {
		extent.flush();
	}

}
