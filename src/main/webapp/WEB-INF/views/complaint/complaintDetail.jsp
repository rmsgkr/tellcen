<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen/complaint/complaintInfo" class="button large fit">민원이란?</a></li>
	<li></li>
	<li><a href="/tellcen/complaint/complaintWrite" class="button large fit">민원신청</a></li>
	<li><a href="/tellcen/complaint/complaintList" class="button large fit">민원목록</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>${complaint.complaintTitle }</h1>
			</header>
			<!-- 0.진행  / 1.종료 / 2.답변완료 -->
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;
				<c:if test="${complaint.complaintStatus == 0}">
				<b style="color: #6495ED">민원 심사 중</b>
				</c:if>
				<c:if test="${complaint.complaintStatus == 1}">
				<b style="color: #00CED1">민원 답변 완료</b>
				</c:if>
			</h3>
			<br>
			<div class="box">
				<b>[기관분류]</b>&nbsp;&nbsp;${complaint.complaintOrganization }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[상세기관]</b>&nbsp;&nbsp;${complaint.complaintOrganizationDetail }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[민원인]</b>&nbsp;&nbsp;${complaint.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[등록일]</b>&nbsp;&nbsp;<fmt:formatDate value="${complaint.complaintDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<c:if test="${complaint.complaintStatus == 1}">
				<div class="field">
					<h3 style="color: #00CED1">답변내용</h3>
					<div class="box"><c:forEach items="${answerC }" var="answer">
					${answer.answerCContent }
					</c:forEach></div>
				</div>
				</c:if>
				<div class="field">
					<h3>민원내용</h3>
					<div class="box">${complaint.complaintContent }</div>
				</div>
			</div></br></br> 
 
			
		</div>
	</section>
</div>
<script>
function button() {
	const agreeForm = document.querySelector('.agreeForm');
	
	agreeForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />