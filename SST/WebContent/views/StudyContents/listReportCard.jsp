<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
		<%@include file="../../template/sidemenu.jsp"%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- topbar -->
				<%@include file="../../template/topbar.jsp"%>
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">페이지헤더</h1>
					</div>
					<!-- Content Row -->
					<div class="row">
						<c:forEach items="${rclist}" var="rc">
							<div class="col-xl-12 mb-4">
								<div class="card border-left-info shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div
													class="h7 font-weight-bold text-info text-uppercase mb-1">
													
													${rc.rc_type} / ${rc.rc_subtype}</div>
												<div class="h3 mb-0 font-weight-bold text-gray-800">${rc.rc_title}</div>
											</div>
											<div class="col-auto">
												<button type="button" class="btn btn-info"
													onclick="location.href='/SST/ReportCard/detailReportCardAction.do?rc_num=${rc.rc_num}&rc_type=${rc.rc_type}'">조회</button>
											<button type="button" class="btn btn-danger"
													onclick="location.href='/SST/ReportCard/deleteReportCardAction.do?rc_num=${rc.rc_num}&rc_type=${rc.rc_type}'">삭제</button>
											</div>
										</div>
										
									</div>
									
								</div>
							</div>
						</c:forEach>
						<div>
						<a class="btn btn-success btn-circle" href="/SST/ReportCard/insertReportCardForm.do">
                                        <i class="fas fa-plus"></i>
                                    </a>
						</div>
						
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../../template/footer.jsp"%>
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