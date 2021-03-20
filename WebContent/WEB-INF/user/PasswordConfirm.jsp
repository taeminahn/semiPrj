<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>

	$(function() {
		
		function checkFunc() {
			var check = 0;
			var userPwd = $('#userPwd').val().length;
			if (userPwd == 0) {
				alert('비밀번호를 입력해주세요.');
				check++;
			}
			return check;
		}

		$('#submit').click(function() {
			console.log('h');
			var userPwd = $('#userPwd').val();
			console.log(userPwd);
			var emptyCheck = checkFunc();
			if (emptyCheck == 0) {
				$.ajax({
					type : "post",
					url : "password",
					data : {
						"userPwd" : userPwd
					},
					success : function(resp) {
						console.log("hi")
						if (resp == 1) {
							window.location.href = "view?n=1";
						} else {
							alert("비밀번호가 틀렸습니다. 다시 입력해주세요")
						}
					},
					error : function(request, status, error) {
						location.href = "/naver.com"
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
         <span><a class="mini-item" href="/myPage/view">마이페이지</a></span>
      </div>
   </c:if>
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
   <!-- 회원가입 -->
   <div class="row justify-content-center">
      <aside class="aside col-2" style="min-width:300px">
         <h4 class="text-center text-blue" style="line-height:50px">My Page</h4>
         <ul class="nav nav-pills flex-column text-left">
            <li class="nav-item mypageItem"><a class="nav-link pageLi text-dark " href="/mypage/view">- 내 정보 변경</a></li>
            <li class="nav-item mypageItem"><a class="nav-link pageLi text-dark " href="/withdrawbridge">- 회원탈퇴</a></li>
         </ul>
      </aside>
      <div class="body col-8" style="padding-left: 50px">
         <h2 class="text-center" style="line-height:50px">비밀번호 확인</h2>
         <form>
            <table class="table" style="text-align: center;">
               <tbody>
                  <tr >
                     <td style="width: 150px; text-align: left; padding-top:100px"><h5>비밀번호</h5></td>
                     <td style="padding-top:100px"><input class="form-control hopehover" type="password" id="userPwd"
                        name="userPwd" maxlength="15" placeholder="비밀번호를 입력하세요."></td>
                     
                  </tr>
               </tbody>
            </table>
            <br>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col text-center">
                     <br><input type="button" id="submit" value="확인" class="btn btn-primary btn-md">
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