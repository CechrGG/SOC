<%@ page import="jspfun.JspClassTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	Unix时间戳：${time.time }<br><hr>
	<jsp:useBean id="jspClass" class="jspfun.JspClassTest" />
	<!-- 直接赋值 -->
	<jsp:setProperty property="id" name="jspClass" value="0"/>
	<jsp:setProperty property="name" name="jspClass" value="Guo"/>
	<jsp:setProperty property="desc" name="jspClass" value="wo"/>
	<!-- URL赋值 -->
	<jsp:setProperty property="id" name="jspClass"/>
	<jsp:setProperty property="name" name="jspClass"/>
	<jsp:setProperty property="desc" name="jspClass"/>
	<%
		long id = ((JspClassTest)pageContext.getAttribute("jspClass")).getId();
		String name = ((JspClassTest)pageContext.getAttribute("jspClass")).getName();
		String desc = ((JspClassTest)pageContext.getAttribute("jspClass")).getDesc();
		out.println(id + "#" + name + "#" + desc);
	%><br>
	id:<jsp:getProperty property="id" name="jspClass"/><br>
	<c:set var="str" value="爱咋滴<咋滴" scope="request" />
	string:<c:out value="${str }"/><hr>
	<c:if test="true">Yeah</c:if>
	<c:set var="time" value="<%=Calendar.getInstance().get(Calendar.HOUR_OF_DAY) %>"/>
	<h3><c:if test="${time < 12 }">Good Morning</c:if>
	<c:if test="${time > 12 }">Good Afternoon</c:if></h3><br>
	<c:choose>
		<c:when test="${param.name == \"gg\" }"><h4>GG Best</h4></c:when>
		<c:when test="${param.name == \"qq\" }"><h4>QQ Best 2</h4></c:when>
		<c:otherwise><h4>WTF</h4></c:otherwise>
	</c:choose>
</body>
</html>