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
				<h1>삭제(미승인)하기</h1>
			</header>
			<h3>해당 청원 - <b style="color: #F08080">조건 미 충족(동의수 - ${petition.petitionAgreement})</b></h3>
			<div class="box">
				<b>[지역]</b>&nbsp;&nbsp;${petition.petitionArea }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[분야]</b>&nbsp;&nbsp;${petition.petitionField }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[청원인]</b>&nbsp;&nbsp;${petition.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[청원기간]</b>&nbsp;&nbsp;<fmt:formatDate value="${petition.petitionSdate }" pattern="yyyy/MM/dd" />~
								<fmt:formatDate value="${petition.petitionEdate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<div class="field">
					<div class="box">
					<h4>제목:${petition.petitionTitle}</h4><br>
					${petition.petitionContent }
					</div>
				</div>
			</div>
			<form method="post" class="petitionDelete" name="deleteForm"
				action="<%=request.getContextPath()%>/admin/${petition.petitionNo }/delete">
			</form>
			<input type="button" class="button primary large" value="삭제(미승인)하기"
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