//product_create.jsp
var guManager = null;
var guManager2 = null;


function afterFileTransfer(realname, filename, filesize) {

	var realname9 = document.getElementById('realname');
	var filename9 = document.getElementById('filename');
	var filesize9 = document.getElementById('filesize');

	realname9.value = realname;
	filename9.value = filename;
	filesize9.value = filesize;
	
	document.createP.submit();
}

function productCreate() {
	guManager.uploadFiles();
	document.createP.action = "product_create_action";
	document.createP.method = "POST";
	alert("상품 등록이 완료되었습니다.");	
};

function pdImageCreate() {
	document.createP.action = "pdImage_create";
	document.createP.method = "post";
}



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
		success : function(data) {
			var a = '';

			for (i = 0; i < data.length; i++) {
				a += "<div class='row'>";
				a += "<h4 class='no-underline'>" + data[i].mId;
				a += "<button onClick='deleteReply(" + data[i].rNo + ", " + data[i].mNo + ")' class='btn btn-ghost' style='float: right;'>삭제</button></h4>";
				a += "<p>" + data[i].rContent + "</p>";
				a += "<button onClick='incReport(" + data[i].rNo + ")' class='btn btn-ghost' style='float: right;'>신고 " + data[i].rReport + "</button>";
				a += "<button onClick='incRec(" + data[i].rNo + ")' class='btn btn-ghost' style='float: right;' value='" + data[i].rNo + "'>추천 " + data[i].rRecommend + "</button>";
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

	//alert(pNo + ' : ' + mNo + ' : ' + rContent + ' : ' + wNo);

	$.ajax({
		url : "reply_create",
		type : "post",
		dataType : "text",
		data : {
			"mNo" : mNo,
			"wNo" : wNo,
			"pNo" : pNo,
			"rContent" : rContent
		},
		error : function(request, error) {
	    	 alert("fail");
	 			// error 발생 이유를 알려준다.
	 		 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	},
		success : function(data) {			
			getReplies();
			$('#rContent').val('');
		}
	});
});

function deleteReply(rNo, mNo) {
	var replyNo = rNo;
	var pNo = $('#pNoo').val();
	var myNo = $('#mNo').val();
	var memNo = mNo;
	
	//alert(rNo + " " + pNo + " " + mNo);
	//alert("나 : " + myNo + " 댓글 작성자 : " + memNo);
	
	if(confirm("댓글을 삭제하시겠습니까?") == true) {
		if(myNo == memNo) {
			$.ajax({
				url : "reply_delete",
				data : {"rNo" : replyNo, "pNo" : pNo, "mNo" : myNo},
				type : "post",
				dataType : "json",
				success : function(data) {
					if(data == 1) {
						alert("댓글이 삭제되었습니다.");
						getReplies();
					}
					else {
						alert("오류가 발생했습니다.");
						getReplies();
					}
				}
			});
		}
		else {
			alert("다른 사람의 댓글은 삭제할 수 없습니다.");
		}
		
	}
	else {
		return false;
	}
	
}

function incReport(rNo) {
	var myNo = $('#mNo').val();
	
	if(myNo == '') {
		alert("신고하려면 로그인하세요.");
	}
	else {
		
	}
}

function incRec(rNo) {
	var myNo = $('#mNo').val();
	
	if(myNo == '') {
		alert("추천하려면 로그인하세요.");
	}
	else {
		
	}
}

//친구 추가
$('#searchDropdwon a:nth-child(1)').click(function(e){
	e.preventDefault();
	var html = "";
	var params = {
			"mNo" : $('#searchMessage').attr('value'),
			"mId" : $('#addFriend').attr('value')
	}
		
	$.ajax({
		url : "../mypage/friend_create",
		data : params,
		dataType : "json",
		success : function(result){
			if(result.status == 'success'){
				alert('친구 추가 완료');

				//location.reload();
			}else if(result.status == 'D'){
				alert('이미 친구 추가된 회원입니다');
			}else if(result.status =='M'){
				alert('본인은 친구추가가 불가능합니다');
			}
			
		},
		error : function(){
			location.href = '404';
		}
		
	});
});

$('#searchword').on("click", function(e){
	var mId = $('#searchword').val();
	
	var html = ""
		$.ajax({
    		url : "../mypage/friend_find",
    		data : "mId="+mId,
    		dataType : "json",
    		success : function(result){
    			if(result.status == 'success'){
    				//$('#results').prepend('<button class="btn btn-primary dropdown-toggle add" data-toggle="dropdown">'
    				//							+result.mId+'</button>')	
    				$('#searchMessage').attr('value',result.mNo);
    				$('#addFriend').attr('value',result.mId);
    				
    			}else{
    				$('#noId').text('회원 아이디를 다시 확인해주세요');	
    				//alert('회원 아이디를 다시 확인해주세요');
    			}
    		},
    		error : function(){
    			location.href = '404';
    		}
    	});
	    	
	
});

//쪽지 보내기
$('#searchDropdwon a:nth-child(2)').click(function(e){
	e.preventDefault();
	var noV = $(this).attr('value');
	window.open("../mypage/message?mNo="+noV, "_blank","width=750, height=5500, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
});