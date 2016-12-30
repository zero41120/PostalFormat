package postal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import util.FileManager;
import util.PDFManager;

public class PostalPDFManager extends PDFManager {

	private static PDType0Font font = null;
	private static float mmLabelWidth = 208;
	private static float mmLabelHight = 114;

	public void createLabelAt(File workingDirectory, File workingFile) throws Exception {
		PostalExcelManager eManager = new PostalExcelManager();
		FileManager fManager = new FileManager();
		FileOutputStream out = fManager.getOutStreamAt(workingDirectory, workingFile, ".pdf");
		XSSFSheet sheet = eManager.getSheet(workingFile);

		PDDocument doc = new PDDocument();
		font = defaultFont(doc);
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			createPage(doc, sheet.getRow(i));
		}

		doc.save(out);
		out.close();
		doc.close();

	}

	private void createPage(PDDocument doc, XSSFRow row) throws Exception {
		PostalExcelManager eManager = new PostalExcelManager();
		ArrayList<String> arr = eManager.getCellAsArrayString(row, 0, 10);
		if (arr != null) {
			PDRectangle size = new PDRectangle(PDFManager.mm2pt(mmLabelWidth), PDFManager.mm2pt(mmLabelHight));
			PDPage p = new PDPage(size);
			doc.addPage(p);
			PDPageContentStream contents = new PDPageContentStream(doc, p);
			this.setContent(arr, contents);
			contents.close();

		}
	}

	private void setContent(ArrayList<String> arr, PDPageContentStream contents) throws IOException {
		for (int i = 0; i < arr.size(); i++) {
			contents.beginText();
			contents.setFont(font, 12);
			contents.newLineAtOffset(
					FormatProvider.getXOffset(i),
					FormatProvider.getYOffset(i));
			System.out.println(arr.get(i));
			contents.showText(arr.get(i));
			contents.endText();
		}
	}

}
