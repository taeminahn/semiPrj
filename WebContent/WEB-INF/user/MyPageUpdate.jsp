<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Community</title>
<!-- 부트스트랩 css 사용 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 반응형 웹 디자인 적용 -->
<!-- <meta name="viewport" content="width=device width" initial-scale="1"> -->
<style>
/* html {
   background: url(resource/KakaoTalk_20210128_101406084.png) no-repeat center center fixed;
   -webkit-background-size: cover;
   -moz-background-size: cover;
   -o-background-size: cover;
   background-size: cover;
} */


.hopehover:hover {
	background: lightgray;
}

.Gender {
	text-align: left;
	width: 50px;
	position: static;
}

.pageLi:hover {
	background: lightgray;
}

.pageLi {
	padding-left: 50px;
}

.mypageItem {
	width: 200px;
	margin-left: 30px;
	margin-right: auto;
}

.container {
	margin: 0px;
}

.active {
	background: lightgrey !important;
}

aside {
	border-right: 2px solid gray;
}

table {
	min-width:800px;
}
</style>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	// 다음 주소 api
    function PostCode() {
        new daum.Postcode({
            oncomplete: function(data) {

                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                if(data.userSelectedType === 'R'){

                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }

                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
              
                
                } else {
           
                }
				
                document.getElementById('userPost').value = data.zonecode;
                document.getElementById("userAddress").value = addr;
 
                document.getElementById("userAddress").focus();
            }
        }).open();
    }
</script>



<script>
		// 정규식
	$(function(){
		
		  var pwdCheck = false;
		  var pwcCheck = false;
		  var nameCheck = true;
		  var phoneCheck = true;
		  var eCheck = true;
		
	      $('#userPW').focusout(function(){
	          var userPw = $('#userPW').val();
	          var pwCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]).{8,16}$/);
	          if(pwCheck.test(userPw) == false ){
	                 $('#pwCheck').text('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.').css('color','red').show();
		       		     pwdCheck = false;
		       		 console.log(pwCheck);
	              }else{
	            	  console.log('tr');
	                 $('#pwCheck').hide();
	        		    pwdCheck = true;
	        		    console.log(pwCheck);
	              }
	       });
	      
	       $('#PWConfirm').focusout(function(){
	          var userPw = $('#userPW').val();
	          var userPwCheck = $('#PWConfirm').val();
	          
	          if(userPw != userPwCheck || userPwCheck == ""){
	              $('#pwCheck1').text('비밀번호가 일치하지 않습니다.').css('color','red').show();
	        	    pwcCheck = false;
	        	    console.log(pwcCheck);
	           }else{
	              $('#pwCheck1').text('비밀번호가 일치합니다.').css('color','green').show();
	              pwcCheck = true;
	        	    console.log(pwcCheck);
	          }
	       });
	       
	       $('#userName').focusout(function(){
	          var userName = $('#userName').val();
	          var userNameCheck = RegExp(/^[가-힣]{2,6}$/);
	          if(userNameCheck.test(userName) == false){
	             $('#nameCheck').text('2~6자 한글만 입력해주세요.').css('color','red').show();
		   		    nameCheck = false;
		   		 console.log(pwcCheck);
	          }else{
	             $('#nameCheck').hide();
	             nameCheck = true;
	             console.log(pwcCheck);
	          }
	       });
	       
	       $('#userPhoneNumber').focusout(function(){
	          var userPhone = $('#userPhoneNumber').val();
	          var phoneCheck = RegExp(/^01[0179][0-9]{7,8}$/);
	          if(phoneCheck.test(userPhone) == false){
	             $('#phoneCheck').text('다시 입력해주세요.').css('color','red').show();
		   		    phoneCheck = false;
	          }else{
	             $('#phoneCheck').hide();
	             phoneCheck = true;
	          }
	       });
	       
	       $('#userEmail').focusout(function(){
	           var email = $('#userEmail').val();
	           var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	           if(emailCheck.test(email) == false){
	              $('#emailCheck').text('이메일 형식을 다시 확인해주세요.').css('color','red').show();
	    		   eCheck = false;
	           }else{
	              $('#emailCheck').hide();
	              eCheck = true;
	           }
	        });

	// 아작스

		$('#submit').click(function() {
			console.log('hhh');
			var userPW = $('#userPW').val();
			var userPWC = $('#PWConfirm').val();
			var userName = $('#userName').val();
			var userGender = $('input[name=userGender]:checked').val();
			var userBirth = $('#userBirth').val();
			var userPhoneNumber = $('#userPhoneNumber').val();
			var userPost = $('#userPost').val();
			var userAddress = $('#userAddress').val();
			var subAddress = $('#subAddress').val();
			var userEmail = $('#userEmail').val();
			
			console.log(pwCheck);
			console.log(pwcCheck);
			console.log(nameCheck);
			console.log(phoneCheck);
			console.log(eCheck);
			

			if (pwdCheck == true && pwcCheck == true && nameCheck == true && phoneCheck == true && eCheck == true) {
				$.ajax({
					type : "post",
					url : "update",
					data : {
						"userPW" : userPW,
						"userPWC" : userPWC,
						"userName" : userName,
						"userGender" : userGender,
						"userBirth" : userBirth,
						"userPhoneNumber" : userPhoneNumber,
						"userPost" : userPost,
						"userAddress" : userAddress,
						"subAddress" : subAddress,
						"userEmail" : userEmail
					},
					success : function(resp) {
						console.log(resp)
						if (resp == 1) {
							alert("수정완료");
							window.location.href = "view";
						} else {
							alert("수정에 실패했습니다. 확인바랍니다.")
						}
					},
					error : function(request, status, error) {
						location.href = "/naver.com"
					}
				}) // ajax 끝
			} else {
				alert("모든항목을 정확히 기입하시기 바랍니다.");
			}
		}) // submit 끝
	})
