package com.re.TwinliteGenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection connection=null;
	public void connecToDatabase() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
	}

	
	public void closeDatbase() throws SQLException
	{
		connection.close();
	}
}
