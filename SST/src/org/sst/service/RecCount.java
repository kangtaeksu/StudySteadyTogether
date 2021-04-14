package org.sst.service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.action.Action;
import org.sst.action.ActionForward;
import org.sst.domain.QuestionListVO;
import org.sst.repository.QuestionDAO;


public class RecCount implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		
		
		QuestionListVO q = service.questionListService(request);
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("RecDTO",q);
		
		forward.setPath("/views/question/question_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}