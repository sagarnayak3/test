package com.re.twinliteTest;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.re.Twinlite.ObjectRepository.DetailsUpdatePage;
import com.re.Twinlite.ObjectRepository.LoginPage;
import com.re.Twinlite.ObjectRepository.RegisterPropertyPage;
import com.re.Twinlite.ObjectRepository.RegisterUserPage;
import com.re.TwinliteGenericUtilities.BaseClass;
import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.FileUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(com.re.TwinliteGenericUtilities.ListenerImp.class)
public class VerifyThatUserCanEditTheRegisteredPropertyTest extends BaseClass {
	//utilities done pom done baseclass done
		
	@Test
	public void VerifyThatUserCanEditTheRegisteredPropertyTest()throws Throwable{
		
		//reading from excel file
		
		int ranNo=ju.getRandomNumber(799)+100;
		
		//storing the values from the excel file
		
		String username1=eu.getExcelData("Sheet1", 2, 1)+ranNo;
		
		String password1=eu.getExcelData("Sheet1", 5, 1);
		
		wbu.maximizeTheWindow(driver);
		driver.get(fu.getPropertyData("url"));
				
	
				//registering the user
				RegisterUserPage registerUserPage=new RegisterUserPage(driver);
				registerUserPage.RegisterUser(username1, password1);
				//log in to the application as a user
				LoginPage loginPage =new LoginPage(driver);
				loginPage.loginAsUser(username1, password1);
				
				//Assert.fail();
				//reading data for the register property
				String rmobile=eu.getExcelData("Sheet1",18,1)+ranNo;
				String raltermobile=eu.getExcelData("Sheet1", 19, 1)+ranNo;
				
				
				
				//registering a property into the application
				RegisterPropertyPage registerPropertyPage=new RegisterPropertyPage(driver);
				registerPropertyPage.registerProperty(driver, rmobile, raltermobile);
				
					Thread.sleep(2000);
					registerPropertyPage.FetchSuccessfullMsg();

					registerPropertyPage.clickOnLogout();
	
	//first log in as user again
	loginPage.loginAsUser(username1, password1);
	//edit the property
	
	
	String otherr=eu.getExcelData("Sheet1", 41, 1);
	DetailsUpdatePage detailsUpdatePage = new DetailsUpdatePage(driver);
	Thread.sleep(3000);
	detailsUpdatePage.editProperty(rmobile, otherr, driver);
	detailsUpdatePage.validateThePropertEdit(rmobile);
	
	
	
}
	
	
}
