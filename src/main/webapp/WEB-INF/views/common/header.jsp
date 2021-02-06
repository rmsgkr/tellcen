<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>말해주센</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="/tellcen/resources/css/main.css" />
<noscript>
	<link rel="stylesheet" href="/tellcen/resources/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header --> 
		<header id="header" class="alt">
			<a href="/tellcen/" class="logo"><strong>아이티센그룹</strong> <span>이근학</span></a>
			<nav>
				<a href="#menu">Menu</a>
			</nav>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<ul class="actions stacked">
				<li><a href="/tellcen/petition/petitionWrite" class="button fit">청원하기</a></li>
				<li><a href="#" class="button fit">민원신청</a></li>
				<li><a href="#" class="button fit">국민제안</a></li>
				<li><a href="#" class="button fit">공지사항</a></li>
				<li><a href="#" class="button fit">오류·이용 문의</a></li>
			<!-- 일반 회원 로그인 시 -->
			<c:if test="${member != null && member.author != 1}">
				<li><a href="#" class="button fit">마이페이지</a></li>
			</c:if>
			<!-- 관리자 로그인 시 -->
			<c:if test="${member.author == 1}">
				<li><a href="/tellcen/admin" class="button primary fit">관리자페이지</a></li> 
			</c:if>
			
			</ul>
			<ul class="links">
			<!-- 로그인 안했을 때 -->
			<c:if test="${member == null }">
				<li><a href="/tellcen/member/login" class="button primary fit">로그인</a></li>
				<li><a href="/tellcen/member/signup" class="button primary fit">회원가입</a></li>
				<li><a href="/tellcen/member/seekId" class="button primary fit">아이디찾기</a></li>
				<li><a href="/tellcen/member/seekPwd" class="button primary fit">비밀번호찾기</a></li>
			</c:if>
			<!-- 일반 회원/관리자 로그인 시 -->
			<c:if test="${member != null }">
				<li><a href="/tellcen/member/logout" class="button primary fit">로그아웃</a></li>
			</c:if>
			</ul>
			
		</nav>