<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!-- Banner -->
<section id="banner" class="major">
	<div class="inner">
		<header class="major">
			<h1>말해주센</h1>
		</header>
		<div class="content">
			<b>무엇이든 말씀해주세요. 항상 소통하겠습니다.</b>
			<ul class="actions">
				<li><a href="#one" class="button next scrolly">시작하기</a></li>
			</ul>
		</div>
	</div>
</section>
<!-- Main -->
<div id="main">
	<!-- One -->
	<section id="one" class="tiles">
		<article>
			<span class="image"> <img src="images/pic01.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="/tellcen/petition/petitionWrite" class="link">청원하기</a>
				</h3>
				<p>Petition</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic02.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="/tellcen/complaint/complaintWrite" class="link">민원신청</a>
				</h3>
				<p>Complaint</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic03.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="/tellcen/suggestion/suggestionWrite" class="link">국민제안</a>
				</h3>
				<p>Suggestion</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic04.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="/tellcen/inquiry/inquiryWrite" class="link">오류·이용 문의</a>
				</h3>
				<p>Inquiry</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic05.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="/tellcen/notice/noticeList" class="link">공지사항</a>
				</h3>
				<p>Notice</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic06.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="/tellcen/mypage" class="link">마이페이지</a>
				</h3>
				<p>Mypage</p>
			</header>
		</article> 
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />