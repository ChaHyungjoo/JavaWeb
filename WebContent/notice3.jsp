<%@page import="com.newlecture.javaweb.entity.Notice"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="notice" method="get">
		<label>검색어</label>
		<input type="text" name="title"/>
		<input type="submit" />
	</form>
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
			<td>${n.title}</td>
			<td>hj</td>
			<td>${n.regDate}</td>
			<td>${n.hit}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>