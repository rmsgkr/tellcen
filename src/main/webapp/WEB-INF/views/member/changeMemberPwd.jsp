<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">

			<header class="major">
				<h1>비밀번호 변경</h1>
			</header>
			<form id="formChange" method="post" action="changeMemberPwd" class="changeForm">
			<div class="row gtr-200">
 				<div class="col-9 col-12-medium">
					<input type="password" name="pwd" placeholder="비밀번호">
					<input type="password" name="rePwd" placeholder="비밀번호 확인" onkeyup="checkPwd()">
					<div id="checkPwd">동일한 암호를 입력하세요.</div>
				</div>
				<div class="col-3 col-12-medium">
					<button type="button" class="button primary large" onclick="changeButton();">변경하기</button>
				</div>
				</div>
			</form>
			<hr class="major" />
			<div class="row gtr-200">
				<ul class="actions fit">
					<li><a href="/tellcen/member/login" class="button">로그인</a></li>
					<li><a href="/tellcen/member/signup" class="button">회원가입</a></li>
					<li><a href="/tellcen/member/seekMemberId" class="button">아이디찾기</a></li>
				</ul>
			</div>
		</div>

	</section>
</div>
<script>
	function checkPwd(){
		  var f1 = document.forms[0];
		  var pwd = f1.pwd.value;
		  var rePwd = f1.rePwd.value;
		  if(pwd.length >= 7){
		  if(pwd!=rePwd){
		   document.getElementById('checkPwd').style.color = "red";
		   document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요.";
		  }else{
		   document.getElementById('checkPwd').style.color = "white";
		   document.getElementById('checkPwd').innerHTML = "암호가 확인 되었습니다.";
		  }
		  }else{
		   document.getElementById('checkPwd').innerHTML = "비밀번호를 7자리이상 입력하세요.";     
		  }
		  
		};
      function changeButton() {
			const changeForm = document.querySelector('.changeForm');
			if (changeForm.pwd.value == "") {
				alert('비밀번호를 입력해주세요.');
				changeForm.pwd.focus();
				return;
			}
			if (changeForm.rePwd.value == "") {
				alert('비밀번호를 입력해주세요.');
				changeForm.rePwd.focus();
				return;
			}
			if (changeForm.pwd.value != changeForm.rePwd.value) {
				alert('비밀번호가 일치하지 않습니다.');
				changeForm.rePwd.focus();
				return;
			}
			changeForm.submit();
		}
</script> 
<jsp:include page="/WEB-INF/views/common/footer.jsp" />