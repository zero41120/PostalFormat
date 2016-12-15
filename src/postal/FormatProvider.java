package postal;

import java.util.ArrayList;

import util.StringUtil;

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
	
	public static String getPrintFormat(ArrayList<String> arr){
		String out = arr.toString();
		StringUtil util = new StringUtil();
		for (int i = 0; i < arr.size(); i++) {
			String temp = "";
			switch (i) {
			case 0: temp += util.padFor(arr.get(i), "\n", 3); break;
			case 1: temp += util.padFor(arr.get(i), "|", 3); break;
			case 2: temp += util.padFor(arr.get(i), "\n", 3); break;
			case 3: temp += util.padFor(arr.get(i), "\t", 3); break;
			case 4: temp += util.padFor(arr.get(i), ".", 3); break;
			case 5: temp += util.padFor(arr.get(i), "~", 3); break;
			case 6: temp += util.padFor(arr.get(i), "$", 3); break;
			case 7: temp += util.padFor(arr.get(i), "^", 3); break;
			case 8: temp += util.padFor(arr.get(i), "&", 3); break;
			case 9: temp += util.padFor(arr.get(i), "*", 3); break;
			case 10: temp += util.padFor(arr.get(i), "(", 3); break;
			default: break;
			}
			out += temp;
		}
		return out;
	}

}
