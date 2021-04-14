package org.sst.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.action.Action;
import org.sst.action.ActionForward;
import org.sst.action.Question_DetailAction;
import org.sst.action.Question_InsertAction;
import org.sst.action.Question_InsertFormAction;
import org.sst.action.Question_InsertReplyAction;
import org.sst.action.Question_ListAction;
import org.sst.action.Question_RecCountAction;

import org.sst.action.Question_RecUpdateAction;






@WebServlet("/Question/*")
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public QuestionController() {
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
    	String command = requestURI.substring(contextPath.length()+10);
    	System.out.println("최종요청 : "+command); //필요한 커맨드값만 뽑아서 요청확인함
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	//해당 URL에 대한 Action 호출 (각각의 액션을 만들어서 액션 호출해야쥬)
    	if(command.equals("Question_InsertFormAction.do")) {
    		//페이지 이동 insert
    		action = new Question_InsertFormAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("Question_InsertAction.do")) {
    		action = new Question_InsertAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
		    }
    		
    	}	else if(command.equals("Question_ListAction.do")) {
    		action = new Question_ListAction();
    		
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("Question_DetailAction.do")) {
    		action = new Question_DetailAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
		    }
    	}else if(command.equals("Question_InsertReplyAction.do")) {
    		action = new Question_InsertReplyAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}	
    	// 추천체크
    			
    	// 추천추가
		else if (command.equals("Question_RecUpdateAction.do")) {
			try {
				action = new Question_RecUpdateAction();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	// 추천삭제
    			/*else if (command.equals("Question_RecDeleteAction.do")) {
    				try {
    					action = new Question_RecDeleteAction();
    					action.execute(request, response);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}*/
		// 추천세기
		else if (command.equals("Question_RecCountAction.do")) {
			try {
				action = new Question_RecCountAction();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    	
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
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
		doProcess(request, response);
	}

}