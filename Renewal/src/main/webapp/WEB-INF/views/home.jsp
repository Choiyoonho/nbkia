<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <jsp:include page="../header_footer/header.jsp" flush="false" />
<jsp:include page="../header_footer/footer.jsp" flush="false" />
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/include/common01.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<script>
if($(window).width() > 0){
	$(window).on("scroll", function(ev){
		if($(window).scrollTop() > 150){
			$('.menu_box').addClass('fixed');
		}else{
			$('.menu_box').removeClass('fixed');
		}
		return false;
	});
}

$(function(){
	$('a[href ^= #]').click(function(){
		var speed = 800;
		var href = $(this).attr("href");
		var target = $(href == "#" || href == "" ? 'html' : href);
		var position = target.offset().top;
		$('body, html').animate({scrollTop : position}, speed, 'swing');
		return false;
	});
});
</script>
<body>
	<div id="section01">
		<div class="menu_box">
			<div class="logo">
				<a href="#section01">Y O O N H O</a>
			</div>
			<ul>
				<li><a href="#section01">Introduce</a></li>
				<li><a href="#section02">Career</a></li>
				<li><a href="#section03">Certificate</a></li>
				<li><a href="#section04">Portfolio</a></li>
				<li><a href="#">link</a></li>
			</ul>
		</div>
		<div style="position:relative; top:70%;left:50%;width:500px;height:100px;">
			<ul>
				<li style="float:left;width:150px;color: red">test</li>
				<li style="float:left;width:150px;color: red">test</li>
				<li style="float:left;width:150px;color: red">test</li>
			</ul>
		</div>
	</div>

	<div id="section02">
		
	</div>
	<div id="section03">test</div>
	<div id="section04">test</div>
</body>