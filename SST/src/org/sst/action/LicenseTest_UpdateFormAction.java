package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.LicenseTestVO;
import org.sst.service.ReportCardService;

public class LicenseTest_UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		LicenseTestVO lt = service.selectLicenseTest(request);
		request.setAttribute("test", lt);
		forward.setPath("/view/StudyContents/updateLicenseTest.jsp");
		return forward;
	}

}
