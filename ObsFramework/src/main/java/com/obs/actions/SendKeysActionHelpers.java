package com.obs.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKeysActionHelpers {
	
	
	
	
	private WebDriver driver;

	public SendKeysActionHelpers(WebDriver driver) {
		this.driver = driver;

	}
	public void sendkeys(WebElement elementName,String inputText) throws Exception
	{
		try
		{
			elementName.sendKeys(inputText);
		}
		catch(Exception e)
		{
			throw new Exception("sendkeys (SendKeyActionHelper)" + e.getMessage());
		}		
	}


	public void clearTextandSendkeys(WebElement elementName,String inputText)throws Exception
	{
		try
		{
			elementName.clear();
			elementName.sendKeys(inputText);
		}

		catch(Exception e)
		{
			throw new Exception("cleartext (clearTextandSendkeys)"+ e.getMessage());
		}	
	}
}
