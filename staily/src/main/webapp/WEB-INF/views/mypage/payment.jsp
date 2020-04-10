<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp"%>
<html>

<head>
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
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
					<h1 class="h3 mb-2 text-gray-800">결제페이지</h1>
					<!-- DataTales Example -->
					<div class="join-step2">
						<!--<div class="text-header">기본정보 ( * 필수 입력 항목)</div>-->
						<div class="border border-secondary">
							<form id="memberInfoFrm" name="memberInfoFrm" autocomplete="off">
								<input type="hidden" name="mNo" id="mNo" value="${member.mNo}">
								<input type="hidden" name="mId" id="mId" value="${member.mId}">
								<input type="hidden" name="mName" id="mName"
									value="${member.mName}"> <input type="hidden"
									name="mType" id="mType" value="${member.mType}"> <input
									type="hidden" name="mPhone" id="mPhone"
									value="${member.mPhone}">
								<table class="table table-hover">
									<colgroup>
										<col class="col_wp25">
										<col class="col_auto">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="mName">※ 아이디</label></th>
											<td class="text-left">${member.mId}</td>
										</tr>
										
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="mName">※ 이름</label></th>
											<td class="text-left">${member.mName}</td>
										</tr>
										<c:if test="${member.mType =='C'}">
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="mName">※ 사업자등록번호</label></th>
											<td class="text-left">${member.mCompany.coNo}</td>
										</tr>
										</c:if>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="joinPwd">※ 비밀번호</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col-4">
														<input type="password" name="mPw" id="mPw"
															class="form-control" autocomplete="new-password" value=""
															maxlength="15">
													</div>
												</div>
												<div>* 영문, 숫자, 특수문자중 2가지 포함하여 8자리 이상, 16자리 미만으로 구성해야
													합니다.</div>
											</td>
										</tr>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="joinNewPwdCheck">※ 비밀번호 확인</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col-4">
														<input type="password" name="repeatPw" id="repeatPw"
															class="form-control" autocomplete="new-password" value=""
															maxlength="15">
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<th scope="row" class="bg-light essentia"><label>※
													결제여부</label></th>
											<td class="text-left">${member.mCompany.coCheck}</td>
										</tr>

										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="phnno1N1">※ 휴대폰</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col">
														<select class="hphead hp form-control"
															id="cellphoneTelecom" name="cellphoneTelecom">
															<option value="01">SKT</option>
															<option value="02">KT</option>
															<option value="03">LGU+</option>
															<option value="04">알뜰폰 SKT</option>
															<option value="05">알뜰폰 KT</option>
															<option value="06">알뜰폰 LGU+</option>
														</select>
													</div>
													<div class="col">
														<select class="hphead hp form-control" id="phnno1N1"
															name="phnno1N1">
															<option selected="selected" value="010">010</option>
															<option value="011">011</option>
															<option value="016">016</option>
															<option value="018">018</option>
															<option value="019">019</option>
														</select>
													</div>
													<div class="col">
														<input type="text" name="phnno1N2" id="phnno1N2"
															class="hphead form-control" value="8030" maxlength="4">
															
													</div>
													<div class="col">
														<input type="text" name="phnno1N3" id="phnno1N3"
															class="hphead form-control" value="3348" maxlength="4">
													</div>
												</div>

											</td>
										</tr>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="email1">※이메일</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col">
														<input type="text" name="mEmail" id="mEmail"
															class="form-control" value="${member.mEmail}"
															maxlength="20">
													</div>

												</div>

											</td>
										</tr>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="mAddress">※주소</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col">
														<input type="text" name="mAddress" id="mAddress" 
														 onclick="sample6_execDaumPostcode()" value="${member.mAddress}"
															class="form-control" 
															maxlength="20">
													</div>

												</div>

											</td>
										</tr>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="daddress">※기타주소</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col">
														<input type="text" name="mDaddress" id="mDaddress"
															class="form-control" value="${member.mDaddress}"
															maxlength="20">
													</div>

												</div>

											</td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>

						<br>
						<div class="text-center">
							<button type="button"
								class="btn btn-default btn-lg io-data io-fn-nextStep"
								data-step="2" onclick="member_update()">수정</button>
						</div>
					</div>


					<!-- DataTales Example -->
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
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
function member_update(){
	if($('#mPw').val() != $('#repeatPw').val()){
		alert("비밀번호가 일치하지 않습니다");
		return;
	}
	alert("수정완료");
	document.getElementById("memberInfoFrm").action = "member_update";
	document.getElementById("memberInfoFrm").submit();
}
</script>
	<script type="text/javascript">
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
	            document.getElementById("mAddress").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("mDaddress").focus();
	        }
	    }).open();
	}
	
function register_action(){
  $('#mPw').keyup(function() {
		var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
		
		if(!getCheck.test($('#inputPw').val())){
			alert("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
			return;
		}
	});
  
  $('#repeatPw').keyup(function() {
		var getCheck = RegExp(/^[a-zA-Z0-9]{6,10}$/);
		
  		if($('#mPw').val() != $('#repeatPw').val()) {
  			alert("비밀번호가 일치하지 않습니다");
			return;
  		}
   });
  
  
  $('#mEmail').keyup(function() {
	  var getCheck = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
	  
	  if(!getCheck.test($("#mEmail").val())){
		  alert("이메일 형식으로 입력해주세요");
		  return;
	  }
   });
  
  $('#mPhone').keyup(function() {
	  var getCheck = RegExp(/^[0-9]{9,11}$/);
	  
	  if(!getCheck.test($("#mPhone").val())){
		  alert("알맞은 전화번호를 입력해주세요");
		  return;
   		}
	});
  
  	if($('#mPw').val() != $('#repeatPw').val()){
		alert("비밀번호가 일치하지 않습니다");
		return;
	}
	alert("수정완료");
	document.getElementById("memberInfoFrm").action = "member_update";
	document.getElementById("memberInfoFrm").submit();
  }
  

		/*
		$(function() {
			//유효성확인
			$('#memberInfoFrm').validate({
				rules : {
					userid : {
						required : true,
						minlength : 5,
						maxlength : 10
					},
					joinPwd : {
						required : true,
						minlength : 8,
						maxlength : 15
					}
					/*
					mName : {
						required : true,
						minlength : 8,
						maxlength : 15
					},
					mEmail : {
						email : true
					}
					*/
					/*
				},
				messages : {
					userid : {
						required : "아이디를 입력하세요",
						minlength : "{0}글자 이상 입력하세요",
						maxlength : "{0}글자 이하 입력하세요"
					},
					joinPwd : {
						required : "비밀번호를 입력하세요",
						minlength : "{0}글자 이상 입력하세요",
						maxlength : "{0}글자 이하 입력하세요"
					},
					mName : {
						required : "이름을 입력하세요",
						minlength : "{0}글자 이상 입력하세요",
						maxlength : "{0}글자 이하 입력하세요"
					}
					/*
					mEmail : {
						email : "이메일을 입력하세요"
					}
					*/
					/*
				},
				submitHandler : function() {
					member_update();
				},
				errorClass : "error",
				validClass : "valid"
			});
			
			$('#memberInfoFrm').on('submit',function(e){
				alert("ff");
			})
		})
		*/
	</script>

	<!-- Bootstrap core JavaScript-->
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script
		src="../../../${pageContext.request.contextPath}/css/admin/js/demo/datatables-demo.js"></script>

</body>

</html>
