package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.StudyNoteVO;
import org.sst.service.StudyNoteServiceImpl;



public class StudyNote_UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		StudyNoteServiceImpl service = StudyNoteServiceImpl.getInstance();
		
		String sn_num = request.getParameter("sn_num");
		StudyNoteVO snv = service.detailStudyNoteService(sn_num);		
		request.setAttribute("studynote", snv);
		
		forward.setRedirect(false);
		forward.setPath("/studynote_update_form.jsp");
		
		return forward;
	}

}
