<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	
	<!-- visual 부분 -->
	<jsp:include page="../inc/visual.jsp"></jsp:include>
	
	<div id="body" class="clearfix">
		<div class="content-container">
			<!-- aside 부분 -->
			<jsp:include page="../inc/aside.jsp"></jsp:include>
		  	
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
				<table class="table">
					<tr>
						<th>제목</th>
						<td colspan="3">${notice.title}</td>
					</tr>
						<th>작성일</th>
						<td colspan="3">${notice.regDate}</td>
					<tr>
						<th>작성자</th>
						<td>${notice.writerId}</td>
						<th>조회수</th>
						<td>${notice.hit}</td>
					</tr>
					
					<tr>
						<th>첨부파일</th>
						<td colspan="3"><a download href="../../upload/${notice.fileName}">${notice.fileName}</a></td>
					</tr>
					
					<tr>
						<td colspan="4">${notice.content}</td>
					</tr>
					
				</table>
				
				<div>
					<a class="btn btn-default" href="list">목록</a>
					<a class="btn btn-default" href="edit?id=${notice.id}">수정</a>
					<a class="btn btn-default" href="del">삭제</a>
				</div>
			</main>
		</div>
	</div>
	
	<!-- footer 부분 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
	
</body>
</html>