package login;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBServlet;
import common.Encryptor;

public class Register extends DBServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException {
		String userName = null;
		if(request.getParameter("login") != null) {
			response.sendRedirect("login.jsp");
		}
		try {
			//返回之后直接回到注册界面
			request.setAttribute("page", "../pages/register.jsp");
			userName = request.getParameter("userName");
			//userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			if (!checkUserName(userName)) {
				request.setAttribute("info", userName + "已经被使用，请重新注册");
				request.setAttribute("CodeError", userName + "已经被使用");
				return;
			}
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String mobilePhone = request.getParameter("mobilePhone");
			String validateCode = request.getParameter("validateCode");
			if (null == userName || userName.equals("") || null == password || password.equals("")) {
				request.setAttribute("info", "用户名或密码为空，请重新输入");
				request.setAttribute("CodeError", "用户名或密码为空");
				return;
			}
			if (null == validateCode || validateCode.equals("")) {
				request.setAttribute("info", "验证码为空，请重新输入");
				request.setAttribute("CodeError", "验证码为空");
				return;
			}						
			if(!checkValidateCode(request, validateCode)){
				return;
			}
			email = (null == email) ? "" : email;
			mobilePhone = (null == mobilePhone) ? "" : mobilePhone;
			String passwordMD5 = Encryptor.md5Encrypt(password);
			String sql = "insert into t_users(userName, passwordMD5, email, mobilePhone) values (?, ?, ?, ?)";
			execSQL(sql, userName, passwordMD5, email, mobilePhone);
			request.setAttribute("info", "用户注册成功");
		} catch (Exception e) {
			request.setAttribute("info", e.getStackTrace());
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("../pages/result.jsp");
			rd.forward(request, response);			
		}
	}
}
