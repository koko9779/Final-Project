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

		<%@ include file="/WEB-INF/views/mypage/include/include_sidebar.jsp" %>

		<div class="col-sm-9 col-sm-push-1" style="width: 70%">
	
			<!-- Page Heading -->

        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">내가쓴글목록</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th>상품화면</th>
                      <th>상품이름</th>
                      <th>작성일</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="product" items="${data}">
                  	 <tr>
                  	  <td><input type="checkbox" name="member_write_check" value="${product.pNo}"></td>
                      <td style = "cursor:pointer;" 
                      	  onClick = "location.href='../detail/product_detail?pNo=${product.pNo}&wNo=${product.wNo}'">
                      <img src="${pageContext.request.contextPath}/images/product/scene/${product.pScene}.jpg" width="100px" height="100px"></td>
                      <td>${product.pName}</td>
                      <td>${product.pDate}</td>
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
                <input type="button" class="btn btn-outline btn-primary pull-right" value="삭제" id="deleteWriteBtn">
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
	</div>
</div>
	  
</body>
</html>
