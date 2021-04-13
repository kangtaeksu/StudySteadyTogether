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
                        <h1 class="h3 mb-0 text-gray-800">그룹생성</h1>
                    </div>
                    <!-- 페이지 본문 -->
                    <div class="row">
					<div class="col-lg-3"></div>
	                    <div class="col-lg-6">
	                        <div class="p-5">
	                            <div class="text-center">
	                                <h1 class="h4 text-gray-900 mb-4">그룹생성</h1>
	                            </div>
	                            <form action="groupAdd.do" class="user">
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	그룹명
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="groupname" type="text" class="form-control rounded-pill" id="exampleLastName"
	                                            placeholder="그룹명을 입력하세요">
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	카테고리
	                                    </div>
	                                    <div class="col-sm-9">
	                                    	<select name="category" class="form-control rounded-pill" 
	                                    	placeholder="카테고리를 선택하세요">
	                                    		<option selected>선택</option>
	                                    		<option value="highschool">고등학생</option>
	                                    		<option value="college">대학생</option>
	                                    		<option value="employement">취업</option>
	                                    		<option value="language">어학</option>
	                                    		<option value="etc">기타</option>
	                                    	</select>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	스터디 설명
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <textarea name="groupcontent" class="form-control rounded" id="exampleLastName"
	                                            placeholder="스터디 설명을 입력하세요"></textarea>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	모집인원
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="groupnum" type="text" class="form-control rounded-pill" id="exampleLastName"
	                                            placeholder="모집인원을 입력하세요"></textarea>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	공개여부
	                                    </div>
	                                    <div class="col-sm-9 row">
	                                        <div class="col-sm-6 form-check text-center">
											  <input class="form-check-input groupsecrets" type="radio" name="groupsecret" id="exampleRadios1" value="open">
											  <label class="form-check-label" for="exampleRadios1">
											    	공개
											  </label>
											</div>
											<div class="col-sm-6 form-check text-center">
											  <input class="form-check-input groupsecrets" type="radio" name="groupsecret" id="exampleRadios2" value="secret">
											  <label class="form-check-label" for="exampleRadios2">
											    	비공개
											  </label>
											</div>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-3 pl-3 mb-3 mb-sm-0 text-center align-self-center">
	                                        	비밀번호
	                                    </div>
	                                    <div class="col-sm-9">
	                                        <input name="grouppw" type="text" class="form-control rounded-pill" id="inputgrouppw"
	                                            placeholder="그룹 비밀번호를 입력하세요"></textarea>
	                                    </div>
	                                </div>
	                                <input type="submit" class="btn btn-primary btn-user btn-block" value="그룹생성">
	                                <hr>
	                            </form>
	                            <hr>
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