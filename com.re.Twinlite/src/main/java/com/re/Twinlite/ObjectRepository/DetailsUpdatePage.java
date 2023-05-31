package com.re.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.re.TwinliteGenericUtilities.WebDriverUtility;

public class DetailsUpdatePage {
	
	@FindBy(xpath="//div[(@id='navbarResponsive1')]/ul/li[3]")private WebElement DetailsUpdateButton;
	@FindBy(xpath="//select[@id='vacant']")private WebElement VacantSelect;
	@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='other']")private WebElement OtherTB;
	@FindBy(xpath="//h2[.='Register Room']/../form//button[.='Submit']")private WebElement SubmitButton;
	@FindBy(xpath="//p[contains(.,'Mobile Number')]")private List<WebElement> AllPhonesList ;
	@FindBy(xpath="//p[contains(.,'Occupied')]")private WebElement ocupied;
	@FindBy(xpath="//a[.='Complaint']")private WebElement ComplaintButton;
	@FindBy(xpath="//input[@name='name']")private WebElement ComplaintRoomNoTB;
	@FindBy(xpath="//input[@name='cmp']")private WebElement ComplaintTB;
	@FindBy(xpath="//button[.='Submit']")private WebElement ComplaintSubmitButton ;
	@FindBy(xpath="//div[.='Sent Successfully']")private WebElement ComplaintsMsg;
	
	public DetailsUpdatePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getDetailsUpdateButton() {
		return DetailsUpdateButton;
	}
	public WebElement getVacantSelect() {
		return VacantSelect;
	}
	public WebElement getOtherTB() {
		return OtherTB;
	}
	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	
	public void editProperty(String Rmob,String other, WebDriver driver) throws InterruptedException
	{
		WebDriverUtility wbu=new WebDriverUtility();
		//Thread.sleep(2000);
		DetailsUpdateButton.click();
		driver.findElement(By.xpath("//p[contains(.,'"+Rmob+"')]/../../..//a")).click();
		wbu.selectElementInDropdown(VacantSelect, "0");
		OtherTB.sendKeys(other);
		SubmitButton.click();
		
	}
	
	public void validateThePropertEdit(String rmobile)
	{
		DetailsUpdateButton.click();
		String occupy=null;
		for(WebElement phone:AllPhonesList) {
			String phoneNo=phone.getText();
			if(phoneNo.contains(rmobile)) {
				 occupy = ocupied.getText();
			}
		}

		if(occupy.equals("Occupied"))
			System.out.println("Details edited successfully by the user");
		else
			System.out.println("Details not edited by the user");
			
		}
	
	public void fileAComplaint(String rcno,String rcomplaint)
	{
		DetailsUpdateButton.click();
		ComplaintButton.click();
		ComplaintRoomNoTB.sendKeys(rcno);
		ComplaintTB.sendKeys(rcomplaint);
		ComplaintSubmitButton.click();
	}
	
	public void validateSuccessfullMsgComplaint()
	{
		String check = ComplaintsMsg.getText();
		if(check.contains("Sent Successfully"))
			System.out.println("complaint rised successfully");
		else 
			System.out.println("complaint rising failed");
	}
	
	}

