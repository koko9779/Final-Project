<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>

<!-- Hero -->
<div id="content_hero"
	style="background-image: url(http://via.placeholder.com/1440x435)">

	<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg"
		alt="Scroll down" class="scroll" />

	<!-- Content -->
	<div class="container">
		<div class="row blurb scrollme animateme" data-when="exit"
			data-from="0" data-to="1" data-opacity="0" data-translatey="100">
			<div class="col-md-9">
				<span class="title">The very latest</span>
				<h1>Cinema news</h1>
			</div>
		</div>
	</div>

</div>

<!-- Section -->
<div class="container-fluid">
	<div class="row">
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
                      <input type="text" class="form-control form-control-user" id="inputId" placeholder="아이디" name="userId" onkeyup="loginKeyup();">
                    </div>
                    <div>
                      <input type="password" class="form-control form-control-user" id="inputPw" placeholder="비밀번호" name="userPw" onkeyup="loginKeyup();">
                    </div>
                    <div class="error_msg" id="error_msg">
                    	${msg}
                    </div>
                    <a href="javascript:login_action();" role="button" class="btn btn-primary btn-user btn-block">
                    	 로그인
                    </a>
                    <hr>
                    <a href="${url}" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with Naver
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
		<!-- -->
		
	</div>
</div>
<%@ include file="/WEB-INF/views/include/include_js.jsp"%>
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>


</html>