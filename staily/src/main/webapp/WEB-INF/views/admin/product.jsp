<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp" %>
          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">회원관리페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">회원리스트 출력</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>상품이름</th>
                      <th>상품가격</th>
                      <th>상품URL</th>
                      <th>상품주소</th>
                      <th>상품상세주소</th>
                      <th>상품조회수</th>
                      <th>상품등록일</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="product" items="${data }">
                  	 <tr style = "cursor:pointer;" onClick = " location.href='admin/'" >
                      <td>${product.pName}</td>
                      <td>${product.pPrice}</td>
                      <td>${product.pUrl}</td>
                      <td>${product.pAddress}</td>
                      <td>${product.pDaddress}</td>
                      <td>${product.pView}</td>
                      <td>${product.pDate}</td>
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>

</html>
