/*
 * path : 전송 URL
 * params : 전송 데이터 {'q':'a','s':'b','c':'d'...}으로 묶어서 배열 입력
 * method : 전송 방식(생략가능)
 */
function post_to_url(path, params, method) {
    method = method || "post"; // Set method to post by default, if not specified.
    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
    for(var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]);
        form.appendChild(hiddenField);
    }
    document.body.appendChild(form);
    form.submit();
}

function board_delete(bNo) {
	var replyArray = document.querySelectorAll(".reply");
	if(replyArray.length > 0) {
		var isOk = confirm("게시글을 지우면 댓글들도 모두 지워집니다 정말 지우시겠습니까?");
		
		if(isOk) {
			post_to_url("style_board_delete_action", {"bNo" : bNo});
		}
	}else {
		post_to_url("style_board_delete_action", {"bNo" : bNo});
	}
	
}

function board_modify(bNo) {
	$.ajax({
		url: "board_one_for_udate_read",
		type: 'get',
		data: {"bNo" : bNo},
		async : false,
		dataType: "json",
		success: function(boardJson) {
							$("#board").html("<h3 class='board-top'>스타일 질문</h3>" +
									 "<form name='boardWriteF' onSubmit='return false;'>" +
												"<div class='row justify-content-md-center'>" +
													"제목" +
													"<input type='text' name='bTitle' class='form-control' value='" + boardJson.bTitle + "'>" +
													"<select class='custom-select' name='bType' id='inputGroupSelect03'>" +
													"<option value='Q'>문의</option>" +
													"<option selected value='S'>스타일코디</option>" +
													"</select>" +
												"</div>" +
												"<div class='row justify-content-md-center'>" +
													"<textarea id='contents' name='bContent'>" + boardJson.bContent + "</textarea>" +
													"<script>" +
														"CKEDITOR.replace('contents',{" +
															"filebrowserUploadUrl : '/staily/style/ImgUpload'" +
														"});" +
													"</script>" +
												"</div>" +
												"<div class='row justify-content-md-center'>" +
													"<button type='submit' class='btn btn-ghost' " + 
															"style='width: 20%; font-weight: bold; margin-top: 15px;' " + 
															"onclick='boardCreate();'>" + 
														"등 록" + 
													"</button>" +
												"</div>" +
										"</form>");	
				}
	});
}

function reply_delete(bNo, boardCount) {
	
	$.ajax({
		url: "style_reply_delete_action",
		type: 'post',
		data: {"bNo" : bNo},
		async : false,
		dataType: "json",
		success: function(isDelete) {
			if(isDelete === false) {
				alert("댓글 삭제에 실패하였습니다");
			}else {
				if(boardCount = 2) {
					$(".reply-delete").fadeOut();
				}else {
					$("#board_"+bNo).fadeOut();
				}
			}
		}
	});
	
}

function boardCreate() { 
	CKEDITOR.instances.contents.updateElement(); 
	if(document.boardWriteF.bTitle.value === "") { 
		alert("제목을 입력해 주세요"); 
		return; 
	}else if(document.boardWriteF.bType.value === "분류") { 
		alert("분류를 지정해 주세요"); 
		return; 
	}else if(document.boardWriteF.bContent.value === "") { 
		alert("내용을 입력해 주세요"); 
		return; 
	}else {
		document.boardWriteF.action = "${pageContext.request.contextPath}/style/style_create_board_action";
		document.boardWriteF.method = "POST";
		document.boardWriteF.submit();	
	} 
}

