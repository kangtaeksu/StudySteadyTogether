package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Member_SignupFwdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회원가입페이지로 이동시키는 액션
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // 단순 페이지 이동 회원가입 이동
		forward.setPath("/views/member/sign_Up.jsp");
		return forward;
	}
	
}
