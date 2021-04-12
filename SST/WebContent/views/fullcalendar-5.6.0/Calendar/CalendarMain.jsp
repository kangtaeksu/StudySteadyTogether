<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.sst.domain.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"  %>
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
<%List<Todo> toDoList = (List<Todo>)request.getAttribute("toDoList");%>


  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
    	

      headerToolbar: {
    	height: '10%',
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      initialDate: '2020-09-12',
      navLinks: true, // can click day/week names to navigate views
      //이거 false로 처리하고 fc-daygrid-day-number 여기에 이벤트 처리 하고싶음.
      //overlap: true이면 스케쥴 이동이 가능하다, false면 스케쥴이동이불가하다.
      //시간 미 입력시 all-day이벤트로 된다.
      businessHours: true, // display business hours
      editable: true,
      selectable: true,
      locale : 'ko',
      dayMaxEvents: true,
      events: [
    	  
<%--      	<% for(int i = 0;i<toDoList.size();i++ ){%>
    	 {
             title: '<%=toDoList.get(i).getT_title()%>',
             <%Date sdate = toDoList.get(i).getT_startdate();

				SimpleDateFormat sttransFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String stdate = sttransFormat.format(sdate);%>
				 start: '<%=stdate%>',
             <%Date edate = toDoList.get(i).getT_enddate();

				SimpleDateFormat entransFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String endate = entransFormat.format(edate);%>
             end : '<%=endate%>',
             constraint: 'availableForMeeting', // defined below
             color: '#257e4a'
           },
    	<%}%> --%>
        
         {
          title: 'Meeting',
          start: '2020-09-13T00:00:00',
          constraint: 'availableForMeeting', // defined below
          color: '#257e4a'
        },
        {
          title: 'Conference',
          start: '2020-09-03',
          end: null
        },
        {
        	//매주 지정 요일 반복 1 => 월요일
          title: 'repeating event 1',
          start: '2020-09-03',
          end : '2020-09-20'
          
        },
        {
          title: 'Party',
          start: '2020-09-03T20:00:00'
        },

        
        // areas where "Meeting" must be dropped
        {
          groupId: 'availableForMeeting',
          start: '2020-09-03T10:00:00',
          end: '2020-09-11T16:00:00',
          display: 'background'
        },
        {
          groupId: 'availableForMeeting',
          start: '2020-09-03T10:00:00',
          end: '2020-09-13T16:00:00',
          display: 'background'
        },

        // red areas where no events can be dropped
        {
          start: '2020-09-24',
          end: '2020-09-28',
          overlap: false,
          display: 'background',
          color: '#ff9f89'
        },
        {
          start: '2020-09-06',
          end: '2020-09-08',
          overlap: false,
          display: 'background',
          color: '#ff9f89'
        },
        {
            title: 'Movie Night – “Greater”',
            start: '2020-09-01',
            end: '2020-09-15',
            color: '#4776fd',
          },
        {
            title: 'Lets see if this works',
            start: '2020-09-01T13:00:00',
            end: '2020-09-25T14:00:00',
            daysOfWeek: [ 1, 2 ],
              
            url: 'http://www.naver.com',
            color: '#7dc5d7',
            catid: '99',
            cat: 'all-events',
          }, 
           
      ]
    });

    calendar.render();
  });

</script>
<style>

/*   body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  } */

  #calendar {
    max-width: 600px;
    margin: 0 auto;
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
                        <h1 class="h3 mb-0 text-gray-800">페이지헤더</h1>
                    </div>
                    <!-- Content Row -->
                    <div class="row">

                        <h1>활용면적</h1>
                          <div id='calendar'></div>
  							<button><a href = "/PrivateSteudy/fullcalendar-5.6.0/Calendar2/insertTodoForm.do">Todo작성</a></button>
					<div id='calendar'></div>
                    <button><a href = "/PrivateSteudy/fullcalendar-5.6.0/Calendar2/insertTodoForm.do">Todo작성</a></button> 
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