<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>
	<h1>${param.username }登录成功！</h1><br>
	<%--= request.getAttribute("name") --%>
	
	<s:property value="result"/>
	<p>本站访问次数：${application.counter }</p>
	<p>用户名：${session.username }</p>
	<p>登录信息：${request.info }</p>
</body>
</html>