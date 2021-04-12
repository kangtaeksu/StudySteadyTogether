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
<title>노트 필기</title>
<!-- Custom fonts for this template-->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../css/sb-admin-2.min.css" rel="stylesheet">
<link href="../css/studynote_input.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		
		document.execCommand('styleWithCSS', false, true);
		document.execCommand('insertBrOnReturn', false, true);
		
		$("#fontSize").change(function(){
		    document.execCommand('fontSize', false, $(this).val());
		 });
	}
	
	$(function(){
		$("#submit").click(function(){
			
			sendRegData();
			
		});
	});
	
	function sendRegData(){
		$.ajax({
			type: "POST",
			url: "/SST/StudyNote/StudyNote_InsertAction.do",
			data: {sn_contents:$(".input_contents").html(),sn_title:$(".input_title").val()},
			async:"true",
			success: function(){
				console.log("asdfawef");
			}
		});
	}

</script>


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
						
					</div>
					<!-- Content Row -->
					<div class="row">

						<div class="studyNoteFormWrap">
						<form action="StudyNote_InsertAction.do" method="post">

							<!-- 작성자 : <input type="text" name="gm_num"> --><br> 
							<!-- <input class="input_title" type="text" placeholder="제목을 입력하세요" name="sn_title"> -->
							<div class="input_title_wrap">
								<textarea class="input_title" placeholder="제목을 입력하세요" name="sn_title"></textarea>
							</div>
							
							<div class="input_tools_wrap">
							
								<a class="btn btn-light btn-icon-split btn-sm">
								<span class="icon text-white-100">
                                       <i class="fas fa-bold"></i>
                           		</span>							
								</a>
								
								<a class="btn btn-light btn-icon-split btn-sm">
								<span class="icon text-white-100">
                                       <i class="fas fa-italic"></i>
                           		</span>							
								</a>
								
								<a class="btn btn-light btn-icon-split btn-sm">
								<span class="icon text-white-100">
                                       <i class="fas fa-underline"></i>
                           		</span>							
								</a>
								
								<a class="btn btn-light btn-icon-split btn-sm">
								<span class="icon text-white-100">
                                       <i class="fas fa-align-left"></i>
                           		</span>							
								</a>
								
								<a class="btn btn-light btn-icon-split btn-sm">
								<span class="icon text-white-100">
                                       <i class="fas fa-align-center"></i>
                           		</span>							
								</a>
								
								<a class="btn btn-light btn-icon-split btn-sm">
								<span class="icon text-white-100">
                                       <i class="fas fa-align-right"></i>
                           		</span>							
								</a>
								
								<input type="button" class="BOLD" value="B"
									onclick="document.execCommand('bold')" /> 
									<input type="button"
									class="ITALIC" value="Italic"
									onclick="document.execCommand('Italic')" /> 
									<input type="button"
									class="UNDERBAR" value="underline"
									onclick="document.execCommand('Underline')" />
								<button type="button" class="aignLeft"
									onclick="document.execCommand('justifyleft')">
									<i class="fas fa-align-left"></i>
								</button>
								<button type="button" class="aignCenter"
									onclick="document.execCommand('justifycenter')">
									<i class="fas fa-align-center"></i>
								</button>
								<button type="button" class="aignRight" value="오른쪽 정렬"
									onclick="document.execCommand('justifyright')">
									<i class="fas fa-align-right"></i>
								</button>
								<select id="fontSize">
									<option value="">글자 크기</option>
									<option value="3">10px</option>
									<option value="4">12px</option>
									<option value="5">16px</option>
									<option value="6">20px</option>
									<option value="7">30px</option>
								</select>

							</div>
							<!-- end of tool Wrap -->
							
							<div class="input_contents_wrap">
								<div class="input_contents" name="sn_contents" contenteditable="true"></div>
							</div>
							
							<div class="formBtnWrap">
							
								<a id="submit" href="/SST/StudyNote/StudyNote_ListAction.do" 
									class="btn btn-primary btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-flag"></i>
                                    </span>
                                    <span class="text">제출</span>
                                </a>
							</div>
									
						</form>
						</div>
						<!-- end of studyNoteFormWrap -->
						
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