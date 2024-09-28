package com.actitime.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstant
{
	public static String getStringTypeCellData(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		String cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return cellValue;
	}
	
	public double getNumericTypeCellData(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		double cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return cellValue;
	}
	
	public boolean getBooleanTypeCellData(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		boolean cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getBooleanCellValue();
		return cellValue;
	}
	
	public Date getDateTypeCellData(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		Date cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getDateCellValue();
		return cellValue;
	}
	
	public CellAddress getCellAddress(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		CellAddress cellAddress=wb.getSheet(sheet).getRow(row).getCell(cell).getAddress();
		return cellAddress;
	}
	
	public int rowCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheet1=wb.getSheet(sheet);
		int rowNum=sheet1.getLastRowNum();
		return rowNum;
	}
	
	public int cellCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheet1=wb.getSheet(sheet);
		int rowNum=sheet1.getLastRowNum();
		int cellCount=0;
		for(int i=0;i<=rowNum;i++)
		{
			cellCount=sheet1.getRow(i).getLastCellNum(); 
		}
		return cellCount;
	}
}