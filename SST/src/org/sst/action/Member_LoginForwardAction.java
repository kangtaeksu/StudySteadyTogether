package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sst.domain.MemberVO;

public class Member_LoginForwardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 페이지로 이동시키는 액션
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		forward.setRedirect(false);
		forward.setPath("/views/member/login.jsp");
		return forward;
	}
}
