<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sst.domain.CalendarTodoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html lang="en">
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <meta charset="utf-8">
<link href='../../views/fullcalendar-5.6.0/lib/main.css' rel='stylesheet' />
<script src='../../views/fullcalendar-5.6.0/lib/main.js'></script>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SST</title>
    <!-- Custom fonts for this template-->
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../../css/sb-admin-2.min.css" rel="stylesheet">
<script>
    functionGetdays(){
        var obj = $("[name=day]");
        var chkArray = new Array(); // 배열 선언
 
        $('input:checkbox[name=day]:checked').each(function() { // 체크된 체크박스의 value 값을 가지고 온다.
            chkArray.push(this.value);
        });
        $('#hiddenValue').val(chkArray);
        
        alert($('#hiddenValue').val()); // 아래 체크박스가 모두 체크되어 있다면 1,2,3,4 가 출력 된다.
        
    }
 
</script>
<style>
.insertTodoButton{
	background-color: #2c3e50;
	border-radius: 3px;
	color : white;
}
.inputTodoText,.repeatDay{
 float: left;
color : #1a252f;
font-size:  15px;
font-weight: bold;
}
.inputTodoText_content,.repeatDayCheck{
color : #1a252f;
font-size:  15px;
font-weight: bold;
}
</style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- sidemenu -->
        <%@include file="../../../../template/sidemenu.jsp" %>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- topbar -->
				<%@include file="../../../../template/topbar.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Group Schedule 등록</h1>
                    </div>
                    <!-- Content Row -->
                    <div class="row">
							<!--<h3>Todo항목추가</h3>  -->
							</div>
							<form action="" method="post">
								<div class = "inputTodoText">제목 : </div><input type="text" name="t_title"><br>
								<div class = "inputTodoText">종류 : </div><input type="text" name="t_category"><br>
								<div class = "inputTodoText_content">내용 </div>
							<textarea rows="6" cols="70" name="t_contents"></textarea>
							<br>
							<div class = "inputTodoText">시작날짜 : </div><input type = "text" name = "t_startdate"><br>
							<div class = "inputTodoText">마감날짜 : </div><input type = "text" name = "t_enddate"><br>
							<div class = "repeatDay">반복 날짜</div><br>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="1">월</label>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="2">화</label>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="3">수</label>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="4">목</label>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="5">금</label>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="6">토</label>
							<label class = "repeatDayCheck"><input type="checkbox" name="day" value="7">일</label>
							<input type="hidden" name="hiddenValue" id="hiddenValue"/>
							<input type="submit" value="등록" class = 'insertTodoButton' onclick="Getdays();">
							</form>
                	</div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@include file="../../../../template/footer.jsp" %>
            <!-- End of Footer -->
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
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