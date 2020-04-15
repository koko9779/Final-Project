//product_create.jsp
var guManager = null;
var guManager2 = null;

window.onload = function() {
	
	var option = {
		listtype : "thumbnail",
		fileid : "uploadScene",
		uploadURL : "upload",
		maxFileCount : 1,
		maxFileSize : 3,
		afterFileTransfer : afterFileTransfer
	}
	guManager = new guUploadManager(option);
	
	/*
	$.ajax({
		url: "pNo_nextval",
		dataType: "json",
		error: function() {
			alert("에러");
		},
		success: function(data) {
			alert(data);
			alert("성공");
		}
	});
	*/		
	
}

function afterFileTransfer(realname, filename, filesize) {

	var realname9 = document.getElementById('realname');
	var filename9 = document.getElementById('filename');
	var filesize9 = document.getElementById('filesize');

	realname9.value = realname;
	filename9.value = filename;
	filesize9.value = filesize;

	document.fff.submit();
	/*
	var spl = realname9.value.split('.');
	alert(realname9.value);
	if (spl[1] == "jpg" || spl[1] == "png") {
		document.ff.submit();
	} else {
		alert("이미지 파일만 올려주세요");
	}	
 	*/
}


function pdImageCreate() {
	window.open('pdImage_create', 'width=600, height=400, resizable=no, toolbars=no, menubar=no');
}

function productCreate() {
	//document.ff.action = "upload";
	//document.ff.method = "POST";
	//document.ff.submit();
	
	guManager.uploadFiles();
	//guManager2.uploadFiles();
	
};

function work_search() {
	location.href = 'work_select';
	//window.open('work_select');
	//window.close();
};

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