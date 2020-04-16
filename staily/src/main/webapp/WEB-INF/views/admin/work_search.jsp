<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/admin/include/include_css.jsp"%>
</head>
<div class="modal fade" id="work_confirm" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" style="width: auto">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">작품 상세</h4>
			</div>
			<div class="modal-body" id="body"></div>
			<div class="modal-footer">
				<form id= "searchRequest" name="searchRequest" method="POST" style="float: left;">
					<input type="hidden" id="wName" name="wName">
					<input type="hidden" id="wPoster" name="wPoster">
					<input type="hidden" id="wDate" name="wDate">
					<button type="button" class="btn btn-primary"
						onClick="modal_click()">선택</button>
				</form>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
<body>
	<h2 align="center">작품검색</h2><br>
	<div align="center">
	<input id="queryM" type="text" value=""
		onkeyup="searchItemM(queryM.value)" width="auto" >
	<button onclick="searchItemM(queryM.value)">확인</button>
	<form id="resultF" name="resultF"></form>
	</div>
</body>
<%@ include file="/WEB-INF/views/admin/include/include_js.jsp"%>
</html>