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
	<jsp:include page="../inc/header.jsp"></jsp:include>
	
	<!-- visual 부분 -->
	<jsp:include page="inc/visual.jsp"></jsp:include>
	
	<div id="body" class="clearfix">
		<div class="content-container">
			<!-- aside 부분 -->
			<jsp:include page="inc/aside.jsp"></jsp:include>
		  	
		  	<main id="main">
 				<h2>학생 index 페이지</h2>
				
				
				
			</main>
		</div>
	</div>
	
	<!-- footer 부분 -->
	<jsp:include page="../inc/footer.jsp"></jsp:include>
	
</body>
</html>