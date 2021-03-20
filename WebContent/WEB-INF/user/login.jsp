<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Community</title>
<!-- 부트스트랩 css 사용 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 반응형 웹 디자인 적용 -->
<!-- <meta name="viewport" content="width=device width">-->
<style>
/* html {
	background: url(resource/KakaoTalk_20210128_101406084.png) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
} */
</style>
	<script>
		$(function(){
			
			function checkFunc() { // 입력값 유효성 검사
				var check = 0;
				var idLength = $('#userID').val().length;
				var pwLength = $('#userPassword').val().length;
				
				console.log(idLength,pwLength);
				if(idLength == 0){
					alert("아이디를 입력하세요!");
					check++;
				}
				if(pwLength == 0){
					alert("비밀번호를 입력하세요!")
					check++;
				}
				return check;
			} //유효성 검사 끝
			
			// 캡스락 감지
			$('#userPassword').keypress(function(e) { 	
				var s = String.fromCharCode(e.which);
				if(s.toUpperCase() === s && s.toLowerCase() !== s && !e.shiftKey){
					$('#pwCheck').text("!Caps Lock을 확인해주세요");
				}else{
					$('#pwCheck').html("&nbsp");
				}
			})
			
			$('form').submit(function() {
				var userId = $('#userID').val();
				var userPw = $('#userPassword').val();
				var emptyCheck = checkFunc();
				if(emptyCheck == 0){
					$.ajax({
						type : "post",
						url : "login.kh",
						data : {
							"userID" : userId,
							"userPW" : userPw
						},
						success : function(resp){
							console.log("hi")
							if(resp == 1){
								window.location.href = "/main";
							} else {
								alert("없는 아이디거나 비밀번호가 틀렸습니다.")
							}
						},
						error : function(request, status, error){
							location.href = "/error.jsp"
						}
					}) // ajax 끝
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
	<!-- navbar -->
	<nav
		class="navbar navbar-expand-sm bg-dark justify-content-center navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link " href="/main">Home</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/freeboard/list">자유게시판</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/jobBoard/list">취업게시판</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/foodboard/list">맛집정보</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/studyboard/list">스터디모집</a></li>
			<li class="nav-item"><label class="nav-link disabled">|</label></li>
			<li class="nav-item"><a class="nav-link" href="/qnaboard/board">Q n A</a></li>
		</ul>
	</nav>
	<br>
	<!-- login-main -->
	<h3 class="text-center">로그인</h3>
	<div class="container">
		<div class="col-md-2"></div>		
		<hr class="col-md-8">
		<div class="col-md-2"></div>
	</div>
	<div class="col-md-3"></div>
	<div class="container col-md-6 text-center">
		<div>
			<form class="form-signin" method="POST" name="loginform" onsubmit="return false;">
				<input type="text" class="form-control" placeholder="ID" name="userID" id="userID"><br>			
				<input type="password" class="form-control" placeholder="Password" name="userPassword" id="userPassword"><br>
				<span id="pwCheck" style="color:red;">&nbsp;</span>
				<br><label><a href="/idFinder">아이디 찾기</a></label>&nbsp; /&nbsp;				
				<label><a href="/pwFinder">비밀번호 찾기</a></label>&nbsp; /&nbsp;				
				<label><a href="/join">회원가입</a></label><br>
				<button class="btn btn-lg btn-primary" type="submit">로그인</button>
			</form>
		</div>
	</div>	
	<div class="col-md-3"></div>
	<!-- footer -->
	<div style="height: 100px;"></div>
</body>
</html>