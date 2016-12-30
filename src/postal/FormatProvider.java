package postal;

import java.util.ArrayList;

public class FormatProvider {

	public static ArrayList<String> getFirstRow() {
		ArrayList<String> out = new ArrayList<>();
		out.add("寄件人姓名");
		out.add("寄件人郵遞區號");
		out.add("寄件人地址");
		out.add("寄件人電話");
		out.add("寄件人手機");
		out.add("收件人名字");
		out.add("收件人郵遞區號");
		out.add("收件人地址");
		out.add("收件人電話");
		out.add("收件人手機");
		return out;
	}
	
	public static Integer getXOffset(Integer i){
		switch (i) {
			case  0: return 10;
			case  1: return 20;
			case  2: return 30;
			case	  3: return 40;
			case  4: return 50;
			case  5: return 60;
			case  6: return 70;
			case  7: return 80;
			case  8: return 90;
			case  9: return 100;
			case 10: return 110;
			default: throw new IndexOutOfBoundsException();
		}
	}
	public static Integer getYOffset(Integer i){
		switch (i) {
		case  0: return 10;
		case  1: return 20;
		case  2: return 30;
		case	  3: return 40;
		case  4: return 50;
		case  5: return 60;
		case  6: return 70;
		case  7: return 80;
		case  8: return 90;
		case  9: return 100;
		case 10: return 110;
		default: throw new IndexOutOfBoundsException();
	}
	}
	public static Integer getFontSize(Integer i){
		switch (i) {
		case  0: return 12;
		case  1: return 12;
		case  2: return 12;
		case	  3: return 12;
		case  4: return 12;
		case  5: return 12;
		case  6: return 12;
		case  7: return 12;
		case  8: return 12;
		case  9: return 12;
		case 10: return 12;
		default: throw new IndexOutOfBoundsException();
	}
	}

}
