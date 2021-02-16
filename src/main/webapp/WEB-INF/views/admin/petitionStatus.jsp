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
				<h1>청원관리</h1>
			</header>
			<!-- 상태별 보기 기능 -->
			<div class="box">

				<div class="row">
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/petitionStatus/0'">진행중인
							청원보기</button>
					</div>
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/petitionStatus/1'">마감
							청원보기</button>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/petitionStatus/2'">답변완료
							청원보기</button>
					</div>
					<div class="col-6 col-12-small">
						<button type="button" class="button fit"
							onclick="window.location.href='<%=request.getContextPath()%>/admin/petitionStatus/3'">미승인(삭제)
							청원보기</button>
					</div>
				</div>
			</div>
			<hr>
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
							<jsp:useBean id="today" class="java.util.Date" />
							<fmt:formatDate value='${today}' pattern='yyyy/MM/dd' var="nowDate"/>
							<fmt:parseNumber value="${today.time / (1000*60*60*24)}" integerOnly="true" var="NowDate"></fmt:parseNumber>
							
							<fmt:formatDate value="${list.petitionEdate }" pattern="yyyy/MM/dd" var="endDate"/>
							<fmt:parseNumber value="${list.petitionEdate.time / (1000*60*60*24)}" integerOnly="true" var="EndDate"></fmt:parseNumber>
							<tr>
								<td>${list.petitionNo }</td>
								<td>${list.petitionArea }</td>
								<td>${list.petitionField }</td>
								<td><a href="/tellcen/admin/petition/${list.petitionNo}">[${list.petitionTitle } ]</a></td>
								<td><fmt:formatDate value="${list.petitionSdate }" pattern="yyyy/MM/dd" />~
								<fmt:formatDate value="${list.petitionEdate }" pattern="yyyy/MM/dd" /></td>
								<c:if test="${list.petitionAgreement < 1}">
								<td><b>${list.petitionAgreement }</b></td>
								</c:if>
								<c:if test="${list.petitionAgreement >= 1}">
								<td><b style="color: #6495ED">${list.petitionAgreement }</b></td>
								</c:if>
								
								<c:if test="${list.petitionStatus == 0 && EndDate-NowDate < 0 }">
								<td><button class="button" onclick="window.location.href='<%=request.getContextPath()%>/admin/petition/${list.petitionNo}/finish'">마감하기</button></td>
								</c:if>
								<c:if test="${list.petitionStatus == 1 && list.petitionAgreement >= 1}">
								<td><button class="button primary" onclick="window.location.href='<%=request.getContextPath()%>/admin/petition/${list.petitionNo}/answer'">답변하기</button></td>
								</c:if>
								<c:if test="${list.petitionStatus == 1 && list.petitionAgreement < 1}">
								<td><button onclick="window.location.href='<%=request.getContextPath()%>/admin/petition/${list.petitionNo}/delete'">삭제하기</button></td>
								</c:if>
								<c:if test="${list.petitionStatus == 2}">
								<td><button class="button disabled">답변완료</button></td>
								</c:if>
								<c:if test="${list.petitionStatus == 3}">
								<td><button class="button disabled">삭제완료</button></td>
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
						href="/tellcen/admin/petitionStatus/${paging.petitionStatus}?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&petitionStatus=${paging.petitionStatus}"
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
								href="/tellcen/admin/petitionStatus/${paging.petitionStatus}?nowPage=${p }&cntPerPage=${paging.cntPerPage}&petitionStatus=${paging.petitionStatus}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/admin/petitionStatus/${paging.petitionStatus}?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&petitionStatus=${paging.petitionStatus}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />