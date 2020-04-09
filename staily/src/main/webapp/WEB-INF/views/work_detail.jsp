<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<script>
function workEpisode(wNo,wdEpisode){
	var workEpisode_form = document.getElementById('workEpisode_'+wNo);
	alert("작품번호:"+wNo+" 회차:"+wdEpisode);
}
</script>
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
				
				
				<aside class="col-sm-3 col-sm-pull-2 sidebar">
					<div class="widget">
						<img src="${pageContext.request.contextPath}${w.wPoster}" alt="${w.wName}" />
						<h3 style="margin:50px auto;">${w.wName}</h3>
					</div>
					<div class="widget">
						<select class="form-control">
							<c:forEach begin="1" end="${tepisode}" step="1" varStatus="status">
								<form id="workEpisode_${w.wNo}" method="get">
							 		<option onclick="workEpisode(${w.wNo},${status.current})">${status.current}회</option>
									<input type="hidden" value="${w.wNo}" name="wNo"/>
							 		<input type="hidden" value="${status.current}" name="wdEpisode" />
								</form>
							</c:forEach>
						</select>
					</div>	
					<div class="widget">
						<form>
							<input type="text" placeholder="Search..." class="search" />
							<i class="material-icons">search</i>
						</form>
					</div>
				</aside>

					<!-- 기업회원 -->					
					<div class="col-sm-9 col-sm-push-1">
						<div class="slick-carousel" id="newIn5">
							<c:forEach var="cw" items="${cw}">
									<div class="movie-slide">
										<div class="movie-poster2">
											<a href="#"> <img
												src="${pageContext.request.contextPath}${cw.product[0].pScene}"
												alt="${cw.product[0].pName}" />
											</a>
										</div>
										<h4 class="no-underline">${cw.product[0].pName}</h4>
										<div>조회수: ${cw.product[0].pView}</div>
									</div>
							</c:forEach>
						</div>
						<h2></h2>
						<!-- 일반회원 -->
						<article>
							<c:forEach var="mw" items="${mw}">
							<form id="bookmark_${mw.product[0].pNo}" style="margin-top:10%;">
								<input type="hidden" value="${mNo}" name="mNo">
								<input type="hidden" value="${mw.product[0].pNo}" name="pNo">
								<img src="${pageContext.request.contextPath}${mw.product[0].pScene}" class="news-single-img" alt="" />
								<h2 value="상품이름" style="margin:0px;">${mw.product[0].pName}</h2>
								<div style="float:right;">
									<span value="작성자">작성자: ${mw.product[0].mId}</span>
									<span class="categories tag" value="조회수">조회수: ${mw.product[0].pView}</span>
									<span class="categories tag" value="에피소드">${mw.wdEpisode}회</span>
								</div>
								<input type="button" value="즐겨찾기 등록" onclick="create_bookmark(${mNo},${mw.product[0].pNo})">
							</form>
							</c:forEach>
						</article>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/include/include_js.jsp" %>
	</body>
</html>