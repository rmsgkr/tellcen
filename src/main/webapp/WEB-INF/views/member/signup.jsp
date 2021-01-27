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
				<h1>회원가입</h1>
			</header>
			<form method="post" class="sign" name="signUpForm" action="signup">
				<div class="table-wrapper">
					<table class="alt">
						<tbody>
							<tr>
								<th>아이디</th>
								<td><input type="text" name="id" id="id"
									placeholder="아이디를 입력해주세요." />
									<div id="id_check"></div></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="pwd"
									placeholder="비밀번호를 입력해주세요." /></td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" name="rePwd"
									onkeyup="checkPwd()" placeholder="비밀번호를 다시 입력해주세요." />
									<div id="checkPwd">동일한 비밀번호를 입력하세요.</div></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" name="name"
									placeholder="이름을 입력해주세요." /></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td style=text-align:center;>
									<input type="text" name="email1" 
									onfocus="this.value='';" placeholder="이메일을 입력해주세요." style=width:30%;float:left;/> 
									@
									<input type="text" name="email2" readonly style=width:30%;display:inline-block;>  
									&nbsp;&nbsp;&nbsp;&nbsp;
									<select name="emailBox"onchange="email_change()" style=width:30%;display:inline-block;> 
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
								-&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tel2" class="JJ" style=width:30%;display:inline-block;> 
								-&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tel3" class="JJ" style=width:30%;display:inline-block;>
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td><input type="date" name="birthday" style=color:black;></td>
							</tr>
							<tr>
								<th>성별</th>
								<td>
									<input type="radio" id="radio1" name="gender" value="M"> 
									<label for="radio1">남자</label>
									<input type="radio" id="radio2" name="gender" value="F"> 
									<label for="radio2">여자</label> 
								</td>
							</tr>
							<tr> 
								<th>주소</th>
								<td>  
									<input type="text" name="zipcode" id="sample6_postcode" class="address" placeholder="우편번호" readonly style="width:200px;float:left;">
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="button" style=display:inline-block;>
									<input type="text" name="address1" id="sample6_address" placeholder="주소" class="address" readonly>
									<input type="text" name="address2" id="sample6_detailAddress" placeholder="상세주소" class="address">
									<input type="text" name="address3" id="sample6_extraAddress" placeholder="참고항목" class="address" readonly>
								</td>
							</tr>
						</tbody>
						
						<tfoot>
							<tr>
								<td colspan="1"></td>
								<td colspan="2" align="right"><input type="button"
									class="button primary large" value="회원가입" onclick="button()">
									<input type="reset" class="button large" value="다시쓰기"></td>
							</tr>
						</tfoot>
					</table>
				</div>

			</form>
		</div>
	</section>
</div>
	<script src="/tellcen/resources/js/login.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
	function checkPwd() {
		var f1 = document.forms[0];
		var pwd = f1.pwd.value;
		var rePwd = f1.rePwd.value;
		if (pwd.length >= 7) {
			if (pwd != rePwd) {
				document.getElementById('checkPwd').style.color = "red";
				document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요.";
			} else {
				document.getElementById('checkPwd').style.color = "white";
				document.getElementById('checkPwd').innerHTML = "암호가 확인 되었습니다.";
			}
		} else {
			document.getElementById('checkPwd').innerHTML = "비밀번호를 7자리이상 입력하세요.";
		}

	};

	//아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#id").blur(function() {
		var id = $('#id').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/member/idCheck?id=' + id,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : " + data);
				if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#id_check").text("사용중인 아이디입니다.");
					$("#id_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
				} else {

					/* if(idJ.test(id)){
						// 0 : 아이디 길이 / 문자열 검사
						$("#id_check").text("");
						$("#reg_submit").attr("disabled", false);
					
					} else  */if (id == "") {

						$('#id_check').text('아이디를 입력해주세요 :)');
						$('#id_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);

					} else {

						$('#id_check').text("사용가능한 아이디입니다.");
						$('#id_check').css('color', 'blue');
						$("#reg_submit").attr("disabled", true);
					}

				}
			},
			error : function() {
				console.log("실패");
			}
		});
	});
</script>
<!-- 다음 주소검색 APi -->
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0c3b575d9b62709c133865c5dc51d0cc&libraries=services"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />