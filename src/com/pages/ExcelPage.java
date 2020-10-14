package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPage {

	public static String getCellValue(String sheetName, int rowNum, int cellNum) throws IOException {

		String cellValue = null;
		FileInputStream stream = new FileInputStream("G:\\selenium\\salesForce\\Excel\\SalesForce.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		cellValue = cell.getStringCellValue();
		return cellValue;

	}

	public static void putCellValue(String sheetName, String value) throws IOException {

		FileInputStream stream = new FileInputStream("G:\\selenium\\salesForce\\Excel\\SalesForce.xlsx");
		File f = new File("G:\\selenium\\salesForce\\Excel\\SalesForce.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		sheet.createRow(0).createCell(0).setCellValue(value);
		FileOutputStream fo = new FileOutputStream(f);
		workBook.write(fo);

	}

}
