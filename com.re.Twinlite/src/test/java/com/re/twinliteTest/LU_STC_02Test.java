package com.re.twinliteTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.re.Twinlite.ObjectRepository.HomePage;
import com.re.Twinlite.ObjectRepository.LoginPage;
import com.re.Twinlite.ObjectRepository.RegisterPropertyPage;
import com.re.Twinlite.ObjectRepository.RegisterUserPage;
import com.re.TwinliteGenericUtilities.BaseClass;
import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.FileUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LU_STC_02Test extends BaseClass {
	
	//utilities done pom done baseclass done
	
	@Test(priority=0,groups="SmokeTest")
	public void LU_STC_02Test()throws Throwable{
		
		//reading from excel file
		
		int ranNo=ju.getRandomNumber(888)+100;
		
		
		//storing the values from the excel file
		String username1=eu.getExcelData("Sheet1", 2, 1)+ranNo;
		String password1=eu.getExcelData("Sheet1", 5, 1);
		
		//filling the form
		
		RegisterUserPage registerUserPage=new RegisterUserPage(driver);
		registerUserPage.RegisterUser(username1, password1);
		
		
		//verify the account creation
		registerUserPage.fetchRegisterMsg();
		
		
		//passing the login credentials
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginAsUser(username1, password1);
		
		//verify the login homepage
		
		loginPage.verifyLogin(driver);
		
		//reading data for the register property
		String rmobile=eu.getExcelData("Sheet1",18,1)+ranNo;
		System.out.println(rmobile);
		String raltermobile=eu.getExcelData("Sheet1", 19, 1)+ranNo;
		
		
		//pass the details for the register form
		RegisterPropertyPage registerPropertyPage=new RegisterPropertyPage(driver);
		registerPropertyPage.registerProperty(driver,rmobile, raltermobile);
		
		//verify the property registration
		registerPropertyPage.FetchSuccessfullMsg();
		
		//click on logout button
		registerPropertyPage.clickOnLogout();
		
		//verify the landing page
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage(driver);
		
		
		//excel values for the search keyword
		String searchk=eu.getExcelData("Sheet1", 43, 1);
		String searchl=eu.getExcelData("Sheet1", 44, 1);
		
		//pass the required search entries
		
		homePage.searchUsingKeywords(searchk, searchl);
		
		
		//verify the search results
		Thread.sleep(2000);
		homePage.fetchSearchResult(rmobile);
	//rmobile
		

		
	}

}
