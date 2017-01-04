<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!-- action이 지정되지 않았다.
	그 이유 : form의 action 속성이 지정되지 않으면 현재 경로를 그래도 action의 대상 경로로 잡기 때문이다.
 -->
<form role="form" method="POST">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" placeholder="Enter Title">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" rows="3" placeholder="Enter..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" placeholder="Enter Writer">
		</div><!-- /.box-body -->
		
		<div class="box-footer">
			<button type="submit" class="btn btn_primary">Submit</button>
		</div>
	</div>
</form>
<%@ include file="../include/footer.jsp" %>