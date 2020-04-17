<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include
	file="/WEB-INF/views/include/detail/include_css_product_detail.jsp"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>



<!-- Hero -->
<div id="content_hero"
	style="background-image: url(http://via.placeholder.com/1440x435)">

	<a href="#afterHeader" class="anchor"> <img
		src="${pageContext.request.contextPath}/images/scroll-arrow.svg"
		alt="Scroll down" class="scroll" />
	</a>

	<!-- Content -->
	<div class="container">
		<div class="row blurb scrollme animateme" data-when="exit"
			data-from="0" data-to="1" data-opacity="0" data-translatey="100">
			<div class="col-md-9">
				<span class="title">The very latest</span>
				<h1>Cinema news</h1>
			</div>
		</div>
	</div>

</div>

<!-- Section -->
<div class="container section news" id="afterHeader">
	<div class="row">
		<%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>
		<div class="col-sm-9 col-sm-push-1">
			<h2 style="margin-bottom: 0;">이 상품이 나온 장면</h2>
			<!--  
			<div class="row" style="width: 850px; height: 450px">
				<img src="${pageContext.request.contextPath}${productOne.get(0).getpScene()}">
			</div>
			-->
			<img
				src="${pageContext.request.contextPath}${productOne.get(0).getpScene()}"
				height="450px" width="850px" style="padding: 20px;">

			<!-- Section -->
			<h2>상품 사진</h2>
			<div class="slick-carousel news-carousel">
				<c:forEach var="product" items="${productOne}">
					<div>
						<img src="${pageContext.request.contextPath}${product.pdImage}">
					</div>
				</c:forEach>
			</div>

			<!-- Section -->
			<div class="row">
				<div class="tabs">
					<ul>
						<li><a href="#one">상품 정보</a></li>
						<c:if test="${not empty productOne.get(0).getpAddress()}">
							<li><a href="#two">매장 지도</a></li>
						</c:if>
						<li><a href="#three" id="reply">댓글</a></li>
					</ul>
					<div id="one">
						■상품명<br> ${productOne.get(0).getpName()}<br> ■가격<br>
						${productOne.get(0).getpPrice()}<br> ■쇼핑몰 URL<br>
						${productOne.get(0).getpUrl()}<br>
						<c:if test="${not empty productOne.get(0).getpAddress()}">
                        ■매장 오프라인 주소<br>
                        ${productOne.get(0).getpAddress()} ${productOne.get(0).getpDaddress()}<br>
						</c:if>
					</div>
					<c:if test="${not empty productOne.get(0).getpAddress()}">
						<div id="two">
							대충 지도가 있다는 내용<br>
						</div>
					</c:if>
					<div id="three">
						<div class="comments">
							<div class="col-sm-12">
								<form name="rpl">
									<c:choose>
										<c:when test="${not empty userNo}">
											<div class="form-group">
												<label>댓글 입력</label>
												<textarea rows="2" name="rContent" id="rContent"></textarea>
											</div>
											<div class="form-group right-align">
												<button class="btn btn-ghost" id="createreply"
													>작성하기</button>
											</div>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>
									<input type="hidden" name="mNo" id="mNo" value="${userNo}">
									<input type="hidden" name="pNoo" id="pNoo" value="${productOne.get(0).getpNo()}">
									<input type="hidden" name="wNo" id="wNo" value="${wNo}">
								</form>
								<div id="reply_space"></div>
							</div>
						</div>
					</div>
				</div>

				<form name="pNo_request" method="POST">
					<input type="hidden" id="pNo" name="pNo"
						value="${productOne.get(0).getpNo()}">
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include
	file="/WEB-INF/views/detail/include/include_product_detail_js.jsp"%>
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>

</html>