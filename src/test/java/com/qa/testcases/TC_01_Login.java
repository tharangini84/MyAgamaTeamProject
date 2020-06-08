package com.qa.testcases;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.LoginPage;

public class TC_01_Login extends Library
{
	LoginPage page;
	
	@BeforeMethod
	public void init_Browser()
	{
		browserSetUp();
	}
	
	@Test
	public void FreeCrmLogin()
	{
		page=new LoginPage(driver);
		page.login(properties.getProperty("username"),properties.getProperty("password"));
		page.signin();
	
	}
	
	@AfterMethod	
	public void close()throws IOException
		{
		screenshot();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		page.logoff();
		tearDown();
		}
	
}