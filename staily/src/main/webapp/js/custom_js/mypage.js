/**
 * 
 */

$(function(){
	/***************************내가쓴글 삭제***************************/
   $('#deleteWriteBtn').click(function(e){
      var noArray = [];
      
      $('input[name="member_write_check"]:checked').each(function(i){
         noArray.push($(this).val());
      })
      
      var params = {
         "pNo" : noArray
      }
      
      $.ajax({
         url : 'member_write_delete',
         data : params,
         dataType : "text",
         success : function(result){
            if(result == 'true'){
               alert('삭제완료');
               location.reload();
            }else{
               location.href = '404';
            }
         },
         error : function(){
            location.href = '404';
         }
      });
      
      
   });
   
   /***************************북마크삭제***************************/
 //배열로 데이터를 Controller에 전송하기
	$('#deleteBtn').click(function(e){
		//배열선언
		var noArray = [];
		
		//배열에 값 채우기
		$('input[name="book_check"]:checked').each(function(i){
			noArray.push($(this).val());
		});
		
		var params = {
				"bmNo" : noArray 
		};
		
		//ajax 호출
		$.ajax({
			url : "bookmark_delete",
			data : params,
			dataType : "text",
			success : function(result){
				if(result == 'true'){
					alert('삭제완료');
					location.reload();
				}else{
					location.href = '404';
				}
			}
		});
	});
	
	/************************친구삭제시작******************************/
	
	$('#deleteFriendBtn').click(function(e){
		//데이터를 받을 배열 선언
		var noArray = [];
		
		//배열에 데이터 넣기
		$('input[name="friend_check"]:checked').each(function(i){
			noArray.push($(this).val());
		})
		
		var params = {
			"fPk" : noArray
		}
		
		$.ajax({
			url : 'friend_delete',
			data : params,
			dataType : "text",
			success : function(result){
				if(result == 'true'){
					alert('삭제완료');
					location.reload();
				}else{
					location.href = '404';
				}
			},
			error : function(){
				location.href = '404';
			}
		});
		
	});

	/************************쪽지보내기 시작******************************/
	$('#friendDropdown a:nth-child(1)').click(function(e){
		e.preventDefault();
		var no = $(this).attr('value');	
		window.open("message?mNo="+no, "_blank","width=800, height=700, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
		
	});
	
	//메시지 보관함 열기
	$('#friendDropdown a:nth-child(2)').click(function(e){
		e.preventDefault();
		window.open("message_list", "_blank", "width=800, height=700, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	});
	
	/************************검색한 친구 쪽지보내기************************/
	$('#searchDropdwon a:nth-child(2)').click(function(e){
		e.preventDefault();
		//var noV = $(this).attr('value');
		window.open("message", "_blank","width=800, height=700, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	});
	
	/************************친구검색 function 시작******************************/
	
	$('#searchword').focus(function(e){
		this.value="";
		$(".add").toggle();
		$(".add").text('');
	});

	$('#searchword').on({
		keyup : function(e){
			if(e.keyCode == 13){
				var mId = $('#searchword').val();
				confirm('찾으신 회원이 맞습니까?');
				if(mId != ""){
					$.ajax({
						url : "friend_find",
						method : "GET",
						data : "mId="+mId,
						dataType : "text",
						success : function(result){
							if(result!="N"){
								$('.add').text(result);
								friend_findNo_function(result);
								//alert(mId);
								//$('.add').text('없는 회원입니다');
							}else{
								$('.add').text('없는 회원입니다');
								$('#searchDropdwon').hide();
								//$('.add').text(result);
							}
						},
						error : function(e){
							//$('.add').text('없는 회원입니다');
						}
						
					})
				}
			}
		}
	});
	
	function friend_findNo_function(result){
		$('#searchDropdwon a:nth-child(1)').click(function(e){
			//alert("friend_findNo_function Id"+result);
			e.preventDefault();
			$.ajax({
				url : 'friend_findNo',
				method : 'GET',
				data : 'mId='+result,
				dataType : 'text',
				success : function(data){
					friend_create_function(data);
				}
			})
		})
	};
	function friend_create_function(data){
		//alert("friend_create_function mNo"+data);
		$.ajax({
			url : 'friend_create',
			method : 'GET',
			data : 'fNo='+data,
			dataType : 'text',
			success : function(result){				
				if(result == 'true'){					
					alert('친구추가완료');
					location.reload();
				}else{
					alert('이미 친구추가된 회원입니다');
				}
			},
			error : function(e){
				alert('이미 친구추가된 회원입니다');
			}
		})
	};
	
	
   
});

/*****************************주소검색*****************************/
function execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
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

/*******************회원수정 유효성체크*******************/
function check() {
	var mPw = $('#mPw').val();
	var repeatPw = $('#repeatPw').val();
	var mEmail = $('#mEmail').val();
	var mAddress = $('#mAddress').val();
	var mDaddress = $('#mDaddress').val();
	var phn1 = $('#phn1').val();
	var phn2 = $('#phn2').val();
	var phn3 = $('#phn3').val();

	//이메일 체크
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if (!regExp.test(mEmail)) {
		alert('이메일을 입력하세요');
		return;
	}
	
	if(mPw != repeatPw){
		alert('비밀번호가 일치하지 않습니다');
		return;
	}else if(mPw == "" || repeatPw == ""){
		alert('비밀번호를 입력하세요');
		return;
	}
	
	//비밀번호 체크
	var getCheck = RegExp(/^[a-zA-Z0-9]{8,15}$/);
	if(!getCheck.test(mPw)){
		alert("비밀번호는 대소문자와 숫자만 입력가능하고, 8 ~ 15글자 사이입니다");
		return;
	}
	
	//주소 체크
	if(mAddress == ""){
		alert('주소를 입력하세요');
		return;
	}
	
	//상세주소 체크
	if(mDaddress == ""){
		alert('상세주소를 입력하세요');
		return;
	}
	
	//전화번호 체크
	if(phn1 == ""){
		alert("전화번호를 입력하세요");
		return;
	}
	if(phn2 == ""){
		alert("전화번호를 입력하세요");
		return;
	}
	if(phn3 == ""){
		alert("전화번호를 입력하세요");
		return;
	}
	
	alert('회원정보가 수정되었습니다');
	document.getElementById("memberInfoFrm").action = "member_update";
	document.getElementById("memberInfoFrm").method = 'POST';
	document.getElementById("memberInfoFrm").submit();
	

}
