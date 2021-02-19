<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen"
		class="button large fit">말해주센<span class="icon solid alt fa-home"></span></a></li>
	<li></li>
	<li><a href="/tellcen/notice/noticeList" class="button large fit">공지사항</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>공지사항</h1>
			</header>
			<h2>${notice.noticeTitle }</h2>
			<div class="box">
				<b>공지일</b>&nbsp;&nbsp;<fmt:formatDate value="${notice.noticeDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>조회수</b>&nbsp;&nbsp;${notice.noticeCount }&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<blockquote>${notice.noticeContent }</blockquote>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />