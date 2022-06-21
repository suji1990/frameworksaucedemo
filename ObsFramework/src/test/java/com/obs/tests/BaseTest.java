package com.obs.tests;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obs.Constants.constants;
import com.obs.pages.LoginPage;
import com.obs.utilities.ConfigUtil;
import com.obs.utilities.ExcelRead;
import com.obs.utilities.WaitUtil;


public class BaseTest {
	protected WebDriver driver;
	
	protected LoginPage loginpage;
	protected WaitUtil waitutilpage;
	
	protected ConfigUtil configUtil =new ConfigUtil();

	protected String baseUrl =configUtil.getApplicationUrl();
	protected String username =configUtil.getUserName();
	protected String password =configUtil.getPassword();


		@Test
		

		@Parameters("browser")
		@BeforeClass (alwaysRun = true)
		public void setUp(@Optional("chrome") String browsername) {
			String path = System.getProperty("user.dir");
			if (browsername.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", path + configUtil.getPropertyValue("chromepath"));
				driver = new ChromeDriver();
			} else if ((browsername.equals("edge"))) {

				System.setProperty("webdriver.edge.driver", path + configUtil.getPropertyValue("edgepath"));
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			driver.get(baseUrl);

		  
			waitutilpage =new WaitUtil(driver);
			loginpage =new LoginPage(driver);
		}

		@DataProvider()
		public Object[][] userData() throws InvalidFormatException, IOException {
			Object[][] data = ExcelRead.getDataFromExcel(constants.dataProvider_filepath, "testData_Sheet1");
			return data;
		}

		@AfterMethod
		public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
			if (iTestResult.getStatus() == ITestResult.FAILURE) {
				takeScreenShotOnFailure(iTestResult.getName());

			}
		}

		public String takeScreenShotOnFailure(String name) throws IOException {
			String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String destination = constants.screenShot_path + name + dateName + ".png";

			File finalDestination = new File(destination);

			FileUtils.copyFile(source, finalDestination);
			
			return destination;
		}

		@AfterTest
		public void afterTest() {
		}
	}

