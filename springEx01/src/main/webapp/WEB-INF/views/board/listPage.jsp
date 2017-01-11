<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<script>
var result = '${msg}';
if(result == "success"){
	alert("작업이 성공적으로 이루어졌습니다.");
}
</script>
<table class="table table-bordered">
	<tr>
		<th style="width: 10px;">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px;">VIEWCNT</th>
	</tr>
	
	<c:forEach  items="${list}" var="boardVO">
		<tr>
			<td>${boardVO.bno}</td>
			<!-- UriComponents 사용 전 -->
			<%-- <td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td> --%>
			<!-- UriComponents 사용 후 -->
			<td><a href="/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardVO.bno}">${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
		</tr>
	</c:forEach>
</table>

<!-- UriComponents 사용 전 -->
<%-- <div class="text-center">
	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li><a href="listPage?page=${pageMaker.startPage - 1}">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?' class = active':''}"/>>
				<a href="listPage?page=${idx}">${idx}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="listPage?page=${pageMaker.endPage + 1}">&raquo;</a></li>
		</c:if>
	</ul>
</div> --%>

<!-- UriComponents 사용 후 -->
<div class="text-center">
	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li><a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?' class = active':''}"/>>
				<a href="listPage${pageMaker.makeQuery(idx)}">${idx}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="listPage${pageMaker.makeQuery(pageMaker.endPage + 1)}">&raquo;</a></li>
		</c:if>
	</ul>
</div>
<%@ include file="../include/footer.jsp" %>