package com.flipkart.testcases;

import org.testng.annotations.Test;

import com.flipkart.pages.BaseClass;
import com.flipkart.utility.DropdownMenu;

public class OpenMenu extends BaseClass {
	
	@Test
	public void hoverParentMenu(){
		logger = report.createTest("parent menu");
		DropdownMenu ddMenu = new DropdownMenu(driver);
		
		ddMenu.mouseHoverOnMenu("Electronics");
		ddMenu.clickOnSubMenu("Mobiles");
		
	}

}

