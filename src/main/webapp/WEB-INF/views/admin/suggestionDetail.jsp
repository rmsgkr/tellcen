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
				<h1>${suggestion.suggestionTitle }</h1>
				<c:if test="${suggestion.suggestionStatus == 0}">
				<button class="button primary large" onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestion/${suggestion.suggestionNo}/answer'">답변하기</button>
				<button class="button primary large" onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestion/${suggestion.suggestionNo}/delete'">삭제하기</button>
				</c:if>
			</header>
			<!-- 0.심사중  / 1.답변완료 / 2.삭제완료-->
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;
				<c:if test="${suggestion.suggestionStatus == 0}">
				<b style="color: #6495ED">제안 심사 중</b>
				</c:if>
				<c:if test="${suggestion.suggestionStatus == 1}">
				<b style="color: #00CED1">제안 답변 완료</b>
				</c:if>
				<c:if test="${suggestion.suggestionStatus == 2}">
				<b style="color: #CD853F">제안 삭제 완료</b>
				</c:if>
			</h3>
			<br>
			<div class="box">
				<b>제안인</b>&nbsp;&nbsp;${suggestion.id }&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>제안일</b>&nbsp;&nbsp;<fmt:formatDate value="${suggestion.suggestionDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<div class="field">
					<h3>제안내용</h3>
					<blockquote>
					<h4><b>●  현황 및 문제점</b></h4><br>
					${suggestion.suggestionProblem }
					<br><br><br><br>
					<h4><b>●  개선방안</b></h4><br>
					${suggestion.suggestionPlan }
					<br><br><br><br>
					<h4><b>●  기대효과</b></h4><br>
					${suggestion.suggestionEffect }
					<br><br>
					</blockquote>
				</div>
				<c:if test="${suggestion.suggestionStatus == 1}">
				<div class="field">
					<h2 style="color: #00CED1">답변내용</h2>
					<c:forEach items="${answerS }" var="answer">
					<h3>|&nbsp;&nbsp;답변일 :&nbsp;&nbsp;<fmt:formatDate value="${answer.answerSDate }" pattern="yyyy/MM/dd" /></h3>
					<blockquote>
					${answer.answerSContent }
					</blockquote>
					</c:forEach>
				</div>
				</c:if>
			</div></br></br> 
			
			<hr>
 			<h3>
				<b>댓글</b>
			</h3>
			<c:forEach items="${commentS }" var="list">	
				<b>${list.id } > ${list.commentSContent } (${list.commentSDate })</b>
			<hr />
			</c:forEach>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />