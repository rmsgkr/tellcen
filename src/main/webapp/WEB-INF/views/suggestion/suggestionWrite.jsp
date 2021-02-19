<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen"
		class="button large fit">말해주센<span class="icon solid alt fa-home"></span></a></li>
	<li></li>
	<li><a href="/tellcen/suggestion/suggestionInfo"
		class="button large fit">제안이란?</a></li>
	<li><a href="/tellcen/suggestion/suggestionWrite"
		class="button large fit">제안하기</a></li>
	<li><a href="/tellcen/suggestion/suggestionList"
		class="button large fit">제안목록</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>제안하기</h1>
			</header>
			<h3>운영원칙 및 주의사항</h3>
			<div class="box">
				<b style="color: skyblue">제안</b>은 국민의 참여를 통해 다수가 공감하는 제안이 정책으로 반영될 수 있도록 공개하는 국민제안입니다.<br><br>
				정상적으로 신청하였다 하더라도 민원이관 등 제안 외 처리, 개인정보 유출 또는 동일 내용의 반복적인 게재 등인 경우에는 <br>
				관리자에 의해 <b style="color: #F08080">비공개로 전환</b>될 수 있습니다.<br><br>
				또한, 따로 기관을 선택하지 않고 신청하여 말해주센에서 제안을 분석하고 <b style="color: skyblue">유연한 적용</b>을 할 수 있도록 합니다. 
				
			</div>
			<form method="post" class="suggestionWrite" name="writeForm"
				action="suggestionWrite">
				<div class="fields">
					<div class="field">
						<h3>제안 제목</h3>
						<input type="text" name="suggestionTitle" id="suggestionTitle"
							placeholder="제안 제목을 입력하세요." autocomplete="off"/>
					</div>
					<div class="field">
						<h3>현황 및 문제점</h3>
						<textarea name="suggestionProblem" id="suggestionProblem" rows="6"
							placeholder="현황 및 문제점을 입력하세요."></textarea>
					</div>
					<div class="field">
						<h3>개선방안</h3>
						<textarea name="suggestionPlan" id="suggestionPlan" rows="6"
							placeholder="개선방안을 입력하세요."></textarea>
					</div>
					<div class="field">
						<h3>기대효과</h3>
						<textarea name="suggestionEffect" id="suggestionEffect" rows="6"
							placeholder="기대효과를 입력하세요."></textarea>
					</div>
				</div>
			</form>
			<input type="button" class="button primary large" value="신청하기"
				onclick="button()" style="float: right"> <br> <br>
			<br> <br>
		</div>
	</section>
</div>
<script>
	function button() {
		if (writeForm.suggestionTitle.value == "") {
			alert('제목을 입력해주세요.');
			writeForm.suggestionTitle.focus();
			return;
		}
		if (writeForm.suggestionProblem.value == "") {
			alert('현황 및 문제점을 입력해주세요.');
			writeForm.suggestionProblem.focus();
			return;
		}
		if (writeForm.suggestionPlan.value == "") {
			alert('개선방안을 입력해주세요.');
			writeForm.suggestionPlan.focus();
			return;
		}
		if (writeForm.suggestionEffect.value == "") {
			alert('기대효과를 입력해주세요.');
			writeForm.suggestionEffect.focus();
			return;
		}
		writeForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />