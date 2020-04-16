<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_navbar.jsp"%>
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

		<%@ include file="/WEB-INF/views/mypage/include/include_work_sidebar.jsp" %>

		<div class="col-sm-9 col-sm-push-1" style="width: 70%">
	
			<!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">북마크리스트</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
           
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th>화면</th>
                      <th>상품번호</th>
                      <th>작성자</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="bookmark" items="${data}">
                  	 <tr>
                  	  <td><input type="checkbox" name="book_check" value="${bookmark.bmNo}"></td>
                  	  <td style = "cursor:pointer;" onClick = " location.href='admin/'">
                  	  <img src="${pageContext.request.contextPath}/${bookmark.product.pScene}" width="50px" height="50px"> </td>
                      <td>${bookmark.product.pNo}</td>
                      <td>${bookmark.member.mId}</td>
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
                <input type="button" class="btn btn-outline btn-primary pull-right" value="삭제" id="deleteBtn">
                <!--  <button type="button" class="btn btn-outline btn-primary pull-right" id="selectBtn" >삭제</button>-->
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
</div>
      <!-- Footer -->
</body>
</html>
