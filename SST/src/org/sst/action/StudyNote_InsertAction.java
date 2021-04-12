package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.StudyNoteService;
import org.sst.service.StudyNoteServiceImpl;



public class StudyNote_InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		StudyNoteServiceImpl service = StudyNoteServiceImpl.getInstance();
		
		service.studyNoteInsertService(request);				
	
		forward.setRedirect(true);
		forward.setPath("StudyNote_ListAction.do");
		
		return forward;
	}

}
