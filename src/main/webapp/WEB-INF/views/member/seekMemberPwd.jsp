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
			<form id="formSeek" method="post" action="seekMemberPwd" class="seekForm">
			<div class="row gtr-200">
 				<div class="col-9 col-12-medium">
					<input type="text" name="id" id="id" placeholder="아이디">
					<input type="text" name="email" placeholder="이메일">
				</div>
				<div class="col-3 col-12-medium">
					<button type="button" class="button primary large" onclick="button();">아이디찾기</button>
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
		const seekForm = document.querySelector('.seekForm');
		if (seekForm.name.value == "") {
			alert('이름을 입력해주세요.');
			seekForm.name.focus();
			return;
		}
		if (seekForm.email.value == "") {
			alert('이메일을 입력해주세요.');
			seekForm.email.focus();
			return;
		}
		seekForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />