<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title>상품 등록</title>
<meta charset="UTF-8">
<script type="text/javascript">
function work_search() {
	location.href = 'work_select';
	//window.open('work_select');
	//window.close();
};

function product_create() {
	alert('작품 등록 성공!');
	location.href = "../main/index";
}

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
	<form name="ff" method="post">
		상품이 나온 장면 <input type="button" value="파일 업로드"><br>
		상품명 <input type="text" name="pName"><br>
		가격 <input type="text" name="pPrice"><br>
		쇼핑몰 URL <input type="text" name="pUrl"><br>
		<input type="button" value="주소 검색" onClick=""><br>
		주소 <input type="text" name="pAddress"><br>
		상세 주소 <input type="text" name="pDaddress"><br>
		<input type="button" value="작성" onClick="product_create()">
		<input type="reset" value="다시 작성">
	</form>
	
</div>

</body>
</html>