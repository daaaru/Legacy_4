<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="styleSheet">
<link href="../resources/css/list.css" rel="stylesSeet">

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<div class="table-container">
	<h1>${board} List page</h1>
	
	<table class="table-basic">
		<tr>
		<th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일자</th><th>조회수</th>
		</tr>
	<c:forEach items="${list}" var="dto">
	<tr>
	
	
		<td>${dto.num }</td>
		<td>
			<a href="./detail?num=${dto.num}">
			<c:catch>
			<c:forEach begin="1" end="${dto.depth}">&nbsp;</c:forEach>
			</c:catch>
			${dto.title}</a>
		</td>
		<td>${dto.contents}</td>
		<td>${dto.writer}</td>
		<td><fmt:formatDate value="${dto.regDate}" pattern="yy-MM-dd"/> </td>
		<td>${dto.hit}</td>

	
	</tr>

	</c:forEach>
	
	
	</table>
	
	</div>
	<c:if test="${not empty member }">
	<a href="./add">ADD</a>
	</c:if>
	
</body>
</html>