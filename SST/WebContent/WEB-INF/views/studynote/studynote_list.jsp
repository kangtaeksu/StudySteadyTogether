<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SST</title>
<!-- Custom fonts for this template-->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- sidemenu -->
		<%@include file="/template/sidemenu.jsp"%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- topbar -->
				<%@include file="/template/topbar.jsp"%>
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">노트 목록</h1>
					</div>
					
					<!-- Content Row -->
					<div class="row">
					<a href="StudyNote_InsertFormAction.do">글쓰기</a>
					
					</div>
					<!-- end of row -->
					
					<div class="row">

						
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
									<td>${studynote.sn_num }</td>
									<td><a
										href="StudyNote_DetailAction.do?sn_num=${studynote.sn_num }">${studynote.sn_title }</a></td>
									<td>${studynote.gm_num }</td>
									<td><fmt:parseDate var="dt" value="${studynote.sn_date }"
											pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
											value="${dt }" pattern="yyyy/MM/dd" /></td>
								</tr>
							</c:forEach>
						</table>
						

						<!-- 페이징 영역 -->
						<!-- 이전 영역 -->
						<%-- 	<c:if test="${StudyNoteListVO.startPage > 5 }">
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
	</c:if> --%>

					


					</div>
					<!-- end of row -->
					
					
					<div class="row">
					
						<form action="StudyNote_ListAction.do" method="post">
							<input type="checkbox" name="area" value="title">제목 <input
								type="checkbox" name="area" value="writer">ID <input
								type="text" name="searchKey" size="10"> <input
								type="submit" value="검색">
						</form>
					
					</div>
					<!-- end of row -->
					
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="/template/footer.jsp"%>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="../js/sb-admin-2.min.js"></script>


</body>
</html>












