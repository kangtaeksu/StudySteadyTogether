<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<hr>
<form action="StudyNote_InsertAction.do" method="post">
		
	노트번호 : <input type="text" name="sn_num"><br>
	작성자 : <input type="text" name="gm_num"><br>
	제목 : <input type="text" name="sn_title"><br>	
	내용 <br>
	<textarea rows="10" cols="300" name="sn_contents"></textarea>

	<br>
	<input type="submit" value="제출">
</form>

</body>
</html>








