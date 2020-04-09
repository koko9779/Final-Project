<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp" %>
  <!-- custom css  -->
  <link href="${pageContext.request.contextPath}/css/login/login_custom.css" rel="stylesheet" type="text/css">
 
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
  <script type="text/javascript">
  	function login_action() {
  		document.f.action="login_action";
  		document.f.method="POST";
  		document.f.submit();
  	}
  	
  	$(function() {
		var id = $("#findIdE").val();
		if(id === "") {
			return;
		}else {
			alert("고객님의 아이디는 " + id + "입니다");
			location.href="login";
			return;
		}
	});
  	
  </script>
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">환영합니다</h1>
                  </div>
                  <input type="hidden" value="${findId}" id="findIdE">
                  <form class="user" name="f">
                    <div class="form-group" id="id_margin">
                      <input type="email" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="아이디" name="userId">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="비밀번호" name="userPw">
                    </div>
                    <div class="error_msg" id="error_msg">
                    	${msg}
                    </div>
                    <a href="javascript:login_action();" role="button" class="btn btn-primary btn-user btn-block">
                      로그인
                    </a>
                    <hr>
                    <a href="index.html" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with Google
                    </a>
                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                    </a>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="find_id">아이디를 잊어버리셨나요?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="find_pw">비밀번호를 잊어버리셨나요?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="register">회원가입을 하고 싶으신가요?</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>
</body>

</html>
