package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.ReportCardService;

public class LicenseTest_InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		request.setAttribute("rc_num", request.getParameter("rc_num"));
		forward.setRedirect(false);
		forward.setPath("/view/StudyContents/insertLicenseTest.jsp");
		return forward;
	}

}
