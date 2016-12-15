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

}
