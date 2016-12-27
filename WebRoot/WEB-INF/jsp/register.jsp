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
	<h2>用户注册</h2>
	<form name="form2" action="${pageContext.request.contextPath}/registerServer.action" method="post">
		注册账号:&nbsp;&nbsp;<input type="text" name="username" ><br><br>
		注册密码:&nbsp;&nbsp;<input type="password" name="password" ><br><br>
		确认密码:&nbsp;&nbsp;<input type="password" name="register-password" ><br/><br>
		电话号码:&nbsp;&nbsp;<input type="text" name="phonenum" 
		onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"><br/><br>
		姓&nbsp;&nbsp;名:&nbsp;&nbsp;<input type="text" name="name" ><br/><br>
		年&nbsp;&nbsp;龄:&nbsp;&nbsp;<input type="text" name="age"  
		onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"><br/><br>
		性&nbsp;&nbsp;别:&nbsp;&nbsp;<input type="text" name="sex" ><br/><br>
		家庭地址:&nbsp;&nbsp;<input type="text" name="address" ><br/><br>
		<button type="submit" class="submit_button">&nbsp;&nbsp;注册&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/main.action">返回</a>
	</form>
</body>
</html>