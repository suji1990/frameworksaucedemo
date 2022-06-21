package com.obs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.actions.ClickActionHelpers;
import com.obs.actions.SendKeysActionHelpers;
import com.obs.utilities.WaitUtil;

public class LoginPage {
	public SendKeysActionHelpers send;
	public ClickActionHelpers click;
	public WaitUtil waitutilpage;
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='user-name' and @name='user-name']") 
	WebElement uname1;
	
	@FindBy(xpath="//input[@id='password' and @name='password']") 
	WebElement pwd1;
	
	@FindBy(xpath="//input[@id='login-button' and @name='login-button']")
	WebElement login;
	
	@FindBy(xpath="//h3[contains(.,'Epic sadface: Username is required')]")
	WebElement emptyErrorMsg;
	
	@FindBy(xpath="//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
	WebElement invalidErrorMsg;
			
	@FindBy(xpath="//span[contains(.,'Products')]")
	WebElement productTitle;
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		send = new SendKeysActionHelpers(driver);
		click=new ClickActionHelpers(driver);
		waitutilpage = new WaitUtil(driver);
		
	}
	
	public void loginAction(String uname,String pword) throws Exception
	{
	
		send.clearTextandSendkeys(uname1, uname);
		send.clearTextandSendkeys(pwd1, pword);
	
		waitutilpage.waitforElementClick(login);
		click.click(login);
		
		
	}
	public boolean isEmptyErrorMsgDisplayed() {
		return emptyErrorMsg.isDisplayed();
	}
	
	public boolean isInvalidErrorMsgDisplayed() {
		return invalidErrorMsg.isDisplayed();
	}
	
	
	public void click() throws Exception {
		click.click(login);
		
		// TODO Auto-generated method stub
		
	}

	public boolean ProductTitle() {
		// TODO Auto-generated method stub
		return productTitle.isDisplayed();
	}
	
	
	
	
}
