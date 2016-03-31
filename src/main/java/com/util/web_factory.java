package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class web_factory {
	private static WebDriver driver = null;
	public static  void createInstance1(String browser_Name)
	{  
		String iekey="webdriver.ie.driver";
		String chromekey="webdriver.chrome.drive";
		String iePath="C:/Program Files/Internet Explorer/iedriver.exe ";
		String chromePath="C:/Users/liruitian/AppData/Local/Google/Chrome/Application/chromedriver.exe";
		if(browser_Name.toLowerCase()=="firefox")
		{ 
			driver=new FirefoxDriver();
		}
		if (browser_Name.toLowerCase()=="chrome")
		{   
			System.setProperty(chromekey,chromePath);
			driver=new ChromeDriver();
		}
		if (browser_Name.toLowerCase()=="ie")
		{  
		     System.setProperty(iekey, iePath);
		     DesiredCapabilities capab=DesiredCapabilities.internetExplorer();
		     capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		     driver=new InternetExplorerDriver(capab);
		    driver.get("http://192.168.1.107:7001/ggpj/mainPage.jsp?menuId=10040000&username=90106&password=10000");
		}
	}

	public static void createInstance(String browser_Name) {
		// TODO Auto-generated method stub
		
	}
}
