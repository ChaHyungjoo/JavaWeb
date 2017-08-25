<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<header id="header">
		<div class="content-container">
		<h1 id="logo">
			<a href="">
			<img src="../images/logo.png" alt="뉴렉쳐사이트" />
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
						<input type="" />
						<input type="submit" class="btn btn-search" value="" />
					</form>
				</section>
				
				
				<nav class="hr-list member-menu">	
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="">HOME</a></li>
						<li><a href="">로그인</a></li>
						<li><a href="">회원가입</a></li>
					</ul>	
				</nav>
					
				<nav id="customer-menu" class="hr-list">
					<h1 class="hidden">고객메뉴</h1>
					<ul>
						<li><a href=""><img alt="마이페이지" src="../images/txt-mypage.png" /></a></li>
						<li><a href=""><img alt="고객센터" src="../images/txt-customer.png" /></a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>
	
	<div id="visual">
		<div class="content-container">
		</div>
	</div>
	
	<div id="body" class="clearfix">
		<div class="content-container">
			<aside id="aside">
<!-- 				<h1>고객센터</h1>
				
				<nav>
					<h1>고객센터 메뉴</h1>
					<ul>
						<li><a href="">공지사항</a></li>
						<li><a href="">1:1고객문의</li>
						<li><a href="">학습안내</li>
					</ul>
				</nav>
			
				<nav>
					<h1>추천사이트</h1>
					<ul>
						<li>앤서이즈</li>
						<li>W3C</li>
						<li>마이크로소프트</li>
					</ul>
				</nav>
				
				<nav>
					<h1>구글광고</h1>
				</nav> -->
		  	</aside>
		  	
		  	<main id="main">
 				<h2>공지사항</h2>
				
				<div>
					<h3>경로</h3>	
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</div>
				  
				자세한 페이지
				
			</main>
		</div>
	</div>
	
	<footer id="footer">
		<div class="content-container">
		</div>
	</footer>
	
<!-- 	<div id="floating">
		플로팅 박스
		<div></div>
	</div> -->
	
</body>
</html>