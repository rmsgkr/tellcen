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
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="searchPetition"
				class="searchForm">
				<div class="fields">
					<div class="field half">
						<select name="petitionArea" id="petitionArea">
							<option value="" disabled selected>지역</option>
							<option value="서울">서울</option>
							<option value="인천">인천</option>
							<option value="경기">경기</option>
							<option value="강원">강원</option>
							<option value="충남">충남</option>
							<option value="충북">충북</option>
							<option value="전남">전남</option>
							<option value="전북">전북</option>
							<option value="경남">경남</option>
							<option value="경북">경북</option>
							<option value="제주">제주</option>
						</select>
					</div>
					<div class="field half">
						<select name="petitionField" id="petitionField">
							<option value="" disabled selected>분야</option>
							<option value="가족ㆍ보건ㆍ복지">가족ㆍ보건ㆍ복지</option>
							<option value="문화ㆍ관광ㆍ체육">문화ㆍ관광ㆍ체육</option>
							<option value="교육ㆍ취업">교육ㆍ취업</option>
							<option value="교통ㆍ건설ㆍ환경">교통ㆍ건설ㆍ환경</option>
							<option value="농림ㆍ축산ㆍ해양">농림ㆍ축산ㆍ해양</option>
							<option value="도시ㆍ주택">도시ㆍ주택</option>
							<option value="산업ㆍ경제">산업ㆍ경제</option>
							<option value="소방ㆍ재난ㆍ안전">소방ㆍ재난ㆍ안전</option>
							<option value="조세ㆍ법무ㆍ행정">조세ㆍ법무ㆍ행정</option>
							<option value="기타">기타</option>
						</select>
					</div>
				</div>
				<div class="row gtr-200">
					<!-- Content -->
					<div class="col-9 col-12-medium">
						<input type="text" name="petitionTitle" id="petitionTitle"
							value="" placeholder="청원 제목을 검색하세요." autocomplete="off"/>
					</div>
					<div class="col-3 col-12-medium">
						<button type="button"
							class="button primary fit icon solid fa-search"
							onclick="searchButton();">검 색</button>
					</div>
				</div>
			</form>
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
						<c:if test="${petition.size() == 0}">
							<tr>
								<td colspan="6" align="center"><b>검색된 결과가 없습니다.</b></td>
							</tr>
						</c:if>
						<c:if test="${petition.size() != 0}">
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
								<td>${list.petitionNo }</td>
								<td>${list.petitionArea }</td>
								<td>${list.petitionField }</td>
								<td><a href="/tellcen/admin/petition/${list.petitionNo}">[${list.petitionTitle }
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

								<c:if test="${list.petitionStatus == 0 && EndDate-NowDate < 0 }">
									<td><button class="button"
											onclick="window.location.href='<%=request.getContextPath()%>/admin/petition/${list.petitionNo}/finish'">마감하기</button></td>
								</c:if>
								<c:if
									test="${list.petitionStatus == 1 && list.petitionAgreement >= 1}">
									<td><button class="button primary"
											onclick="window.location.href='<%=request.getContextPath()%>/admin/petition/${list.petitionNo}/answer'">답변하기</button></td>
								</c:if>
								<c:if
									test="${list.petitionStatus == 1 && list.petitionAgreement < 1}">
									<td><button
											onclick="window.location.href='<%=request.getContextPath()%>/admin/petition/${list.petitionNo}/delete'">삭제하기</button></td>
								</c:if>
								<c:if test="${list.petitionStatus == 2}">
									<td><button class="button disabled">답변완료</button></td>
								</c:if>
								<c:if test="${list.petitionStatus == 3}">
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
				<c:if test="${paging.start != 1 }">
					<li><a
						href="/tellcen/admin/petition?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"
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
								href="/tellcen/admin/petition?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/admin/petition?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>
</div>
<script>
function searchButton() {
	const searchForm = document.querySelector('.searchForm');
	searchForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />