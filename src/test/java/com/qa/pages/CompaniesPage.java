package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CompaniesPage 
{
	WebDriver driver;
	public CompaniesPage(WebDriver Cdriver) 
	{
		this.driver=Cdriver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")
    WebElement companies;
	
	@FindBy(xpath="//*[@href='/companies/new']")
	WebElement newEntry;
	
	@FindBy(xpath="//input[@autocomplete='new-password' and @name='name']")
	//@FindBy(xpath="//*[@class='ui label label right corner']")
	WebElement name;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement save;
	
	@FindBy(xpath="//input[@name='url']")
	WebElement website;
	
	@FindBy(xpath="//button[contains(text(),'Fetch')]")
	WebElement fetch;
	
	@FindBy(xpath="//input[ @placeholder='Street Address']")
	WebElement streetaddress;
	
	@FindBy(name="city")
	WebElement cityaddress;
	
	@FindBy(name="state")
	WebElement stateaddress;
	
	@FindBy(name="zip")
	WebElement zipcode;	
	
	//@FindBy(xpath="//div[ @name='country']")////div[@name='Country' and @class='ui fluid search selection dropdown']
	@FindBy(name="country")
	WebElement country;
	
	//@FindBy(xpath="//div[ @name='status']")
	@FindBy(name="status")
	WebElement status;
	
	
	@FindBy(xpath="//input[@name='image']")
	WebElement image;
	
	public void companies_Tab() throws InterruptedException 
	{
		companies.click();
		// explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/companies/new']")));
		newEntry.click();
		
	}
	
	public void enterName(String Name)
	{
		
	driver.navigate().refresh();
	driver.navigate().refresh();
	name.sendKeys(Name);		
	}
	
	public void enterWebsite(String Website)
	
	{
		website.sendKeys(Website);
	}
	
	public void fetchWeb()
	{		
		fetch.click();
    }	
	public void address(String street,String city,String state,String zip) 
	{
		streetaddress.sendKeys(street);
		cityaddress.sendKeys(city);
		stateaddress.sendKeys(state);
		zipcode.sendKeys(zip);
	}
	public void selectCountry(String Country)
	{
		Actions action =new Actions(driver);
		action.moveToElement(country).click().build().perform();
		action.sendKeys(Country);	  
		
	}
	
	public void selectStatus(String Status) 
	{
		/*Select sel = new Select(status);
		sel.selectByVisibleText(Status);*/
		
		Actions action =new Actions(driver);
		action.keyDown(Keys.CONTROL).click(status).sendKeys(Status).build().perform();
		//action.moveToElement(status).click().build().perform();
		//action.sendKeys(Status);

		
	}
	
	public void image_upload(String path)
	{
		image.sendKeys(path);
	}
	
	public void save_Tab()
	{
		save.click();
		companies.click();
		companies.click();

	}
	
	
}
