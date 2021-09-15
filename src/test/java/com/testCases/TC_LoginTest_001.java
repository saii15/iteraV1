package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.utilities.BaseClass;

public class TC_LoginTest_001 extends BaseClass
{
	public static Logger log = Logger.getLogger(TC_LoginTest_001.class.getName());
	public WebDriver driver;
	
	 @BeforeTest
		public void init() throws IOException
		{
		 driver= initializeDriver();
		 driver.get(prop.getProperty("baseUrl"));
		 log.info("URl is opend");
	    }
	 
	@Test
	public void loginTest() throws IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Username Entered");
		log.info("Password Entered");
		lp.clickLogin().click();
		log.info("Login Successfull");
		
		if(driver.getPageSource().contentEquals("Welcome sayali12"))
		//if(driver.getCurrentUrl().equals("https://itera-qa.azurewebsites.net/Dashboar"))
		{
			Assert.assertTrue(true);
			log.info("Login test Passed");
		}
		else
		{
			//getScreenshotPath("loginTest",driver);
			Assert.assertTrue(false);
			log.info("Login test Failed");
		}
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	} 

	
}
