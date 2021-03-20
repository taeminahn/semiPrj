<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Community</title>
<!-- 부트스트랩 css 사용 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<!-- 부트스트랩 js 사용 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
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
		var pwd = false;
		var pwdCheck = false;
		
		$('#inputNewPw').focusout(function(){
	         var userPw = $('#inputNewPw').val();
	         var pwCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]).{8,16}$/);
	         if(pwCheck.test(userPw) == false){
	                $('#pwCheck').text('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.').css('color','red').show();
	                $('#pwCheck1').hide();
	                pwd = false;
	             }else{
	                $('#pwCheck').hide();
	                pwd = true;
	             }
	      });
		
		$('#inputNewPwCheck').focusout(function(){
	         var userPw = $('#inputNewPw').val();
	         var userPwCheck = $('#inputNewPwCheck').val();
	         var pwCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]).{8,16}$/);
	         
	         if(userPw != userPwCheck){
	            $('#pwCheck1').text('비밀번호를 다시 확인해주세요.').css('color','red').show();
	            pwdCheck = false;
	          }else{
	             $('#pwCheck1').text('비밀번호가 일치합니다.').css('color','green').show();
	             pwdCheck = true;
	         }
	      });
		
		$('form').submit(check);
		
		function check() {
			 if(pwd != true || pwdCheck != true){
				alert('입력사항을 확인해주세요.');
				return false;
			}else{
				return true;
			} 
		};
	});
</script>
</head>
<body>
	<!-- header -->
	<div class="p-3 my-3 bg-white text-center" style="margin-bottom: 0;">
		<h1 class="title">OSOL</h1>
		<p>KH 커뮤니티에 오신 것을 환영합니다</p>
	</div>
	<!-- login/sign up -->
	<!-- 비로그인 시 -->
	<c:if test="${empty userID}">
		<div class="mini-navbar" style="text-align: right;">
			<span><a class="mini-item" href="/login">로그인 </a></span>&nbsp;|&nbsp;
			<span><a class="mini-item" href="/join">회원가입</a></span>
		</div>
	</c:if>
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
	<!-- pwFinderEnd-main -->
	<h3 class="text-center">비밀번호 변경</h3>
	<div class="container">
		<div class="col-2"></div>		
		<hr class="col-8">
		<div class="col-2"></div>
	</div>
	<div class="col-3"></div>
	<div class="container col-6">
		<div>
			<form method="POST" name="newPwForm" action="/pwAuthentication">
				<input type="text" class="form-control" value="${id}" name="id" readonly="readonly" /><br>
				<input type="text" class="form-control" placeholder="인증번호 입력" id="inputKey" name="AuthenticationUser" required><br>
				<input type="password" class="form-control" placeholder="새 비밀번호" id="inputNewPw" name="newPw" required>
				<span id="pwCheck"></span><br>
				<input type="password" class="form-control" placeholder="새 비밀번호 확인" id="inputNewPwCheck" name="newPwCheck" required>
				<span id="pwCheck1"></span>
				<div class="d-flex justify-content-center">
					<br><input type="submit" class="btn btn-lg btn-primary" value="변경">		
				</div>		
			</form>
		</div>
	</div>	
	<div class="col-3"></div>
	<!-- footer -->
	<div style="height: 100px;"></div>
</body>
</html>