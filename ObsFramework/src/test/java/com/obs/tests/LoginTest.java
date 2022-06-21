package com.obs.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.obs.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@BeforeMethod
	public void invokeLogin() {
		lpage = new LoginPage(driver);
	}
	LoginPage lpage;
	  @Test(dataProvider = "userData", priority = 1, groups = "smoke")
	  public void loginAction(String uname1, String pword1) throws Exception {
		 // String expected = "7rmart supermarket";
		 // String actual = loginpage.loginPagetext();
		 // Assert.assertEquals(actual, expected);
		  loginpage.loginAction(uname1, pword1);//from excel sheet
		 // loginpage.loginAction(username, password); //from properties file
	  }
	  
	  
	  
	  @Test(priority=1)
		public void verifyEmptyLogin() throws Exception
		{
			lpage=new LoginPage(driver);
			lpage.loginAction("", "");
			lpage.click();
			Assert.assertTrue(lpage.isEmptyErrorMsgDisplayed(),"Empty error message is not displayed");
			
		}
		//verify user is able to login with wrong username to enter the fields
			@Test(priority=2)
		public void verifyInvalidLogin() throws Exception 
		{
			lpage.loginAction("stan", "secret");
			lpage.click();
			Assert.assertTrue(lpage.isInvalidErrorMsgDisplayed(),"Inalid error message is not displayed");	
			
		}
			//verify user is able to login with  username and password
			//@Test(dataProvider="Credentials")
			@Test(priority=3)
		public void verifyvalidLogin() throws Exception
				{
			
				lpage.loginAction("standard_user", "secret_sauce");
				lpage.click();
			driver.navigate().forward();
			Assert.assertTrue(lpage.ProductTitle(),"Inventory page not displayed");	
				driver.navigate().forward();
			
				}
}
