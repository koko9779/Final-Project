<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function check() {
		var mPw = $('#mPw').val();
		var repeatPw = $('#repeatPw').val();
		var mEmail = $('#mEmail').val();
		var mAddress = $('#mAddress').val();
		var mDaddress = $('#mDaddress').val();
		var phn1 = $('#phn1').val();
		var phn2 = $('#phn2').val();
		var phn3 = $('#phn3').val();

		//이메일 체크
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if (!regExp.test(mEmail)) {
			alert('이메일을 입력하세요');
			return;
		}
		
		if(mPw != repeatPw){
			alert('비밀번호가 일치하지 않습니다');
			return;
		}else if(mPw == "" || repeatPw == ""){
			alert('비밀번호를 입력하세요');
			return;
		}
		
		//비밀번호 체크
		var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
		if(!getCheck.test(mPw)){
			alert("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
			return;
		}
		
		//주소 체크
		if(mAddress == ""){
			alert('주소를 입력하세요');
			return;
		}
		
		//상세주소 체크
		if(mDaddress == ""){
			alert('상세주소를 입력하세요');
			return;
		}
		
		//전화번호 체크
		if(phn1 == ""){
			alert("전화번호를 입력하세요");
			return;
		}
		if(phn2 == ""){
			alert("전화번호를 입력하세요");
			return;
		}
		if(phn3 == ""){
			alert("전화번호를 입력하세요");
			return;
		}
		
		alert('회원정보가 수정되었습니다');
		document.getElementById("memberInfoFrm").action = "member_update";
		document.getElementById("memberInfoFrm").submit();
		

	}

	function execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
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
</script>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">회원정보페이지</h1>
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
												<div>* 비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다</div>
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
										<c:if test="${member.mType =='C'}">
										<tr>
											<th scope="row" class="bg-light essentia"><label>※
													결제여부</label></th>
											<td class="text-left">${member.mCompany.coCheck}</td>
										</tr>
										</c:if>
										<tr>
											<th scope="row" class="bg-light essentia"><label
												for="phnno1N1">※ 휴대폰</label></th>
											<td class="text-left">
												<div class="form-row">
													<div class="col">
														<select class="hphead hp form-control" id="phn1"
															name="phn1">
															<option selected="selected" value="010">010</option>
															<option value="011">011</option>
															<option value="016">016</option>
															<option value="018">018</option>
															<option value="019">019</option>
														</select>
													</div>
													<div class="col">
														<input type="text" name="phn2" id="phn2"
															class="hphead form-control" value="${phn2}" maxlength="4"
															onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">

													</div>
													<div class="col">
														<input type="text" name="phn3" id="phn3"
															class="hphead form-control" value="${phn3}" maxlength="4"
															onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
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
															onclick="execDaumPostcode()" value="${member.mAddress}"
															class="form-control" maxlength="20">
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
								class="btn btn-outline btn-primary pull-right"
								data-step="2" onclick="check()">수정</button>
						</div>
					</div>


					<!-- DataTales Example -->
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>
