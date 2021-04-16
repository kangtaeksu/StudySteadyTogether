package org.sst.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sst.domain.MemberSessionVO;
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
	// selectMemberInfoService : 회원 조회
	@Override
	public MemberVO selectMemberInfoService(HttpServletRequest request) throws Exception {
		HttpSession se = request.getSession();
		MemberSessionVO vo = (MemberSessionVO) se.getAttribute("loginsession");
		if(vo!=null) {
			//request.setAttribute("infomem", o);
			return memdao.selectMemberInfo(vo.getId());
		} else {
			return null;
		}
	}

	// updateMemberService : 회원 정보 수정
	@Override
	public int updateMemberService(HttpServletRequest request) throws Exception {
		MemberVO vo = new MemberVO();
		request.setCharacterEncoding("utf-8");
		HttpSession se = request.getSession();
		MemberSessionVO mem = (MemberSessionVO)se.getAttribute("loginsession");
		vo.setM_id(mem.getId());
		vo.setM_name(request.getParameter("memname"));
		vo.setM_phone(request.getParameter("memphone"));
		vo.setM_birth(request.getParameter("membirth"));
		vo.setM_email(request.getParameter("mememail"));
		return memdao.updateMember(vo);
	}
}
