package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgServlet
 */
@WebServlet("/ImgServlet")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	response.setContentType("image/jpeg");
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[8192];
			String imageName = request.getParameter("name");
			String path = this.getServletContext().getRealPath(imageName);
			FileInputStream fileIS = new FileInputStream(path);
			int count = 0;
			while(true) {
				count = fileIS.read(buffer);
				if(count <= 0) {
					break;
				}
				os.write(buffer, 0, count);
			}
			fileIS.close();
			
//			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.html");
//			rd.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
		}
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
