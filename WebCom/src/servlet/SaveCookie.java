package servlet;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveCookie
 */
@WebServlet("/SaveCookie")
public class SaveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//临时Cookie
		Cookie tempCookie = new Cookie("temp", "123456");
		response.addCookie(tempCookie);
		//及时删除Cookie
		Cookie onceCookie = new Cookie("once", "666");
		onceCookie.setMaxAge(0);
		response.addCookie(onceCookie);
		//永久Cookie
		String username = request.getParameter("username");
		if(null != username) {
			Cookie userCookie = new Cookie("username", username);
			userCookie.setMaxAge(7*24*60*60);
			userCookie.setPath("/");
			response.addCookie(userCookie);
		}
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3*60);
		if(session.isNew()) {
			session.setAttribute("session", "GG");
			out.println("新会话已经建立");
		} else {
			out.println("会话属性session值为" + session.getAttribute("session"));
		}
		
		
		//转发到ReadCookie
//		RequestDispatcher readCookie = this.getServletContext().getRequestDispatcher("/servlet/readcookie");
//		readCookie.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
