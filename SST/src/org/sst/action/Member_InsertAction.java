package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.MemberService;
import org.sst.service.MemberServiceImpl;

public class Member_InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MemberService service = MemberServiceImpl.getInstance();
		service.insertMemberService(request);
		forward.setRedirect(true);
		forward.setPath("memberEnd.do");
		return forward;
	}

}
