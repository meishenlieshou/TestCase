package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
private WebDriver driver;
private int timeout = 20;

public Wait (WebDriver driver){
  this.driver = driver;	
}

public void waitForElementPresent(String locator){
	try {
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
public void waitForElement(String locator){

		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));	
	}

public static void waitfor(long timeout){
        try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
}


}


