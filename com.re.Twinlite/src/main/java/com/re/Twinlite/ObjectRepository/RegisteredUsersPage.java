package com.re.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUsersPage {
	@FindBy(xpath="//div[contains(.,'Registered Users: ') and @class='alert alert-warning']")private WebElement RegisteredUsersButton;
	@FindBy(xpath="//td")private List<WebElement> allNames ;
//	@FindBy(xpath=)private WebElement ;
//	@FindBy(xpath=)private WebElement ;
//	@FindBy(xpath=)private WebElement ;
//	@FindBy(xpath=)private WebElement ;
	
	public RegisteredUsersPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getRegisteredUsersButton() {
		return RegisteredUsersButton;
	}

	public List<WebElement> getAllNames() {
		return allNames;
	}
	
	public void validateNewUserAsAdmin(String fullname)
	{
		RegisteredUsersButton.click();
		boolean flag=false;
		for(WebElement owner:allNames) {
			String ownerName = owner.getText();
			if(ownerName.contains(fullname)) {
		              flag=true;
		              System.out.println("User was found in the admin's User list successfully");
		              break;
		}}
		if(!flag) 
			System.out.println("User was not  found in the admin's User list ");
	}
	
}
