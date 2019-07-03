package com.flipkart.pages;

import org.testng.annotations.Test;

public class closePoup extends BaseClass {
	
	@Test
	public void closePopupWindow(){
		logger = report.createTest("Close popup");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.closePupup();
	}

}
