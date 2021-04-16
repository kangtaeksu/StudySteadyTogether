package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.ReportCardVO;
import org.sst.service.ReportCardService;

public class RC_DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		
		service.deleteReportCard(request);
		List<ReportCardVO> list = service.listReportCard(request);
		request.setAttribute("rclist", list);
		
		forward.setRedirect(false);
		forward.setPath("/view/StudyContents/listReportCard.jsp");
		return forward;
	}

}
