package com.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage 
{
	WebDriver driver;

	public DocumentsPage(WebDriver Ddriver)
	{
		this.driver=Ddriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Documents')]")
	WebElement documentsPage;
	
	@FindBy(xpath="//*[@href='/documents/new']")
	WebElement newbutton;

	@FindBy(xpath="//div[@name='folder']//input")
	WebElement folder;
	
	@FindBy(xpath="//span[contains(text(),'Attachments')]")
	WebElement attachments;

	@FindBy(xpath="//span[contains(text(),'Exports')]")
	WebElement exports;

	@FindBy(xpath="//input[@autocomplete='new-password' and @name='title']")
	WebElement title;

	@FindBy(xpath="//*[@for='tags']//div")
	WebElement tags;
	
	@FindBy(xpath="//div[@class='selected item addition']//span")
	WebElement add;
	
	@FindBy(xpath="//textarea[@name='description' or @rows='3']")
	WebElement description;
	
	
	@FindBy(xpath="	//input[@name='file']\r\n")
	WebElement file;

	@FindBy(xpath="//input[@name='identifier']")
	WebElement identifier;

	@FindBy(xpath="//*[@class='save icon']")
	WebElement save;
	
	@FindBy(xpath="//button[@class='ui icon button']//i[@class='edit icon']")
	WebElement edit;
	
	
	
	public void documents_Tab()
	{
		documentsPage.click();
		newbutton.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
	}
	
	
	public void folder()
	{	
		     Actions action= new Actions(driver);
		     action.keyDown(Keys.CONTROL).click(folder).click(attachments).build().perform();	
	}
	
	public void enter_Title(String Title)
	{
		title.sendKeys(Title);
	}
	public void enter_Tag(String tagTxt)
	{
		tags.sendKeys(tagTxt);
	}
	public void click_Add() 
	{
		add.click();
	}
	public void enter_Description(String descr)
	{
		description.sendKeys(descr);
	}
	public void upload_File(String path)
	{
		file.sendKeys(path);
	}
	public void enter_Identifier(String identifierTxt)
	{
		identifier.sendKeys(identifierTxt);
	}
	
	public void  hit_Save()
	{
		save.click();
		documentsPage.click();
		
	}
	public void hit_Edit()
	{
		edit.click();
	}
}
