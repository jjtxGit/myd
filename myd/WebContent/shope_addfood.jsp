<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
	function bt(obj) {
		obj.type = "submit";

	}
</script>


</head>
<body>
	<center>
		<font color="blue" style="font-size: 20px">店铺${param.shopename }&nbsp;添加菜品</font>
	</center>

	<div class="formbody">

		<form action="/myd/foodServlet.action?optype=addFood"
			enctype="multipart/form-data" method="post">

			<ul class="forminfo">

				<li><input type="hidden" name="shopeid"
					value="${param.shopeid }" /></li>


				<li><label>食品名<b>*</b></label> <input name="foodname"
					id="foodname" type="text" class="dfinput" /></li>


				<li><label>食品价格<b>*</b></label><input name="foodprice"
					id="foodprice" class="dfinput" /></li>

				<li><label>食品类别<b>*</b></label><select name="foodtype"
					id="foodtype">

						<option value="0">--请选择--</option>
						<option value="1">类别1</option>
						<option value="2">类别2</option>
						<option value="3">类别3</option>
						<option value="4">类别4</option>
						<option value="5">类别5</option>
				</select></li>


				<li><label>描述<b>*</b></label><textarea name="des" class="textinput"></textarea></li>

				<li><label>食品图片<b>*</b></label>&nbsp; <input type="file"
					name="foodimg" id="foodimg"></li>

				<li><label>&nbsp;</label><input type="button" class="btn"
					value="确认" onclick="bt(this)" /></li>

			</ul>
		</form>

	</div>


</body>
</html>