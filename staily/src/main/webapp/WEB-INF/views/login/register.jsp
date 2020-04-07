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
  <script type="text/javascript">
  	function register_action() {
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
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
              <form name="registerF" class="user">
              <input type="hidden" name="mType" value="M">
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="InputId" name="mId" placeholder="Write id here">
                </div>
                 <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="inputPw" name="mPw" placeholder="Write password here">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="repeatPw" placeholder="Repeat password">
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="InputName" name="mName" placeholder="Write name Here">
                </div>
                <div class="form-group">
                  <input type="email" class="form-control form-control-user" id="InputEmail" name="mEmail" placeholder="Write email here">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="InputAddress" name="mAddress" placeholder="Write address here">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="InputDaddress" name="mDaddress" placeholder="Write detail address here">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" id="InputPhone" name="mPhone" placeholder="Write phone number without  '-'">
                </div>
                <a href="javascript:register_action();" role="button" class="btn btn-primary btn-user btn-block">
                  Register Account
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
</body>

</html>
