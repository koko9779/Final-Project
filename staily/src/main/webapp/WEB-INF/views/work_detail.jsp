<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">


function create_bookmark(mNo,pNo){
	var product_form = document.getElementById('product_'+pNo);
	alert('즐겨찾기에 상품이 추가되었습니다');
	product_form.action = "create_bookmark";
	product_form.submit();
}
/*
function displayWorkListHTML(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			var html = xhr.responseText;
			console.log(html);
			if(html.trim()=='true'){
				document.getElementById('heart').innerHTML = html;
			}
		}
	}
}
function create_bookmark(mNo,pNo){
	var bookmark_form = document.getElementById('bookmark_'+pNo);
	bookmark_form.addEventListener('click',function(e){
		var url = 'create_bookmark';
		var params = 'mNo='+bookmark_form.mNo.value+'&'+
					 'pNo='+bookmark_form.pNo.value;
		console.log(params);
		var callback = displayWorkListHTML;
		var method = 'POST';
		var async = true;
		
		sendRequest('create_bookmark', params, callback, method, async);
		e.preventDefault();
	});
	
}
*/
</script>
			<!-- Hero -->
			<div id="content_hero" style="background-image: url(http://via.placeholder.com/1440x435)">
				
				<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

				<!-- Content -->
				<div class="container">
					<div class="row blurb scrollme animateme" data-when="exit" data-from="0" data-to="1" data-opacity="0" data-translatey="100">
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

				<!-- 기업회원 -->					
					<div class="col-sm-9 col-sm-push-1" id="work_list_main" >
						
						<div class="slick-carousel newIn" >
						<!-- <div class="slick-carousel" id="newIn5">-->
							<c:forEach var="cw" items="${cw}">
								<form id="product_${cw.product[0].pNo}">
									<input type="hidden" value="${mNo}" name="mNo">
									<input type="hidden" value="${cw.product[0].pNo}" name="pNo">
									<div class="movie-slide">
										<div class="movie-poster2">
											<a href="#"> <img
												src="${pageContext.request.contextPath}${cw.product[0].pScene}"
												alt="${cw.product[0].pName}" />
											</a>
										</div>
										<div>
											<input class="material-icons" type="image"
												style="border: none; width: 10%; float:left; padding: 0px; margin: 0 5%;" alt="즐겨찾기 제거"
												src="${pageContext.request.contextPath}/images/emptystar.png"
												onclick="create_bookmark(${mNo},${cw.product[0].pNo})">
											<span class="no-underline" style="margin: 2% 0px;float:left;">${cw.product[0].pName}</span>
											
											<div>조회수: ${cw.product[0].pView}</div>
										</div>
									</div>
								</form>
							</c:forEach>
						</div>
						<h2></h2>
					<!-- 일반회원 -->
					<article>
						<c:forEach var="mw" items="${mw}">
						<form id="product_${mw.product[0].pNo}" style="margin-top:10%;">
							<input type="hidden" value="${mNo}" name="mNo">
							<input type="hidden" value="${mw.product[0].pNo}" name="pNo">
							<img src="${pageContext.request.contextPath}${mw.product[0].pScene}" class="news-single-img" alt="" />
							<h2 value="상품이름" style="margin:0px;">${mw.product[0].pName}</h2>
							<div style="float:right;">
								<span value="작성자">작성자: ${mw.product[0].mId}</span>
								<span class="categories tag" value="조회수">조회수: ${mw.product[0].pView}</span>
								<span class="categories tag" value="에피소드">${mw.wdEpisode}회</span>
							</div>
							<input type="button" value="즐겨찾기 등록" onclick="create_bookmark(${mNo},${mw.product[0].pNo})">
						</form>
						</c:forEach>
					</article>
					</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/include/include_js.jsp" %>
	</body>	
</html>