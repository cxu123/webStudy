
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login-Logs</title>
<script type="text/javascript">
	function doAction() {
		window.history.go(-1);
	}
</script>

</head>

<body>
		<h2 align="center"><b>已购商品</b></h2><h4 style="color:blue;"><a onclick="doAction()"><b>返回</b></a></h4>
		<hr>
		<table width="50%" >
			<tr><td><h3>用户名:&nbsp;&nbsp;${userToShowname}</h3></td><td></td><td></td><td></td></tr>
			<c:forEach items="${userToShowOwned}" var="list" >

				<tr><td></td>
					<td>商品名:&nbsp;&nbsp;${list.item}</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>数量:&nbsp;&nbsp;${list.itemnum}台</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>