<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

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
	<div class="row"></div>
</div>
<%@ include file="/WEB-INF/views/include/include_js.jsp"%>
<div class="content" style="width: 70%">
	<div class="row justify-content-md-center">
		<div class="col-sm-9">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text">제목</label>
				</div>
				<input type="text" class="form-control">
			</div>
		</div>
		<div class="col-sm-3">
			<div class="input-group mb-3">
				<select class="custom-select" id="inputGroupSelect03">
					<option selected>분류</option>
					<option value="1">문의</option>
					<option value="2">스타일코디</option>
					<option value="3">아무거나~</option>
				</select>
			</div>
		</div>
	</div>

	<hr>

	<div class="row justify-content-md-center">
		<div class="col_c" style="margin-bottom: 30px">
			<div class="input-group">
				<textarea name="contents" cols="80" rows="10"></textarea>
				<script>
					CKEDITOR.replace('contents');
				</script>
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="input-group mb-3">
			<div class="custom-file">
				&nbsp;<input type="file" class="form-control-file"
					id="exampleFormControlFile1">
			</div>
		</div>
	</div>

	<div class="row justify-content-md-center">
		<button type="submit" class="btn btn-outline-secondary"
			style="width: 20%; font-weight: bold">등 록</button>
	</div>
</div>
</body>
</html>