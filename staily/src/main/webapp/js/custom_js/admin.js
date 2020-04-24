/**
 * 
 * 
 */
/** ***********공용*************** */

function window_close() {
	window.close();
};
function window_back() {
	location.href = document.referrer;
};

/** ***********통계 일반*************** */
function timeChange() {
		var changeTime = $('#currentDate').val();
		var choiceTime = "stTime="+changeTime
		console.log(choiceTime);
			$.ajax({
				url: "stats",
				data: choiceTime,
				dataType:"json",
				async:true,
				success:function(result){
					statsData = result
				}
		});
}
/** ***********작품 일반*************** */

function searchWork() {
	window.open("work_seach", "작품정보수정",
	"width=500, height=800, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
};
function workCreate(i) {
	document.getElementById("searchResult"+i+"").action = "work_create";
	document.getElementById("searchResult"+i+"").submit();
};

function product_confirm(pNo) {
	var no = "pNo="+pNo;
	console.log(pNo);
	$.ajax({
		url: 'product_confirm',
		data: no,
		method: 'POST',
		dataType: 'text',
		success: function() {
			swal({
				   title: "상품이 승인되었습니다..",
				   text: "버튼을 클릭해주세요!",
				   icon: "success" // "info,success,warning,error" 중 택1
				}).then(() => {
					window.opener.location.reload();
					window.close();
				});
		}
	});
};
function sceneUpdate(scn) {
	window.open("product_update_scene?" + "pScene="+ scn,"이미지정보수정",
	"width=500, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
};
function imageUpdate(img) {
	window.open("product_update_img?" + "pdImage="+ img,"이미지정보수정",
	"width=500, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
};
/** ***********주소 일반*************** */

function execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			// document.getElementById('new_address_zipcode').value =
			// data.zonecode;
			document.getElementById("mAddress").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("mDaddress").focus();
		}
	}).open();
};
/** ***********TMDB API************** */
function sucess(item) {
	$('#resultF').empty();
	var content = JSON.parse(item);
	console.log(content);
	var count = content.total_results;
	for (var i = 0; i < count; i++) {
		if(content.results[i].name != null){
			var name = content.results[i].name;
		}else{
			var name = content.results[i].title
		}
		if(content.results[i].first_air_date != null){
			var date = content.results[i].first_air_date
		}else{
			var date = content.results[i].release_date
		}
		if(content.results[i].media_type=='tv'){
			var category = 'D';
		}else{
			var category = 'M';
		}
		var poster = content.results[i].poster_path;
		var overview = content.results[i].overview
		var tag = "";
		tag += "<form id='searchResult"+i+"' name='searchResult"+i+"'>";
		tag += "<input type='hidden' id='wName' name='wName' value='" + name + "'>";
		tag += "<input type='hidden' id='wPoster' name='wPoster' value='" + poster + "'>";
		tag += "<input type='hidden' id='wDate' name='wDate' value='" + date + "'>";
		tag += "<input type='hidden' id='wCategory' name='wCategory' value='" + category + "'>";	
		tag += "<input type='hidden' id='wOverview' name='wOverview' value='" + overview + "'>";	
		tag += "<table>";
		tag += "<tr>";
		tag += "<th></th>";
		tag += "<th hidden='poster'></th>";
		tag += "<th hidden='date'></th>";
		tag += "<th hidden='category'></th>";
		tag += "<th hidden='overview'></th>";
		tag += "<th></th>";
		tag += "</tr>";
		tag += "<tr>";
		tag += "<td>" + name + "</td>";
		tag += "<td hidden='poster2'>" + poster + "</td>";
		tag += "<td hidden='date2'>" + date + "</td>";
		tag += "<td hidden='category2'>" + category + "</td>";
		tag += "<td hidden='overview2'>" + overview + "</td>";
		tag += "</tr>";
		tag += "</table>";
		tag += "<button type='submit' value='submit' class='btn' data-step='2' onclick='workCreate("+i+")'>선택</button>";
		tag += "</form>"
			
			$("#resultF").append(tag);
	}
};
function error(test) {
	console.log('실패~', test);
};
function searchItemM(item) {
	theMovieDb.search.getMulti({
		"query" : item
	}, sucess, error);
};
/** *****멤버 펑션 시작********** */
$(function() {
	$(document).on('click','#mCheckBtn',function(e) {
		var checkBtn = $(this);
		var tr = checkBtn.parent().parent();
		var td = tr.children();
		var no = td.eq(1).text();
		window.open("member_select?" + "mNo="+ no, "회원정보수정",
		"width=695, height=685, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
	});
});
$(function() {
	$(document).on('click','#mSelectBtn',
			function() {
				var checkbox = $("input[name=member_CheckBox]:checked");
				var tdArray = new Array();
				checkbox.each(function(i) {
					var tr = checkbox.parent().parent().eq(i);
					var td = tr.children();
					var mNo = "mNo="+td.eq(1).text();
					$.ajax({
						url : 'member_delete',
						data : mNo,
						method : 'POST',
						success:function(){
							swal({
								title: "회원삭제성공",
								text: "버튼을 클릭해주세요!",
								icon: "success" // "info,success,warning,error" 중 택1
							}).then(() => {
								location.reload();
							});
						}
					});
				});
	});
});
/** *****상품 펑션 시작********** */
$(function() {
	$(document).on('click','#pCheckBtn',function() {
					var checkBtn = $(this);
					var tr = checkBtn.parent().parent();
					var td = tr.children();
					var no = td.eq(1).text();
					window.open("product_select?" + "pNo="+ no, "상품정보수정",
								"width=800, height=685, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
						});	
});
$(function() {
	$(document).on('click','#pUpdate',function() {
		var params = $('#product_detail').serializeArray();
		$.ajax({
			url:"product_update",
			data:params,
			method:'post',
			success: function(result) {
				 if(result == 'success'){
					 swal({
						   title: "상품변경성공",
						   text: "버튼을 클릭해주세요!",
						   icon: "success" // "info,success,warning,error"
											// 중 택1
						}).then(() => {
							window.opener.location.reload();
							window.close();
						});
						// window.opener.location.reload();
						// window.close();
			     }else{
			       	swal({
						   title: "상품변경실패",
						   text: "버튼을 클릭해주세요!",
						   icon: "error" // "info,success,warning,error"
													// 중 택1
					});
			            }
			     },
			     error:function(request, error) {
			    	 swal({
						   title: "상품변경실패",
						   text: "버튼을 클릭해주세요!",
						   icon: "error" // "info,success,warning,error"
											// 중 택1
						});
			 		 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			 	}
		  });
	  });					
});	
$(function() {
	$(document).on('click','#pSelectBtn',function() {
		var checkbox = $("input[name=product_CheckBox]:checked");
		var tdArray = new Array();
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent()
			.eq(i);
			var td = tr.children();
			var pNo = 'pNo='+td.eq(1).text();
			$.ajax({
				url : 'product_delete',
				data : pNo,
				method : 'POST',
				success:function(){
					swal({
						title: "상품삭제성공",
						text: "버튼을 클릭해주세요!",
						icon: "success" // "info,success,warning,error" 중 택1
					}).then(() => {
						location.reload();
					});
				}
			});
		});
	});
});

