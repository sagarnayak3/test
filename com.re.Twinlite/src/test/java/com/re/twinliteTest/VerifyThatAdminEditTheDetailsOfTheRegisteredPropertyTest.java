package com.re.twinliteTest;
import static org.testng.Assert.fail;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.re.Twinlite.ObjectRepository.AdminDetailsUpdatePage;
import com.re.Twinlite.ObjectRepository.LoginPage;
import com.re.TwinliteGenericUtilities.BaseClass;
import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.FileUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners()
public class VerifyThatAdminEditTheDetailsOfTheRegisteredPropertyTest extends BaseClass{
	//utilities done pom done baseclass done
	
	@Test(groups="SmokeTest", retryAnalyzer=com.re.TwinliteGenericUtilities.RetryAnalyser.class)
	public void VerifyThatAdminEditTheDetailsOfTheRegisteredPropertyTest() throws Throwable {

		int ranNo=ju.getRandomNumber(888)+100;
		
		//storing the values from the excel file
		String username1=eu.getExcelData("Sheet1", 2, 1)+ranNo;
		String password1=eu.getExcelData("Sheet1", 5, 1);
				//log in to the application as a admin
				LoginPage loginPage =new LoginPage(driver);
				loginPage.loginAsAdmin(fu.getPropertyData("admin"), fu.getPropertyData("apassword"));
		
				//goto details and edit the details of a property registered by the user
				//Assert.fail();
				
				String raltermobile=eu.getExcelData("Sheet1", 19, 1)+ranNo;
				String Other=eu.getExcelData("Sheet1", 34, 1);
				
				AdminDetailsUpdatePage adminDetailsUpdatePage= new AdminDetailsUpdatePage(driver);
				adminDetailsUpdatePage.editPropertyDetails(raltermobile, Other);
				
				//verify if the mobile number is changed
				adminDetailsUpdatePage.verifyTheChange(raltermobile, driver);
		
	}


}
