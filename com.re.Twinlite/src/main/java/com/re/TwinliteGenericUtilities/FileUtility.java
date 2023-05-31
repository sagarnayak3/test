package com.re.TwinliteGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class is used to get value from property file.
 * @author sagar
 *
 */

public class FileUtility {
	
	/**
	 * this method is used to get value from property file.
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.PropertyfilePath);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(Key);
		return data;
		
		
		
		
	}
	
	
	

}
