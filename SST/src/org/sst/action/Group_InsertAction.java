package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.MemberService;
import org.sst.service.MemberServiceImpl;
import org.sst.service.StudyGroupService;
import org.sst.service.StudyGroupServiceImpl;

public class Group_InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 그룹 생성 액션
		ActionForward forward = new ActionForward();
		StudyGroupService service = StudyGroupServiceImpl.GetInstance();
		service.insertGroupService(request);
		forward.setRedirect(true);
		forward.setPath("groupEnd.do");
		return forward;
	}

}
