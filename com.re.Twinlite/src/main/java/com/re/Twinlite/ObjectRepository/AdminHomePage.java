package com.re.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(xpath="//a[.='Logo/Home']")private WebElement LogoHomeButton;
	@FindBy(xpath="//a[.='Logout']")private WebElement LogoutButton;
	@FindBy(xpath="//b[(text()='Registered Users: ')]")private WebElement RegisteredUsersButton;
	@FindBy(xpath="//b[(text()='Rooms for Rent: ')]")private WebElement RoomsForRentButton;
	@FindBy(xpath="//a[(text()='Home')]")private WebElement AdminHomeButton;
	@FindBy(xpath="//a[(text()='Register')]")private WebElement RegisterPropertyButton;
	@FindBy(xpath="//a[(text()='Details/Update')]")private WebElement DetailsUpdateButton;
	@FindBy(xpath="//a[(text()='Send SMS')]")private WebElement SendSMSButton;
	@FindBy(xpath="//a[(text()='Complaint List')]")private WebElement ComplaintListButton;
	
	
	
	//initialization
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//Utilization
	public WebElement getLogoHomeButton() {
		return LogoHomeButton;
	}



	public WebElement getLogoutButton() {
		return LogoutButton;
	}



	public WebElement getRegisteredUsersButton() {
		return RegisteredUsersButton;
	}



	public WebElement getRoomsForRentButton() {
		return RoomsForRentButton;
	}



	public WebElement getAdminHomeButton() {
		return AdminHomeButton;
	}



	public WebElement getRegisterPropertyButton() {
		return RegisterPropertyButton;
	}



	public WebElement getDetailsUpdateButton() {
		return DetailsUpdateButton;
	}



	public WebElement getSendSMSButton() {
		return SendSMSButton;
	}



	public WebElement getComplaintListButton() {
		return ComplaintListButton;
	}
	
	/**
	 * following methods are used to to click on each msg
	 * @param driver
	 */
	public void clickOnLogoHomeButton(WebDriver driver)
	{
		LogoHomeButton.click();
	}


	public void clickOnComplaintsListButton() {
		ComplaintListButton.click();
	}
	
	public void clickAdminHomeButton() {
		AdminHomeButton.click();
	}
	
	
	public void LogoutButton() {
		LogoutButton.click();
	}
	
	
	public void RegisteredUsersButton() {
		RegisteredUsersButton.click();
	}
	
	public void RoomsForRentButton() {
		RoomsForRentButton.click();
	}
	
	public void AdminHomeButton() {
		AdminHomeButton.click();
	}
	
	public void RegisterPropertyButton() {
		RegisterPropertyButton.click();
	}
	
	public void DetailsUpdateButton() {
		DetailsUpdateButton.click();
	}
	
	public void SendSMSButton() {
		DetailsUpdateButton.click();
	}
	
	
	
	
	
	
	
	
	
}
