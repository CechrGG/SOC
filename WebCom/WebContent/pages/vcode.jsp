<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.text.*,java.util.*,java.awt.*,java.awt.image.*,java.io.*,javax.imageio.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String code = "";
		int intCount = 0;
		intCount = (new Random()).nextInt(9999);
		if(intCount < 1000) {
			intCount += 1000;
		}
		code = code + intCount;
		session.setAttribute("validateCode", code);
		response.setContentType("image/gif");
		BufferedImage image = new BufferedImage(35, 14, BufferedImage.TYPE_INT_RGB);
		Graphics graph = image.getGraphics();
		graph.setColor(Color.yellow);
		graph.fillRect(1, 1, 33, 12);
		graph.setColor(Color.black);
		graph.setFont(new Font("宋体", Font.PLAIN, 12));
		char c;
		for(int i = 0; i < 4; i++) {
			c = code.charAt(i);
			graph.drawString(c + "", i*7 + 4, 11);
		}
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "JPG", os);
		out.clear();
		out = pageContext.pushBody();
	%>
</body>
</html>