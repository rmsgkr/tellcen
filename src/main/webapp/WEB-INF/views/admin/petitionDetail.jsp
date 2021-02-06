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
				<h1>${petition.petitionTitle }</h1>
			</header>
			<!-- 0.진행  / 1.종료 / 2.답변완료 -->
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;
				<c:if test="${petition.petitionStatus == 0}">
				<b style="color: #6495ED">청원 진행 중</b>
				</c:if>
				<c:if test="${petition.petitionStatus == 1}">
				<b style="color: #B0C4DE">청원 종료(답변 대기 중)</b>
				</c:if>
				<c:if test="${petition.petitionStatus == 2}">
				<b style="color: #00CED1">청원 답변 완료</b>
				</c:if>
				&nbsp;&nbsp;[참여인원:<b style="color: skyblue">${petition.petitionAgreement }</b>명]
			<jsp:useBean id="today" class="java.util.Date" />
			<fmt:formatDate value='${today}' pattern='yyyy/MM/dd' var="nowDate"/>
			<fmt:parseNumber value="${today.time / (1000*60*60*24)}" integerOnly="true" var="NowDate"></fmt:parseNumber>
			
			<fmt:formatDate value="${petition.petitionEdate }" pattern="yyyy/MM/dd" var="endDate"/>
			<fmt:parseNumber value="${petition.petitionEdate.time / (1000*60*60*24)}" integerOnly="true" var="EndDate"></fmt:parseNumber>
				
			<c:if test="${list.petitionStatus == 0 && EndDate-NowDate < 0 }">
			<button class="button" onclick="window.location.href='<%=request.getContextPath()%>/admin/${list.petitionNo}/answer'">마감하기</button>
			</c:if>	
			<c:if test="${petition.petitionStatus == 1 && petition.petitionAgreement >= 1}">&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="button primary" onclick="window.location.href='<%=request.getContextPath()%>/admin/${petition.petitionNo}/answer'">답변하기</button>
			</c:if>
			<c:if test="${petition.petitionStatus == 1 && petition.petitionAgreement < 1}">&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="window.location.href='<%=request.getContextPath()%>/admin/${petition.petitionNo}/answer'">삭제하기</button>
			</c:if> 
			</h3>
			
			<br>
			<div class="box">
				<b>[지역]</b>&nbsp;&nbsp;${petition.petitionArea }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[분야]</b>&nbsp;&nbsp;${petition.petitionField }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[청원인]</b>&nbsp;&nbsp;${petition.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[청원기간]</b>&nbsp;&nbsp;<fmt:formatDate value="${petition.petitionSdate }" pattern="yyyy/MM/dd" />~
								<fmt:formatDate value="${petition.petitionEdate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<c:if test="${petition.petitionStatus == 2}">
				<div class="field">
					<h3 style="color: #00CED1">답변내용</h3>
					<div class="box"><c:forEach items="${answerP }" var="answer">
					${answer.answerPContent }
					</c:forEach></div>
				</div>
				</c:if>
				<div class="field">
					<h3>청원내용</h3>
					<div class="box">${petition.petitionContent }</div>
				</div>
			</div></br></br> 
			
			
 			<h3>
				<b>청원동의</b> <b style="color: skyblue">${petition.petitionAgreement }</b><b>명</b>
			</h3>
			<hr />
			<c:forEach items="${commentP }" var="list">	
				<b>${list.id } > ${list.commentPContent } (${list.commentPDate })</b>
			<hr />
			</c:forEach>
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