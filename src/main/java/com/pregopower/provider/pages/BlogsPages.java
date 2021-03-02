package com.pregopower.provider.pages;

import java.util.concurrent.TimeUnit;

//import org.apache.commons.math3.util.OpenIntToDoubleHashMap.Iterator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.sun.glass.ui.Screen;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import net.bytebuddy.asm.Advice.Return;


public class BlogsPages {

	WebDriver driver;

	By Blogs = By.xpath("//*[@class='nav-link nav-link--blogs']");
	By BabyProduc = By.xpath("//*[@class='nav-link nav-link--referral-home']");
	By Knowledgecenter = By.xpath("//*[@class='nav-link active nav-link--knowledge-center is-active']");
	By pregopwoerapp = By.xpath("//*[@class='nav-link dropdown-toggle nav-link-']");
	By joinus = By.xpath("//a[contains(text(),'Join Us Here')]");
	By closepopup = By.xpath("//*[@class='close close_subscribe_popup']");
	By recentpost = By.xpath("//*[@class= 'owl-page']");
	By customloginlink = By.id("custom_global_popup_left_cross");
	By recentpostclick = By.xpath("//div[@class='custom_blog_view_right']/div/a[contains(text(),'May I travel by air during pregnancy?')]");
	By recentmessage = By.xpath("//div[@class='field field--name-node-title field--type-ds field--label-hidden field__item']/h2");
	// By dropdown=By.xpath("//*[@class='svg-inline--fa fa-angle-down
	// fa-w-10']");
	By dropdown = By.xpath("//*[@class='custom_blog_terms']");
	By dropdwon1 = By.xpath("//*[@class='fontawesome-icon-inline custom_blog_categories_fonticon']");
	By firstName = By.id("edit-name-first");
	By lastname = By.id("edit-name-last");
	By email = By.id("edit-email");
	By RadioYes = By.id("edit-evaluation-yes");
	By radioNo = By.id("edit-evaluation-no");
	By editfeedback = By.id("edit-feedback");
	By submit = By.id("edit-submit");
	By BookMark = By.xpath("//*[@class='custom_kc_loginredirect']");
	By signinEmail= By.id("signinemail");
	By signinpassword= By.id("signinpassword");
	By SigninButton=By.id("btn-login");
	By commentname2=By.xpath("//input[@id='edit-name']");
	By commentName=By.id("edit-name--2");
	By commentEmail= By.id("edit-field-comment-email-0-value");
	By commentedit=By.id("edit-comment-body-0-value");
	By commentMath=By.xpath("//*[@class='field-prefix input-group-text']");//for get text math 
	By commentcapta=By.id("edit-captcha-response");
	By commmentsubmit=By.xpath("//button[contains(text(), 'Submit Comment')]");
	By validaitonMessageLeaveForComment=By.xpath("//*[@class='js-ajax-comments-messages alert alert-dismissible fade show col-12 alert-danger']");
	By leaveforcommentSuccuessMessage=By.xpath("//*[@class='js-ajax-comments-messages alert alert-dismissible fade show col-12 alert-success']");
	By subscribeEmail=By.xpath("//*[@id='edit-mail-0-value--2']");
	By subscribeButton=By.xpath("//button[contains( text(),'Subscribe')]");
	By subscribevalidationmessage= By.xpath("//*[@class='alert alert-dismissible fade show col-12 alert-success']");
	By subcribeclose = By.xpath("//button[@class='close']");
	By bookmark=By.xpath("//img[ancestor::a[contains(@class,'custom_kc_loginredirect')]]");
	By bookmarkemail=By.id("signinemail");
	By bookmarkpassword=By.id("signinpassword");
	By bookmarkbutton=By.id("btn-login");
	public BlogsPages(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		driver.findElement(closepopup).click();
	}

