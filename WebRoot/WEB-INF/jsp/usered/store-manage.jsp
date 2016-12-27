
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
</script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/managerSubmit.action" method="post">
		<h1 align="center"><b>商城管理</b></h1><h4><a onclick="doAction()" style="color: blue;">返回</a></h4>
		<hr>
		<table width="100%">
			<tr><td></td><td>商品名称</td><td>&nbsp;&nbsp;&nbsp;商品数量</td><td></td><td>&nbsp;&nbsp;&nbsp;商品价格</td><td></td><td align="center">商品信息</td></tr>
				<tr><td>添加:</td><td><input type="text" name="itemname"></td><td><input type="text" name="num" onkeyup="this.value=this.value.replace(/\D/g,'')" 
				onafterpaste="this.value=this.value.replace(/\D/g,'')"></td><td></td><td><input type="text" name="price" onkeyup="this.value=this.value.replace(/\D/g,'')" 
				onafterpaste="this.value=this.value.replace(/\D/g,'')"></td><td></td><td><input type="text" name="info"></td></tr>
				<tr height="8"></tr>
		<c:forEach items="${itemToStore}" var="list" >
			<tr><td></td><td>${list.itemname}</td>
				<td ><input type="text"  name="itemnum${list.id}" value="${list.num}" onkeyup="this.value=this.value.replace(/\D/g,'')" 
				onafterpaste="this.value=this.value.replace(/\D/g,'')"></td><td>台</td>
				<td ><input type="text" name="itemprice${list.id}"  value="${list.price}" onkeyup="this.value=this.value.replace(/\D/g,'')" 
				onafterpaste="this.value=this.value.replace(/\D/g,'')"></td><td>元</td>
				<td ><input type="text" name="iteminfo${list.id}"  value="${list.info}"></td></tr>	
		</c:forEach>
		</table><input type="hidden" name="name" value="${name}"> 
			<br><div align="right"><button type="submit" >确认修改</button></div>
	</form>
</body>
</html>