package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.flipkart.pages.BaseClass;
import com.flipkart.pages.LoginPage;

public class LoginCRM extends BaseClass {
	
	@Test
	public void validLlogin() throws Exception{
		logger = report.createTest("Login to CRM");
	
		LoginPage loginpage = new LoginPage(driver);
		logger.info("Starting Apllication");
		Reporter.log("Login screen is open", true);
		loginpage.login(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		Thread.sleep(3000);
		Reporter.log("Checking pagetitle");
		Assert.assertEquals(driver.getTitle(), "Gogle", "Failed");

		

	}

}
