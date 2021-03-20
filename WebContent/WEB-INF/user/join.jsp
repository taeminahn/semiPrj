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
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 다음 주소 api 사용 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
.Gender { 
   text-align : left;
   width : 50px;
   position : static;
}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    // document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    // document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById('roadAddress').value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('detailAddress').focus();
            }
        }).open();
    }
</script>
<script>
   $(function(){
      var checkId = false;
      var checkPw = false;
      var checkPwc = false;
      var checkName = false;
      var checkPhone = false;
      var checkGender = false;
      var checkBirth = false;
      var checkEmail = false;
      // 아이디 중복&유효성 검사
      $('#userId').focusout(function(){
            var userId = $('#userId').val();
             var idCheck = RegExp(/^[A-Za-z0-9_\-]{5,20}$/);
             if(idCheck.test(userId) == false){
                $('#idCheck').text('5~20자의 영문 대소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.').css('color','red');
             }else{
                $.ajax({
                   url:'/joinCheck',
                   data: {mbId : userId},
                   success:function(data){
                      if(data == userId){
                         $('#idCheck').text('해당 아이디는 현재 사용 중 입니다.').css('color','red');
                         checkId = false;
                      }else{
                         $('#idCheck').text('사용가능한 아이디입니다.').css('color','green');
                         checkId = true;
                      }
                   },
                   error: function(request, status, error){
                 } 
                });
             }
        });
      // 비밀번호 유효성 검사
      $('#userPw').focusout(function(){
         var userPw = $('#userPw').val();
         var pwCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]).{8,16}$/);
         if(pwCheck.test(userPw) == false){
                $('#pwCheck').text('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.').css('color','red').show();
                $('#pwCheck1').hide();
                checkPw = false;
             }else{
                $('#pwCheck').hide();
                checkPw = true;
             }
      });
      // 비밀번호 중복 검사
      $('#userPwCheck').focusout(function(){
         var userPw = $('#userPw').val();
         var userPwCheck = $('#userPwCheck').val();
         var pwCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\,.<>\/?]).{8,16}$/);
         
         if(userPw != userPwCheck){
            $('#pwCheck1').text('비밀번호를 다시 확인해주세요.').css('color','red').show();
            checkPwc = false;
          }else{
             $('#pwCheck1').text('비밀번호가 일치합니다.').css('color','green').show();
             checkPwc = true;
         }
      });
      // 이름 유효성 검사
      $('#userName').focusout(function(){
         var userName = $('#userName').val();
         var userNameC = 0;
         var userNameCheck = RegExp(/^[가-힣]{2,6}$/);
         if(userNameCheck.test(userName) == false){
            $('#nameCheck').text('2~6자 한글만 입력해주세요.').css('color','red').show();
            checkName = false;
         }else{
            $('#nameCheck').hide();
            checkName = true;
         }
      });
      // 전화번호 유효성 검사
      $('#userPhone').focusout(function(){
         var userPhone = $('#userPhone').val();
         var phoneCheck = RegExp(/^01[0179][0-9]{7,8}$/);
         if(phoneCheck.test(userPhone) == false){
            $('#phoneCheck').text('다시 입력해주세요.').css('color','red').show();
            checkPhone = false;
         }else{
            $('#phoneCheck').hide();
            checkPhone = true;
         }
      });
      // 성별 유효성 검사
      $("input[name='userGender']").focusout(function(){
         var userGender = $("input[name='userGender']:checked").val();
         checkGender = false;
         if(userGender != null){
            $('#genderCheck').hide();
            checkGender = true;
         }
      });
      // 생년월일 유효성 검사
      $('#userBirth').focusout(function(){
         var birth = $('#userBirth').val();
         checkBirth = false;
         if(birth != null){
            $('#birthCheck').hide();
            checkBirth = true;
         }
      });
      // 이메일 유효성 검사
      $('#userEmail').focusout(function(){
         var email = $('#userEmail').val();
         var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
         if(emailCheck.test(email) == false){
            $('#emailCheck').text('이메일 형식을 다시 확인해주세요.').css('color','red').show();
            checkEmail = false;
         }else{
            $('#emailCheck').hide();
            checkEmail = true;
         }
      });
      // 각 항목들 null체크 & 각 항목들 유효성 체크 완료 시 데이터 전송
      $('form').submit(function() {
         var id = $('#userId').val();
         var pw = $('#userPw').val();
         var pwCheck = $('#userPwCheck').val();
         var name = $('#userName').val();
         var gender = $("input[name='userGender']:checked").val();
         var birthDay = $('#userBirth').val();
         var phone = $('#userPhone').val();
         var address1 = $('#postcode').val();
         var address2 = $('#roadAddress').val();
         var address3 = $('#detailAddress').val();
         var email = $('#userEmail').val();
         if(id == ""){
            $('#idCheck').text('필수 정보입니다.').css('color','red');
         }
         if(pw == ""){
            $('#pwCheck').text('필수 정보입니다.').css('color','red').show();
         }
         if(name == ""){
            $('#nameCheck').text('필수 정보입니다.').css('color','red');
            
         }
         if(gender == null){
            $('#genderCheck').text('필수 정보입니다.').css('color','red').show();
         }
         if(birthDay == ""){
            $('#birthCheck').text('필수 정보입니다.').css('color','red').show();
         }
         if(phone == ""){
            $('#phoneCheck').text('필수 정보입니다.').css('color','red');
         }
         if(address1 == null || address2 == null || address3 == null){
            $('#addressCheck').text('필수 정보입니다.').css('color','red');
         }
         if(email == ""){
            $('#emailCheck').text('필수 정보입니다.').css('color','red').show();
         }
         if(checkId == true && checkPw == true && checkPwc == true && checkName == true &&
         checkPhone == true && checkGender == true && checkBirth == true && checkEmail == true){
            $.ajax({
               type : "post",
               url : "/join/reg",
               data : {
                  "userID" : id,
                  "userPassword" : pw,
                  "userPwCheck" : pwCheck,
                  "userName" : name,
                  "userGender" : gender,
                  "userBirth" : birthDay,
                  "userPhoneNumber" : phone,
                  "userAddress1" : address1,
                  "userAddress2" : address2,
                  "userAddress3" : address3,
                  "userEmail" : email
               },
               success : function(result){
                  if(result == 1){
                     alert("회원가입에 성공하셨습니다.")
                     window.location.href = "/main";
                  } else {
                     alert("회원가입 실패.")
                  }
               },
               error : function(request, status, error){
                  location.href = "/error";
               }
            });
         }else{
            alert("회원정보를 다시 확인해주세요");
         }
      });
   });
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
   <!-- 회원가입 -->
      <h2 class="text-center">회원가입</h2>
      <div class="container">
         <div class="col-md-2"></div>
         <div class="col-md-8"></div>
         <div class="col-md-2"></div>
      </div>
      
      
      <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6 justify-content-center">
      <br>
         <form class="form-signin" method="post" onsubmit="return false;">
            <table class="table table-hover" style="text-align:center;">
               <tbody>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>아이디</h5></td>
                     <td><input class="form-control" type="text" id="userId" name="userID" maxlength="15" placeholder="아이디를 입력하세요."><br>
                        <span id="idCheck"></span>
                     </td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>비밀번호</h5></td>
                     <td><input class="form-control" type="password" id="userPw" name="userPw" maxlength="15" placeholder="패스워드를 입력하세요."><br>
                        <span id="pwCheck"></span></td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>비밀번호 확인</h5></td>
                     <td><input class="form-control" type="password" id="userPwCheck" name="userPwCheck" maxlength="15" placeholder="패스워드를 입력하세요."><br>
                        <span id="pwCheck1"></span>
                     </td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>이름</h5></td>
                     <td><input class="form-control" type="text" id="userName" name="userName" maxlength="5" placeholder="이름을 입력하세요."><br>
                        <span id="nameCheck"></span>
                     </td>
                  
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>성별</h5></td>
                     <td style="text-align:left; with:30px">
                     남자<input class="form control Gender" type="radio" id="man" name="userGender" value="남자" />
                     여자<input class="form control Gender" type="radio" id="woman" name="userGender" value="여자" /><br>
                        <span id="genderCheck"></span>
                     </td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>생년월일</h5></td>
                     <td><input class="form-control" type="date" max="local" id="userBirth" name="userBirth"><br>
                        <span id="birthCheck"></span></td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>전화번호</h5></td>
                     <td><input class="form-control" type="text" id="userPhone" name="userPhone" maxlength="11" placeholder="(-)빼고 입력해주세요."><br>
                        <span id="phoneCheck"></span>
                     </td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>주소</h5></td>
                     <td><!-- <input class="form-control col-lg-7" style="float:left;" type="text" id="userAddress" name="userAddress"> -->
                        <span id="userAddress">
                           <input type="text" class="form-control" style="float:left;" readonly id="postcode" placeholder="우편번호">
                           <input type="text" class="form-control" style="float:left;" readonly id="roadAddress" placeholder="도로명주소" ><br>
                           <input type="hidden" id="jibunAddress" placeholder="지번주소"  size="60">
                           <span id="guide" style="color:#999;display:none"></span>
                           <input type="text" class="form-control" id="detailAddress" placeholder="상세주소"><br>
                           <input type="hidden" id="extraAddress" placeholder="참고항목">
                           <input type="hidden" id="engAddress" placeholder="영문주소">
                           <!-- <input class="form-control col-md-4" type="button" onclick="PoscCode()" value="상세주소 검색"><br><br><br> -->
                        </span>   
                        <span>
                           <input type="button" class="form-control col-lg-5 btn-secondary" style="float:right;" onclick="execDaumPostcode()" value="우편번호 찾기">
                        </span>
                        <span id="addressCheck"></span>
                     </td>
                  </tr>
                  <tr>
                     <td style="width:150px; text-align:left"><h5>이메일</h5></td>
                     <td><input class="form-control" type="email" id="userEmail" name="userEmail" maxlength="20" placeholder="이메일을 입력하세요." ><br>
                        <span id="emailCheck"></span>
                     </td>
                  </tr>
               </tbody>
            </table>
               <div class="container">
               <div class="row">
               <div class="col text-center"><br>
               <button type="submit"  class="btn btn-primary btn-lg">회원가입</button>
               </div>
               </div>
               </div>
               <br>
               <br><br>
         </form>
         
         
      </div>
      <div class="col-md-3"></div>
      </div>
      
   
   <!-- footer -->
</body>
</html>