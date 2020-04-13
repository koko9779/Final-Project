//product_create.jsp
var guManager = null;
var guManager2= null;

function productCreate() {
	document.ff.action = "product_create_action";
	document.ff.method = "POST";
	document.ff.submit();
	
	alert("작품 등록 성공!");
};

window.onload = function() {
	var option = {
		listtype: "thumbnail",
		fileid: "uploadScene",
		uploadURL: "upload",
		maxFileCount: 1,
		maxFileSize: 3,
		afterFileTransfer: afterFileTransfer
	}
	guManager = new guUploadManager(option);
	
	var option2 = {
			listtype: "thumbnail",
			fileid: "uploadScene2",
			uploadURL: "upload",
			maxFileCount: 10,
			maxFileSize: 3,
			afterFileTransfer: afterFileTransfer2
	}
	guManager2 = new guUploadManager(option2);
}

function formSubmit(){
	guManager.uploadFiles();
	guManager2.uploadFiles();
	
	return ;
}

function afterFileTransfer(realname, filename, filesize){

	var realname9 = document.getElementById( 'realname' );
	var filename9 = document.getElementById( 'filename' );
	var filesize9 = document.getElementById( 'filesize' );
	
	realname9.value = realname;
	filename9.value = filename;
	filesize9.value = filesize;
	
	var spl = realname9.value.split('.');
	
	if(spl[1] != "jpg" && spl[1] != "png") {
		document.form1.submit();
	}
	else {
		alert("이미지 파일만 올려주세요");
	}
}

function afterFileTransfer2(realname2, filename2, filesize2){
	
	var realname9 = document.getElementById( 'realname2' );
	var filename9 = document.getElementById( 'filename2' );
	var filesize9 = document.getElementById( 'filesize2' );
	
	realname9.value = realname2;
	filename9.value = filename2;
	filesize9.value = filesize2;
	
	var spl = realname9.value.split('.');
	
	if(spl[1] != "jpg" && spl[1] != "png") {
		document.form1.submit();
	}
	else {
		alert("이미지 파일만 올려주세요");
	}
}

function work_search() {
	location.href = 'work_select';
	//window.open('work_select');
	//window.close();
};

/*
$(window).on("load", function() {
	$('.f').validate({
		rules : {
			wdEpisode : {
				required : true,
				idCk : true,
				isIdExisted : true,
				rangelength : [ 8, 15 ]
			}
		},
		messages : {
			mId : {
				required : "아이디를 입력해주세요",
				idCk : "아이디는 영문 대소문자, 숫자로 이루어져야 합니다",
				isIdExisted : "중복된 아이디가 있습니다",
				rangelength : "아이디는 8자리 이상, 15이하로 구성되어야 합니다"
			},
			mPw : {
				required : "비밀번호를 입력해주세요",
				passwordCk : "영문, 숫자, 특수문자를 조합해서 입력해야 합니다.",
				minlength : "비밀번호는 8자리 이상으로 구성해야 합니다.",
				maxlength : "비밀번호는 16자리 미만으로 구성해야 합니다"
			},
			repeatPw : {
				required : "비밀번호를 확인해주세요",
				equalTo : '비밀번호가 다릅니다.'

			},
			mEmail : {
				required : "이메일을 입력해주세요",
				isEmailExisted : "중복된 이메일입니다",
				email : "이메일 형식으로 입력하셔야합니다."
			},
			mPhone : {
				required : "휴대폰번호를 입력해주세요",
				phoneCk : "핸드폰 번호는 숫자로만 이루어져야 합니다",
				rangelength : "핸드폰 번호는 10~11 숫자로 이루어져야 합니다"
			}
		},
		submitHandler : function() {
			member_create();
		},
		errorClass : "error_msg",
		validClass : "valid"
	});
	$.validator.addMethod("idCk", function(value, element) {
		return /^.*[a-zA-Z0-9]$/.test(value);
	});
	$.validator.addMethod("isIdExisted", function(value, element) {
		var check = -1;
		$.ajax({
			url : "Id_check",
			type : 'POST',
			data : "mId=" + value,
			async : false,
			dataType : "json",
			success : function(resultCount) {
				check = resultCount;
			}
		});
		if (check === 1) {
			return false;
		} else {
			return true;
		}
	});
	$.validator.addMethod("passwordCk", function(value, element) {
		return /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(value);
	});
	$.validator.addMethod("phoneCk", function(value, element) {
		return /^.*[0-9]$/.test(value);
	});
	$.validator.addMethod("isEmailExisted", function(value, element) {
		var result = -1;
		$.ajax({
			url : "email_check",
			method : 'POST',
			data : {
				mEmail : value
			},
			dataType : "json",
			async : false,
			success : function(resultCount) {
				result = resultCount;
			}
		});
		if (result === 1) {
			return false;
		} else {
			return true;
		}
	});
	function member_create() {
		document.getElementById("registerF").action = "member_create_action";
		document.getElementById("registerF").submit();
		alert("가입 성공");
	}
});
*/

function execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
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

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				// document.getElementById("sample6_extraAddress").value = extraAddr;

			} else {
				//document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById("pAddress").value = addr;

			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("pDaddress").focus();
		}
	}).open();
}