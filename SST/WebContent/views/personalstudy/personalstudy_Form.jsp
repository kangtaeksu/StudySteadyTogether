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
</head>
<script type="text/javascript">
	var timId;
	var running = false;
	//를 걸어주어 상태를 만들어 준뒤
	function show() {
		var now = new Date();
		var hour = now.setHours(now.getHours());
		var minute = now.setMinutes(now.getMinutes());
		var seconds = now.setSeconds(now.getSeconds());
		var millionseconds = now.setMilliseconds(now.getMilliseconds());
		
		var mTimeHour = now.getHours();
		var mTimeMinutes = now.getMinutes ();
		var mTimeSeconds = now.getSeconds();
		var mTimeMilliseconds = now.getMilliseconds();
		
		
		var stTime = new Date();
		var stHour = stTime.getHours();
		var stMinute = stTime.getMinutes();
		var stSecond = stTime.getSeconds();
		var stMillisecond = stTime.getMilliseconds();
		var timeValue = (stHour-mTimeHour) + '시' + (stMinute-mTimeMinutes) + '분' 
		+ (stSecond-mTimeSeconds) + '초'+(stMillisecond-mTimeMilliseconds);

		document.fmt.display.value = timeValue;
		//브라우저객체 에서 바디의 이름fmt 를찾고 그 아래서
		//display이름을 찾고 거기의 value값을 timeValue 으로한다.
		/* setTimeout("show()",100); */
		//1초마다 출력하는 함수이다. 즉 이게 없다면 시작을 누를때 출력이된다.
		timId = setTimeout("show()",1000);
		//변수를 하나 생성해서 넣어줘어야 멈춤이 가능하다.
		
		
	}

	function startClock() {
		if(running){
			return;
		}//러닝이라면 startclock를 다시 실행하지않고 돌려준다.
		show();
		running = true;
		// if문으로running상태를 주어준다.
	}

	function stopClock() {
		if(running){
			clearTimeout(timId);
			running = false;
			//러닝상태면 종료를 실행하고 running을 false로 돌려준다.
		}
		
		// setTimeout 과 clearTimeout은 쌍으로써줘야한다.
		//그런데 시작을 여러번 누르고 종료를 누르면 그만큼 종료를 안누르면안멈춘다.
		//그이유는show가 여러번 생성되어 러닝 되기 때문이다.
		
	}
</script>
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
                        <h1 class="h3 mb-0 text-gray-800">페이지헤더</h1>
                    </div>
                    <!-- Content Row -->
                    <div class="row">
                    	<div class="col-md-1">
                        	과목분류
                    	</div>
                        <div class="col-md-11">
                        	<textarea rows="1" cols="15" name="ps_category"></textarea>
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col-md-1">
                        	과목명
                    	</div>
                        <div class="col-md-11">
                        	<textarea rows="1" cols="15" name="ps_subjectname"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
							<form name="fmt">

								<input type="text" name="display"><br> 
								<input type="button" name="start" value="시작" onclick="startClock()">
								<input type="button" name="ps_studytime" value="종료" onclick="stopClock()"><br>
							</form>
                       </div>
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