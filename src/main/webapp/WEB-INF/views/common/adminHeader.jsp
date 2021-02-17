<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>말해주센 관리자</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/tellcen/resources/css/main.css" />
<link rel="stylesheet" href="/tellcen/resources/css/jquery-ui.css" />
<noscript>
	<link rel="stylesheet" href="/tellcen/resources/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<a href="/tellcen/admin" class="logo"><strong>아이티센그룹</strong> <span>이근학
					[관리자]</span></a>
			<nav>
				<a href="#menu">Menu</a>
			</nav>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<ul class="actions stacked">
				<li><a href="/tellcen/" class="button fit">말해주센</a></li>
				<li><a href="/tellcen/member/logout" class="button primary fit">로그아웃</a></li>

			</ul>

		</nav>
		<ul class="links" id="adminSidebar">
			<li><a href="/tellcen/admin/member" class="button large fit">회원관리</a></li>
			<li></li>
			<li><a href="/tellcen/admin/petition" class="button large fit">청원
					관리</a></li>
			<li></li>
			<li><a href="/tellcen/admin/complaint" class="button large fit">민원
					관리</a></li>
			<li></li>
			<li><a href="/tellcen/admin/suggestion" class="button large fit">제안
					관리</a></li>
			<li></li>
			<li><a href="/tellcen/admin/inquiry" class="button large fit">문의
					관리</a></li>
			<li></li>
			<li><a href="/tellcen/admin/notice" class="button large fit">공지
					관리</a></li>
			
		</ul>