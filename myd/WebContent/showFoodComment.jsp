<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br />
	<br />
	<br />
	<br />
	<center>
		<font color="blue" style="font-size: 24px;">食物评论</font>
	</center>
	
	<br />
	<br />
	<br />
	<br />

	<table  class="tablelist">
		
		
		<c:forEach items="${foodComments }" var="foodComment" varStatus="index">
			
			<tr>
			<td><font color="blue" style="font-size: 16px;">第${index.index+1 }条评论</font></td>
				<td><font color="green"  style="font-size: 16px;"> <c:choose>
						<c:when test="${foodComment.level eq 1 }">差评</c:when>
						<c:when test="${foodComment.level eq 2 }">中评</c:when>
						<c:when test="${foodComment.level eq 3 }">好评</c:when>
					</c:choose></font></td>
				<td><font color="orange"  style="font-size: 16px;">${foodComment.comment }</font></td>

				<td><font color = "red"  style="font-size: 16px;">${foodComment.time }</font></td>

			</tr>

		</c:forEach>

	</table>
	
</body>

</html>