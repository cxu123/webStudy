<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>修改密码</h2>
	<form action="${pageContext.request.contextPath}/changePswCServer.action">
		<input type="hidden" name="username" value="${cpsUsername}">
		请输入新密码:&nbsp;<input type="password" name="chanPsw-password" ><br/><br>
		请再次输入:&nbsp;<input type="password" name="chanPsw-password1" 
		onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"><br/><br>
		<button type="submit" class="submit_button">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/changePsw.action">返回</a>
	</form>
</body>
</html>