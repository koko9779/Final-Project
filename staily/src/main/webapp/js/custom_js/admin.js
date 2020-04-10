/**
 * 
 * 
 */


function execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			// document.getElementById('new_address_zipcode').value =
			// data.zonecode;
			document.getElementById("mAddress").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("mDaddress").focus();
		}
	}).open();
}
$(window)
		.on(
				"load",
				function() {
					/** *****멤버 펑션 시작********** */
					
					$('#memberInfoFrm').validate({
						rules:{
							mPw:{
								required: true,
								passwordCk : true,
								minlength: 8,
								maxlength: 15
							},
							repeatPw:{
								required: true,
								equalTo : '#mPw'
								
							},
							mEmail:{
								required: true,
								email : true
							}
							
						},
						messages:{
							mPw:{
								required: "비밀번호를 입력해주세요",
								passwordCk: "영문, 숫자, 특수문자를 조합해서 입력해야 합니다.",
								minlength:"비밀번호는 8자리 이상으로 구성해야 합니다." ,
								maxlength:"비밀번호는 16자리 미만으로 구성해야 합니다"
							},
							repeatPw:{
								required: "비밀번호를 확인해주세요",
								equalTo : '비밀번호가 다릅니다.'
								
							},
							mEmail:{
								required: "이메일을 입력해주세요",
								email : "이메일 형식으로 입력하셔야합니다."
							}
						},
						submitHandler:function(){
							member_update();
						},
						errorClass:"error_validate",
						validClass:"valid"
					});
					$.validator.addMethod("passwordCk",  function( value, element ) {
						   return this.optional(element) ||  /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(value);
						});
					function member_update() {
						alert("수정완료");
						document.getElementById("memberInfoFrm").action = "member_update";
						document.getElementById("memberInfoFrm").submit();
					}
					$(".mCheckBtn")
							.click(
									function(e) {

										var checkBtn = $(this);
										var tr = checkBtn.parent().parent();
										var td = tr.children();
										var no = td.eq(1).text();
										window
												.open("member_update?" + "mNo="
														+ no, "회원정보수정",
														"width=870, height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes")
									});
					
					$("#mSelectBtn")
							.click(
									function() {
										var checkbox = $("input[name=member_CheckBox]:checked");
										var tdArray = new Array();
										checkbox
												.each(function(i) {
													var tr = checkbox.parent()
															.parent().eq(i);
													var td = tr.children();
													var mNo = td.eq(1).text();
													var noArray = 'noArray='
															+ mNo + '-';
													console.log(noArray);
													$
															.ajax({
																url : 'member_delete',
																data : noArray,
																method : 'POST',
																success : function(
																		result) {
																	if (result
																			.trim() == 'success') {
																		alert("회원 삭제를 완료하였습니다.");
																		location
																				.reload();
																	}
																}
															});
												});
									});

					function execDaumPostcode() {
						new daum.Postcode(
								{
									oncomplete : function(data) {
										var addr = ''; // 주소 변수
										var extraAddr = ''; // 참고항목 변수

										// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
										if (data.userSelectedType === 'R') { // 사용자가
											// 도로명
											// 주소를
											// 선택했을
											// 경우
											addr = data.roadAddress;
										} else { // 사용자가 지번 주소를 선택했을 경우(J)
											addr = data.jibunAddress;
										}
										// 우편번호와 주소 정보를 해당 필드에 넣는다.
										// document.getElementById('new_address_zipcode').value
										// = data.zonecode;
										document.getElementById("mAddress").value = addr;
										// 커서를 상세주소 필드로 이동한다.
										document.getElementById("mDaddress")
												.focus();
									}
								}).open();
					}
					/** *****멤버 펑션 끝********** */
					/** *****상품 펑션 시작********** */

					$("#pSelectBtn")
							.click(
									function() {
										var checkbox = $("input[name=product_CheckBox]:checked");
										var tdArray = new Array();
										checkbox.each(function(i) {
											var tr = checkbox.parent().parent()
													.eq(i);
											var td = tr.children();
											var pNo = td.eq(1).text();
											var noArray = 'noArray=' + pNo
													+ '-';
											console.log(pNo);
											console.log(noArray);
											/*
											 * $.ajax({ url : 'member_delete',
											 * data : noArray, method : 'POST',
											 * dataType : "text", success :
											 * function(result) {
											 * location.reload(); }
											 */
										});
									});
					/** *****상품 펑션 끝********** */

				});