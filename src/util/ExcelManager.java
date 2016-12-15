package util;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public abstract class ExcelManager extends Manager {

	public void setCellWithArrayString(XSSFRow row, ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(arr.get(i));
		}
	}

	public boolean isEqualCellArrayString(XSSFRow row, ArrayList<String> arr) {
		try {
			for (int i = 0; i < arr.size(); i++) {
				XSSFCell cell = row.getCell(i);
				if (!cell.getStringCellValue().equals(arr.get(i)))
					return false;
			}
		} catch (Exception e) {
			// Probably array out of bound. 
			e.getMessage();
			return false;
		}
		return true;
	}
}
