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
			<th>상품번호</th><th>상품명</th><th>이자율</th><th>판매</th>
		</tr>
		
		<c:forEach items="${list}" var="book">
		<tr>
			<td>${book.booknumber}</td>
			<td><a href="./detail?booknumber=${book.booknumber}">${book.bookname}</a></td>
			<td>${book.bookrate}</td>
			<td>${book.booksale}</td>
			
		</tr>
		
		</c:forEach>
	
	
	
	</table>
	
	<div>
		<c:if test="${pager.pre }">
			<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum }" step="1" var="i">
		<a href="./list?page=${i }">${i }</a>
		</c:forEach>
		
		<c:if test="${pager.next }">
			<a href="./list?page=${pager.lastNum+1}">NEXT</a>
		</c:if>
		
	</div>
	
	
	<a href="./add">ADD</a>
	
</body>
</html>