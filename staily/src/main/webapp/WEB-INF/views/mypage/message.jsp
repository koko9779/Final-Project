<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/mypage/include/include_message_top.jsp" %>

<body class="bPopup">
	<script>
		INVEN.Popup.resizeWindowBody(747, 510);
	</script>

	<div id="noteWrap">
		<div id="noteLeft">
			<dl class="menu">
				<dt>쪽지함</dt>
				<dd>
					<ul>
						<li class="selected"><span class="orange"><a
								href="message?mNo=" ${member.mNo} onfocus="this.blur();">쪽지 보내기</a></span></li>
						<li class=" oldstart"><span class="orange"><a
								href="message_list" onfocus="this.blur();">받은 쪽지함</a></span></li> 
					</ul>
				</dd>
			</dl>
		</div>
		<div id="noteMain">

			<form id="fmNoteWrite" name="fmNoteWrite" action="message_create"
				method="POST">
				<h1 class="note">
					<strong class="page">새쪽지쓰기</strong>
				</h1>
				<div id="noteWrite">
					<div class="hidden" style="display: none;">
						<input type="hidden" name="rNo" value="${member.mNo}">
					</div>
					<table class="content" border="0" cellpadding="0" cellspacing="0">
						<colgroup>
							<col class="th">
							<col class="td">
						</colgroup>
						<tbody>
							<tr>
								<td class="label">아이디</td>
								<td class="value"><input class="nick" type="text" id="mId"
									name="mId" value="${member.mId}"></td>
							</tr>
							<tr>
								<td class="label">제목</td>
								<td class="value"><input class="title" type="text"
									id="msTitle" name="msTitle" value="" maxlength="15"></td>
							</tr>
							<tr>
								<td class="label">내용</td>
								<td class="value"><textarea class="content" id="msContent"
										name="msContent"></textarea></td>
							</tr>
						</tbody>
					</table>
					<div class="command">
						<a id="aNoteCancel" href="#" onfocus="this.blur();" class="bttn46">취소</a>
						<a id="aNoteSave" href="#" onfocus="this.blur();" class="bttn92w">쪽지보내기</a>
					</div>
				</div>
			</form>

		</div>

	</div>
	<script type="text/javascript">
		$(function() {
			$('#aNoteSave').click(function(e){
				e.preventDefault();
				var mId = $('#mId').val();
				var msTitle = $('#msTitle').val();
				var msContent = $('#msContent').val();

				if(mId ==""){
					alert('아이디를 입력하세요');
					return;
				}
				
				if (msTitle == "") {
					alert('제목을 입력하세요');
					return;
				}
				if (msContent == "") {
					alert('내용을 입력하세요');
					return;
				}
				
				$.ajax({
					url : 'message_create',
					data : $('#fmNoteWrite').serializeArray(),
					dataType : 'text',
					success : function(result){
						if(result == 'true'){
							alert('보내기 완료');
							location.href = 'message_list';
						}else if(result == 'N'){
							alert('정확한 아이디를 입력해주세요');
							return;
						}
					},
					error : function(){
						location.href = 'message';
					}
				})
			});
			
			
			$('#aNoteCancel').click(function(e) {
				window.close();
				e.preventDefault();
			});

		})
	</script>

	<div id="comFloatAlert" style="display: none;">
		<ul class="textlist">
		</ul>
	</div>
</body>
</html>