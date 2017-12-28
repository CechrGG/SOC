package struts2Test.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage(value = "struts-default")
@Namespace(value = "/test")

public class TestAction {
	@Action(value = "test", results = {@Result(name = "success", location = "/pages/success.jsp"),
									@Result(name = "error", location = "/pages/error.jsp")})
	public String execute() throws Exception {
		try {
			System.out.println("test");
			return "success";
		} catch (Exception e ) {
			return "error";
		}
	}
}
