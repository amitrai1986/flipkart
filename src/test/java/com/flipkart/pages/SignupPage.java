package com.flipkart.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
	WebDriver driver;
	public SignupPage(WebDriver ldriver){
		this.driver=ldriver;
	}
	
	public By titleText = By.xpath("//span[contains(text(),'Signup')]");
	public By mobileField = By.xpath("//span[text()='Enter Mobile number']//parent::label//preceding-sibling::input");
	public By existinguserLink = By.xpath("//span[starts-with(text(),'Existing User')]//parent::a");
	
	public String getTitle(){
		return driver.findElement(titleText).getText();
	}
	
	public void enterMobile(double mobile){
		driver.findElement(mobileField).sendKeys(String.valueOf(mobile));;
	}
	
			

}
