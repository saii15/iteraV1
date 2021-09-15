package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By txtusername= By.name("Username");
	By txtpassword= By.name("Password");
	By btnlogin= By.name("login");
	By btnLogout= By.xpath("//a[contains(text(),'Log out')]");
	
	public WebElement setUsername()
	{
		return driver.findElement(txtusername);
	}
	
	public WebElement setPassword()
	{
		return driver.findElement(txtpassword);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(btnlogin);
	}
	
	public WebElement clickLogout()
	{
		return driver.findElement(btnLogout);
	}
	
	public void Login(String username, String password)
	{
		setUsername().sendKeys(username);
		setPassword().sendKeys(password);
	}
	
	

}
