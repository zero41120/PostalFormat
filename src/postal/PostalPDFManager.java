package postal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import util.PDFManager;

public class PostalPDFManager extends PDFManager {
	
	class PostalText{
		float x, y;
		String text;
		int size;
		public PostalText(float myX, float myY, int mySize,String myText) {
			x = myX;
			y = myY;
			size = mySize;
			text = myText;
		}
		public String toString() {
			return "\n(" + x + "," + y + "," + text + ")";
		}
	}
	File myExcelFile;
	XSSFSheet mySheet;
	ArrayList<PostalText> locationArray;
	float nextOffset;
	public PostalPDFManager(File workingFile) throws Exception {
		PostalExcelManager eManager = new PostalExcelManager();
		myExcelFile = workingFile;
		mySheet = eManager.getSheet(myExcelFile);
		locationArray = new ArrayList<>();
		initQueue();
		nextOffset = 0;
	}
	
	private void initQueue() {
		PostalExcelManager eManager = new PostalExcelManager();
		for (int i = 1; i < mySheet.getLastRowNum(); i++) {
			XSSFRow row = mySheet.getRow(i);
			ArrayList<String> myArray = eManager.getCellAsArrayString(row, 0, 10);
			for (int j = 0; j < myArray.size(); j++) {
				PostalText text = new PostalText(
						FormatProvider.getXOffset(j),
						FormatProvider.getYOffset(j),
						FormatProvider.getFontSize(j),
						myArray.get(j)
				);
				locationArray.add(text);
			}
			locationArray.add(new PostalText(0, 0, 0, "------"));
		}
	}
	public void createLabelAt(File workingDirectory) throws IOException {
		PDDocument doc = new PDDocument();
		PostalFileManager fManager = new PostalFileManager();
		FileOutputStream out = fManager.getOutStreamAt(workingDirectory, myExcelFile, ".pdf");
		PDFont font = defaultFont(doc);
		PDPage page = super.makeA4Page();
		doc.addPage(page);
		PDPageContentStream contents = new PDPageContentStream(doc, page);
		System.out.println(locationArray);
		System.out.println("m4h:" + mm2pt(MMA4HEIGHT));
		
		for (int i = 0; i < locationArray.size(); i++) {
			PostalText myText = locationArray.get(i);
			if(myText.size == 0) {
				nextOffset += 120;
				continue;
			} 
			if(myText.y - mm2pt(nextOffset) < 0) {
				contents.beginText();
				contents.setFont(font, 12);
				contents.newLineAtOffset(myText.x, myText.y - mm2pt(nextOffset));
				contents.showText(myText.text);
				contents.endText();	
				
				System.out.println(myText);
				System.out.println(myText.y - mm2pt(nextOffset));
				System.out.println(pt2mm(myText.y - mm2pt(nextOffset)));
				System.out.println(nextOffset);
				nextOffset = pt2mm(myText.y) - MMA4HEIGHT - pt2mm(myText.y - mm2pt(nextOffset));
				System.out.println(nextOffset);
				
				contents.close();
				page = super.makeA4Page();
				doc.addPage(page);
				contents = new PDPageContentStream(doc, page);
			} 
			contents.beginText();
			contents.setFont(font, 12);
			contents.newLineAtOffset(myText.x, myText.y - mm2pt(nextOffset));
			contents.showText(myText.text);
			contents.endText();	
			
			
		}
		contents.close();
		doc.save(out);
		out.close();
		doc.close();
	}
	
}
