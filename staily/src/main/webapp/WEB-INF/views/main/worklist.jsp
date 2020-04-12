<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>

<!-- Hero -->
<div id="content_hero" style="background-image: url(http://via.placeholder.com/1440x435)">
	
	<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

	<!-- Content -->
	<div class="container">
		<div class="row blurb scrollme animateme" data-when="exit" data-from="0" data-to="1" data-opacity="0" data-translatey="100">
			<div class="col-md-9">
				<span class="title">The very latest</span>
				<h1>Cinema news</h1>
			</div>
		</div>
	</div>

</div>

<!-- Section -->
<div class="container section news">
	<div class="row">
	
	<%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>

		<div class="col-sm-9 col-sm-push-1" id="work_list_main" >
		
			<!-- 기업회원 -->					
			<h2>~~기업특권이다~~</h2>
			<div class="slick-carousel newIn" >
			<!-- <div class="slick-carousel" id="newIn5">-->
				<c:forEach var="cw" items="${cw}">
					<form id="product_${cw.product[0].pNo}">
						<input type="hidden" value="${userNo}" name="userNo">
						<input type="hidden" value="${cw.product[0].pNo}" name="pNo">
						<div class="movie-slide">
							<div class="movie-poster2">
								<a href="#"> <img
									src="${pageContext.request.contextPath}${cw.product[0].pScene}"
									alt="${cw.product[0].pName}" />
								</a>
							</div>
							<div>
								<input class="material-icons" type="image"
									style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 등록"
									src="${pageContext.request.contextPath}/images/emptystar.png"
									onclick="create_bookmark(${userNo},${cw.product[0].pNo})">
								<span class="no-underline" style="margin: 2% 0px;float:left;">${cw.product[0].pName}</span>
								
								<div>조회수: ${cw.product[0].pView}</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</div>
					
			<!-- 일반회원 -->
			<article>
				<c:forEach var="mw" items="${mw}">
				<form id="product_${mw.product[0].pNo}" style="margin-top:10%;">
					<h2 value="상품이름" >${mw.product[0].pName}</h2>
					<input type="hidden" value="${userNo}" name="userNo">
					<input type="hidden" value="${mw.product[0].pNo}" name="pNo">
					<img src="${pageContext.request.contextPath}${mw.product[0].pScene}" class="news-single-img" alt="" />
					<div >
					<input class="material-icons" type="image"
							style="border: none; width: 5%; padding: 0px; margin: 0 5%; float:left;" alt="즐겨찾기 등록"
							src="${pageContext.request.contextPath}/images/emptystar.png"
							onclick="create_bookmark(${userNo},${mw.product[0].pNo})">
					<div style="float:right;">
						<span value="작성자">작성자: ${mw.product[0].mId}</span>
						<span class="categories tag" value="조회수">조회수: ${mw.product[0].pView}</span>
						<span class="categories tag" value="에피소드">${mw.wdEpisode}회</span>
					</div>
					</div>
				</form>
				</c:forEach>
			</article>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/include/include_js.jsp" %>
</body>	
</html>