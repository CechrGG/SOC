<%@ page import="jspfun.JspClassTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入jar包 -->
<%@ page import="java.text.*,java.util.*,java.awt.*,java.awt.image.*,java.io.*,javax.imageio.*" %>
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
	
	<%
		//字符串数组
		String names[] = {"gg", "cr", "st"};
		pageContext.setAttribute("names", names);
		//字符串链表
		LinkedList<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("Jsp");
		list.add("javascript");
		pageContext.setAttribute("list", list);
		//游标
		pageContext.setAttribute("iterator", list.iterator());
		//动态数组
		Vector<String> vector = new Vector<String>();
		vector.addAll(list);
		//Enumeration
		pageContext.setAttribute("enume", vector.elements());
		//哈希表
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("gg", "best");
		map.put("qq", "best2");
		map.put("ot", "soso");
		pageContext.setAttribute("keySet", map.keySet());
		pageContext.setAttribute("entrySet", map.entrySet());
				
	%>
	<c:forEach var="n" items="${names }">${n };</c:forEach><br>
	<c:forEach begin="1" end="2" varStatus="i" var="ns" items="${names }">
		names[${i.index }] = ${ns };
	</c:forEach><br>
	<c:forEach varStatus="i" var="l" items="${list }">list.get(${i.index }) = ${l };</c:forEach><br>
	<c:forEach varStatus="i" var="it" items="${iterator }">list.get(${i.index }) = ${it };</c:forEach><br>
	<c:forEach var="key" items="${keySet }">${key };</c:forEach><br>
	<c:forEach var="entry" items="${entrySet }">${entry.key } = ${entry.value };</c:forEach><br>
	<c:forTokens var="c" items="gg#qq#ot" delims="#">${c };</c:forTokens>
	<c:forEach var="s" items="${enume }">${s };</c:forEach><hr>
</body>
</html>