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
		</div>
	</div>

</div>

<!-- Section -->
<div class="container-fluid">
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable2" width="100%"
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
								<td><a href="style_detail_read?bNo=${board.bNo}">
										${board.bTitle} </a></td>
								<td>${board.mId}</td>
								<td>${board.bView}</td>
								<td>${board.bDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="style_board_create" class="btn btn-ghost sort"> <span>쓰기</span>
				</a>
				<div id="msg"></div>
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
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
<%@ include file="/WEB-INF/views/admin/include/include_js.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#dataTable_paginate > ul > li.paginate_button.page-item.active > a")
				.css("background-color", "#e76115");
		$("#dataTable_paginate > ul > li.paginate_button.page-item.active > a")
				.css("border-color", "#e76115");

		$("#dataTable_paginate > ul > .page-link").click(function() {
			$(".page-link").css("background-color", "#e76115");
			$(".page-link").css("border-color", "#e76115");
		});

		var table = $('#dataTable2').DataTable({
			"language" : {
				"emptyTable" : "데이터가 없어요.",
				"lengthMenu" : "페이지당 _MENU_ 개씩 보기",
				"info" : "현재 _START_ - _END_ / _TOTAL_건",
				"infoEmpty" : "데이터 없음",
				"infoFiltered" : "( _MAX_건의 데이터에서 필터링됨 )",
				"search" : "검색: ",
				"zeroRecords" : "일치하는 데이터가 없어요.",
				"loadingRecords" : "로딩중...",
				"processing" : "잠시만 기다려 주세요...",
				"paginate" : {
					"next" : "다음",
					"previous" : "이전"
				}
			},
			order : [ [ 0, 'desc' ] ],
		});
	});
</script>
<style>
.pagination>.active>a, .pagination>.active>a:hover {
	background-color: #e76115 !important;
	border-color: #e76115 !important;
}

.table-responsive {
	overflow-x: hidden;
}
</style>

</body>
</html>