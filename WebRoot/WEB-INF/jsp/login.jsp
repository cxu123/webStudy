<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login-page</title>
</head>
<body>
	<h1>登入</h1>
	<form action="${pageContext.request.contextPath}/login.action">
		<h3>账号:<input type="text" name="username" >&nbsp;<a href="${pageContext.request.contextPath}/register.action">注册</a></h3>
		<h3>密码:<input type="password" name="password" >&nbsp;<a href="${pageContext.request.contextPath}/changePsw.action">忘记密码？</a></h3>
		<button type="submit" class="submit_button">登录</button>
	</form>
</body>
</html>