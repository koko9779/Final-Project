/**
 * 
 */
$(window).on("load", function() {
	
	//버튼 클릭시 Row 값 가져오기
	$(".mCheckBtn").click(function(e){ 
		
	    var checkBtn = $(this);
	    var tr = checkBtn.parent().parent();
	    var td = tr.children();
	    var no = td.eq(1).text();
	    window.open("member_update?"+"mNo="+no,"회원정보수정","width=870, height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes")
	});
	$("#selectBtn").click(function(){ 
	    var checkbox = $("input[name=user_CheckBox]:checked");
	    // 체크된 체크박스 값을 가져온다
	    var tdArray = new Array();
	    checkbox.each(function(i) {
	        // checkbox.parent() : checkbox의 부모는 <td>이다.
	        // checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
	        var tr = checkbox.parent().parent().eq(i);
	        var td = tr.children();
	        var mNo = td.eq(1).text();
	        var noArray = 'noArray='+mNo+'-';
	        $.ajax({
	    		url:'member_delete',
	    		data:noArray,
	    		method:'POST',
	    		dataType: "text",
	    		success:function(result){
	    			 location.reload();
	    			}		
	    		});
	    	});
	    });
	function member_update() {
		if ($('#mPw').val() != $('#repeatPw').val()) {
			alert("비밀번호가 일치하지 않습니다");
			return;
		}
		alert("수정완료");
		document.getElementById("memberInfoFrm").action = "member_update";
		document.getElementById("memberInfoFrm").submit();
	}
	function check() {
		var mPw = $('#mPw').val();
		var repeatPw = $('#repeatPw').val();
		var mEmail = $('#mEmail').val();

		//이메일 체크
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if (regExp.test(mEmail)) {
			//alert('잘입력했어요');
		} else {
			alert('이메일 형식으로 입력하세요');
			return false;
		}
		
		if(mPw != repeatPw || mPw == "" || repeatPw == ""){
			alert('비밀번호가 일치하지 않습니다');
			return;
		}
		
		//비밀번호 체크
		var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
		if(getCheck.test(mPw)){
			
		}else{
			alert("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
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
});