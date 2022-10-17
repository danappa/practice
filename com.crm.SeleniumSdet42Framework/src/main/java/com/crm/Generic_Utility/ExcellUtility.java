package com.crm.Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	/**
	 * this method is used to get the data from excell File
	 * @param SheetName
	 * @param Row
	 * @param Cell
	 * @return
	 * @throws IOException
	 */
	public String getExcellKeyValue(String SheetName,int Row,int Cell) throws IOException
	{
//		FileInputStream fis=new FileInputStream("./Book2.xlsx");
		FileInputStream fis=new FileInputStream(ipathConstant.EXCELL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(Row);
		Cell cell =row.getCell(Cell);
		String data = cell.getStringCellValue();
		return data;
	}
		
}
