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
			<li><a href="/tellcen/mypage/memberModify" class="button large fit">회원정보수정
					</a></li>
			<li><a href="/tellcen/mypage/memberDelete" class="button large fit">회원탈퇴
					</a></li>		
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>나의 제안</h1>
			</header>
			<hr>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>제안일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${suggestion.size() == 0}">
							<tr>
								<td colspan="6" align="center"><b>검색된 결과가 없습니다.</b></td>
							</tr>
						</c:if>
						<c:if test="${suggestion.size() != 0}">
						<c:forEach items="${suggestion }" var="list">
		
							<tr>
								<c:if test="${list.suggestionStatus != 2}">
									<td>${list.suggestionNo }</td>
									<td><a href="/tellcen/mypage/suggestion/${list.suggestionNo}">[${list.suggestionTitle }]</a></td>
									<td><fmt:formatDate value="${list.suggestionDate }" pattern="yyyy/MM/dd" /></td>
									<td>${list.suggestionCount }</td>
									<c:if
										test="${list.suggestionStatus == 0}">
										<td><b style="color: #6495ED">심사중</b></td>
									</c:if>
									<c:if
										test="${list.suggestionStatus == 1}">
										<td><b style="color: #00CED1">답변완료</b></td>
									</c:if>
								</c:if>
							</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<!-- 페이징 -->
			<ul class="pagination" style="text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<li><a
						href="/tellcen/mypage/suggestionList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"
						class="button small">Prev</a></li>
				</c:if>

				<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
					var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<li><a href="#" class="page active">${p }</a></li>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<li><a
								href="/tellcen/mypage/suggestionList?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/mypage/suggestionList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>

</div>
<script>
function button() {
	const searchForm = document.querySelector('.searchForm');
	searchForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />