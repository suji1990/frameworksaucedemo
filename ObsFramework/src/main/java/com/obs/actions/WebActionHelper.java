package com.obs.actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WebActionHelper {
	// method to launch the URL

		public void lauchURL(WebDriver driver, String url) {
			try {
				driver.get(url);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			} catch (Exception e) {
				System.out.print("Launch Exception(WebActionHelpers):" + e);
				

			}
		}

		public String getCurrentTitle(WebDriver driver) {
			String Title = "";
			try {
				Title = driver.getTitle();
			} catch (Exception e) {
				System.out.print("URL Exception(WebActionHelpers):" + e);
			}
			return Title;
		}

		public void acceptAlert(WebDriver driver) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				System.out.print("alert Exception(WebActionHelpers):" + e);
			}

		}

		public void dismissAlert(WebDriver driver) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			} catch (Exception e) {

				System.out.print("dismissalert Exception(WebActionHelpers):" + e);
			}

		}

		public void navigateToUrl(WebDriver driver, String url) {
			try {
				driver.navigate().to(url);

			} catch (Exception e) {
				System.out.print("NavigatetoUrl Exception(WebActionHelpers):" + e);

			}

		}

		public void navigateToBack(WebDriver driver) {
			try {
				driver.navigate().back();

			} catch (Exception e) {

				System.out.print("NavigatetoUrl Exception(WebActionHelpers):" + e);
			}

		}

		public void navigateToforward(WebDriver driver) {
			try {
				driver.navigate().forward();

			} catch (Exception e) {

				System.out.print("Navigatetoforward Exception(WebActionHelpers):" + e);
			}

		}

		public void toClose(WebDriver driver) {
			try {
				driver.close();

			} catch (Exception e) {
				System.out.print("toClose Exception(WebActionHelpers):" + e);
			}

		}

		public void ToRefresh(WebDriver driver) {
			try {
				driver.navigate().refresh();

			} catch (Exception e) {

				System.out.print("toClose Exception(WebActionHelpers):" + e);
			}

		}

}
