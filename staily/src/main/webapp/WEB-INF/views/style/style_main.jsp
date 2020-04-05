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
	<h1>스타일코디 메인</h1><hr>
	<div>
		<h3>조회수 top 10 게시물 출력</h3>
		<c:forEach var="top10" items="${boardTop10}">
			<div>
				<c:out value="${top10.bNo}"/>
				<c:out value="${top10.mId}"/>
				<c:out value="${top10.bTitle}"/>
				<c:out value="${top10.bView}"/>
			</div>
		</c:forEach><hr>
	</div>
	<div>
		<h3>총 질문 수/ 총 댓글 수</h3>
		총 질문 수: ${boardCount} / 총 댓글 수: ${replyCount}
	</div><hr>
	<div>
		<h3>게시글 원글 출력</h3>
		<c:forEach var="b" items="${boardList}">
			<div>
				<c:out value="${b.bNo}"/>
				<c:out value="${b.mId}"/>
				<c:out value="${b.bTitle}"/>
				<c:out value="${b.bDate}"/>
				<c:out value="${b.bView}"/>
			</div>
		</c:forEach>
	</div>
	
</body>
</html>