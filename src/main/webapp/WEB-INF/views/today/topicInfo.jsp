<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value='${today}' pattern='yyyy년 MM월 dd일' var="nowDate" />
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major"> 
				<h1>오늘의 이슈 - ( ${nowDate } )</h1>
			</header>
			<hr>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th><h4>순위</h4></th>
							<th><h4>이슈명</h4></th>
							<th><h4>건수</h4></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${topicInfo }" var="list">
						<tr>
						<td><b>${list.rank }위</b></td>
						<td><b>${list.topic }</b></td>
						<td><b>${list.count }건</b></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />