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
}

function afterFileTransfer(realname, filename, filesize) {

	var realname9 = document.getElementById('realname');
	var filename9 = document.getElementById('filename');
	var filesize9 = document.getElementById('filesize');

	realname9.value = realname;
	filename9.value = filename;
	filesize9.value = filesize;
	
	document.ff.submit();
}


function pdImageCreate() {
	document.ff.action = "pdImage_create";
	document.ff.method = "post";
}

function productCreate() {
	guManager.uploadFiles();
	document.ff.action = "product_create_action";
	document.ff.method = "POST";
	document.ff.submit();
	alert("상품 등록이 완료되었습니다.");	
};

function work_search() {
	location.href = 'work_select';
};

function execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
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
				// document.getElementById("sample6_extraAddress").value =
				// extraAddr;

			} else {
				// document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById("pAddress").value = addr;

			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("pDaddress").focus();
		}
	}).open();
};

// product_detail.jsp
$("#reply").on("click", function(e) {
	getReplies();
});

function getReplies() {
var pNo = $('#pNo').val();
	
	$.ajax({
		url : "reply_list",
		type : "POST",
		data : {"pNo" : pNo},
		dataType : "json",
		async : false,
		success : function(data) {
			var a = '';

			for (i = 1; i < data.length; i++) {
				a += "<div class='row'>";
				a += "<h4 class='no-underline'>" + data[i].mName;
				a += "<button class='btn btn-ghost' style='float: right;'>삭제</button></h4>";
				a += "<p>" + data[i].rContent + "</p>";
				a += "<button class='btn btn-ghost' style='float: right;'>추천</button>";
				a += "<button class='btn btn-ghost' style='float: right;'>신고</button>";
				a += "</div>";
			}
			
			$('#reply_space').html(a);
		}
	});
};


$('#createreply').on("click", function(e) {
	var pNo = $('#pNoo').val();
	var wNo = $('#wNo').val();
	var mNo = $('#mNo').val();
	var rContent = $('#rContent').val();

	alert(pNo + ' : ' + mNo + ' : ' + rContent + ' : ' + wNo);

	$.ajax({
		url : "reply_create",
		type : "GET",
		async : false,
		dataType : "text",
		data : {
			"mNo" : mNo,
			"wNo" : wNo,
			"pNo" : pNo,
			"rContent" : rContent
		},
		success : function(data) {
			colsole.log(data);
			getReplies();
			$('#rContent').val('');
		}
	});
});


/*
function createreply() {
	document.rpl.action = "reply_create";
	document.rpl.method = "post";
	document.rpl.submit();
};
*/