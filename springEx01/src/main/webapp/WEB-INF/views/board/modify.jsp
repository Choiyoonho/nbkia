<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");	//<form> 태그를 의미함
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		self.location = "/board/listAll";
	});
	
	$(".btn-primary").on("click", function(){
		formObj.submit();
	});
});
</script>
<%@ include file="../include/header.jsp" %>
<form role="form" method="POST">
	<div class="box_body">
		<div class="form-group">
			<label for="exampleInputEmail1">bno</label>
			<input type="text" name="bno" class="form-control" value="${boardVO.bno}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" value="${boardVO.title}">
		</div>
		<div class="form-group">
			<label for="examplePassword1">Content</label>
			<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
		</div>
	</div>
	
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Save</button>
		<button type="submit" class="btn btn-warning">Cancel</button>
	</div>
</form>
<%@ include file="../include/footer.jsp" %>