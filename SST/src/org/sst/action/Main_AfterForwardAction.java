package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sst.domain.MemberSessionVO;

public class Main_AfterForwardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인후 메인페이지로 이동시키는 액션, 로그인x시 로그인전 메인페이지로 이동.. Main_ForwardAction 삭제해도될거같음 ㅎ
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		// getSession() 객체가 존재하면 현재 세션 반환하고 없다면 새로운 세션 객체 생성
		MemberSessionVO temp = (MemberSessionVO)session.getAttribute("loginsession");
		if(temp == null) {
			forward.setRedirect(true);
			forward.setPath("main.do");
		} else {
			forward.setRedirect(false);
			forward.setPath("/views/main/after_login.jsp");
		}
		return forward;
	}
}