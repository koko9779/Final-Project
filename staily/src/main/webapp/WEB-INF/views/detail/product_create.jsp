<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function work_search() {
	window.open('work_search');
	window.close();
};

</script>
</head>
<body>

<div>
	<input type="button" value="작품 검색" onClick="work_search()">
	<form name="f" method="post">
		작품명 : ${workOne.getwName()}<br>
		카테고리 : 
		<c:choose>
			<c:when test="${workOne.getwCategory() eq 'D'}">
				드라마
			</c:when>
			<c:otherwise>
				영화
			</c:otherwise>
		</c:choose><br>
		처음 방영(개봉)일 : 
		<fmt:parseDate value="${workOne.getwDate()}" var="dateFormat" pattern="yyyy-MM-dd"/>
		<fmt:formatDate value="${dateFormat}" pattern="yyyy-MM-dd(E)" type="both"/><br>
		전체 회차 : ${workOne.getwTepisode()}부작<br>
		작품 포스터 <br>
		<img src='/staily${workOne.getwPoster()}' width='465px' height='664px'><br>
	</form>
	
</div>

</body>
</html>