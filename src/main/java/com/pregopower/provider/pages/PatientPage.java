package com.pregopower.provider.pages;

import org.testng.AssertJUnit;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.text.html.HTMLDocument.Iterator;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.pregopower.provider.utility.ReadandWrite_Excel;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

public class PatientPage {
	
	WebDriver driver;
	
	By PregoPowerAPP =By.xpath("//*[@class='nav-link dropdown-toggle nav-link-']");
	By ProviderApp = By.xpath("//*[@class='nav-link-https--uatphysicianpregopowercom']");
	By UserEmail =By.id("signinemail");
	By closepopup = By.xpath("//*[@class='close close_subscribe_popup']");
	By Userpassword=By.id("signinpassword");
	By Loginbutton=By.id("btn-login");
	//By Patients  = By.xpath("//a[contains(text(),' Patients ')]");
	By Patients  = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-layout[1]/section[1]/div[1]/app-header[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]");
	//By AddNewPatient = By.xpath("//body/app-root[1]/div[1]/app-layout[1]/section[1]/app-patient-list[1]/div[1]/div[2]/button[2]");
	By AddNewPatient = By.cssSelector("div.container-fluid section:nth-child(1) app-patient-list:nth-child(3) div.row.mt-3.mb-2:nth-child(1) div.col-md-5.col-sm-6.text-right > button.btn.btn-primary.btn-sm.mx-1:nth-child(3)");
	By FirstName =By.xpath("//*[@name='fName']");
	By MiddelName=By.xpath("//*[@name='mName']");
	By LastName =By.xpath("//*[@name='lName']");
	By BloodGroup= By.xpath("//*[@id='bloodgrp']");
	By Email=By.xpath("//*[@name='email']");
	By PhoneNumber=By.xpath("//*[@name='contactno']");
	By AlternatePhoneNumber = By.xpath("//*[@name='alternate_contactno']");
	By Country = By.xpath("//*[@name='country_code']");
	By State = By.xpath("//*[@name='state']");
	By City = By.xpath("//*[@name='city']");
	By zip =By.xpath("//*[@name='zip']");
	By SaveButton=By.xpath("//*[contains(text(),'Save')]");
	By ClanderButton=By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/app-add-update-patient[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/select-date[1]/div[1]/div[1]/div[1]/button[1]");
	By DateOfBirth=By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/app-add-update-patient[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/select-date[1]/div[1]/div[1]/div[1]/button[1]");
	By SelectYear=By.xpath("//*[@title='Select year']");
	By SelectMonth=By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/app-add-update-patient[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/select-date[1]/div[1]/div[1]/ngb-datepicker[1]/div[1]/ngb-datepicker-navigation[1]/ngb-datepicker-navigation-select[1]/select[1]");
	By SelectDate=By.xpath("//div[contains(text(),'20')]");
	By Adreess=By.id("comment");
	By UpalodBulkPatients= By.xpath("//body/app-root[1]/div[1]/app-layout[1]/section[1]/app-patient-list[1]/div[1]/div[2]/div[1]");
	By DownlodaSampleExel=By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-layout[1]/section[1]/app-patient-list[1]/div[1]/div[2]/button[1]");
	By UploadCloseButton= By.xpath("//button[contains(text(),'Close')]");
	By SearchPatients=By.xpath("//input[@placeholder='Search Patients']");
	public PatientPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clickOnProvider() throws InterruptedException{

		driver.findElement(PregoPowerAPP).click();
		
		driver.findElement(ProviderApp).click();
		
		
	}
	public void Login ( String username , String password ) throws InterruptedException, IOException{
		//String username , String password
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("ID :-" + mainWindowHandle  );
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
		
        while (iterator.hasNext()) {
        	System.out.println("Login");
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                System.out.println("ID :-" + ChildWindow  );
                ReadandWrite_Excel d= new ReadandWrite_Excel();
        		ArrayList data = d.getData("login");
                driver.findElement(UserEmail).sendKeys(username);
 			   driver.findElement(Userpassword).sendKeys(password);
 			   driver.findElement(Loginbutton).click();
 			  
         }
        }
   
		}
	
	public void addNewPatient( ) throws InterruptedException, IOException{
		//String Fname, String Mname ,String Lname
		try {
			WebElement element =  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(Patients)));
		       ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		       System.out.println("Element is clickable");
		       
		     }
		catch(Exception e) {
		       System.out.println("Element isn't clickable");
		    }
		//driver.findElement(Patients).click();
		Thread.sleep(2000);

		
		driver.findElement(AddNewPatient).click();
		System.out.println("amit");
    ReadandWrite_Excel d= new ReadandWrite_Excel();
	
		ArrayList data = d.getData("login");
		
		
		String abcd =  (String)data.get(2);
		String abcde =  (String)data.get(3);
		System.out.println(data.get(1));
		driver.findElement(FirstName).sendKeys(data.get(1).toString());
		driver.findElement(MiddelName).sendKeys(abcd);
		driver.findElement(LastName).sendKeys(abcde);
		driver.findElement(ClanderButton).click();
		
		Select Month = new Select(driver.findElement(SelectMonth));
		
		Month.selectByVisibleText("Mar");
		Thread.sleep(2000);
		Select year = new Select(driver.findElement(SelectYear));
		year.selectByValue("1999");
		
		//Thread.sleep(2000);
		//String a = "25" ;
		//div[contains(text(),'+a+')]
		//WebElement link_Date = driver.findElement(SelectDate);
		//WebElement link_Date = driver.findElement(By.xpath("//*[@class='ngb-dp-day ng-star-inserted']/div[contains(text(),'16')]"));
		/*System.out.println(link_Date);
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder
                .moveToElement(link_Date)
                .click().build();
		//Thread.sleep(2000);
		mouseOverHome.perform();*/
		
		List<WebElement> column = driver.findElements(By.xpath("//*[@class='ngb-dp-day']"));
		 System.out.println("Size of List: "+column.size());
		
		for(WebElement cell:column){
			   System.out.println(cell.getText()); 
			   if (cell.getText().equals("14")){
			      //cell.findElement(By.linkText("13"));
				   cell.click();
			     /* Actions builder = new Actions(driver);
					Action mouseOverHome = builder
			                .moveToElement(cell)
			                .click().build();
					Thread.sleep(2000);
					mouseOverHome.perform();*/
			      break;
			 }
		}
		
		/*int count=driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']")).size();
        System.out.println(column.get(count));
		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']")).get(i).getText();
		if(text.equalsIgnoreCase("21"))
		{
			driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']")).get(i).click();
		break;
		}
		}*/
		/*WebElement link_Date = driver.findElement(By.xpath("//div[contains(text(),'"+a+"')]"));
		System.out.println(link_Date);
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder
                .moveToElement(link_Date)
                .click().build();
		Thread.sleep(2000);
		mouseOverHome.perform();*/
		
		Select Blood = new Select(driver.findElement(BloodGroup));
		Blood.selectByVisibleText("A+ve");
		driver.findElement(Email).sendKeys("johng4569i9bb51@yopmail.com");
		driver.findElement(PhoneNumber).sendKeys("7885585484");
		// India
		Select country  = new Select(driver.findElement(Country));
		country.selectByVisibleText("India");
		Select state   = new Select(driver.findElement(State));
		state.selectByVisibleText("Maharashtra ");
		driver.findElement(City).sendKeys("pune");
		driver.findElement(zip).sendKeys("1234567");
		driver.findElement(Adreess).sendKeys("305 B pune ");
		driver.findElement(SaveButton).click();
		
	}
	
	public void  UpalodBulkPatients() throws InterruptedException, IOException{
		driver.findElement(UpalodBulkPatients).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\BULKUPLOAD\\fileuplaod.exe");
		Thread.sleep(5000);
		driver.findElement(UploadCloseButton).click();
	}
	
	public void DownloadSampleExcel(){
		//String downloadPath=System.getProperty("user.dir");
		
		
		driver.findElement(DownlodaSampleExel).click();
		

	/*String dowloadpath1=	System.getProperty("user.dir");
	
	if(f.exists())

	{

	AssertJUnit.assertTrue(f.exists());

	if(f.delete())

	System.out.println("file deleted");

	}*/
	}
	
	public void SearchPatients(String SearchName ){
		
	driver.findElement(SearchPatients).sendKeys(SearchName);
		
	}

}
