package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.QuestionListVO;
import org.sst.domain.QuestionVO;
import org.sst.domain.StudyNoteListVO;
import org.sst.domain.StudyNoteVO;
import org.sst.service.QuestionServiceImpl;
import org.sst.service.StudyNoteServiceImpl;

public class Question_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		List<QuestionVO> list = null;
		
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		
		QuestionListVO q = service.questionListService(request);
		
		
		request.setAttribute("QuestionListVO", q);
		
		forward.setPath("/views/question/question_list.jsp");
		System.out.println("문제집_리스트액션");
		System.out.println(list);
		forward.setRedirect(false);
		
		return forward;
	}

}
