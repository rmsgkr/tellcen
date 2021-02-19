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
				<h1>오류신고·이용문의</h1>
				<c:if test="${inquiry.inquiryStatus == 0}">
				<button class="button primary large" onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry/${inquiry.inquiryNo}/answer'">답변</button>
				<button class="button primary large" onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry/${inquiry.inquiryNo}/delete'">삭제</button>
				</c:if> 
			</header>
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;
				<c:if test="${inquiry.inquiryStatus == 0}">
				<b style="color: #6495ED">처리중</b>
				</c:if>
				<c:if test="${inquiry.inquiryStatus == 1}">
				<b style="color: #00CED1">답변 완료</b>
				</c:if>
			</h3>
			<br>
			<div class="box">
				<b>[제목]</b>&nbsp;&nbsp;${inquiry.inquiryTitle }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[아이디]</b>&nbsp;&nbsp;${inquiry.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[신청일]</b>&nbsp;&nbsp;<fmt:formatDate value="${inquiry.inquiryDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<div class="field">
					<h3>문의내용</h3>
					<div class="box">${inquiry.inquiryContent }</div>
				</div>
				<c:if test="${inquiry.inquiryStatus == 1}">
				<div class="field">
					<h2 style="color: #00CED1">답변내용</h2>
					<c:forEach items="${answerI }" var="answer">
					<h3>|&nbsp;&nbsp;답변일 :&nbsp;&nbsp;<fmt:formatDate value="${answer.answerIDate }" pattern="yyyy/MM/dd" /></h3>
					<blockquote>
					${answer.answerIContent }
					</blockquote>
					</c:forEach>
				</div>
				</c:if>
			</div></br></br> 
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />