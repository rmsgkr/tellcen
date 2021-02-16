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
				<h1>민원 삭제(미승인)하기</h1>
			</header>
			<h3>해당 민원</h3>
			<div class="box">
				<b>[기관분류]</b>&nbsp;&nbsp;${complaint.complaintOrganization}&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[상세기관]</b>&nbsp;&nbsp;${complaint.complaintOrganizationDetail }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[민원인]</b>&nbsp;&nbsp;${complaint.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[등록일]</b>&nbsp;&nbsp;<fmt:formatDate value="${complaint.complaintDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<div class="field">
					<div class="box">
					<h4>제목:${complaint.complaintTitle}</h4><br>
					${complaint.complaintContent }
					</div>
				</div>
			</div>
			<form method="post" class="complaintDelete" name="deleteForm"
				action="<%=request.getContextPath()%>/admin/complaint/${complaint.complaintNo }/delete">
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