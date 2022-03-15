<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./template/header_css.jsp"></c:import>


</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<div>
		<img alt="" src="./resources/images/hey.jpeg">
	</div>
	
	<h1>Index Page</h1>
	
	<h3>${member.name}님 환영합니다 
	<span class="material-icons-outlined">login</span>
	</h3>
	
	<div>
		<c:if test="${not empty member}">
			<a class="my" href="./member/mypage">MyPage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	
	</div>
	
	<img alt="" src="./resources/upload/member/1b4a076c-ddb5-4cba-a184-057217e1cd6f_1590377048793.jpeg">
	
</body>
</html>