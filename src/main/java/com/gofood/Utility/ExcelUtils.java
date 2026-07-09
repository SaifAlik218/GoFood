package com.gofood.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static String getSheetPath() {
		try {
			return ConfigReader.getInstance().getConfig("excelPath");
		} catch (Exception e) {
			throw new RuntimeException("Failed to find sheet path");
		}
	}

	public static synchronized void updateData(String sheetName, int row, String key, int cellKey, String val,
			int cellVal) {
		String SHEET = getSheetPath();
		try (FileInputStream fis = new FileInputStream(SHEET); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				workbook.createSheet(sheetName);
			}
			if (sheet.getRow(0) == null) {
				XSSFRow headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("key");
				headerRow.createCell(1).setCellValue("value");
			}

			int nextRow = sheet.getLastRowNum() + 1;
			XSSFRow dataRow = sheet.createRow(nextRow);
			if (dataRow == null) {
				dataRow = sheet.createRow(row);
			}
			dataRow.createCell(0).setCellValue(key);
			dataRow.createCell(1).setCellValue(val);
			try (FileOutputStream fos = new FileOutputStream(SHEET)) {
				workbook.write(fos);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to find the sheet" + SHEET, e);
		}
	}

	public static synchronized String getCellData(String sheetName, int rowNum, int cellNum) throws Exception {
		String SHEET = getSheetPath();
		try (FileInputStream fis = new FileInputStream(SHEET); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Failed to find the sheet " + sheetName);

			}
			XSSFRow row = sheet.getRow(rowNum);
			if (row == null) {
				throw new RuntimeException("Failed to find the searching row: " + rowNum);
			}
			return row.getCell(cellNum).getStringCellValue();
		} catch (Exception e) {
			throw new RuntimeException("Unable to read sheet:" + sheetName, e);
		}
	}

}
