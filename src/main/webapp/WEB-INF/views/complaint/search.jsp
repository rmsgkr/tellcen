<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<h1>민원목록</h1>
			</header>
			<!-- 검색기능 -->
			<form id="formSearch" method="get" action="search" class="searchForm">
				<div class="box">
					<div class="row">
						<div class="col-6 col-12-small">
							<b> 시작일</b> <input type="text" id="complaintSdate" name="complaintSdate"
								placeholder="시작일을 입력하세요"  autocomplete="off" >
						</div>
						<div class="col-6 col-12-small">
							<b>종료일</b> <input type="text" id="complaintEdate" name="complaintEdate"
								placeholder="종료일을 입력하세요"  autocomplete="off" >
						</div>
					</div>
				</div>
				<div class="fields">
					<div class="field half">
						<select name="complaintOrganization" id="complaintOrganization"
							onchange="categoryChange(this)">
							<option value="" disabled selected>기관분류</option>
							<option value="중앙행정기관">중앙행정기관</option>
							<option value="지방자치단체">지방자치단체</option>
							<option value="교육기관">교육기관</option>
							<option value="공공기관">공공기관</option>
							<option value="헌법기관">헌법기관</option>
						</select>
					</div>
					<div class="field half">
						<select name="complaintOrganizationDetail"
							id="complaintOrganizationDetail">
							<option value="" disabled selected>상세기관</option>
						</select>
					</div>
				</div>
				<div class="row gtr-200">
					<div class="col-9 col-12-medium">
						<input type="text" name="complaintTitle" id="complaintTitle"
							value="" placeholder="민원 제목을 검색하세요." autocomplete="off"/>
					</div>
					<div class="col-3 col-12-medium">
						<button type="button"
							class="button primary fit icon solid fa-search"
							onclick="button();">검 색</button>
					</div>
				</div>
			</form>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>기관분류</th>
							<th>상세기관</th>
							<th>제목</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${complaint.size() == 0}">
							<tr>
								<td colspan="6" align="center"><b>검색된 결과가 없습니다.</b></td>
							</tr>
						</c:if>
						<c:if test="${complaint.size() != 0}">
						<c:forEach items="${complaint }" var="list">
							<tr>
								<c:if test="${list.complaintStatus != 2}">
									<td>${list.complaintNo }</td>
									<td>${list.complaintOrganization }</td>
									<td>${list.complaintOrganizationDetail }</td>
									<td><a href="/tellcen/complaint/${list.complaintNo}">[${list.complaintTitle }
											]</a></td>
									<td><fmt:formatDate value="${list.complaintDate }"
											pattern="yyyy/MM/dd" /></td>
									<td>${list.complaintCount }</td>
									<c:if test="${list.complaintStatus == 0}">
										<td><b style="color: #6495ED">심사중</b></td>
									</c:if>
									<c:if test="${list.complaintStatus == 1}">
										<td><b style="color: #00CED1">답변완료</b></td>
									</c:if>
								</c:if>
							</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<!-- 페이징 -->
			<ul class="pagination" style="text-align: center;">
				<c:if test="${paging.startPage != 1 }">
					<li><a
						href="/tellcen/complaint/search?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&complaintTitle=${paging.complaintTitle}&complaintOrganization=${paging.complaintOrganization}&complaintOrganizationDetail=${paging.complaintOrganizationDetail}&complaintSdate=${paging.complaintSdate}&complaintEdate=${paging.complaintEdate}"
						class="button small">Prev</a></li>
				</c:if>

				<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
					var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<li><a href="#" class="page active">${p }</a></li>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<li><a
								href="/tellcen/complaint/search?nowPage=${p }&cntPerPage=${paging.cntPerPage}&complaintTitle=${paging.complaintTitle}&complaintOrganization=${paging.complaintOrganization}&complaintOrganizationDetail=${paging.complaintOrganizationDetail}&complaintSdate=${paging.complaintSdate}&complaintEdate=${paging.complaintEdate}"
								class="page">${p }</a></li>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${paging.endPage != paging.lastPage}">
					<li><a
						href="/tellcen/complaint/search?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&complaintTitle=${paging.complaintTitle}&complaintOrganization=${paging.complaintOrganization}&complaintOrganizationDetail=${paging.complaintOrganizationDetail}&complaintSdate=${paging.complaintSdate}&complaintEdate=${paging.complaintEdate}"
						class="button small">Next</a></li>
				</c:if>
			</ul>
		</div>
	</section>
