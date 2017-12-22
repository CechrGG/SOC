<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/jspfun.tld" prefix="jsptest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jsp Function</title>
</head>
<body>
	<form method="post">
		<input type="text" name="text"><br>
		<input type="submit" value="submit"><br>
	</form>
	<p>文本框中的内容:${param.text }</p>
	<p>转换之后为：${jsptest:ps(param.text) }</p>
	<script type="text/javascript">
		document.write("Hello!!");
		<%
		out.println(page.getClass().getName());
		%>
	</script>
	<br>
	<%=config.getServletName() %><br>
	<%=config.getInitParameter("jsparg") %>
	
</body>
</html>