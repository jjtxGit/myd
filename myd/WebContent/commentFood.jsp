<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title></title>

</head>
<body>
	<hr>

	<br>
	<font size="10">评论食物</font>


	<form action="/myd/vipServlet.action" method="post">
		
		<textarea name="gb_word" id="textArea" cols="48" rows="10"></textarea>

		<div style="width: 380px">
			<p>
				<img src="images/01.gif" width="20" height="20"
					onClick="document.forms[0].gb_word.value+='[-_-] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/02.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[@o@] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/03.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[-|-] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/04.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[o_o] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/05.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[ToT] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/06.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[*_*] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/07.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[-x-] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/08.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[-_-zz] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/09.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[t_t] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/10.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[-_-!] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/11.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:,] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/12.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:P] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/13.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:D] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/14.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:)] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/15.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:(] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/16.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:O] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/17.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:#] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/18.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:Z] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/19.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:0=] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/20.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/:P] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/21.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:$] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/22.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[-.-] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/23.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/-_-] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/24.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:{] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/25.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[zz] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/26.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[|-_-|] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/27.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[-_-||] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/28.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:.] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/29.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:-Q] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/30.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[9_9] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/31.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:,.] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/32.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:?] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/33.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:-|] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/34.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:K] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/35.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:G] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/36.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:L] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/37.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:c] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/38.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:q] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/39.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[:Y] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/40.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/gs] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/41.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/sg] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/42.gif" awidth="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/hp] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/43.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/ok] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/44.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/rain] ';document.forms[0].gb_word.focus()"
					style="cursor: hand"> <img src="images/45.gif" width="20"
					height="20"
					onClick="document.forms[0].gb_word.value+='[/yin] ';document.forms[0].gb_word.focus()"
					style="cursor: hand">
			</p>
		</div>
		
		
		 <input type="hidden" name="optype" value="commentFood">
		 
		 <input type="hidden" name="foodId" value="${param.foodId }" > 
		 
		 <input type="radio"  name="level" value="1">差评  	&nbsp; 
		 <input type="radio"  name="level" value="2">中评  	&nbsp;
		 <input type="radio"  name="level" value="3" checked="checked">好评
		 
		 <br> 
		
		
		 <br>
		
		<input type="submit" value="发表">

	</form>



	<hr>
</body>
</html>