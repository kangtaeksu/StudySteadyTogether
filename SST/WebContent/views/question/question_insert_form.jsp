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
<title>문제 공유</title>
<!-- Custom fonts for this template-->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../css/sb-admin-2.min.css" rel="stylesheet">
<link href="../css/question.css" rel="stylesheet">
<link href="../css/studynote.css" rel="stylesheet">
<link href="../css/studynote_input.css" rel="stylesheet">
<script type="text/javascript">
	window.onload = function(){
		document.execCommand('styleWithCSS', false, true);
		document.execCommand('insertBrOnReturn', false, true);
	}
	
	$(function(){
		$("#submit").click(function(){
			sendRegData();
		});
		
	    $('select').change(function(){
	        document.execCommand($(this).attr('id'), false, $(this).val());
	      });
	    $('.button').click(function(){
	        document.execCommand($(this).attr('id'), false, true);
	      });
	});
	
	function sendRegData(){
		$.ajax({
			type: "POST",
			url: "/SST/Question/Question_InsertAction.do",
			data: {q_contents:$(".input_contents").html(),q_title:$(".input_title").val()},
			async:"true",
			success: function(){
				console.log("asdfawef");
			}
		});
	}


<!-- 이미지첨부 스크립트 -->

 <script type="text/javascript">
var fileList = []; //파일 정보를 담아 둘 배열
$(function(){

    //드래그앤드랍
    $("#fileDrop").on("dragenter", function(e){
        e.preventDefault();
        e.stopPropagation();
    }).on("dragover", function(e){
        e.preventDefault();
        e.stopPropagation();
        $(this).css("background-color", "#FFD8D8");
    }).on("dragleave", function(e){
        e.preventDefault();
        e.stopPropagation();
        $(this).css("background-color", "#FFF");
    }).on("drop", function(e){
        e.preventDefault();

        var files = e.originalEvent.dataTransfer.files;
        if(files != null && files != undefined){
            var tag = "";
            for(i=0; i<files.length; i++){
                var f = files[i];
                fileList.push(f);
                var fileName = f.name;
                var fileSize = f.size / 1024 / 1024;
                fileSize = fileSize < 1 ? fileSize.toFixed(3) : fileSize.toFixed(1);
                tag += 
                        "<div class='fileList'>" +
                            "<span class='fileName'>"+fileName+"</span>" +
                            "<span class='fileSize'>"+fileSize+" MB</span>" +
                            "<span class='clear'></span>" +
                        "</div>";
            }
            $(this).append(tag);
        }

        $(this).css("background-color", "#FFF");
    });

    //저장
    $(document).on("click", "#save", function(){
        var formData = new FormData($("#fileForm")[0]);
        if(fileList.length > 0){
            fileList.forEach(function(f){
                formData.append("fileList", f);
            });
        }         

        $.ajax({
            url : "서버 맵핑 URL",
            data : formData,
            type:'POST',
            enctype:'multipart/form-data',
            processData:false,
            contentType:false,
            dataType:'json',
            cache:false,
            success:function(res){
                alert("저장에 성공하셨습니다.");
            },error:function(res){
                alert("오류 발생.\n관리자에게 문의해주세요.");
            }
        });
    });
});

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
						<h1 class="h3 mb-0 text-gray-800">문제등록</h1>
					</div>
					<!-- Content Row -->
					<div class="row">

						
						<form action="Question_InsertAction.do" method="post">
	
							작성자 : <input type="text" name="gm_num" ><br>
							 	<div class="q_insert">
							 제목 : <input type="text" name="q_title"><br></div>
						<!-- 	 이미지 첨부: <input type = "file" name = "uploadFile" class="boxTF" size="74"/> -->
							 <!-- <input type = "button" value="파일등록" onclick ="sendlt()"/> -->
							 <br><br>
							 내용 <br><input type="text" name="q_contents">
							<div class="input_contents_w-rap">
								<div class="input_contents" contenteditable="true"></div>
							</div><br>
							답 : <input type="text" name="q_answer">
							
							
							<div class="formBtnWrap">
							
								<a id="submit" href="/SST/Question/Question_ListAction.do" 
									class="btn btn-primary btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-check"></i>
                                    </span>
                                    <span class="text">제출</span>
							</a>
						</div>
							<input type="submit" value="제출">
						</form>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="/template/footer.jsp"%>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->


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