<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<script>
	function remove_bookmark(bmNo){
		  var bookmark_form = document.getElementById('bookmark_'+bmNo);
		  alert("즐겨찾기에서 상품이 제거됐습니다");
		  bookmark_form.action = "delete_bookmark";
		  bookmark_form.submit();
	};
	function bm_productpage(bmNo,pNo){
		var product_form = document.getElementById('bookmark_'+bmNo);
		product_form.action = "../detail/detail_main";
		product_form.submit();
	};
	function hot_productpage(pNo){
		var product_form = document.getElementById('product_'+pNo);
		product_form.action = "../detail/detail_main";
		product_form.submit();
	};
	function workpage(wNo){
		var work_form = document.getElementById('work_'+wNo);
		work_form.action = "worklist_read";
		work_form.submit();
	};
</script>
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

				<div class="slick-carousel newIn">
					<c:forEach var="bm" items="${bmList}">
						<form id="bookmark_${bm.bmNo}" method="post">
							<input type="hidden" value="${bm.bmNo}" name="bmNo" />
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
											alt="${bm.product.pName}" />
										</a>
									</div>
								<div>
									<input class="material-icons" type="image"
										style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 제거"
										src="${pageContext.request.contextPath}/images/star.png"
										onclick="remove_bookmark(${bm.bmNo})">
									<span class="no-underline" style="margin: 2% 0px;float:left;">${bm.product.pName}</span>
								</div>
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

				<div class="slick-carousel newIn">
					<c:forEach var="hot" items="${hotList}">
						<form id="product_${hot.pNo}" method="post">
							<input type="hidden" value="${hot.pNo}" name="pNo"/>
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#" onclick="hot_productpage(${hot.pNo})"> <img
										src="${pageContext.request.contextPath}${hot.pScene}"
										alt="${hot.pName}" />
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

				<div class="slick-carousel newIn">
					<c:forEach var="today" items="${todayList}">
						<form id="work_${today.wNo}" method="post">
							<input type="hidden" value="${today.wNo}" name="wNo" />
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#" onclick="workpage(${today.wNo})"> <img
										src="${pageContext.request.contextPath}${today.wPoster}"
										alt="Movie title" />
									</a>
								</div>
							</div>
						</form>
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

				<div class="slick-carousel newIn" >
					<c:forEach var="drama" items="${dramaList}">
						<form id="work_${drama.wNo}" method="post">
							<input type="hidden" value="${drama.wNo}" name="wNo" />
							<div class="movie-slide">
								<div class="movie-poster2">
									<a href="#" onclick="workpage(${drama.wNo})"> <img
										src="${pageContext.request.contextPath}${drama.wPoster}"
										alt="Movie title" />
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
										src="${pageContext.request.contextPath}${movie.wPoster}"
										alt="Movie title" />
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