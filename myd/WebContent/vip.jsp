<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />

<title>vip中心</title>

<script type="text/javascript">
	function buyInBulk() {
		var checkBoxs = document.getElementsByName("checkbox1");

		for (var i = 0; i < checkBoxs.length; i++) {

			if (checkBoxs[i].checked) {
				location.href = "/myd/vipServlet.action?optype=buyFromShoppingCart&id="
						+ checkBoxs[i].value;
			}

		}

	}
	/**
	 *全选
	 */
	function checkAll(obj) {
		var flage = obj.checked;
		var checkBoxs = document.getElementsByName("checkbox1");

		for (var i = 0; i < checkBoxs.length; i++) {
			checkBoxs[i].checked = flage;
		}

	}

	function confirmFood(orderid,money) {
		alert("你将支付:"+money+"元");
		location.href = '/myd/vipServlet.action?optype=confirmBill&orderid='+ orderid;
	
	}
</script>


</head>
<body>
	<br />




	<br>
	<br>
	<br>
	<br>


	<!-- -------------------------------------------------------- -->
	<center>

		<font style="font-size: 18px;" color="blue">购物车</font>

	</center>

	<table class="tablelist">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="checkAll(this)" /></th>

				<th>食物图片</th>
				<th>餐品名称</th>
				<th>店铺名</th>
				<th>描述</th>
				<th>类型</th>
				<th>价格</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${ vipPage.foodBills}" var="foodBill">
				<tr>
					<td><input name="checkbox1" type="checkbox"
						value="${foodBill.cartId }"></td>
					<td><img width="150" height="200"
						src="/myd/imgServlet.action?imgpath=${foodBill.foodImgPath }"></td>
					<td>${foodBill.foodName }</td>
					<td>${foodBill.shopeName }</td>
					<td>${foodBill.des }</td>
					<td>${foodBill.foodType }</td>
					<td>${foodBill.price }</td>
					<td>${foodBill.time }</td>
					<td><a
						href="/myd/vipServlet.action?optype=buyFromShoppingCart&id=${foodBill.cartId }">购买</a>&nbsp;<a
						href="/myd/vipServlet.action?optype=removeFromShoppingCart&id=${foodBill.cartId }">移除</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<hr>
	<!-- -------------------------------------------------------- -->


	<center>
		<br> <br> <input type="button" class="scbtn1"
			onclick="buyInBulk()" value="批量购买"> <br> <br> <br>
		<br> <font style="font-size: 18px;" color="blue">未完成订单</font> <br>
		<br> <br> <br>
	</center>

	<table class="tablelist">
		<thead>
			<tr>
				<th><input name="" type="checkbox" value="" /></th>
				<th>食物图片</th>
				<th>餐品名称</th>
				<th>店铺名</th>
				<th>描述</th>
				<th>类型</th>
				<th>价格</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${vipPage.orderFormIngs }" var="orderForm">
				<tr>
					<td><input type="checkbox"></td>
					<td><img width="150" height="200"
						src="/myd/imgServlet.action?imgpath=${orderForm.foodImgPath }"></td>
					<td>${orderForm.foodName }</td>
					<td>${orderForm.shopeName }</td>
					<td>${orderForm.des }</td>
					<td>${orderForm.foodType }</td>
					<td>${orderForm.price }</td>
					<td>${orderForm.time }</td>
					<td>&nbsp;&nbsp;<input type="button" class="scbtn"
						value="确认收货"
						onclick="confirmFood(${orderForm.cartId},${orderForm.price })"></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>
	<br>
	<br>
	<br>
	<br>

	<hr>
	<!-- -------------------------------------------------------- -->
	<center>

		<font style="font-size: 18px;" color="blue">已完成订单</font>

	</center>

	<table class="tablelist">
		<thead>
			<tr>
				<th><input name="" type="checkbox" value="" checked="checked" /></th>
				<th>食物图片</th>
				<th>餐品名称</th>
				<th>店铺名</th>
				<th>描述</th>
				<th>类型</th>
				<th>价格</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${vipPage.orderFormEds }" var="orderForm">
				<tr>
					<td><input type="checkbox"></td>
					<td><img width="150" height="200"
						src="/myd/imgServlet.action?imgpath=${orderForm.foodImgPath }"></td>
					<td>${orderForm.foodName }</td>
					<td>${orderForm.shopeName }</td>
					<td>${orderForm.des }</td>
					<td>${orderForm.foodType }</td>
					<td>${orderForm.price }</td>
					<td>${orderForm.time }</td>
					<td><input type="button" value="评论食物"
						onclick="location.href='/myd/commentFood.jsp?foodId=${orderForm.foodId }'"
						class="scbtn1">&nbsp;&nbsp;<input type="button"
						value="评论店铺" class="scbtn2"
						onclick="location.href='/myd/commentShope.jsp?shopeId=${orderForm.shopeId }'"></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>