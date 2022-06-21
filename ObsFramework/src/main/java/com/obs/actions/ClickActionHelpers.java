package com.obs.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActionHelpers {
	
	
	private WebDriver driver;

	public ClickActionHelpers(WebDriver driver) {
		this.driver = driver;

	}
	public void click(WebElement element) throws Exception {
		
		try{
			element.click();
		}

		catch (Exception e) {
			throw new Exception("click (ClickActionHelper)" + e.getMessage());
		}
	}

	public void rightClick(WebDriver driver, String elementName) throws Exception {
		try {
			Actions action = new Actions(driver);
			action.contextClick().build().perform();
		} catch (Exception e) {
			throw new Exception("rightclick (ClickActionHelper)" + e.getMessage());
		}

	}
	public void doubleClick(WebDriver driver, String elementName) throws Exception {
		try {
			
			Actions actions = new Actions(driver);
			actions.doubleClick().build().perform();
		} catch (Exception e) {
			throw new Exception("doubleclick (ClickActionHelper)" + e.getMessage());
		}

	}
	

}
