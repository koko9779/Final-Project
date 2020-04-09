<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 정렬된 기업회원 -->					
<div class="col-sm-9 col-sm-push-1">
	<div class="slick-carousel" id="newIn5">
		<c:forEach var="cwe" items="${cwe}">
				<div class="movie-slide">
					<div class="movie-poster2">
						<a href="#"> <img
							src="${pageContext.request.contextPath}${cwe.product[0].pScene}"
							alt="${cwe.product[0].pName}" />
						</a>
					</div>
					<h4 class="no-underline">${cwe.product[0].pName}</h4>
					<div>조회수: ${cwe.product[0].pView}</div>
				</div>
		</c:forEach>
	</div>
	<h2></h2>
	<!-- 정렬된 일반회원 -->
	<article>
		<c:forEach var="mwe" items="${mwe}">
		<form id="bookmark_${mwe.product[0].pNo}" style="margin-top:10%;">
			<input type="hidden" value="${mNo}" name="mNo">
			<input type="hidden" value="${mwe.product[0].pNo}" name="pNo">
			<img src="${pageContext.request.contextPath}${mwe.product[0].pScene}" class="news-single-img" alt="" />
			<h2 value="상품이름" style="margin:0px;">${mwe.product[0].pName}</h2>
			<div style="float:right;">
				<span value="작성자">작성자: ${mwe.product[0].mId}</span>
				<span class="categories tag" value="조회수">조회수: ${mwe.product[0].pView}</span>
				<span class="categories tag" value="에피소드">${mwe.wdEpisode}회</span>
			</div>
			<input type="button" value="즐겨찾기 등록" onclick="create_bookmark(${mNo},${mwe.product[0].pNo})">
		</form>
		</c:forEach>
	</article>
</div>