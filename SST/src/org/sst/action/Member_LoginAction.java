package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sst.domain.MemberSessionVO;
import org.sst.domain.MemberVO;
import org.sst.service.MemberService;
import org.sst.service.MemberServiceImpl;

public class Member_LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 성공 실패시 
		ActionForward forward = new ActionForward();
		MemberService service = MemberServiceImpl.getInstance();
		MemberVO vo = service.loginMemberService(request);
		// 로그인 실패시 로그인 페이지로 이동
		if(vo == null) {
			forward.setRedirect(true);
			forward.setPath("loginForward.do");
		} else {
			// 로그인 성공시 로그인해야만 들어갈 수 있는 페이지로 이동
			HttpSession session = request.getSession(); // 기존의 세션이 없다면 세션생성
			MemberSessionVO mem = new MemberSessionVO(); // id, name만 저장하는 객체
			mem.setId(vo.getM_id());
			mem.setEmail(vo.getM_email());
			session.setAttribute("loginsession", mem); // 세션정보에 id, name 저장
			//System.out.println(vo.getM_id());
			forward.setRedirect(true);
			forward.setPath("afterlogin.do");
		}
		return forward;
	}
	
}
