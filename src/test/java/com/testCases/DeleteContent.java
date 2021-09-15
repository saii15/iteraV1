package com.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DeleteContent
{
        
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://itera-qa.azurewebsites.net/Login/Index");
		driver.findElement(By.name("Username")).sendKeys("sayali123");
		driver.findElement(By.name("Password")).sendKeys("sayali123");
		driver.findElement(By.name("login")).click();
		List<WebElement> list= driver.findElements(By.cssSelector(".btn.btn-outline-danger"));
		System.out.println(list.size());
		/*for(WebElement e:list)
		{
			e.click();
			driver.findElement(By.cssSelector("[value='Delete']")).click();
		}*/
		
		for(int i=0;i<=list.size();i++)
		{
			list.get(i).click();
			driver.findElement(By.cssSelector("[value='Delete']")).click();
		}
		


	}
}