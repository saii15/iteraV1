package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
	
	public WebDriver driver;
	
	public FormPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By link= By.linkText("Test Automation");
	By name= By.id("name");
	By ContNumber= By.id("phone");
	By eid= By.id("email");
	By pwd= By.id("password");
	By addr= By.id("address");
	By sub= By.name("submit");
	By gender= By.id("female");
	By day= By.id("thursday");
	By dropDown = By.xpath("//div[@class='form-group']/select");
	By exp= By.xpath("//label[contains(text(),'3 years')]");
	By framework= By.xpath("//label[contains(text(),'Cucumber')]");
	By uploading= By.id("inputGroupFile02");
	
	public  WebElement getLink()
	{
		return driver.findElement(link);
	}
	
	public WebElement getName()
	{
		return driver.findElement(name);
	}
	
	public WebElement getContact()
	{
		return driver.findElement(ContNumber);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(eid);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getAdress()
	{
		return driver.findElement(addr);
	}
	
	public WebElement clkSubmit()
	{
		return driver.findElement(sub);
	}
	
	public WebElement clkGender()
	{
		return driver.findElement(gender);
	}
	
	public WebElement clkDay()
	{
		return driver.findElement(day);
	}
	
	public void clkDropdown()
	{
		
		Select sd= new Select(driver.findElement(dropDown));
		sd.selectByVisibleText("Italy");
		  
	}
	
	public WebElement clkExperince()
	{
		return driver.findElement(exp);
	}
	
	public WebElement clkFramework()
	{
		return driver.findElement(framework);
	}
	
	public WebElement clkUpload()
	{
		return driver.findElement(uploading);
	}
}
