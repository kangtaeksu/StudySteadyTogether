package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.ReportCardService;

public class SchoolScore_insertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		service.insertSchoolScore(request);
		forward.setRedirect(true);
		forward.setPath("updateSchoolTestForm.do?st_num="+request.getParameter("st_num"));
		return forward;
	}

}
