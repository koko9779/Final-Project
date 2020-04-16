<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<style>
		.p_content>h1,.p_content> h2,.p_content> h3,.p_content> h4 {
		
	line-height: inherit;
    position: relative;
    margin: inherit;
    padding: inherit;
    border-bottom: inherit;
    font-size: inherit;
    font-family: inherit;
    font-weight: inherit;
    line-height: inherit;
    color: inherit;
    margin: inherit;
    font-size: inherit;
    font-weight: normal;
    line-height: inherit;

    font-size: inherit;
    margin-block-start: inherit;
    margin-block-end: inherit;
    margin-inline-start: inherit;
    margin-inline-end: inherit;
    font-weight: inherit;
		
		
		
			border-bottom: none;
			background-image: none !important;
		}
		
		.p_content>h2:after, .p_content>h3:after, .p_content>h4:after, .p_content>h5:after{
			background-image: none !important;
		}
	</style>
<link href="${pageContext.request.contextPath}/ckeditor/contents.css" rel="stylesheet">
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
					<div class="col-sm-3" style="margin-top: 7px;">
						<aside class="col-sm-push-1 sidebar">
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
						</aside>
					</div>
					<div class="col-sm-1">
					</div>
				
					<div class="col-sm-8">
						<article id="board" style="border-bottom: none;">
						<h3 class="board-top">스타일 질문</h3>
						<div class="categories col-md-6 board-title">${boardOneList[0].bTitle}</div>
						<div class="col-md-6 text-left">
							<span class="font-small">${boardOneList[0].mId}.${boardOneList[0].bDate}.조회수: ${boardOneList[0].bView}</span>
						</div>
							<div class="p_content">
								${boardOneList[0].bContent}
							</div> 
								<a href="javascript:board_delete(${boardOneList[0].bNo});" class="btn btn-ghost sort">
									<span>삭제</span>
								</a>
								<a href="javascript:board_modify(${boardOneList[0].bNo});" class="btn btn-ghost sort">
									<span>수정</span>
								</a>
						</article>
						<c:if test="${fn:length(boardOneList) > 1}">
						<h3 class="board-top reply-delete" id="reply-top">스타일 답변</h3>
						</c:if>
						<c:forEach var="board" items="${boardOneList}" begin="1" varStatus="status">
						<article class="reply reply-delete" id="board_${board.bNo}">
							<div></div>
							<div class="categories col-md-6 board-title">${board.bTitle}</div>
							<div class="col-md-6 text-left"><span class="font-small">${board.mId}.${board.bDate}</span></div>
							<p>${board.bContent}</p>
							<a href="news-single.html" class="btn btn-ghost">
								<span>추천하기</span>
							</a>
							<a href="javascript:reply_delete(${board.bNo}, ${fn:length(boardOneList)});" class="btn btn-ghost sort">
								<span>삭제</span>
							</a>
							<a href="news-single.html" class="btn btn-ghost sort">
								<span>수정</span>
							</a>
						</article>
						</c:forEach>
					</div>
					
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