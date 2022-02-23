<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" name="booknumber" value="${dto.booknumber}">
		BookName <input type="text" name="bookname" value="${dto.bookname}">
		BookContents <textarea name ="bookcontents" rows="10" cols="">${dto.bookcontents}</textarea>
		BookRate <input type="text" name="bookrate" value="${dto.bookrate }">
	
		BookSale 
		<div>
			판매<input type="radio" name="booksale" value="1">
			판매중지<input type="radio" name="booksale" value="0">
		</div>
		
		<div>
			CheckBox
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
		</div>
		
		<input type="submit" value="ADD">
	</form>
</body>
</html>