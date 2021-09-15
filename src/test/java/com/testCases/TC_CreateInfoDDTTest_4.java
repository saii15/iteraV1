package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObjects.CustomerPage;
import com.pageObjects.LoginPage;
import com.utilities.BaseClass;

public class TC_CreateInfoDDTTest_4 extends BaseClass {

	public WebDriver driver;
	public static Logger log= Logger.getLogger(TC_CreateInfoDDTTest_4.class.getName());
	
	 @BeforeTest
		public void init() throws IOException
		{
		 driver= initializeDriver();
		}
	 
	 @Test(dataProvider="getData")
	public void EnterInfo(String name, String company, String Address, String city, String no, String email ) throws IOException
	{
		driver.get(prop.getProperty("baseUrl"));
		log.info("URl is opend");
		LoginPage lp= new LoginPage(driver);
		lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Username Entered");
		log.info("Password Entered");
		lp.clickLogin().click();
		log.info("Login Successfull");
		
		CustomerPage cp= new CustomerPage(driver);
		cp.getInfo().click();
		log.info("Clicked on Create Button");
		cp.enterName().sendKeys(name);
		log.info("Name entered");
		cp.enterCompany().sendKeys(company);
		log.info("Company name entered");
		cp.enterAddress().sendKeys(Address);
		log.info("Address entered");
		cp.enterCity().sendKeys(city);
		log.info("City entered");
		cp.enterPhone().sendKeys(no);
		log.info("Phone entered");
		cp.enterEmail().sendKeys(email);
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
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][6];           //2 user with 3 value
		                                     //          0        1       2
		data[0][0]="sai";                   //  0   non@qw.com   123    restricted user
		data[0][1]="techm";                   //  1   res@qw.com   567    Non restricted user
		data[0][2]="mumbai";
		data[0][3]="thane";
		data[0][4]="5674534567";
		data[0][5]="saibhbhbh@gmail.com";
		
		data[1][0]="priya";                   
		data[1][1]="amdocs";                  
		data[1][2]="pune";
		data[1][3]="kothrud";
		data[1][4]="5674534677";
		data[1][5]="p34@gmail.com";
		
		return data;
	}
}
