<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp" %>

<html>
  
<head>
<style type="text/css">
	.check_register {
  		margin-top: -0.8rem;
	    margin-bottom: 0.4rem;
	    margin-left: 0.7rem;
	    font-size: 12px;
	    color: red;
     }
</style>
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
  	function register_action() {
  		/*
  		var id = $('#inputId').val();
  		var pw = $('#inputPw').val();
  		var pw2 = $('#repeatPw').val();
  		var name = $('#InputName').val();
  		var email = $('#InputEmail').val();
  		var address = $('#InputAddress').val();
  		var daddress = $('#InputDaddress').val();
  		var phone = $('#InputPhone').val();
  		*/
  		
  		var getCheck = RegExp(/^[a-zA-Z0-9]{6,10}$/);
  		
  		//alert($('#').val());
  		
  		if(!getCheck.test($('#inputId').val())){
  			alert('아이디는 대소문자와 숫자만 입력가능하고, 6 ~ 10자 사이입니다');
  			return;
  		}else if ($('#inputPw').val() != $('#repeatPw').val()) {
  			alert("비밀번호가 일치하지 않습니다")
  			return;
  		}
  		else if (!getCheck.test($('#inputPw').val())){
  			alert("비밀번호는 대소문자와 숫자만 입력가능하고, 6 ~ 10자 사이입니다.");
  			return;
  		}
  		
  		document.registerF.action = "register_action";
  		document.registerF.method = "POST";
  		document.registerF.submit();
  	}
  	
  </script>
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원 가입</h1>
              </div>
              <form name="registerF" class="user">
              <input type="hidden" name="mType" value="M">
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="inputId" name="mId" placeholder="아이디">
                </div>
                 <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="inputPw" name="mPw" placeholder="패스워드">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="repeatPw" placeholder="패스워드 확인">
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="inputName" name="mName" placeholder="이름">
                </div>
                <div class="form-group">
                  <input type="email" class="form-control form-control-user" id="inputEmail" name="mEmail" placeholder="이메일">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="inputAddress" name="mAddress" placeholder="주소">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="inputDaddress" name="mDaddress" placeholder="상세주소">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="inputPhone" name="mPhone" placeholder="'-'  없이 핸드폰번호 입력해주세요">
                </div>
                <div class="check_register" id="check_register">
                	여기에 유효성검사 결과 나올거에용
                </div>
                <a href="javascript:register_action();" role="button" class="btn btn-primary btn-user btn-block">
                  회원가입
                </a>
                <hr>
                <a href="index.html" class="btn btn-google btn-user btn-block">
                  <i class="fab fa-google fa-fw"></i> Register with Google
                </a>
                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                  <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                </a>
              </form>
              <hr>
              <div class="text-center">
                <a class="small" href="forgot-password.html">Forgot Id?</a>
              </div>
              <div class="text-center">
                <a class="small" href="forgot-password.html">Forgot Password?</a>
              </div>
              <div class="text-center">
                <a class="small" href="login">Already have an account? Login!</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript">
	  $('#inputId').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
			
			if(!getCheck.test($('#inputId').val())){
				$('#check_register').css("color", "red");
				$('#check_register').html("아이디는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
				return;
			}else {
				$('#check_register').css("color", "white");
				return;
			}
		});
	  
	  $('#inputPw').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
			
			if(!getCheck.test($('#inputPw').val())){
				$('#check_register').css("color", "red");
				$('#check_register').html("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
				return;
			}else {
				$('#check_register').css("color", "white");
			}
		});
	  
	  $('#repeatPw').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{6,10}$/);
			
	  		if($('#inputPw').val() != $('#repeatPw').val()) {
	  			$('#check_register').css("color", "red");
				$('#check_register').html("비밀번호가 일치하지 않습니다");
				return;
	  		}else {
	  			$('#check_register').css("color", "white");
	  		}
	   });
	  
	  $('#inputName').keyup(function() {
		  var koreanCheck = RegExp(/^[가-힣]{2,10}$/);
		  var englichCheck = RegExp(/^[a-zA-Z]{5,25}$/); // 영문이름 당최 어찌 주어야할까 글자수
		  
		  if(!koreanCheck.test($("#inputName").val()) && !englichCheck.test($("#inputName").val())){
			  $('#check_register').css("color", "red");
			  $('#check_register').html("이름은 한글로 2 ~ 10글자 사이, 영어로 5~ 25글자 사이여야 합니다");
		  }else {
			  $('#check_register').css("color", "white");
		  }
	   });
	  
	  $('#inputEmail').keyup(function() {
		  var getCheck = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
		  
		  if(!getCheck.test($("#inputEmail").val())){
			  $('#check_register').css("color", "red");
			  $('#check_register').html("이메일 형식으로 입력해주세요");
		  }else {
			  $('#check_register').css("color", "white");
		  }
	   });
	  
	  $('#inputPhone').keyup(function() {
		  var getCheck = RegExp(/^[0-9]{9,11}$/);
		  
		  if(!getCheck.test($("#inputPhone").val())){
			  $('#check_register').css("color", "red");
			  $('#check_register').html("알맞은 전화번호를 입력해주세요");
		  }else {
			  $('#check_register').css("color", "white");
		  }
	   });
	  
  </script>
</body>

</html>
