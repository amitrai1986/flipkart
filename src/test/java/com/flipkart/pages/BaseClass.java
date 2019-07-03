package com.flipkart.pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.flipkart.utility.BrowserFactory;
import com.flipkart.utility.ConfigDataProvider;
import com.flipkart.utility.ExcelDataProvider;
import com.flipkart.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	//public static boolean verificationStatus=true;
	
	
	@BeforeSuite
	public void setUpSuit(){
		config = new ConfigDataProvider();
		excel = new ExcelDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/extentreport"+Helper.currentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	//@Parameters({"systembrowser", "urlTobeTested"})
	@BeforeClass
	//public void setup(String browser, String url){
	public void setup(){
		Reporter.log("Brrowsers setup completed", true);
		/*driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());*/
		
		//driver=BrowserFactory.startApplication(driver, browser, url);
		//Inserting hardcare url here for testing
		driver=BrowserFactory.startApplication(driver, "chrome", "https://flipkart.com");
	}
	
	@AfterMethod
	public void screenonFailure(ITestResult result) throws Exception{
		if(ITestResult.FAILURE==result.getStatus()){
			logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
		}
		else if(ITestResult.SUCCESS==result.getStatus()){
			//if verification fails but TC is passed
			logger.pass("Test Case Passed");
			
		}
		report.flush();
	}
	
	@AfterClass
	public void teardown(){
		BrowserFactory.closeBrowser(driver);
	}

}
