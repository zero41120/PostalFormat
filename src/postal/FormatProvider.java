package postal;

import java.util.ArrayList;

import util.PDFManager;

public class FormatProvider {

	private final static float MMLABLEWIDTH = 208;
	private final static float MMLABLEHEIGHT = 114;
	private final static float MMASPT = 4;
	
	public static ArrayList<String> getFirstRow() {
		ArrayList<String> out = new ArrayList<>();
		out.add("寄件人郵遞區號");//0
		out.add("寄件人地址");//1
		out.add("寄件人姓名"); //2
		out.add("寄件人電話");//3
		out.add("寄件人手機");//4
		out.add("收件人郵遞區號");//5
		out.add("收件人地址");//6
		out.add("收件人名字");//7
		out.add("收件人電話");//8
		out.add("收件人手機");//9
		return out;
	}
	
	public static float getXOffset(Integer i){
		float right = PDFManager.mm2pt(PDFManager.MMA4WIDTH);
		switch (i) {
			case  0: case  1: case  2: 
			case  5: case  6: case  7:
				return rightOffset(i, 36);
			case  3: case  8: 
				return rightOffset(i, 46);
			case  4: case  9:
				return rightOffset(i, 97);
			default: throw new IndexOutOfBoundsException();
		}
	}
	public static float getYOffset(Integer i){
		float baseS = 19f;
		float baseR = 47f;
		float l = 6.5f;
		float d = 9f;
		switch (i) {
			case  0: return downOffset(i, baseS );
			case  1: return downOffset(i, baseS + l);
			case  2: return downOffset(i, baseS + l * 2);
			case  3: case  4: 
				return downOffset(i, baseS + l * 3);
			case  5: return downOffset(i, baseR );
			case  6: return downOffset(i, baseR + d );
			case  7: return downOffset(i, baseR + d * 2);
			case  8: case  9: 
				return downOffset(i, baseR + d * 3);
			default: throw new IndexOutOfBoundsException();
		}
	}
	public static Integer getFontSize(Integer i){
		switch (i) {
			case  0: return 12;
			case  1: return 12;
			case  2: return 12;
			case  3: return 12;
			case  4: return 12;
			case  5: return 14;
			case  6: return 14;
			case  7: return 14;
			case  8: return 12;
			case  9: return 12;
			default: throw new IndexOutOfBoundsException();
		}
	}
	
	private static float downOffset(int whitchItem, float offsetMM) {
		float top = PDFManager.mm2pt(PDFManager.MMA4HEIGHT);
		top -= getFontSize(whitchItem);
		top -= PDFManager.mm2pt(offsetMM);
		return top;
	}
	
	private static float rightOffset(int whitchItem,float offset) {
		return PDFManager.mm2pt(offset);
	
	}
	

}
