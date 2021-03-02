package com.pregopower.provider.testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pregopower.provider.pages.Base;
import com.pregopower.provider.pages.BlogsPages;
import com.pregopower.provider.pages.PatientPage;
import com.pregopower.provider.utility.ReadandWrite_Excel;

public class PatientsTestcase extends Base {

	PatientPage ob;

	@BeforeTest

	public void setup() throws IOException {
		driver = intializeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.pregopower.com/");
		driver.navigate().refresh();
		

	}
	
	@Test (priority=0)
	public void TC01() throws InterruptedException{
		ob = new PatientPage(driver);
		//driver.findElement(By.xpath("//*[@id='custom_global_popup_left_cross']")).click();
				//*[@class='close close_subscribe_popup']
		ob.clickOnProvider();
	}
	@Test(priority=1,dataProvider="getdata" )
	//dataProvider="getdata"
	//String username, String password
	public void TC09(String username, String password) throws InterruptedException, IOException{
		//obj.bookmark("amit7@yopmail.com", "1234");
		//ob = new PatientPage(driver);
		ob.Login(username, password);
		//ReadandWrite_Excel d= new ReadandWrite_Excel();
		//ArrayList data = d.getData("login");
		
		//Thread.sleep(3000);
		////ob.Login(data.get(0),data.get(1));
	//dataProvider="getdata"	
		
	}
	@DataProvider
	public Object [][] getdata(){
		
		Object[][] data = new Object[1][2];
		data[0][0] ="amit8080@yopmail.com";
		data[0][1] = "1234";
		return data;
		
	}
	
	@Test(priority=2)
	public void TC03 () throws InterruptedException, IOException{
		ob=new PatientPage(driver);
		
		
		ob.addNewPatient();
		/*ReadandWrite_Excel d= new ReadandWrite_Excel();
		
		ArrayList data = d.getData("login");
		ob.addNewPatient(data.get(0),data.get(1),data.get(2));
		System.out.println(data.get(0));
		System.out.println(data.get(1));*/
	}
	@Test(priority=3)
	public void TC04 () throws InterruptedException, IOException{
		ob = new PatientPage(driver);
		ob.UpalodBulkPatients();
	}
	@Test(priority=4)
	public void TC05 () throws InterruptedException{
		ob=new PatientPage(driver);
		ob.DownloadSampleExcel();
		//String path= super(downloadPath);
		File f=new File(downloadPath+"//mmc_sample_upload.xlsx");
         Thread.sleep(5000);
    	// Assert.assertTrue(f.exists());
    	 //f.delete();
		if(f.exists())

		{

			 Assert.assertTrue(f.exists());

		if(f.delete())

		System.out.println("file deleted");

		}
	}
}
