<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<style>
body
{
	margin:0px auto;
	/*background-color:Khaki;*/
}
input
{
	width:300px;
}
div
{
	margin:0px auto;
	/*background-color:pink;*/
	margin-top:128px;
	width:512px;
	height:256px;
}
table
{
	margin:0px auto;
	padding-top:32px;
}
</style>
<script type="text/javascript">
	function checkLogin()
	{
		var userName = document.getElementById("userName");
		if("" == userName.value) {
			alert("用户名不能为空，请重新输入！");
			userName.focus();
			return;
		} else {
			var pattern = /^[A-Za-z\u4e00-\u9fa5]([\w\u4e00-\u9fa5]){0,63}$/
			var flag = pattern.test(userName.value);
			if(!flag) {
				alert("用户名格式不正确，请重新输入！");
				userName.focus();
				return;
			}
		}
		var password = document.getElementById("password");
		if("" == password.value) {
			alert("密码不能为空，请重新输入！");
			password.focus();
			return;
		} else {
			var pattern = /^[\w]{8,64}$/
			var flag = pattern.test(password.value);
			if(!flag) {
				alert("密码格式不正确，请重新输入！");
				password.focus();
				return;
			}
		}
		var validateCode = document.getElementById("validateCode");
		if("" == validateCode.value) {
			alert("验证码为空，请重新输入");
			validateCode.focus();
			return;
		}
		loginForm.submit();
	}
	function refresh() {
		var img = document.getElementById("img_validateCode");
		img.src = "../login/validatecode?" + Math.random();
	}
</script>
<body>
<div>
	<form name="loginForm" action="../login/login" method="post" >
		<table> 
			<tr>
				<td align="right">用户名：</td>
				<td align="left"><input type="text" id="userName" name="userName" placeholder="1-64位字母、数字、汉字或_，不能以数字或_开头" size="64" maxLength="64"/></td>
			</tr>
			<tr>
				<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td align="left"><input type="password" id="password" name="password" placeholder="8-64位字母、数字或符号，必须以字母开头" size="64" maxLength="64"/></td>
			</tr>
			<tr>
				<td align="right">验证码：</td>
				<td align="left"><input style="width:128px;" type="text" id="validateCode" name="validateCode" size="12" maxLength="12"/>
				<img alt="验证码" src="../login/validatecode" id="img_validateCode" onclick="refresh()" style="width:90px;height:20px;display:inline-block;margin-bottom:2px;vertical-align:middle;"/></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input style="width:64px;" type="button" value="登录" onclick="checkLogin()"/>
					<label style="font:italic 12px serif">还没有用户名？</label>
					<input style="width:64px;" type="submit" value="注册" name="register" />					 
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>