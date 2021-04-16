package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.PersonalStudyServiceImpl;

public class PersonalStudy_insertStudyTimeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/personalstudy/personalstudy_Form.jsp");
		return forward;
	}

}
