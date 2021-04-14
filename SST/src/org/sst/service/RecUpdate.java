package org.sst.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.action.Action;
import org.sst.action.ActionForward;
import org.sst.repository.QuestionDAO;

public class RecUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		
		
		service.recUpdateService(request);
		
		forward.setRedirect(true);
		forward.setPath("Question_DetailAction.do");
		
		return forward;
	}
}