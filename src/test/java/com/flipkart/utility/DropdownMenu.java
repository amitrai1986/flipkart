package com.flipkart.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DropdownMenu {
	
	WebDriver driver;
	public DropdownMenu(WebDriver ldriver){
		this.driver=ldriver;
	}
	
	
	public By parentMenuLink(String parentMenuText){
		return By.xpath("//li//span[contains(text(),'"+parentMenuText+"')]");
	}
	
	public By clickSubMenuItem(String subMenuTitle){
		return By.xpath("//li//a[@title='"+subMenuTitle+"']");
	}
	
	public void mouseHoverOnMenu(String parentMenuText){
		DropdownMenu ddmenu = new DropdownMenu(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(ddmenu.parentMenuLink(parentMenuText))).build().perform();
	}
	
	public void clickOnSubMenu(String subMenuTitle){
		DropdownMenu ddmenu = new DropdownMenu(driver);
		driver.findElement(ddmenu.clickSubMenuItem(subMenuTitle));

}
}
