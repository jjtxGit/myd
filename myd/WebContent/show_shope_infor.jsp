<%@page language="java" contentType="text/html; charset=utf-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>


</head>
<body>

	<center>
		<font color="blue" style="font-size: 20px">店铺信息</font>
	</center>

	<div class="formbody">

		<form action="/myd/shopeServlet.action?optype=addShope1" method="post">

			<ul class="forminfo">

				<li><label>店铺名<b>*</b></label><input type="text"
					class="dfinput" value="${shope.name }" /></li>

				<li><label>电话号码<b>*</b></label><input type="text"
					class="dfinput" value="${shope.pnum }" /></li>

				<li><label>邮箱地址<b>*</b></label><input type="email"
					class="dfinput" value="${shope.mail }" /></li>

				<li><label>地址<b>*</b></label> <textarea class="textinput"> ${shope.adress } </textarea></li>


				<li><input type="button" class="btn"
					onclick="location.href='/myd/shopeServlet.action?optype=updateShopeInfor1&id=${shope.id}'"
					value="修改信息" /> <input type="button" class="btn" value="返回"
					onclick=" location.href= '/myd/shopeServlet.action?optype=loginShope&name= + ${shope.name }'" /></li>

			</ul>
		</form>
	</div>
</body>

</html>