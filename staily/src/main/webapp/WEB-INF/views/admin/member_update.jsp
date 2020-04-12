<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<head>
<%@ include file="/WEB-INF/views/admin/include/include_css.jsp"%>
</head>
<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">회원정보페이지</h1>
<!-- DataTales Example -->
<div class="join-step2">
	<!--<div class="text-header">기본정보 ( * 필수 입력 항목)</div>-->
	<div class="border border-secondary">
		<form id="memberInfoFrm" name="memberInfoFrm" autocomplete="off" action="member_update" method="post">
			<input type="hidden" name="mNo" id="mNo" value="${member.mNo}">
			<input type="hidden" name="mId" id="mId" value="${member.mId}">
			<input type="hidden" name="mName" id="mName" value="${member.mName}">
			<input type="hidden" name="mType" id="mType" value="${member.mType}">
			<input type="hidden" name="mPhone" id="mPhone"
				value="${member.mPhone}">
			<table class="table table-hover">
				<colgroup>
					<col class="col_wp25">
					<col class="col_auto">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="mName">※
								아이디</label></th>
						<td class="text-left">${member.mId}</td>
					</tr>

					<tr>
						<th scope="row" class="bg-light essentia"><label for="mName">※
								이름</label></th>
						<td class="text-left">${member.mName}</td>
					</tr>
					<c:if test="${member.mType =='C'}">
						<tr>
							<th scope="row" class="bg-light essentia"><label for="mName">※
									사업자등록번호</label></th>
							<td class="text-left">${member.mCompany.coNo}</td>
						</tr>
					</c:if>
					<tr>
						<th scope="row" class="bg-light essentia"><label
							for="joinPwd">※ 비밀번호</label></th>
						<td class="text-left">
							<div class="form-row">
								<div class="col-4">
									<input type="password" name="mPw" id="mPw" class="form-control"
										autocomplete="new-password" value="" maxlength="15">
								</div>
							</div> <small>* 영문, 숫자, 특수문자중 2가지 포함하여 8자리 이상, 16자리 미만으로 구성해야
								합니다.</small>
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
					<tr>
						<th scope="row" class="bg-light essentia"><label
							for="phnno1N1">※ 휴대폰</label></th>
						<td class="text-left">
							<div class="form-row">
								<div class="col">
									<select class="hphead hp form-control" id="cellphoneTelecom"
										name="cellphoneTelecom">
										<option value="01">SKT</option>
										<option value="02">KT</option>
										<option value="03">LGU+</option>
										<option value="04">알뜰폰 SKT</option>
										<option value="05">알뜰폰 KT</option>
										<option value="06">알뜰폰 LGU+</option>
									</select>
								</div>
								<div class="col">
									<select class="hphead hp form-control" id="phn1" name="phn1">
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
						<th scope="row" class="bg-light essentia"><label for="email1">※이메일</label></th>
						<td class="text-left">
							<div class="form-row">
								<div class="col">
									<input type="text" name="mEmail" id="mEmail"
										class="form-control" value="${member.mEmail}" maxlength="20">
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
			<div class="text-center">
				<button type="submit" value="submit"
					class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2">수정</button>
			</div>
		</form>
	</div>

	<br>
</div>


<!-- DataTales Example -->
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>

</html>
