package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBServlet;

public class Login extends DBServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException {
		String userName = null;
		if(request.getParameter("register") != null) {
			response.sendRedirect("../pages/register.jsp");
			return;
		}
		try {
			//返回之后直接回到注册界面
			request.setAttribute("page", "../pages/login.jsp");
			userName = request.getParameter("userName");
			//userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			String password = request.getParameter("password");
			if (null == userName || userName.equals("") || null == password || password.equals("")) {
				request.setAttribute("info", "用户名或密码为空，请重新输入");
				request.setAttribute("CodeError", "用户名或密码为空");
				return;
			}						
			if (checkUserName(userName)) {
				request.setAttribute("info", "用户名" + userName + "不存在，请重新输入");
				request.setAttribute("CodeError", "用户名" + userName + "不存在");
				return;
			}
			if (!checkPassword(userName, password)){
				request.setAttribute("info", "密码错误，请重新输入");
				return;
			}
			
			String validateCode = request.getParameter("validateCode");
			if (null == validateCode || validateCode.equals("")) {
				request.setAttribute("info", "验证码为空，请重新输入");
				request.setAttribute("CodeError", "验证码为空");
				return;
			}						
			if(!checkValidateCode(request, validateCode)){
				return;
			}

			request.setAttribute("info", "用户登录成功");
			request.setAttribute("page", "../index.jsp");
		} catch (Exception e) {
			request.setAttribute("info", e.getStackTrace());
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("../pages/result.jsp");
			rd.forward(request, response);			
		}
	}
}
