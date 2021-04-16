package org.sst.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.ReportCardVO;
import org.sst.service.ReportCardService;

public class LicenseTest_InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		
		service.insertLicenseTest(request);
		ReportCardVO rc = service.selectReportCard(request);
		String rc_type= URLEncoder.encode(rc.getRc_type(),"utf-8");
		
		forward.setRedirect(true);
		forward.setPath("detailReportCardAction.do?rc_num="+request.getParameter("rc_num")+"&rc_type="+rc_type);
		return forward;
	}

}
