<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
  
<!-- Hero -->
<div id="content_hero"
	style="background-image: url(http://via.placeholder.com/1440x435)">

	<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg"
		alt="Scroll down" class="scroll" />

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
	<!--  
	<div class="row">

		<%--@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"--%>

		<div class="col-sm-9 col-sm-push-1" style="width: 70%">
	-->
			<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">스타일코디 페이지</h1>
<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<div>
			총 질문 수: ${boardCount} / 총 댓글 수: ${replyCount}
		</div>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${data}">
						<tr>
							<td>${board.bIdx}</td>
							<td>
								<a href="style_detail_read?bNo=${board.bNo}">
									${board.bTitle}
								</a>
							</td>
							<td>${board.mId}</td>
							<td>${board.bView}</td>
							<td>${board.bDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="style_board_create" class="btn btn-ghost sort">
								<span>쓰기</span>
							</a>
			<div id="msg">
			</div>
		</div>
	</div>
</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/admin/include/include_js.jsp" %>
<script type="text/javascript">
$(function (){
		$("#dataTable_paginate > ul > li.paginate_button.page-item.active > a").css("background-color", "#e76115");
		$("#dataTable_paginate > ul > li.paginate_button.page-item.active > a").css("border-color", "#e76115");
	
	$("#dataTable_paginate > ul > .page-link").click(function() {
		$(".page-link").css("background-color", "#e76115");
		$(".page-link").css("border-color", "#e76115");
	});
	
});
</script>
</body>
</html>