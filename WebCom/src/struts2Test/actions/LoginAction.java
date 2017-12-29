package struts2Test.actions;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

//命名空间
@Namespace(value = "/test")

@Results({@Result(name = "success", location = "/pages/success.jsp"), 
		@Result(name = "error", location = "/pages/error.jsp")})

public class LoginAction implements com.opensymphony.xwork2.Action{
	private String username;
	private String password;
	//保存信息
	private static HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginAction() {
		users.put("gg", "123");
		users.put("qq", "123");
		users.put("any", "123");
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		try {
			ActionContext ctx = ActionContext.getContext();
			Map<String, Object> application = ctx.getApplication();
			Map<String, Object> session = ctx.getSession();
			Integer counter = (Integer)application.get("counter");
			session.put("username", getUsername());
			String pw = users.get(username);
			if(null == pw) {
				ctx.put("info", "该用户不存在，请重新输入");
				return ERROR;
			} else {
				if(pw.equals(getPassword())) {
					if(null == counter) {
						counter = 1;
					} else {
						counter++;
					}
					application.put("counter", counter);
					ctx.put("info", "登录成功");
					return SUCCESS;
				} else {
					ctx.put("info", "密码不正确，请重新输入");
					return ERROR;
				}
			}
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "register", results = {@Result(name = "register", location = "/pages/register.jsp")})
	public String register() throws Exception {
		return "register";
	}
}
