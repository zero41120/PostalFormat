package util;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

abstract public class PDFManager {
	protected static File zhFontFile = new File("msjh.ttf");
	public final static float MMA4WIDTH = 210.0058f;
	public final static float MMA4HEIGHT = 296.926f;

	protected PDType0Font defaultFont(PDDocument pdf) throws IOException {
		return PDType0Font.load(pdf, PDFManager.zhFontFile);
	}
	
	protected PDPage makePage(float width, float height) {
		PDRectangle size = new PDRectangle(
				PDFManager.mm2pt(width), 
				PDFManager.mm2pt(height));
		return new PDPage(size);
	}
	
	protected PDPage makeA4Page() {
		return makePage(MMA4WIDTH, MMA4HEIGHT);
	}
	public static float pt2mm(float pt) {
		return pt * 25.4f / 72.0f;
	}
	
	public static float mm2pt(float mm){
		return mm * 72.0f / 25.4f;
	}

}
