package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원가입 완료
public class Member_EndAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회원가입 후 페이지 이동 액션
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // 단순 페이지 이동
		forward.setPath("/views/main/end_join.jsp");
		return forward;
	}
}
