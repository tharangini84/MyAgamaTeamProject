package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library
{
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;

	public Library() 
	{
		properties = new Properties();
		try {
			
			FileInputStream Inputfile=new FileInputStream("C:\\Users\\Sudhakar\\eclipse-workspace\\AgamaTeamProject\\src\\test\\resources\\ConfigurationProperties\\Config.properties");
			try {
				properties.load(Inputfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger = Logger.getLogger("Library");
		PropertyConfigurator.configure("C:\\Users\\Sudhakar\\eclipse-workspace\\AgamaTeamProjectDummy\\src\\test\\resources\\Log4jProperty\\Log4j.Properties");

	}
	
	public static void browserSetUp() {
		logger.info("Starting with Browser Set Up");
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
 		switch (browser) {
		case "chrome":
			//For WebDriverManager we have add jar file (instead of System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe"); we are using WebDriverManager)
			WebDriverManager.chromedriver().setup();
			System.out.println( browser);
			driver = new ChromeDriver();
			logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
			break;
			
		case "headlessbrowser":
			
				WebDriverManager.chromedriver().setup();
				ChromeOptions options=new ChromeOptions();
				options.setHeadless(true);
				driver=new ChromeDriver(options);

		default:
			logger.info(String.format("Could not identify the browser as %s. Please specify correct browser", browser));
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		logger.info("Launched the Orange Application");
	}

	public static void tearDown() 
	{
		driver.quit();
		logger.info("Exiting the application and closing the browser");
	}

	public void screenshot() throws IOException 
	{
		logger.info("Take Screenshot");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/FreeCrm" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(source, new File(path));
		logger.info("Image captured");
	}




}
