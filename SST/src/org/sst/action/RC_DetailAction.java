package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.sst.domain.LicenseTestVO;
import org.sst.domain.SchoolTestVO;
import org.sst.service.ReportCardService;

public class RC_DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		request.setAttribute("rc_num", request.getParameter("rc_num"));
		
		//학교성적
		if(request.getParameter("rc_type").endsWith("성적")) {
			List<SchoolTestVO> list = service.averageSchoolTest(request);
			List<SchoolTestVO> list2 = service.listSchoolTest(request);
			forward.setRedirect(false);
			if(list.size() == 0) {
				forward.setPath("/views/StudyContents/insertSchoolTest.jsp");
			}else {
				request.setAttribute("stlist", list);
				request.setAttribute("stlist2", list2);
				forward.setPath("/views/StudyContents/detailReportCard.jsp");
			}
		}else { //자격증 성적
			List<LicenseTestVO> list = service.listLicenseTest(request);
			if(list.size() == 0) {
				forward.setPath("/views/StudyContents/insertLicenseTest.jsp");
			}else {
				request.setAttribute("ltlist", list);
				forward.setPath("/views/StudyContents/detailLicenseReportCard.jsp");
			}
			
		}
		
		
		
		
		
		return forward;
	}

}
