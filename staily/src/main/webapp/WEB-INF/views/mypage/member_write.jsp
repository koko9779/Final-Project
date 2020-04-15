<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>

<script type="text/javascript">
$(function(){
	
	/***************내가쓴글 삭제***************************/
	$('#deleteWriteBtn').click(function(e){
		var noArray = [];
		
		$('input[name="member_write_check"]:checked').each(function(i){
			noArray.push($(this).val());
		})
		
		var params = {
			"pNo" : noArray
		}
		
		$.ajax({
			url : 'member_write_delete',
			data : params,
			dataType : "text",
			success : function(result){
				if(result == 'true'){
					alert('삭제완료');
					location.reload();
				}else{
					location.href = '404';
				}
			},
			error : function(){
				location.href = '404';
			}
		});
		
		
	});
	
	
	/*
	$('#deleteWriteBtn').click(function(e){
		var size = document.getElementsByName("member_write_check").length;
		for (var i = 0; i < size; i++) {
			if(document.getElementsByName("member_write_check")[i].checked == true){
				var pNo = document.getElementsByName("member_write_check")[i].value;
				member_write_delete_function(pNo);
			}
			
		}
		
	});
	function member_write_delete_function(pNo){
		$.ajax({
			url : "member_write_delete",
			method : "GET",
			data : 'pNo='+pNo,
			dataType : "text",
			success : function(result){
				location.reload();
			}
		})
	}
	*/
})
</script>

        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">내가쓴글목록</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">내가쓴글목록</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th>상품화면</th>
                      <th>상품이름</th>
                      <th>상품번호</th>
                      <th>회원번호</th>
                      <th>작성일</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="product" items="${data}">
                  	 <tr>
                  	  <td><input type="checkbox" name="member_write_check" value="${product.pNo}"></td>
                      <td style = "cursor:pointer;" onClick = " location.href='admin/'">
                      <img src="${pageContext.request.contextPath}/${product.pScene}" width="50px" height="50px"></td>
                      <td>${product.pName}</td>
                      <td>${product.pNo}</td>
                      <td>${product.mNo}</td>
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
      <!-- End of Main Content -->

      <!-- Footer -->
   	  <%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>
