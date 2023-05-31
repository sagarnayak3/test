package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoMySql {
	
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
		Statement statement = connection.createStatement();
		String query="insert into sagar values('5','lalappa','lalappa@kalburgi.com','1999-08-03');";
		int result= statement.executeUpdate(query);
		if(result==1)
		
			System.out.println("data is addded");
		else
			System.out.println("data is not added");
		
	}
		finally {
			connection.close();
		}
	}
}
