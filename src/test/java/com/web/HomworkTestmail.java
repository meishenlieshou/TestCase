package com.web;

import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.Browser;
import com.util.BrowserType;
import com.util.ParseProperties;
import com.util.Wait;

public class HomworkTestmail {

	private WebDriver dr = null;
	
	
	@BeforeClass
	public void setup(){
		Browser browser = new Browser(BrowserType.chorme);
		dr = browser.dr;
		
		
		
	}
	
	@Parameters({"Testdata"})
	@Test
	public void login(@Optional("/test.properties") String Testdata){
		String Classpath = System.getProperty("user.dir");
		ParseProperties a =new ParseProperties( Classpath+Testdata);
		
			try {
				dr.get(a.getValue("url"));
				System.out.println("---start browser-----");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		
		
		dr.switchTo().frame(dr.findElement(By.id("x-URS-iframe")));
		WebElement user = dr.findElement(By.cssSelector("input.j-inputtext.dlemail"));
		user.sendKeys( "a15221676424" );
		WebElement pwd = dr.findElement(By.xpath( "//input[@class='j-inputtext dlpwd']"));
		pwd.sendKeys( "1522167" );
		WebElement loginbutton = dr.findElement(By.xpath( "//a[@id='dologin']" ));
		loginbutton.click();
		System.out.println(dr.getTitle());
		Wait.waitfor(3000);
		Assert.assertEquals(dr.getTitle().contains("网易邮箱"), true);		
	}
	
	public void homepage(){
		
		Wait wait = new Wait( dr );	
	
//		wait.waitForElement( locatorrecive );
//		WebElement recive = dr.findElement(By.xpath( locatorrecive ));
//		recive.click();
		//strong[@class='nui-tree-item-count']
		//String mailnum="//div[@class='nui-tabs-item-text nui-fNoSelect' and text()='�ռ���']";
		String mailnum = "//li/div[@class='nui-tabs-item-text nui-fNoSelect'and text()='�ռ���']";
		WebElement number = dr.findElement(By.xpath( mailnum ));
		number.click();
		//�ռ����ʼ�����
		int  num=Integer.parseInt(number.getText());
		
		String pages="//span[@class='nui-select-text']";
		WebElement page = dr.findElement(By.xpath( pages ));
		String  pagenum=page.getText();
		String[] pagenums=pagenum.split("/",2);
		//��ҳ��
		int pagetotal = Integer.parseInt(pagenums[1]);
		
		String settings="//span[@class='nui-btn-icon']/b/ancestor::div[@title='����']";
		WebElement setting = dr.findElement(By.xpath( settings ));
		
		String perpagenum="//span[text()='ÿҳ��ʾ�ʼ�����']";
		
		wait.waitForElement( perpagenum );
		String pageradio = "//div[@class='nui-smallBtn nui-btn nui-btn-active js-component-radio-dc']/span[text()='10']";
		
		WebElement pagenumradio = dr.findElement(By.xpath( pageradio ));
		//ÿҳ����
		int perpagesnum = Integer.parseInt(pagenumradio.getText());
		//�л������һҳ
		//��ҳ�������б?ȡ���һ��ֵ�������һҳ
		String droplastvalue = "//div[@id='_mail_menu_10_214']/a[last()]";
		//��ҳ��������ť
		WebElement drop = dr.findElement(By.xpath("//span[@class='nui-select-arr']/b[@class='nui-ico nui-ico-dArr']"));
		drop.click();
		WebElement droplist = dr.findElement(By.xpath("droplastvalue"));
		droplist.click();
		
		String mailsnum = "//div[@class='tv0']/div[@sign='letter']";
		List<WebElement> mailnumbers = dr.findElements(By.xpath(mailsnum));
		int count=0;
		for(WebElement mailnumber:mailnumbers){
			
			count=count+1;
		}
		
		int total=count+perpagesnum*pagetotal;
		
		Assert.assertEquals(total, num);
	}
}
