package postal;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import util.FileManager;
import util.WordManager;

public class PostalWordManager extends WordManager {
	// Word did not work as excepted. Abort
	public void createLabelAt(File workingDirectory, File workingFile) throws Exception {
		PostalExcelManager eManager = new PostalExcelManager();
		FileManager fManager = new FileManager();
		FileOutputStream out = fManager.getOutStreamAt(workingDirectory, workingFile, ".doc");
		XSSFSheet sheet = eManager.getSheet(workingFile);
		
		XWPFDocument doc = new XWPFDocument();
		
		for (int i = 1; i < sheet.getLastRowNum(); i++){
			createLabel(doc, sheet.getRow(i));
		}
		/*
		 * for each row create an paragraph
		 *     for each cell, print on paragraph
		 * 
		 */
		
		doc.write(out);
		out.close();
		doc.close();

	}
	
	private void createLabel(XWPFDocument doc, XSSFRow row){
		PostalExcelManager eManager = new PostalExcelManager();
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		ArrayList<String> arr = eManager.getCellAsArrayString(row, 0, 10);
		r.setText(arr.toString());
		r.addBreak(BreakType.PAGE);
		//r.setBold(true);
		//r.setFontFamily("Courier");
		//r.setTextPosition(10); // Distance between lines
		//r.setFontSize(20);
	}

}
