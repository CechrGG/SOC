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
			return;
		}
		try {
			super.service(request, response);
			userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String mobilePhone = request.getParameter("phone");
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
			//userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			request.setAttribute("page", "register.jsp");
			if(!checkValidateCode(request, validateCode)){
				return;
			}
			email = (null == email) ? "" : email;
			mobilePhone = (null == mobilePhone) ? "" : mobilePhone;
			String passwordMD5 = Encryptor.md5Encrypt(password);
			String sql = "select * from t_users where userName=" + userName;
			ResultSet rs = null;
			rs = execQuery(sql);
			if(rs.next()) {
				request.setAttribute("info", userName + "已经被使用，请重新输入");
				request.setAttribute("CodeError", userName + "已经被使用");
				return;
			}
			sql = "insert into t_users(userName, passwordMD5, email, mobilePhone) values (?, ?, ?)";
			execSQL(sql, userName, passwordMD5, email, mobilePhone);
			request.setAttribute("info", "用户注册成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);			
		}
	}
}
