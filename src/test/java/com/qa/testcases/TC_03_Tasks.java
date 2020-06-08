package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;

public class TC_03_Tasks extends Library
{
	TasksPage Tpage;
	LoginPage page;
	
	@BeforeMethod
	public void intiBrowser_Login()
	{
		browserSetUp();
		page=new LoginPage(driver);
		page.login(properties.getProperty("username"),properties.getProperty("password"));
		page.signin();
		
	}
	
	@Test
	public void task_Tab()
	{
		Tpage=new TasksPage(driver);
		Tpage.task_Tab();
		Tpage.new_Entry();
		Tpage.enter_Title(properties.getProperty("title"));
		//Tpage.assigned_To("Manjula S");
		Tpage.type_Tab("General Support");
		//Tpage.due_Date("12/07/2014 2:00 PM");
		Tpage.save_Icon();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	@AfterMethod
	public void close() throws IOException
	{
		screenshot();
		page.logoff();
		tearDown();
	}
}
