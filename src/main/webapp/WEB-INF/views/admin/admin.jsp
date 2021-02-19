<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/adminHeader.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<!-- Main -->
<div id="main" class="alt">
	<!-- One -->
	<section id="one">
		<div class="inner">
			<header class="major">
				<h1>관리자</h1>
			</header>
			<hr/>
			<div class="row">
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">청원&nbsp;<a href="/tellcen/admin/petition"><u><b style="color: #00CED1">${petitionCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">민원&nbsp;<a href="/tellcen/admin/complaint"><u><b style="color: #9370DB">${complaintCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">제안&nbsp;<a href="/tellcen/admin/suggestion"><u><b style="color: #F08080">${suggestionCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
				<div class="col-6 col-12-small">
					<div class="box" >
						<h2 align="center">문의&nbsp;<a href="/tellcen/admin/inquiry"><u><b style="color: #FFDAB9">${inquiryCount }</b></u></a>&nbsp;건</h2>
						<hr>
					</div>
				</div>
			</div>
			
			<hr>
		</div>
	</section>

</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />