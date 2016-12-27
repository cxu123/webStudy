
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
		<h2 align="center"><b>登入日志</b></h2><h4 style="color:blue;"><a onclick="doAction()"><b>返回</b></a></h4>
		<hr>
		<table width="100%" >

			<c:forEach items="${userToShowLog}" var="list" >

				<tr>
					<td>用户名:&nbsp;&nbsp;${list.username}</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>登入时间:&nbsp;&nbsp;<fmt:formatDate value="${list.logintime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>