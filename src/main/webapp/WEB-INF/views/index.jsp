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
			<p>무엇이든 말씀해주세요. 항상 소통하겠습니다.</p>
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
					<a href="/tellcen/petition/petitionList" class="link">민원신청</a>
				</h3>
				<p>Complaint</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic03.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="landing.jsp" class="link">국민제안</a>
				</h3>
				<p>Suggestion</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic04.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="landing.jsp" class="link">공지사항</a>
				</h3>
				<p>Notice</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic05.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="landing.html" class="link">오류·이용 문의</a>
				</h3>
				<p>Inquiry</p>
			</header>
		</article>
		<article>
			<span class="image"> <img src="images/pic06.jpg" alt="" />
			</span>
			<header class="major">
				<h3>
					<a href="landing.html" class="link">마이페이지</a>
				</h3>
				<p>Mypage</p>
			</header>
		</article> 
	</section>

	<!-- Two -->
	<!-- <section id="two">
		<div class="inner">
			<header class="major">
				<h2>Massa libero</h2>
			</header>
			<p>Nullam et orci eu lorem consequat tincidunt vivamus et
				sagittis libero. Mauris aliquet magna magna sed nunc rhoncus
				pharetra. Pellentesque condimentum sem. In efficitur ligula tate
				urna. Maecenas laoreet massa vel lacinia pellentesque lorem ipsum
				dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et
				sagittis libero. Mauris aliquet magna magna sed nunc rhoncus amet
				pharetra et feugiat tempus.</p>
			<ul class="actions">
				<li><a href="landing.html" class="button next">Get Started</a></li>
			</ul>
		</div>
	</section>  -->

</div>

<!-- Contact -->
<!-- <section id="contact">
	<div class="inner">
		<section>
			<form method="post" action="#">
				<div class="fields">
					<div class="field half">
						<label for="name">Name</label> <input type="text" name="name"
							id="name" />
					</div>
					<div class="field half">
						<label for="email">Email</label> <input type="text" name="email"
							id="email" />
					</div>
					<div class="field">
						<label for="message">Message</label>
						<textarea name="message" id="message" rows="6"></textarea>
					</div>
				</div>
				<ul class="actions">
					<li><input type="submit" value="Send Message" class="primary" /></li>
					<li><input type="reset" value="Clear" /></li>
				</ul>
			</form>
		</section>
		<section class="split">
			<section>
				<div class="contact-method">
					<span class="icon solid alt fa-envelope"></span>
					<h3>Email</h3>
					<a href="#">information@untitled.tld</a>
				</div>
			</section>
			<section>
				<div class="contact-method">
					<span class="icon solid alt fa-phone"></span>
					<h3>Phone</h3>
					<span>(000) 000-0000 x12387</span>
				</div>
			</section>
			<section>
				<div class="contact-method">
					<span class="icon solid alt fa-home"></span>
					<h3>Address</h3>
					<span>1234 Somewhere Road #5432<br /> Nashville, TN 00000<br />
						United States of America
					</span>
				</div>
			</section>
		</section>
	</div>
</section> -->
<jsp:include page="/WEB-INF/views/common/footer.jsp" />