package com.re.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Declaration
	@FindBy(xpath="//a[.='Login']")private WebElement LoginButton ;
	@FindBy(xpath="//input[@name='username']")private WebElement LoginUserNameTB ;
	@FindBy(xpath="//input[@name='password']")private WebElement LoginPasswordTB ;
	@FindBy(xpath="//button[.='Submit']")private WebElement LoginSubmitButton;
	@FindBy(xpath="//a[.='Logout']")private WebElement LogoutButton;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getLoginUserNameTB() {
		return LoginUserNameTB;
	}

	public WebElement getLoginPasswordTB() {
		return LoginPasswordTB;
	}

	public WebElement getLoginSubmitButton() {
		return LoginSubmitButton;
	}
	
	/**
	 * login as user in click.
	 * @param un
	 * @param pwd
	 */
	public void loginAsUser(String un,String pwd)
	{
		LoginButton.click();
		LoginUserNameTB.sendKeys(un);
		LoginPasswordTB.sendKeys(pwd);
		LoginSubmitButton.click();
	}
	
	/**
	 * login as admin in one click.
	 * @param un
	 * @param pwd
	 */
	public void loginAsAdmin(String un,String pwd)
	{
		LoginButton.click();
		LoginUserNameTB.sendKeys(un);
		LoginPasswordTB.sendKeys(pwd);
		LoginSubmitButton.click();
	}
	
	
	public void clickOnloginButton()
	{
		LoginButton.click();
	}
	
	public void logoutAsUser()
	{
		LogoutButton.click();
	}
	
	public void logoutAsAdmin()
	{
		LogoutButton.click();
	}
	
	public void verifyLogin(WebDriver driver)
	{
		String Url=driver.getCurrentUrl();
		if(Url.contains("dashboard"))
		{
			System.out.println("Homepage is displaying");
		}
		else {
			System.out.println("Homepage is not displaying");
		}
	}
	
	
	
}
