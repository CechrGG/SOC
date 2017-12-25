package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //get conn
    private void initConnection() {
    	try {
    		if(null == conn) {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/websoc");
				conn = ds.getConnection();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter writer = response.getWriter();
		try {
			this.initConnection();
		} catch (Exception e) {
			e.printStackTrace(writer);
		}
	}
	
	/**
	 * Execute sql 
	 * @param String sql
	 * @param Object[] objects
	 * @return ResultSet
	 * 
	 */

	@SuppressWarnings("finally")
	public void execSQL(String sql, Object... objects ) {	
		PreparedStatement pstmt	= null;
		try {
			if (null == conn) {
				this.initConnection();
			}
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < objects.length; i++) {
				pstmt.setObject(i + 1, objects[i]);
			}
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("finally")
	public ResultSet execQuery(String sql) {
		ResultSet rs = null;	
		PreparedStatement pstmt	= null;
		try {
			if (null == conn) {
				this.initConnection();
			}
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rs;
		}
	}
	
	/**
	 * @校验验证码
	 * @param HttpServletRequest request
	 * @param String validateCode
	 * @return boolean return false if it's illegal else true
	 */
	public boolean checkValidateCode(HttpServletRequest request, String validateCode) {
		boolean isLegal = false;
		//从session中获取系统随机生成的验证码
		String validateCodeSession = (String)request.getSession().getAttribute("validateCode");
		if(null == validateCodeSession) {
			request.setAttribute("info", "验证码过期，请刷新页面");
			request.setAttribute("codeError", "验证码过期");
		} else if (!validateCode.equalsIgnoreCase(validateCodeSession)){
			request.setAttribute("info", "验证码不正确，请重新输入");
			request.setAttribute("codeError", "验证码不正确");
		} else {
			isLegal = true;
		}
		
		return isLegal;
	}
}
