<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp" %>

<html>
  
<head>
<style type="text/css">
	.check_register {
		color: red;
  		margin-top: -0.8rem;
	    margin-bottom: 0.4rem;
	    margin-left: 0.7rem;
	    font-size: 12px;
	    visibility: hidden;
     }
     
    .type-button {
	    color: #fff;
	    background-color: #4e73df;
	    border-color: #4e73df;
	    border-radius: 10rem;
    }
    
    .type-button:hover {
    color: #fff;
    background-color: #2e59d9;
    border-color: #2653d4;
}
    
    .gaip-top {
    	margin-top: 1.5rem
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
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script type="text/javascript">
  	function register_action() {
  		if($("#check_register").css("visibility") === "hidden" &&
  			$("#inputId").val() != "" &&
  			$("#inputPw").val() != ""  &&
  			$("#repeatPw").val() != ""  &&
  			$("#inputName").val() != ""  &&
  			$("#inputEmail").val() != ""  &&
  			$("#inputAddress").val() != ""  &&
  			$("#inputDaddress").val() != ""  &&
  			$("#inputPhone").val() != "" ) {
  			
  			var coNoE = $("#inputCono");
  			
  			if(coNoE != null && coNoE.val() === null) {
  				alert("모든 입력창에 알맞게 정보를 넣어야만 가입 가능합니다");
  				return;
  			}
  			
	  		document.registerF.action = "register_action";
	  		document.registerF.method = "POST";
	  		document.registerF.submit();
  		}else {
  			alert("모든 입력창에 알맞게 정보를 넣어야만 가입 가능합니다");
  		}
  	}
  	
	function sample6_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수

	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }

	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	           // document.getElementById('new_address_zipcode').value = data.zonecode;
	            document.getElementById("inputAddress").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("inputDaddress").focus();
	        }
	    }).open();
	}
	
	function mType_company() {
		var phoneGroupE = document.getElementById("phoneGroupE");
		
		if(document.getElementById("inputCono")==null) {
			$("#inputType").attr("value", "C");
			$("<div class='form-group'>" +
	                "<input type='text' class='form-control form-control-user' id='inputCono' name='coNo' placeholder=\"'-'  없이 사업자등록번호 입력해주세요\">" +
	          "</div>").insertAfter(phoneGroupE);
			return;
		}else {
			return;
		}
	}
	
	function mType_member() {
		var phoneGroupE = document.getElementById("phoneGroupE");
		var coNoE = document.getElementById("inputCono");
		
		if(coNoE!=null) {
			$("#inputType").attr("value", "M");
			coNoE.remove();
		}
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
            <div class="btn-group" role="group">
				<button class="btn btn-secondary type-button" type="button" onclick="mType_member();">
					일반 회원
				</button> 
				<button class="btn btn-secondary type-button" type="button" onclick="mType_company();">
					기업 회원
				</button> 
			</div>
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4 gaip-top">회원 가입</h1>
              </div>
              <form name="registerF" id="registerF" class="user">
              <input type="hidden" id="inputType" name="mType" value="M">
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
                  <input type="text" class="form-control form-control-user" id="inputAddress" name="mAddress" placeholder="주소" onclick="sample6_execDaumPostcode();">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="inputDaddress" name="mDaddress" placeholder="상세주소">
                </div>
                <div class="form-group" id="phoneGroupE">
                  <input type="text" class="form-control form-control-user" id="inputPhone" name="mPhone" placeholder="'-'  없이 핸드폰번호 입력해주세요">
                </div>
                <div class="check_register" id="check_register">
                	오류기입란
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
                <a class="small" href="forgot-password.html">아이디를 잊어버리셨나요?</a>
              </div>
              <div class="text-center">
                <a class="small" href="forgot-password.html">비밀번호를 잊어버리셨나요?</a>
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
  <script type="text/javascript">
	  $('#inputId').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
			
			if(!getCheck.test($('#inputId').val())){
				$('#check_register').css("visibility", "visible");
				$('#check_register').html("아이디는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
				return;
			}else {
				var paramStr = $("#registerF").serialize();
				
				$.ajax({
					url: "Id_check",
					method: 'POST',
					data: paramStr,
					dataType: "json",
					success: function(resultCount) {
								if(resultCount == 1) {
									$('#check_register').html("중복된 아이디가 있습니다");
								}else {
									$('#check_register').css("visibility", "hidden");
								}
							}
				});
				
				
		}
	  });
	  
	  $('#inputPw').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
			
			if(!getCheck.test($('#inputPw').val())){
				$('#check_register').css("visibility", "visible");
				$('#check_register').html("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
				return;
			}else {
				$('#check_register').css("visibility", "hidden");
			}
		});
	  
	  $('#repeatPw').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{6,10}$/);
			
	  		if($('#inputPw').val() != $('#repeatPw').val()) {
	  			$('#check_register').css("visibility", "visible");
				$('#check_register').html("비밀번호가 일치하지 않습니다");
				return;
	  		}else {
	  			$('#check_register').css("visibility", "hidden");
	  		}
	   });
	  
	  $('#inputName').keyup(function() {
		  var koreanCheck = RegExp(/^[가-힣]{2,10}$/);
		  var englichCheck = RegExp(/^[a-zA-Z]{5,25}$/); // 영문이름 당최 어찌 주어야할까 글자수
		  
		  if(!koreanCheck.test($("#inputName").val()) && !englichCheck.test($("#inputName").val())){
			  $('#check_register').css("visibility", "visible");
			  $('#check_register').html("이름은 한글로 2 ~ 10글자 사이, 영어로 5~ 25글자 사이여야 합니다");
		  }else {
			  $('#check_register').css("visibility", "hidden");
		  }
	   });
	  
	  $('#inputEmail').keyup(function() {
		  var getCheck = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
		  
		  if(!getCheck.test($("#inputEmail").val())){
			  $('#check_register').css("visibility", "visible");
			  $('#check_register').html("이메일 형식으로 입력해주세요");
		  }else {
			  var paramStr = $("#registerF").serialize();
				$.ajax({
					url: "email_check",
					method: 'POST',
					data: paramStr,
					dataType: "json",
					success: function(resultCount) {
								if(resultCount == 1) {
									$('#check_register').html("중복된 이메일이 있습니다");
								}else {
									$('#check_register').css("visibility", "hidden");
								}
							}
				});
		  }
	   });
	  
	  $('#inputPhone').keyup(function() {
		  var getCheck = RegExp(/^[0-9]{9,11}$/);
		  
		  if(!getCheck.test($("#inputPhone").val())){
			  $('#check_register').css("visibility", "visible");
			  $('#check_register').html("알맞은 전화번호를 입력해주세요");
		  }else { 
			  $('#check_register').css("visibility", "hidden");
		  }
	   });
	  
  </script>
</body>

</html>
