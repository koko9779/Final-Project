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
            <span class="title"></span>
            <h1>관리자페이지</h1>
         </div>
      </div>
   </div>

</div>

<!-- Section -->
<div class="container-fluid" id="afterHeader">
   <%@ include file="/WEB-INF/views/admin/include/include_sidebar.jsp"%>