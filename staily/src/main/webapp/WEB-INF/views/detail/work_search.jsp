<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp" %>

<html>
<head>
<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/css/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/css/admin/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${pageContext.request.contextPath}/css/admin/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/css/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.request.contextPath}/css/admin/js/demo/datatables-demo.js"></script>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">
        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">작품 검색</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>번호</th>
                      <th>작품명</th>
                      <th>카테고리</th>
                      <th>처음 방영일</th>
                      <th>전체 회차</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="work" items="${data }">
                  	 <tr>
                  	  <td>${work.wNo}</td>
                  	  <td>${work.wName}</td>
                     	<c:choose>
							<c:when test="${work.wCategory eq 'D'}">
								<td>드라마</td>
							</c:when>
							<c:otherwise>
								<td>영화</td>
							</c:otherwise>
						</c:choose>
                      <fmt:parseDate value="${work.wDate}" var="dateFormat" pattern="yyyy-MM-dd"/>
					  <td><fmt:formatDate value="${dateFormat}" pattern="yyyy-MM-dd(E)" type="both"/></td>
                      <td>${work.wTepisode}부작</td>
                      <td><input type="button" class="confirm" value="선택"/></td>
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
    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>


<script type="text/javascript">
function member_delete(mNo) {
	var updateForm = document.getElementById("member_"+mNo);
	console.log(updateForm);
	updateForm.action="admin_delete";
	updateForm.method="POST";
	updateForm.submit;
};


//버튼 클릭시 Row에 있는 작품 번호 값 전달
$(".confirm").click(function(){ 
    var str = ""
    var tdArr = new Array();    
    var confirm = $(this);
    
    var tr = confirm.parent().parent();
    var td = tr.children();    
    
    var no = td.eq(0).text();
    
    console.log(no);

});
</script>
</body>

</html>