<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertTimeAction.do">
	<input type="text" name="ps_place">
	<input type="text" name="ps_category">
	<div>
		<div>
			<span id="studyhour">00</span>
			<span>:</span><span id="studymin">00</span>
			<!-- 분 -->
			<span>:</span> <span id="studysec">00</span>

			<!--초-->
			<span>.</span> <span id="studymilisec">00</span>
			<!--밀리초-->
			
		</div>
		<input type="text" name="ps_time" id = "inputTime">
		<div>
			<ul id="recordlist">
			
			</ul>
			<!--중간 기록할 리스트-->
		</div>
		<div>
			<button type="button" id="startbtn">START</button>
			<!--시작/재시작/기록 버튼-->
			<button type="button" id="stopbtn">STOP</button>
			<!--스톱 버튼-->
		</div>
	</div>
	<input type="submit" value = "공부완료" >
</form>
</body>
<script type="text/javascript">
	var stTime = 0
	var endTime = 0
	var timerStart
	var hour
	var min
	var sec
	var milisec
	var startBtn = document.getElementById('startbtn')
	var stopBtn = document.getElementById('stopbtn')
	var recordList = document.getElementById('recordlist')
	startBtn.addEventListener('click', function() {
		
		// RECORD
		if (this.innerText == 'RECORD' && milisec) {
			//console.log(hour,min, sec, milisec)
			var li = document.createElement('li')
			li.style.color = "black"
			li.innerText =hour +' : ' +min + ' : ' + sec + ' : ' + milisec
			if (!recordList.firstChild) {
				recordList.append(li)
			} else {
				recordList.insertBefore(li, recordList.firstChild)
			}
			return false
		}
		this.innerText = 'RECORD'
		if (!stTime) {
			stTime = Date.now() // 최초 START
		} else {
			stopBtn.innerText = 'STOP'
			stTime += (Date.now() - endTime) // RESTART
		}
		timerStart = setInterval(function() {
			var nowTime = new Date(Date.now() - stTime)
			
			hour = addZero(nowTime.getHours()-9)//기본초기값이 대한민국 표준이 9시로 맞춰져 있음
			min = addZero(nowTime.getMinutes())
			sec = addZero(nowTime.getSeconds())
			milisec = addZero(Math.floor(nowTime.getMilliseconds() / 10))
			document.getElementById('studyhour').innerText = hour
			document.getElementById('studymin').innerText = min
			document.getElementById('studysec').innerText = sec
			document.getElementById('studymilisec').innerText = milisec
		}, 1)
	})
	stopBtn.addEventListener('click', function() {
		var hour = $('#studyhour').text();
		var min = $('#studymin').text();
		var sec = $('#studysec').text();
		var milisec = $('#studymilisec').text();
		alert(hour+':'+min+' : '+sec+' : '+milisec+$(".input_contents")	);
		$('#inputTime').val(hour+":"+min+":"+sec+":"+milisec);
		if (timerStart) {
			clearInterval(timerStart) // STOP
			if (this.innerText == 'STOP') {
				endTime = Date.now()
				this.innerText = 'RESET'
				startBtn.innerText = 'RESTART'
			} else { // RESET
				stTime = 0
				hour = 0
				min = 0
				sec = 0
				milisec = 0
				document.getElementById('studyhour').innerText = '00'
				document.getElementById('studymin').innerText = '00'
				document.getElementById('studysec').innerText = '00'
				document.getElementById('studymilisec').innerText = '00'
				startBtn.innerText = 'START'
				this.innerText = 'STOP'
				timerStart = null
				recordList.innerHTML = ''
			}
		}
	})
	function addZero(num) {
		return (num < 10 ? '0' + num : '' + num)
	}
	

	
	/* $(function(){
	$("#submit").click(function(){
	 

	sessionStorage.setItem("studytime",hour+":"+min+":"+sec+":"+milisec); */
/*   	$.ajax({
		type: "POST",
		url: "/SST/views/personalstudy/dkstjdals.jsp",
		data: {studytime :$("#studysec").val()},
		async:"true",
		success: function(){
			console.log("asdfawef");
		}
	});   
 	}); 
});*/
</script>
</html>