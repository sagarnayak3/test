package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDB {
	
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
		Statement statement = connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from sagar");
		while(resultset.next()){
			System.out.println(resultset.getString(3));
		}
		}
		finally {
			connection.close();
		}
		
		
		
	}
	
	
	
	
	

}
