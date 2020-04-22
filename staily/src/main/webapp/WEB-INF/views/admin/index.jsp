
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp"%>

<!-- Page Heading -->
<div class="col-lg-10">
	<h1 class="h3 mb-2 text-gray-800">임시로 메인씁네다</h1>
	<button type="button" onclick="calendar()">달력테스트</button>
	<div class="row">
		<div class="col-xl-6 col-lg-6"
			style="float: left; margin-right: 10px;">
			<!-- Area Chart -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">일별 접속자</h6>
				</div>
				<div class="card-body">
					<div class="chart-area">
						<canvas id="dayChart"></canvas>
					</div>
				</div>
				<form>
					<p>
						<input type="date" id="currentDate">
					</p>
					<p>
						<input type="submit" value="기준날짜설정">
					</p>
				</form>
			</div>
		</div>
		<!-- Pie Chart -->
		<div class="col-xl-4 col-lg-4" style="float: left;">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">브라우저별 접속자</h6>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-pie pt-4">
						<canvas id="browserChart"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->

<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
<script>
var now = document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);;
var nowTime = "stTime="+now

$(function() {
	var statsData;
	$.ajax({
		url: "stats",
		data: nowTime,
		dataType:"json",
		async:false,
		success:function(result){
				statsData = result
			}
	});
	// 우선 컨텍스트를 가져옵니다. 
	var ctx = document.getElementById("dayChart").getContext('2d');
	var cty = document.getElementById("browserChart").getContext('2d');
	/*
	 - Chart를 생성하면서, 
	 - ctx를 첫번째 argument로 넘겨주고, 
	 - 두번째 argument로 그림을 그릴때 필요한 요소들을 모두 넘겨줍니다. 
	 */
	console.log(statsData,'찍혀라 제발...');
	var browserChart = new Chart(cty, {
		type : 'pie',
		data : {
			labels : [ "크롬", "MSIE", "파이어폭스", "안드로이드", "사파리" ],
			datasets : [ {
				label : '일자별 접속자 수',
				data : [ 12, 31, 3, 5, 2 ],
				backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)', 'rgba(255, 159, 64, 0.2)' ],
				borderColor : [
				//'rgba(255, 99, 132, 0.2)', 빨강
				'rgba(54, 162, 235, 0.2)'
				//'rgba(255, 206, 86, 0.2)', 노랑
				//'rgba(75, 192, 192, 0.2)', 초록
				//'rgba(153, 102, 255, 0.2)' 
				//'rgba(255, 159, 64, 0.2)' 오렌지
				],
				borderWidth : 1
			} ],
		},
		options : {
			maintainAspectRatio : true, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
	var dayChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : [ "4월20일", "4월21일", "4월22일", "4월23일", "4월24일", "4월25일" ],
			datasets : [ {
				label : '일자별 접속자 수',
				data : [ 12, 199, 3, 5, 2, 3 ],
				backgroundColor : [
				//'rgba(255, 99, 132, 0.2)', 빨강
				//'rgba(54, 162, 235, 0.2)', 파랑
				//'rgba(255, 206, 86, 0.2)', 노랑
				//'rgba(75, 192, 192, 0.2)', 초록
				'rgba(153, 102, 255, 0.2)'
				//'rgba(255, 159, 64, 0.2)' 오렌지
				],
				datasets : [ {
					fill : 'origin'
				}, // 0: fill to 'origin'
				{
					fill : '+2'
				}, // 1: fill to dataset 3
				{
					fill : 1
				}, // 2: fill to dataset 1
				{
					fill : false
				}, // 3: no fill
				{
					fill : '-2'
				} // 4: fill to dataset 2
				],
				borderColor : [
				//'rgba(255, 99, 132, 0.2)', 빨강
				'rgba(54, 162, 235, 0.2)'
				//'rgba(255, 206, 86, 0.2)', 노랑
				//'rgba(75, 192, 192, 0.2)', 초록
				//'rgba(153, 102, 255, 0.2)' 
				//'rgba(255, 159, 64, 0.2)' 오렌지
				],
				borderWidth : 1
			} ],
		},
		options : {
			maintainAspectRatio : true, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
});

	function calendar() {
		window
				.open(
						"calendar",
						"일정표",
						"width=690, height=750, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no");
	}
	
</script>
</html>