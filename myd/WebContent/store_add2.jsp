<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>

<script type="text/javascript">
	function verifyFile(obj) {

		var fileName = $("#name").val();
		var length = fileName.length;

		if (fileName.charAt(length - 3) == 'j'
				&& fileName.charAt(length - 2) == 'p'
				&& fileName.charAt(length - 1) == 'g') {
			obj.type = "submit";
			return true;
		} else {
			aler("您选择的不是 jpg 文件 请重新选择");
			return false;
		}

	}
</script>
</head>
<body>

	<br />
	<br />
	<br />
	<br />

	<center>

		<font color="blue" style="font-size: 20px">选择店铺logo</font>

		<form action="/myd/shopeServlet.action?optype=addShope2"
			enctype="multipart/form-data" method="post">

			<ul class="forminfo">

				<li><input type="hidden" name="mail" value="${param.mail }" /></li>

				<li><br /> <br /> <br /></li>

				<li><input name="name" id="name" type="file"
					style="width: auto;" /></li>
				<li><br /> <br /> <br /></li>

				<li><input type="button" onclick="verifyFile(this)" class="btn"
					value="下一步" /></li>
			</ul>
		</form>
	</center>
</body>

</html>
