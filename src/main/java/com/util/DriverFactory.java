package com.util;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DriverFactory {
	private static AndroidDriver and_driver;
	private static IOSDriver ios_driver;
	private static WebDriver driver;
	
	public static void pre_smoking_list_page(String pro_no){
		//top
		WebElement top_left=and_driver.findElementById("android:id/up");//页面左上角按钮，打开侧滑栏
		WebElement top_right=and_driver.findElementById("com.tobacco.smoke:id/public_menu_refresh");//页面右上角刷新按钮
		//list
		
		List<WebElement> num=and_driver.findElements(By.id("com.tobacco.smoke:id/wsmoke_numNo"));
		for(WebElement no:num)
		{
			if(num.equals("pro_no"))
			{
				no.click();
			}
		}
		
		//button
		WebElement button_left=and_driver.findElementByName("待评吸");
		
		WebElement button_middle=and_driver.findElementByName("已评吸");
		
		WebElement button_right=and_driver.findElementByName("通知");
		//List<WebElement> num=and_driver.findElements(By.id("com.tobacco.smoke:id/tab_title"));
		
	}
	
	public  void pre_smoking_page(AndroidDriver and_driver){
		this.driver=driver;
		//第一个一级tab
		WebElement fir_level_tab1=and_driver.findElement(By.id("com.tobacco.smoke:id/item_title_1"));
		//第二个一级tab
		WebElement fir_level_tab2=and_driver.findElement(By.id("com.tobacco.smoke:id/item_title_2"));
		//第一个一级tab下的二级tab
		List<WebElement> sec_level_tab1=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/title_layout2_1"));
		//第二个一级tab下的二级tab
		List<WebElement> sec_level_tab2=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/title_layout2_2"));
		//评分输入框
		List<WebElement> current_smoking=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/content_item_result_num"));
		//评分标准
		List<WebElement> standard_smoking=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/content_item_layout"));
		//备注
		List<WebElement>  tips=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/add_remarks"));
		//下一个样品
		WebElement next_sample=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_next"));
		//上一个样品
		WebElement front_sample=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_pre"));
		//评吸进度
		WebElement sample_list=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_progress"));
		//提交
		WebElement submit=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_title_commit"));
		//返回评吸列表
		WebElement back_list=and_driver.findElement(By.id("com.tobacco.smoke:id/btn_back"));
	}
	
	
}
