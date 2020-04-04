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
	<h1>작품상세페이지</h1>
	<h2>상품리스트 출력(기업)</h2>
	<c:forEach var="cw" items="${cw}">
		<div>
			<c:out value="에피소드:${cw.wdEpisode}"/>
			<c:forEach var="p" items="${cp}">
				<c:out value="상품이름:${p.pName}"/>
				<c:out value="장면(이미지):${p.pScene}"/>
				<c:out value="작성자:${p.mId}"/>
				<c:out value="조회수:${p.pView}"/>
			</c:forEach>
		</div>
	</c:forEach>
	<br/>
	<h2>상품리스트 출력(일반)</h2>
		<c:forEach var="mw" items="${mw}">
		<div>
			<c:out value="에피소드:${mw.wdEpisode}"/>
			<c:forEach var="p" items="${mp}">
				<c:out value="상품이름:${p.pName}"/>
				<c:out value="장면(이미지):${p.pScene}"/>
				<c:out value="작성자:${p.mId}"/>
				<c:out value="조회수:${p.pView}"/>
			</c:forEach>
		</div>
	</c:forEach>
	<br/>
	<h2>상품리스트 회차별 출력(기업)</h2>
		<c:forEach var="cwe" items="${cwe}">
		<div>
			<c:out value="에피소드:${cwe.wdEpisode}"/>
			<c:forEach var="p" items="${cpe}">
				<c:out value="상품이름:${p.pName}"/>
				<c:out value="장면(이미지):${p.pScene}"/>
				<c:out value="작성자:${p.mId}"/>
				<c:out value="조회수:${p.pView}"/>
			</c:forEach>
		</div>
	</c:forEach>
	<br/>
	<h2>상품리스트 회차별 출력(일반)</h2>
		<c:forEach var="mwe" items="${mwe}">
		<div>
			<c:out value="에피소드:${mwe.wdEpisode}"/>
			<c:forEach var="p" items="${mpe}">
				<c:out value="상품이름:${p.pName}"/>
				<c:out value="장면(이미지):${p.pScene}"/>
				<c:out value="작성자:${p.mId}"/>
				<c:out value="조회수:${p.pView}"/>
			</c:forEach>
		</div>
	</c:forEach>
	<br/>
	<h2>게시물 총 건수</h2>
	
</body>
</html>