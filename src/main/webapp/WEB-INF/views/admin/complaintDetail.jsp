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
				<h1>${complaint.complaintTitle }</h1>
				<c:if test="${complaint.complaintStatus == 0}">
				<button class="button primary large" onclick="window.location.href='<%=request.getContextPath()%>/admin/complaint/${complaint.complaintNo}/answer'">답변하기</button>
				<button class="button primary large" onclick="window.location.href='<%=request.getContextPath()%>/admin/complaint/${complaint.complaintNo}/delete'">삭제하기</button>
				</c:if>	
			</header>
			<!-- 0.진행  / 1.답변완료 / 2.삭제완료 -->
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;
				<c:if test="${complaint.complaintStatus == 0}">
				<b style="color: #6495ED">민원 심사 중</b>
				</c:if>
				<c:if test="${complaint.complaintStatus == 1}">
				<b style="color: #00CED1">민원 답변 완료</b>
				</c:if>
				<c:if test="${complaint.complaintStatus == 2}">
				<b style="color: #CD853F">민원 삭제 완료</b>
				</c:if>
			</h3>
			<br>
			<div class="box">
				<b>기관분류</b>&nbsp;&nbsp;${complaint.complaintOrganization }&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>상세기관</b>&nbsp;&nbsp;${complaint.complaintOrganizationDetail }&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>민원인</b>&nbsp;&nbsp;${complaint.id }&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>등록일</b>&nbsp;&nbsp;<fmt:formatDate value="${complaint.complaintDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<blockquote>${complaint.complaintContent }</blockquote></br></br>
			<div class="fields">
				<c:if test="${complaint.complaintStatus == 1}">
				<div class="field">
					<h2 style="color: #00CED1">답변내용</h2>
					<c:forEach items="${answerC }" var="answer">
					<h3>|&nbsp;&nbsp;답변일 :&nbsp;&nbsp;<fmt:formatDate value="${answer.answerCDate }" pattern="yyyy/MM/dd" /></h3>
					<blockquote>
					${answer.answerCContent }
					</blockquote>
					</c:forEach>
				</div>
				</c:if>
			</div></br></br> 
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />