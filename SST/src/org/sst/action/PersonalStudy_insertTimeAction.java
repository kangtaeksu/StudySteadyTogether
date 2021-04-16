package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.PersonalStudyServiceImpl;

public class PersonalStudy_insertTimeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		PersonalStudyServiceImpl service = PersonalStudyServiceImpl.getInstance();
		
		service.insertStudyTimeService(request);
		
		forward.setRedirect(true);
		forward.setPath("insertStudyTimeForm.do");
		
		return forward;
	}

}
