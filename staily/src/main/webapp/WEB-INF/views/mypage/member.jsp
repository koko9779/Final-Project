<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp"%>

<html>

<head>
<!-- Bootstrap core JavaScript-->
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script
	src="${pageContext.request.contextPath}/css/admin/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/datatables/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script
	src="${pageContext.request.contextPath}/css/admin/js/demo/datatables-demo.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>

<script type="text/javascript">
	function member_update() {
		alert("수정완료");
		//document.getElementById("member_up").action = "member_update";
		//document.getElementById("member_up").submit();
	}

	function submit_check() {
		var isaName = $("#mNo").val();
		var isaAddress = document.f.aAddress.value;
		var isaAddressDetail = document.f.aAddressDetail.value;
		var isaPhone = document.f.aPhone.value;
		var isaMemo = document.f.aMemo.value;
		var isPayment_method = document.f.payment_method.value;

		if (isaName == null || isaName == "") {
			alert("받는 사람을 입력하세요.");
			return false;
		}

		if (isaAddress == null || isaAddress == "") {
			alert("배송주소를 입력하세요.");
			return false;
		}

		if (isaAddressDetail == null || isaAddressDetail == "") {
			alert("상세주소를 입력하세요.");
			return false;
		}

		if (isaPhone == null || isaPhone == "") {
			alert("연락가능한 전화번호를 입력하세요.");
			return false;
		}

		if (isPayment_method == null || isPayment_method == "") {
			alert("지불 방법을 선택하세요.");
			return false;
		}

		return true;

	}
</script>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
		<%@ include file="/WEB-INF/views/mypage/include/include_nav.jsp"%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">




						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">관리자</span> <img
								class="img-profile rounded-circle"
								src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">회원관리페이지</h1>

					<!-- DataTales Example -->
					<div>
						<form class="form-horizontal">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="inputEmail3"
										placeholder="Email">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="checkbox">
										<label> <input type="checkbox"> Remember me
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-default">Sign in</button>
								</div>
							</div>
						</form>
						<!-- 
			<form id="member_up" name="member_up">
				mNo<input type="text" name="mNo" id="mNo" value="${member.mNo}" readonly="readonly"><br>
				mId<input type="text" name="mId" id="mId" value="${member.mId}"><br>
				mPw<input type="text" name="mId" id="mId" value="${member.mPw}"><br>
				mName<input type="text" name="mId" id="mId" value="${member.mName}"><br>
				mAddress<input type="text" name="mAddress" id="mAddress" value="${member.mAddress}"><br>
				mDaddress<input type="text" name="mDaddress" id="mDaddress" value="${member.mDaddress}"><br>
				mEmail<input type="text" name="mEmail" id="mEmail" value="${member.mEmail}"><br>
				mType<input type="text" name="mType" id="mType" value="${member.mType}"><br>
				mPhone<input type="text" name="mPhone" id="mPhone" value="${member.mPhone}"><br>
				<input type="button" value="멤버수정" id="modify">
			</form>
			 -->
					</div>



					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2019</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>


		<script type="text/javascript">
			$(function() {
				//유효성확인
				$('#member_up').validate({
					rules : {
						mId : {
							required : true,
							minlength : 5,
							maxlength : 10
						},
						mPw : {
							required : true,
							minlength : 8,
							maxlength : 15
						}
					},
					messages : {
						mId : {
							required : "아이디를 입력하세요",
							minlength : "{0}글자 이상 입력하세요",
							maxlength : "{0}글자 이하 입력하세요"
						},
						mPw : {
							required : "비밀번호를 입력하세요",
							minlength : "{0}글자 이상 입력하세요",
							maxlength : "{0}글자 이하 입력하세요"
						}
					},
					submitHandler : function() {
						member_update();
					},
					errorClass : "error",
					validClass : "valid"
				});
			})
		</script>
</body>

</html>