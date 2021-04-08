<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="StudyNote_InsertForm.do">글쓰기</a>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="studynote" items="${StudyNoteListVO.list}">
		<tr>	
			<td>${StudyNote.sn_num }</td>		
			<td><a href="StudyNote_DetailAction.do?seq=${StudyNote.sn_num }">${StudyNote.sn_title }</a></td>
			<td>${StudyNote.gm_num }</td>
			<td>
				<fmt:parseDate var="dt" value="${StudyNote.sn_date }" pattern="yyyy-MM-dd HH:mm:ss"/>
				<fmt:formatDate value="${dt }" pattern="yyyy/MM/dd"/>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	
	<!-- 페이징 영역 -->
	<!-- 이전 영역 -->
	<c:if test="${StudyNoteListVO.startPage > 5 }">
		<a href="ListAction.do?pageNum=${StudyNoteListVO.startPage -1 }">[이전]</a>
	</c:if>
	
	<!-- 페이지목록 -->
	<c:forEach var="pageNo" begin="${StudyNoteListVO.startPage }" end="${StudyNoteListVO.endPage }">
		<c:if test="${StudyNoteListVO.requestPage == pageNo }"><b></c:if>
			<a href="StudyNote_ListAction.do?pageNum=${pageNo }">[${pageNo }]</a>
		<c:if test="${StudyNoteListVO.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	
	<!-- 이후 영역 -->
	<c:if test="${StudyNoteListVO.endPage < StudyNoteListVO.totalPageCount}">
		<a href="StudyNote_ListAction.do?pageNum=${StudyNoteListVO.endPage +1 }">[이후]</a>
	</c:if>
	
	<form action="StudyNote_ListAction.do" method="post">
		<input type="checkbox" name="area" value="title">제목
		<input type="checkbox" name="area" value="writer">ID
		<input type="text" name="searchKey" size="10">
		<input type="submit" value="검색">
	</form>	
	
</body>
</html>

















