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
			<h2>여기 이름을 뭐로 줄까요?</h2>
			<div class="slick-carousel newIn" >
				<c:forEach var="cw" items="${cw}">
					<form id="product_${cw.product[0].pNo}">
						<input type="hidden" value="${userNo}" name="userNo">
						<input type="hidden" value="${cw.product[0].wNo}" name="wNo">
						<input type="hidden" value="${cw.product[0].pNo}" name="pNo">
						<div class="movie-slide">
							<div class="movie-poster2">
								<a href="#" onclick="productpage(${cw.product[0].pNo})"> <img
									src="${pageContext.request.contextPath}${cw.product[0].pScene}"
									alt="${cw.product[0].pName}" style="width:100%; height:108px;"/>
								</a>
							</div>
							<div pNo="${cw.product[0].pNo}">
								<c:choose>
									<c:when test="${!empty userNo}">
										<c:set var="cnt" value="0"/>
										<c:forEach var="bm" items="${bmList}">
											<c:if test="${cw.product[0].pNo eq bm.product.pNo}">
												<c:set var="cnt" value="1"/>
											</c:if>
										</c:forEach>
										<c:choose>
											<c:when test="${cnt==1}">
												<input class="material-icons" type="image"
														style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 제거"
														src="${pageContext.request.contextPath}/images/star.png"
														onclick="select_bookmark(${userNo},${cw.product[0].pNo});return false;">
											</c:when>
											<c:otherwise>
												<input class="material-icons" type="image"
												style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 등록"
												src="${pageContext.request.contextPath}/images/emptystar.png"
												onclick="create_bookmark(${userNo},${cw.product[0].pNo});return false;">	
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<input class="material-icons" type="image"
										style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 등록"
										src="${pageContext.request.contextPath}/images/emptystar.png"
										onclick="login_advice(); return false;">													
									</c:otherwise>
								</c:choose>
								<div class="no-underline" style="margin: 2% 0px;text-align:right;">${cw.product[0].pName}</div>
								<div style="text-align:right; margin: 8% 0;">조회수: ${cw.product[0].pView}</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</div>
					
			<!-- 일반회원 -->
			<article>
				<c:forEach var="mw" items="${mw}">
					<form id="product_${mw.product[0].pNo}" onsubmit="">
						<h2 value="상품이름" >${mw.product[0].pName}</h2>
						<input type="hidden" value="${userNo}" name="userNo">
						<input type="hidden" value="${mw.product[0].wNo}" name="wNo">
						<input type="hidden" value="${mw.product[0].pNo}" name="pNo">
						<div class="movie-poster2">
							<img onclick="productpage(${mw.product[0].pNo})"
								src="${pageContext.request.contextPath}${mw.product[0].pScene}"
								alt="${mw.product[0].pName}" style="width:850px; height:450px; margin: 0;cursor: pointer;"/>
						</div>
						<div style="height:100px;">
							<c:choose>
								<c:when test="${!empty userNo}">
									<c:set var="cnt" value="0"/>
									<c:forEach var="bm" items="${bmList}">
										<c:if test="${mw.product[0].pNo eq bm.product.pNo}">
											<c:set var="cnt" value="1"/>
										</c:if>
									</c:forEach>
									<c:choose>
										<c:when test="${cnt==1}">
											<input class="material-icons" type="image" 
													style="border: none; width: 4%; float:left; padding: 0px;" alt="즐겨찾기 제거"
													src="${pageContext.request.contextPath}/images/star.png"
													onclick="select_bookmark(${userNo},${mw.product[0].pNo});return false;">
										</c:when>
										<c:otherwise>
											<input class="material-icons" type="image"
											style="border: none; width: 4%; float:left; padding: 0px;" alt="즐겨찾기 등록"
											src="${pageContext.request.contextPath}/images/emptystar.png"
											onclick="create_bookmark(${userNo},${mw.product[0].pNo});return false;">	
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<input class="material-icons" type="image"
									style="border: none; width: 4%; float:left; padding: 0px;" alt="즐겨찾기 등록"
									src="${pageContext.request.contextPath}/images/emptystar.png"
									onclick="login_advice(); return false;">													
								</c:otherwise>
							</c:choose>
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