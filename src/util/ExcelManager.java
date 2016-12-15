package util;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelManager extends Manager {

	public void setCellWithArrayString(XSSFRow row, ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(arr.get(i));
		}
	}
	
	public ArrayList<String> getCellAsArrayString(XSSFRow row, Integer begin, Integer end){
		ArrayList<String> data = new ArrayList<>();
		for (int i = begin; i < end; i++) {
			XSSFCell cell = row.getCell(i);
			try {
				data.add(cell.getStringCellValue());
			} catch (Exception e){
				data.add(cell.getRawValue().toString());
			}
		}
		ArrayUtil<String> aUtil = new ArrayUtil<>();
		
		return aUtil.isAllEqual(data)? (new ArrayList<String>()) : data;
	}

	public boolean isEqualCellArrayString(XSSFRow row, ArrayList<String> arr) {
		try {
			for (int i = 0; i < arr.size(); i++) {
				XSSFCell cell = row.getCell(i);
				try {
					if (!cell.getStringCellValue().equals(arr.get(i)))
						return false;
				} catch (Exception e){
					return false;
				}
					
			}
		} catch (Exception e) {
			// Probably array out of bound. 
			e.getMessage();
			return false;
		}
		return true;
	}
	
	public XSSFSheet getSheet(File workingFile, Integer index) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook(workingFile);
		wb.close();
		return wb.getSheetAt(index);		
	}
}
