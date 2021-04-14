package org.sst.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sst.domain.QuestionListVO;
import org.sst.domain.QuestionReplyVO;
import org.sst.domain.QuestionVO;
import org.sst.domain.RecDTO;
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
	
	public int insertQuestionReplyService(HttpServletRequest request)throws Exception{
		
		QuestionReplyVO q_reply = new QuestionReplyVO();
		q_reply.setC_num(request.getParameter("c_num"));
		q_reply.setC_contents(request.getParameter("c_contents"));
		q_reply.setC_date(request.getParameter("c_date"));
		q_reply.setQ_num(request.getParameter("q_num"));
		q_reply.setGm_num(request.getParameter("gm_num"));
		q_reply.setG_num(request.getParameter("g_num"));
		return dao.insertQuestionReply(q_reply);
	}
	
	public List<QuestionReplyVO> listQuestionReplyService(String q_num){
		return dao.listQuestionReply(q_num);
	}
	
	
	//추천하는 서비스
	
	public int recUpdateService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		QuestionDAO manager = QuestionDAO.getInstance();
		RecDTO q = new RecDTO();
		q.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		q.setRec_id(request.getParameter("rec_id"));
		
		
	
		return manager.recCheck(q);
		

		
	}

	
		//추천수 세기 서비스
	public int recCountService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

	
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		int no = Integer.parseInt(request.getParameter("no"));
		
		QuestionDAO manager = QuestionDAO.getInstance();
		int count = manager.recCount(no);
	
		
		return count;
	}
	
}
