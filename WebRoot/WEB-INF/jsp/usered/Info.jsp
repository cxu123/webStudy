
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User-Information</title>
<script type="text/javascript">
	function doAction() {
		window.history.go(-1);
	}
</script>

</head>

<body>
		<h2 align="center"><b>用户信息</b></h2><h4 style="color:blue;"><a onclick="doAction()"><b>返回</b></a></h4>
		<hr>
		<table width="25%" >
				<tr>
					<td>用户名:&nbsp;</td>
					<td>${userToShowInfo.username}</td>
				</tr>
				<tr>
					<td>姓名:&nbsp;</td>
					<td>${userToShowInfo.name}</td>
				</tr>
				<tr>
					<td>年龄 :&nbsp;</td>
					<td>${userToShowInfo.age}</td>
				</tr>
				<tr>
					<td>性别 :&nbsp;</td>
					<td>${userToShowInfo.sex}</td>
				</tr>
				<tr>
					<td>地址 :&nbsp;</td>
					<td>${userToShowInfo.address}</td>
				</tr>
				<tr>
					<td>电话号码 :&nbsp;</td>
					<td>${userToShowInfo.phonenum}</td>
				</tr>
		</table>
</body>
</html>