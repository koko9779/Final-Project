<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include
	file="/WEB-INF/views/admin/include/include_top_without_sidebar.jsp"%>

<style>
image {
	margin: auto;
}

.w-100 {
	width: 400px;
	height: 300px;
}
</style>
<form id="product_detail" name="product_detail" method="post">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<input type="hidden" name="pNo" id="pNo" value="${productList[0].pNo}">
		<input type="hidden" name="mNo" id="mNo" value="${productList[0].mNo}">
		<input type="hidden" name="wNo" id="wNo" value="${productList[0].wNo}">
		<input type="hidden" name="pView" id="pView"
			value="${productList[0].pView}"> <input type="hidden"
			name="pScene" id="pScene" value="${productList[0].pScene}"> <input
			type="hidden" name="pDate" id="pDate" value="${productList[0].pDate}">
		<input type="hidden" name="pCheck" id="pCheck"
			value="${productList[0].pCheck}">
		<c:forEach var="product" items="${productList }">
			<input type="hidden" name="pdNo" id="pdNo" value="${product.pdNo }">
		</c:forEach>
		<table class="table table-hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
				<c:forEach var="product" items="${productList }">
					<tr>
						<th scope="row" class="bg-light essentia"></th>
						<th scope="row" class="bg-light essentia"><label for="pCheck">상품선택</label>
						</th>
						<td class="text-left"><input type="checkbox" name="pCheck"></td>
						<td class="text-left">
							<div class="col">
								<img width="350" height="200"
									src="${pageContext.request.contextPath}${product.pdImage }">
							</div>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<th scope="row" class="bg-light essentia"></th>
					<th scope="row" class="bg-light essentia"><label for="pdImage">
							상품 이미지<br>(최대 10장)
					</label></th>
					<td class="text-left"></td>
					<td class="text-left">
						<div class="col">
							<div id="uploadScene" style="width: 100%;"></div>
							<input type="hidden" id="realname" name="realname" /> 
							<input type="hidden" id="filename" name="filename" /> 
							<input type="hidden" id="filesize" name="filesize" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="text-center">
			<button type="submit" value="submit"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2"
				onclick="product_update()">수정</button>
			<button type="button"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2"
				onclick="product_confirm(${productList[0].pNo})">승인</button>
		</div>
</form>
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
<script type="text/javascript">
window.onload = function() {
	var option = {
		listtype : "thumbnail",
		fileid : "uploadScene",
		uploadURL : "upload",
		maxFileCount : 10,
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
	
	document.fff.action = "pdImage_create_action";
	document.fff.submit();
	
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
	guManager.uploadFiles();
}

</script>
</html>
