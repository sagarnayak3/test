package com.re.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDetailsUpdatePage {
	
	
	@FindBy(xpath="//a[.='Details/Update']")private WebElement DetailsUpdateButton;
	@FindBy(xpath="//b[contains(.,'Sale: ')]/../../../../a")private WebElement PropertyEditButton;
	@FindBy(xpath="//input[@id='alternat_mobile']")private WebElement AlternateMobileTB;
	@FindBy(xpath="//input[@name='other']")private WebElement OtherTB;
	@FindBy(xpath="//button[.='Submit']")private WebElement SubmitButton;
//	@FindBy(xpath=)private WebElement ;
//	@FindBy(xpath=)private WebElement ;
//	@FindBy(xpath=)private WebElement ;
	
	public AdminDetailsUpdatePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void editPropertyDetails(String raltermobile,String Other)
	{
		DetailsUpdateButton.click();
		PropertyEditButton.click();
		AlternateMobileTB.clear();
		AlternateMobileTB.sendKeys(raltermobile);
		OtherTB.sendKeys(Other);
		SubmitButton.click();
	}
	
	public void verifyTheChange(String raltermobile,WebDriver driver)
	{
		DetailsUpdateButton.click();
		List<WebElement> allPhones = driver.findElements(By.xpath("//p[contains(.,'"+raltermobile+"')]"));
		boolean flag=false;
		for(WebElement phone:allPhones) {
			String phoneNo =phone.getText();
			if(phoneNo.contains(raltermobile)) {
              flag=true;
              System.out.println("phone number was edited successfully by the admin");
              break;
}}
if(!flag) 
	System.out.println("admin could not edit the phone number successfully");
	}

}

