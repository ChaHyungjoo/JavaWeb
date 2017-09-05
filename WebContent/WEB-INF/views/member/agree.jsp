<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
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
 				<h2>가입동의</h2>
				
				<div>
					<h3>경로</h3>	
					<ol>
						<li>HOME</li>
						<li>회원정보</li>
						<li>가입동의</li>
					</ol>
				</div>
				
				<c:if test="${not empty param.error}">
					<div style="color:red;">
						모든 내용에 동의를 하셔야 합니다.
					</div>
				</c:if>
				
				<form method="post">
					<div>
						<h3>개인정보 활용 동의</h3>
						<div style="width: 100%; height: 100px; overflow: scroll;">
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
							가입된 정보는.........<br />
						</div>
					</div>
					
					<div>
						<input type="checkbox" name="agree" value="ok"/>
					</div>
					
					<div>
						<input type="submit" value="가입동의"/>
					</div>
				</form>
							
			</main>
		</div>
	</div>
	
	<!-- footer 부분 -->
	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>
</html>