package org.sst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sst.domain.QuestionListVO;
import org.sst.domain.QuestionVO;
import org.sst.domain.StudyNoteListVO;
import org.sst.domain.StudyNoteSearchVO;
import org.sst.domain.StudyNoteVO;
import org.sst.repository.QuestionDAO;
import org.sst.repository.StudyNoteDAO;

public class QuestionServiceImpl {
	private static QuestionServiceImpl service = new QuestionServiceImpl();
	private static QuestionDAO dao;
	
	
	public QuestionServiceImpl() {
	}

	public static QuestionServiceImpl getInstance() {
		dao = QuestionDAO.getInstance();
		return service;
	}

	public int questionInsertService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		QuestionVO q = new QuestionVO();
		q.setQ_num(request.getParameter("q_num"));
		q.setQ_title(request.getParameter("q_title"));
		q.setQ_contents(request.getParameter("q_contents"));
		q.setQ_answer(request.getParameter("q_answer"));
		q.setQ_date(request.getParameter("q_date"));
		q.setG_num(request.getParameter("g_num"));
		q.setGm_num(request.getParameter("gm_num"));

		return dao.insertQuestion(q);
	}
	
	public QuestionListVO questionListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();

	
		List<QuestionVO> list = dao.questionList();
		QuestionListVO questionListVO = new QuestionListVO(list);
		return questionListVO;
	}
	
	public QuestionVO detailQuestionService(String q_num) throws Exception {
		return dao.detailQuestion(q_num);
	}
}
