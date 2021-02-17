<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>오류신고·이용문의</h1>
				<c:if test="${inquiry.inquiryStatus == 0}">
				<button class="button large" onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry/${inquiry.inquiryNo}/answer'">답변</button>
				<button class="button large" onclick="window.location.href='<%=request.getContextPath()%>/admin/inquiry/${inquiry.inquiryNo}/delete'">삭제</button>
				</c:if> 
			</header>
			<hr>
			<section id="contact">

				<div class="inner">
					<section>

						<div class="fields">
							<h2>문의 내용</h2>
							<div class="box">
								<p>${inquiry.inquiryContent }</p>
							</div>
						</div>
					</section>
					<section class="split">
						<section>
							<div class="contact-method">
								<h3>제목 : ${inquiry.inquiryTitle }</h3>
							</div>
						</section>
						<section>
							<div class="contact-method">
								<h3>
									신청일 :
									<fmt:formatDate value="${inquiry.inquiryDate }"
										pattern="yyyy/MM/dd" />
								</h3>
							</div>
						</section>

					</section>
				</div>
			</section>
			<c:if test="${inquiry.inquiryStatus == 1}">
				<section id="contact">
					<c:forEach items="${answerI }" var="answer">
						<div class="inner">
							<section>

								<div class="fields">

									<h2>답변 내용</h2>

									<div class="box">
										<p>${answer.answerIContent }</p>
									</div>
								</div>

							</section>
							<section class="split">
								<section>
									<div class="contact-method">
									</div>
								</section>
								<section>
									<div class="contact-method">
										<h3>
											답변등록일 :
											<fmt:formatDate value="${answer.answerIDate }"
												pattern="yyyy/MM/dd" />
										</h3>
									</div>
								</section>
							</section>
						</div>
					</c:forEach>
				</section>
			</c:if>



		</div>
	</section>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />