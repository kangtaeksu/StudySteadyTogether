package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchoolTest_InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("rc_num", request.getParameter("rc_num"));
		forward.setPath("/view/StudyContents/insertSchoolTest.jsp");
		return forward;
	}

}
