package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.QuestionListVO;
import org.sst.service.QuestionServiceImpl;

public class Question_RecCountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		
		service.recCountService(request, response);
		
		forward.setRedirect(false);
		forward.setPath("/views/question/question_detail.jsp");

		return forward;
	}

}
