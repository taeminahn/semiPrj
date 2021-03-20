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
<!-- 반응형 웹 디자인 적용 -->
<meta name="viewport" content="width=device width" initial-scale="1">
<style>
/* html {
	background: url(resource/KakaoTalk_20210128_101406084.png) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
} */

</style>
</head>
<body>
	<!-- header -->
	<div class="p-3 my-3 bg-white text-center" style="margin-bottom: 0;">
		<h1 class="title">OSOL</h1>
		<p>KH 커뮤니티에 오신 것을 환영합니다</p>
	</div>
	<!-- login/sign up -->
	<!-- 비로그인 시 -->
	<c:if test="${empty userId}">
		<div class="mini-navbar" style="text-align: right;">
			<span><a class="mini-item" href="/login">로그인 </a></span>&nbsp;|&nbsp;
			<span><a class="mini-item" href="/join">회원가입</a></span>
		</div>
	</c:if>
	<!-- 로그인 성공 시 -->
	<c:if test="${not empty userId}">
		<div class="mini-navbar" style="text-align: right;">
			<span>${userId}님 환영합니다.</span>&nbsp;|&nbsp;
			<span><a class="mini-item" href="/mypage/view">마이페이지</a></span>&nbsp;|&nbsp;
			<span><a class="mini-item" href="/logout">로그아웃</a></span>
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
         <li class="nav-item"><a class="nav-link" href="board">Q n A</a></li>
      </ul>
   </nav>
	<br>
	<!-- view-main -->
	<h3 class="text-center">글수정</h3>
	<br>
	<div class="container" id="main">
	<form action="/qnaboard/updateAction" method="GET">
		<input type="hidden" class="form-control" name="num" value="${b.bbsNumber}"  />
		<table class="table">
			<tbody class="tbody-dark text-center">
				<tr class="text-center">
					<td style="width: 20%;">글 제목</td>
					<td colspan="2"><input type="text" class="form-control"
						placeholder="글 제목" name="bbsTitle" maxlength="50" value="${b.bbsTitle}" /></td>
				</tr>
				<tr class="text-center">
					<td>작성자</td>
					<td colspan="2" class="text-left">${b.bbsWriter}</td>
				</tr>
				<tr class="text-center">
					<td>작성일</td>
					<td colspan="2" class="text-left">${b.bbsPubdate}</td>
				</tr>
				<tr class="text-center">
					<td>내용</td>
					<td colspan="2" style="min-height: 200px; text-align: left;">
					<textarea class="form-control"
						placeholder="글 내용" name="bbsContent" maxlength="2048"
						style="height: 350px;">${b.bbsContent}</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<a href="qnaboard/board" class="btn btn-primary">목록</a>
		<!-- 만약 해당글의 작성자가 본인이라면 -->
		<input type="submit" onclick="return confirm('정말로 수정하시겠습니까?')" class="btn btn-primary float-right" value="수정">		
	</form>
	</div>	
	<!-- footer -->
	<div style="height: 100px;"></div>
</body>
</html>
