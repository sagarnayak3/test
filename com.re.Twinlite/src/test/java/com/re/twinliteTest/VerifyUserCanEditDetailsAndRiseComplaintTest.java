package com.re.twinliteTest;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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


public class VerifyUserCanEditDetailsAndRiseComplaintTest extends BaseClass {
	//utilities done POM done baseclass done
	
	@Test
	public void VerifyUserCanEditDetailsAndRiseComplaintTest() throws Throwable{
		
		
				int ranNo=ju.getRandomNumber(799)+100;
				
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
			
		//edit and complaint on the property
			String otherr=eu.getExcelData("Sheet1", 41, 1);
			DetailsUpdatePage detailsUpdatePage = new DetailsUpdatePage(driver);
			Thread.sleep(3000);
			detailsUpdatePage.editProperty(rmobile, otherr, driver);
		
		String rcno=eu.getExcelData("Sheet1", 38, 1);
		String rcomplaint=eu.getExcelData("Sheet1", 39, 1);
		
		//rising a complaint
		detailsUpdatePage.fileAComplaint(rcno, rcomplaint);
		//verifying the complaint
		detailsUpdatePage.validateSuccessfullMsgComplaint();
	}

}
