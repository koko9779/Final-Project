<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>

<!-- Hero -->
<div id="content_hero" >
	<iframe class="ww"
			src="https://www.youtube-nocookie.com/embed/YubXq6Fh4S0?autoplay=1&amp;loop=1;playlist=YubXq6Fh4S0&controls=0&vq=hd720"
			frameborder="0"	allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>
	<a href="#afterHeader" class="anchor">
		<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />
	</a>
</div>


<!-- Section -->
<div class="container-fluid totop">
	<div class="row" id="afterHeader">
		<!-- 
		<div class="col-sm-2" id="board-create-sidebar">
			<aside class="col-sm-push-1 sidebar m-top-21">
				<div class="widget">
					<h3>Categories</h3>
					<ul style="padding-left: 15px;">
						<li><a href="style_main_read">전체 보기</a></li>
						<li><a href="style_main_read_top10">top 10</a></li>
						<li><a href="style_main_read_category?bCategory=M">영화</a></li>
						<li><a href="style_main_read_category?bCategory=D">드라마</a></li>
					</ul>
				</div>
			</aside>
		</div>
		-->
		<div class="col-sm-10">
			<div class=" col-sm-push-1 m-top-21" style="width: 90%">
				<form id="boardWriteF" name="boardWriteF" onSubmit="return false;">
					<div class="row justify-content-md-center">
							제목
							<input type="text" name="bTitle" class="form-control title_detail" autocomplete ="off">
							<span>
							<select class="custom-select form-control" name="bType" id="inputGroupSelect03">
								<option value="S">스타일코디</option>
							</select>
							<select class="custom-select form-control" name="bCategory" id="inputGroupSelect04">
								<option selected>카테고리</option>
								<option value="M">영화</option>
								<option value="D">드라마</option>
							</select>
							</span>
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
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>