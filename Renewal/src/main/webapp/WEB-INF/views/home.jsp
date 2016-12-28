<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <jsp:include page="../header_footer/header.jsp" flush="false" />
<jsp:include page="../header_footer/footer.jsp" flush="false" />
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="resources/include/common01.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<script>
	if ($(window).width() > 0) {
		$(window).on("scroll", function(ev) {
			if ($(window).scrollTop() > 150) {
				$('.menu_box').addClass('fixed');
			} else {
				$('.menu_box').removeClass('fixed');
			}
			return false;
		});
	}

	$(function() {
		$('a[href ^= #]').click(function() {
			var speed = 800;
			var href = $(this).attr("href");
			var target = $(href == "#" || href == "" ? 'html' : href);
			var position = target.offset().top;
			$('body, html').animate({
				scrollTop : position
			}, speed, 'swing');
			return false;
		});
		$("#login").click(function() {
			//슬라이딩 기능 추가
			$("#rightNav").css("width", "250px");
			$("#main").css("marginRight", "250px");
		});
		$("#close").click(function(){
			$("#rightNav").css("width", "0px");
			$("#main").css("marginRight", "0px");
		});
	});
</script>
<body>
	<div id ="main">
		<div id="section01">
			<div class="menu_box">
				<div class="logo">
					<a href="#section01">Y O O N H O</a>
				</div>
				<ul>
					<li><a href="#section01">Introduce</a></li>
					<li><a href="#section02">Portfolio</a></li>
					<li><a href="#section03">Board</a></li>
					<li><a href="#" id="login" class="loginNav" onclick="openNav()">login</a></li>
				</ul>
			</div>
			<div class="menuContext">
				<ul>
					<li>
						<div>
							<img src="resources/images/introduce.png" style="height: 100px;" title="자세히 보기 클릭">
						</div>
						<div>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
						</div>
					</li>
					<li>
						<div>
							<img src="resources/images/career.png" style="height: 100px;">
						</div>
						<div>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
						</div>
					</li>
					<li>
						<div>
							<img src="resources/images/certificate.png" style="height: 100px;">
						</div>
						<div>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
							test<br>
						</div>
					</li>
				</ul>
			</div>
		</div>

		<div id="section02">
			<div class="menuContext">
				<ul>
					<li style="float: left; width: 150px; color: red">test</li>
					<li style="float: left; width: 150px; color: red">test</li>
					<li style="float: left; width: 150px; color: red">test</li>
				</ul>
			</div>
		</div>
		<div id="section03">test</div>
	</div>
	<div class="rightNav" id="rightNav">
		아이디 <input type="text" class="loginText" name="memberId" id="memberId" size="5">
		비밀번호 <input type="text" class="loginText" name="memberPw" id="memberPw" size="10">
		<input type="submit" value="로그인">
		<input type="button" value="회원가입">
		<span id="close" style="cursor:pointer">close</span>
	</div>
</body>