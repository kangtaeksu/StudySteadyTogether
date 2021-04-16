package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.QuestionVO;
import org.sst.domain.QuestionReplyVO;
import org.sst.domain.StudyNoteVO;
import org.sst.service.QuestionServiceImpl;
import org.sst.service.StudyNoteServiceImpl;

public class Question_DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		
		String q_num = request.getParameter("q_num");
		
		QuestionVO q = service.detailQuestionService(q_num);
		List<QuestionReplyVO> q_reply = service.listQuestionReplyService(q_num);
		
		request.setAttribute("question", q);
		request.setAttribute("questionreply", q_reply);
		
		forward.setRedirect(false);
		forward.setPath("/views/question/question_detail.jsp");
		
		return forward;
	}

}
