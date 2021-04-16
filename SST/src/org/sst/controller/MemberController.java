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
import org.sst.action.Main_AfterForwardAction;
import org.sst.action.Main_ForwardAction;
import org.sst.action.Member_EndAction;
import org.sst.action.Member_InsertAction;
import org.sst.action.Member_LoginAction;
import org.sst.action.Member_LoginForwardAction;
import org.sst.action.Member_LogoutAction;
import org.sst.action.Member_SignupFwdAction;
import org.sst.action.Member_UpdateAction;
import org.sst.action.Member_UpdateDoAction;


@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
		System.out.println("사용자 요청 URI : " + requestURI);
		
		String path = request.getContextPath();
		String command = requestURI.substring(path.length()+8);
		System.out.println("최종 요청 : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		
		if(command.equals("main.do")) {
			// main.jsp 이동ㅇㄹ
			action = new Main_ForwardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("memberForward.do" )) {
			// signUp.jsp 이동
			action = new Member_SignupFwdAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("memberInsert.do")) {
			// 회원가입 처리
			action = new Member_InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("memberEnd.do")) {
			// 회원가입 후 end_join.jsp 이동
			action = new Member_EndAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("loginForward.do")) {
			// 로그인 페이지 login.jsp 이동
			action = new Member_LoginForwardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("login.do")) {
			// 로그인 처리
			action = new Member_LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("afterlogin.do")) {
			// 로그인 성공시 로그인한 사용자 전용 메인페이지로 이동
			action = new Main_AfterForwardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("logout.do")) {
			// 로그아웃시 메인페이지로 이동
			System.out.println("여기까지 들어오니");
			action = new Member_LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("mypage.do")) {
			// 회원정보 수정 페이지로 이동
			action = new Member_UpdateAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("updateinfo.do")) {
			// 회원정보 수정
			action = new Member_UpdateDoAction();
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
