<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/adminHeader.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>공지 등록</h1>
			</header>
			<form method="post" class="noticeWrite" name="writeForm"
				action="<%=request.getContextPath()%>/admin/notice/write" enctype="multipart/form-data">
				<div class="fields">
					<div class="field">
						<h3>제목</h3>
						<input type="text" name="noticeTitle" id="noticeTitle"
							placeholder="공지사항 제목을 입력하세요." autocomplete="off"/>
					</div>
					<div class="field">
						<h3>내용</h3>
						<textarea name="noticeContent" id="noticeContent" rows="6"
							placeholder="공지사항 내용을 입력하세요."></textarea>
					</div>
					<div class="field">
					<h3>첨부파일</h3>
					<input type="file" size="40" maxlength="30" name="file" id="file">
					</div>
				</div>
			</form>
			<input type="button" class="button primary large" value="등록하기"
				onclick="button()" style="float: right"> <br> <br>
			<br> <br>
		</div>
	</section>
</div>
<script>
	function button() {
		if (writeForm.noticeTitle.value == "") {
			alert('제목을 입력해주세요.');
			writeForm.noticeTitle.focus();
			return;
		}
		if (writeForm.noticeContent.value == "") {
			alert('내용을 입력해주세요.');
			writeForm.noticeContent.focus();
			return;
		}

		writeForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />