<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Add page</h1>

	<form action="./add" method ="post">
	
		Title <input type="text" name="title">
		Contents <textarea name="contents" rows="10" cols="10"></textarea>
		Writer <input type="text" name="writer">
		RegDate <input type="date" name="regDate">
		Hit <input type="text" name="hit">	
	</form>
	
	
</body>
</html>