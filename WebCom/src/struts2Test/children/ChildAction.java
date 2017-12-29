package struts2Test.children;

import org.apache.struts2.convention.annotation.Action;
//import org.apache.struts2.convention.annotation.Namespace;
//import org.apache.struts2.convention.annotation.ParentPackage;
//import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.convention.annotation.Results;

////指定父包
//@ParentPackage(value = "parents")
////指定命名空间
//@Namespace(value = "/test")
////指定结果
//@Results({@Result(name = "success", location = "/pages/success.jsp"),
//		@Result(name = "error", location = "/pages/error.jsp")})

public class ChildAction {
	@Action(value = "child")
	public String execute() throws Exception {
		try {
			System.out.println("child");
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
}
