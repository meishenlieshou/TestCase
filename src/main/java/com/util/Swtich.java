package com.util;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Swtich {
private WebDriver driver;
private String currentwindow;
	public  Swtich( WebDriver driver ){
	this.driver=driver;
	currentwindow = driver.getWindowHandle();
	}
	
	public void topSpecifcWindow(String partialTitleName){
		Set<String> handles = driver.getWindowHandles();
		String title;
		for (String handle : handles){
			title = driver.switchTo().window(handle).getTitle();
			if( title.contains(partialTitleName)){
				break;
			}
		}
	}
	
	public void backToCurrentwindow(){
		driver.switchTo().window(currentwindow);
	}
}

