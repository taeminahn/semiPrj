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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
<script>
	$(function(){
		
	function checkText() {
		var check = 1;
		var bbsTitle = $('#bbsTitle').val().length;
		var bbsContent = $('#bbsContent').val().length;
		
		if(bbsTitle == 0 ) {
			alert("글 제목을 입력하세요.");
			check = 0;
		}
		if(bbsContent == 0 ) {
			alert("내용을 입력하세요.");
			check = 0;
		}
		return check;
	}
	

	$('#registComp').click(function() {
			var bbsTitle = $('#bbsTitle').val();
			var bbsContent = $('#bbsContent').val();
			var RtKind = $('#RtKind').val();
			var RtGrade = $('#RtGrade').val();

			var emptyCheck = checkText();
			 if (emptyCheck == 1) {
				$.ajax({
					type : "post",
					url : "/foodboard/write",
					data : {
						"bbsTitle" : bbsTitle,
						"bbsContent" : bbsContent,
						"RtKind" : RtKind,
						"RtGrade" : RtGrade
					},
					success : function(resp) {
						if (resp == 1) {
							alert('글이 등록되었습니다.')
							window.location.href = "/foodboard/list";
						} else {
							alert("글이 등록되지 않았습니다.")
						}
					},
					error : function(request, status, error) {
						location.href = "naver.com"
					}
				})
			}
		})

		
		
		$('#updateComp').click(function() {
			var bbsTitle = $('#bbsTitle').val();
			var bbsContent = $('#bbsContent').val();
			var RtKind = $('#RtKind').val();
			var RtGrade = $('#RtGrade').val();
			var bbsNum = $('#bbsNum').val();
			console.log('ht');

			var emptyCheck = checkText();
			if (emptyCheck == 1) {
				$.ajax({
					type : "post",
					url : "/foodboard/update",
					data : {
						"bbsTitle" : bbsTitle,
						"bbsContent" : bbsContent,
						"RtKind" : RtKind,
						"RtGrade" : RtGrade,
						"bbsNum" : bbsNum
					},
					success : function(resp) {
						if (resp == 1) {
							alert('글이 등록되었습니다.')
							window.location.href = "/foodboard/detail?num="+bbsNum;
						} else {
							alert("글이 등록되지 않았습니다.")
						}
					},
					error : function(request, status, error) {
						location.href = "naver.com"
					}
				})
			}
		});

	})
</script>
</head>
<body>
	<!-- header -->
	<div class="p-3 my-3 bg-white text-center" style="margin-bottom: 0;">
		<h1 class="title">OSOL</h1>
		<p>KH 커뮤니티에 오신 것을 환영합니다</p>
	</div>
	<!-- login/sign up -->
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
			<li class="nav-item"><a class="nav-link " href="main.jsp">Home</a></li>
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
	<!-- write-main -->
	<c:if test="${empty dv.bbsNum} ">
	<h3 class="text-center">글쓰기</h3>
	</c:if>
	
	<c:if test="${not empty dv.bbsNum}">
	<h3 class="text-center">수정하기</h3>
	</c:if>
	
	<br>
	<div class="container" id="main">			
	<form method="POST" name="writeForm" onsubmit="return false">
		<table class="table">
			<thead class="thead-dark text-center">
				<tr>
					<td class="text-center" style="width:80px" >
						<span>분류</span>
					</td>
					<td class="text-left" style="width:300px">
						<c:if test="${not empty dv.bbsNum}">
						<select name="RtKind" id="RtKind">
							<option value="한식" 	${dv.kind eq '한식'?"selected":''}>한식</option>
							<option value="중식" ${dv.kind eq '중식'?"selected":''}>중식</option>
							<option value="양식" ${dv.kind eq '양식'?"selected":''}>양식</option>
							<option value="일식" ${dv.kind eq '일식'?"selected":''}>일식</option>
							<option value="기타" ${dv.kind eq '기타'?"selected":''}>기타</option>
						</select>
						</c:if>
						<c:if test="${empty dv.bbsNum}">
						<select name="RtKind" id="RtKind">
							<option value="한식">한식</option>
							<option value="중식">중식</option>
							<option value="양식">양식</option>
							<option value="일식">일식</option>
							<option value="기타">기타</option>
						</select>
						</c:if>
					</td>
					<td class="text-right" >
						<span>평점</span>
					</td>
					<td class="text-left">
						<c:if test="${not empty dv.bbsNum}">
						<select style="width:120px" name="RtGrade" id="RtGrade">
							<option value="★★★★★" ${dv.grade == '★★★★★'?"selected":''}>★★★★★</option>
							<option value="★★★★☆" ${dv.grade == '★★★★☆'?"selected":''}>★★★★☆</option>
							<option value="★★★☆☆" ${dv.grade == '★★★☆☆'?"selected":''}>★★★☆☆</option>
							<option value="★★☆☆☆" ${dv.grade == '★★☆☆☆'?"selected":''}>★★☆☆☆</option>
							<option value="★☆☆☆☆" ${dv.grade == '★☆☆☆☆'?"selected":''}>★☆☆☆☆</option>
						</select>
						</c:if>
						<c:if test="${empty dv.bbsNum}">
						<select style="width:120px" name="RtGrade" id="RtGrade">
							<option value="★★★★★">★★★★★</option>
							<option value="★★★★☆">★★★★☆</option>
							<option value="★★★☆☆">★★★☆☆</option>
							<option value="★★☆☆☆">★★☆☆☆</option>
							<option value="★☆☆☆☆">★☆☆☆☆</option>
						</select>
						</c:if>
					</td>
				</tr>
				<tr>
					<c:if test="${dv.bbsNum != null}">
						<td colspan="4"><input type="text" class="form-control"
							placeholder="글 제목" name="bbsTitle" id="bbsTitle" maxlength="50"
							value = "${dv.bbsTitle != null? dv.bbsTitle : ''}">
						</td>
					</c:if>
					<c:if test="${dv.bbsNum == null}">
						<td colspan="4"><input type="text" class="form-control"
							placeholder="글 제목" name="bbsTitle" id="bbsTitle" maxlength="50">
						</td>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<tr class="text-left">
					<c:if test="${dv.bbsNum != null}">
					<td colspan="4"><textarea class="form-control"
						placeholder="글 내용" name="bbsContent" id="bbsContent" maxlength="2048"
						style="height: 350px">${dv.bbsContent != null? dv.bbsContent : ''}</textarea>
					<input type="hidden" id="bbsNum" value="${dv.bbsNum}">	
					</td>
					</c:if>	
					<c:if test="${dv.bbsNum == null}">
					<td colspan="4"><textarea class="form-control"
						placeholder="글 내용" name="bbsContent" id="bbsContent" maxlength="2048"
						style="height: 350px"></textarea>
					</td>
					</c:if>	
				</tr>
			</tbody>
		</table>
		
		<div class="text-right">
		<input type="reset" class="btn btn-primary" value="취소">
		
		<c:if test="${dv.bbsNum == null}">
		<input type="button" class="btn btn-primary" id="registComp" value="등록"  >
		</c:if>
		
		<c:if test="${dv.bbsNum != null}">
		<input type="button" class="btn btn-primary" id="updateComp" value="완료" >
		</c:if>		
		
		</div>
	</form>
	</div>	
	<!-- footer -->
	<div style="height: 100px;"></div>
</body>
</html>
