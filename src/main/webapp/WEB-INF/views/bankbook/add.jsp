<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Add Page</h1>
	
	<form action="./add" method="POST">
		BookName <input type="text" name="bookname">
		BookContents <textarea name ="bookcontents" rows="10" cols="10"></textarea>
		BookRate <input type="text" name="bookrate">
	
		BookSale 
		<div>
			판매<input type="radio" name="booksale" value="1"> 판매중지<input type="radio" name="booksale" value="0">
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