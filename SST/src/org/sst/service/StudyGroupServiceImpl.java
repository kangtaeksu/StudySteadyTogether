package org.sst.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sst.domain.GroupMemberVO;
import org.sst.domain.MemberSessionVO;
import org.sst.domain.StudyGroupVO;
import org.sst.repository.MemberDAO;
import org.sst.repository.StudyGroupDAO;

import sun.security.jca.GetInstance;

public class StudyGroupServiceImpl implements StudyGroupService {
	private static StudyGroupServiceImpl service = new StudyGroupServiceImpl();
	private static StudyGroupDAO dao;

	public static StudyGroupServiceImpl GetInstance() {
		dao = StudyGroupDAO.getInstance();
		return service;
	}
	
	// insertGroupService : 그룹 생성
	@Override
	public String insertGroupService(HttpServletRequest request) throws Exception {
		StudyGroupVO vo = new StudyGroupVO();
		HttpSession se = request.getSession();
		// int re = -1;
		String result = null;
		// 그룹 생성 폼에서 값 가져옴
		MemberSessionVO mse = (MemberSessionVO) se.getAttribute("loginsession");
		vo.setG_name(request.getParameter("groupname"));
		vo.setG_category(request.getParameter("category"));
		vo.setG_contents(request.getParameter("groupcontent"));
		vo.setG_memnum(request.getParameter("groupnum"));
		vo.setG_secreat(request.getParameter("groupsecret"));
		vo.setG_passwd(request.getParameter("grouppw"));
		
		// 그룹 생성하자마자 그룹멤버에 회원 추가
		GroupMemberVO gm = new GroupMemberVO();
		result = dao.insertStudyGroup(vo);
		System.out.println(result);
		gm.setG_num(result);
		gm.setM_id(mse.getId());
		gm.setP_grant(1);
		service.insertGroupMemberService(request, gm);
		return result;
	}

	// insertGroupMemberService : 그룹멤버에 추가
	@Override
	public int insertGroupMemberService(HttpServletRequest request, GroupMemberVO gmem) throws Exception {
		return dao.insertGroupMember(gmem);
	}

	// selectGroupListService : 스터디 그룹 다 가져오기일단.. 
	@Override
	public void selectGroupListService(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
