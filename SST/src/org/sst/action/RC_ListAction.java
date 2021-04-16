package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.ReportCardVO;
import org.sst.service.ReportCardService;

public class RC_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		List<ReportCardVO> list = service.listReportCard(request);
		if(list.size() ==0) {
			forward.setRedirect(true);
			forward.setPath("insertReportCardForm.do");
		}else {
			forward.setRedirect(false);
			request.setAttribute("rclist", list);
			forward.setPath("/view/StudyContents/listReportCard.jsp");
		}
		
		return forward;
	}

}
