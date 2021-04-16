package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.SchoolTestVO;
import org.sst.service.ReportCardService;

public class SchoolTest_UpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		SchoolTestVO st = service.selectSchoolTest(request);
		request.setAttribute("st", st);
		forward.setRedirect(false);
		forward.setPath("/views/StudyContents/updateSchoolTest.jsp");
		return forward;
	}

}
