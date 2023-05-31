package com.re.TwinliteGenericUtilities;


import java.util.Date;
import java.util.Random;

/**
 * this class is used for all the java related programs
 * @author sagar
 *
 */

public class JavaUtility {
	
	/**
	 * this method is used to get the Random number
	 * @param num
	 * @return
	 */
	public int getRandomNumber(int num)
	{
		Random ran=new Random();
		int ranNo=ran.nextInt(num);
		return ranNo;
	}
	
	/**
	 * this method will get current system date
	 * @return
	 */
	public String currentSystemDate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}
	
	/**
	 * this method is used to get the current date in required format
	 * @return
	 */
	public String getSystemDateinFormat()
	{
		Date date=new Date();
		String cdate=date.toString();
		String[]d=cdate.split(" ");
		int month=date.getMonth();
		String week=d[0];
		String Date=d[2];
		String year=d[5];
		String dateformat=month+" "+week+" "+Date+" "+year;
		return dateformat;
		
	}
	
	
	
	

}
