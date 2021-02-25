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
				<h1>공지 수정</h1>
			</header>
			<form method="post" class="noticeModify" name="modifyForm"  enctype="multipart/form-data"
				action="<%=request.getContextPath()%>/admin/notice/${notice.noticeNo }/modify">
			<h2><input type="text" name="noticeTitle" id="noticeTitle" value="${notice.noticeTitle }"></h2>
			<div class="box">
				<b>공지일</b>&nbsp;&nbsp;<fmt:formatDate value="${notice.noticeDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>조회수</b>&nbsp;&nbsp;${notice.noticeCount }&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<blockquote><textarea name="noticeContent" id="noticeContent" rows="6">${notice.noticeContent }</textarea></blockquote>
			<div class="field">
					<h3>이미지파일</h3>
					<input type="file" size="40" maxlength="30" name="file" id="file"><br>
					(기존 이미지파일: ${notice.noticeFile})
					</div>
			</form>
			<input type="button" class="button primary large" value="수정하기"
				onclick="button()" style="float: right">
			<br> <br>
		</div>
	</section> 
</div>
<script>
	function button() {
		
		modifyForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />