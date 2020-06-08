package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.DocumentsPage;
import com.qa.pages.LoginPage;

public class TC_04_Documents extends Library 

{
	LoginPage page;
	DocumentsPage Dpage;
	@BeforeMethod
	public void intiBrowser_Login()
	{
		browserSetUp();
		page=new LoginPage(driver);
		page.login(properties.getProperty("username"),properties.getProperty("password"));
		page.signin();
		
	}

	@Test(priority=1)
	public void documents_Tab()
	{
		Dpage=new DocumentsPage(driver);
		Dpage.documents_Tab();
		Dpage.folder();
		Dpage.enter_Title(properties.getProperty("Title"));
		//Dpage.enter_Tag(properties.getProperty("Tags"));
		//Dpage.click_Add();
		Dpage.enter_Description(properties.getProperty("Description"));
		Dpage.upload_File(properties.getProperty("File"));
		Dpage.enter_Identifier(properties.getProperty("Identifier"));
		Dpage.hit_Save();
		//Dpage.hit_Edit();
	}
	
	@Test(priority=2)
	public void documents_Edit()
	
	{
		Dpage.hit_Edit();
	}
	@AfterMethod
	public void close() throws IOException
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot();
		page.logoff();
		tearDown();
	}

	
}
