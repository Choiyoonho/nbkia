<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<script>
/* var result = '${msg}';
if(result == "success"){
	alert("작업이 성공적으로 이루어졌습니다.");
} */

$(document).ready(function(){
	$('#searchBtn').on("click", function(event){
		self.location = "searchList" + '${pageMaker.makeQuery(1)}'
			+ "&searchType=" 
			+ $("select option:selected").val()
			+ "&keyword=" + $("#keywordInput").val();
		});
		
		$("#newBtn").on("click", function(evt){
			self.location = "register";
		});
});
</script>

<div class="box-body">
	<select name="searchType">
		<option value="n" <c:out value="${searchCri.searchType == null ? 'selected' : '' }"/>>---option</option>
		<option value="t" <c:out value="${searchCri.searchType eq 't' ? 'selected' : '' }"/>>---Title</option>
		<option value="c" <c:out value="${searchCri.searchType eq 'c' ? 'selected' : '' }"/>>---Content</option>
		<option value="w" <c:out value="${searchCri.searchType eq 'w' ? 'selected' : '' }"/>>---Writer</option>
		<option value="tc" <c:out value="${searchCri.searchType eq 'tc' ? 'selected' : '' }"/>>---Title OR Content</option>
		<option value="cw" <c:out value="${searchCri.searchType eq 'cw' ? 'selected' : '' }"/>>---Content OR Writer</option>
		<option value="tcw" <c:out value="${searchCri.searchType eq 'tcw' ? 'selected' : '' }"/>>---Title OR Content OR writer</option>
	</select>
	
	<input type="text" name="keyword" id="keywordInput" value="${searchCri.keyword}">
	<button id="searchBtn">Search</button>
	<button id="newBtn">New Board</button>
</div>

<table class="table table-bordered">
	<tr>
		<th style="width: 10px;">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px;">VIEWCNT</th>
	</tr>
	
	<c:forEach  items="${searchList}" var="boardVO">
		<tr>
			<td>${boardVO.bno}</td>
			<!-- UriComponents 사용 전 -->
			<%-- <td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td> --%>
			<!-- UriComponents 사용 후 -->
			<td><a href="/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}">${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
		</tr>
	</c:forEach>
</table>
<div class="text-center">
	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li><a href="searchList${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?' class = active':''}"/>>
				<a href="searchList${pageMaker.makeSearch(idx)}">${idx}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="searchList${pageMaker.makeSearch(pageMaker.endPage + 1)}">&raquo;</a></li>
		</c:if>
	</ul>
</div>
<%@ include file="../include/footer.jsp" %>