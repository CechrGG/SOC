package login;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateCode
 */
@WebServlet("/ValidateCode")
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//验证码字符集，系统将从中选择一些字符作为验证码
	private static String codeChars = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
	
	//获取一个随机颜色
	private static Color getRandomColor(int minColor, int maxColor) {
		Random random = new Random();
		if(minColor > 255) {
			minColor = 255;
		}
		if(maxColor > 255) {
			maxColor = 255;
		}
		int red = minColor + random.nextInt(maxColor - minColor);
		int green = minColor + random.nextInt(maxColor - minColor);
		int blue = minColor + random.nextInt(maxColor - minColor);
		return new Color(red, green, blue);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int charsLength = codeChars.length();
		//关闭浏览器缓冲区
		response.setHeader("ragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//验证码图片
		int width = 90, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.getGraphics();
		graphics.setColor(getRandomColor(180, 250));//BGC
		graphics.fillRect(0, 0, width, height);
		graphics.setFont(new Font("Times New Roman", Font.ITALIC, height));//Font
		graphics.setColor(getRandomColor(180, 250));//Font Color
		StringBuilder validateCode = new StringBuilder();
		String[] fontNames = {"Times New Roman", "Book antiqua", "Arial"};//验证码字体集合
		Random random = new Random();
		//绘制干扰线
		graphics.setColor(getRandomColor(120,200));
		for(int i = 0; i < 20; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(5) + 1;
			int y1 = random.nextInt(10) + 1;
			
			graphics.drawLine(x, y, x+x1+30, y+y1+10);		
		}
		//绘制验证码
		for(int i = 0; i < 3 + random.nextInt(3); i++) {
			graphics.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height));
			char codeChar = codeChars.charAt(random.nextInt(charsLength));
			validateCode.append(codeChar);
			graphics.setColor(getRandomColor(10, 100));
			graphics.drawString(String.valueOf(codeChar), 16*i + random.nextInt(7), height - random.nextInt(6));
		}

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5 * 60);
		session.setAttribute("validateCode", validateCode.toString());
		graphics.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

}
