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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<h1>Notice List page</h1>
	
	<table>
		<tr>
		<th>제목</th><th>내용</th><th>작성자</th><th>작성일자</th><th>조회수</th>
		</tr>
	<c:forEach items="${list}" var="notice">
	<tr>
	
	
		
		<td><a href="./detail?num=${notice.num}">${notice.title}</a></td>
		<td>${notice.contents}</td>
		<td>${notice.writer}</td>
		<td><fmt:formatDate value="${notice.regDate}" pattern="yy-MM-dd"/> </td>
		<td>${notice.hit}</td>

	
	</tr>

	</c:forEach>
	
	
	</table>
	
	<div>
		<!--  이전블럭으로 가는거 -->
		<c:if test="${pager.pre }">
			<a href="./list?page=${pager.startNum-1 }">PREVIEW</a>
		</c:if>
	
		<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
			<a href="./list?page=${i }">${i }</a>
		</c:forEach>
		
		<!--  다음블럭으로 가는거  -->
		<c:if test="${pager.next }">
			<a href="./list?page=${pager.lastNum+1 }">NEXT</a>
		</c:if>
		
	</div>
	
	<a href="./add">ADD</a>
	
</body>
</html>