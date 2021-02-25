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
				<h1>회원탈퇴</h1>
			</header>
			<div class="box">
						<h3 style="color: #F08080">탈퇴시 유의사항</h3>
						<ul class="alt">
							<li><b style="color: #F08080">①</b> <b>회원 탈퇴 시 회원님의 정보는 말해주센 정보보호정책에따라 관리 됩니다.</b></li>
							<li><b style="color: #F08080">②</b> <b>탈퇴한 ID와 동일한 ID로 재가입 할 수 없습니다.</b></li>
							<li><b style="color: #F08080">③</b> <b>이전에 신청하신 청원/민원/제안 내역들은 말해주센에서 보관합니다.</b></li>
						</ul>
					<form method="post" action="deleteMember" name="deleteForm">
						<h3>[ 회원님의 정보를 안전하게 보호하기 위해 <u>비밀번호</u>를 재인증 해주세요. ]</h3>
						<ul class="alt">
							<li><input type="password" name="pwd" placeholder="비밀번호를 입력해주세요."></li>
						</ul>
						<input type="hidden" name="id" value="${member.id}">
					</form>
					<input type="button" class="button primary large" value="탈퇴하기"
			 			onclick="button()" style="float: right"> <br> <br>  
				</div>
			</div>
	</section>
</div>
<script>
	function button() {
		
			if (deleteForm.pwd.value == "") {
				alert('비밀번호를 입력해주세요.');
				deleteForm.pwd.focus();
				return;
			}
			
			deleteForm.submit();
	} 
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />