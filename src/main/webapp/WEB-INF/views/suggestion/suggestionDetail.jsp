<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen"
		class="button large fit">말해주센<span class="icon solid alt fa-home"></span></a></li>
	<li></li>
	<li><a href="/tellcen/suggestion/suggestionInfo"
		class="button large fit">제안이란?</a></li>
	<li><a href="/tellcen/suggestion/suggestionWrite"
		class="button large fit">제안하기</a></li>
	<li><a href="/tellcen/suggestion/suggestionList"
		class="button large fit">제안목록</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>${suggestion.suggestionTitle }</h1>
			</header>
			<!-- 0.심사중  / 1.답변완료 -->
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;
				<c:if test="${suggestion.suggestionStatus == 0}">
				<b style="color: #6495ED">심사 중</b>
				</c:if>
				<c:if test="${suggestion.suggestionStatus == 1}">
				<b style="color: #00CED1">답변 완료</b>
				</c:if>
			</h3>
			<br>
			<div class="box">
				<b>제안인</b>&nbsp;&nbsp;${suggestion.id }&nbsp;&nbsp;|&nbsp;&nbsp;
				<b>신청일</b>&nbsp;&nbsp;<fmt:formatDate value="${suggestion.suggestionDate }" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;&nbsp;
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
			</div></br></br><hr> 
 			<h3>
				<b>댓글</b>
			</h3>
			
		<form id="formComment" method="post" action="${suggestion.suggestionNo }/comment" class="commentForm">
				<div class="row gtr-200">
				
					<div class="col-9 col-12-medium">
						<input type="text" name="commentSContent" id="commentSContent" placeholder="댓글을 입력해주세요." />
					</div>
					<div class="col-3 col-12-medium">
						<button type="button" class="button primary fit"
							onclick="button();">댓 글 등 록</button>
					</div>
					
				</div>
			</form>
			<hr />
			<c:forEach items="${commentS }" var="list">	
				<b>${list.id } > ${list.commentSContent } (${list.commentSDate })</b>
			<hr />
			</c:forEach>
		</div>
	</section>
</div>
<script>
function button() {
	const commentForm = document.querySelector('.commentForm');
	
	commentForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />