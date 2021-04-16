package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.ReportCardService;


public class RC_InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		service.insertReportCard(request);
		forward.setRedirect(true);
		forward.setPath("listReportCardAction.do");
		return forward;
	}

}
