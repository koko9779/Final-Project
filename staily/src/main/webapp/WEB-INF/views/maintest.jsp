<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
function bookmark_remove(bmNo){
	var bookmark_form = document.getElementById('bookmark_'+bmNo);
	bookmark_form.action = "bookmark_remove";
	bookmark_form.submit();
}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원번호 ${mNo}의 즐겨찾기 목록</h1>
	<c:forEach var="bm" items="${bmList}">
		<form id="bookmark_${bm.bmNo}" method="get">
			<c:out value="북마크번호:${bm.bmNo}" />
			<c:out value="상품번호:${bm.product.pNo}" />
			<c:out value="상품이름:${bm.product.pName}" />
			<c:out value="작품장면:${bm.product.pScene}" />
			<input type="button" value="즐겨찾기 제거" onclick="bookmark_remove(${bmNo})">
		</form>
	</c:forEach>
	<br />
	<h1>HOT</h1>
	<c:forEach var="hot" items="${hotList}">
		<div>
			<c:out value="상품번호:${hot.pNo}" />
			<c:out value="상품이름:${hot.pName}" />
			<c:out value="작품조회수:${hot.pView}" />
			<c:out value="작품장면:${hot.pScene}" />
		</div>
	</c:forEach>
	<br />
	<h1>Today</h1>
	<c:forEach var="today" items="${todayList}">
		<div>
			<c:out value="${today.wPoster}"/>
		</div>
	</c:forEach>
	<h1>드라마</h1>
	<c:forEach var="drama" items="${dramaList}">
		<div>
			<c:out value="작품번호:${drama.wNo}"/>
			<c:out value="작품카테고리:${drama.wCategory}"/>
			<c:out value="작품포스터:${drama.wPoster}"/>
		</div>
	</c:forEach>
	<h1>영화</h1>
	<c:forEach var="movie" items="${movieList}">
		<div>
			<c:out value="작품번호:${movie.wNo}"/>
			<c:out value="작품카테고리:${movie.wCategory}"/>
			<c:out value="작품포스터:${movie.wPoster}"/>
		</div>
	</c:forEach>
</body>
</html>