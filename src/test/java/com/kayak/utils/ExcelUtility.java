package com.kayak.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility  {
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public void openExcel(String filePath, String sheetName) {
		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Map<String, String>> getCellDataList() {
		List<Map<String, String>> cellList = new ArrayList<>();
		Map<String, String> rowMap = null;
		for(int i=1; i<getRowNum(); i++) {
			rowMap = new LinkedHashMap<>();
			for(int j=0; j<getColNum(0); j++) {
				rowMap.put(getCellData(0, j).toString(), getCellData(i, j));
			}
		cellList.add(rowMap);
		}
		return cellList;
	}
	
	public int getColNum(int row) {
		
		return sheet.getRow(row).getLastCellNum();
	}
	
	public int getRowNum() {
		
		return sheet.getPhysicalNumberOfRows();
	}
	
	public String getCellData(int row, int col) {
		
		return sheet.getRow(row).getCell(col).toString();
	}
	
	public void closeExcel() {
		try {
			if(workbook !=null)
				workbook.close();
			if(fis !=null)
				fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
