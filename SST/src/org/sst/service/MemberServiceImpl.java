package org.sst.service;

import javax.servlet.http.HttpServletRequest;

import org.sst.domain.MemberVO;
import org.sst.repository.MemberDAO;

public class MemberServiceImpl implements MemberService {

	private static MemberServiceImpl service = new MemberServiceImpl();
	private static MemberDAO memdao;
	
	public static MemberServiceImpl getInstance() {
		memdao = MemberDAO.getInstance();
		return service;
	}

	// insertMember : 회원가입
	@Override
	public int insertMemberService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO member = new MemberVO();
		member.setM_id(request.getParameter("id"));
		member.setM_pw(request.getParameter("pw"));
		member.setM_name(request.getParameter("name"));
		member.setM_email(request.getParameter("email"));
		member.setM_phone(request.getParameter("phone"));
		member.setM_birth(request.getParameter("birth"));
		return memdao.joinMember(member);
	}

	// loginMemberService : 로그인 처리
	@Override
	public MemberVO loginMemberService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO login_member = new MemberVO();
		login_member.setM_id(request.getParameter("id"));
		login_member.setM_pw(request.getParameter("pw"));
		MemberVO member = memdao.selectLoginMember(login_member);
		if(member == null) {
			return null;
		} else {
			return member;
		}
	}
	

}
