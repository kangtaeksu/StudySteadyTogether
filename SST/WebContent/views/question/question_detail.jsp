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
<link href="../css/studynote.css" rel="stylesheet">

<link>
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
						<h1 class="h3 mb-0 text-gray-800"></h1>
					</div>

					<!-- Content Row -->


					<div class="row">


						<div class="noteView">
							<div class="noteHeader">
								<h2>${question.q_title}</h2>
								<hr>
								작성일 :${question.q_date}
							</div>






							<%-- 글번호 :${studynote.sn_num }<br>  --%>

							<div class="noteContents">${question.q_contents}</div>

							<div class="noteFooter">
								<a class="btn btn-light btn-icon-split noteFooterBtn"
									href="Question_ListAction.do"> <span
									class="icon text-gray-600"><i class="fas fa-arrow-right"></i></span><span
									class="text">문제 목록</span>
								</a> <a class="btn btn-primary btn-icon-split noteFooterBtn"
									href="Question_UpdateFormAction.do?q_num=${question.q_num}">
									<span class="icon text-white-50"><i class="fas fa-check"></i></span><span
									class="text">문제 수정하기</span>
								</a> <a class="btn btn-danger btn-icon-split noteFooterBtn"
									href="Question_DeleteAction.do?q_num=${question.q_num }"> <span
									class="icon text-white-50"><i class="fas fa-trash"></i></span><span
									class="text">문제 삭제</span>
								</a>
							</div>



						</div>
					</div>
					<!-- 
							여기부터 댓글 입력
							 -->
					<div>
						<h3>댓글 목록</h3>
						<table border="1">
							<tr>
								<td>댓글번호</td>
								<td>댓글내용</td>
								<td>댓글날짜</td>
								<td>문제번호</td>
								<td>그룹원아이디</td>
							</tr>
							<c:forEach var="reply" items="${questionreplyvo}">
								<tr>
									<td>${questionreplyvo.c_num }</td>
									<td>${questionreplyvo.c_contents }</td>
									<td>${questionreplyvo.c_date }</td>
									<td>${questionreplyvo.q_num }</td>
									<td>${questionreplyvo.gm_num }</td>
									<td>${questionreplyvo.g_num }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<br>

					<form action="Question_InsertReplyAction.do" method="post">
						<input type="hidden" name="q_num" value="${question.q_num }">

						댓글작성자: <input type="text" name="gm_num"><br> 댓글내용: <input
							type="text" name="c_contents"><br> <input
							type="submit" value="댓글쓰기">
					</form>
					<br>

					<!-- 여기서 댓글이 보여짐  -->
					<div class="noteView">
						<div class="noteHeader">${questionreplyvo.gm_num}님 :
						
							<tr>
									<td>${questionreplyvo.c_num }</td>
									<td>${questionreplyvo.c_contents }</td>
									<td>${questionreplyvo.c_date }</td>
									<td>${questionreplyvo.q_num }</td>
									<td>${questionreplyvo.gm_num }</td>
									<td>${questionreplyvo.g_num }</td>
								</tr>
							</div>



						<!-- end of row  여기서 댓글 추천기능 로그인해야만 된다 -->

			

<script>
	$(function(){
		// 추천버튼 클릭시(추천 추가 또는 추천 제거)
		$("#rec_update").click(function(){
			$.ajax({
				url: "/expro/RecUpdate.do",
                type: "POST",
                data: {
                    no: ${content.board_no},
                    id: '${id}'
                },
                success: function () {
			        recCount();
                },
			})
		})
		
		// 게시글 추천수
	    function recCount() {
			$.ajax({
				url: "/expro/RecCount.do",
                type: "POST",
                data: {
                    no: ${content.board_no}
                },
                success: function (count) {
                	$(".rec_count").html(count);
                },
			})
	    };
	    recCount(); // 처음 시작했을 때 실행되도록 해당 함수 호출
	    </script>
	    <div>
		<div class="w3-border w3-center w3-padding">
			<c:if test="${ gm_num == null }">
				추천 기능은 <button type="button" id="newLogin"><b class="w3-text-blue">로그인</b></button> 후 사용 가능합니다.<br />
				<i class="fa fa-heart" style="font-size:16px;color:red"></i>
				<span class="rec_count"></span>					
			</c:if>
			<c:if test="${ gm_num != null }">
				<button class="w3-button w3-black w3-round" id="rec_update">
					<i class="fa fa-heart" style="font-size:16px;color:red"></i>
					&nbsp;<span class="rec_count"></span>
				</button> 
			</c:if>
		</div>
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












