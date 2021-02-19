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
	<li><a href="/tellcen/suggestion/suggestionInfo"
		class="button large fit">제안이란?</a></li>
	<li><a href="/tellcen/suggestion/suggestionWrite"
		class="button large fit">제안하기</a></li>
	<li><a href="/tellcen/suggestion/suggestionList"
		class="button large fit">제안목록</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>제안이란?</h1>
			</header>
			
			<div class="box"><b style="color: skyblue">제안</b><b>은 원래 민간에서 소속 직원으로부터 생산방법, 업무 효율성에 관한 개선방안을
				받아 조직·경영 혁신의 수단으로 활용하던 것에서부터 비롯되었습니다. </b><br><br>
				<b>반면 </b><b style="color: skyblue">국민제안</b><b>은 내부직원이 아닌 일반국민이 제출 주체가
				된다는 점, 기업경영이 아닌 정부업무(중앙·지자체·교육청)에 관한 개선방안을 받는다는 점에서 민간기업의 제안제도와는 그
				성격이 다소 다르다 할 수 있습니다.</b><br><br>
				<b>기업제안이 보통 엄격한 심사기준과 혁신적인 아이디어를 요구하는 경향이 많다면,
				국민제안은 기업제안에 비해 그 문턱이 낮고 소통의 성격, 즉 </b><b style="color: skyblue">정부가 정책의 수요자인 국민으로부터 개선방안을 수렴하여
				행정서비스의 수준을 향상시키겠다는 목적</b><b>을 가지고 있습니다. </b><br><br><b>아울러 </b><b style="color: skyblue">참여민주주의의 확산에 따라 다수 국민이 정책에 직접
				참여하는 길을 열고, 정부와 국민이 머리를 맞대고 함께 대안을 만들어가는 민관 협력의 제도</b><b>이기도 합니다.</b></div>
			<hr />	
			<div class="box">
				<div class="row">
					<div class="col-6 col-12-small">
						<h3>신청방법</h3>
						<ul class="alt">
							<li><b style="color: #6495ED">①</b> <b>로그인</b></li>
							<li><b style="color: #6495ED">②</b> <b>국민제안</b></li>
							<li><b style="color: #6495ED">③</b> <b>제안하기</b></li>
							<li><b style="color: #6495ED">④</b> <b>신청하기버튼</b></li>
						</ul>
					</div>
					<div class="col-6 col-12-small">
						<h3>처리절차</h3>
						<ul class="alt">
							<li><b style="color: #6495ED">①</b> <b>제안신청</b></li>
							<li><b style="color: #6495ED">②</b> <b>제안심사</b></li>
							<li><b style="color: #6495ED">③</b> <b>제안답변</b></li>
						</ul>
					</div>
				</div>
			</div>
			<br><br> 
			<div class="row">
				<div class="col-6 col-12-small">
					<h3>작성법</h3>
					<div class="box">
						<b>제안서는 </b><b style="color: skyblue">현황 및 문제점, 개선방안, 기대효과</b><b>로
							구성됩니다.</b> <b>특정 제안이 논리적이고 설득력을 갖기 위해서는 이 </b><b
							style="color: skyblue">네 가지 구성요소</b><b>가 균형 있게 다루어져야 하며, 이중
							가장 중요한 것이 </b><b style="color: skyblue">개선방안</b><b>입니다.</b>
					</div>
				</div>
				<div class="col-6 col-12-small">
					<h3>심사기준</h3>
					<div class="box">
						<b>심사기준은 </b><b style="color: skyblue">실시가능성, 창의성, 효율성과 효과성,
							적용범위, 계속성</b><b> 등이며, 배점기준은 기관에 따라 조금씩 다르게 적용될 수 있습니다. 이러한 심사기준을
							이해하면서 제안서를 작성한다면 보다 나은 제안, 채택할 아이디어가 있는 제안이 나올 수 있습니다.</b>
					</div>
				</div>
			</div>
			<br><br>
			<h3>제안자와 심사자의 상호작용</h3>
			<div class="box"><b>제안은 </b><b style="color: #6495ED">착상→조사→정리→제출</b><b>의 과정을 거쳐야 하나 실제로는 ‘조사’와 ‘정리’과정을 생략한 채 성급하게 제출되는 경우가 많습니다.</b><br><br>
				<b>그로 인해 도입 필요성이 높고, 상당히 독창적인 아이디어들이 심사자를 제대로 설득하지 못하고 </b><b style="color: #F08080">불채택</b> <b>되고 있는 상황입니다. </b><br><br>
				<b>어떤 사람이 아이디어를 제안하고, 심사자가 이것을 채택할 것인지를 결정하는 제안처리과정은 본질적으로 </b><b style="color: #6495ED">상호작용과정</b><b>입니다.</b><br><br>
				<b>행정기관의 제도개선은 민간기업과는 달리 그 효과가 전국민, 전지역을 대상으로 나타나기 때문에 심사자는 특정제안을 채택하는데 신중을 기하지 않을 수 없습니다.</b><br><br> 
				<b>따라서 제안서를 통해 제안내용의 타당성을 논리적으로 설득시킬 수 있어야 하며, 객관적인 자료를 활용하여 이를 뒷받침 해주어야 합니다.</b></div>
		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />