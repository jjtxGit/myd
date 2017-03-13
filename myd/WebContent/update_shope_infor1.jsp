<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>

<script type="text/javascript">
	
	/*
	 *手机号码的提示
	 */
	function alertUserpunm() {
		var $pnumi = $("#pnumi");
		$pnumi.html("请填写11位手机号码");
	}

	/**
	 *邮箱的提示
	 */
	function alertMail() {
		var $maili = $("#maili");
		$maili.html("请输入正确的邮箱号");
	}

	/*
	 *判断手机号码
	 */
	function verifyPum() {
		var pnum = $("#pnum").val();
		var $pnumi = $("#pnumi");

		if (pnum.length == 11 && !isNaN(pnum)) {
			pnumFT = true;
			$pnumi.html("<img src='/myd/icon/true.png' width='25'   >");
		} else {
			pnumFT = false;
			$pnumi.html("<img src='/myd/icon/false.png' width='25'   >");
		}
	}

	function bt(obj) {

		obj.type = "submit";
	}
</script>
</head>
<body>
	<center>
		<font color="blue" style="font-size: 20px">店铺信息修改</font>
	</center>
	<div class="formbody">
		<form action="/myd/shopeServlet.action?optype=updateShopeInfor2" method="post">
			
				<input type="hidden" name="id" value="${shope.id }" />
			
			
			<ul class="forminfo">
		

				<li><label>店铺名<b>*</b></label><input name="shopename"
					id="shopename" type="text" class="dfinput"
					onfocus="alertUserName()" value="${shope.shopName }"/> <i id="namei"></i></li>


				<li><label>电话号码<b>*</b></label><input name="pnum" id="pnum"
					type="text" class="dfinput" onfocus="alertUserpunm()" value="${shope.pnum }" /> <i id="pnumi"></i></li>

				<li><label>邮箱地址<b>*</b></label><input name="mail" id="mail"
					type="email" class="dfinput" onfocus="alertMail()" value="${shope.mail }"/><i id="maili"></i></li>


				<li><label>地址<b>*</b></label> <textarea name="adress"
						class="textinput" >${shope.adress }</textarea></li>

				<li><label>&nbsp;</label><input type="button" class="btn"
					value="下一步" onclick="bt(this)" /></li>
			</ul>
		</form>
	</div>
</body>

</html>
