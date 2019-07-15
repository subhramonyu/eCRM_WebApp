package com.eCRM.client.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static FileInputStream workbookFileObject;
	private static XSSFWorkbook workbookObject;
	private static XSSFSheet worksheetObject;
	private static Row row;
	private static Cell cell;
	private static FileOutputStream outputStream;
	private static CellStyle cellStyle;
	private static CellStyle cellStyleRed;
	private static CellStyle cellStyleWhite;
	private static DataFormat format;
	
	public static void initSheet(String workBookPath, String sheetName) {
		try {
			workbookFileObject = new FileInputStream(workBookPath);
			workbookObject  = new XSSFWorkbook(workbookFileObject);
			worksheetObject = workbookObject.getSheet(sheetName);
			cellStyle = workbookObject.createCellStyle();
			cellStyleRed = workbookObject.createCellStyle();
			cellStyleWhite = workbookObject.createCellStyle();
			format = workbookObject.createDataFormat();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void appendRows(String workBookPath, String sheetName, Object[][] values){
		try
		{
			initSheet(workBookPath, sheetName);
			int lastRow = worksheetObject.getLastRowNum();
			for (Object[] value: values) {
				row = worksheetObject.createRow(++lastRow);
				int colNum = 0;
				for (Object cellValue : value) {
					cell = row.createCell(colNum++);
					if (cellValue instanceof String) {
						cell.setCellValue((String) cellValue);
					} else if (cellValue instanceof Float) {
						cell.setCellValue((Float) cellValue);
						cellStyleRed.setDataFormat(format.getFormat("#.##"));
						cellStyleWhite.setDataFormat(format.getFormat("#.##"));
						if((Float)cellValue < 10.0)
							setCellForegroundColor(cell, IndexedColors.RED);
						else
							setCellForegroundColor(cell, IndexedColors.BLACK);
					}
				}
			}
			workbookFileObject.close();
			saveWorkbook(workBookPath);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void saveWorkbook(String workbookPath) {
		try {
			outputStream = new FileOutputStream(workbookPath);
			workbookObject.write(outputStream);
			workbookObject.close();
			outputStream.close();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setCellForegroundColor(Cell cell, IndexedColors colorName) {
		switch(colorName) {
		case RED:
			cellStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
			cellStyleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyleRed);
			break;
		case WHITE:
			cellStyle.setFillBackgroundColor(colorName.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyle);
			break;
		default:
			cellStyleWhite.setFillPattern(FillPatternType.NO_FILL);
			cell.setCellStyle(cellStyleWhite);
			break;
		}
	}

}
