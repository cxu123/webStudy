<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function doAction() {
		window.history.go(-1);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>wrong</title>
</head>
<body>
	<h3>${WrongInfo}</h3><br><h3><a style="color: blue;" onclick="doAction()">确定</a></h3>
</body>
</html>