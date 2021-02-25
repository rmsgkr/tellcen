<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<ul class="links" id="sidebar">
	<li><a href="/tellcen" class="button large fit">말해주센<span
			class="icon solid alt fa-home"></span></a></li>
	<li></li>
	<li><a href="/tellcen/inquiry/inquiryWrite"
		class="button large fit">문의하기</a></li>
	<li><a href="/tellcen/inquiry/inquiryQuestion"
		class="button large fit">자주하는질문</a></li>
</ul>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>자주하는질문</h1>
			</header>
			<blockquote>
				<div id="toggleButton1">
					<a href="#"><h3><b style="color: #6495ED">①</b>&nbsp;신청한 청원/민원/제안이 보이지 않습니다.</h3></a>
				</div>
				<div id="Menu1" style="display: none">
					<div class="box">내용 중 개인정보 노출, 비속어 등 공개되기에 부적절하거나 말해주센의 취지에
						맞지않는 광고성 내용 등의 경우 관리자에 의해 비공개로 전환될 수 있습니다.</div>
				</div>

				<div id="toggleButton2">
					<a href="#"><h3><b style="color: #6495ED">②</b>&nbsp;신청한 건에 대한 답변은 어디에서 볼 수 있나요?</h3></a>
				</div>
				<div id="Menu2" style="display: none">
					<div class="box">말해주센 사이트에서 로그인 하신 후 마이페이지에서 확인하실 수 있으며 각
						청원/민원/제안목록에서도 확인이 가능하십니다.</div>
				</div>

				<div id="toggleButton3">
					<a href="#"><h3><b style="color: #6495ED">③</b>&nbsp;청원/민원/제안을 신청한 후 내용 등을 수정하려고 하는데 어떻게 하나요?</h3></a>
				</div>
				<div id="Menu3" style="display: none">
					<div class="box">수정은 신청단계(신청하기 버튼 누르기 전)에서만 가능합니다. 접수 이후의 심사
						중인 청원/민원/제안은 일체의 정보 수정이 되지 않으니 참조해 주시기 바랍니다.</div>
				</div>

				<div id="toggleButton4">
					<a href="#"><h3><b style="color: #6495ED">④</b>&nbsp;채택된 건은 어떻게 진행되나요?</h3></a>
				</div>
				<div id="Menu4" style="display: none">
					<div class="box">특별한 사유가 없으면 지체 없이 이를 행정에 적용하여 실시하거나 부분적인
						수정ㆍ보완을 거쳐 실시하도록 하고 있습니다. 그러나 현실적으로 과제가 큰 경우 예산확보 및 법령개정 필요, 사업실행계획
						수립 등의 실시추진과정이 필요하여 최종 행정 적용에 다소 시간이 소요될 수 있습니다.</div>
				</div>

				<div id="toggleButton5">
					<a href="#"><h3><b style="color: #6495ED">⑤</b>&nbsp;회원가입 후 탈퇴를 했는데 가입이 안됩니다.</h3></a>
				</div>
				<div id="Menu5" style="display: none">
					<div class="box">말해주센 회원으로 가입한 이후 탈퇴시 이전 아이디로 재가입이 불가능하다는 설명을 해드렸습니다.
					다른 아이디로 가입하시는 것을 권유드립니다.</div>
				</div>
				</blockquote> 

		</div>
	</section>
</div>
<script>
	
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />