package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.re.TwinliteGenericUtilities.JavaScriptUtility;

public class JavaScriptPractice {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	JavaScriptUtility js=new JavaScriptUtility();
	
	//launch application
	js.launchApplication("https://docs.phptravels.com/");
	
	//get url of the current page
	String url=js.getUrlOfCurrentPage();
	System.out.println(url);
	
	//get title of the current page
	String title=js.getTitleOfCurrentPage();
	System.out.println(title);
	
	//scrolldown
	js.scrollDown();
	
	Thread.sleep(3000);
	
	//sroll up
	js.scrollUp();
	
	
	
	
	
	
	
	
	
	
	}
}
