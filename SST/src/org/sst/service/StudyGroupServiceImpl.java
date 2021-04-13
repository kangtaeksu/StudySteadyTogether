package org.sst.service;

import javax.servlet.http.HttpServletRequest;

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
	public int insertGroupService(HttpServletRequest request) throws Exception {
		StudyGroupVO vo = new StudyGroupVO();
		vo.setG_name(request.getParameter("groupname"));
		vo.setG_category(request.getParameter("category"));
		vo.setG_contents(request.getParameter("groupcontent"));
		vo.setG_num(request.getParameter("groupnum"));
		vo.setG_secreat(request.getParameter("groupsecret"));
		vo.setG_passwd(request.getParameter("grouppw"));
		return dao.insertStudyGroup(vo);
	}
}
