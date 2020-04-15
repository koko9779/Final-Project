<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>

<script type="text/javascript">
$(function(){
	
	//배열로 데이터를 Controller에 전송하기
	$('#deleteBtn').click(function(e){
		//배열선언
		var noArray = [];
		
		//배열에 값 채우기
		$('input[name="book_check"]:checked').each(function(i){
			noArray.push($(this).val());
		});
		
		var params = {
				"bmNo" : noArray 
		};
		
		//ajax 호출
		$.ajax({
			url : "bookmark_delete",
			data : params,
			dataType : "text",
			success : function(result){
				if(result == 'true'){
					alert('삭제완료');
					location.reload();
				}else{
					location.href = '404';
				}
				
			}
		});
		
		
		
		
	});
	
	
	
	
})

</script>

        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">북마크리스트페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">북마크리스트</h6>
            </div>
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

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>
