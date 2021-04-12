package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main_ForwardAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// (로그인전) 메인페이지로 이동시키는 액션
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // 단순 페이지 이동
		forward.setPath("/views/main/main.jsp");
		return forward;
	}
}
