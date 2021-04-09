package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Member_SignupFwdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // 단순 페이지 이동 회원가입 이동
		forward.setPath("/WEB-INF/views/member/sign_Up.jsp");
		return forward;
	}
	
}
