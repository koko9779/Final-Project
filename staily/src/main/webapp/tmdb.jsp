<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/admin/include/include_css.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/themoviedb.js">
</script>

<script
	src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<style>
</style>
</head>
<div class="modal fade" id="work_confirm" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">작품 상세</h4>
			</div>
			<div class="modal-body" id="body"></div>
			<div class="modal-footer">
				<form name="wNo_request" method="POST">
					<button type="button" class="btn btn-primary"
						onClick="modal_click()">확인</button>
				</form>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">
					취소</button>
			</div>
		</div>
	</div>
</div>
<body>
	영화검색
	<input id="queryM" type="text" value="" onkeyup="searchItemM(queryM.value)">
	<button onclick="searchItemM(queryM.value)">확인</button>
	<input id="queryD" type="text" value="">
	<button onclick="searchItemD(queryD.value)">확인</button>
	<form id="resultF" name="resultF"></form>
</body>
<script src="${pageContext.request.contextPath}/js/custom_js/admin.js"></script>
</html>