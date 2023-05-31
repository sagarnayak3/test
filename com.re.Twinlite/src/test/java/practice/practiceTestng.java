package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.re.Twinlite.ObjectRepository.LoginPage;
import com.re.Twinlite.ObjectRepository.RegisterUserPage;
import com.re.TwinliteGenericUtilities.BaseClass;
import com.re.TwinliteGenericUtilities.ExcelUtility;

public class practiceTestng extends BaseClass{
	@Test(priority=0)
	public void create()
	{
		System.out.println("creating the user ");
	}
	
	
	
	@Test
	public void update()
	{
		System.out.println("updating the user");
	}
	
	@Test(dependsOnMethods="create")
	public void delete()
	{
		System.out.println("deleting the user");
	}
	
	@Test(dataProviderClass=getDatafromProvider.class,dataProvider="data1")
	public void getData(String city,String place,String object)
	{
		System.out.println("city "+city+" has got "+place+" famous for "+object);
	}
	
	@Test
	public void test1() throws Throwable
	{    
		
		ExcelUtility eutil=new ExcelUtility();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		RegisterUserPage registerUserPage=new RegisterUserPage(driver);
		registerUserPage.clickOnRegisterButton();
	//	HomePage1 hp=new HomePage1();
		//hp.registerUser(eutil.getMultipleData("d1"),driver);
	//	
	}
	

}
