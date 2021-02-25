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
				<h1>회원정보수정</h1>
			</header>
			<form method="post" class="modify" name="modifyForm" action="modifyMember">
				<div class="table-wrapper">
					<table class="alt">
						<tbody>
							<tr>
								<th>아이디</th>
								<td>
								<input type="hidden" name="id" id="id" value="${member.id}" />${member.id}
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="pwd"
									placeholder="비밀번호를 입력해주세요." /></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" name="name"
									value="${info.name}" readonly/></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td style=text-align:center;>
									<input type="text" name="email1" 
									value="${info.email1}" style=width:30%;float:left; autocomplete="off"/> 
									@
									<input type="text" name="email2" value="${info.email2}" readonly style=width:30%;display:inline-block;>  
									&nbsp;&nbsp;&nbsp;&nbsp;
									<select name="emailBox"onchange="email_change2()" style=width:30%;display:inline-block;> 
										<option value="0" disabled selected>메일선택</option>
										<option value="9">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="nate.com">nate.com</option>
										<option value="daum.net">daum.net</option>
										<option value="gmail.com">gmail.com</option> 
									</select> 
								</td>
							</tr>
							<tr>
								<th>휴대전화</th>
								<td style=text-align:center;>
									<select name="tel1" style=width:30%;float:left;>
										<option value="" disabled selected>---</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
								</select> 
								-&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tel2" class="JJ" style=width:30%;display:inline-block; value="${info.tel2}" autocomplete="off"> 
								-&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tel3" class="JJ" style=width:30%;display:inline-block; value="${info.tel3}" autocomplete="off">
								</td>
							</tr>
							<tr> 
								<th>주소</th>
								<td>  
									<input type="text" name="zipcode" id="sample6_postcode" class="address" value="${info.zipcode}" readonly style="width:200px;float:left;">
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="button" style=display:inline-block;>
									<input type="text" name="address1" id="sample6_address" value="${info.address1}" class="address" readonly>
									<input type="text" name="address2" id="sample6_detailAddress" value="${info.address2}" class="address" autocomplete="off">
									<input type="text" name="address3" id="sample6_extraAddress" value="${info.address3}" class="address" readonly>
								</td>
							</tr>
						</tbody>
						
						<tfoot>
							<tr>
								<td colspan="1"></td>
								<td colspan="2" align="right"><input type="button"
									class="button primary large" value="수정하기" onclick="button2()">
									</td>
							</tr>
						</tfoot>
					</table>
				</div>

			</form>
		</div>
	</section>
</div>
<script src="/tellcen/resources/js/login.js"></script>
<script type="text/javascript">
	document.modifyForm.tel1.value='${info.tel1}';
	document.modifyForm.emailBox.value='${info.email2}';
</script>
<!-- 다음 주소검색 APi -->
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0c3b575d9b62709c133865c5dc51d0cc&libraries=services"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />