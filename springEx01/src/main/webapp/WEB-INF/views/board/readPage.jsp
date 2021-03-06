<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");	//<form> 태그를 의미함
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");
		formObj.submit();
	});
	/* 목록페이지 정보 저장 전 */
	/* $(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/remove");
		formObj.submit();
	}); */
	/* 목록페이지 정보 저장 후 */
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/removePage");
		formObj.submit();
	});
	
	/* 목록페이지 이동시 정보 저장 전 */
	/* $(".btn-primary").on("click", function(){
		self.location = "/board/listAll";
	}); */
	
	/* 목록페이지 이동시 정보 저장 후 */
	$(".btn-primary").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/board/listPage");
		formObj.submit();
	});
});
</script>
<form role="form" method="POST">
	<input type="hidden" name="bno" value="${boardVO.bno}">
	<input type="hidden" name="page" value="${cri.page}">
	<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
</form>

<div class="box_body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="examplePassword1">Content</label>
		<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
	</div>
</div>

<div class="box-footer">
	<button type="submit" class="btn btn-warning">Modify</button>
	<button type="submit" class="btn btn-danger">Remove</button>
	<button type="submit" class="btn btn-primary">List All</button>
</div>
<%@ include file="../include/footer.jsp" %>