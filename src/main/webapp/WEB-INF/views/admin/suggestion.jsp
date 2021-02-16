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
				<h1>제안목록</h1>
			</header>
			<!-- 상태별 보기 기능 -->
			<div class="box">

				<div class="row">
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestion'">전체
							제안보기</button>
					</div>
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestionStatus/0'">진행중인
							제안보기</button>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestionStatus/1'">답변완료
							제안보기</button>
					</div>
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestionStatus/2'">미승인(삭제)
							제안보기</button>
					</div>
				</div>
			</div>
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="searchSuggestion" class="searchForm">
				<div class="box">
					<div class="row">
						<div class="col-6 col-12-small">
							<b> 시작일</b> <input type="text" id="suggestionSdate" name="suggestionSdate"
								placeholder="시작일을 입력하세요"  autocomplete="off" >
						</div>
						<div class="col-6 col-12-small">
							<b>종료일</b> <input type="text" id="suggestionEdate" name="suggestionEdate"
								placeholder="종료일을 입력하세요"  autocomplete="off" >
						</div>
					</div>
				</div>
				<div class="row gtr-200">
					<!-- Content -->
					<div class="col-9 col-12-medium">
						<input type="text" name="suggestionTitle" id="suggestionTitle"
							value="" placeholder="제안 제목을 검색하세요." autocomplete="off"/>
					</div>
					<div class="col-3 col-12-medium">
						<button type="button"
							class="button primary fit icon solid fa-search"
							onclick="button();">검 색</button>
					</div>
				</div>
			</form>
			<hr>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>제안인</th>
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
									<td>${list.suggestionNo }</td>
									<td><a href="/tellcen/admin/suggestion/${list.suggestionNo}">[${list.suggestionTitle }]</a></td>
									<td>${list.id }</td>
									<td><fmt:formatDate value="${list.suggestionDate }" pattern="yyyy/MM/dd" /></td>
									<td>${list.suggestionCount }</td>
									
								<c:if test="${list.suggestionStatus == 0}">
								<td><button class="button " onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestion/${list.suggestionNo}/answer'">답변</button>
								<button class="button " onclick="window.location.href='<%=request.getContextPath()%>/admin/suggestion/${list.suggestionNo}/delete'">삭제</button></td>
								</c:if>
								
								<c:if test="${list.suggestionStatus == 1}">
								<td><button class="button disabled">답변완료</button></td>
								</c:if>
								<c:if test="${list.suggestionStatus == 2}">
								<td><button class="button disabled">삭제완료</button></td>
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
						href="/tellcen/admin/suggestion?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"
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
								href="/tellcen/admin/suggestion?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/admin/suggestion?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"
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