/**
 * 
 */
$(window).on("load", function() {
	
	//버튼 클릭시 Row 값 가져오기
	$(".checkBtn").click(function(e){ 
		
	    var checkBtn = $(this);
	    var tr = checkBtn.parent().parent();
	    var td = tr.children();
	    var no = td.eq(1).text();
//	    $.ajax({
//	    	url:'member_select',
//	    	data:{"mNo":no},
//	    	method:'GET',	
//	    	dataType: "json",
//	    	async: false,
//	    	success: function() {
//			}
//	    	
//	    });
	    window.open("member_select?"+"mNo="+no,"width=500,height=600")
	});
	$("#selectBtn").click(function(){ 
	    var checkbox = $("input[name=user_CheckBox]:checked");
	    // 체크된 체크박스 값을 가져온다
	    var tdArray = new Array();
	    checkbox.each(function(i) {
	        // checkbox.parent() : checkbox의 부모는 <td>이다.
	        // checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
	        var tr = checkbox.parent().parent().eq(i);
	        var td = tr.children();
	        var mNo = td.eq(1).text();
	        var noArray = 'noArray='+mNo+'-';
	        $.ajax({
	    		url:'member_delete',
	    		data:noArray,
	    		method:'POST',
	    		dataType: "text",
	    		success:function(result){
	    			 location.reload();
	    			}		
	    		});
	    	});
	    });
	function member_update(){
		if($('#mPw').val() != $('#repeatPw').val()){
			alert("비밀번호가 일치하지 않습니다");
			return;
		}
		alert("수정완료");
		document.getElementById("memberInfoFrm").action = "member_update";
		document.getElementById("memberInfoFrm").submit();
	}
		function sample6_execDaumPostcode() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		            var addr = ''; // 주소 변수
		            var extraAddr = ''; // 참고항목 변수

		            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                addr = data.roadAddress;
		            } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                addr = data.jibunAddress;
		            }

		            // 우편번호와 주소 정보를 해당 필드에 넣는다.
		           // document.getElementById('new_address_zipcode').value = data.zonecode;
		            document.getElementById("mAddress").value = addr;
		            // 커서를 상세주소 필드로 이동한다.
		            document.getElementById("mDaddress").focus();
		        }
		    }).open();
		}
		
	function register_action(){
	  $('#mPw').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
			
			if(!getCheck.test($('#inputPw').val())){
				alert("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
				return;
			}
		});
	  
	  $('#repeatPw').keyup(function() {
			var getCheck = RegExp(/^[a-zA-Z0-9]{6,10}$/);
			
	  		if($('#mPw').val() != $('#repeatPw').val()) {
	  			alert("비밀번호가 일치하지 않습니다");
				return;
	  		}
	   });
	  
	  
	  $('#mEmail').keyup(function() {
		  var getCheck = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
		  
		  if(!getCheck.test($("#mEmail").val())){
			  alert("이메일 형식으로 입력해주세요");
			  return;
		  }
	   });
	  
	  $('#mPhone').keyup(function() {
		  var getCheck = RegExp(/^[0-9]{9,11}$/);
		  
		  if(!getCheck.test($("#mPhone").val())){
			  alert("알맞은 전화번호를 입력해주세요");
			  return;
	   		}
		});
	  
	  	if($('#mPw').val() != $('#repeatPw').val()){
			alert("비밀번호가 일치하지 않습니다");
			return;
		}
		alert("수정완료");
		document.getElementById("memberInfoFrm").action = "member_update";
		document.getElementById("memberInfoFrm").submit();
	  }


			/*
			$(function() {
				//유효성확인
				$('#memberInfoFrm').validate({
					rules : {
						userid : {
							required : true,
							minlength : 5,
							maxlength : 10
						},
						joinPwd : {
							required : true,
							minlength : 8,
							maxlength : 15
						}
						/*
						mName : {
							required : true,
							minlength : 8,
							maxlength : 15
						},
						mEmail : {
							email : true
						}
						*/
						/*
					},
					messages : {
						userid : {
							required : "아이디를 입력하세요",
							minlength : "{0}글자 이상 입력하세요",
							maxlength : "{0}글자 이하 입력하세요"
						},
						joinPwd : {
							required : "비밀번호를 입력하세요",
							minlength : "{0}글자 이상 입력하세요",
							maxlength : "{0}글자 이하 입력하세요"
						},
						mName : {
							required : "이름을 입력하세요",
							minlength : "{0}글자 이상 입력하세요",
							maxlength : "{0}글자 이하 입력하세요"
						}
						/*
						mEmail : {
							email : "이메일을 입력하세요"
						}
						*/
						/*
					},
					submitHandler : function() {
						member_update();
					},
					errorClass : "error",
					validClass : "valid"
				});
				
				$('#memberInfoFrm').on('submit',function(e){
					alert("ff");
				})
			})
			*/
});