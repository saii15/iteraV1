package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pageObjects.CustomerPage;
import com.pageObjects.LoginPage;
import com.utilities.BaseClass;

public class TC_CreateInfoTest_003 extends BaseClass {

	public WebDriver driver;
	public static Logger log= Logger.getLogger(TC_CreateInfoTest_003.class.getName());
	
	 @BeforeTest
		public void init() throws IOException
		{
		 driver= initializeDriver();
		 driver.get(prop.getProperty("baseUrl"));
		 log.info("URl is opend");
	    }
	 
	@Test
	public void crateInfo() throws IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Username Entered");
		log.info("Password Entered");
		lp.clickLogin().click();
		log.info("Login Successfull");
		
		CustomerPage cp= new CustomerPage(driver);
		cp.getInfo().click();
		log.info("Clicked on Create Button");
		cp.enterName().sendKeys("Sayali");
		log.info("Name entered");
		cp.enterCompany().sendKeys("QG");
		log.info("Company name entered");
		cp.enterAddress().sendKeys("Mumbai");;
		log.info("Address entered");
		cp.enterCity().sendKeys("Thane");;
		log.info("City entered");
		cp.enterPhone().sendKeys("7896532155");;
		log.info("Phone entered");
		cp.enterEmail().sendKeys("test78@gmail.com");;
		log.info("Email entered");
		cp.clkSubmit().click();
		log.info("Clicked on Submit");
		//cp.searchByName().sendKeys("sayali");
		//cp.clkSearch().click();
		//cp.clkDetails().click();
		cp.countDetails();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	} 
}
