package com.urban.utillities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	static String xfile = System.getProperty("user.dir")+"\\src\\test\\resources\\ProjectData.xlsx";
	
	public static String readDataFromExcel(String sheetName, int r, int c) {
		String data ="";
		try {
			fi = new FileInputStream(xfile);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(r);
			cell = row.getCell(c);
			
			if(cell != null) {
				if(cell.getCellType() == CellType.NUMERIC)
					data = String.valueOf((int)cell.getNumericCellValue());
				else
					data = cell.toString();
					
			}
			workbook.close();
			fi.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return data;
		
	}
	
	public static void writeDataIntoExcel(String sheetName, int r, int c, String message) {
		try {
			fi = new FileInputStream(xfile);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(r);
			if(row == null)
				row = sheet.createRow(r);
			cell = row.createCell(c);

			try {
				double value = Double.parseDouble(message);
				cell.setCellValue(value);
				
			} catch (NumberFormatException e) {
				
				cell.setCellValue(message);
			}

			fo = new FileOutputStream(xfile);
			workbook.write(fo);
			workbook.close();
			fo.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	public static void fillGreenColor(String sheetName, int r, int c) {
		try {
			fi = new FileInputStream(xfile);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(r);
			cell = row.getCell(c);
			
			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			
			fo = new FileOutputStream(xfile);
			workbook.write(fo);
			workbook.close();
			fo.close();
			fi.close();
			
		} catch (IOException e) {
			
			System.out.println("Unable to Color");
		}
		
	}
	public static void fillRedColor(String sheetName, int r, int c) {
		try {
			fi = new FileInputStream(xfile);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(r);
			cell = row.getCell(c);
			
			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			
			fo = new FileOutputStream(xfile);
			workbook.write(fo);
			workbook.close();
			fo.close();
			fi.close();
			
		} catch (IOException e) {
			
			System.out.println("Unable to Color");
		}
	}
	
}
