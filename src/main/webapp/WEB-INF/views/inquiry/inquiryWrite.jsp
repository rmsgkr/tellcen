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
				<h1>오류·이용 문의</h1>
			</header>
			<div class="box">
				<b style="color: #6495ED">말해주센</b><b> 이용과 관련하여 궁금하신 부분을 문의해주세요.</b><br><br>
				마이페이지에서 답변을 확인하실 수 있습니다.
			</div>
			<form method="post" class="inquiryWrite" name="writeForm"
				action="inquiryWrite" enctype="multipart/form-data">
				<div class="fields">
					<div class="field">
						<h3>제목</h3>
						<input type="text" name="inquiryTitle" id="inquiryTitle"
							placeholder="문의 내용을 잘 나타낼 수 있는 단어를 사용해주세요." autocomplete="off"/>
					</div>
					<div class="field">
						<h3>내용</h3>
						<textarea name="inquiryContent" id="inquiryContent" rows="6"
							placeholder="질문하시는 내용을 구체적으로 적어주시면 빠른 답변에 도움이 됩니다."></textarea>
					</div>
					<div class="field">
					<h3>첨부파일</h3>
					<input type="file" size="40" maxlength="30" name="file">
					</div>
				</div>
			</form>
			<input type="button" class="button primary large" value="문의하기"
				onclick="button()" style="float: right"> <br> <br>
			<br> <br>
		</div>
	</section>
</div>
<script>
	function button() {
		if (writeForm.inquiryTitle.value == "") {
			alert('제목을 입력해주세요.');
			writeForm.inquiryTitle.focus();
			return;
		}
		if (writeForm.inquiryContent.value == "") {
			alert('내용을 입력해주세요.');
			writeForm.inquiryContent.focus();
			return;
		}

		writeForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />