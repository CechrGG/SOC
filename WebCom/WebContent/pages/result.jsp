<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果页面</title>
</head>
<body>
	<form action="${requestScope.page }" name="form" method="post"></form>
	<c:if test="${requestScope.info != null}">
		<script type="text/javascript">
			alert("${requestScope.info}");
			form.submit();
		</script>
	</c:if>
	
</body>
</html>