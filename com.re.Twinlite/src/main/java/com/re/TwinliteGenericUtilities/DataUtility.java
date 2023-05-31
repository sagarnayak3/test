package com.re.TwinliteGenericUtilities;

import org.testng.annotations.DataProvider;

public class DataUtility {
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eutil=new ExcelUtility();
		Object[][] value=eutil.readSetofData("Sheet3");
		return value;
	}

}
