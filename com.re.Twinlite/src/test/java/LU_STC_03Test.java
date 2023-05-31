

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.re.TwinliteGenericUtilities.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LU_STC_03Test extends BaseClass {
	@Test
	public void LU_STC_03Test() throws Throwable {
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Properties.Properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url=pobj.getProperty("url");
		String username=pobj.getProperty("username");
		String password=pobj.getProperty("password");
		String Admin=pobj.getProperty("admin");
		String AdminPassword=pobj.getProperty("apassword");
		
		
		//WebDriverManager.chromedriver().setup();
		
		//click on login
				driver.findElement(By.xpath("//a[.='Login']")).click();
				
				//passing the login credentials
				driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
				//click on login button
				driver.findElement(By.xpath("//button[@name='login']")).click();
				//verify the login homepage
				String Url=driver.getCurrentUrl();
				if(Url.contains("dashboard"))
				{
					System.out.println("Homepage is displaying");
				}
				else {
					System.out.println("Homepage is not displaying");
				}
				
				//click on register
				driver.findElement(By.xpath("//a[.='Register']")).click();
				
				//verify the register page
				String rUrl=driver.getCurrentUrl();
				if(rUrl.contains("register"))
				{
					System.out.println("register page is displaying");
				}
				else {
					System.out.println("register page is not displaying");
				}
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//a[.='Apartment Registration']")).click();
				
				//click on apartment registration tab
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='apartment_name']")).sendKeys("vijaya homes");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='mobile']")).sendKeys("7878657676");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='alternat_mobile']")).sendKeys("7878657676");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='email']")).sendKeys("vh@vh.com");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='plot_number']")).sendKeys("50");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='country']")).sendKeys("uganda");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='state']")).sendKeys("urug");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='city']")).sendKeys("upanda");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='landmark']")).sendKeys("near majestic");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='address']")).sendKeys("rajajinagar");
				File file=new File("./src/test/resources/Screenshot 2023-04-28 160820.png");
				String abspath=file.getAbsolutePath();
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='image']")).sendKeys(abspath);
				driver.findElement(By.xpath("//a[.='Add More(Plat Number/Description)']")).click();
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='fullname']")).sendKeys("harshitha poonacha");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='ap_number_of_plats']")).sendKeys("402");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='rooms']")).sendKeys("1BHK");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='area']")).sendKeys("2000");
				WebElement purpose=driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//select[@id='purpose']"));
				Select s=new Select(purpose);
				s.selectByValue("Residential");
				
				WebElement floor=driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//select[@id='floor']"));
				Select f=new Select(floor);
				f.selectByValue("4th");
				
				WebElement owner=driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//select[@id='ownership']"));
				Select o=new Select(owner);
				o.selectByIndex(0);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='rent']")).sendKeys("2000");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='deposit']")).sendKeys("20000");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='accommodation']")).sendKeys("geyser");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//input[@id='description']")).sendKeys("good locality");
				
				WebElement vacant=driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//select[@id='vacant']"));
				Select v=new Select(vacant);
				v.selectByIndex(0);
				
				//driver.findElement(By.xpath("")).sendKeys("");
				
				
				
				
//				driver.findElement(By.xpath("//h2[.='Register Room']/../form//input[@id='image']"));
				
				
				
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//button[.='Submit']")).click();
				Thread.sleep(3000);
				
				//validate the successful registration
				String msg=driver.findElement(By.xpath("//h2[.='Apartment Room']/..//div[.='Registration successfull. Thank you']")).getText();
				if(msg.contains("Thank you"))
				{
					System.out.println("property registration successfull");
				}
				else {
					System.out.println("property registration failed");
				}
				//click on home button
				driver.findElement(By.xpath("//a[.='Home']")).click();
				
				//verify the homepage
				String dUrl=driver.getCurrentUrl();
				if(dUrl.contains("dashboard"))
				{
					System.out.println("dashboard is displaying");
				}
				else {
					System.out.println("dashboard is not displaying");
				}
				
				//10. Click on registerd rooms button

				driver.findElement(By.xpath("//h1[.='Dash board']/../div//a")).click();
				//verify the registered rooms page
				
				String ApPage=driver.findElement(By.xpath("//h2[.='List of Apartment Details']")).getText();
				if(ApPage.contains("List of Apartment Details"))
						{
					System.out.println("registered rooms page is displaying");
				}else {
					System.out.println("registered rooms page is not displaying");
				}
				
				//11. click on details/update button
				driver.findElement(By.xpath("//a[.='Details/Update']")).click();
				
				//verify the details/update page
				String DetailsPage=driver.findElement(By.xpath("//h2[.='List of Apartment Details']")).getText();
				if(DetailsPage.contains("List of Apartment Details")){
					System.out.println("details/update page is displaying");
				}else {
					System.out.println("details/update page is not displaying");
				}
				
				
				//12. Click on edit button of required property
				driver.findElement(By.xpath("//p[text()='9966432243']/../../..//a")).click();
				
				//13. update the required section
				driver.findElement(By.xpath("//input[@id='other']")).sendKeys("good");
				
				//14. click on submit button
				driver.findElement(By.xpath("//button[.='Submit']")).click();
				
				//15. Click on complaint button
				driver.findElement(By.xpath("//a[.='Details/Update']")).click();
				driver.findElement(By.xpath("//a[.='Complaint']")).click();
					
				//16. enter apartment number and write complaint
				driver.findElement(By.xpath("//input[@id='name']")).sendKeys("321");
				driver.findElement(By.xpath("//input[@id='cmp']")).sendKeys("power problem");
				
				//17. click on submit button
				driver.findElement(By.xpath("//button[.='Submit']")).click();
				
				//verify the submission msg
				String submsg=driver.findElement(By.xpath("//div[.='Sent Successfully']")).getText();
				if(submsg.contains("Sent Successfully"))
				{
					System.out.println("complaint submitted successfully");
				}
				else {
					System.out.println("complaint not submitted");
				}
				
				//18. Click on logout button
				driver.findElement(By.xpath("//a[.='Logout']")).click();
				
				//verify the landing page
				String Landingpage=driver.findElement(By.xpath("//div[.='Welcome To Room Rental Registration!']")).getText();
					if(Landingpage.contains("Welcome To Room Rental Registration"))
					{System.out.println("successfully redirected to Landingpage");
					}
					else {
						System.out.println("redirection to Landing page failed");
					}
				
				
		
		
	}

}
