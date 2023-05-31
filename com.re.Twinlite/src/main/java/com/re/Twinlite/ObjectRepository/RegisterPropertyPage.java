package com.re.Twinlite.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;

public class RegisterPropertyPage extends ExcelUtility{
	
	@FindBy(xpath="//a[.='Register']")private WebElement RegisterPropertyButton;
	@FindBy(xpath="//input[@name='fullname']")private WebElement RFullNameTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='mobile']")private WebElement RMobileTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='alternat_mobile']")private WebElement RAlternateMobileTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='email']")private WebElement REmailTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='plot_number']")private WebElement RPlotNoTB;
	@FindBy(xpath="(//input[@name='rooms'])")private WebElement RRoomsTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='country']")private WebElement RCountryTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='state']")private WebElement RStateTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='city']")private WebElement RCityTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='rent']")private WebElement RRentTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='deposit']")private WebElement RDepositTB ;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='accommodation']")private WebElement RFacilityTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='description']")private WebElement RDescTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='landmark']")private WebElement RLandmarkTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='address']")private WebElement RAddressTB;
	@FindBy(xpath="//select[@class='form-control']")private WebElement ROptionsDD ;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='image']")private WebElement RImageButton;
	@FindBy(xpath="//h2[.='Register Room']/../form//button[.='Submit']")private WebElement RSubmitButton;
	@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement RSuccessfullText;
	@FindBy(xpath="//a[.='Logout']")private WebElement RLogoutButton;
	//@FindBy(xpath=)private WebElement ;
	
	public RegisterPropertyPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getRegisterPropertyButton() {
		return RegisterPropertyButton;
	}

	public WebElement getRImageButton() {
		return RImageButton;
	}

	public WebElement getRLogoutButton() {
		return RLogoutButton;
	}
	
	public void verifyRegisterPage()
	{
		
	}
	
	public void registerProperty(WebDriver driver,String mob,String Amob) throws EncryptedDocumentException, IOException {
		JavaUtility ju=new JavaUtility();
		WebDriverUtility wbu=new WebDriverUtility();
		int ranNo=ju.getRandomNumber(888)+100;
		RegisterPropertyButton.click();
		String rUrl=driver.getCurrentUrl();
		if(rUrl.contains("register"))
		{
			System.out.println("register page is displaying");
		}
		else {
			System.out.println("register page is not displaying");
		}
		RFullNameTB.sendKeys(getExcelData("Sheet1",17,1));
		RMobileTB.sendKeys(mob);
		RAlternateMobileTB.sendKeys(Amob);
		REmailTB.sendKeys(ranNo+getExcelData("Sheet1", 20, 1));
		RPlotNoTB.sendKeys(getExcelData("Sheet1", 21, 1));
		RRoomsTB.sendKeys(getExcelData("Sheet1", 22, 1));
		RCountryTB.sendKeys(getExcelData("Sheet1", 23, 1));
		RStateTB.sendKeys(getExcelData("Sheet1", 24, 1));
		RCityTB.sendKeys(getExcelData("Sheet1", 25, 1));
		RRentTB.sendKeys(getExcelData("Sheet1", 26, 1));
		RDepositTB.sendKeys(getExcelData("Sheet1", 27, 1));
		RFacilityTB.sendKeys(getExcelData("Sheet1", 28, 1));
		RDescTB.sendKeys(getExcelData("Sheet1", 29, 1));
		RLandmarkTB.sendKeys(getExcelData("Sheet1", 30, 1));
		RAddressTB.sendKeys(getExcelData("Sheet1", 31, 1));
		wbu.selectElementInDropdown(ROptionsDD, "0");
		wbu.fileUpload(RImageButton);
		RSubmitButton.click();
		//@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement RSuccessfullText;
		//@FindBy(xpath="//a[.='Logout']")private WebElement RLogoutButton;
	}
	
	public void FetchSuccessfullMsg()
	{
		String msg=RSuccessfullText.getText();
		if(msg.contains("Registration successfull"))
		{
			System.out.println("property registration successfull");
		}
		else {
			System.out.println("property registration failed");
		}
		
	}
	
	public void clickOnLogout() {
		RLogoutButton.click();
	}
	

}
