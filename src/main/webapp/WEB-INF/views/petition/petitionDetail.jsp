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
				<h1>${petition.petitionTitle }</h1>
			</header>
			<!-- 진행 상태와 프로그래스 조건별 추가하기 -->
			<h3>
				진행상태&nbsp;&nbsp;-&nbsp;&nbsp;<b>${petition.petitionStatus }</b>&nbsp;&nbsp;[참여인원:<b
					style="color: skyblue">${petition.petitionAgreement }</b>명]
			</h3>
			<!-- <div class="w3-light-grey w3-round-large">
				<div class="w3-container w3-blue w3-round-large" style="width: 25%">&nbsp;</div>
			</div> -->
			<br>
			<div class="box">
				<b>[지역]</b>&nbsp;&nbsp;${petition.petitionArea }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[분야]</b>&nbsp;&nbsp;${petition.petitionField }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[청원인]</b>&nbsp;&nbsp;${petition.id }&nbsp;&nbsp;&nbsp;&nbsp;
				<b>[청원등록일]</b>&nbsp;&nbsp;${petition.petitionDate }&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<div class="fields">
				<div class="field">
					<h3>청원내용</h3>
					<div class="box">${petition.petitionContent }</div>
				</div>
			</div></br></br> 
 			<h3>
				<b>청원동의</b> <b style="color: skyblue">${petition.petitionAgreement }</b><b>명</b>
			</h3>
			<form id="formAgreement" method="post" action="${petition.petitionNo }/agree" class="agreeForm">
				<div class="row gtr-200">
					<c:if test="${petition.agreeCheck == 0 }">
					<!-- Content -->
					<div class="col-9 col-12-medium">
						<input type="text" name="commentPContent" id="commentPContent" value="동의합니다." placeholder="동의합니다." />
					</div>
					<div class="col-3 col-12-medium">
						<button type="button" class="button primary fit"
							onclick="button();">동 의</button>
					</div>
					</c:if>
					
					<c:if test="${petition.agreeCheck == 1 }">
					<!-- Content -->
					<div class="col-12-medium">
						<button type="button" class="button primary fit disabled"
							onclick="button();">이미 동의하신 청원입니다.</button>
					</div>
					</c:if>
				</div>
			</form>
			<hr />
			<c:forEach items="${commentP }" var="list">	
				<b>${list.id } > ${list.commentPContent } (${list.commentPDate })</b>
			<hr />
			</c:forEach>
		</div>
	</section>
</div>
<script>
function button() {
	const agreeForm = document.querySelector('.agreeForm');
	
	agreeForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />