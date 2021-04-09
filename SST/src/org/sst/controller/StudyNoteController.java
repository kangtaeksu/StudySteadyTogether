package org.sst.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.action.StudyNote_InsertFormAction;
import org.sst.action.StudyNote_ListAction;
import org.sst.action.StudyNote_UpdateAction;
import org.sst.action.StudyNote_UpdateFormAction;
import org.sst.action.StudyNote_detailAction;


import org.sst.action.Action;
import org.sst.action.ActionForward;
import org.sst.action.StudyNote_InsertAction;





@WebServlet("/StudyNote/*")
public class StudyNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudyNoteController() {
        super();
       
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("요청 받음");
    	//http://localhost:8081/MVC/board/updateBoard.do => 문자열 부분추출해야쥬
    	//첫번째 할 것 url 식별
    	
    	String requestURI = request.getRequestURI();
    	System.out.println("요청 : "+requestURI);
    	//  ->/MVC/board/updateBoard.do
    	
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+11);
    	System.out.println("최종요청 : "+command); //필요한 커맨드값만 뽑아서 요청확인함
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	//해당 URL에 대한 Action 호출 (각각의 액션을 만들어서 액션 호출해야쥬)
    	if(command.equals("StudyNote_InsertFormAction.do")) {
    		//페이지 이동 insert
    		action = new StudyNote_InsertFormAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("StudyNote_InsertAction.do")) {
    		action = new StudyNote_InsertAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
		    }
    		
    	}else if(command.equals("StudyNote_DetailAction.do")) {
    		action = new StudyNote_detailAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
		    }
    	}else if(command.equals("StudyNote_UpdateFormAction.do")) {
    		action = new StudyNote_UpdateFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("StudyNote_UpdateAction.do")) {
    		action = new StudyNote_UpdateAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	else if(command.equals("StudyNote_ListAction.do")) {
    		action = new StudyNote_ListAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	//

    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    	
    	
    	
    	
    	
  
    	
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

}
