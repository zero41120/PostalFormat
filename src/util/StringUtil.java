package util;

public class StringUtil {
	public String padLeftFor(String main, String pad, Integer i){
		for (; i > 0; i--) main += pad;
		return main;
	}
	
	public String padRightFor(String main, String pad, Integer i){
		String temp = "";
		for (; i > 0; i--) temp += pad;
		return temp + main;
	}
	
	public String padFor(String main, String pad, Integer i){
		String temp = "";
		for (; i > 0; i--) temp += pad;
		return temp + main + temp;
	}
}
