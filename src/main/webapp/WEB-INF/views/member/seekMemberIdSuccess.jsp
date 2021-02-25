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
				<h1>아이디 찾기</h1>
			</header>
			
			<c:if test="${id != null}">
			<div class="box">
 				<b>회원님의 ID는 [ <u>${id }</u> ]</b>입니다.
			</div>	
			</c:if>
			<c:if test="${id == null}">
			<div class="box"> 
 				<u><b>입력하신 정보와 일치하는 아이디가 없습니다.</b></u>
			</div>	
			</c:if>
			
			<hr class="major" />
			<div class="row gtr-200">
				<ul class="actions fit">
					<li><a href="/tellcen/member/login" class="button">로그인</a></li>
					<li><a href="/tellcen/member/signup" class="button">회원가입</a></li>
					<li><a href="/tellcen/member/seekMemberPwd" class="button">비밀번호찾기</a></li>
				</ul>
			</div>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />