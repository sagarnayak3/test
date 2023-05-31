package com.re.Twinlite.ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

public class ApartmentRegisterPage extends ExcelUtility {
	
	
	
	@FindBy(xpath="//a[.='Register']")private WebElement RegisterPropertyButton;
	@FindBy(xpath="//a[.='Apartment Registration']")private WebElement ApartmentRegistrationTab;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='apartment_name']")private WebElement ApartmentNameTB ;
	//@FindBy(xpath=)private WebElement ;
	@FindBy(xpath="//input[@name='fullname[]']")private WebElement AFullNameTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='mobile']")private WebElement AMobileTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='alternat_mobile']")private WebElement AAlternateMobileTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='email']")private WebElement AEmailTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='plot_number']")private WebElement APlotNoTB;
	@FindBy(xpath="//input[@name='rooms[]']")private WebElement ARoomsTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='country']")private WebElement ACountryTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='state']")private WebElement AStateTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='city']")private WebElement ACityTB;
	@FindBy(xpath="//input[@name='rent[]']")private WebElement ARentTB;
	@FindBy(xpath="//input[@name='deposit[]']")private WebElement ADepositTB ;
	@FindBy(xpath="//input[@name='accommodation[]']")private WebElement AFacilityTB;
	@FindBy(xpath="//input[@name='description[]']")private WebElement ADescTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='landmark']")private WebElement ALandmarkTB;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='address']")private WebElement AAddressTB;
	@FindBy(xpath="//select[@id='vacant']")private WebElement AOptionsDD ;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='image']")private WebElement AImageButton;
	@FindBy(xpath="//h2[.='Apartment Room']/../form//button[.='Submit']")private WebElement ASubmitButton;
	@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement ASuccessfullText;
	@FindBy(xpath="//a[.='Logout']")private WebElement ALogoutButton;
	@FindBy(xpath="//input[@name='ap_number_of_plats[]']")private WebElement ANumberOfFlatsTB;
	@FindBy(xpath="//input[@name='area[]']")private WebElement AAreaTB;
	@FindBy(xpath="//a[.='Add More(Plat Number/Description)']")private WebElement AddMoreFlatsButton;
	@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement SuccessMsg;
	@FindBy(xpath="//div[contains(.,'Rooms for Rent: ') and @class='alert alert-warning']")private WebElement RoomsForRentButton;
	@FindBy(xpath="//p[contains(.,'Plot Number: ')]")private  List<WebElement> AllRoomsList;
	//@FindBy(xpath=)private WebElement ;

	public ApartmentRegisterPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void RegisterApartment(String rmobile,String raltermobile) throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebDriverUtility wbu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		int ranNo=ju.getRandomNumber(888)+100;
//		String rroom=eu.getExcelData("Sheet1", 22, 1);	
//		String rdesc=eu.getExcelData("Sheet1", 29, 1);
//		String noflats=eu.getExcelData("Sheet1", 47, 1);
//		String area=eu.getExcelData("Sheet1", 49, 1);
//		
		
		////registering a property into the application
		RegisterPropertyButton.click();
		ApartmentRegistrationTab.click();
		ApartmentNameTB.sendKeys(getExcelData("Sheet1", 46, 1));
		AMobileTB.sendKeys(rmobile);
		AAlternateMobileTB.sendKeys(raltermobile);
		AEmailTB.sendKeys(ranNo+getExcelData("Sheet1", 20, 1));
		APlotNoTB.sendKeys(getExcelData("Sheet1", 21, 1));
		ACountryTB.sendKeys(getExcelData("Sheet1", 23, 1));
		AStateTB.sendKeys(getExcelData("Sheet1", 24, 1));
		ACityTB.sendKeys(getExcelData("Sheet1", 25, 1));
		ALandmarkTB.sendKeys(getExcelData("Sheet1", 30, 1));
		AAddressTB.sendKeys(getExcelData("Sheet1", 31, 1));
		//uploading image
		Thread.sleep(2000);
		
				wbu.fileUpload(AImageButton);
				Thread.sleep(2000);
				AddMoreFlatsButton.click();
				AFullNameTB.sendKeys(getExcelData("Sheet1",17,1));
				ANumberOfFlatsTB.sendKeys(getExcelData("Sheet1", 47, 1));
				
				ARoomsTB.sendKeys(getExcelData("Sheet1", 48, 1));
				AAreaTB.sendKeys(getExcelData("Sheet1", 49, 1));
				ARentTB.sendKeys(getExcelData("Sheet1", 26, 1));
				ADepositTB.sendKeys(getExcelData("Sheet1", 27, 1));
				AFacilityTB.sendKeys(getExcelData("Sheet1", 28, 1));
				ADescTB.sendKeys(getExcelData("Sheet1", 29, 1));
				wbu.selectElementInDropdown(AOptionsDD, "1");
				
				ASubmitButton.click();
				
	}
	
	public void fetchRegisterSuccessMsg()
	{
		String successText = SuccessMsg.getText();
		if(successText.contains("successfull"))
			System.out.println("Apartment registered successfully");
		else
			System.out.println("Apartment registration failed");
	}
	
	public void validateTheRegisteredProperty(String rplotno)
	{
		RoomsForRentButton.click();
		boolean flag=false;
		for(WebElement room:AllRoomsList) {
			String roomName = room.getText();
			if(roomName.contains(rplotno)) {
		              flag=true;
		              System.out.println("room was found in the admin's registered room list successfully");
		              break;
		}}
		if(!flag) 
			System.out.println("User was not  found in the admin's registered room list successfully");
	}
	
}
