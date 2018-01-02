<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常</title>
</head>
<body>
	<h1>异常消息</h1>
	<p><font color="red"><s:property value="exception.message"/></font></p>
	<h1>异常栈消息</h1>
	<s:property value="exceptionStack"/>
</body>
</html>