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
				<h1>로그인</h1>
			</header>
			<form id="formLogin" method="post" action="login" class="loginForm">
			<div class="row gtr-200">
				<!-- Content -->
				<div class="col-9 col-12-medium">
					<input type="text" name="id" id="id" value="" placeholder="아이디" autocomplete="off"/> 
					<input type="password" name="pwd" id="pwd" value="" placeholder="비밀번호" />
				</div>
				<div class="col-3 col-12-medium">
					<button type="button" class="button primary large" onclick="button();">Login</button>
				</div>
			</div>
			</form>
			<hr class="major" />
			<div class="row gtr-200">
				<ul class="actions fit">
					<li><a href="/tellcen/member/signup" class="button">회원가입</a></li>
					<li><a href="/tellcen/member/seekMemberId" class="button">아이디찾기</a></li>
					<li><a href="/tellcen/member/seekMemberPwd" class="button">비밀번호찾기</a></li>
				</ul>
			</div>
		</div>

	</section>
</div>
<script>
	function button() {
		const loginForm = document.querySelector('.loginForm');
		if (loginForm.id.value == "") {
			alert('아이디를 입력해주세요.');
			loginForm.id.focus();
			return;
		}
		if (loginForm.pwd.value == "") {
			alert('비밀번호를 입력해주세요.');
			loginForm.pwd.focus();
			return;
		}
		loginForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />