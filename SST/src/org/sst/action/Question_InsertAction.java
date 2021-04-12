package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.QuestionServiceImpl;
import org.sst.service.StudyNoteServiceImpl;

public class Question_InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		
		service.questionInsertService(request);
				
	
		forward.setRedirect(true);
		forward.setPath("Question_ListAction.do");
		
		return forward;
	}

}
