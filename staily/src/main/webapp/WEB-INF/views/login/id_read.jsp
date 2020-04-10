<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/login/include/include_top_login.jsp" %>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>아이디 찾기</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/css/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/css/admin/css/sb-admin-2.min.css" rel="stylesheet">

   <!-- Javascript -->
    <script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
    
	<script type="text/javascript">
		function find_id() {
			var name = $("#inputName").val();
			var phone = $("#inputPhone").val();
			
			if(name == "" || phone == ""){
				alert("이름과 번호를 입력해주세요");
				return;
			}
			
			document.forgotIdF.action = "id_read_action";
			document.forgotIdF.method= "POST";
			document.forgotIdF.submit();
		}
		
		$(function() {
			var msgE = $("#msgE").val();
			if(msgE === "") {
				return;
			}else {
				alert(msgE);
				location.href = "id_read"
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
              <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-2">아이디를 잊어버리셨나요?</h1>
                    <p class="mb-4">회원가입 시 입력하셨던 이름과 전화번호<br>(혹은 핸드폰번호)를 입력하시면<br> 아이디를 찾을 수 있습니다</p>
                  </div>
                  <input type="hidden" value="${msg}" id="msgE">
                  <form name="forgotIdF" class="user">
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="inputName" name="name" placeholder="이름">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="inputPhone" name="phone" placeholder="'-' 없이 전화번호 or 핸드폰번호">
                    </div>
                    <a href="javascript:find_id();" class="btn btn-primary btn-user btn-block">
                      아이디 찾기
                    </a>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="member_create">회원가입을 하고 싶으신가요?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="login">계정이 있으신가요? 로그인하러 갑시다!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/css/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/css/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/css/admin/js/sb-admin-2.min.js"></script>

</body>

</html>
