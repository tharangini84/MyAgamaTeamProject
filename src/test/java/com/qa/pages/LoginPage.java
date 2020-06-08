package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver Rdriver) 
	{
		this.driver=Rdriver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//span[@class='icon icon-xs mdi-chart-bar']")
	WebElement login;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;

	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement submit;

	@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
	WebElement settings;
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement logoff;
	
	public void login(String u_name,String p_word)
	{
		login.click();
		username.sendKeys(u_name);
		password.sendKeys(p_word);
		
	}
	
	public void signin()
	{submit.click();}
	
	public void logoff() 
	{
		settings.click();
	
		logoff.click();
	}


}
