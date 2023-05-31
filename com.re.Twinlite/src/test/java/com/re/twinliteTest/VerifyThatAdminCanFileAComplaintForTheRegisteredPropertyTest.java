package com.re.twinliteTest;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
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
//utilities done pom done baseclass done
public class VerifyThatAdminCanFileAComplaintForTheRegisteredPropertyTest extends BaseClass {
	
		@Test(groups="RegTest")
		public void VerifyThatAdminCanFileAComplaintForTheRegisteredPropertyTest()throws Throwable {
		//reading from excel file
		
		int ranNo=ju.getRandomNumber(999)+100;
		
		//storing the values from the excel file
		String username1=eu.getExcelData("Sheet1", 2, 1)+ranNo;
		String password1=eu.getExcelData("Sheet1", 5, 1);
		
		
		wbu.maximizeTheWindow(driver);
		driver.get(fu.getPropertyData("url"));
		
		
		//registering the user
		RegisterUserPage registerUserPage=new RegisterUserPage(driver);
		registerUserPage.RegisterUser(username1,password1);
		
		//log in to the application as a user
		LoginPage loginPage =new LoginPage(driver);
		loginPage.loginAsUser(username1, password1);
		
		//reading data for the register property
		String rmobile=eu.getExcelData("Sheet1",18,1)+ranNo;
		String raltermobile=eu.getExcelData("Sheet1", 19, 1)+ranNo;
		String rplotno=eu.getExcelData("Sheet1", 21, 1);
		
		RegisterPropertyPage registerPropertyPage=new RegisterPropertyPage(driver);
		registerPropertyPage.registerProperty(driver, rmobile, raltermobile);
	
		Thread.sleep(2000);
		registerPropertyPage.FetchSuccessfullMsg();
		
		loginPage.logoutAsUser();
	
		
		//first log in as user again
		loginPage.loginAsUser(username1, password1);
		
		
		String rcno=eu.getExcelData("Sheet1", 38, 1);
		String rcomplaint=eu.getExcelData("Sheet1", 39, 1);
		
		//rising a complaint
		DetailsUpdatePage detailsUpdatePage=new DetailsUpdatePage(driver);
		detailsUpdatePage.fileAComplaint(rcno, rcomplaint);
		
		//verifying the complaint
		detailsUpdatePage.validateSuccessfullMsgComplaint();
	
	}


}
