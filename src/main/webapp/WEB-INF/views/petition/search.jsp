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
			
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="search" class="searchForm">
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
							value="" placeholder="청원 제목을 검색하세요." />
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
								<td><a href="/tellcen/petition/${list.petitionNo}">[${list.petitionTitle } ]</a></td>
								<td>${list.petitionDate }</td>
								<td><b>${list.petitionAgreement }</b></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 페이징 -->
			<ul class="pagination" style="text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<li><a
						href="/tellcen/petition/petitionList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"
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
								href="/tellcen/petition/petitionList?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
								class="page">${p }</a></li>
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
function button() {
	const searchForm = document.querySelector('.searchForm');
	searchForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />