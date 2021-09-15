package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.FormPage;
import com.pageObjects.LoginPage;
import com.utilities.BaseClass;

public class TC_FormTest_002 extends BaseClass {

	public WebDriver driver;
	public static Logger log= Logger.getLogger(TC_FormTest_002.class.getName());
	
	@BeforeTest
		public void init() throws IOException
		{
		 driver= initializeDriver();
		 driver.get(prop.getProperty("baseUrl"));
		 log.info("URl is opend");
	    }
	
	@Test
	public void formTest() throws IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Username Entered");
		log.info("Password Entered");
		lp.clickLogin().click();
		log.info("Login Successfull");
		
		FormPage fp= new FormPage(driver);
		fp.getLink().click();
		log.info("Clicked  on Link");
		fp.getName().sendKeys("Sayali Ingawale");
		log.info("entered Name");
		fp.getContact().sendKeys("7350704654");
		log.info("entered Contact");
		fp.getEmail().sendKeys("sayali.ibgawale6@gmail.com");
		log.info("entered Email");
		fp.getPassword().sendKeys("sayali123");
		log.info("entered Password");
		fp.getAdress().sendKeys("Roha");
		log.info("entered Address");
		//fp.clkSubmit().click();
		//log.info("Clicked on Submit");
		fp.clkGender().click();
		log.info("Gender selected");
		fp.clkDay().click();
		log.info("Day selected");
		fp.clkDropdown();
		log.info("Dropdown selected");
		fp.clkExperince().click();
		log.info("Experience selected");
		fp.clkFramework().click();
		log.info("Framework selected");
		//fp.clkUpload().sendKeys("C:\\Users\\HP\\Documents\\Shivanand Resume (1).pdf");
		//log.info("File Uploaded");
		}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	} 
}
