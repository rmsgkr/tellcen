<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/adminHeader.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>문의 답변하기</h1>
			</header>
			<form method="post" class="answerIWrite" name="writeForm"
				action="<%=request.getContextPath()%>/admin/inquiry/${inquiry.inquiryNo }/answer">
				<div class="fields">
					<div class="field">
						<h3>답변내용</h3>
						<textarea name="answerIContent" id="answerIContent" rows="6"
							placeholder="답변 내용을 입력하세요."></textarea>
					</div>
				</div>
			</form>
			<input type="button" class="button primary large" value="답변하기"
				onclick="button()" style="float: right"> <br> <br>
			<br> <br><hr>
			<h3>해당 민원</h3>
			<div class="box">
				<b>[아이디]</b>&nbsp;&nbsp;${inquiry.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[신청일]</b>&nbsp;&nbsp;<fmt:formatDate value="${inquiry.inquiryDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<div class="field">
					<div class="box">
					<h4>제목:${inquiry.inquiryTitle}</h4><br>
					${inquiry.inquiryContent }
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
<script>
	function button() {
		if (writeForm.answerIContent.value == "") {
			alert('내용을 입력해주세요.');
			writeForm.answerIContent.focus();
			return;
		}
		writeForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />