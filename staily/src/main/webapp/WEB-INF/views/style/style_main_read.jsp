<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">스타일코디 페이지</h1>
<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">스타일코디</h6>
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
			<div id="msg">
			</div>
		</div>
	</div>
</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
</html>