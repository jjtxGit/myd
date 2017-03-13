<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script language="javascript">
	$(function() {
		$(".imglist li").click(function() {
			$(".imglist li.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>


<style type="text/css">
.wrap a {
	display: block;
	width: 220px;
	height: 330px;
	text-decoration: none;
	color: #000;
}

.wrap {
	width: 220px;
	height: 330px;
	position: relative;
	overflow: hidden;
	font-family: arial, sans-serif;
	border: 0;
	margin: 0 10px;
	float: left;
	display: inline;
}

.wrap img {
	border: 0;
}

.wrap i {
	display: block;
	width: 220px;
	height: 330px;
	position: absolute;
	left: 0;
	top: 300px;
	z-index: 1;
	background: #000;
	filter: alpha(opacity = 40);
	filter: progid:DXImageTransform.Microsoft.Alpha(opacity=40);
	opacity: 0.40;
	-webkit-transition: all 0.6s ease-in-out;
}

.wrap p {
	display: block;
	width: 220px;
	height: 330px;
	position: absolute;
	left: 0;
	top: 300px;
	z-index: 1;
	background: transparent;
	font-size: 12px;
	color: #fff;
	padding: 0;
	margin: 0;
	line-height: 16px;
	-webkit-transition: all 0.6s ease-in-out;
}

.wrap p b {
	display: block;
	font-size: 22px;
	color: #fc0;
	text-align: center;
	margin: 0;
	padding: 0;
	line-height: 30px;
}

.wrap p span {
	display: block;
	padding: 10px;
	line-height: 20px;
}

.wrap a:hover {
	direction: ltr;
}

.wrap a:hover i {
	top: 0;
}

.wrap a:hover p {
	top: 0;
}

.clear {
	clear: left;
}
</style>




<script type="text/javascript">
	
	function addToCart(foodid)
	{
		$.post("/myd/vipServlet.action?optype=addToCart",{foodid:foodid},function(date){
				if(date =="false"){
					alert("亲，你还没有登陆哦");
				}else{
					alert("在购物车里等你哦");
				}
		});
	}
	

</script>

</head>

<body>
	<br />
	<br />
	<center>
		<span> <font style="font-size: 20px" color="green">尊敬的会员
				<a style="font-size: 24px;" href="/myd/vipServlet.action?optype=vip"
				target="top"> <%
 	Object obj = session.getAttribute("Vipname");
 	if (obj != null) {
 		out.print(obj);
 	}
 %>
			</a>欢迎登陆美易点点餐系统
		</font>
		</span>
	</center>
	<br />
	<br />


	<div class="rightinfo">

		<ul class="classlist">

			<c:forEach items="${foodInfors }" var="foodinfor">

				<li>
					<div class="wrap">

						<a
							href="/myd/foodServlet.action?optype=showFoodComment&foodId=${foodinfor.food.id }"
							target="top"> <img
							src='/myd/imgServlet.action?imgpath=${foodinfor.food.picPath }'
							width="200" height="250" /> <i></i>
							<p>
								<b>食品描述</b> <span>${foodinfor.food.des }</span>
							</p>
						</a>
					</div>
					<div class="lright">
						<h2>食品信息</h2>
						<p>
							食品名称：${foodinfor.food.name }<br />${foodinfor.shope.shopName }<br />价格:<font
								color='red'>￥${foodinfor.food.price }</font><br />类别
							<c:choose>
								<c:when test="${foodinfor.food.type eq 1}">种类1</c:when>
								<c:when test="${foodinfor.food.type eq 0}">种类0</c:when>
								<c:when test="${foodinfor.food.type eq 6}">种类6</c:when>
								<c:when test="${foodinfor.food.type eq 2}">种类2</c:when>
								<c:when test="${foodinfor.food.type eq 3}">种类3</c:when>
								<c:when test="${foodinfor.food.type eq 4}">种类4</c:when>
								<c:when test="${foodinfor.food.type eq 5}">种类5</c:when>
							</c:choose>
						</p>

						好评&nbsp;&nbsp;<font color="red">${foodinfor.goodLevel }</font><br />
						中评&nbsp;&nbsp;<font color="red">${foodinfor.badLevel }</font><br />
						差评&nbsp;&nbsp;<font color="red">${foodinfor.normal }</font><br />
						<a class="enter" onclick="addToCart(${foodinfor.food.id })">加入购物车</a>
						<a class="enter"
							href="/myd/vipServlet.action?optype=buyItNow&foodId=${foodinfor.food.id  }" target="view_window">直接购买</a>

					</div>
				</li>
			</c:forEach>

		</ul>

	</div>


</body>

</html>
