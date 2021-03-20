<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	background : lightgray;
}

.Gender { 
	text-align : left;
	width : 50px;
	position : static;
}

.pageLi:hover {
	background : lightgray;
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
	height : 600px;
	border-right: 2px solid gray;
}
</style>
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
	<!-- navbar -->
	<nav class="navbar navbar-expand-sm bg-dark justify-content-center navbar-dark">
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
	<!-- 회원가입 -->
	<div class="row justify-content-center">
		<aside class="aside col-2" style="min-width:300px">
			<h4 class="text-center text-blue" style="line-height:50px">My Page</h4>
			<ul class="nav nav-pills flex-column text-left">
				<li class="nav-item mypageItem"><a class="nav-link pageLi text-dark " href="/mypage/view">- 내 정보 보기</a></li>
				<li class="nav-item mypageItem"><a class="nav-link pageLi text-dark " href="/withdrawbridge">- 회원탈퇴</a></li>
			</ul>
		</aside>
		<div class="body col-8" style="padding-left: 50px">
			<h2 class="text-center" style="line-height:50px">회원탈퇴</h2>
			<form method="post" action="/withDraw">
				<table class="table" style="text-align: center;">
					<tbody>
						<tr >
							<td style="width: 150px; text-align: left; padding-top:100px"><h5>비밀번호</h5></td>
							<td style="padding-top:100px"><input class="form-control hopehover" type="password" id="userPassword"
								name="userPassword" maxlength="15" placeholder="비밀번호를 입력하세요."></td>
							
						</tr>
					</tbody>
				</table>
				<br>
				<br>
				<div class="container">
					<div class="row">
						<div class="col text-center">
							<br> <input type="submit" id="userId" name="userId" value="탈퇴하기" class="btn btn-primary btn-md">
							&nbsp;&nbsp;&nbsp;
							<input type="submit" value="취소" class="btn btn-primary btn-md">
						</div>
					</div>
				</div>
				<br> <br>
				<br>
			</form>
		</div>
	</div>






	<!-- footer -->
</body>
</html>