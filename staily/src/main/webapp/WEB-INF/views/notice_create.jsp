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
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-10">
			<div class=" col-sm-push-1 m-top-21" style="width: 80%">
				<form name="boardWriteF" onSubmit="return false;">
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
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
<style>

	.title_detail{
		margin-bottom: 15px;
	}
	
	.custom-select{
	float:left;
		margin-right:5px;
		width: 115px;
    	margin-bottom: 7px;
	}
	
	.add_btn_detail{
		
	    background-color: #717171;
	}

</style>

</html>