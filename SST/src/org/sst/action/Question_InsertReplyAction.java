package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.QuestionServiceImpl;



public class Question_InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		request.setCharacterEncoding("utf-8");
		
		service.insertQuestionReplyService(request);
		
		forward.setRedirect(true);
		forward.setPath("Quesiton_DetailAction.do?q_num="+ request.getParameter("q_num"));
		
		return forward;
	}

}
