<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<!-- login 상태일 때 -->
	<c:if test="${not empty userId}">
		<div class="mini-navbar" style="text-align: right;">
			<span>${userId}님 환영합니다.</span>&nbsp;|&nbsp; 
			<span><a class="mini-item" href="/mypage/view">마이페이지</a>&nbsp;|&nbsp;
				<a class="mini-item" onclick="return confirm('로그아웃 하시겠습니까?')" href="/logout">로그아웃</a></span>
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
	<!-- board-main -->
	<h3 class="text-center">자유 게시판</h3>
	<br>
	<div class="container">
		<div class="col-md-2"></div>
		<table class="table">
			<thead class="thead-dark text-center">
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>글제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${list}">
					<tr class="text-center">
						<td>${n.boardNum}</td>
						<td>${n.boardWriter}</td>
						<td><a style="text-decoration:none; color:#000000" href="/freeboard/detail?id=${n.boardId}">${n.boardTitle} <span style="color:orange;">[${(n.cmtCount != 0)?n.cmtCount:0}]</span></a></td>
						<td>${n.boardPubDate}</td>
						<td>${n.boardHit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-md-2"></div>
	</div>
	<!-- board-pagination -->
	<div>
	<c:set var="page" value="${(empty param.p)?1:param.p}"/>
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10),'.')}" />
	
		<ul class="pagination justify-content-center">
			<c:if test="${param.p-5 >= 1 and not empty param.p}">
				<li class="page-item"><a class="page-link" href="?p=${startNum-1}&f=&q="><<</a></li>
			</c:if>
			<c:if test="${param.p-5 < 1 || empty param.p}">
				<li class="page-item disabled"><a class="page-link"><<</a></li>
			</c:if>
			<c:if test="${param.p!=1 and not empty param.p}">
				<li class="page-item"><a class="page-link" href="?p=${param.p-1}&f=&q="><</a></li>&nbsp;&nbsp;
			</c:if>
			<c:if test="${param.p==1 || empty param.p}">
				<li class="page-item disabled"><a class="page-link"><</a></li>&nbsp;&nbsp;
			</c:if>
			<c:forEach var="i" begin="0" end="4">
				<c:if test="${(startNum+i) <= lastNum }">
					<li class="page-item ${(page==(startNum+i))?'active':''}"><a class="page-link" href="list?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${page+1 <= lastNum}">
				&nbsp;&nbsp;<li class="page-item"><a class="page-link" href="?p=${page+1}&f=&q=">></a></li>
			</c:if>
			<c:if test="${page+1 > lastNum}">
				&nbsp;&nbsp;<li class="page-item disabled"><a class="page-link" href="?p=${page+1}&f=&q=">></a></li>
			</c:if>
			<c:if test="${startNum+4<lastNum}">
				<li class="page-item"><a class="page-link" href="?p=${startNum+5}&f=&q=">>></a></li>
			</c:if>
			<c:if test="${startNum+4>lastNum}">
				<li class="page-item disabled"><a class="page-link" href="?p=${startNum+5}&f=&q=">>></a></li>
			</c:if>
		</ul>
	</div>
	<!--  -->
	<div class="container">
		<div class="col-1"></div>		
		<hr class="col-10">
		<div class="col-1"></div>
	</div>
	<div class="container">
		<div class="row">
			<c:if test="${not empty userId}">
				<div class="col-4">
					<a href="/freeboard/writeaction" class="btn btn-md btn-primary" id="write">글쓰기</a>
				</div>
			</c:if>
			<c:if test="${empty userId}">
				<div class="col-4">
					<a class="btn btn-md btn-primary" id="nologwrite">글쓰기</a>
				</div>
			</c:if>
			<Script>
				$('#nologwrite').click(function(){
					alert('로그인 후 글작성 가능합니다.');
					window.location.href = "/login";
				});
			</Script>
			
			
			<div class="col-3"></div>
			<div class="container col-5">
			<form>
				<div class="input-group justify-content-right">
					<div class="form-group-append">
						<select class="form-control" name="f">
							<option ${(param.f == "B_TITLE")?"Selected":""} value="B_TITLE">글제목</option>
							<option ${(param.f == "B_WRITER")?"Selected":""} value="B_WRITER">작성자</option>
						</select>
					</div>
					<input type="text" class="form-control" placeholder="Search" name="q" value="${param.q}">
					<div class="input-group-append">
						<button class="btn btn-success" type="submit">Go</button>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div style="height: 100px;"></div>
</body>
</html>
