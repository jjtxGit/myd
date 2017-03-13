<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

	function shopeAddFood(shopeid,shopename) {
		location.href="/myd/shope_addfood.jsp?shopeId="+shopeid+"&shopename="+shopename;
	}
	
	function closeShope(opened){
		
		location.href="/myd/shopeServlet.action?optype=changeOpened&opened="+opened+"&name=${shopePage.name }";		
	
	}
	
	
	function showBill(shopeid){
		location.href="/myd/shopeServlet.action?optype=showBill&shopeid="+shopeid;
	}
	
	
</script>




<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品中心</title>
</head>
<body>
	<br />
	<br />
	<br />

	<center>

		<font style="font-size: 20px;" color="blue">亲爱的店铺&nbsp;<a
			style="font-size: 20px;"
			href="/myd/shopeServlet.action?optype=showShopeInfor&shopeId=${shopePage.id }">${shopePage.shopName }</a>&nbsp;店长你好，欢迎！
		</font> 
		<br>
		<br>
		
		<font style="font-size: 20px;" color="green">当前营业状态为&nbsp; </font>
		<font style="font-size: 15px;" color="blue"> 
		<c:choose>
				<c:when test="${shopePage.opened eq 1}">正常营业</c:when>
				<c:when test="${shopePage.opened eq 2}">打烊</c:when>
				<c:when test="${shopePage.opened eq 3}">休息</c:when>
				<c:when test="${shopePage.opened eq 4}">暂停营业</c:when>
				<c:when test="${shopePage.opened eq 5}">停止营业</c:when>
			</c:choose>
		</font> 
	
	
		
		<br>
		<br> 
		
		<input type="button" class="scbtn" onclick="closeShope(2)" value="打烊" /> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<input type="button" class="scbtn" onclick="closeShope(3)" value="休息" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		
		<input type="button" class="scbtn2" onclick="closeShope(4)" value="暂停营业" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		
		<input type="button" class="scbtn" onclick="closeShope(1)" value="正常营业" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<br /> <br />
			
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input type="button" class="scbtn1" onclick="shopeAddFood(${shopePage.id},'${shopePage.shopName}' )" value="增加食品" /> 
		 
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		 <input type="button" class="scbtn1" onclick="showBill(${shopePage.id})" value="查看订单" /><br> <br> 
		
		
		
		<font style="font-size: 20px;" color="red">  好评：${shopePage.goodLevel }</font> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<font style="font-size: 20px;" color="blue"> 中评：${shopePage.normalLevel }</font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<font style="font-size: 20px;" color="green">差评：${shopePage.badLevel }</font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		
		<br />
		<br />
		
		<font style="font-size: 20px;" color="red">用户评论</font> <br /> <br />

	</center>

	<table class="tablelist">

		<thead>
			<tr>
				<th>序号</th>
				<th>评论</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${shopePage.comments }" var="comment"
				varStatus="status">

				<tr>
					<td>${status.index+1 }</td>
					<td>${comment.comment }</td>
					<td>${comment.time }</td>
					<td><a href="#" class="tablelink"></a> <a href="#"
						class="tablelink"> 改功能暂定</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<br />
	<br />
	<br />

	<center>
	<font style="font-size: 20px;" color="red">商铺食品</font>
	</center>
	
	<br />
	<br />
	<table class="tablelist">

		<thead>
			<tr>
				<th>序号</th>
				<th>名字</th>
				<th>图片</th>
				<th>种类</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${shopePage.foods }" var="food" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${food.name }</td>

					<td><img width="100"
						src="/myd/imgServlet.action?imgpath=${food.picPath }"></td>
					<td><c:choose>
							<c:when test="${food.type eq 1 }">
								种类1
							</c:when>

							<c:when test="${food.type eq 2 }">
								种类2
							</c:when>
							<c:when test="${food.type eq 3 }">
								种类3
							</c:when>

							<c:when test="${food.type eq 4 }">
								种类4
							</c:when>

							<c:when test="${food.type eq 5 }">
								种类5
							</c:when>

							<c:when test="${food.type eq 0 }">
								种类
							</c:when>

						</c:choose></td>

					<td>${food.price }</td>
					<td><a href="/myd/foodServlet.action?optype=deleteFood&foodid=${food.id }" class="tablelink"> 下架食品</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<br />
	<br />
	<br />

</body>
</html>