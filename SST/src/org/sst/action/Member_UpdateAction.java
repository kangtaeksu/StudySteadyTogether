package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.MemberVO;
import org.sst.service.MemberService;
import org.sst.service.MemberServiceImpl;

public class Member_UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MemberService service = MemberServiceImpl.getInstance();
		// request(세션에 id저장되어있음)
		MemberVO vo = service.selectMemberInfoService(request);
		request.setAttribute("meminfo", vo);
		forward.setRedirect(false);
		forward.setPath("/views/member/member_update.jsp");
		return forward;
	}
}
