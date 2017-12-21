<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入jar包 -->
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JspTest</title>
</head>
<body>
<%//response.setHeader("refresh", "1");
%>
	<p align="center">#服务器当前时间#</p>
	<p align="center"><font color="red">
		<%
			//格式化时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(format.format(new Date()));
		%>
	</font></p><hr>
	<form action="">
		<table align="center">
			<tr align="center"><td>name:</td><td><input type="text" name="name" ></td></tr>
			<tr align="center"><td>password:</td><td><input type="password" name="password" ></td></tr>
			<tr align="center"><td colspan="2"><input type="submit" value="submit"></td></tr>
		</table>
	</form>
	
	&emsp;&emsp;name:${param.name }<br>
	password:${param.password }<br>
	<jsp:useBean id="time" class="java.util.Date" scope="request" />
	Unix时间戳：${time.time }<br>
</body>
</html>