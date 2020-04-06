<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">

/*
function create_bookmark(mNo,pNo){
	var bookmark_form = document.getElementById('bookmark_'+pNo);
	alert(mNo+" "+pNo);
	alert(bookmark_form);
	bookmark_form.action = "create_bookmark";
	bookmark_form.submit();
}
*/
function displayWorkListHTML(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			var html = xhr.responseText;
			console.log(html);
			if(html.trim()=='true'){
				document.getElementById('heart').innerHTML = html;
			}
		}
	}
}
function create_bookmark(mNo,pNo){
	var bookmark_form = document.getElementById('bookmark_'+pNo);
	bookmark_form.addEventListener('click',function(e){
		var url = 'create_bookmark';
		var params = 'mNo='+bookmark_form.mNo.value+'&'+
					 'pNo='+bookmark_form.pNo.value;
		console.log(params);
		var callback = displayWorkListHTML;
		var method = 'POST';
		var async = true;
		
		sendRequest('create_bookmark', params, callback, method, async);
		e.preventDefault();
	});
	
}

</script>
<title>Insert title here</title>
</head>
<body>
	<h1>작품상세페이지</h1>
	<h2>작품정보 출력</h2>
	<div>
		작품포스터: ${w.wPoster}
		작품이름: ${w.wName}
	</div>
	<div>
		총회차: ${tepisode} 회
	</div>	
	<h2>상품리스트 출력(기업)</h2>
	<c:forEach var="cw" items="${cw}">
		<form id="bookmark_${cw.product[0].pNo}">
			<input type="hidden" value="${mNo}" name="mNo">
			<input type="hidden" value="${cw.product[0].pNo}" name="pNo">
			에피소드:<c:out value="${cw.wdEpisode}"/>
			상품이름:<c:out value="${cw.product[0].pName}"/>
			장면(이미지):<c:out value="${cw.product[0].pScene}"/>
			작성자:<c:out value="${cw.product[0].mId}" />
			조회수:<c:out value="${cw.product[0].pView}" />
			<div id="heart">
				즐찾=
			</div>
			<input type="button" value="즐겨찾기" onclick="create_bookmark(${mNo},${cw.product[0].pNo})">
		</form>
	</c:forEach>
	<br/>
	<h2>상품리스트 출력(일반)</h2>
		<c:forEach var="mw" items="${mw}">
		<div>
			<c:out value="에피소드:${mw.wdEpisode}"/>
			<c:forEach var="p" items="${mw.product}">
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
			<c:forEach var="p" items="${cwe.product}">
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
			<c:forEach var="p" items="${mwe.product}">
				<c:out value="상품이름:${p.pName}"/>
				<c:out value="장면(이미지):${p.pScene}"/>
				<c:out value="작성자:${p.mId}"/>
				<c:out value="조회수:${p.pView}"/>
			</c:forEach>
		</div>
	</c:forEach>
	<br/>
	<h2>게시물 총 건수</h2>
	<div>
		${pCnt}건
	</div>
<script src="${pageContext.request.contextPath}/js/httpRequest.js" type="text/javascript"></script>
</body>
</html>