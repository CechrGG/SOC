package jspfun;

public class JspFunTest {
	//Jsp直接调用静态函数
	public static String processStr(String str) {
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll(" ", "&nbsp;");
		return str;
	}
}
