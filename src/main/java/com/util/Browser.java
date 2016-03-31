package com.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Browser {
	public static WebDriver dr = null;
	String iekey="webdriver.ie.driver";
	String chromekey="webdriver.chrome.driver";
	String iePath="C:/Program Files/Internet Explorer/iedriver.exe";
	String chromePath="/Applications/Google Chrome.app/Contents/MacOS/chromedriver";
	String certskey = "webdriver.accept.untrusted.certs";
	private String projectpath = System.getProperty("user.dir");
	private FirefoxProfile firefoxprofile = null;
	
	public Browser(BrowserType browserType){
		switch(browserType){
			case ie:
				System.setProperty(iekey, iePath);
			     DesiredCapabilities capab=DesiredCapabilities.internetExplorer();
			   
			     capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			  
			    capab.setCapability(InternetExplorerDriver.IE_SWITCHES, ".private");
			   
			     capab.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			     
			     dr=new InternetExplorerDriver(capab);
		     
//			     import org.snipecode.reg.RegUtil��
//			     int handle=RegUtil.RegOpenKey(RegUtil.HKEY_CURRENT,"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Setting",RegUtil.KEY_ALL_ACCESS)[RegUtil.NATIVE_HANDLE];
//			     RegUtil.RegSetValueEx(handle,"ProxyEnable","");
//			     RegUtil.RegSetValueEx(handle,"Proxyserver",proxy);
			     break;
			case ff:
				File firebug = new File(projectpath+"/tool/firebug-2.0.14-fx.xpi");
				File firepath = new File(projectpath+"/tool/firepath-0.9.7.1-fx.xpi");
				
				firefoxprofile = new FirefoxProfile();				
			try {
				
				firefoxprofile.addExtension(firebug);
  		        firefoxprofile.addExtension(firepath);
  		    
  				firefoxprofile.setPreference("extension.firebug.currentVersion","2.0.14");
/*			
				firefoxprofile.setPreference(certskey, "true");
				
				firefoxprofile.setPreference("network.proxy.type",0);
			
				firefoxprofile.setPreference("network.proxy.http","10.1.1.0");
				firefoxprofile.setPreference("network.proxy.http_port","3228");
				
				firefoxprofile.setPreference("network.proxy.share_proxy_settings", true);
				
//				firefoxprofile.setPreference("network.proxy.no_proxies_on", "localhost");*/
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//��ϵͳ�����в���"%temp%",������ϵͳ��ʱ�ļ��в��ҵ�webdriver-firefoxprofile�ļ�
			    //��ff������->����->�����ų���Ϣ���ɲ鿴�������ļ���
				dr=new FirefoxDriver(firefoxprofile);
				break;
			case chorme:
				DesiredCapabilities cap=DesiredCapabilities.chrome();
//				//���ô���
//				cap.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443"));
//				//���ô��ڵĴ�С
//				cap.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
				System.setProperty(chromekey,chromePath);
			    dr=new ChromeDriver(cap);
				break;
				
		}
	}

}
