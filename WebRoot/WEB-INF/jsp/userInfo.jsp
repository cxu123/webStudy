<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User page</title>

</head>
<body>
		<h4 align="right"><a href="${pageContext.request.contextPath}/main.action">注销</a></h4><h1 align="center">用户界面</h1>
		<input type="hidden" name="username">
		<h2><a href="${pageContext.request.contextPath}/toStore.action?username=${loginUser.username}">&nbsp;&nbsp;商城&nbsp;&nbsp;</a></h2>
		<form action="${pageContext.request.contextPath}/toShowInfo.action"><input type="hidden" name="username" value="${loginUser.username}"><h4>用户名:&nbsp;${loginUser.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit">用户信息</button></h4></form>
		<form action="${pageContext.request.contextPath}/toShowLog.action"><input type="hidden" name="username" value="${loginUser.username}"><h4>本次登入时间:&nbsp;<fmt:formatDate value="${loginLog}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;<button type="submit" >查看登入历史</button></h4></form>
		<form action="${pageContext.request.contextPath}/toRecharge.action"><input type="hidden" name="username" value="${loginUser.username}"><h4>用户余额:&nbsp;${loginUser.balance}元&nbsp;&nbsp;<button type="submit">充值</button></h4></form>
		<form action="${pageContext.request.contextPath}/toShowOwned.action"><input type="hidden" name="username" value="${loginUser.username}"><button type="submit" >已购物品</button>&nbsp;&nbsp;&nbsp;</form>
		
	
</body>
</html>