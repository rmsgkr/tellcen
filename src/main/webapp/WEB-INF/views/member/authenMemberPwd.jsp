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
				<h1>비밀번호 찾기</h1>
			</header>
			<form id="formAuth" method="post" action="authenMemberPwd" class="authenForm">
			<div class="row gtr-200">
			<strong>
					<br>
					입력하신 이메일로 인증번호를 보냈습니다.<br>
					인증번호를 10분 안에 입력해주세요.<br>
					</strong>
					<br><br><br> 
 				<div class="col-9 col-12-medium">
					<input type="text" name="key" placeholder="인증번호">
				</div>
				<div class="col-3 col-12-medium">
					<button type="button" class="button primary large" onclick="button();">제출하기</button>
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
      function button() {
			const authenForm = document.querySelector('.authenForm');
			if (authenForm.key.value == "") {
				alert('인증번호를 입력해주세요.');
				authenForm.key.focus();
				return;
			}
			authenForm.submit();
		}
</script> 
<jsp:include page="/WEB-INF/views/common/footer.jsp" />