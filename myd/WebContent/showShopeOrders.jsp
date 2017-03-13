<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
	KE.show({
		id : 'content7',
		cssPath : './index.css'
	});
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>

</head>
<body>


	<center>

		<br />
		<br />
		<br />
		<br /> <font color="green" style="font-size: 20px;"> <br />
		<br />
		<br />
		<br />


			<table class="tablelist">
				<thead>
					<tr>
						<th>姓名</th>
						<th>电话</th>
						<th>地址</th>
						<th>食物名</th>
						<th>查看二维码</th>
					</tr>
				</thead>
				<c:forEach items="${shopeOrders }" var="shopeOrder">

					<td>${shopeOrder.user.name }</td>
					<td>${shopeOrder.user.pnum }</td>
					<td>${shopeOrder.user.adress }</td>
					<td>${shopeOrder.food.name }</td>
					<td><a href="/myd/shopeServlet.action?optype=showcode&num=${shopeOrder.user.pnum }">点击查看</a></td>
				</c:forEach>
			</table>
	</center>



</body>
</html>