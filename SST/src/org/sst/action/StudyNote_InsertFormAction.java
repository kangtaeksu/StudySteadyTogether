package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.action.ActionForward;

public class StudyNote_InsertFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		forward.setPath("/views/studynote/studynote_insert_form.jsp");

		
		
		return forward;
	}
	
	

}
