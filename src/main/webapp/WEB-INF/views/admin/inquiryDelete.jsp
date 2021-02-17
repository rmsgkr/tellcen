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
				<h1>문의 삭제하기</h1>
			</header>
			<h3>해당 문의</h3>
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
			<form method="post" class="inquiryDelete" name="deleteForm"
				action="<%=request.getContextPath()%>/admin/inquiry/${inquiry.inquiryNo }/delete">
			</form>
			<input type="button" class="button primary large" value="삭제하기"
				onclick="button()" style="float: right"> <br> <br>
		</div>
	</section>
</div>
<script>
	function button() {
		
		deleteForm.submit();
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />