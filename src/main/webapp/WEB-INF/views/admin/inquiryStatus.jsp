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
				<h1>오류신고·이용문의</h1>
			</header>
			<!-- 상태별 보기 기능 -->
			<div class="box">

				<div class="row">
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry'">전체
							문의보기</button>
					</div>
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiryStatus/0'">진행중인
							문의보기</button>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiryStatus/1'">답변완료
							문의보기</button>
					</div>
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiryStatus/2'">삭제
							문의보기</button>
					</div>
				</div>
			</div>
			<hr>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>제목</th>
							<th>신청일</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${inquiry.size() == 0}">
							<tr>
								<td colspan="6" align="center"><b>신청된 문의가 없습니다.</b></td>
							</tr>
						</c:if>
						<c:if test="${inquiry.size() != 0}">
						<c:forEach items="${inquiry }" var="list">
							<tr>
									<td>${list.inquiryNo }</td>
									<td>${list.id }</td>
									<td><a href="/tellcen/admin/inquiry/${list.inquiryNo}">[${list.inquiryTitle }]</a></td>
									<td><fmt:formatDate value="${list.inquiryDate }" pattern="yyyy/MM/dd" /></td>
									
									<c:if test="${list.inquiryStatus == 0}">
									<td><button class="button " onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry/${list.inquiryNo}/answer'">답변</button>
									<button class="button " onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry/${list.inquiryNo}/delete'">삭제</button></td>
									</c:if>
									
									<c:if test="${list.inquiryStatus == 1}">
									<td><button class="button disabled">답변완료</button></td>
									</c:if>
									<c:if test="${list.inquiryStatus == 2}">
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
						href="/tellcen/admin/inquiryStatus/${paging.inquiryStatus}?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&inquiryStatus=${paging.inquiryStatus}"
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
								href="/tellcen/admin/inquiryStatus/${paging.inquiryStatus}?nowPage=${p }&cntPerPage=${paging.cntPerPage}&inquiryStatus=${paging.inquiryStatus}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/admin/inquiryStatus/${paging.inquiryStatus}?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&inquiryStatus=${paging.inquiryStatus}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />