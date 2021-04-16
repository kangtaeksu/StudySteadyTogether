<%@page import="org.sst.domain.MemberSessionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SST</title>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    
    <script type="text/javascript" src="../radioajax0412.js"></script>
    <!-- Custom fonts for this template-->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
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
        <%@include file="../../template/sidemenu.jsp" %>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- topbar -->
				<%@include file="../../template/topbar.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- 페이지 헤더 -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">회원정보 수정</h1>
                    </div>
                    <!-- 페이지 본문 -->
                    <div class="row">
					<div class="col-lg-3"></div>
	                    <div class="col-lg-6">
	                        <div class="p-5">
	                            <div class="text-center">
	                                <h1 class="h4 text-gray-900 mb-4">회원정보 수정</h1>
	                            </div>
	                            <form action="/SST/member/updateinfo.do" method="post" class="user">
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	회원 ID
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="memid" type="text" class="form-control rounded-pill" id="exampleLastName"
	                                            value=${meminfo.m_id } disabled>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	회원 이름
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="memname" type="text" class="form-control rounded-pill" id="exampleLastName"
	                                        value=${meminfo.m_name } >
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center"
	                                    >
	                                        	핸드폰 번호
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input value=${meminfo.m_phone } name="memphone" type="text" class="form-control rounded-pill" id="exampleLastName">
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	생년월일
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="membirth" type="text" class="form-control rounded-pill" id="exampleLastName"
	                                        value=${meminfo.m_birth }>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	이메일
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="mememail" type="text" class="form-control rounded-pill" id="exampleLastName"
	                                        value=${meminfo.m_email }>
	                                    </div>
	                                </div>
	                                <input type="submit" class="btn btn-primary btn-user btn-block" value="회원정보수정">
	                                <hr>
	                            </form>
	                            
	                        </div>
	                    </div>
                    <div class="col-lg-3"></div>
					<br> 
                    </div>
                </div>

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@include file="../../template/footer.jsp" %>
            <!-- End of Footer -->
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="../js/sb-admin-2.min.js"></script>
</body>
</html>