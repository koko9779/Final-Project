<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/include_css.jsp"%>
<%@ include file="/WEB-INF/views/include/include_js.jsp"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>

<html>
<head>
</head>
<!-- Hero -->
<div id="content_hero"
	style="background-image: url(http://via.placeholder.com/1440x435)">

	<img src="images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

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
<div class="container section news">
	<div class="row">
		<div class="col-sm-12">
			<h2>상품 사진</h2>
			<hr class="space-40" />
			<div class="row">
				<div class="col-sm-12">

					<div class="slick-carousel news-carousel">
						<div>
							<div class="movie-poster">
								<aside>
									<div>
										<a href="#" class="play"> <i class="material-icons">link</i>
										</a> <a href="single-movie.html" class="read-more">read more</a>
									</div>
								</aside>
								<a href="#"> <img src="http://via.placeholder.com/360x225"
									alt="Lorem ipsum delor sit amet">
								</a>
							</div>
							<span class="date">8 March, 2017</span>
							<h4>Lorem ipsum delor sit amet</h4>
							<p>Classified advertising is a form of advertising that is
								particularly common in newspapers and other periodicals.</p>
						</div>
						<div>
							<div class="movie-poster">
								<aside>
									<div>
										<a href="#" class="play"> <i class="material-icons">link</i>
										</a> <a href="single-movie.html" class="read-more">read more</a>
									</div>
								</aside>
								<a href="#"> <img src="http://via.placeholder.com/360x225"
									alt="Lorem ipsum delor sit amet">
								</a>
							</div>
							<span class="date">2 March, 2017</span>
							<h4>Lorem ipsum delor sit amet</h4>
							<p>Classified advertising is a form of advertising that is
								particularly common in newspapers and other periodicals.</p>
						</div>
						<div>
							<div class="movie-poster">
								<aside>
									<div>
										<a href="#" class="play"> <i class="material-icons">link</i>
										</a> <a href="single-movie.html" class="read-more">read more</a>
									</div>
								</aside>
								<a href="#"> <img src="http://via.placeholder.com/360x225"
									alt="Lorem ipsum delor sit amet">
								</a>
							</div>
							<span class="date">14 February, 2017</span>
							<h4>Lorem ipsum delor sit amet</h4>
							<p>Classified advertising is a form of advertising that is
								particularly common in newspapers and other periodicals.</p>
						</div>
						<div>
							<div class="movie-poster">
								<aside>
									<div>
										<a href="#" class="play"> <i class="material-icons">link</i>
										</a> <a href="single-movie.html" class="read-more">read more</a>
									</div>
								</aside>
								<a href="#"> <img src="http://via.placeholder.com/360x225"
									alt="Lorem ipsum delor sit amet">
								</a>
							</div>
							<span class="date">2 March, 2017</span>
							<h4>Lorem ipsum delor sit amet</h4>
							<p>Classified advertising is a form of advertising that is
								particularly common in newspapers and other periodicals.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Section -->
<div class="container section news">
	<div class="row">
		<div class="col-sm-12">
			<h2>Tabs</h2>
			<hr class="space-40" />
			<div class="row">
				<div class="col-sm-5" style="width: auto;">
					<div class="tabs">
						<ul>
							<li><a href="#one">상품 정보</a></li>
							<c:if test="${not empty productOne.get(0).getpAddress()}">
								<li><a href="#two">매장 지도</a></li>
							</c:if>
							<li><a href="reply_list">댓글</a></li>
						</ul>
						<div id="one">
							■상품명<br>
							${productOne.get(0).getpName()}<br>
							■가격<br>
							${productOne.get(0).getpPrice()}<br>
							■쇼핑몰 URL<br>
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
						<div id="reply_list">
							<c:forEach var="replyList" items="${replyList}">
								<c:out value="${replyList.getmName()}"></c:out><br>
								<c:out value="${replyList.getrContent()}"></c:out><br>
								<c:out value="${replyList.getrRecommend()}"></c:out><br>
								<c:out value="${replyList.getrReport()}"></c:out><br>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</html>