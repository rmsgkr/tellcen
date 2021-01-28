<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<!-- Main -->
<div id="main" class="alt">

	<!-- One -->
	<section id="one">
		<div class="inner">

			<header class="major">
				<h1>청원목록</h1>
			</header>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>지역</th>
							<th>분야</th>
							<th>제목</th>
							<th>작성일</th>
							<th>동의수</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${petition }" var="list">
						
						<tr>
							<td>${list.petitionNo }</td>
							<td>${list.petitionArea }</td>
							<td>${list.petitionField }</td>
							<td><a href="/tellcen/petition/${list.petitionNo}" >[ ${list.petitionTitle } ]</a></td>
							<td>${list.petitionDate }</td>
							<td>${list.petitionAgreement }</td>
						</tr>
						
					</c:forEach>
					</tbody>
					<!-- <tfoot>
						<tr>
							<td colspan="2"></td>
							<td>100.00</td>
						</tr>
					</tfoot> -->
				</table>
			</div>
			<!-- 페이징 -->
			<ul class="pagination" style="text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<li><a
			href="/tellcen/petition/petitionList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}" class="button small">Prev</a></li>
				</c:if>

				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<li><a
								href="#" class="page active">${p }</a></li>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<li><a
								href="/tellcen/petition/petitionList?nowPage=${p }&cntPerPage=${paging.cntPerPage}" class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/petition/petitionList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>

</div>
 <script>
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />