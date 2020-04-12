<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/login/include/include_top_login.jsp" %>

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
                    <input type="password" class="form-control form-control-user" id="repeatPw" name="repeatPw" placeholder="패스워드 확인">
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
                <a class="small" href="id_read">아이디를 잊어버리셨나요?</a>
              </div>
              <div class="text-center">
                <a class="small" href="pw_count_read">비밀번호를 잊어버리셨나요?</a>
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
  /*
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
		  var englichCheck = RegExp(/^[a-zA-Z]{5,25}$/); 
		  
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
*/
  </script>
 <%@ include file="/WEB-INF/views/login/include/include_bottom_login.jsp" %>
   </body>

</html> 
