<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen"
		class="button large fit">말해주센<span class="icon solid alt fa-home"></span></a></li>
	<li></li>	
	<li><a href="/tellcen/petition/petitionInfo"
		class="button large fit">청원이란?</a></li>
	<li><a href="/tellcen/petition/petitionWrite"
		class="button large fit">청원하기</a></li>
	<li><a href="/tellcen/petition/petitionList"
		class="button large fit">청원목록</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>청원이란?</h1>
			</header>
			<div class="box">
				<b style="color: skyblue">청원</b><b>은 말해주센의 직접소통이며</b> <b
					style="color: skyblue">'국민이 물으면 정부가 답한다'</b><b>는 철학을 지향합니다.</b> <br />
				<br /> <br /> <b>국정 현안 관련, 국민들 다수의 목소리가 모여 <b
					style="color: skyblue">30일 동안 1명 이상 동의 청원</b>에 대해서는 <b
					style="color: skyblue">말해주센</b>에서 정책반영 등을 적극 검토하고 책임 있는 답변을 드리겠습니다.
				</b>
			</div>
			<div class="box">
				<div class="row">
					<div class="col-6 col-12-small">
						<h3>신청방법</h3>
						<ul class="alt">
							<li><b style="color: #6495ED">①</b> <b>로그인</b></li>
							<li><b style="color: #6495ED">②</b> <b>청원하기</b></li>
							<li><b style="color: #6495ED">③</b> <b>신청하기버튼</b></li>
						</ul>
					</div>
					<div class="col-6 col-12-small">
						<h3>처리절차</h3>
						<ul class="alt">
							<li><b style="color: #6495ED">①</b> <b>청원신청</b></li>
							<li><b style="color: #6495ED">②</b> <b>청원진행</b></li>
							<li><b style="color: #6495ED">③</b> <b>청원종료</b></li>
							<li><b style="color: #6495ED">④</b> <b>청원답변</b></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="box">
				<h3>청원 제외사항</h3>
				<ul>
					<li>국가기관이나 지방자치단체 등 특정 기관·단체를 근거없이 비난하거나 모독하는 사항</li>
					<li>감사·수사·재판·행정심판·조정·중재 등 다른 법령에 의한 조사· 불복 또는 구제절차가 진행중인 사항</li>
					<li>욕설, 비속어 등 폭력적이고 선정적인 내용</li>
					<li>허위사실이나 타인의 명예를 훼손하는 내용</li>
					<li>정치적 목적이 있거나 영리목적의 상업적인 내용</li>
					<li>사인간의 권리관계 또는 개인의 사생활에 관한 사항</li>
					<li>동일 이용자가 동일한 내용의 청원서를 2회 이상 제출한 경우 나중에 제출된 것</li>
					<li>그밖에 공익을 저해하거나 법령에 위배되는 등 게시판 운영 취지에 맞지 아니하는 게시물 등</li>
				</ul>
				<b style="color: #F08080">위 청원 제외사항에 해당할 경우 관리자에 의해 숨김처리 또는 삭제될
					수 있습니다.</b>
			</div>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />