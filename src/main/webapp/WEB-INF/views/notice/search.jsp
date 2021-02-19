<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen"
		class="button large fit">말해주센<span class="icon solid alt fa-home"></span></a></li>
	<li></li>
	<li><a href="/tellcen/notice/noticeList" class="button large fit">공지사항</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>공지사항</h1>
			</header>
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="search" class="searchForm">
				<div class="row gtr-200">
					<div class="col-9 col-12-medium">
						<input type="text" name="noticeTitle" id="noticeTitle"
							value="" placeholder="공지 제목을 검색하세요." autocomplete="off" />
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
							<th>공지일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${notice.size() == 0}">
							<tr>
								<td colspan="6" align="center"><b>등록된 공지가 없습니다.</b></td>
							</tr>
						</c:if>
						<c:if test="${notice.size() != 0}">
						<c:forEach items="${notice }" var="list">
							<tr>
									<td>${list.noticeNo }</td>
									<td><a href="/tellcen/notice/${list.noticeNo}">[${list.noticeTitle }]</a></td>
									<td><fmt:formatDate value="${list.noticeDate }" pattern="yyyy/MM/dd" /></td>
									<td>${list.noticeCount }</td>
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
						href="/tellcen/notice/search?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&noticeTitle=${paging.noticeTitle}"
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
								href="/tellcen/notice/search?nowPage=${p }&cntPerPage=${paging.cntPerPage}&noticeTitle=${paging.noticeTitle}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/notice/search?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&noticeTitle=${paging.noticeTitle}"
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