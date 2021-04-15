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
<link href="../css/question.css" rel="stylesheet">
<link href="../css/studynote.css" rel="stylesheet">
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
						<h1 class="h3 mb-0 text-gray-800">문제 목록</h1>
					</div>

					<!-- Content Row -->
					<div class="row headerLine"></div>
					<!-- end of row -->

					<div class="row">

						<div class="noteListArea">


							<div class="noteTableArea">
								<table class="noteTable">
									<tr>
										<td class="sn_num thead">문제번호</td>
										<td class="sn_title thead">문제명</td>
		
										<td class="sn_date thead">작성일자</td>
									</tr>
									<tr><td></td><td></td><td></td><td></td></tr>
									<c:forEach var="question" items="${QuestionListVO.list}">
										<tr class="q_row">
											<td class="sn_num">${question.q_num }</td>
											<td class="sn_title"><a class="noHyper" href="Question_DetailAction.do?q_num=${question.q_num }"> ${question.q_title }</a></td>
											<td class="sn_num">${question.gm_num }</td>
<%-- 											<td class="q_date"><fmt:parseDate var="dt"
													value="${question.q_date}" pattern="yyyy-MM-dd HH:mm:ss" />s
												<fmt:formatDate value="${dt}" pattern="yyyy/MM/dd" /></td> --%>
										</tr>
									</c:forEach>
								</table>
								<input type="hidden" name="q_answer" value="${question.q_answer }">
							</div>
							
							
						</div>







					</div>
					<!-- end of row -->


				<div class="row">
						<div class="noteListFooterArea">

							<form
								action="StudyNote_ListAction.do" method="post">
								<input type="checkbox" name="area" value="sn_title">제목 
								<input type="checkbox" name="area" value="sn_contents">내용
								<input type="text" class="" name="searchKey" placeholder="검색어를 입력해주세요" size="20"> 
								<input type="submit" class="btn-primary" value="검색">


								<a class="btn btn-secondary btn-icon-split rightBtn"
									href="StudyNote_InsertFormAction.do"> 
								<span class="icon text-white-50"> 
									<i class="fas fa-pen"></i>
								</span> <span class="text">글쓰기</span>
								</a>
							</form>
							<a href="http://192.168.0.189:3000">채팅 참가</a>
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












