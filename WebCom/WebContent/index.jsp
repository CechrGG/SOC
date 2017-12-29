<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<script type="text/javascript">
function login() {
	userForm.action = "./test/login.action"
	userForm.submit();
}
function register() {
	userForm.action = "./test/register.action";
	userForm.submit();
}
</script>
<body>
	<h3 align="center">CECHR-SOC</h3>
	<s:form name="userForm">
	<table align="center" style="text-align:center">
		<tr><td><s:textfield label="username" name="username" /></td></tr>
		<tr><td><s:textfield label="password" name="password" /></td></tr>
		<tr><td><s:submit value="login" onclick="login()"></s:submit>
		<s:submit value="register" onclick="register()"></s:submit></td></tr>
	</table>
	</s:form>

</body>
</html>