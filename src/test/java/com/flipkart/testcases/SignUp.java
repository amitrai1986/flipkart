package com.flipkart.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.flipkart.pages.BaseClass;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SignupPage;
import com.flipkart.utility.Helper;

public class SignUp extends BaseClass {
	LoginPage loginpage;
	SignupPage signuppage;
	
	@Test(priority=1)
	public void openSignup(){
		loginpage = new LoginPage(driver);
		signuppage = new SignupPage(driver);
		SoftAssert verify = new SoftAssert();
		
		logger = report.createTest("Open Signup Screen");
		logger.info("Website is opened");
		//Test the explicit wait
		Helper.explicitWait(driver, 20, loginpage.signupLink);
		loginpage.clickSignup();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("test");
		logger.info("signup link is clicked");
		
		String expectedTitle = excel.getStringData("login", 0, 2);
		String actualTitle = signuppage.getTitle();
		
		verify.assertEquals(actualTitle, expectedTitle);
		//verify.assertEquals(actual, expected);
		
		/*if(signuppage.getTitle().equalsIgnoreCase("signup")){
			logger.pass("Title verification Pass");
		}
		else{
			logger.fail("title verification fails");
		}*/
		
		System.out.println("testing is comleted");

		
		verify.assertAll();
	}
	
	@Test(priority=2)
	public void signup(){
		logger=report.createTest("New User Signup");
		signuppage.enterMobile(excel.getNumericData("login", 0, 3));
		logger.info("Mobile number is entered");
	}
	
	


}
