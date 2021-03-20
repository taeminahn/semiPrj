<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:if test="${not empty userId}">
		<div class="mini-navbar" style="text-align: right;">
			<span>${userId}님 환영합니다.</span>&nbsp;|&nbsp;
			<span><a class="mini-item" href="/mypage/view">마이페이지</a>&nbsp;|&nbsp;
				<a class="mini-item" onclick="return confirm('로그아웃 하시겠습니까?')" href="/logout">로그아웃</a></span> 
		</div>
	</c:if>
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
	<!-- view-main -->
	<h3 class="text-center">맛집 정보</h3>
	<br>
	<div class="container" id="main">
		<table class="table">
			<tbody class="thead-dark text-center">
				<tr>
					<td class="text-center" style="width:150px; background:lightgray">
						<span>분 류</span>
					</td>
					<td class="text-center">
						<span>${dv.kind}</span>
					</td>
					<td class="text-center" style="width:150px; background:lightgray">
						<span>평점</span>
					</td>
					<td class="text-center"> 
					<span>${dv.grade}</span>
					</td>
				</tr>
				<tr>
					<td class="text-center" style="width:150px; background:lightgray">
						<span>작성자</span>
					</td>
					<td class="text-center">
						<span>${dv.bbsWriter}</span>
					</td>
					<td class="text-center" style="width:150px; background:lightgray">
						<span>작성일</span>
					</td>
					<td class="text-center"> 
					<span>${dv.bbsTime}</span>
					</td>
				</tr>
				<tr class="text-center">
					<td style="width:150px; background:lightgray">글 제목</td>
					<td colspan="4">${dv.bbsTitle}</td>
				</tr>
				<tr class="text-center" style="height:300px; ">
					<td style="vertical-align:middle; width:150px; background:lightgray ">내 용</td>
					<td colspan="4" style="min-height: 200px; text-align: center; vertical-align:middle">
					<span>${dv.bbsContent}</span>
					</td>
				</tr>
			</tbody>
		</table>

		<div class="container">
		<div class="row">
		<div class="col-lg-5">
		<a href="list" class="btn btn-primary">목록</a>
		</div>
		<!-- 만약 해당글의 작성자가 본인이라면 -->
		<div class="col-lg-7 text-right">
	      <c:if test="${dv.bbsWriter eq userId}">
	      <a href="detail?number=${dv.bbsNum}" class="btn btn-primary">수정</a>
	      <a href="delete?num=${dv.bbsNum}" class="btn btn-primary">삭제</a>
	      </c:if>
	      
	      <c:if test="${dv.bbsWriter != userId}">
	      <button onclick="history.back()" class="btn btn-primary" >뒤로</button>
	      </c:if>
		</div>
		</div>
		</div>
	</div>	
	<!-- footer -->
	<div style="height: 100px;"></div>
</body>
</html>
