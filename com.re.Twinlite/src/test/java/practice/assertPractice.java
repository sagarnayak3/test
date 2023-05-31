package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertPractice {
	@Test
	public void testAddition()
	{
		//int result =add(2,3);
		//int expected=5;
		String result="sagar";
		String expected="sagar";
		Assert.assertEquals(result, expected);
		
	}
	
	private int add(int a, int b) {
        return a + b;
    }

}
