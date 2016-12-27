<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>找回密码</h2>
	<form action="${pageContext.request.contextPath}/changePswServer.action">
		请输入您的账号:&nbsp;<input type="text" name="chanPsw-username"><br/><br>
		请输入您的姓名:&nbsp;<input type="text" name="chanPsw-name"><br/><br>
		请输入您的注册电话号码:&nbsp;<input type="text" name="chanPsw-phonenum" 
		onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"><br/><br>
		<button type="submit" class="submit_button">&nbsp;&nbsp;提交&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/main.action">返回</a>
	</form>
</body>
</html>