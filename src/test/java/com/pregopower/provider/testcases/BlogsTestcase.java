package com.pregopower.provider.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pregopower.provider.pages.Base;
import com.pregopower.provider.pages.BlogsPages;

public class BlogsTestcase extends Base {

	BlogsPages obj;

	@BeforeTest

	public void setup() throws IOException {
		driver = intializeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.pregopower.com/");
		driver.navigate().refresh();

	}

	@Test(enabled = false)

	public void click() throws InterruptedException {

		obj = new BlogsPages(driver);
		Thread.sleep(1000);
		// obj.closePopup().click();;
		// obj.clickOnBlogs().click();
		// BlogsPage obj = new BlogsPage(driver);
		// obj.clickOnBlogs();
	}

	@Test(priority = 0)

	public void TC01() throws InterruptedException {
		obj = new BlogsPages(driver);
		try{
			
		obj.closepoplink();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		obj.homePageOptions1();

	}

	@Test(priority = 2)
	public void TC02() throws InterruptedException {
		obj = new BlogsPages(driver);
		// obj.closePopup();
		obj.reccentpages();
	}

	@Test(priority = 3)

	public void TC03() throws InterruptedException {
		obj = new BlogsPages(driver);
		obj.recentPost();
	}

	@Test(priority = 1)

	public void TC04() throws InterruptedException {
		obj = new BlogsPages(driver);
		
		obj.dropdown();
	}
	
	@Test(priority=5)
	
	public void TC05( ) throws InterruptedException{
		
		obj = new BlogsPages(driver);
	   // obj.blogComment("Amittt", "Leeee", "amit1236789@yopmail.com", "very good ");
		obj.blogComment("Amittt", "Leeee", "amit1236789@yopmail.com", "very good ");
	}
	
	@Test(priority=6)
	
	public void TC06() throws InterruptedException{
		obj = new BlogsPages(driver);
		obj.scrollDown();
	    obj.leaveForComment("Amit ", "amit787564@yopmail.com", "Test very good");
	}
@Test(priority=7)
	
	public void TC07() throws InterruptedException{
		obj = new BlogsPages(driver);
		//obj.scrollDown();
	    obj.leaveForCommentSubmit("amit", "amit7875@gmail.com");
	}
@Test(priority=8)
 public  void TC08() throws InterruptedException{
	obj.subcribe("amit78@yopmail.com");
}

@Test(priority=9 ,dataProvider="getdata" )
public void TC09(String username, String password) throws InterruptedException{
	//obj.bookmark("amit7@yopmail.com", "1234");
	obj.bookmark(username, password);
	
	
}
@DataProvider
public Object [][] getdata(){
	
	Object[][] data = new Object[1][2];
	data[0][0] ="amit7@yopmail.com";
	data[0][1] = "1234";
	return data;
	
}
	
}
