package postal;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.ExcelManager;
import util.FileManager;
import util.ValidationException;

public class PostalExcelManager extends ExcelManager {
	final static String NAME = "空白總表";
	final static String EXTENSION = ".xlsx";
	
	@Override
	public void validate(Object target) throws Exception{
		File myFile = (File) target;
		ArrayList<String> firstRow = FormatProvider.getFirstRow();
		XSSFWorkbook wb = new XSSFWorkbook(myFile);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		if (!isEqualCellArrayString(row, firstRow)) {
			wb.close();
			throw new ValidationException("選擇的總表標題 與 預設標題 不相等");
		}
		wb.close();
	}
	public void createDefaultAt(File selectedDirectory) throws Exception {
		System.out.println("createDefaultAt");
		ArrayList<String> firstRow = FormatProvider.getFirstRow();
		FileManager fManager = new FileManager();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Default");
	    XSSFRow row = sheet.createRow(0);
	    setCellWithArrayString(row, firstRow);
	    FileOutputStream out = 
				fManager.getOutStreamAt(selectedDirectory, NAME, EXTENSION);
		wb.write(out);
		wb.close();
		out.close();
	}
	public XSSFSheet getSheet(File workingFile) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook(workingFile);
		wb.close();
		return wb.getSheetAt(0);		
	}
	
	public ArrayList<String> getData(File workingFile, Integer atRow) throws Exception{
		XSSFSheet sheet = getSheet(workingFile);
		return getCellAsArrayString(sheet.getRow(atRow), 1, 10);
	}

}
