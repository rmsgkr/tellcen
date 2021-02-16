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
				<h1>제안 답변하기</h1>
			</header>
			<form method="post" class="answerSWrite" name="writeForm"
				action="<%=request.getContextPath()%>/admin/suggestion/${suggestion.suggestionNo }/answer">
				<div class="fields">
					<div class="field">
						<h3>답변내용</h3>
						<textarea name="answerSContent" id="answerSContent" rows="6"
							placeholder="답변 내용을 입력하세요."></textarea>
					</div>
				</div>
			</form>
			<input type="button" class="button primary large" value="답변하기"
				onclick="button()" style="float: right"> <br> <br>
			<br> <br><hr>
			<h3>해당 제안</h3>
			<div class="box">
				<b>[제안인]</b>&nbsp;&nbsp;${suggestion.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[제안일]</b>&nbsp;&nbsp;<fmt:formatDate value="${suggestion.suggestionDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="field">
				<h4>제목:${suggestion.suggestionTitle}</h4>
				<div class="box">
					<h4><b>●  현황 및 문제점</b></h4><br>
					${suggestion.suggestionProblem }
					<br><br><br><br>
					<h4><b>●  개선방안</b></h4><br>
					${suggestion.suggestionPlan }
					<br><br><br><br>
					<h4><b>●  기대효과</b></h4><br>
					${suggestion.suggestionEffect }
					<br><br>
				</div>
			</div>
		</div>
	</section>
</div>
<script>
	function button() {
		if (writeForm.answerSContent.value == "") {
			alert('내용을 입력해주세요.');
			writeForm.answerSContent.focus();
			return;
		}
		writeForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />