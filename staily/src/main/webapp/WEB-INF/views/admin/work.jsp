<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">작품관리페이지</h1>
<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">작품리스트 출력</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr align="center">
						<th></th>
						<th hidden="wNo">번호</th>
						<th>이름</th>
						<th>카테고리</th>
						<th>방영일</th>
						<th>전체회차</th>
						<th>작품상세정보</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="work" items="${data }">
						<tr valign="middle" align="center">
							<td><input type="checkbox" name="user_CheckBox"></td>
							<td hidden="wNo2">${work.wNo}</td>
							<td>${work.wName}</td>
							<c:choose>
							<c:when test="${work.wCategory =='D'}">
							<td>드라마</td>
							</c:when>
							<c:when test="${work.wCategory =='M'}">
							<td>영화</td>
							</c:when>
							</c:choose>
							<td>${work.wDate}</td>
							<td>${work.wTepisode}</td>
							<td><input type="button" class="wCheckBtn" value="클릭" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" class="btn btn-outline btn-primary pull-right"
				id="selectBtn">삭제</button><div id="msg"></div>
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