package com.re.TwinliteGenericUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public DataBaseUtility dbs=new DataBaseUtility();
	public static WebDriver driver;
	public WebDriverUtility wbu=new WebDriverUtility();
	public FileUtility fu=new FileUtility();
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtility ju=new JavaUtility();
	
	@BeforeSuite(groups= {"SmokeTest","RegTest"})
	public void config_BS()throws Throwable
	{
		dbs.connecToDatabase();
		System.out.println("connect to database");
	}
	//@Parameters("browser")
	@BeforeTest
	//@BeforeClass(groups= {"SmokeTest","RegTest"})
	public void config_BC()throws Throwable
	{
	String browser=fu.getPropertyData("browser");
	String url=fu.getPropertyData("url");
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		System.out.println("Chrome Launched");
	}
	else if(browser.equalsIgnoreCase("Firefox"))
	{
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();	
		System.out.println("Edge Launched");
	}
	else
	{
		driver=new ChromeDriver();
		System.out.println("Chrome Launched");
	}
	wbu.maximizeTheWindow(driver);
	driver.get(url);
	wbu.waitTillPageGetsLoaded(driver);
	}
	
	@BeforeMethod(groups= {"SmokeTest","RegTest"})
	public void config_BM()
	{
		System.out.println("Before method started");
	}
	

	@AfterMethod(groups= {"SmokeTest","RegTest"})
	public void config_AM()
	{
		System.out.println("After method running");
	}
	
	@AfterTest
	//@AfterClass(groups= {"SmokeTest","RegTest"})
	public void config_AC() throws Throwable
	{
		driver.quit();
		System.out.println("After class successfull");
	}
	
	@AfterSuite(groups= {"SmokeTest","RegTest"})
	public void config_AS() throws Throwable
	{
		dbs.closeDatbase();
		System.out.println("close the database");
	}

}
