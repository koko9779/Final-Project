<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include
	file="/WEB-INF/views/admin/include/include_top_without_sidebar.jsp"%>
<style>
image {
	margin: auto;
	height: 500px;
}

</style>
<form id="work_update" name="work_update" method="post">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div id="slider-div">
					<div>
						<img
							src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/${work.wPoster }" height="300px" >
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" name="wNo" id="wNo" value="${work.wNo}"> 
		<input type="hidden" name="wTepisode" id="wTepisode" value="${work.wTepisode}"> 
		<input type="hidden" name="wView" id="wView" value="${work.wView}"> 
		<input type="hidden" name="wPoster" id="wPoster" value="${work.wPoster}"> 
		<table class="table table-hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pName">
							작품이름</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="wName" id="wName" class="form-control"
								value="${work.wName}" maxlength="20">
						</div>
					</td>
				</tr>

				<tr >
					<th scope="row" class="bg-light essentia"><label for="pPrice">
							카테고리</label></th>
					<td class="text-left">
						<div class="col">
						<c:if test="${work.wCategory =='D'}">
							<input type="text" name="wCategory" id="wCategory" class="form-control"
								value="드라마" maxlength="20">
						</c:if>		
						<c:if test="${work.wCategory =='M'}">
							<input type="text" name="wCategory" id="wCategory" class="form-control"
								value="영화" maxlength="20">
						</c:if>		
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="mName">
							상영일</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="wDate" id="wDate" class="form-control"
								value="${work.wDate}">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label>
							총회차</label></th>
					<td class="text-left" align="left">
						<div class="col">${work.wTepisode}</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label>
							조회수</label></th>
					<td class="text-left" align="left">
						<div class="col">${work.wView}</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="text-center">
			<button type="submit" value="submit" id="wUpdateBtn"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2" >수정</button>
			<button type="button" 
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2" onclick="window_close()">닫기</button>
		</div>
</form>
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
</html>
