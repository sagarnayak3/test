package com.re.twinliteTest;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.re.Twinlite.ObjectRepository.ApartmentRegisterPage;
import com.re.Twinlite.ObjectRepository.LoginPage;
import com.re.Twinlite.ObjectRepository.RegisterUserPage;
import com.re.TwinliteGenericUtilities.BaseClass;
import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.FileUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheAdminCanSeeListOfApartmentDetailsOnClickingRoomsForRentButtonTest extends BaseClass  {
	//utilities done pom done base class done
	
	@Test	
	public void VerifyTheAdminCanSeeListOfApartmentDetailsOnClickingRoomsForRentButtonTest()throws Throwable {

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
		
		//reading data for the register property
		String rfullname=eu.getExcelData("Sheet1",17,1);
		String rmobile=eu.getExcelData("Sheet1",18,1)+ranNo;
		String raltermobile=eu.getExcelData("Sheet1", 19, 1)+ranNo;
		String rplotno=eu.getExcelData("Sheet1", 21, 1);
		//System.out.println(rmobile);
		
		////registering a property into the application
		ApartmentRegisterPage apartmentRegisterPage=new ApartmentRegisterPage(driver);
		apartmentRegisterPage.RegisterApartment(rmobile, raltermobile);
		
		apartmentRegisterPage.fetchRegisterSuccessMsg();
		
		loginPage.logoutAsUser();
		
		//log in to the application as a admin
		loginPage.loginAsAdmin(fu.getPropertyData("admin"), fu.getPropertyData("apassword"));
				
		//click on registered users and check for newly registered user
				apartmentRegisterPage.validateTheRegisteredProperty(rplotno);
	}

}
