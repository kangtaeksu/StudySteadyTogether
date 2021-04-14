package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sst.domain.MemberSessionVO;

public class Member_LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그아웃 처리 액션
		ActionForward forward = new ActionForward();
		// 세션이 있다면 기존의 세션을 가지고온다. 
		HttpSession session = request.getSession();
		MemberSessionVO temp = (MemberSessionVO)session.getAttribute("loginsession");
		
		if(temp == null) {
			// 세션 없으면 메인페이지로 이동
			forward.setRedirect(true);
			forward.setPath("main.do");
		} else {
			// 세션이 있으면 세션을 무효화 시킨 후 메인페이지로 이동 
			session.invalidate();
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		
		return forward;
	}

}
