<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">


</script>
</head>
<body>
<div>
	<input type="button" value="작품 검색" onClick="window.open('work_search')">
	<form name="f" method="post">
		작품명 : <input type="text" id="wNo" value="${workOne.getwName()}" readonly><br>
		카테고리 : <input type="text" id="wCategory" value="${workOne.getwCategory()}" readonly><br>
		처음 방영(개봉)일 : <input type="text" id="wDate" value="${workOne.getwDate()}" readonly><br>
		전체 회차 : <input type="text" id="wTepisode" value="${workOne.getwTepisode()}" readonly><br>
		작품 포스터 : <input type="text" id="wPoster" value="${workOne.getwPoster()}" readonly><br>
	</form>
	
</div>

</body>
</html>