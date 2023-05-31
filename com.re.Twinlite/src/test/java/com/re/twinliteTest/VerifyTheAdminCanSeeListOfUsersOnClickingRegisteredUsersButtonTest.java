package com.re.twinliteTest;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.re.Twinlite.ObjectRepository.LoginPage;
import com.re.Twinlite.ObjectRepository.RegisterUserPage;
import com.re.Twinlite.ObjectRepository.RegisteredUsersPage;
import com.re.TwinliteGenericUtilities.BaseClass;
import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.FileUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheAdminCanSeeListOfUsersOnClickingRegisteredUsersButtonTest extends BaseClass {
	//utilities done POM done basclass done
	
	@Test(groups="RegTest")
	public void VerifyTheAdminCanSeeListOfUsersOnClickingRegisteredUsersButtonTest() throws Throwable {
		
		
		//reading from excel file
		
		int ranNo=ju.getRandomNumber(888)+100;
		
		//storing the values from the excel file
		String username1=eu.getExcelData("Sheet1", 2, 1)+ranNo;
		String password1=eu.getExcelData("Sheet1", 5, 1);
				
		
		//registering the user
		RegisterUserPage registerUserPage=new RegisterUserPage(driver);
		registerUserPage.RegisterUser(username1, password1);
		//log in to the application as a user
		LoginPage loginPage =new LoginPage(driver);
		loginPage.loginAsUser(username1, password1);
		loginPage.logoutAsUser();
		//log in to the application as a admin
				loginPage.loginAsAdmin(fu.getPropertyData("admin"), fu.getPropertyData("apassword"));
		//click on registered users and check for newly registered user
				String fullname=eu.getExcelData("Sheet1", 1, 1);
				RegisteredUsersPage registeredUsersPage=new RegisteredUsersPage(driver);
				registeredUsersPage.validateNewUserAsAdmin(fullname);
	}

}
