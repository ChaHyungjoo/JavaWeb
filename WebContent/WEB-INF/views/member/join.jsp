<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/> 

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
 				<h2>회원가입</h2>
				
				<div>
					<h3>경로</h3>	
					<ol>
						<li><a href="">HOME</a></li>
						<li><a href="">회원정보</a></li>
						<li><a href="">회원가입</a></li>
					</ol>
				</div>
				
				<form method="post">
			         <fieldset>
			            <legend>회원정보</legend>
			            <table>
			               <tbody>
			                  <tr>
			                     <th><label>아이디</label></th>
			                     <td>
			                        <input name="id" value=""/>
			                        <a target="_blank" href="check-id">중복확인</a>
			                        <span></span>
			                     </td>
			                  </tr>
			                  <tr>
			                     <th><label>비밀번호</label></th>
			                     <td><input name="pwd" /></td>
			                  </tr>
			                  <tr>
			                     <th><label>비밀번호 확인</label></th>
			                     <td><input name="pwd" /></td>
			                  </tr>
			                  <tr>
			                     <th><label>이름</label></th>
			                     <td><input name="name"  value=""/></td>
			                  </tr>
			                  <tr>
			                     <th><label>필명</label></th>
			                     <td><input name="nicname" /></td>
			                  </tr>
			                  <tr>
			                     <th><label>성별</label></th>
			                     <td>
			                        <select name="gender">
			                           <option>선택</option>
			                           <option>남성</option>
			                           <option>여성</option>
			                        </select>
			                     </td>
			                  </tr>
			                  <tr>
			                     <th><label>생년월일</label></th>
			                     <td>
			                        <input name="birthday" />년<input name="birthday" />월<input name="birthday" />일
			                        <input type="radio" name="is-lunar" value="no" />양력
			                        <input type="radio" name="is-lunar" value="yes" />음력
			                     </td>
			                  </tr>
			                  <tr>
			                     <th><label>핸드폰번호</label></th>
			                     <td><input name="phone" /></td>
			                  </tr>
			                  <tr>
			                     <th><label>이메일</label></th>
			                     <td><input name="email" /></td>
			                  </tr>
			                  <tr>                     
			                     <td><input type="submit" name="btn" value="확인" /></td>
			                  </tr>
			               </tbody>
			            </table>
			         </fieldset>
      			</form>
				
				
				<!-- <form>
					<table>
						<tr>
							<td>아이디: </td>
							<td>
								<input type="text" />
								<a target="_blank" href="check-id">중복확인</a>
							</td>
						</tr>
						
						<tr>
							<td>비밀번호</td>
							<td><input type="text" /></td>
						</tr>
							<td>비밀번호 확인</td>
							<td><input type="text" /></td>
					</table>
				</form> -->
				
							
			</main>
		</div>
	</div>
	
	<!-- footer 부분 -->
	<jsp:include page="../inc/footer.jsp"></jsp:include>
	
join페이지
</body>
</html>