package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.re.TwinliteGenericUtilities.DataUtility;
import com.re.TwinliteGenericUtilities.ExcelUtility;

public class getDatafromProvider {
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] arr=new Object[2][2];
		arr[0][0]="Bangalore";
		arr[0][1]="vidhansoudha";
		arr[1][0]="Hyderabad";
		arr[1][1]="golgumbaz";
		return arr;
	}
	
	@DataProvider
	public Object[][] data1()
	{
		Object[][] arr=new Object[2][3];
		arr[0][0]="Bangalore";
		arr[0][1]="vidhansoudha";
		arr[0][2]="cubbonpark";
		arr[1][0]="Hyderabad";
		arr[1][1]="golgumbaz";
		arr[1][2]="iranichai";
		return arr;
	}
	
	@DataProvider
	public Object[][] data3(){
		
		Object[][] arr=new Object[4][5];
		arr[0][0]="goa";
		arr[0][1]="udupi";
		arr[0][2]="karnataka";
		arr[0][3]="India";
		arr[0][4]=900;		
		arr[1][0]="kodagu";
		arr[1][1]="mysore";
		arr[1][2]="karnataka";
		arr[1][3]="India";
		arr[1][4]=250;	
		arr[2][0]="bidar";
		arr[2][1]="gulbarga";
		arr[2][2]="karnataka";
		arr[2][3]="India";
		arr[2][4]=500;	
		arr[3][0]="belgam";
		arr[3][1]="hubli";
		arr[3][2]="karnataka";
		arr[3][3]="India";
		arr[3][4]=410;
		
		return arr;
	}
		
		@Test(dataProvider= "data3")
		public void getData1(String src,String dest,String state,String country, int price)
		{
			System.out.println("From "+src+" to "+dest+"  "+state+" "+country+" "+price);
		}
		
		
		@DataProvider
		public Object[][] data4(){
			
			Object[][] arr=new Object[3][2];
			arr[0][0]="Vijayapura";
			arr[0][1]="goa";
			
			arr[1][0]="QSpiders";
			arr[1][1]="oldairport road";
			
			arr[2][0]="jspiders";
			arr[2][1]="silk board";
			
			return arr;
		}
			
			@Test(dataProvider= "data4")
			public void getData(String src,String dest)
			{
				System.out.println("From "+src+" to "+dest);
			}
			
			@DataProvider
			public Object[][] getData() throws Throwable
			{
				ExcelUtility eutil=new ExcelUtility();
				Object[][] value=eutil.readSetofData(null);
				return value;
			}
			
			@Test(dataProviderClass= DataUtility.class,dataProvider="getData")
			public void getexc(String name, String place, String gender)
			{
				System.out.println(name+" "+place+" "+gender);
			}
}



