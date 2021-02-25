<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h1>마이페이지</h1>
			</header>
			<hr/>
			<div class="row">
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">나의 청원&nbsp;<a href="/tellcen/mypage/petitionList"><u><b style="color: #00CED1">${petitionCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">나의 민원&nbsp;<a href="/tellcen/mypage/complaintList"><u><b style="color: #9370DB">${complaintCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">나의 제안&nbsp;<a href="/tellcen/mypage/suggestionList"><u><b style="color: #F08080">${suggestionCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">나의 문의&nbsp;<a href="/tellcen/mypage/inquiryList"><u><b style="color: #FFDAB9">${inquiryCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
			</div>
			
			<hr>
		</div>
	</section>

</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />