package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage {

	public WebDriver driver;
	
	public CustomerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By create= By.xpath("//a[text()='Create New']");
	By name= By.id("Name");
	By company= By.id("Company");
	By addr= By.id("Address");
	By city= By.id("City");
	By phone= By.id("Phone");
	By email= By.id("Email");
	By submit= By.cssSelector("[value='Create']");
	By textbox= By.name("searching");
	By search= By.cssSelector("[value='Search']");
	By details= By.xpath("//a[contains(text(),'Details')]");
	By countRows= By.cssSelector(".table.table-hover  tr");
	
	public WebElement getInfo()
	{
		return driver.findElement(create);
	}
	
	public WebElement enterName()
	{
		return driver.findElement(name);
	}
	
	public WebElement enterCompany()
	{
		return driver.findElement(company);
	}
	
	public WebElement enterAddress()
	{
		return driver.findElement(addr);
	}
	
	public WebElement enterCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement enterPhone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement clkSubmit()
	{
		return driver.findElement(submit);
	}
	
	public WebElement searchByName()
	{
		return driver.findElement(textbox);
	}
	
	public WebElement clkSearch()
	{
		return driver.findElement(search);
	}
	
	public WebElement clkDetails()
	{
		return driver.findElement(details);
	}
	
	public void countDetails()
	{
		int count= driver.findElements(countRows).size();
		System.out.println(count);
	}


}
