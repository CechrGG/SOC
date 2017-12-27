<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
	function checkRegister()
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
		var rePassword = document.getElementById("repassword");
		if(password.value != rePassword.value) {
			alert("密码不一致，请重新输入！");
			rePassword.focus();
			return;
		}
		var email = document.getElementById("email");
		if("" != email.value) {
			var pattern = /^([\w])+@([\w])+(\.[\w]+)+$/;
			var flag = pattern.test(email.value);
			if(!flag) {
				alert("email格式不正确，请重新输入！");
				email.focus();
				return;
			}
		}
		var phone = document.getElementById("mobilePhone");
		if("" != phone.value) {
			var pattern = /^1([0-9]){10}$/
			var flag = pattern.test(phone.value);
			if(!flag){
				alert("手机号码有误，请重新输入！");
				phone.focus();
				return;
			}
		}
		var validateCode = document.getElementById("validateCode");
		if("" == validateCode.value) {
			alert("验证码为空，请重新输入");
			validateCode.focus();
			return;
		}
		registerForm.submit();
	}
	function refresh() {
		var img = document.getElementById("img_validateCode");
		img.src = "../login/validatecode?" + Math.random();
	}
</script>
<body>
<div>
	<form name="registerForm" action="../login/register" method="post" >
		<table> 
			<tr>
				<td align="right"><span style="color:red">*</span> 用户名：</td>
				<td align="left"><input type="text" id="userName" name="userName" placeholder="1-64位字母、数字、汉字或_，不能以数字或_开头" size="64" maxLength="64"/></td>
				<!-- td><input type="text" name="userNameLabel" value="(1-64位字母、数字或'_',必须以字母开头)" size="40" disabled/></td> -->
			</tr>
			<tr>
				<td align="right"><span style="color:red">*</span>登录密码：</td>
				<td align="left"><input type="password" id="password" name="password" placeholder="8-64位字母、数字或符号，必须以字母开头" style="margin-right:0px" size="64" maxLength="64"/></td>
				<!-- td><input type="text" name="passwordLabel" value="(8-64位字母、数字或_)" size="40" disabled/></td-->
			</tr>
			<tr>
				<td align="right"><span style="color:red">*</span>确认密码：</td>
				<td align="left"><input type="password" id="repassword" name="repassword" size="64" maxLength="64"/></td>
			</tr>
			<tr>
				<td align="right">邮箱地址：</td>
				<td align="left"><input type="text" id="email" name="email" size="64" maxLength="64"/></td>
			</tr>
			<tr>
				<td align="right">手机号码：</td>
				<td align="left"><input type="text" id="mobilePhone" name="mobilePhone" placeholder="请输入11位电话号码" size="20" maxLength="20"/></td>
			</tr>
			<tr>
				<td align="right"><span style="color:red">*</span> 验证码：</td>
				<td align="left"><input style="width:128px;" type="text" id="validateCode" name="validateCode" size="12" maxLength="12"/>
				<img alt="验证码" src="../login/validatecode" id="img_validateCode" onclick="refresh()" style="width:90px;height:20px;display:inline-block;margin-bottom:2px;vertical-align:middle;"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input style="width:64px;" type="button" value="注册" onclick="checkRegister()"/></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>