	public void homePageOptions1() {
		//driver.findElement(customloginlink).click();
		//driver.findElement(Blogs).click();
		SoftAssert softassert = new SoftAssert();
		// softassert.assertEquals("BABY PRODUCT", "BABY PRODUCT");
		boolean actRuslt = driver.findElement(BabyProduc).isDisplayed();
		softassert.assertTrue(actRuslt, "Baby product not dislpyed");
		boolean actreult1 = driver.findElement(Blogs).isDisplayed();
		softassert.assertTrue(actreult1, "Blogs product not dislpyed");
		boolean actresult2 = driver.findElement(Knowledgecenter).isDisplayed();
		softassert.assertTrue(actresult2, "Knowledgecenter product not dislpyed");
		boolean actresult3 = driver.findElement(joinus).isDisplayed();
		softassert.assertTrue(actresult3, "joinus product not dislpyed");
	}

	public void closepoplink() {
		driver.findElement(customloginlink).click();
	}

	public void reccentpages() throws InterruptedException {

		// driver.findElement(Blogs).click();
		// Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement Element = driver.findElement(closepopup);

		js.executeScript("arguments[0].scrollIntoView()", Element);
		Element.click();
		java.util.List<WebElement> myElements = driver.findElements(recentpost);
		for (WebElement e : myElements) {
			e.click();
		}

	}

	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)");
		WebElement Element = driver.findElement(closepopup);

		//js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Thread.sleep(3000);
		Element.click();
	}

	public void waitForElement(String item) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(item)));
	}

	public void recentPost() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(recentpostclick).click();
		// Thread.sleep(100);
		String ab = driver.findElement(recentmessage).getText();
		// softassert.assertAll(ab);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(ab, "May I travel by air during pregnancy?");

	}

	public void dropdown() throws InterruptedException {
		driver.findElement(Blogs).click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,-100)");

		driver.findElement(dropdwon1).click();
		Thread.sleep(3000);
		java.util.List<WebElement> ddMenu = driver.findElements(dropdown);

		String arr[] = { "Pre Pregnancy", "Pregnancy", "Getting ready for a baby", "Fourth Trimester", "Nutrition",
				"Wellness", "Lactation", "Recipes", "Special Pregnancy Conditions" };

		for (int i = 0; i < ddMenu.size(); i++) {

			// WebElement element = ddMenu.get(i);

			// String inner = element.getText();
			// System.out.println("value from Drop Down " + inner);
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(arr[i], ddMenu.get(i).getText());

		}

	}

	public void blogComment(String firstname, String latname, String Email, String feedback) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastname).sendKeys(latname);
		driver.findElement(email).sendKeys(Email);
		driver.findElement(RadioYes).click();
		driver.findElement(editfeedback).sendKeys(feedback);
		js.executeScript("window.scrollBy(0,100)");
		// driver.findElement(submit).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(submit)).click().perform();
	}

	/*
	 * public void setFirstName(String firstname){
	 * driver.findElement(firstName).sendKeys(firstname); } public void
	 * setLastName(String latname){
	 * driver.findElement(lastname).sendKeys(latname); } public void
	 * setEmail(String Email){ driver.findElement(email).sendKeys(Email); }
	 * public void setFeedback(String feedback){
	 * driver.findElement(editfeedback).sendKeys(feedback); } public void
	 * clicRadio(){ driver.findElement(RadioYes).click(); } public void
	 * clickSubmit(){ driver.findElement(submit).click(); } public void
	 * blogComment( String firstname , String latname , String Email , String
	 * feedback ) throws InterruptedException{ //JavascriptExecutor js =
	 * (JavascriptExecutor) driver;
	 * //js.executeScript("window.scrollBy(0,350)");
	 * this.setFirstName(firstname); this.setLastName(latname);
	 * this.setEmail(Email); this.clicRadio(); this.setFeedback(feedback);
	 * js.executeScript("window.scrollBy(0,100)");
	 * //driver.findElement(submit).click(); Actions act = new Actions(driver);
	 * act.moveToElement(driver.findElement(submit)).click().perform();
	 * 
	 * 
	 * }
	 */
   public void leaveForComment( String Name , String Email , String comment ) throws InterruptedException{
	   int result = 0;
	   driver.navigate().refresh();
	   WebElement element = driver.findElement(commentname2);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	   js.executeScript("arguments[0].scrollIntoView();", element);
	   element.sendKeys(Name);
	   driver.findElement(commentEmail).sendKeys(Email);
	   driver.findElement(commentedit).sendKeys(comment);
	  String abcd = driver.findElement(commentMath).getText().trim();
	  
	  
	 // this logic for only addition a splitting purpose 
	  String removespace = abcd.replaceAll("\\s+", "");
	  String[] parts = removespace.split("\\+");
	  String part1 = parts[0];
	  String part2 = parts[1];
	  String[] parts1 = part2.split("\\=");
	  String part11 = parts1[0];
	  int summation = Integer.parseInt(part1) + Integer.parseInt(part11);
	  String final_value = String.valueOf(summation);
	  
	 
	  driver.findElement(commentcapta).sendKeys(final_value);
	  WebElement Element = driver.findElement(closepopup);

		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Thread.sleep(3000);
		Element.click();
	   WebDriverWait w = new WebDriverWait(driver, 30);
	   WebElement element1 = w.until(ExpectedConditions.elementToBeClickable(commmentsubmit));
	   element1.click();
	 String abce=driver.findElement(leaveforcommentSuccuessMessage).getText();
	 SoftAssert a= new SoftAssert();
	  a.assertEquals("Your comment has been queued for review by site administrators and will be published after approval.", abce);
	 
	  driver.findElement(By.xpath("//*[@class='close']")).click();
   }
   
   public void leaveForCommentSubmit(String Name , String Email ) throws InterruptedException{
	   //JavascriptExecutor js = (JavascriptExecutor) driver;
	   //js.executeScript("window.scrollBy(0,-250)", "");
	   
	   driver.navigate().refresh();
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,850)");
		WebElement Element = driver.findElement(closepopup);

		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Thread.sleep(3000);
		Element.click();
	   WebElement element = driver.findElement(commentname2);
	   
	   
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	   js.executeScript("arguments[0].scrollIntoView();", element);
	   element.sendKeys(Name);
	   driver.findElement(commentEmail).sendKeys(Email);
	   
	   WebDriverWait w = new WebDriverWait(driver, 30);
	   WebElement element1 = w.until(ExpectedConditions.elementToBeClickable(commmentsubmit));
	   element1.click();
	  String ab= driver.findElement(validaitonMessageLeaveForComment).getText();
	  System.out.println(ab);
	  SoftAssert a= new SoftAssert();
	  a.assertEquals("Comment field is required.", ab);  
   }
   public void subcribe (String Email ) throws InterruptedException{
	   
	   driver.navigate().refresh();
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,850)");
		WebElement Element = driver.findElement(closepopup);

		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		Thread.sleep(3000);
		Element.click();
	WebElement element=	driver.findElement(subscribeEmail);
		js.executeScript("arguments[0].scrollIntoView();", element);
		   element.sendKeys(Email);
		   driver.findElement(subscribeButton).click();
		   
		   String element5	= driver.findElement(subscribevalidationmessage).getText();
		   SoftAssert a= new SoftAssert();
			  a.assertEquals("×You will receive a confirmation e-mail shortly containing further instructions on how to complete your subscription.",element5);
			  Thread.sleep(5000);
			  driver.findElement(subcribeclose).click();
		   
   }
   public void bookmark ( String username , String password ) throws InterruptedException{
	   driver.navigate().refresh();
	   driver.findElement(bookmark).click();
	   Thread.sleep(3000);
	   driver.findElement(bookmarkemail).sendKeys(username);
	   driver.findElement(bookmarkpassword).sendKeys(password);
	   driver.findElement(bookmarkbutton).click();
	   
   }
}
