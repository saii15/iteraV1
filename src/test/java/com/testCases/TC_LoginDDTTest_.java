package com.testCases;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObjects.LoginPage;
import com.utilities.BaseClass;
import com.utilities.XLUtils;

public class TC_LoginDDTTest_ extends BaseClass
{
	public static Logger log = Logger.getLogger(TC_LoginDDTTest_.class.getName());
	public WebDriver driver;
	
	 @BeforeTest
		public void init() throws IOException
		{
		 driver= initializeDriver();
	    }
	 
	@Test(dataProvider="LoginData")
	public void loginDDTTest(String user, String pwd) throws IOException
	{
		driver.get(prop.getProperty("baseUrl"));
		log.info("URl is opend");
		LoginPage lp= new LoginPage(driver);
		lp.setUsername().sendKeys(user);
		//lp.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Username Entered");
		lp.setPassword().sendKeys(pwd);
		log.info("Password Entered");
		lp.clickLogin().click();
		log.info("Login Successfull");
		
		if(driver.getCurrentUrl().equals("https://itera-qa.azurewebsites.net/Dashboard"))
		{
			Assert.assertTrue(true);
			log.info("Login test Passed");
			lp.clickLogout().click();
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
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/utilities/Book1.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "TestData");
		int colcount=XLUtils.getCellCount(path,"TestData",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"TestData", i,j);//1 0
			}
				
		}
	return logindata;
	}

	
}
