package com.qa.seleniumutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.baseclass.Library;

public class Utilis extends Library
{
	WebDriver driver;
	public Utilis(WebDriver driver)
	{
	this.driver=driver;
	}
	
	public void gettitle()
	{
		//String title=driver.getTitle();
		System.out.println("Title is:"+driver.getTitle());
		
	}

public void actions(String locator1) 
{
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(locator1))).click().build().perform();
}
public void dropdown(String locator,String pick) 
{
	Select drop=new Select(driver.findElement(By.xpath(locator)));
	drop.selectByVisibleText(pick);
}
//public void ExplicitWait(String locator) 
//{
//	WebDriverWait wait=new WebDriverWait(driver,20);
//	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(locator))));
//	
//}
}
