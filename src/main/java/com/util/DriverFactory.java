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
		WebElement top_left=and_driver.findElementById("android:id/up");//ҳ�����Ͻǰ�ť���򿪲໬��
		WebElement top_right=and_driver.findElementById("com.tobacco.smoke:id/public_menu_refresh");//ҳ�����Ͻ�ˢ�°�ť
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
		WebElement button_left=and_driver.findElementByName("������");
		
		WebElement button_middle=and_driver.findElementByName("������");
		
		WebElement button_right=and_driver.findElementByName("֪ͨ");
		//List<WebElement> num=and_driver.findElements(By.id("com.tobacco.smoke:id/tab_title"));
		
	}
	
	public  void pre_smoking_page(AndroidDriver and_driver){
		this.driver=driver;
		//��һ��һ��tab
		WebElement fir_level_tab1=and_driver.findElement(By.id("com.tobacco.smoke:id/item_title_1"));
		//�ڶ���һ��tab
		WebElement fir_level_tab2=and_driver.findElement(By.id("com.tobacco.smoke:id/item_title_2"));
		//��һ��һ��tab�µĶ���tab
		List<WebElement> sec_level_tab1=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/title_layout2_1"));
		//�ڶ���һ��tab�µĶ���tab
		List<WebElement> sec_level_tab2=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/title_layout2_2"));
		//���������
		List<WebElement> current_smoking=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/content_item_result_num"));
		//���ֱ�׼
		List<WebElement> standard_smoking=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/content_item_layout"));
		//��ע
		List<WebElement>  tips=(List<WebElement>) and_driver.findElement(By.id("com.tobacco.smoke:id/add_remarks"));
		//��һ����Ʒ
		WebElement next_sample=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_next"));
		//��һ����Ʒ
		WebElement front_sample=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_pre"));
		//��������
		WebElement sample_list=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_progress"));
		//�ύ
		WebElement submit=and_driver.findElement(By.id("com.tobacco.smoke:id/detail_title_commit"));
		//���������б�
		WebElement back_list=and_driver.findElement(By.id("com.tobacco.smoke:id/btn_back"));
	}
	
	
}
