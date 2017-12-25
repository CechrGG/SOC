<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form name="registerForm" action="login/register" method="post" >
		<table align="center"> 
			<tr align="center">
				<td><span class="require">*</span>用户名：</td>
				<td><input type="text" id="userName" name="userName" size="64" maxLength="64"/></td>
				<td><input type="text" name="userNameLabel" value="(1-64位字母、数字或'_',必须以字母开头)"/></td>
			</tr>
			<tr align="center">
				<td><span class="require">*</span>密码：</td>
				<td><input type="password" id="password" name="password" size="64" maxLength="64"></td>
				<td><input type="text" name="passwordLabel" value="(8-64位字母、数字或符号，必须以字母开头)"/></td>
			</tr>
		</table>
	</form>

</body>
</html>