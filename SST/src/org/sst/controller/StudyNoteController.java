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
  
    	
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

}
