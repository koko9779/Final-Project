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
	<div class="row">

		<!-- <%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>-->
		
		<div class="col-sm-3">
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
		<div class="col-sm-1"></div>
		<div class="col-sm-8">
			<div class=" col-sm-push-1" style="width: 80%">
				<form name="boardWriteF" onSubmit="return false;">
					<div class="row justify-content-md-center">
							제목
							<input type="text" name="bTitle" class="form-control title_detail" autocomplete ="off">
							<select class="custom-select form-control" name="bType" id="inputGroupSelect03">
								<option selected>분류</option>
								<option value="Q">문의</option>
								<option value="S">스타일코디</option>
							</select>
					</div>
					<div class="row justify-content-md-center">
								<textarea id="contents" name="bContent"></textarea>
								<script>
									CKEDITOR.replace('contents',{
										filebrowserUploadUrl : '/staily/style/ImgUpload'
									});
								</script>
					</div>
					<div class="row justify-content-md-center">
						<button type="submit" class="btn btn-ghost"
							style="width: 20%; font-weight: bold; margin-top: 15px;" onclick="board_create();">등 록</button>
					</div>
				</form>
			</div>
		</div>
		
	</div>
</div>
<%@ include file="/WEB-INF/views/include/include_js.jsp"%>
</body>
<style>

	.title_detail{
		margin-bottom: 15px;
	}
	
	.custom-select{
		width: 115px;
    	margin-bottom: 7px;
	}
	
	.add_btn_detail{
		
	    background-color: #717171;
	}

</style>

</html>