<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="replyList" items="${replyList}">
	<c:out value="${replyList.getmName()}"></c:out><br>
	<c:out value="${replyList.getrContent()}"></c:out><br>
	<c:out value="${replyList.getrRecommend()}"></c:out><br>
	<c:out value="${replyList.getrReport()}"></c:out><br>
</c:forEach>
</body>
</html>