package com.util;

import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
public class SnapShot {
	public  static void SnapShot(TakesScreenshot WebDriver,String filename)
	{
		 String currentPath = System.getProperty("user.dir");//get current work folder
		 System.out.println(currentPath);
		 File scrFile = WebDriver.getScreenshotAs(OutputType.FILE);
		 try {
	            System.out.println("save snapshot path is:"+currentPath+"/"+filename);
	            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        } 
	        finally
	        {
	           
	            System.out.println("screen shot finished");
	        }
	  }
	}

