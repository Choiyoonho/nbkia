<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h2>lotto number</h2>
<div>
<c:forEach items="${lottoResult }" var="lr">
	<div>${lr}</div>
</c:forEach>
</div>
</body>
</html>
