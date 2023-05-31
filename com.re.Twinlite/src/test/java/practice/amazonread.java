package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class amazonread {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		
		System.out.println("to get the count of rows created  "+sh.getLastRowNum());
		
		int lastrow= book.getSheet("Sheet1").getLastRowNum();
//		for(int i=0;i<lastrow;i++)
//		{
//			Row rw=sh.getRow(i);
//			for(int j=0;j<lastrow;i++)
//			{
//				Cell cell=rw.getCell(0);
//				DataFormatter df=new DataFormatter();
//				String data= df.formatCellValue(cell);
//				System.out.println(data);
//			}
//		}
		
		
		for(int i=0;i<lastrow;i++)
		{
			String links=book.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			System.out.println(links);
		}
		
		
		
		
		
	}

}
