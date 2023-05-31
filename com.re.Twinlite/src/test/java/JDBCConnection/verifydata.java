package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mysql.cj.jdbc.Driver;


public class verifydata {
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		String pj="karnataka";
		try {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = connection.createStatement();
		
		String query="insert into project values('TY_PROJ_1333','lalappa','12/01/2023','"+pj+"','On Going',5);";
		int result= statement.executeUpdate(query);
		if(result>=1)
		
			System.out.println("data is addded");
		else
			System.out.println("data is not added");
		
	}
		finally {
			connection.close();
		}
	
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	System.setProperty("webdriver.chrome.driver","D:\\experience\\chromedriver_win32\\chromedriver.exe\\");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://rmgtestingserver:8084/");
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	List <WebElement> projects=driver.findElements(By.xpath("//tbody/tr/td[2]"));
	String Searchproject=pj;
	boolean flag=false;
	for(WebElement p:projects) {
		String t=p.getText();
		if(t.equalsIgnoreCase(Searchproject))
		flag=true;
	}
	if(flag)
		System.out.println(Searchproject +"is present");
		else
			System.out.println(Searchproject+" is absent");
	
	driver.close();

}
}
