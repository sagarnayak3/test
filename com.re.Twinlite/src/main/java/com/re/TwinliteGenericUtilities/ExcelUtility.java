package com.re.TwinliteGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of excel related methods like insert data , fetch data, get row num
 * @author sagar
 *
 */

public class ExcelUtility {
	
	/**
	 * This class is used to write data into the excel file
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void insertIntoExcel(String sheetname,int rowno,int cellno,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rowno);
		Cell cell=row.getCell(cellno);
		cell.setCellValue(data);
		FileOutputStream fos= new FileOutputStream(IpathConstants.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	public String getExcelData(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rowno);
		Cell cell=row.getCell(cellno);
		DataFormatter dataFormatter=new DataFormatter();
		String value=dataFormatter.formatCellValue(cell);
		return value;
		
		
	}
	
	/**
	 * this method gets count of rows created in excel sheet
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowNumber(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int row =sh.getLastRowNum();
		return row;
	}
	
	
	/**
	 * This method is used to get the excel data into two dimensional array , which helps the data utility class for testng data provider
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readSetofData(String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		int LastRow =sh.getLastRowNum()+1;
		int LastCell=sh.getRow(0).getLastCellNum();
		DataFormatter dataFormatter=new DataFormatter();
		
		Object[][] obj =new Object[LastRow][LastCell];
				for(int i=0;i<LastRow;i++)
				{
					for (int j=0;j<LastCell;j++)
					{
						obj[i][j]=dataFormatter.formatCellValue((sh.getRow(i).getCell(j)));
						
					}
				}
		return obj;
	}
	
	
	/**
	 * 
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getMultipleData(String sheetname) throws Throwable
	{

		FileInputStream fis=new FileInputStream(IpathConstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int count =sh.getLastRowNum();
		DataFormatter dataFormatter=new DataFormatter();
		HashMap<String, String> map=new HashMap<String,String>();
		
		for (int i = 0; i < count; i++) 
		{
			String Key=dataFormatter.formatCellValue(sh.getRow(i).getCell(0));
			String Value=dataFormatter.formatCellValue(sh.getRow(i).getCell(1));
			map.put(Key, Value);
		}
		return map;
	}
	
	

}
