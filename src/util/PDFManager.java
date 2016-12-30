package util;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PDFManager {
	protected static File zhFontFile = new File("msjh.ttf");

	protected PDType0Font defaultFont(PDDocument pdf) throws IOException {
		return PDType0Font.load(pdf, PDFManager.zhFontFile);
	}

	public static float pt2mm(float pt) {
		return pt * 25.4f / 72;
	}
	
	public static float mm2pt(float mm){
		return mm * 72 / 25.4f;
	}

}