</script>



</head>
<body>
	<!-- header -->
	<div class="p-3 my-3 bg-white text-center" style="margin-bottom: 0;">
		<h1 class="title">OSOL</h1>
		<p>KH 커뮤니티에 오신 것을 환영합니다</p>
	</div>
	<c:if test="${not empty userId}">
		<div class="mini-navbar" style="text-align: right;">
			<span>${userId}님 환영합니다.</span>&nbsp;|&nbsp; <span>
			<a class="mini-item"
				href="/logout">로그아웃</a></span>
		</div>
	</c:if>
	<!-- 비 로그인 상태일때 -->
	<c:if test="${empty userId}">
		<div class="mini-navbar" style="text-align: right;">
			<span><a class="mini-item" href="/login">로그인 </a></span>&nbsp;|&nbsp;
			<span><a class="mini-item" href="/join">회원가입</a></span>
		</div>
	</c:if>
	<!-- navbar -->
	
	
	<nav class="navbar navbar-expand-sm bg-dark justify-content-center navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link " href="/main">Home</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/freeboard/list">자유게시판</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/jobBoard/listbridge">취업게시판</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/foodboard/list">맛집정보</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/studyboard/list">스터디모집</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/qnaboard/board">Q n A</a></li>
		</ul>
	</nav>
	
	
	<br>
	<!-- 회원가입 -->
	<div class="row justify-content-center">
		<aside class="aside col-2" style="min-width: 300px">
			<h4 class="text-center" style="line-height: 50px;">My Page</h4>
			<ul class="nav nav-pills flex-column text-left">
				<li class="nav-item mypageItem"><a
					class="nav-link pageLi text-dark " href="#">- 내 정보 변경</a></li>
				<li class="nav-item mypageItem"><a
					class="nav-link pageLi text-dark " href="withdraw.jsp">- 회원탈퇴</a></li>
			</ul>
		</aside>
		<div class="body col-8" style="padding-left: 50px">
			<h2 class="text-center" style="line-height: 50px">내 정보 수정</h2>
			<form method="post" class="form-myupdate">
				<table class="table table-hover" style="text-align: center;">
					<tbody>
						<tr>
							<td style="width: 150px; text-align: left"><h5>아이디</h5></td>
							<td><input class="form-control" type="text" id="userID" value="${mv.memberId}" readonly 
								maxlength="15" ></td>
						</tr>
						<tr>
							<td style="width: 150; text-align: left; padding-right:0px;"><h5>비밀번호 변경</h5></td>
							<td><input class="form-control" type="password" id="userPW"maxlength="15" required>
							<span id="pwCheck"></span></td>
							
						</tr>
						<tr>
							<td style="width: 150px; text-align: left; padding-right:0px;"><h5>비밀번호 확인</h5></td>
							<td><input class="form-control" type="password" id="PWConfirm" maxlength="15" required>
							<span id="pwCheck1"></span>
							</td>
						</tr>
						<tr>
							<td style="width: 150px; text-align: left"><h5>이름</h5></td>
							<td><input class="form-control" type="text" id="userName" value="${mv.memberName}"maxlength="5" required>
							<span id="nameCheck"></span>
							</td>
						</tr>
						<tr>
							<td style="width: 150px; text-align: left"><h5>성별</h5></td>
							<td style="text-align: left; with: 30px">
							남자<input class="form control Gender" type="radio" id="Man" name="userGender" value="남자" ${mv.memberGender eq "남자"?"checked":""}> 
							여자<input class="form control Gender" type="radio" id="Woman" name="userGender" value="여자" ${mv.memberGender eq "여자"?"checked":""} />
							</td>
						</tr>
						<tr>
							<td style="width: 150px; text-align: left"><h5>생년월일</h5></td>
							<td><input class="form-control" type="date" id="userBirth" value="${mv.memberBirthday}" required></td>
						</tr>
						<tr>
							<td style="width: 150px; text-align: left"><h5>전화번호</h5></td>
							<td><input class="form-control" type="text" value="${mv.memberPhone}" id="userPhoneNumber" maxlength="11" required>
							<span id="phoneCheck"></span>
							</td>
						</tr>
						<tr>
							<td style="width: 150px; text-align: left"><h5>주소</h5></td>
							<td>
							<input class="form-control" style="float:left; width:590px;" type="text" id="userPost" name="userPost" readonly >
							<input class="form-control col-md-3 btn-secondary" style="width:300px; float:right; " type="button"
								onclick="PostCode()" value="우편번호 검색"  >
							<input class="form-control" type="text" id="userAddress" name="userAddress"  placeholder="주소 입력 " value="${mv.memberAddress}" readonly>
							<input class="form-control" type="text" id="subAddress" name="subAddress" placeholder="상세주소 입력 ">
							</td>
						</tr>
						<tr>
							<td style="width: 150px; text-align: left"><h5>이메일</h5></td>
							<td><input class="form-control" type="email" id="userEmail" value="${mv.memberEmail}" maxlength="20"  required>
							<span id="emailCheck"></span>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="container">
					<div class="row">
						<div class="col text-center">
							<br> <input type="button" value="수정 완료" id="submit" class="btn btn-primary btn-lg">
						</div>
					</div>
				</div>
				<br> <br> <br>
			</form>
		</div>
	</div>



	<!-- footer -->
</body>
</html>