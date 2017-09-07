<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
		<div class="content-container">
		<h1 id="logo">
			<a href="">
			<img src="${path}/images/logo.png" alt="뉴렉쳐사이트" />
			</a>
		</h1>
			<section>
				<h2 class="hidden">머릿말</h2>
				
				<nav class="hr-list main-menu">
					<h1 class="hidden">메인메뉴</h1>
					
					<ul>
						<li><a href="">학습가이드</a></li>
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>
				
				<section id="search-form">
					<h1 class="hidden">강좌검색 폼</h1>
					<form>
						<label>과정검색</label>
						<input type="text" />
						<input type="submit" class="btn btn-search" value="" />
					</form>
				</section>
				
				
				<nav class="hr-list member-menu">	
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="">HOME</a></li>
						<li>
							<c:if test="${empty sessionScope.id}">
								<a href="${path}/member/login">로그인</a>
							</c:if>
							<c:if test="${not empty sessionScope.id}">
								<a href="${path}/member/logout">로그아웃</a>
							</c:if>
						</li>
						<li><a href="${path}/member/agree">회원가입</a></li>
					</ul>	
				</nav>
					
				<nav id="customer-menu" class="hr-list">
					<h1 class="hidden">고객메뉴</h1>
					<ul>
						<li><a href="${path}/member/home"><img alt="마이페이지" src="${path}/images/txt-mypage.png" /></a></li>
						<li><a href="${path}/customer/notice-list"><img alt="고객센터" src="${path}/images/txt-customer.png" /></a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>


</body>
</html>