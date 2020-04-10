<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>

        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">결제내역페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">결제내역</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>결제 이용권</th>
                      <th>결제가격</th>
                      <th>이용권기간</th>
                      <th>결제방법</th>
                      <th>결제일</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="payment" items="${data }">
                  	 <tr style = "cursor:pointer;" onClick = " location.href='admin/'" >
	                      <td>${payment.pyName}</td>
	                      <td>${payment.pyPrice}</td>
	                      <td>${payment.pyPeriod}</td>
	                      <td>${payment.pyType}</td>
	                      <td>${payment.pyDate}</td>
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

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>

