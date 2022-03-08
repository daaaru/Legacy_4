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
	<h1>${board}Detail page</h1>
	<h3>Title : ${dto.title}</h3>
	<h3>Writer : ${dto.writer}</h3>
	<h3>Contents : ${dto.contents }</h3>

	
	<a href="./list">List</a>
	<a href="./delete?num=${dto.num }">DELETE</a>
	<a href="./update?num=${dto.num }">UPDATE</a>
	<a href="./reply?num=${dto.num }">Reply</a>
</body>
</html>