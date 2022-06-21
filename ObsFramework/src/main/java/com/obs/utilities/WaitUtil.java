package com.obs.utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obs.Constants.constants;



public class WaitUtil {
	WebDriver driver;
	public WebDriverWait wait;

	 public WaitUtil(WebDriver driver)
		{
			this.driver = driver;
			
	}
	 
	

	


	public void waitforElementVisible(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 
	 }

	public void implicitWait() {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(constants.IMPLICIT_WAIT));
	}

	public void waitforElementClick(WebElement element) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
