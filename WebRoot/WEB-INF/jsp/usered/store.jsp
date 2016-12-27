
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>STORE</title>
<script type="text/javascript">
	function doAction() {
		window.history.go(-1);
	}
	function doAction2() {
		window.history.go(-3);
	}
	function doAction3(){
	
	}
</script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/itemSubmit.action" method="post">
		<h5 align="right"><input type="hidden" name="name"><a href="${pageContext.request.contextPath}/toManageItem.action?name=${userToStore.username}">商城管理</a></h5>
		<h1 align="center"><b>商城</b></h1><h4><a style="color: blue;" onclick="${back}">返回首页</a></h4>
		<hr>
		<h3>您的可用余额为:&nbsp;${userToStore.balance}元</h3>
		<table width="100%">
			<tr><td>商品名称</td><td>&nbsp;&nbsp;&nbsp;商品数量</td><td></td><td>&nbsp;&nbsp;&nbsp;商品价格</td><td></td><td align="center">商品信息</td><td>购买数量</td></tr>
		<c:forEach items="${itemToStore}" var="list" >
			<tr><td>${list.itemname}</td>
				<td >&nbsp;&nbsp;&nbsp;${list.num}</td><td>台</td>
				<td >&nbsp;&nbsp;&nbsp;${list.price}</td><td>元</td>
				<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${list.info}</td><td ><input size="5" type="text" id="num${list.id}" name="item${list.id}"  
				onkeyup="this.value=this.value.replace(/\D/g,'')" 
				onafterpaste="this.value=this.value.replace(/\D/g,'')"></td></tr>	
		</c:forEach>
		</table><input type="hidden" name="itemuser" value="${userToStore.username}"> 
			<br><div align="right"><button type="submit" >确认购买</button></div>
	</form>
</body>
</html>