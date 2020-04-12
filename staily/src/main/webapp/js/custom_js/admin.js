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
$(window).on("load",function() {
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
						submitHandler:function(f){
							$.ajax({
								url: f.action,
								data: $(f).serializeArray(),
								dataType: 'text',
								success: function() {
									alert("회원정보 수정이 완료되었습니다");
									window.opener.location.reload();
									window.close();
								}
							});
						},
						errorClass:"error_validate",
						validClass:"valid"
					});
					$.validator.addMethod("passwordCk",  function( value, element ) {
						   return this.optional(element) ||  /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(value);
						});
					$(".mCheckBtn").click(
							function(e) {
								var checkBtn = $(this);
								var tr = checkBtn.parent().parent();
								var td = tr.children();
								var no = td.eq(1).text();
								window.open("member_select?" + "mNo="+ no, "회원정보수정",
											"width=870, height=800, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
									});
					$("#mSelectBtn").click(
							function() {
								var checkbox = $("input[name=member_CheckBox]:checked");
								var tdArray = new Array();
								checkbox.each(function(i) {
										var tr = checkbox.parent().parent().eq(i);
										var td = tr.children();
										var mNo = td.eq(1).text();
										var noArray = 'noArray='+ mNo + '-';
										$.ajax({
												url : 'member_delete',
												data : noArray,
												method : 'POST'
										});
								});
								alert("회원 삭제를 완료하였습니다.");
								location.reload();
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
					$(".pCheckBtn").click(
							function() {
								var checkBtn = $(this);
								var tr = checkBtn.parent().parent();
								var td = tr.children();
								var no = td.eq(1).text();
								console.log(no);
								window.open("product_select?" + "pNo="+ no, "상품정보수정",
											"width=685, height=685, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
									});	
					$("#pSelectBtn").click(
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
					$('#slider-div').slick({
						slide: 'div',		//슬라이드 되어야 할 태그 ex) div, li 
						infinite : true, 	//무한 반복 옵션	 
						slidesToShow : 1,		// 한 화면에 보여질 컨텐츠 개수
						slidesToScroll : 1,		//스크롤 한번에 움직일 컨텐츠 개수
						speed : 100,	 // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
						arrows : true, 		// 옆으로 이동하는 화살표 표시 여부
						dots : false, 		// 스크롤바 아래 점으로 페이지네이션 여부
						autoplay : true,			// 자동 스크롤 사용 여부
						autoplaySpeed : 5000, 		// 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
						pauseOnHover : true,		// 슬라이드 이동	시 마우스 호버하면 슬라이더 멈추게 설정
						vertical : false,		// 세로 방향 슬라이드 옵션
						prevArrow : "<button type='button' class='slick-prev'>Previous</button>",		// 이전 화살표 모양 설정
						nextArrow : "<button type='button' class='slick-next'>Next</button>",		// 다음 화살표 모양 설정
						dotsClass : "slick-dots", 	//아래 나오는 페이지네이션(점) css class 지정
						draggable : true, 	//드래그 가능 여부 
						pade: true,
						responsive: [ // 반응형 웹 구현 옵션
							{  
								breakpoint: 960, //화면 사이즈 960px
								settings: {
									//위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
									slidesToShow:1
								} 
							},
							{ 
								breakpoint: 768, //화면 사이즈 768px
								settings: {	
									//위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
									slidesToShow:1 
								} 
							}
						]

					});
					$('.slider-for').slick({
				          autoplay: true, //자동슬라이드
				          slidesToShow: 1, //큰이미지 몇개 보여줄것인지
				          slidesToScroll: 1,
				          arrows: true,
				          fade: false,
				          centerMode: true,
				          variableWidth: true,
				          variableHeight: true,
				          centerPadding: "50px",
				          asNavFor: '.slider-nav',
				       });
				       $('.slider-nav').slick({
				          slidesToShow: 3, //작은이미지 몇개 보여줄것인지..
				          slidesToScroll: 1,
				          centerMode: true,
				          centerPadding: "50px",
				          variableWidth: true,
				          variableHeight: true,
				          asNavFor: '.slider-for',
				          focusOnSelect: true,
				       });
					/** *****상품 펑션 끝********** */

});

