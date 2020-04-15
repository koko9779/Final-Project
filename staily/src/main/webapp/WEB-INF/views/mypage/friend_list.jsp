<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>


        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <!-- 친구찾기 -->
          <h1 class="h3 mb-2 text-gray-800">친구찾기</h1>

			<div id="search" class="tab_content">
				<input type="text" id="searchword" style="width:300px;" value="아이디를 입력하세요" >
			</div>
			<div class="dropdown" id="results">
			   <!-- add -->
			   <span data-toggle='dropdown' class="add"></span>
				<div class="dropdown-menu" id='searchDropdwon'>
				  	<a class="dropdown-item" href="#">친구추가</a>
				  	<a class="dropdown-item" href="#">쪽지보내기</a>
				</div>
			</div>
			<!--
			<div class="dropdown" id="results">
			  <button class="dropbtn"></button>
			  <div class="dropdown-content">
			    <a href="#">홈</a>
			    <a href="#">회사소개</a>
			    <a href="#">제품소개</a>
			    <a href="#">오시는길</a>
			  </div>
			</div>
			-->
			<br>
			<br>	          
          <!-- 친구찾기 -->
          <h1 class="h3 mb-2 text-gray-800">친구리스트페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">친구리스트</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th>친구</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="friend" items="${data}">
                  	 <tr>
                  	  <td><input type="checkbox" name="friend_check" value="${friend.fPk}"></td>
                      <td >
                      <div class="dropdown">
							<buttion class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
							 	${friend.mId}
							 </button>
							 <div class="dropdown-menu" id="friendDropdown">
							  	<a class="dropdown-item" href="#" value="${friend.fNo}">쪽지보내기</a>
							  	<a class="dropdown-item" href="#" value="${friend.mId}">쪽지보관함</a>
							</div>
					  </div>
	
                    </td>
                      
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
                <input type="button" class="btn btn-outline btn-primary pull-right" value="삭제" id="deleteFriendBtn">
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      
      <!-- End of Main Content -->

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>
