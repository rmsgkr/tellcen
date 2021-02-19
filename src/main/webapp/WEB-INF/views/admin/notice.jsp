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
				<h1>공지사항</h1>
			</header>
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="searchNotice" class="searchForm">
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
									<td><a href="/tellcen/admin/notice/${list.noticeNo}">[${list.noticeTitle }]</a></td>
									<td><fmt:formatDate value="${list.noticeDate }" pattern="yyyy/MM/dd" /></td>
									<td>${list.noticeCount }</td>
									<td><button class="button " onclick="window.location.href='<%=request.getContextPath()%>/admin/notice/${list.noticeNo}/modify'">수정</button>
									<button class="button " onclick="window.location.href='<%=request.getContextPath()%>/admin/notice/${list.noticeNo}/delete'">삭제</button></td> 
							</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<button class="button primary large" style="float:right" onclick="window.location.href='<%=request.getContextPath()%>/admin/notice/write'">공지등록하기</button>
			<!-- 페이징 -->
			<ul class="pagination" style="text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<li><a
						href="/tellcen/admin/notice?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"
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
								href="/tellcen/admin/notice?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/admin/notice?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"
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