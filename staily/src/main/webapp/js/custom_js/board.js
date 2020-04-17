var clone;
var h3ReplyHeader;
$(function() {
	clone = $("#board2").clone();
	h3ReplyHeader = $("#reply-top").clone();
});

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
function reply_write_form() {
	//$("#boardReplyWriteF").slideToggle();
	var display = $("#boardReplyWriteF").css("display");
	if(display === "none") {
		$("#boardReplyWriteF").fadeIn(500);
	}else {
		$("#boardReplyWriteF").fadeOut(500);
	}
}

function board_and_reply_modify(bNo) {
	$.ajax({
		url: "board_one_for_udate_read",
		type: 'get',
		data: {"bNo" : bNo},
		async : false,
		dataType: "json",
		success: function(boardJson) {
							$('#board').fadeOut(500, function() {
								$("#board").html("<h3 class='board-top'>스타일 질문</h3>" +
										 "<form name='boardWriteF' onSubmit='return false;'>" +
										 			"<input type='hidden' id='bNo' name='bNo' value='" + bNo + "'>" +
													"<div class='row justify-content-md-center'>" +
														"제목" +
														"<input type='text' id='bTitle' name='bTitle' class='form-control title_detail' value='" + boardJson.bTitle + "'>" +
														"<select class='custom-select form-control' name='bType' id='inputGroupSelect03'>" +
														"<option selected value='S'>스타일코디</option>" +
														"</select>" +
														"<select class='custom-select form-control' name='bCategory' id='bCategory'>" + 
														"<option selected>카테고리</option>" +
														"<option value='M'>영화</option>" +
														"<option value='D'>드라마</option>" +
														"</select>"	+
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
																"onclick='board_and_reply_modify_action();'>" + 
															"등 록" +
														"</button>" +
														"<button type='submit' id='canselB' class='btn btn-ghost' " + 
															"style='width: 20%; font-weight: bold; margin-top: 15px;' " + 
															"onclick='cansle_update();'>" + 
															"취 소" +
														"</button>" +
													"</div>" +
											"</form>");	
								$("#board").find("#bCategory").val(boardJson.bCategory);
								
								$( "#board" ).fadeIn( 500 );
					        });
				}
	});
}

function cansle_update() {
	
}

function cancel_reply_write() {
	// 내용 초기화가 안되유 ㅠㅠ
	$("#boardReplyWriteF").fadeOut(500);
}


function reply_write() {
	CKEDITOR.instances.contents.updateElement(); 
	if(document.boardReplyWriteF.bTitle.value === "") { 
		alert("제목을 입력해 주세요"); 
		return; 
	}else if(document.boardReplyWriteF.bType.value === "분류") { 
		alert("분류를 지정해 주세요"); 
		return; 
	}else if(document.boardReplyWriteF.bContent.value === "") { 
		alert("내용을 입력해 주세요"); 
		return; 
	}else if(document.boardReplyWriteF.bCategory.value === "카테고리") { 
		alert("카테고리를 지정해 주세요"); 
		return; 
	}else {
		$.ajax({
			url: "style_reply_create",
			type: 'post',
			data: {bNo : bNo,
				   bTitle : bTitle,
				   bContent : bContent,
				   bCategory : bCategory},
			async : false,
			dataType: "json",
			success: function(replyCreate) {
					
					clone.find("#board_title_read").html(replyCreate.bTitle);
					clone.find("#board_content_read").html(replyCreate.bContent);
					clone.find("#board_content_read").html(replyCreate.mId);
					$('#board').fadeOut( 500, function() {
						$("#board").empty();
						$("#board").append(clone);
						$( "#board" ).fadeIn( 500 );
			        });
			}
		});
	}
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

function board_create() { 
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
	}else if(document.boardWriteF.bCategory.value === "카테고리") { 
		alert("카테고리를 지정해 주세요"); 
		return; 
	}else {
		document.boardWriteF.action = "style_create_board_action";
		document.boardWriteF.method = "POST";
		document.boardWriteF.submit();
	} 
}

function board_and_reply_modify_action() {
	CKEDITOR.instances.contents.updateElement(); 
	var bNo = $("#bNo").val();
	var bTitle = $("#bTitle").val();
	var bContent = $("#contents").val();
	var bCategory = $("#bCategory").val();
	
	var boardBNo = $("#updateBNo").val();


	if(document.boardWriteF.bTitle.value === "") { 
		alert("제목을 입력해 주세요"); 
		return; 
	}else if(document.boardWriteF.bContent.value === "") { 
		alert("내용을 입력해 주세요"); 
		return; 
	}else if(document.boardWriteF.bCategory.value === "카테고리") { 
		alert("카테고리를 지정해 주세요"); 
		return; 
	}else {
		$.ajax({
			url: "style_board_and_reply_update",
			type: 'post',
			data: {bNo : bNo,
				   bTitle : bTitle,
				   bContent : bContent,
				   bCategory : bCategory},
			async : false,
			dataType: "json",
			success: function(updateBoard) {
				clone.find("#board_title_read").html(updateBoard.bTitle);
				clone.find("#board_content_read").html(updateBoard.bContent);
				$('#board').fadeOut( 500, function() {
					$("#board").empty();
					$("#board").append(clone);
					$( "#board" ).fadeIn( 500 );
		        });
			}
		});
	}
}
