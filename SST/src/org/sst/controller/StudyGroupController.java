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
import org.sst.action.Group_EndAction;
import org.sst.action.Group_ForwardAction;
import org.sst.action.Group_InsertAction;

@WebServlet("/StudyGroup/*")
public class StudyGroupController extends HttpServlet {
	
    public StudyGroupController() {
        super();
    }
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	System.out.println("사용자 요청 URI : " + requestURI);
    	
    	String path = request.getContextPath();
    	String command = requestURI.substring(path.length()+12);
    	System.out.println("최종 요청 : " + command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(command.equals("groupnew.do")) {
    		// 그룹 생성페이지 이동
    		action = new Group_ForwardAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("groupAdd.do")) {
    		// 그룹 생성 처리
    		action = new Group_InsertAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("groupEnd.do")) {
    		// 그룹 생성완료 페이지로 이동
    		action = new Group_EndAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	if(forward != null) {
			if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispacher = request.getRequestDispatcher(forward.getPath());
    			dispacher.forward(request, response);
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
