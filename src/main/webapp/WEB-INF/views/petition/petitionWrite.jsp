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
				<h1>청원하기</h1>
			</header>
			<h3>운영원칙 및 주의사항</h3>
			<div class="box">
				<p>운영원칙 방송통신심의위원회의 ‘정보통신에 관한 심의 규정’, 한국인터넷자율정책기구의 ‘정책규정’ 등을 기반으로
					문제 게시물은 삭제될 수 있습니다.</p> 
				<p>자극적이고 혐오스러운 내용, 비속어, 폭력적 내용, 특정 대상을 비하하거나 차별을
					조장하는 내용, 개인정보 유출을 비롯해 타인의 권리를 침해하는 내용, 반복되는 내용 등은 제재될 수 있습니다. 
					<br>
					<br>청원기간은 30일 입니다.<br>
					<br><h4 style=color:red>청원 작성시 주의사항</h4>
					한번 작성된 청원은 수정 및 삭제가 불가능합니다. 
					<br>최초 청원취지와 다른 내용으로 변경되는 것을 방지하여 청원참여자의 의견을 보호하기 위한 조치이니 신중하게 작성하여 주시기 바랍니다.
					<br><br><h4 style=color:skyblue>청원 요건에 해당되지 않는 사항 </h4>
					1. 국가기관이나 지방자치단체 등 특정 기관·단체를 근거없이 비난하거나 모독하는 사항 
					<br>2. 감사·수사·재판·행정심판·조정·중재 등 다른 법령에 의한 조사· 불복 또는 구제절차가 진행중인 사항 
					<br>3. 욕설, 비속어 등 폭력적이고 선정적인 내용 
					<br>4. 허위사실이나 타인의 명예를 훼손하는 내용
					<br>5. 정치적 목적이 있거나 영리목적의 상업적인 내용 
					<br>6. 사인간의 권리관계 또는 개인의 사생활에 관한 사항 
					<br>7. 동일 이용자가 동일한 내용의 청원서를 2회 이상 제출한 경우 나중에 제출된 것 
					<br>8. 그밖에 공익을 저해하거나 법령에 위배되는 등 게시판 운영 취지에 맞지 아니하는 게시물 등</p>
			</div>
			<form method="post" class="petitionWrite" name="writeForm" action="petitionWrite">
				<div class="fields">
					<div class="field half">
						<h3>지역</h3>
						<select name="petitionArea" id="petitionArea">
							<option value="" disabled selected>- 선택 -</option>
							<option value="서울">서울</option>
							<option value="인천">인천</option>
							<option value="경기">경기</option>
							<option value="강원">강원</option>
							<option value="충남">충남</option>
							<option value="충북">충북</option>
							<option value="전남">전남</option>
							<option value="전북">전북</option>
							<option value="경남">경남</option>
							<option value="경북">경북</option>
							<option value="제주">제주</option>
						</select>
					</div> 
					<div class="field half">
						<h3>분야</h3>
						<select name="petitionField" id="petitionField">
							<option value="" disabled selected>- 선택 -</option>
							<option value="가족ㆍ보건ㆍ복지">가족ㆍ보건ㆍ복지</option>
							<option value="문화ㆍ관광ㆍ체육">문화ㆍ관광ㆍ체육</option>
							<option value="교육ㆍ취업">교육ㆍ취업</option>
							<option value="교통ㆍ건설ㆍ환경">교통ㆍ건설ㆍ환경</option>
							<option value="농림ㆍ축산ㆍ해양">농림ㆍ축산ㆍ해양</option>
							<option value="도시ㆍ주택">도시ㆍ주택</option>
							<option value="산업ㆍ경제">산업ㆍ경제</option>
							<option value="소방ㆍ재난ㆍ안전">소방ㆍ재난ㆍ안전</option>
							<option value="조세ㆍ법무ㆍ행정">조세ㆍ법무ㆍ행정</option>
							<option value="기타">기타</option>
						</select>
					</div>
					<div class="field">
						<h3>청원제목</h3>
						<input type="text" name="petitionTitle" id="petitionTitle" placeholder="청원 제목을 입력하세요." />
					</div>
					<div class="field">
						<h3>청원내용</h3>
						<textarea name="petitionContent" id="petitionContent" rows="6" placeholder="청원 내용을 입력하세요."></textarea>
					</div>
				</div>
			</form>
			<input type="button" class="button primary large" value="신청하기"
					onclick="button()"> 
			<hr class="major" />
		</div>
	</section>
</div>
<script>
function button() {
	if (writeForm.petitionArea.value == "") {
		alert('지역을 선택해주세요.');
		writeForm.petitionArea.focus();
		return;
	}
	if (writeForm.petitionField.value == "") {
		alert('분야를 선택해주세요.');
		writeForm.petitionField.focus();
		return;
	}
	if (writeForm.petitionTitle.value == "") {
		alert('제목을 입력해주세요.');
		writeForm.petitionTitle.focus();
		return;
	}
	if (writeForm.petitionContent.value == "") {
		alert('내용을 입력해주세요.');
		writeForm.petitionContent.focus();
		return;
	}
	writeForm.submit();
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />