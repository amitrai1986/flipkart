package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	} 
	
	By emailField = By.xpath("//span[contains(text(),'Enter Email/Mobile number')]//parent::label//preceding-sibling::input");
	By passField = By.xpath("//input[@type='password']");
	By loginButton = By.xpath("//span[text()='Login']//parent::button");
	By forgotPasswordLink = By.xpath("//span[contains(text(),'Forgot?')]//parent::a");
	By requestOtpButton = By.xpath("//button[text()='Request OTP']");
	public By signupLink = By.linkText("New to Flipkart? Create an account");
	By closePopupButton = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	
	
	
	public void login(String email, String password){
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public void clickSignup(){
		driver.findElement(signupLink).click();
	}
	
	public void closePupup(){
			try {
				driver.findElement(closePopupButton).click();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Reporter.log("Popup is already closed", true);
			}
		
			
		
	}

}
