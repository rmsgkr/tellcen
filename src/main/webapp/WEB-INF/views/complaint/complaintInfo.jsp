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
	<li><a href="/tellcen/complaint/complaintInfo" class="button large fit">민원이란?</a></li>
	<li><a href="/tellcen/complaint/complaintWrite" class="button large fit">민원신청</a></li>
	<li><a href="/tellcen/complaint/complaintList" class="button large fit">민원목록</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>민원이란?</h1>
			</header>
			<div class="box">
				<b style="color: skyblue">민원</b><b>은 국민이 행정기관에 대하여 처분 등 특정한 행위를
					요구하는 것을 의미합니다.<br> 즉 사법상의 계약 관계, 사법부의 판결 등을 제외하고 국민이 행정기관에 어떤
					행위나 답변을 요청하는 다양한 의사 표시를 통칭하는 개념으로, 행정의 민주화와 신뢰성을 향상시키고 <b
					style="color: skyblue">국민들이 가장 간편하게 이용할 수 있는 행정구제의 수단</b>으로 활용되고
					있습니다.
				</b><br /> <br />
				<br /> <b>특히 말해주센 민원은 처리기간이 평균 7일~14일이며, 인허가 서류 발급 신청 등 정형화된
					서식을 통한 민원사무가 아닌<br> <b style="color: skyblue">①</b> 법령·제도·절차 등
					행정업무에 관한 질의 또는 상담형식을 통한 설명이나 해석의 요구,<br> <b
					style="color: skyblue">②</b> 정부시책이나 행정제도 및 운영의 개선에 관한 건의,<br>
					<b style="color: skyblue">③</b> 행정기관의 위법·부당 하거나 소극적인 처분 및 불합리한
					행정제도로 국민의 권리를 침해하거나 국민에게 불편 또는 부담을 주는 사항의 해결요구인 고충민원을 주로 처리하고 있습니다.<br>
				</b>
			</div>
			<div class="box">
				<div class="row">
					<div class="col-6 col-12-small">
						<h3>신청방법</h3>
						<ul class="alt">
							<li><b style="color: #6495ED">①</b> <b>로그인</b></li>
							<li><b style="color: #6495ED">②</b> <b>민원신청</b></li>
							<li><b se="color: #6495ED">③</b> <b>신청하기버튼</b></li>
						</ul>
					</div>
					<div class="col-6 cotyll-12-small">
						<h3>처리절차</h3>
						<ul class="alt">
							<li><b style="color: #6495ED">①</b> <b>민원신청</b></li>
							<li><b style="color: #6495ED">②</b> <b>민원심사</b></li>
							<li><b style="color: #6495ED">④</b> <b>민원답변</b></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="box">
				<h3>민원 제외사항</h3>
				<b style="color: skyblue"> 다른 법률에 특별한 규정이 있는 경우를 제외하고는, 민원 처리에
					관한 법률(민원처리법)에 따릅니다.(아래 제외대상 예시)</b>
				<ul>
					<li><b>특허법</b> : 특허심판에 관한 사항</li>
					<li><b>행정심판법</b> : 행정심판에 관한 사항</li>
					<li><b>국세심판법</b> : 국세심판에 관한 사항</li>
					<li><b>감사원법</b> : 감사원의 심사청구나 재심의 청구</li>
					<li><b>환경분쟁조정법</b> : 환경 분쟁의 알선·조정 등에 관한 사항</li>
					<li><b>노동위원회법</b> : 노동관계에 있어서 판정 및 조정업무에 관한 사항</li>
					<li><b>국가인권위원회법</b> : 국가인권위원회의 인권 침해나 차별 등에 대한 진정에 관한 사항</li>
					<li><b>부패방지 및 국민권익위원회의 설치와 운영에 관한 법률</b> : 국민권익위원회의 타기관 민원처리에
						관한 조사·심의 등</li>
				</ul>
				<b style="color: #F08080">위 민원 제외사항에 해당할 경우와 그 밖에 운영 취지에 맞지 아니하는
					민원은 게시물 관리자에 의해 숨김처리 또는 삭제될 수 있습니다.</b>
			</div>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />