package com.flipkart.utility;

import java.util.Set;

import com.flipkart.pages.BaseClass;

public class HandleWindow extends BaseClass {
	
	public void switchWindow(String windowTitleToBeSwitched){
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String childWindow : allWindows){
			if(driver.switchTo().window(childWindow).getTitle().equalsIgnoreCase(windowTitleToBeSwitched)){
				break;
			}
		}
	}
	public void switchWindow(){
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String childWindow: allWindows){
			if(!childWindow.equals(parentWindow)){
				driver.switchTo().window(childWindow);
			}
		}
		
	}
}
