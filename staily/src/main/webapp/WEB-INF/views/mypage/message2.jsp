<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form id="fmNoteWrite" name="fmNoteWrite" action="note_send.php"
		method="POST">
		<h1 class="note">
			<strong class="nick">가나마바사아</strong>님의 <strong class="page">새쪽지쓰기</strong>입니다.
		</h1>
		<div id="noteWrite">
			<div class="hidden" style="display: none;">
				<input type="hidden" name="rurl"
					value="http%3A%2F%2Fwww.inven.co.kr%2Fmember%2Fnote%2F%3Ffolder%3Dinbox">
				<input type="hidden" name="toinven" value=""> <input
					type="hidden" name="reply" value="0"> <input type="hidden"
					name="noteflag" value="1586497979">
			</div>
			<table class="content" border="0" cellpadding="0" cellspacing="0">
				<colgroup>
					<col class="th">
					<col class="td">
				</colgroup>
				<tbody>
					<tr>
						<td class="label">닉네임</td>
						<td class="value"><input class="nick" type="text" id="nick"
							name="nick" value=""></td>
					</tr>

					<tr>
						<td class="label">제목</td>
						<td class="value"><input class="title" type="text" id="title"
							name="title" value=""></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td class="value"><textarea class="content" id="content"
								name="content"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="command">
				<a id="aNoteCancel"
					href="http://www.inven.co.kr/member/note/?folder=inbox"
					onfocus="this.blur();" class="bttn46">취소</a> <a id="aNoteSave"
					href="javascript:memberNote1.save();" onfocus="this.blur();"
					class="bttn92w">쪽지보내기</a>
			</div>
		</div>
	</form>
</body>
</html>