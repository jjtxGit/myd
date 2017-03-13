<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/myd/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	function bt() {
		location.href = "/myd/main.html";
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<center>

		<font style="font-size: 20px" color="blue">${param.result==true?"恭喜你，注册成功点击下一步开始点餐吧":"您的用户名已经存在，请重新注册" }</font><br>
		<br> <br> <br> <input type="button" class="btn"
			value="下一步" onclick="bt(this)" />
	</center>
</body>
</html>