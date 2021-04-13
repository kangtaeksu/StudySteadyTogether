<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Todo항목추가</h3>
<form action="insertTodo.do" method="post">
	do : <input type="text" name="t_title"><br>
	종류 : <input type="text" name="t_category"><br>
	내용 <br>
	<textarea rows="6" cols="70" name="t_contents"></textarea>
	<br>
	시작날짜 : <input type = "text" name = "t_startdate"><br>
	마감날짜 : <input type = "text" name = "t_enddate"><br>
	
	<input type="submit" value="등록">
</form>
</body>
</html>