<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/adminHeader.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>공지 삭제</h1>
			</header>
			<h2>${notice.noticeTitle }</h2>
			<div class="box">
				<b>공지일</b>&nbsp;&nbsp;<fmt:formatDate value="${notice.noticeDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>조회수</b>&nbsp;&nbsp;${notice.noticeCount }&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<blockquote>
			<img src="<%=request.getContextPath() %>/resources/upload/${notice.noticeFile}" ><br><br><br><br>
			${notice.noticeContent }
			</blockquote>
			
			<form method="post" class="noticeDelete" name="deleteForm"
				action="<%=request.getContextPath()%>/admin/notice/${notice.noticeNo }/delete">
			</form>
			<input type="button" class="button primary large" value="삭제하기"
				onclick="button()" style="float: right">
			<br> <br>
		</div>
	</section>
</div>
<script>
	function button() {
		
		deleteForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />