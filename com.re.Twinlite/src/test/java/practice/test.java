package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.re.TwinliteGenericUtilities.ExcelUtility;
import com.re.TwinliteGenericUtilities.FileUtility;
import com.re.TwinliteGenericUtilities.JavaUtility;
import com.re.TwinliteGenericUtilities.WebDriverUtility;


public class test {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		JavaUtility ju=new JavaUtility();
		FileUtility fu=new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		WebDriverUtility wbu=new WebDriverUtility();
		
		String f=eu.getExcelData("Sheet1", 1, 1);
		System.out.println(f);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https:www.google.com");
		wbu.maximizeTheWindow(driver);
		wbu.waitTillPageGetsLoaded(driver);
		wbu.takeScreenShot(driver,"scggg");
		driver.close();
		
	}

}
