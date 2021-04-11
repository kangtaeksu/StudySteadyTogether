package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.StudyNoteVO;
import org.sst.service.StudyNoteServiceImpl;



public class StudyNote_detailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		StudyNoteServiceImpl service = StudyNoteServiceImpl.getInstance();
		
		String sn_num = request.getParameter("sn_num");
		
		StudyNoteVO snv = service.detailStudyNoteService(sn_num);
		//List<Reply> replys = service.listReplyService(seq);
		
		request.setAttribute("studynote", snv);
		//request.setAttribute("replys", replys);
		
		forward.setRedirect(false);
		forward.setPath("/views/studynote/studynote_detail.jsp");
		
		return forward;
	}

}
