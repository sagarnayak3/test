package JDBCConnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import com.mysql.jdbc.Driver;

public class RmgYantraTest {
	public static void main(String[] args) throws SQLException  {
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
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		String pname="twinlite";
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(pname);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("sagar");
		WebElement select=driver.findElement(By.xpath("//h4[.='Create Project']/../../div[2]/div[4]/select"));
		Select s=new Select(select);
		s.selectByIndex(2);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		driver.close();
		Connection connection=null;
		try {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from project");
//		while(resultset.next()){
//			System.out.println(resultset.getString(4));
//		}
//		}
//		finally {
//			connection.close();
//		}
		
		
		String SearchProject=pname;
		boolean flag=false;
		while(resultset.next()) {
			String t=resultset.getString(4);
			if(t.equalsIgnoreCase(SearchProject))
			flag=true;
		}
		if(flag)
			System.out.println(SearchProject +"is present");
			else
				System.out.println(SearchProject+" is not present");
		
				
	//	driver.findElement(By.xpath("")).sendKeys("");
		
		
		
		
		}
		finally {
			connection.close();
		}
	}

}