/** *****작품 펑션 시작********** */	
$(function() {
		$(document).on('click','#wUpdateBtn', function() {
				 var params = $('#work_update').serializeArray();
				  $.ajax({
					url: 'work_update',
					data: params,
					method:'post',
					dataType: 'text',
					success: function(result) {
						 if(result == 'success'){
							 swal({
								   title: "작품변경성공",
								   text: "버튼을 클릭해주세요!",
								   icon: "success" // "info,success,warning,error"
													// 중 택1
								}).then(() => {
									window.opener.location.reload();
									window.close();
								});
								// window.opener.location.reload();
								// window.close();
					     }else{
					       	swal({
								   title: "작품변경실패",
								   text: "버튼을 클릭해주세요!",
								   icon: "error" // "info,success,warning,error"
															// 중 택1
							});
					            }
					     },
					     error:function(request, error) {
					    	 swal({
								   title: "작품변경실패",
								   text: "버튼을 클릭해주세요!",
								   icon: "error" // "info,success,warning,error"
													// 중 택1
								});
					 		 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					 	}
				  });
			  });					
});	

$(function() {
	$(document).on('click','#wCheckBtn',function(e) {
			var checkBtn = $(this);
			var tr = checkBtn.parent().parent();
			var td = tr.children();
			var no = td.eq(1).text();
			window.open("work_select?" + "wNo="+ no, "작품정보수정",
						"width=500, height=800, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
	});
});
$(function() {
	$(document).on('click','#wCreateBtn', function() {
			  var params = $('#work_create').serializeArray(); 
			  $.ajax({
				  url: 'work_create_action',
				  data: params,
				  method:'post',
				  dataType: 'text',
				  success: function(result) {
						 if(result == 'success'){
							 swal({
								   title: "작품등록성공",
								   text: "버튼을 클릭해주세요!",
								   icon: "success" // "info,success,warning,error"
													// 중 택1
								}).then(() => {
									window.opener.location.reload();
									window.close();
								});
								// window.opener.location.reload();
								// window.close();
					     }else{
					       	swal({
								   title: "작품등록실패",
								   text: "버튼을 클릭해주세요!",
								   icon: "error" // "info,success,warning,error"
															// 중 택1
							});
					            }
					     },
					     error:function(request, error) {
					    	 swal({
								   title: "작품등록실패",
								   text: "버튼을 클릭해주세요!",
								   icon: "error" // "info,success,warning,error"
													// 중 택1
								});
					 		 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					 	}
				  });
			  });					
});	

$(function() {
	$(document).on('click','#wSelectBtn',function() {
		var checkbox = $("input[name=work_CheckBox]:checked");
		var tdArray = new Array();
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			var wNo = 'wNo='+td.eq(1).text();
			$.ajax({
				url : 'work_delete',
				data : wNo,
				method : 'POST',
				success: function() {
					swal({
						title: "작품삭제성공",
						text: "버튼을 클릭해주세요!",
						icon: "success" // "info,success,warning,error" 중 택1
					}).then(() => {
						location.reload();
					});
				}	
			});
		});
	});
});


/** **********공지사항펑션 이벤트***************** */
$(function() {
	$(document).on('click','#nCheckBtn',function(e) {
		var checkBtn = $(this);
		var tr = checkBtn.parent().parent();
		var td = tr.children();
		var nNo = td.eq(1).text();
		window.open("notice_detail?" + "bNo="+ nNo,"공지수정",
		"width=800, height=600, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
	});
});

function createNotice() {
	location.href='notice_create';
}
$(function() {
	$(document).on('click','#nDeleteBtn',function() {
		var checkbox = $("input[name=notice_CheckBox]:checked");
		var tdArray = new Array();
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			var bNo = 'bNo='+td.eq(1).text();
			$.ajax({
				url : 'notice_delete',
				data : bNo,
				method : 'POST',
				success: function() {
					swal({
						title: "공지삭제성공",
						text: "버튼을 클릭해주세요!",
						icon: "success" // "info,success,warning,error" 중 택1
					}).then(() => {
						location.reload();
					});
				}	
			});
		});
	});
});
function createNoticeAction() { 
	CKEDITOR.instances.contents.updateElement(); 
	if(document.noticeWriteF.bTitle.value === "") { 
		alert("제목을 입력해 주세요"); 
		return; 
	}else if(document.noticeWriteF.bContent.value === "") { 
		alert("내용을 입력해 주세요"); 
		return; 
	}else {
		document.noticeWriteF.action = "notice_create_action";
		document.noticeWriteF.method = "POST";
		document.noticeWriteF.submit();
	} 
}
/** **********document ready 이벤트***************** */
$(document).ready(function() {
	/** *****멤버 validate 시작********** */
	$('#memberInfoFrm').validate({
		rules:{
			mPw:{
				required: true,
				passwordCk : true,
				minlength: 8,
				maxlength: 15
			},
			repeatPw:{
				required: true,
				equalTo : '#mPw'
			},
			mEmail:{
				required: true,
				email : true
			}
		},
		messages:{
			mPw:{
				required: "비밀번호를 입력해주세요",
				passwordCk: "영문, 숫자, 특수문자를 조합해서 입력해야 합니다.",
				minlength:"비밀번호는 8자리 이상으로 구성해야 합니다." ,
				maxlength:"비밀번호는 16자리 미만으로 구성해야 합니다"
			},
			repeatPw:{
				required: "비밀번호를 확인해주세요",
				equalTo : '비밀번호가 다릅니다.'
				
			},
			mEmail:{
				required: "이메일을 입력해주세요",
				email : "이메일 형식으로 입력하셔야합니다."
			}
		},
		submitHandler:function(f){
			$.ajax({
				url: f.action,
				data: $(f).serializeArray(),
				dataType: 'text',
				success: function() {
					swal({
						   title: "회원정보가  변경되었습니다.",
						   text: "버튼을 클릭해주세요!",
						   icon: "success" // "info,success,warning,error"
											// 중 택1
						}).then(() => {
							window.opener.location.reload();
							window.close();
						});
				}
			});
		},
		errorClass:"error_validate",
		validClass:"valid"
	});
	$.validator.addMethod("passwordCk",  function( value, element ) {
		   return this.optional(element) ||  /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(value);
		});

	function execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가
							// 도로명
							// 주소를
							// 선택했을
							// 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						// document.getElementById('new_address_zipcode').value
						// = data.zonecode;
						document.getElementById("mAddress").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("mDaddress")
								.focus();
					}
				}).open();
	};
	
	$('#slider-div').slick({
		slide: 'div',		// 슬라이드 되어야 할 태그 ex) div, li
		infinite : true, 	// 무한 반복 옵션
		slidesToShow : 1,		// 한 화면에 보여질 컨텐츠 개수
		slidesToScroll : 1,		// 스크롤 한번에 움직일 컨텐츠 개수
		speed : 100,	 // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
		arrows : true, 		// 옆으로 이동하는 화살표 표시 여부
		dots : false, 		// 스크롤바 아래 점으로 페이지네이션 여부
		autoplay : true,			// 자동 스크롤 사용 여부
		autoplaySpeed : 5000, 		// 자동 스크롤 시 다음으로 넘어가는데 걸리는
									// 시간 (ms)
		pauseOnHover : true,		// 슬라이드 이동 시 마우스 호버하면 슬라이더
									// 멈추게 설정
		vertical : false,		// 세로 방향 슬라이드 옵션
		prevArrow : "<button type='button' class='slick-prev'>Previous</button>",		// 이전
																						// 화살표
																						// 모양
																						// 설정
		nextArrow : "<button type='button' class='slick-next'>Next</button>",		// 다음
																					// 화살표
																					// 모양
																					// 설정
		dotsClass : "slick-dots", 	// 아래 나오는 페이지네이션(점) css
									// class 지정
		draggable : true, 	// 드래그 가능 여부
		pade: true,
		responsive: [ // 반응형 웹 구현 옵션
			{  
				breakpoint: 960, // 화면 사이즈 960px
				settings: {
					// 위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
					slidesToShow:1
				} 
			},
			{ 
				breakpoint: 768, // 화면 사이즈 768px
				settings: {	
					// 위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
					slidesToShow:1 
				} 
			}
		]

	});
	$('.slider-for').slick({
          autoplay: true, // 자동슬라이드
          slidesToShow: 1, // 큰이미지 몇개 보여줄것인지
          slidesToScroll: 1,
          arrows: true,
          fade: false,
          centerMode: true,
          variableWidth: true,
          variableHeight: true,
          centerPadding: "50px",
          asNavFor: '.slider-nav',
       });
       $('.slider-nav').slick({
          slidesToShow: 3, // 작은이미지 몇개 보여줄것인지..
          slidesToScroll: 1,
          centerMode: true,
          centerPadding: "50px",
          variableWidth: true,
          variableHeight: true,
          asNavFor: '.slider-for',
          focusOnSelect: true,
       });
});	




