<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_navbar.jsp"%>

<!-- Hero -->
<div id="content_hero" style="background-image: url(http://via.placeholder.com/1440x435)">

	<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

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
<div class="container-fluid">
	  
	<div class="row">

		<%@ include file="/WEB-INF/views/mypage/include/include_sidebar.jsp" %>

		<div class="col-sm-9 col-sm-push-1" style="width: 70%">
	
			<!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">결제</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>결제 이용권</th>
                      <th>결제가격</th>
                      <th>이용권기간</th>
                      <th>결제방법</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                   <tr id="payment1">
                      <td value="10일 이용권">10일 이용권</td>
                      <td value="1000">1000원</td>
                      <td value="10">10일</td>
                      <td value="A">카카오페이</td>
                      <td><input type="button" class="paymentBtn" value="결제하기" /></td>
                    </tr>
                     <tr id="payment2">
                      <td value="20일 이용권">20일 이용권</td>
                      <td value="2000">2000원</td>
                      <td value="20">20일</td>
                      <td value="A">카카오페이</td>
                      <td><input type="button" class="paymentBtn" value="결제하기" /></td>
                    </tr>
                     <tr id="payment3">
                      <td value="30일 이용권">30일 이용권</td>
                      <td value="3000">3000원</td>
                      <td value="30">30일</td>
                      <td value="A">카카오페이</td>
                      <td><input type="button" class="paymentBtn" value="결제하기" /></td>
                    </tr>
                    <!--  
                  	<c:forEach var="payment" items="${data }">
                  	
                  	</c:forEach>
                  	-->
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!--  -->
    
		 <form id="memberInfoFrm" name="memberInfoFrm" autocomplete="off" action='member_update'>
			<input type="hidden" name="mNo" id="mNo" value="${member.mNo}">
			<input type="hidden" name="mId" id="mId" value="${member.mId}">
			<input type="hidden" name="mType" id="mType" value="${member.mType}"> 
			<input type="hidden" name="mPhone" id="mPhone" value="${member.mPhone}">
		</form>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
</div>
      <!-- Footer -->
</body>
</html>

