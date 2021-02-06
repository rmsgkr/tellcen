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
				<h1>회원관리</h1>
			</header>
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="searchMember" class="searchForm">
			<div class="fields">  
			</div> 
				<div class="row gtr-200">
					<!-- Content -->
					<div class="col-9 col-12-medium">
						<input type="text" name="id" id="id"
							value="" placeholder="아이디를 검색하세요." />
					</div>
					<div class="col-3 col-12-medium">
						<button type="button" class="button primary fit icon solid fa-search"
							onclick="button();">검 색</button>
					</div>
				</div>
			</form>
			<hr>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>전화번호</th>
							<th>생년월일</th>
							<th>가입일</th>
							<th>탈퇴일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberInfo }" var="list">
							<tr>
							
								<td>${list.id}</td>
								<td>${list.name}</td>
								<td>${list.email}</td>
								<td>${list.tel}</td>
								<td><fmt:formatDate value="${list.birthday}" pattern="yyyy/MM/dd" /></td>
								<td><fmt:formatDate value="${list.regDate}" pattern="yyyy/MM/dd" /></td>
								
								<c:if test="${list.wdrDate != null}">
								<td><fmt:formatDate value="${list.wdrDate}" pattern="yyyy/MM/dd" /></td>
								</c:if>
								<c:if test="${list.wdrDate == null}">
								<td> - </td>
								</c:if>
								
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 페이징 -->
			<ul class="pagination" style="text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<li><a
						href="/tellcen/admin/searchMember?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&id=${paging.id}"
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
								href="/tellcen/admin/searchMember?nowPage=${p }&cntPerPage=${paging.cntPerPage}&id=${paging.id}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/admin/searchMember?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&id=${paging.id}"
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