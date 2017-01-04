<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/include/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<script>
	$(document).ready(function(){
		$("form").submit(function(){//this 받아온걸로 수정
			if($("#memberId").val() == ""){
				alert("아이디 입력해 주세요.");
				return false;
			}
			if($("#memberPw").val() == ""){
				alert("비밀번호를 입력해 주세요.");
				return false;
			}
			return true;
		});
		
		$("#register").click(function(){
			alert("경로만 잡아주면 됨");
		});
	})
</script>
<body>
	<div class="container" style="width: 100%; height: 100%;">
		<form name="fm" action="login" onsubmit="return fmt();" method="POST">
			<div class="header">
				<ul style="float: right;">
					<li style="float: left;">
						<input type="text" name="memberId" id="memberId">
					</li>
					<li style="float: left;">
						<input type="text" name="memberPw" id="memberPw">
					</li>
					<li style="float: left;">
						<input type="submit" name="login" id="login" value="Login">
					</li>
					<li style="float: left;">
						<input type="button" name="register" id="register" value="Register">
					</li>
				</ul>
			</div>
		</form>
		<!-- <div class="leftMenu" style="clear: both;">test1</div>

		<div class="mainContainer" style="float: left;">test2</div> -->
