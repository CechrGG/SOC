package struts2Test.interceptor;

public class MyAction implements Property{
	public String getValue() {
		return "属性值";
	}
	public void execute() {
		System.out.println("execute");
	}
}
