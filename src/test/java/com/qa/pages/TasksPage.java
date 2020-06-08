package com.qa.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class TasksPage
{
	WebDriver driver;
	public TasksPage(WebDriver Tdriver) 
	{
		this.driver=Tdriver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//*[@class='tasks icon']")
	WebElement task;
	
	//@FindBy(xpath="//*[@class='ui linkedin button']//following::button[3]")
	@FindBy(xpath="//*[@href='/tasks/new']")
	WebElement newEntry;

	@FindBy(xpath="//*[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//div[@role='listbox' and @class='ui basic button floating item dropdown']")
	WebElement assignedto;


	@FindBy(xpath="//div[@name='type' and @role='listbox']")
	WebElement type;
			
	@FindBy(xpath="//span[contains(text(),'General Support')]")
	WebElement picktype;
	
	
	//button to open calendar
			
	 @FindBy(xpath="//input[@class='calendarField react-datepicker-ignore-onclickoutside']")
	WebElement selectDate;
	 
	 //all date and month xpath
	 @FindBy(xpath="//div[@class='react-datepicker__header__dropdown react-datepicker__header__dropdown--scroll']")
	 List<WebElement> fullCalendermonth;
	 
	 @FindBy(xpath="//div[@class='react-datepicker__month-container']")
	 WebElement fullCalenderdays;

		
		//button to move next in calendar
		
		@FindBy(xpath="//button[contains(text(),'Next Month')]")
		WebElement nextLink;
		
		//button to click in center of calendar header
		@FindBy(xpath="//button[contains(text(),'Next Month')]")
		WebElement midLink;
		
		//button to move previous month in calendar
		@FindBy(xpath="//button[contains(text(),'Previous Month')]")
		WebElement previousLink;

		//ForTIME
		@FindBy(xpath="//*[@class='react-datepicker__time-list']")
		WebElement time;


	@FindBy(xpath="//*[@class='save icon']")
	WebElement save;
	
	

	@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
	WebElement settings;
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement logoff;
	
	public void task_Tab()
	{
		task.click();
		
		
	}
	public void new_Entry()
	{
		newEntry.click();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.navigate().refresh();
		driver.navigate().refresh();		
	}
	
	public void enter_Title(String Title)
	{
		title.sendKeys(Title);
		
	}
	
	public void assigned_To(String pick) 
	{
		
		Select select=new Select(assignedto);
		select.selectByVisibleText(pick);
		
		
	}
	
	
	
	public void type_Tab(String pick_type)
	{
		
		Actions action =new Actions(driver);
		//action.keyDown(Keys.CONTROL).click(type).click(picktype).build().perform();

		action.moveToElement(type).click();		
		Actions CLICK=action.sendKeys(pick_type).click();	
		CLICK.build().perform();
		
	}
	public void save_Icon() 
	{
		save.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task.click();
		task.click();
	}
	public void logoff() 
	{
		settings.click();	
		logoff.click();
	}
	
	

	public void due_Date(String dateTime) 
	{
		selectDate.click();
		 //Split the date time to get only the date part

        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

        //get the year difference between current year and year to set in calander

        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);

        //midLink.click();

        if(yearDiff!=0){

            //if you have to move next year

            if(yearDiff>0){

                for(int i=0;i< yearDiff;i++){

                    System.out.println("Year Diff->"+i);

                    nextLink.click();

                }

            }

            //if you have to move previous year

            else if(yearDiff<0){

                for(int i=0;i< (yearDiff*(-1));i++){

                    System.out.println("Year Diff->"+i);

                    previousLink.click();

                }

            }

        }
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Get all months from calendar to select correct one
        System.out.println("Testing1");

       // List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@class='react-datepicker__month-container']"));
        
      //  list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        
        fullCalendermonth.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Testing12");

        //get all dates from calendar to select correct one

       // List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@class='react-datepicker__month-container']"));
        
        //list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click(); 
        fullCalendermonth.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
        
        ///FOR TIME

        //WebElement selectTime = driver.findElement(By.xpath("//*[@class='react-datepicker__time-list']"));

        //click time picker button

        time.click();

        //get list of times

        List<WebElement> allTime = driver.findElements(By.xpath("//*[@class='react-datepicker__time-list']"));
      
        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];

     //select correct time

        for (WebElement webElement : allTime) {

            if(webElement.getText().equalsIgnoreCase(dateTime))

            {

                webElement.click();

            }

        }

    }

}
