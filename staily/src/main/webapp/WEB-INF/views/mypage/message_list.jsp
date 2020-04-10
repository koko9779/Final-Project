<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>

        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">메시지리스트페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">메시지리스트</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th>메시지제목</th>
                      <th>작성자</th>
                      <th>보낸 일시</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="message" items="${data}">
                  	 <tr>
                  	  <td><input type="checkbox" name="message_check" value="${message.msNo}"></td>
                      <td style = "cursor:pointer;" 
                       onclick="window.open('message','window_name','width=500,height=500,left= 1000 location=no,status=no,scrollbars=yes');">
                       ${message.msTitle}</td>
                      <td>${message.mId}</td>
                      <td>${message.msDate}</td>
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
                <input type="button" class="btn btn-outline btn-primary pull-right" value="삭제" id="messageDeleteBtn">
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>
