package com.re.Twinlite.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;

/**
 * 
 * @author sagar
 *
 */
public class RegisterUserPage extends ExcelUtility {
	
	//Declaration
	
	@FindBy(xpath="//a[.='Register']")private WebElement RegisterButton;
	@FindBy(xpath="//input[@id='fullname']")private WebElement FullnameTB;
	@FindBy(xpath="//input[@id='username']")private WebElement UsernameTB;
	@FindBy(xpath="//input[@name='mobile']")private WebElement MobileTB;
	@FindBy(xpath="//input[@id='email']")private WebElement EmailTB;
	@FindBy(xpath="//input[@id='password']")private WebElement PasswordTB;
	@FindBy(xpath="//input[@id='c_password']")private WebElement CPasswordTB;
	@FindBy(xpath="//button[.='Submit']")private WebElement SubmitButton;
	@FindBy(xpath="//div[.='Registration successfull. Now you can login']")private WebElement RegisterMsg;
//	@FindBy(xpath=)private WebElement ;
//	@FindBy(xpath=)private WebElement ;
	
	//initialization
	public RegisterUserPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getRegisterButton() {
		return RegisterButton;
	}

	public WebElement getFullnameTB() {
		return FullnameTB;
	}

	public WebElement getUsernameTB() {
		return UsernameTB;
	}

	public WebElement getMobileTB() {
		return MobileTB;
	}

	public WebElement getEmailTB() {
		return EmailTB;
	}

	public WebElement getPasswordTB() {
		return PasswordTB;
	}

	public WebElement getCPassword() {
		return CPasswordTB;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	
	/**
	 * register the user, entire process in one method
	 * @param user
	 * @param pwd
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void RegisterUser(String user,String pwd) throws EncryptedDocumentException, IOException
	{
		JavaUtility ju=new JavaUtility();
		int ranNo=ju.getRandomNumber(888)+100;
		//String user=getExcelData("Sheet1", 2, 1)+ranNo;
		RegisterButton.click();
		FullnameTB.sendKeys(getExcelData("Sheet1", 1, 1));
		UsernameTB.sendKeys(user);
		MobileTB.sendKeys(getExcelData("Sheet1", 3, 1)+ranNo);
		EmailTB.sendKeys(ranNo+getExcelData("Sheet1", 4, 1));
		PasswordTB.sendKeys(pwd);
		CPasswordTB.sendKeys(pwd);
		
		SubmitButton.click();
		//return user;
	}
	
	/**
	 * method is used to click on register button on homepage
	 */
	public void clickOnRegisterButton() {
		RegisterButton.click();
	}
	
	public void fetchRegisterMsg()
	{
		String msg=RegisterMsg.getText();
		if(msg.contains("Registration successfull"))
		{
			System.out.println("Account is created");
		}else {
			System.out.println("Account creation failed");
		}
	}

	

}
