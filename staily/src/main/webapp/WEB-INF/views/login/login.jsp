<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/login/include/include_top_login.jsp" %>

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
                    <div class="margin">
                      <input type="text" class="form-control form-control-user" id="inputId" placeholder="아이디" name="userId">
                    </div>
                    <div>
                      <input type="password" class="form-control form-control-user" id="inputPw" placeholder="비밀번호" name="userPw">
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
                    <a class="small" href="id_read">아이디를 잊어버리셨나요?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="pw_count_read">비밀번호를 잊어버리셨나요?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="member_create">회원가입을 하고 싶으신가요?</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>
 <%@ include file="/WEB-INF/views/login/include/include_bottom_login.jsp" %>
<script type="text/javascript">
$(function() {
	var id = $("#findIdE").val();
	if(id === "" || id === undefined) {
		return;
	}else {
		alert("고객님의 아이디는 " + id + "입니다");
		location.href="login";
		return;
	}
});
</script>
 
   </body>

</html> 