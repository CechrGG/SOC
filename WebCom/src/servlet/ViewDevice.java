package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ViewDevice
 */
@WebServlet("/ViewDevice")
public class ViewDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDevice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/websoc");
			Connection conn = ds.getConnection();
			String sql = "select * from t_device";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			StringBuilder table = new StringBuilder();
			table.append("<table border='2'>");
			table.append("<tr><th>设备id</th><th>设备名</th><th>设备类别</th></tr>");
			while(rs.next()) {
				table.append("<tr><td>" + rs.getLong(1) + "</td><td>" + 
							rs.getString(2) + "</td><td>" + rs.getInt(3) + 
							"</td></tr>");
			}
			table.append("</table>");
			out.println(table.toString());
			pstmt.close();
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.println("<h3>I'm Post</h3>");
	}

}
