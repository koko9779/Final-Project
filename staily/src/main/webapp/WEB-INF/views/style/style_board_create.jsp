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

		<%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>

		<div class="col-sm-9 col-sm-push-1" style="width: 70%">
		<form name="boardWriteF" onSubmit="return false;">
			<div class="row justify-content-md-center">
					제목
					<input type="text" name="bTitle" class="form-control">
					<!-- 
					<input type="hidden" name="mNo" class="form-control" value="">
					 -->
					<select class="custom-select" name="bType" id="inputGroupSelect03">
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
			<div class="row justify-content-md-center" style="margin-bottom: 30px">
				<div class="input-group mb-3">
					<div class="custom-file">
						&nbsp;<input type="file" name="image" class="form-control-file"
							id="exampleFormControlFile1">
					</div>
				</div>
			</div>
			<div class="row justify-content-md-center">
				<button type="submit" class="btn btn-outline-secondary"
					style="width: 20%; font-weight: bold" onclick="boardCreate();">등 록</button>
			</div>
		</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function boardCreate() { 
	CKEDITOR.instances.contents.updateElement(); 
	if(document.boardWriteF.bTitle.value === "") { 
		alert("제목을 입력해 주세요"); 
		return; 
	}else if(document.boardWriteF.bType.value === "분류") { 
		alert("분류를 지정해 주세요"); 
		return; 
	}else if(document.boardWriteF.bContent.value === "") { 
		alert("내용을 입력해 주세요"); 
		return; 
	}else {
		document.boardWriteF.action = "${pageContext.request.contextPath}/style/style_create_board_action";
		document.boardWriteF.method = "POST";
		document.boardWriteF.submit();	
	} 
}

</script>
<%@ include file="/WEB-INF/views/include/include_js.jsp"%>
</body>
</html>