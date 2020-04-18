<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/include_css.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product_create.css"/>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/gu-upload/css/guupload2.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gu-upload/guuploadManager2.js"></script>
</head>
<body>
	<div style="margin: 5%;">
		<form name="pdImage" method="post">
			<table class="table table=hover">
				<colgroup>
					<col class="col_wp25">
					<col class="col_auto">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pdImage">
								상품 이미지<br>(최대 10장)
						</label></th>
						<td class="text-left">
							<div class="col">
								<div id="uploadScene2" style="width: 100%;"></div>
								<input type="hidden" id="realname2" name="realname2" /> 
								<input type="hidden" id="filename2" name="filename2" /> 
								<input type="hidden" id="filesize2" name="filesize2" />
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="wNo" name="wNo" value="${wNo}"/>
			<div class="wrap" style="height: auto;">
				<button class="button_css" type="button" onClick="ImageCreate()">올리기</button>
				<button class="button_css" type="button" onClick="javascript:location.href='work_select'">돌아가기</button>
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
window.onload = function() {
	var option2 = {
		listtype : "thumbnail",
		fileid : "uploadScene2",
		uploadURL : "upload2",
		maxFileCount : 10,
		maxFileSize : 3,
		afterFileTransfer : afterFileTransfer2
	}
	guManager2 = new guUploadManager2(option2);	
}

function afterFileTransfer2(realname2, filename2, filesize2) {

	var realname9 = document.getElementById('realname2');
	var filename9 = document.getElementById('filename2');
	var filesize9 = document.getElementById('filesize2');

	realname9.value = realname2;
	filename9.value = filename2;
	filesize9.value = filesize2;
	
	document.pdImage.action = "pdImage_create_action";
	document.pdImage.submit();
	
	/*
	var spl = realname9.value.split('.');
	console.log(spl);
	
	if (spl[1] != "jpg" && spl[1] != "png") {
		document.form1.submit();
	} else {
		alert("이미지 파일만 올려주세요");
	}
	*/
}

function ImageCreate() {
	guManager2.uploadFiles();
}

</script>
</html>