package com.pregopower.provider.utility;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.OutputType;
 
import org.openqa.selenium.TakesScreenshot;
 
import org.openqa.selenium.WebDriver;
 


public class CaptureScreenshot {


	
	 public static void captureScreenShot(WebDriver driver){
	 
	  // Take screenshot 
	  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	  
	 
	 FileUtils.copyFile(src, new File("D:/seleniume screenshots"+System.currentTimeMillis()+".png"));
	       }
	 
	catch (IOException e)
	 
	{
	 
	System.out.println(e.getMessage());
	 
	    }
	 
	 }
}
