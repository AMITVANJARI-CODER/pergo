package com.pregopower.provider.pages;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public String  downloadPath;
	public WebDriver intializeDriver() throws IOException{
		
		Properties pro =new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\com\\pregopower\\provider\\pages\\data.properties");
		pro.load(fis);
		
		String BrowserName = pro.getProperty("browser");
		
		if (BrowserName.equals("chrome")){
			ChromeOptions options=new ChromeOptions();
			
			  downloadPath=System.getProperty("user.dir");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);

			chromePrefs.put("download.default_directory", downloadPath);
			options.setExperimentalOption("prefs", chromePrefs);
			
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
		}
		
		else if  (BrowserName=="fireFox"){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}
}
