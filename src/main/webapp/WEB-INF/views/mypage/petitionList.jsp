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
				<h1>나의 청원</h1>
			</header>
			<hr>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>지역</th>
							<th>분야</th>
							<th>제목</th>
							<th>청원기간</th>
							<th>동의수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${petition.size() == 0}">
							<tr>
								<td colspan="6" align="center"><b>검색된 결과가 없습니다.</b></td>
							</tr>
						</c:if>
						<c:if test="${complaint.size() != 0}">
						<c:forEach items="${petition }" var="list">
							<jsp:useBean id="today" class="java.util.Date" />
							<fmt:formatDate value='${today}' pattern='yyyy/MM/dd'
								var="nowDate" />
							<fmt:parseNumber value="${today.time / (1000*60*60*24)}"
								integerOnly="true" var="NowDate"></fmt:parseNumber>

							<fmt:formatDate value="${list.petitionEdate }"
								pattern="yyyy/MM/dd" var="endDate" />
							<fmt:parseNumber
								value="${list.petitionEdate.time / (1000*60*60*24)}"
								integerOnly="true" var="EndDate"></fmt:parseNumber>
							<tr>
								<c:if test="${list.petitionStatus != 3}">
									<td>${list.petitionNo }</td>
									<td>${list.petitionArea }</td>
									<td>${list.petitionField }</td>
									<td><a href="/tellcen/mypage/petition/${list.petitionNo}">[${list.petitionTitle }
											]</a></td>
									<td><fmt:formatDate value="${list.petitionSdate }"
											pattern="yyyy/MM/dd" />~ <fmt:formatDate
											value="${list.petitionEdate }" pattern="yyyy/MM/dd" /></td>
									<c:if test="${list.petitionAgreement < 1}">
										<td><b>${list.petitionAgreement }</b></td>
									</c:if>
									<c:if test="${list.petitionAgreement >= 1}">
										<td><b style="color: #6495ED">${list.petitionAgreement }</b></td>
									</c:if>

									<c:if test="${EndDate-NowDate >= 0 }">
										<td><b style="color: #6495ED">진행중</b></td>
									</c:if>
									<c:if
										test="${EndDate-NowDate < 0  && list.petitionStatus == 0}">
										<td><b style="color: #B0C4DE">종료</b></td>
									</c:if>
									<c:if
										test="${EndDate-NowDate < 0  && list.petitionStatus == 1}">
										<td><b style="color: #B0C4DE">종료</b></td>
									</c:if>
									<c:if
										test="${EndDate-NowDate < 0  && list.petitionStatus == 2}">
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
						href="/tellcen/mypage/petitionList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"
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
								href="/tellcen/mypage/petitionList?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/mypage/petitionList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>

</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />