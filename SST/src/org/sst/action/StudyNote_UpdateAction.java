package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.StudyNoteVO;
import org.sst.service.StudyNoteService;
import org.sst.service.StudyNoteServiceImpl;



public class StudyNote_UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		StudyNoteServiceImpl service = StudyNoteServiceImpl.getInstance();
		
		StudyNoteVO snv = new StudyNoteVO();
		snv.setSn_num(request.getParameter("sn_num"));
		snv.setSn_title(request.getParameter("sn_title"));
		snv.setSn_contents(request.getParameter("sn_contents"));
		
		service.updateStudyNoteService(snv);
		
		forward.setRedirect(true);
		forward.setPath("StudyNote_ListAction.do");
		
		return forward;
	}

}
