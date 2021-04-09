<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SST</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="memberInsert.do" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pw"><br>
		이름 : <input type="text" name="name"><br>
		번호 : <input type="text" name="phone"><br>
		생년월일 : <input type="text" name="birth"><br>
		이메일 : <input type="text" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>