package com.re.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.re.TwinliteGenericUtilities.WebDriverUtility;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[.='Logo/Home']")private WebElement HomeButton;
	@FindBy(xpath="//a[.='Search']")private WebElement SearchButton;
	@FindBy(xpath="//a[.='Home']")private WebElement Home2Button;
	@FindBy(xpath="//a[.='Register']")private WebElement RegisterButton;
	@FindBy(xpath="//input[@id='keywords']")private WebElement SearchKeywordTB;
	@FindBy(xpath="//input[@id='location']")private WebElement SearchLocationKeywordTB;
	@FindBy(xpath="//button[@name='search']")private WebElement SearchSubmitButton;
	@FindBy(xpath="//p")private List<WebElement> Ownerslist;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getHomeButton() {
		return HomeButton;
	}


	public WebElement getSearchButton() {
		return SearchButton;
	}


	public WebElement getHome2Button() {
		return Home2Button;
	}


	public WebElement getRegisterButton() {
		return RegisterButton;
	}


	public WebElement getSearchKeywordTB() {
		return SearchKeywordTB;
	}


	public WebElement getSearchLocationKeywordTB() {
		return SearchLocationKeywordTB;
	}


	public WebElement getSearchSubmitButton() {
		return SearchSubmitButton;
	}
	
	/**
	 * this method search the property
	 * @param Key
	 * @param Loc
	 * @throws InterruptedException 
	 */
	public void searchUsingKeywords(String Key,String Loc) throws InterruptedException
	{
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		SearchButton.click();
		SearchKeywordTB.sendKeys(Key);
		SearchLocationKeywordTB.sendKeys(Loc);
		Thread.sleep(2000);
		//webDriverUtility.waitTillElementToBeClickable(driver, SearchSubmitButton);
		SearchSubmitButton.click();
	}
	
	public void ClickOnRegisterButton()
	{
		RegisterButton.click();
	}
	
	public void fetchSearchResult(String rmobile) throws InterruptedException
	{
		boolean flag=false;
		
		for (WebElement owner:Ownerslist)
		{
			
			String oname=owner.getText();
			if(oname.contains(rmobile))
			{
				System.out.println("property found in the list");
				flag=true;
				break;
			}}
			if(!flag)
			{
				System.out.println("property not found in the list");
			}
			
	}
	
	public void verifyHomePage(WebDriver driver)
	{
		String landpage=driver.getCurrentUrl();
		if(landpage.contains("index"))
		{
			System.out.println("Landing page is displayed");
		}
		else {
			System.out.println("Landing page is not displayed");
		}
	}
	
	

}
