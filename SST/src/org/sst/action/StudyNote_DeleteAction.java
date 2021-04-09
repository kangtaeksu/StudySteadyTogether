package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.repository.StudyNoteDAO;

public class StudyNote_DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		StudyNoteDAO dao = StudyNoteDAO.getInstance();
		
		String sn_num = request.getParameter("sn_num");
		int re = dao.deleteStudyNote(sn_num);
		System.out.println(re+"RE deleteAction Sector");
		forward.setRedirect(true);
		forward.setPath("StudyNote_ListAction.do");
		
		return forward;
	}

}
