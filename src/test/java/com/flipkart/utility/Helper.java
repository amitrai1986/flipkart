package com.flipkart.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName){
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+screenshotName+"_"+currentDateTime()+".png";
		
		try {
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(src, new File(screenshotPath));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return screenshotPath;
	}
	
	public static void explicitWait(WebDriver driver, int waitTime, By elementToWait){
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementToWait));
	}
	
	public void handleFrames(){
		
	}
	
	public void handleAlerts(){
		
	}
	
	public void handleMultipleWindows(){
		
	}
	
	public void handleSyncIssue(){
		
	}
	
	public void javascriptExecutor(){
		
	}
	
	public static String currentDateTime(){
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDateTime = new Date();
		return customFormat.format(currentDateTime);
	}

}
