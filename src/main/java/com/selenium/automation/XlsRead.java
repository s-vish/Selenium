package com.selenium.automation;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.WorkbookParser;

/*
download the dependency to run the below code.
https://mvnrepository.com/artifact/net.sourceforge.jexcelapi/jxl/2.6.12

while saving the excel file always select 'use Excel 97-2003'

*/
public class XlsRead {

	@Test(dataProvider = "loginData")
	public void runnerMethod(String email, String password, String passcode)
	{
		System.out.println("email is : "+email);
		System.out.println("password is : "+password);
		System.out.println("passcode is : "+passcode);
	}
	
	@DataProvider(name = "loginData")
	public Object[][] dataMethod() throws BiffException, IOException{
		File file = new File(".\\DataProvider\\DataProvider.xls");
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sh = wb.getSheet("LoginSheet");
		int rows = sh.getRows();
		int col = sh.getColumns();
		
		String data[][]= new String[rows][col];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				Cell c = sh.getCell(j, i);
				data[i][j]=c.getContents();
			}
		}
		return data;
		
		
		// get the number of sheets present in the xls.
//		System.out.println("Number of sheets in xls file are "+wb.getNumberOfSheets());
		
		//print the name of the sheets available in xls.
//		String sheetName[]=wb.getSheetNames();
//		for (String string : sheetName) {
//			System.out.println(string);		
	}
}
		
	
	
	/*
	 * steps 1. get the file using File class 2. in workbook, specify reference of
	 * file object 2. sheet - get the sheet by name/index from workbook 4. get the
	 * total rows from sheet 5. get the total columns from sheet 6. create a multipe
	 * dimensional String array and specify row first and column second. 7. use for
	 * loop for each row and column. 8. create a object of c and use reference of
	 * sheet to provide the values. 9. fetch data from object of cell using method
	 * getContents and store in array of string 10. return string array 11. return
	 * type of method should be 'Object' 12. use DataProvider parameter and name it.
	 * 13. in another method use dataprovider attribute in Test annotation and
	 * provide the number of parameters equal to number of columns in excel.
	 */
	  

	

