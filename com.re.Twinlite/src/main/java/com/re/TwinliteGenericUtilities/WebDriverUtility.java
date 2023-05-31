package com.re.TwinliteGenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class consists of webdriver related methods
 * @author sagar
 *
 */
public class WebDriverUtility {
	
	/**
	 * this method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * this method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method waits for the page gets loaded
	 * @param driver
	 */
	public void waitTillPageGetsLoaded(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstants.ImplicitWaitDuration));
	}
	
	/**
	 * this method waits for the element to be visible
	 * @param driver
	 * @param Element
	 */
	public void waitTillElementToBeVisible(WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,(Duration.ofSeconds(IpathConstants.explicitWaitDuration)));
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	/**
	 * this method waits for the element to be clickable
	 * @param driver
	 * @param Element
	 */
	public void waitTillElementToBeClickable(WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,(Duration.ofSeconds(IpathConstants.explicitWaitDuration)));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * this method will wait for the alert popup to display
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,(Duration.ofSeconds(IpathConstants.explicitWaitDuration)));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * this method waits for the title to get displayed
	 * @param driver
	 * @param title
	 */
	public void waitForTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,(Duration.ofSeconds(IpathConstants.explicitWaitDuration)));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * this method waits for the Url to get displayed
	 * @param driver
	 * @param url
	 */
	public void waitForUrl(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,(Duration.ofSeconds(IpathConstants.explicitWaitDuration)));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	/**
	 * this method waits for the ignore NoSuchElementException
	 * @param driver
	 * @param url
	 */
	public void ignoreNoSuchElementException(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,(Duration.ofSeconds(IpathConstants.explicitWaitDuration)));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * this method will select from the drown using index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method will select from the drown using value
	 * @param element
	 * @param value
	 */
	public void selectElementInDropdown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * this method will select from the drown using visible text
	 * @param text
	 * @param element
	 */
	public void selectElementInDropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * this method will get all the options from the drown  
	 * @param element
	 */
	public void getAllOptionsFromDropdown(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement>options=s.getOptions();
		for (WebElement opt:options)
		{
			String text=opt.getText();
			System.out.println(text);
		}
	}
	
	/**
	 * this method will move the cursor over the particular webelement using actions class
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * this method will right click the cursor over the particular webelement using actions class
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * this method will double click the cursor over the particular webelement using actions class
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will switch to particular frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to particular frame using id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	
	/**
	 * This method will switch to particular frame using Webelement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**This method will switch to main frame 
	 * 
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * this method will accept the alert popup
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopup(WebDriver driver,String text)
	{
		Alert alt=driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("Alert is present");
		}
		else {
			System.out.println("Alert is not present");
		}
		
		alt.accept();
			
	}
	
	/**
	 * this method will dismiss the alert popup
	 * @param driver
	 * @param text
	 */
	public void dismissAlertPopup(WebDriver driver,String text)
	{
		Alert alt=driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("Alert is present");
		}
		else {
			System.out.println("Alert is not present");
		}
		
		alt.dismiss();;
			
	}
	
	/**
	 * this method will upload the file using send keys method
	 * @param element
	 * @param path
	 */
	public void fileUpload(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	
	/**
	 * this method will upload the file using absolute path
	 * @param element
	 */
	public void fileUpload(WebElement element)
	{
		File f=new File(IpathConstants.imagepath);
		String path=f.getAbsolutePath();
		element.sendKeys(path);
	}
	
	/**
	 * this method will custom wait according to the polling time
	 * @param duration
	 * @param element
	 * @param pollingtime
	 */
	public void customWait(int duration, WebElement element,long pollingtime)
	{
		int count=0;
		while(count<duration)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(pollingtime);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				count++;
			
		}
	}
	}
	
	
	/**
	 * this method will take screenshot of the page and saves the file into screenshots folder in project
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
public String takeScreenShot(WebDriver driver,String screenshotname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	LocalDateTime lDTime= LocalDateTime.now();
	File trg=new File("./screenshots/"+screenshotname+lDTime.toString().replace(":", "-")+".png");
		FileUtils.copyFile(src,trg);
	
	
	return screenshotname;
}

/**
// * this method will switch to particular window with help of title
 * @param driver
 * @param title
 */
public void switchToWindow(WebDriver driver,String title)
{
	Set<String> set=driver.getWindowHandles();
	for(String wdw:set)
	{
		driver.switchTo().window(wdw);
		String text=driver.getTitle();
		if(text.contains(title))
		{
			break;
		}
	}
}

/**
 * this method will switch to particular window with help of url
 * @param url
 * @param driver
 */
public void switchToWindow(String url,WebDriver driver)
{
	Set<String>set=driver.getWindowHandles();
	Iterator<String>it=set.iterator();
	while(it.hasNext())
	{
		String wid=it.next();
		driver.switchTo().window(wid);
		String text=driver.getCurrentUrl();
		if(text.contains(url))
		{
			break;
		}
	}
}






}
