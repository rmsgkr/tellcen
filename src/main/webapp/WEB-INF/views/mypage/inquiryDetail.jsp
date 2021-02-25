<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<ul class="links" id="adminSidebar">
			<li><a href="/tellcen"
				class="button large fit">말해주센<span class="icon solid alt fa-home"></span></a></li>
			<li></li>
			<li><a href="/tellcen/mypage/petitionList" class="button large fit">내청원보기
					</a></li>
			<li><a href="/tellcen/mypage/complaintList" class="button large fit">내민원보기
					</a></li>
			<li><a href="/tellcen/mypage/suggestionList" class="button large fit">내제안보기
					</a></li>
			<li><a href="/tellcen/mypage/inquiryList" class="button large fit">내문의보기
					</a></li>
			<li><a href="/tellcen/mypage/modifyMember" class="button large fit">회원정보수정
					</a></li>
			<li><a href="/tellcen/mypage/deleteMember" class="button large fit">회원탈퇴
					</a></li>		
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>오류신고·이용문의</h1>
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
			<h2>${inquiry.inquiryTitle }</h2> 
			<h3>|&nbsp;&nbsp;신청일 :&nbsp;&nbsp;<fmt:formatDate value="${inquiry.inquiryDate }" pattern="yyyy/MM/dd" /></h3>
			<blockquote>${inquiry.inquiryContent }</blockquote><br><br>
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

		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />