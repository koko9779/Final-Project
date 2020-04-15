$(document).ready(function(){
	$('.slick-carousel.newIn').not('.slick-initialized').slick({
		autoplay: false,
		autoplaySpeed: 3000,
		slidesToShow: 4,
		centerPadding: '60px',
		prevArrow: '<i class="material-icons left">keyboard_arrow_left</i>',
		nextArrow: '<i class="material-icons right">keyboard_arrow_right</i>',
		responsive: [
		    {
		      breakpoint: 768,
		      settings: {
		        slidesToShow: 2
		      }
		    },
		    {
		      breakpoint: 480,
		      settings: {
		        slidesToShow: 1
		      }
		    }
		  ]
	});
	//worklist 회차 출력
	$('#workEpisode').change(function(e){
		console.log('#workEpisode change!!!!!!!!!!');
		var contextPath = $("option:selected").attr("contextPath");
		var wNo = $("option:selected").attr("wNo");
		var wdEpisode = $("option:selected").val();
		var params = 'wNo='+wNo+'&wdEpisode='+wdEpisode;
		$.ajax({
			url:'worklist_select/detail',
			method:'GET',
			data:params,
			dataType:'json',
			success:function(jsonData){
				var html = "";
				var userNo = jsonData.userNo;
				console.log("userNo:~~~~~~~~~~~~~~"+userNo);
				//var episode = jsonData.mwe[0].wdEpisode;
				
				var bmList = jsonData.bmList;
				
				var mweArray = jsonData.mwe;
				html += "<article>";
				/***********************************/
				
				for (var i = 0; i < mweArray.length; i++) {
					console.log("html length:"+html.length);
					var mweProduct = mweArray[i].product;
					var pMno = mweProduct[0].mNo;
					var pPno = mweProduct[0].pNo;
					var pScene = mweProduct[0].pScene;
					var pName = mweProduct[0].pName;
					var pView = mweProduct[0].pView;
					var pMid = mweProduct[0].mId;
					
					html += "<form id='product_"+pPno+"' onsubmit=''>";
					html += "<h2 value='상품이름' >"+pName+"</h2>";
					html += "<input type='hidden' value='"+userNo+"' name='userNo'>";
					html += "<input type='hidden' value='"+wNo+"' name='wNo'>";
					html += "<input type='hidden' value='"+pPno+"' name='pNo'>";
					html += "<div class='movie-poster2'>";
					html += "<img onclick='productpage("+pWno+","+pPno+")'";
					html += " src='../"+pScene+"'";
					html += " alt='"+pName+"' style='width:850px; height:450px; margin: 0;cursor: pointer;'/>";
					html += "</div>";
					html += "<div style='height:100px;'>";
					
					if(userNo!=null){
						console.log(bmList+"북마크");
						/////////////////////////
						if(bmList=="" || bmList==undefined){
							
							html += "<input class='material-icons' type='image'";
							html += " style='border: none; width: 4%; float:left; padding: 0px;' alt='즐겨찾기 등록'";
							html += " src='../images/emptystar.png'";
							html += " onclick='create_bookmark("+userNo+","+pPno+");return false;'>"; 
						}else{
							
								console.log("login-->>>>>>>>>>>>>")
								var cnt = 0;
								for (var i = 0; i < bmList.length; i++) {
									if(pPno==bmList[i].product.pNo){
										console.log("cnt1-->>>>>>>>>>>>>")
										cnt = 1;
										break;
									}
								}
								
								if(cnt==1){
									html += "<input class='material-icons' type='image'"; 
									html += " style='border: none; width: 4%; float:left; padding: 0px;' alt='즐겨찾기 제거'";
									html += " src='../images/star.png'";
									html += " onclick='select_bookmark("+userNo+","+pPno+");return false;'>";
									console.log("cnt=====1-->>>>>>>>>>>>>")
								}else{
									html += "<input class='material-icons' type='image'";
									html += " style='border: none; width: 4%; float:left; padding: 0px;' alt='즐겨찾기 등록'";
									html += " src='../images/emptystar.png'";
									html += " onclick='create_bookmark("+userNo+","+pPno+");return false;'>";  
								}
							
						}	
					}else{
						html += "<input class='material-icons' type='image'";
						html += " style='border: none; width: 4%; float:left; padding: 0px;' alt='즐겨찾기 등록'";
						html += " src='../images/emptystar.png'";
						html += " onclick='login_advice(); return false;'>";                                     
					}
					
					///////episode가 널일때 ~~ 수정
					
					
					html += "<div style='float:right;'>";
					html += "<span value='작성자'>작성자: "+pMid+"</span>";
					html += "<span class='categories tag' value='조회수'>조회수: "+pView+"</span>";
					html += "<span class='categories tag' value='에피소드'>"+wdEpisode+"회</span>";
					html += "</div>";
					html += "</div>";
					html += "</form>";
					console.log("end-->>>>>>>>>>>>>")
				}
				/***************************/
				html += "</article>";
				
				$('#work_list_main article').remove();
				$('#work_list_main').append(html);
				/******************************/
				$('.slick-carousel.newIn').not('.slick-initialized').slick({
					autoplay: false,
					autoplaySpeed: 3000,
					slidesToShow: 4,
					centerPadding: '60px',
					prevArrow: '<i class="material-icons left">keyboard_arrow_left</i>',
					nextArrow: '<i class="material-icons right">keyboard_arrow_right</i>',
					responsive: [
					    {
					      breakpoint: 768,
					      settings: {
					        slidesToShow: 2
					      }
					    },
					    {
					      breakpoint: 480,
					      settings: {
					        slidesToShow: 1
					      }
					    }
					  ]
				});
				/******************************/
			}
		});
		
		e.preventDefault();
	});		
});

function bm_productpage(bmNo,pNo){
	var product_form = document.getElementById('bookmark_'+bmNo);
	product_form.action = "../detail/product_detail";
	product_form.submit();
};
/************Controller productpage*******************/
function productpage(pNo){
	var product_form = document.getElementById('product_'+pNo);
	product_form.action = "../detail/product_detail";
	product_form.submit();
};
/************Controller workpage*******************/

function workpage(wNo){
	var work_form = document.getElementById('work_'+wNo);
	work_form.action = "worklist_select";
	work_form.submit();
};

/************Controller create_bookmark*******************/
/*
function create_bookmark(userNo,pNo){
	var product_form = document.getElementById('product_'+pNo);
	alert('즐겨찾기에 상품이 추가되었습니다');
	product_form.action = "create_bookmark";
	product_form.submit();
};
*/
/************Controller delete_bookmark*******************/
/*
function delete_bookmark(bmNo){
	  var bookmark_form = document.getElementById('bookmark_'+bmNo);
//	  alert("즐겨찾기에서 상품이 제거됐습니다");
	  bookmark_form.action = "delete_bookmark";
	  bookmark_form.submit();
	  window.location.reload();
};
*/

/************Controller select_bookmark*******************/
/*
function select_bookmark(mNo,pNo){
	var product_form = document.getElementById('product_'+pNo);
	product_form.action = "select_bookmark";
	product_form.submit();
}
*/
/*************RestController create_bookmark********************/
function create_bookmark(userNo,pNo){
	//alert('즐겨찾기에 상품이 추가되었습니다.'+event.target);
	var params= "userNo="+userNo+"&pNo="+pNo;
	var product = "#product_"+pNo;
	$.ajax({
		url: "create_bookmark",
		method:"POST",
		data: params,
		success:function(result){
			if(result=='true'){
				//console.log($(product).find('.material-icons').attr('src')+"------------->");
				$(product).find('.material-icons').attr('src','../images/star.png');
				$(product).find('.material-icons').attr('alt','즐겨찾기 제거');				
				$(product).find('.material-icons').attr('onclick','select_bookmark('+userNo+','+pNo+');return false;');
			}
		}			
	});
};
/************RestController select_bookmark*******************/
function select_bookmark(userNo,pNo){
	//alert("즐겨찾기에서 상품이 제거됐습니다");
	var params= "userNo="+userNo+"&pNo="+pNo;
	$.ajax({
		url: "select_bookmark",
		method: "POST",
		data: params,
		success:function(bookset){
			delete_bookmark(bookset);
		}
	});
}
/***********RestController delete_bookmark*******************/
function delete_bookmark(bookset){
	//alert("즐겨찾기에서 상품이 제거됐습니다");
	var bmNo = ""+bookset;
	var userNo = 0;
	var pNo = 0;
	var product;
	
	if(bmNo.indexOf(",")!=-1){
		var bookset = bookset.split(',');
		bmNo = bookset[0];
		userNo = bookset[1];
		pNo = bookset[2];
	}
	if(pNo==0){
		product = "#bookmark_"+bmNo;
	}else{
		product = "#product_"+pNo;
	}
	var params= "bmNo="+bmNo+"&userNo="+userNo+"&pNo="+pNo;
		$.ajax({
			url: "delete_bookmark",
			method:"POST",
			data: params,
			success:function(result){
				if(result=='true'){
					//console.log($(product).find('.material-icons').attr('src')+"------------->");
					$(product).find('.material-icons').attr('src','../images/emptystar.png');
					$(product).find('.material-icons').attr('alt','즐겨찾기 등록');				
					$(product).find('.material-icons').attr('onclick','create_bookmark('+userNo+','+pNo+');return false;');
				}
			}
		});
};

/**********************************************************/
function login_advice(){
	alert('로그인이 필요한 작업입니다.');
	location.href="../login/login";
}
