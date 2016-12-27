<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RECHARGE</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RechargeDone.action">
<h2>充值页面</h2>
<hr><input type="hidden" name="username" value="${userToRecharge}">
	充值金额:<input type="text"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="recharge" ><button type="submit">确认</button>
</form>
</body>
</html>