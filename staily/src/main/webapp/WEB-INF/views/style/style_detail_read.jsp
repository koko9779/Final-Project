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
	all:unset;
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
				<div class="col-sm-2">
					<aside class="col-sm-push-1 sidebar">
						<div class="widget p-top-7">
							<h3>Categories</h3>
							<ul style="padding-left: 15px;">
								<li><a href="style_main_read">전체 보기</a></li>
								<li><a href="style_main_read_top10">top 10</a></li>
								<li><a href="style_main_read_category?bCategory=M">영화</a></li>
								<li><a href="style_main_read_category?bCategory=D">드라마</a></li>
							</ul>
						</div>
						
					</aside>
				</div>
					
				
					<div class="col-sm-10">
						<article id="board" style="border-bottom: none;">
						<div id="board2">
						<input type="hidden" id="updateBNo" value="${boardOneList[0].bNo}">
						<h3 class="board-top">스타일 질문</h3>
						<div class="categories col-md-6 board-title f-s-25" id="board_title_read">${boardOneList[0].bTitle}</div>
						<div class="col-md-6 text-left">
							<span class="font-small">${boardOneList[0].mId}.${boardOneList[0].bDate}.조회수: ${boardOneList[0].bView}</span>
						</div>
							<div class="p_content m-top-50" id="board_content_read">
								${boardOneList[0].bContent}
							</div> 
								<a href="javascript:board_delete(${boardOneList[0].bNo});" class="btn btn-ghost sort">
									<span>삭제</span>
								</a>
								<a href="javascript:board_and_reply_modify(${boardOneList[0].bNo});" class="btn btn-ghost sort">
									<span>수정</span>
								</a>
						</div>
						</article>
						<c:if test="${fn:length(boardOneList) > 1}">
						<h3 class="board-top reply-delete" id="reply-top">스타일 답변</h3>
						</c:if>
						<c:forEach var="board" items="${boardOneList}" begin="1" varStatus="status">
						<article class="reply reply-delete" id="board_${board.bNo}">
								<div class="col-md-12 m-top--40">
								
								<div class="categories col-md-6 board-title f-s-25">${board.bTitle}</div>
								<div class="col-md-6 text-left"><span class="font-small">${board.mId}.${board.bDate}</span></div>
								</div>
								<div class="p_content m-top-50 m-bottom-30" id="board_content_read">
									${board.bContent}
								</div> 
									<a href="javascript:recommend(${board.bNo}, ${board.mId});"
									class="btn btn-ghost clicked-button">
										<span>추천하기</span>
									</a>
									<a href="javascript:recommend(${board.bNo}, ${board.mId});"
										class="btn btn-ghost">
											<span>추천하기</span>
									</a>
								<a href="javascript:reply_delete(${board.bNo}, ${fn:length(boardOneList)});" class="btn btn-ghost sort">
									<span>삭제</span>
								</a>
								<a href="javascript:board_and_reply_modify(${board.bNo});" class="btn btn-ghost sort">
									<span>수정</span>
								</a>
						</article>
						</c:forEach>
						<div class="reply_write">
							<a href="javascript:reply_write_form();" class="btn btn-ghost sort">
									<span>답글 쓰기</span>
							</a>
						</div>
						<form name='boardReplyWriteF' id="boardReplyWriteF" onSubmit='return false;' class="dispaly_none" style="margin-top: 100px;">
									 			<input type='hidden' id='bNo' name='bNo' value='" + bNo + "'>
												<div class='row justify-content-md-center'>
													제목
													<input type='text' id='bTitle' name='bTitle' class='form-control title_detail empty'>
													<select class='custom-select form-control' name='bType' id='inputGroupSelect03'>
													<option selected value='S'>스타일코디</option>
													</select>
													<select class='custom-select form-control' name='bCategory' id='bCategory'>
														<option selected>카테고리</option>
														<option value='M'>영화</option>
														<option value='D'>드라마</option>
													</select>
												</div>
												<div class='row justify-content-md-center'>
													<textarea id='contents' name='bContent empty' class="empty"></textarea>
													<script>
														CKEDITOR.replace('contents',{
															filebrowserUploadUrl : '/staily/style/ImgUpload'
														}); 
													</script>
												</div>
												<div class='row justify-content-md-center'>
													<button type='submit' class='btn btn-ghost'
															style='width: 20%; font-weight: bold; margin-top: 15px;'  
															onclick='reply_write();'>
														등 록
													</button>
													<button type='submit' id='canselB' class='btn btn-ghost'
														style='width: 20%; font-weight: bold; margin-top: 15px;' 
														onclick='cancel_reply_write();'>
														취 소
													</button>
												</div>
										</form>
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