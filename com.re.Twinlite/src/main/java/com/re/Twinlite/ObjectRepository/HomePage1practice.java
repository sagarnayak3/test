package com.re.Twinlite.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.re.TwinliteGenericUtilities.JavaUtility;

public class HomePage1practice {
	//Declaration
	//initialization
	//business library
	public void registerUser(HashMap<String,String> fields, WebDriver driver)
	{
	for(Entry<String,String> set:fields.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
	}
	}

}
