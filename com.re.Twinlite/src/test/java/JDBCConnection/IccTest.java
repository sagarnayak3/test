package JDBCConnection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccTest {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement>countries=driver.findElements(By.xpath("//tbody/tr/td[1][text()<6]/../td[2]/span[2]"));
		for(WebElement L:countries)
		{
			String i=L.getText();
			System.out.println(i);
		}
		
	}

}
