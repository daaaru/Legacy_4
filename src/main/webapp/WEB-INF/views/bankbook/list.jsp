<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>BankBook List Page</h1>
	
	<!-- bookname, bookrate, booksale -->

	<table>
		<tr>
			<th>상품명</th><th>이자율</th><th>판매</th>
		</tr>
		
		<c:forEach items="${list}" var="book">
		<tr>
			<td><a href="./detail?booknumber=${book.booknumber}">${book.bookname}</a></td>
			<td>${book.bookrate}</td>
			<td>${book.booksale}</td>
			
		</tr>
		
		</c:forEach>
	
	
	
	</table>
	
	<a href="./add">ADD</a>
	
</body>
</html>