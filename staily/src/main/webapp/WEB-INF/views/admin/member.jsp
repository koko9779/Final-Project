<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">회원관리페이지</h1>
<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">회원리스트 출력</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th></th>
						<th>회원번호</th>
						<th>회원아이디</th>
						<th>회원이름</th>
						<th>이메일</th>
						<th>가입일</th>
						<th>회원구분</th>
						<th>회원수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${data }">
						<tr>
							<td><input type="checkbox" name="user_CheckBox"></td>
							<td>${member.mNo}</td>
							<td>${member.mId}</td>
							<td>${member.mName}</td>
							<td>${member.mEmail}</td>
							<td>${member.mAddress}</td>
							<td>${member.mType}</td>
							<td><input type="button" class="mCheckBtn" value="클릭" /></td>
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