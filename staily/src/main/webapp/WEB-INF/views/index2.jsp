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
<!-- Hero -->
			<div id="hero" class="carousel slide carousel-fade" data-ride="carousel">
				
				<a href="#afterHeader" class="anchor">
					<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />
				</a>

				<!-- Indicators -->
				<div class="container">	
					<ol class="carousel-indicators">
						<li data-target="#hero" data-slide-to="0" class="active"></li>
						<li data-target="#hero" data-slide-to="1"></li>
						<li data-target="#hero" data-slide-to="2"></li>
					</ol>
				</div>
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item active" style="background-image: url(http://via.placeholder.com/1140x665)">
						<!-- Content -->
						<div class="container">
							<div class="row blurb scrollme animateme" data-when="exit" data-from="0" data-to="1" data-opacity="0" data-translatey="100">
								<div class="col-md-9">
									<span class="title">Action, Adventure, Fantasy</span>
									<h1>End of the World: Part II</h1>
									<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum.</p>
									<div class="buttons">
										<span class="certificate">
											PG
										</span>
										<a href="https://youtu.be/ScMzIvxBSi4 data-vbtype="video" class="venobox btn btn-default">
											<i class="material-icons">play_arrow</i>
											<span>Play trailer</span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="item" style="background-image: url(http://via.placeholder.com/1140x665)">
						<!-- Content -->
						<div class="container">
							<div class="row blurb scrollme animateme" data-when="exit" data-from="0" data-to="1" data-opacity="0" data-translatey="100">
								<div class="col-md-9">
									<span class="title">Action, Adventure, Fantasy</span>
									<h1>End of the World: Part II</h1>
									<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum.</p>
									<div class="buttons">
										<span class="certificate">
											15
										</span>
										<a href="https://youtu.be/ScMzIvxBSi4 data-vbtype="video" class="venobox btn btn-default">
											<i class="material-icons">play_arrow</i>
											<span>Play trailer</span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="item" style="background-image: url(http://via.placeholder.com/1140x665)">
						<!-- Content -->
						<div class="container">
							<div class="row blurb scrollme animateme" data-when="exit" data-from="0" data-to="1" data-opacity="0" data-translatey="100">
								<div class="col-md-9">
									<span class="title">Action, Adventure, Fantasy</span>
									<h1>End of the World: Part II</h1>
									<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum.</p>
									<div class="buttons">
										<span class="certificate">
											PG
										</span>
										<a href="https://youtu.be/ScMzIvxBSi4 data-vbtype="video" class="venobox btn btn-default">
											<i class="material-icons">play_arrow</i>
											<span>Play trailer</span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
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