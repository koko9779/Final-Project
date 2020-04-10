<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>
<script type="text/javascript">
	$(function(){
		$('#deleteFriendBtn').click(function(e){
			var size = document.getElementsByName("friend_check").length;
			for (var i = 0; i < size; i++) {
				if(document.getElementsByName("friend_check")[i].checked == true){
					var fPk = document.getElementsByName("friend_check")[i].value;
					friend_delete_function(fPk);
				}
			}
			
		});
		function friend_delete_function(fPk){
			$.ajax({
				url : "friend_delete",
				method : "GET",
				data : "fPk="+fPk,
				dataType : "text",
				success : function(result){
					location.reload();
				}
			})
		}
		
	})
</script>

        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
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
                      <td>${friend.mName}</td>
                      
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
