<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스타일코디 상세보기</h1>
			<form name="f" action="" method="post">
				<input type="text" value=""/>
				<c:out value="${b.bNo}"/>
				<c:out value="${b.mNo}"/>
				<c:out value="${b.bTitle}"/>
				<c:out value="${b.bContent}"/>
				<c:out value="${b.bView}"/>
				<c:out value="${b.bRecommend}"/>
				<c:out value="${b.bDate}"/>
				<c:out value="${b.mId}"/>
			</form>
</body>
</html>