package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	public WebDriver initializeDriver() throws IOException
	{	
	
	  log = Logger.getLogger("itera");
	  PropertyConfigurator.configure("log4j.properties");
	  
	  prop= new Properties();
	  FileInputStream fis=new FileInputStream("src/main/java/Config/config.properties");
	  prop.load(fis);
	  String browserName=prop.getProperty("browser");
	  //String browserName=System.getProperty("browser");
	  System.out.println(browserName);
	  if(browserName.equals("chrome"))
	  {
		  //execute in chrome driver	
		 //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/WebDrivers/chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		
	  }
	  else if (browserName.equals("firefox"))
	  {
		//firefox code
		  WebDriverManager.firefoxdriver().setup();
		   //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/WebDrivers/geckodriver.exe"); 
		   driver= new FirefoxDriver();
		
	  }
	  else if (browserName.equals("IE"))
	  {
	      //	IE code
	  }
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(dest));// for fileUtils add apache coomon io dependency in pom
		System.out.println("Screenshot taken");
		return dest;
	}
	
}