</div>
<script>
	function button() {
		const searchForm = document.querySelector('.searchForm');
		searchForm.submit();
	}
	function categoryChange(e) {
		var category_a = [ "개인정보보호위원회", "경찰청", "고용노동부", "공정거래위원회", "과학기술정보통신부",
				"관세청", "교육부", "국가보훈처", "국가인권위원회", "국가정보원", "국무조정실", "국무총리비서실",
				"국민권익위원회", "국방부", "국세청", "국토교통부", "금융위원회", "기상청", "기획재정부",
				"농림축산식품부", "농촌진흥청", "대검찰청", "문화재청", "문화체육관광부", "민주평화통일자문회의사무처",
				"방송통신위원회", "방위사업청", "법무부", "법제처", "병무청", "보건복지부", "산림청",
				"산업통상자원부", "새만금개발청", "소방청", "식품의약품안전처", "여성가족부", "외교부",
				"원자력안전위원회", "인사혁신처", "조달청", "중소벤처기업부", "질병관리청", "통계청", "통일부",
				"특허청", "해양경찰청", "해양수산부", "행정안전부", "행정중심복합도시건설청", "환경부" ];
		var category_b = [ "강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시",
				"대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "울산광역시", "인천광역시", "전라남도",
				"전라북도", "제주특별자치도", "충청남도", "충청북도" ];
		var category_c = [ "강원도교육청", "경기도교육청", "경상남도교육청", "경상북도교육청",
				"광주광역시교육청", "대구광역시교육청", "대전광역시교육청", "부산광역시교육청", "서울특별시교육청",
				"세종특별자치시교육청", "울산광역시교육청", "인천광역시교육청", "전라남도교육청", "전라북도교육청",
				"제주특별자치도교육청", "충청남도교육청", "충청북도교육청" ];
		var category_d = [ "가축위생방역지원본부", "건강보험심사평가원", "건설근로자공제회", "게임물관리위원회",
				"경기도가족여성연구원", "경기도경제과학진흥원", "경기도의료원", "경기도체육회", "경기문화재단",
				"경기신용보증재단", "경기주택도시공사", "경기콘텐츠진흥원", "경상북도개발공사", "경제인문사회연구회",
				"공무원연금공단", "광주과학기술원", "광주광역시도시공사", "광주광역시도시철도공사", "광주도시관리공사",
				"구미시설공단", "국가철도공단", "국가평생교육진흥원", "국립공원공단", "국립박물관문화재단",
				"국립생태원", "국립암센터", "국립중앙의료원", "국립해양생물자원관", "국민건강보험공단", "국민연금공단",
				"국민체육진흥공단", "국방과학연구소", "국방기술품질원", "국악방송", "국제방송교류재단",
				"국제식물검역인증원", "국토안전관리원", "국토연구원", "근로복지공단", "금융감독원", "금융결제원",
				"기술보증기금", "노사발전재단", "농림수산식품교육문화정보원", "농림식품기술기획평가원",
				"농업기술실용화재단", "농업정책보험금융원", "대구도시공사", "대전광역시도시철도공사",
				"대전광역시시설관리공단", "대전도시공사", "대전마케팅공사", "대한무역투자진흥공사", "대한법률구조공단",
				"대한변호사협회", "대한석탄공사", "대한장애인체육회", "대한적십자사", "대한체육회", "도로교통공단",
				"독립기념관", "동남권원자력의학원", "동북아역사재단", "방송통신심의위원회", "별정우체국연금관리단",
				"부마민주항쟁진상규명및관련자명예회복심의위원회", "부산관광공사", "부산교통공사", "부산도시공사",
				"부산시설공단", "부산신항제이배후도로주식회사", "부산울산고속도로주식회사", "부산지방공단스포원",
				"부산항만공사", "부산항보안공사", "부산환경공단", "북한이탈주민지원재단", "산립조합중앙회",
				"서민금융진흥원", "세종학당재단", "소상공인시장진흥공단", "수도권매립지관리공사", "시청자미디어재단",
				"신대구부산고속도로주식회사", "신용보증기금", "신용회복위원회", "자동차손해배상진흥원", "재외동포재단",
				"전략물자관리원", "전북개발공사", "정보통신산업진흥원", "정부법무공단", "제주국제자유도시개발센터",
				"제주영상문화산업진흥원", "주택도시보증공사", "중소기업기술정보진흥원", "중소기업유통센터", "중소기업은행",
				"중소기업벤처기업진흥공단", "창업진흥원", "청주시시설관리공단", "축산물품질평가원", "충주시시설관리공단",
				"충청남도개발공사", "태권도진흥재단", "포항시시설관리공단", "학교법인한국폴리텍", "한국가스공사",
				"한국가스기술공사", "한국가스안전공사", "한국개발연구원", "한국거래소", "한국건강가정진흥원",
				"한국건설생황환경시험연구원", "한국고용정보원", "한국고전번역원", "한국공정거래조정원", "한국공항공사",
				"한국과학기술기획평가원", "한국과학기술연구원", "한국과학기술원", "한국과학기술원부설고등과학원",
				"한국과학창의재단", "한국관광공사", "한국광물자원공사", "한국광해관리공단", "한국교육개발원",
				"한국교육과정평가원", "한국교육학술정보원", "한국교통안전공단", "한국국제교류재단", "한국국제협력단",
				"한국국토정보공사", "한국기계전기전자시험연구원", "한국기상산업기술원", "한국기술교육대학교",
				"한국남동발전", "한국남부발전", "한국농수산식품유통공사", "한국농어촌공사", "한국농촌경제연구원",
				"한국도로공사", "한국도박문제관리센터", "한국동서발전", "한국로봇산업진흥원", "한국마사회",
				"한국무역보험공사", "한국문학번역원", "한국문화관광연구원", "한국문화예술교육진흥원", "한국문화예술위원회",
				"한국문화재재단", "한국방송광고진흥공사", "한국방송통신전파진흥원", "한국법무보호복지공단",
				"한국법제연구원", "한국벤처투자", "한국보건사회연구원", "한국보건산업진흥원", "한국보건의료연구원",
				"한국보건의료인국가시험원", "한국보훈복지의료공단", "한국부동산원", "한국사학진흥재단",
				"한국사회보장정보원", "한국사회적기업진흥원", "한국산림복지진흥원", "한국산업기술시험원",
				"한국산업기술진흥원", "한국산업기술평가관리원", "한국산업단지공단", "한국산업안전보건공단", "한국산업은행",
				"한국산업인력공단", "한국생산기술연구원", "한국서부발전(주)", "한국석유공사", "한국석유관리원",
				"한국세라믹기술원", "한국소비자원", "한국수력원자력(주)", "한국수목원관리원", "한국수자원공사",
				"한국수출입은행", "한국스마트그리드사업단", "한국승강기안전공단", "한국식품안전관리인증원",
				"한국식품연구원", "한국식품연구원부설세계김치연구소", "한국양성평등교육진흥원", "한국언론진흥재단",
				"한국에너지공단", "한국에너지기술평가원", "한국여성인권진흥원", "한국영상자료원", "한국예탁결제원",
				"한국우편사업진흥원", "한국원자력안전기술원", "한국원자력안전재단", "한국원자력연구원", "한국원자력의학원",
				"한국원자력통제기술원", "한국원자력환경공단", "한국은행", "한국의료기간안전정보원",
				"한국의료분쟁조정중재원", "한국의류시험연구원", "한국의약품안전관리원", "한국인터넷진흥원",
				"한국자산관리공사", "한국자활복지개발원", "한국장애인고용공단", "한국장학재단", "한국재료연구원",
				"한국재정정보원", "한국저작권보호원", "한국저작권위원회", "한국전기안전공사", "한국전력거래소",
				"한국전력공사", "한국정보통신진흥협회", "한국제품안전관리원", "한국주택금융공사", "한국중부발전주식회사",
				"한국지능정보사회진흥원", "한국지식재산보호원", "한국지역난방공사", "한국직업능력개발원", "한국전문연구원",
				"한국철도공사", "한국청소년상담복지개발원", "한국청소년활동진흥원", "한국체육산언개발주식회사",
				"한국출판문화산업진흥원", "한국콘텐츠진흥원", "한국토지주택공사", "한국통신사업자연합회", "한국투자공사",
				"한국학중앙연구원", "한국항로표지기술원", "한국해양교통안전공단", "한국해양수산개발원",
				"한국해양수산연수원", "한국해양진흥공사", "한국형사정책연구원", "한국화학융합시험연구원", "한국환경공단",
				"한국환경산업기술원", "한국환경정책평가연구원", "한국희귀의약품센터", "한식진흥원", "한전KDN",
				"한전KPS(주)", "해양환경공단" ];
		var category_e = [ "법원행정처(대법원)", "중앙선거관리위원회", "헌법재판소" ];
		var target = document.getElementById("complaintOrganizationDetail");

		if (e.value == "중앙행정기관")
			var category = category_a;
		else if (e.value == "지방자치단체")
			var category = category_b;
		else if (e.value == "교육기관")
			var category = category_c;
		else if (e.value == "공공기관")
			var category = category_d;
		else if (e.value == "헌법기관")
			var category = category_e;

		target.options.length = 0;

		for (x in category) {
			var opt = document.createElement("option");
			opt.value = category[x];
			opt.innerHTML = category[x];
			target.appendChild(opt);
		}
	}

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />