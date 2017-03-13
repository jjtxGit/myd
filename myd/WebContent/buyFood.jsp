<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="/myd/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	var phoneFlage = false;
	var adressFlage = false;

	/**
	 *验证电话号码
	 *
	 */
	function verifyPhoneName() {

		var phone = $("#phone")[0].value;

		var $phoneSpan = $("#phoneSpan");

		if (phone.length == 11 && !isNaN(phone)) {//如果电话号码的长度是11位，且都是数字

			phoneFlage = true;
			$phoneSpan.html("<img src='/myd/icon/true.png' width='15'>");
		} else {

			phoneFlage = false;
			$phoneSpan.html("<img src='/myd/icon/false.png' width='15' >");

		}

	}
	/**
	 *提示电话号码
	 */
	function alertPhone() {
		var $phoneSpan = $("#phoneSpan");
		$phoneSpan.html("<font color='red'>请输入11位有效电话号码</font>");

	}

	/**
	 *提示地址信息
	 */
	function alertAdress() {
		var $adressSpan = $("#adressSapn");
		$adressSpan.html("<font color='red'>请输入正确的地址</font>");
	}

	/**
	 *验证地址
	 */
	function verifyAdress() {
		var adress = $("#adress")[0].value;
		var $adressSpan = $("#adressSapn");

		if (adress.length > 5) {

			adressFlage = true;
			$adressSpan.html("<img src='/myd/icon/true.png' width='15'>");

		} else {
			adressFlage = false;
			$adressSpan.html("<img src='/myd/icon/false.png' width='15' >");
		}

	}

	function buy() {

		if (phoneFlage && adressFlage) {
			alert("应该支付" + "${food.price}");
			location.href = "/myd/main.html";
		} else {
			alert("你的信息填写不完整");
		}

	}
</script>


<title>购买食物</title>
</head>
<body>
	<center>

		<div style="color: blue; font-size: 24px;">${food.name }</div>
		<br>
		<div>
			<img src="/myd/imgServlet.action?imgpath=${food.picPath }"
				width="300">
		</div>
	</center>

	<br>

	<div>
		<span>电话</span><span> <input type="text" name="phone"
			onblur="verifyPhoneName()" onfocus="alertPhone()" id="phone"></span>
		<span id="phoneSpan"></span>
	</div>
	<br>
	<div>
		<span>地址</span><span> <input type="text" name="adress"
			id="adress" onfocus="alertAdress()" onblur="verifyAdress()"
			id="phone"></span> <span id="adressSapn"></span>
	</div>

	<br>

	<div>
		<input type="button" onclick="buy()" value="确认购买">
	</div>


</body>
</html>