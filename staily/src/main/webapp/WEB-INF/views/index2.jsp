<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<script>
function bookmark_remove(bmNo){
	var bookmark_form = document.getElementById('bookmark_'+bmNo);
	alert(bmNo);
	bookmark_form.action = "delete_bookmark";
	bookmark_form.submit();
}
</script>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>

	<!-- Section -->
	<c:if test="${not empty mNo}">
	<!-- BOOKMARK -->
	<div class="container section">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>즐겨찾기</h2>

				<div class="slick-carousel" id="newIn">
					<c:forEach var="bm" items="${bmList}">
						<form id="bookmark_${bm.bmNo}" method="get">
							<input type="hidden" value="${bm.bmNo}" name="bmNo" />
							<div class="movie-slide">
								<div class="movie-poster">
									<!-- 커버 -->
									<aside>
										<div>
											<input class="material-icons" type="image"
												style="border: none; width: 50%;" alt="즐겨찾기 제거"
												src="${pageContext.request.contextPath}/images/emptystar.png"
												onclick="bookmark_remove(${bm.bmNo})">
										</div>
									</aside>
									<a href="#"> <img
										src="${pageContext.request.contextPath}${bm.product.pScene}"
										alt="${bm.product.pName}" />
									</a>
								</div>
								<h4 class="no-underline">${bm.product.pName}</h4>
								<!-- 별점 -->
								<!-- 
								<div class="star-rating">
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i>
								</div>
								-->
								<!--  -->
							</div>
						</form>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	</c:if>
	<!-- HOT -->
	<div class="container section">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>HOT</h2>

				<div class="slick-carousel" id="newIn1">
					<c:forEach var="hot" items="${hotList}">
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#"> <img
										src="${pageContext.request.contextPath}${hot.pScene}"
										alt="${hot.pName}" />
									</a>
								</div>
								<h4 class="no-underline">${hot.pName}</h4>
								<div>조회수: ${hot.pView}</div>
								<!-- 별점 -->
								<!-- 
								<div class="star-rating">
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i>
								</div>
								-->
								<!--  -->
							</div>
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

				<div class="slick-carousel" id="newIn2">
					<c:forEach var="today" items="${todayList}">
						<input type="hidden" value="${today.wNo}" name="wNo" />
						<div class="movie-slide">
							<div class="movie-poster2">
								<a href="#"> <img
									src="${pageContext.request.contextPath}${today.wPoster}"
									alt="Movie title" />
								</a>
							</div>
							<!-- 이름 -->
							<!-- 
								<h4 class="no-underline">The last post</h4>
							-->
							<!-- 별점 -->
							<!-- 
								<div class="star-rating">
								<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
								<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
								<i class="material-icons">star_rate</i>
								</div>
							-->
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<!-- DRAMA -->
	<div class="container section remove-top-padding">
		<div class="row">
			<div class="col-sm-12" id="afterHeader">
				<h2>드라마</h2>

				<div class="slick-carousel" id="newIn3">
					<c:forEach var="drama" items="${dramaList}">
						<input type="hidden" value="${drama.wNo}" name="wNo" />
						<div class="movie-slide">
							<div class="movie-poster2">
								<a href="#"> <img
									src="${pageContext.request.contextPath}${drama.wPoster}"
									alt="Movie title" />
								</a>
							</div>
							
							<!-- 이름 -->
							<!-- 
								<h4 class="no-underline">The last post</h4>
								-->
							<!-- 별점 -->
							<!-- 
								<div class="star-rating">
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i>
								</div>
							-->
						</div>
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

				<div class="slick-carousel" id="newIn4">
					<c:forEach var="movie" items="${movieList}">
						<input type="hidden" value="${movie.wNo}" name="wNo" />
						<div class="movie-slide">
							<div class="movie-poster2">
								<a href="#"> <img
									src="${pageContext.request.contextPath}${movie.wPoster}"
									alt="Movie title" />
								</a>
							</div>
							<!-- 이름 -->
							<!-- 
								<h4 class="no-underline">The last post</h4>
							-->
							<!-- 별점 -->
							<!-- 
								<div class="star-rating">
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i> <i class="material-icons">star_rate</i>
									<i class="material-icons">star_rate</i>
								</div>
							-->
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<!-- ----- -->

<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>