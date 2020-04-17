<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<!-- Hero -->
	<div id="hero" class="carousel slide carousel-fade" data-ride="carousel">
		<a href="#afterHeader" class="anchor">
			<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />
		</a>
<iframe class="ww"
	src="https://www.youtube-nocookie.com/embed/QphFqZ7tf9o?autoplay=1&loop=1&controls=0&vq=hd720"
	frameborder="0"	allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
	allowfullscreen style="position: absolute; width:100%; height:100%;"></iframe>

		<!-- Indicators -->
		
		</div>
	</div>
	<!-- Section -->
	<c:if test="${not empty userNo}">
	<!-- BOOKMARK -->
	<div class="container section">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>즐겨찾기</h2>
				<c:choose>
					<c:when test="${not empty bmList}">
						<div class="slick-carousel newIn">
							<c:forEach var="bm" items="${bmList}">
								<form id="bookmark_${bm.bmNo}" method="post">
									<input type="hidden" value="${bm.bmNo}" name="bmNo" />
									<input type="hidden" value="${bm.product.wNo}" name="wNo" />
									<input type="hidden" value="${bm.product.pNo}" name="pNo"/>
									<div class="movie-slide">
											<div class="movie-poster2">
												<!-- 커버 -->
												<!-- 
												<aside>
													<div>
														<input class="material-icons" type="image"
															style="border: none; width: 50%;" alt="즐겨찾기 제거"
															src="${pageContext.request.contextPath}/images/emptystar.png"
															onclick="bookmark_remove(${bm.bmNo})">
													</div>
												</aside>
												-->
												<a href="#" onclick="bm_productpage(${bm.bmNo},${bm.product.pNo})"> <img
													src="${pageContext.request.contextPath}${bm.product.pScene}"
													alt="${bm.product.pName}" style="width:100%; height:150px;" />
												</a>
											</div>
										<div>
											<input class="material-icons" type="image"
												style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 제거"
												src="${pageContext.request.contextPath}/images/star.png"
												onclick="delete_bookmark(${bm.bmNo});">
											<span class="no-underline" style="margin: 2% 0px;float:left;">${bm.product.pName}</span>
										</div>
									</div>
								</form>
							</c:forEach>
						</div>
					</c:when>
					<c:when test="${empty bmList}">
						<div style="text-align:center;margin-top:75px;">즐겨찾기로 등록한 상품이 없습니다</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	</c:if>
	<!-- HOT -->
	<div class="container section">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>HOT</h2>

				<div class="slick-carousel newIn">
					<c:forEach var="hot" items="${hotList}">
						<form id="product_${hot.pNo}" method="post">
							<input type="hidden" value="${hot.wNo}" name="wNo"/>
							<input type="hidden" value="${hot.pNo}" name="pNo"/>
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#" onclick="productpage(${hot.pNo})"> <img
										src="${pageContext.request.contextPath}${hot.pScene}"
										alt="${hot.pName}" style="width:100%; height:150px;" />
									</a>
								</div>
								<h4 class="no-underline">${hot.pName}</h4>
								<div>조회수: ${hot.pView}</div>
							</div>
						</form>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- TODAY -->
	<div class="container section remove-top-padding">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>TODAY</h2>
				<c:choose>
					<c:when test="${not empty todayList}">
					<div class="slick-carousel newIn">
						<c:forEach var="today" items="${todayList}">
							<form id="work_${today.wNo}" method="post">
								<input type="hidden" value="${today.wNo}" name="wNo" />
								<div class="movie-slide">
									<div class="movie-poster2">
										<a href="#" onclick="workpage(${today.wNo})"> <img
											src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${today.wPoster}"
											alt="Movie title" style="width:263px; height:372px;"/>
										</a>
									</div>
								</div>
							</form>
						</c:forEach>
					</div>
					</c:when>
					<c:when test="${empty todayList}">
						<div style="text-align:center;margin-top:75px;">오늘의 작품이 없습니다</div>
					</c:when>
				</c:choose>
			</div>
		</div>

	</div>
	<!-- DRAMA -->
	<div class="container section remove-top-padding">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>드라마</h2>

				<div class="slick-carousel newIn" >
					<c:forEach var="drama" items="${dramaList}">
						<form id="work_${drama.wNo}" method="post">
							<input type="hidden" value="${drama.wNo}" name="wNo" />
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#" onclick="workpage(${drama.wNo})"> <img
										src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${drama.wPoster}"
										alt="Movie title" style="width:263px; height:372px;"/>
									</a>
								</div>
							</div>
						</form>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<!-- MOVIE -->
	<div class="container section remove-top-padding">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>영화</h2>

				<div class="slick-carousel newIn">
					<c:forEach var="movie" items="${movieList}">
						<form id="work_${movie.wNo}" method="post">
							<input type="hidden" value="${movie.wNo}" name="wNo" />
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#" onclick="workpage(${movie.wNo})"> <img
										src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${movie.wPoster}"
										alt="Movie title" style="width:263px; height:372px;"/>
									</a>
								</div>
							</div>
						</form>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<!-- ----- -->
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>