<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>

			<!-- Hero -->
			<div id="content_hero" style="background-image: url(http://via.placeholder.com/1440x435)">
				
				<img src="/staily/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

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
					<div class="col-sm-7">
						<article style="border-bottom: none;">
						<h3 class="board-top">스타일 질문</h3>
							<div class="categories col-md-6 board-title">${boardOneList[0].bTitle}</div>
							<div class="col-md-6 text-left"><span class="font-small">${boardOneList[0].mId}.${boardOneList[0].bDate}.조회수: ${boardOneList[0].bView}</span></div>
							<p>${boardOneList[0].bContent}</p>
							<a href="news-single.html" class="btn btn-ghost sort">
								<span>수정</span>
							</a>
							<a href="news-single.html" class="btn btn-ghost sort">
								<span>삭제</span>
							</a>
						</article>
						<c:forEach var="board" items="${boardOneList}" begin="1">
						<article>
							<h3 class="board-top">스타일 답변</h3>
							<div></div>
							<div class="categories col-md-6 board-title">${board.bTitle}</div>
							<div class="col-md-6 text-left"><span class="font-small">${board.mId}.${board.bDate}</span></div>
							<p>${board.bContent}</p>
							<a href="news-single.html" class="btn btn-ghost">
								<span>추천하기</span>
							</a>
							<a href="news-single.html" class="btn btn-ghost sort">
								<span>수정</span>
							</a>
							<a href="news-single.html" class="btn btn-ghost sort">
								<span>삭제</span>
							</a>
						</article>
						</c:forEach>
						<!--  
						<article>
							<div class="categories col-md-6 board-title">New releases, What's hot</div>
							<div class="col-md-6 text-left"><span class="font-small">글쓴이.작성날짜</span></div>
							<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
							<a href="news-single.html" class="btn btn-ghost">
								<span>추천하기</span>
							</a>
						</article>
						-->
					</div>
					<aside class="col-sm-3 col-sm-push-1 sidebar">
						<div class="widget">
							<form>
								<input type="text" placeholder="Search..." class="search" />
								<i class="material-icons">search</i>
							</form>
						</div>
						<div class="widget">
							<h3>Categories</h3>
							<ul>
								<li><a href="#">Coming soon</a></li>
								<li><a href="#">New releases</a></li>
								<li><a href="#">What's hot</a></li>
								<li><a href="#">Events</a></li>
							</ul>
						</div>
						<div class="widget">
							<h3>Archives</h3>
							<ul>
								<li><a href="#">July 2017</a></li>
								<li><a href="#">June 2017</a></li>
								<li><a href="#">May 2017</a></li>
								<li><a href="#">April 2017</a></li>
							</ul>
						</div>
						<div class="widget">
							<h3>Tags</h3>
							<a href="#" class="tag">Thriller</a>
							<a href="#" class="tag">Kids</a>
							<a href="#" class="tag">Offers</a>
							<a href="#" class="tag">Movie nights</a>
							<a href="#" class="tag">Premiere</a>
							<a href="#" class="tag">Animation</a>
							<a href="#" class="tag">Comedy</a>
							<a href="#" class="tag">New</a>
							</ul>
						</div>
					</aside>
				</div>
			</div>

			<!-- Pagination 
			<div class="section small-padding border-top">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ul class="pagination">
								<li><a href="#">Prev</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#" class="active">2</a></li>
								<li><span>&hellip;</span></li>
								<li><a href="#">7</a></li>
								<li><a href="#">8</a></li>
								<li><a href="#">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			-->
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
	</body>
</html>