package org.sst.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/StudyNoteController/*")
public class StudyNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudyNoteController() {
        super();
       
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("요청 받음");
    	//http://localhost:8081/MVC/board/updateBoard.do => 문자열 부분추출
    	//첫번째 할 것 url 식별
    	
    	String requestURI = request.getRequestURI();
    	System.out.println("요청 : "+requestURI);
    	//  ->/MVC/board/updateBoard.do
    	
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+7);
    	System.out.println("최종요청 : "+command); //필요한 커맨드값만 뽑아서 요청확인함
    	
//    	Action action = null;
//    	ActionForward forward = null;
//    	
    	//해당 URL에 대한 Action 호출 (각각의 액션을 만들어서 액션 호출)
//    	if(command.equals("insertForm.do")) {
//    		//페이지 이동 insert
//    		action = new InsertFormAction();
//    		try {
//    			forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//    		
//    	}else if(command.equals("insertAction.do")) {
//    		//DB 데이터 저장
//    		//페이지 BoardList.do
//    		//여기서 다할순 없지 그래서 액션을 만들어야 함
//    		action = new insertAction();
//    		
//    		//해당하는 url의 클래스만 바뀜 뭔가 딱딱 통일되게 만들어지고 있잖아
//    		//이게 인터페이스를 만들었기 때문에 가능한 것이다.
//    		try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//    		
//    		
//    	}else if(command.equals("listAction.do")) {
//    		//DB 데이터 불러오고
//    		//List.jsp 이동
//    		
//    		action = new ListAction();
//    		
//    		try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//    		
//    	}
    	
//    	if(forward != null) {
//    		if(forward.isRedirect()) {
//    			response.sendRedirect(forward.getPath());
//    		}else {
//    			RequestDispatcher dispatcher = 
//    					request.getRequestDispatcher(forward.getPath());
//    			dispatcher.forward(request, response);
//    		}
//    	}
    	
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

}
