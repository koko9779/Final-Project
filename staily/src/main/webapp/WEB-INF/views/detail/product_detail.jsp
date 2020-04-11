<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/detail/include_css_product_detail.jsp"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>



<!-- Hero -->
<div id="content_hero"
   style="background-image: url(http://via.placeholder.com/1440x435)">

   <a href="#afterHeader" class="anchor">
					<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />
				</a>

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
<div class="container section news" id="afterHeader">
   <div class="row">
   <%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>
      <div class="col-sm-9 col-sm-push-1">
         <h2>이 상품이 나온 장면</h2>
         <hr class="space-40" />
         <div class="row">
            <img src="${pageContext.request.contextPath}${productOne.get(0).getpScene()}">
         </div>
      </div>
   </div>
</div>

<form name="pNo_request" method="POST">
	<input type="hidden" id="pNo" name="pNo" value="${productOne.get(0).getpNo()}">
</form>

<!-- Section -->
<div class="container section news">
   <div class="row">
      <div class="col-sm-12">
         <h2>상품 사진</h2>
         <hr class="space-40"/>
         <div class="row">
            <div class="col-sm-12">
               <div class="slick-carousel news-carousel">
                  
                  <c:forEach var="product" items="${productOne}">
                     <div>
                        <img src="${pageContext.request.contextPath}${product.pdImage}">
                     </div>   
                  </c:forEach>      
               </div>
            </div>
         </div>
      </div>
   </div>
</div>


<!-- Section -->
<div class="container section news">
   <div class="row">
      <div class="col-sm-12">
         <div class="row">
            <div class="col-sm-5" style="width: auto;">
               <div class="tabs">
                  <ul>
                     <li><a href="#one">상품 정보</a></li>
                     <c:if test="${not empty productOne.get(0).getpAddress()}">
                        <li><a href="#two">매장 지도</a></li>
                     </c:if>
                     <li><a href="#three" id="reply">댓글</a></li>
                  </ul>
                  <div id="one">
                     ■상품명<br>
                     ${productOne.get(0).getpName()}<br>
                     ■가격<br>
                     ${productOne.get(0).getpPrice()}<br>
                     ■쇼핑몰 URL<br>
                     ${productOne.get(0).getpUrl()}<br>
                     <c:if test="${not empty productOne.get(0).getpAddress()}">
                        ■매장 오프라인 주소<br>
                        ${productOne.get(0).getpAddress()} ${productOne.get(0).getpDaddress()}<br>
                     </c:if>            
                  </div>
                  <c:if test="${not empty productOne.get(0).getpAddress()}">
                     <div id="two">
                        대충 지도가 있다는 내용<br>
                     </div>
                  </c:if>
                  <div id="three">
                  	<p id="replyList"></p>
                  <!--  
                  	 <form name="reply">
                  	 	아이디 : <input type="text" id="mName" value=""><br>
                  	 	내용 : <input type="text" id="rContent" value=""><br>
                  	 	추천 수 : <input type="text" id="rRecommend" value=""><br>
                  	 	신고 수 : <input type="text" id="rReport" value=""><br>
                  	 </form>
                  -->
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>

<%@ include file="/WEB-INF/views/detail/include/include_product_detail_js.jsp" %>

<script type="text/javascript">
$("#reply").on("click", function(e) {
	var pNo = ${productOne.get(0).getpNo()};
	
	$.ajax({
		url : "reply_list",
		type : "POST",
		data : {"pNo" : pNo},
		async : false,
		dataType : "json",
		success: function(data) {
				var first = $("#replyList").text(data[0].mName + "\n");
				first.html(first.html().replace(/\n/g, '<br>'));
				$("#replyList").append(data[0].rContent + "<br>");
				$("#replyList").append(data[0].rRecommend + "<br>");
				$("#replyList").append(data[0].rReport + "<br>");
			for(i = 1; i < data.length; i++) {
				$("#replyList").append(data[i].mName + "<br>");
				$("#replyList").append(data[i].rContent + "<br>");
				$("#replyList").append(data[i].rRecommend + "<br>");
				$("#replyList").append(data[i].rReport + "<br>");
			}
		}
	});
});
</script>

<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>

</html>