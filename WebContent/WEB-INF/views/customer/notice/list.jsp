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
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	
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
				  
				<div>
					<h3>공지사항 검색 폼</h3>
					<form action="notice" method="get">
						<label>검색어</label>
						<input type="text" name="title"/>
						<input type="submit" />
					</form>
				</div>
	
				<table border="1">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
	
					<c:forEach var="n" items="${list}" begin="0" end="3" step="2">
						<tr>
							<td>${n.id}</td>
							<td><a href="notice-detail">${n.title}</a></td>
							<td>hj</td>
							<td>${n.regDate}</td>
							<td>${n.hit}</td>
						</tr>
					</c:forEach>
	
				</table>
				<a class="btn btn-default" href="">글쓰기</a>
				<a class="btn-img btn-cancel" href ="">취소</a>
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