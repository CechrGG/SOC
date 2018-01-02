package struts2Test.modeldriven;

import java.sql.SQLException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import struts2Test.exception.UserException;
import struts2Test.models.UserModel;

public class LoginAction implements ModelDriven<UserModel> {
	private UserModel model = new UserModel();
	//实现ModelDriven的接口
	public UserModel getModel() {
		return this.model;
	}
	
	public String execute() throws Exception {
		if(getModel().getUsername() == null || getModel().getUsername().equals("")) {
			throw new UserException("用户名不能为空，抛出用户异常");
		} else if(getModel().getPassword() == null || getModel().getPassword().equals("")) {
			throw new SQLException("查不到该用户的密码，抛出数据库异常");
		} else if(getModel().getUsername().equals("gg") && getModel().getPassword().equals("123")) {
			getModel().setResult("SUCCESS");
			return Action.SUCCESS;
		} else {
			return Action.ERROR;
		}
	} 

}
