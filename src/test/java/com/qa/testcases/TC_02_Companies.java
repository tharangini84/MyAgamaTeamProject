package com.qa.testcases;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.Library;
import com.qa.pages.CompaniesPage;
import com.qa.pages.LoginPage;

public class TC_02_Companies extends Library
{
	CompaniesPage Cpage;
	LoginPage page;
	
	@BeforeMethod
	public void intiBrowser_Login()
	{
		browserSetUp();
		page=new LoginPage(driver);
		page.login("Itsmanjudinesh@gmail.com","Mmdindiv8285");
		page.signin();
		
	}
	
	@Test
	public void companies_TabClick() throws InterruptedException 
	{
		
		Cpage=new CompaniesPage(driver);
		Cpage.companies_Tab();		
		logger.info("Add New Entry");
		Thread.sleep(8000);
		Cpage.enterName(properties.getProperty("CompanyTitle"));
		Cpage.enterWebsite(properties.getProperty("Website"));
		Cpage.fetchWeb();
		Cpage.address(properties.getProperty("StreetAddress"),properties.getProperty("City"),properties.getProperty("State"),properties.getProperty("Zip"));
		//Cpage.selectCountry("United States");
		//Cpage.selectStatus("Active");
		Cpage.image_upload("C:\\Users\\Sudhakar\\Desktop\\Logo.png");
		Cpage.save_Tab();
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
