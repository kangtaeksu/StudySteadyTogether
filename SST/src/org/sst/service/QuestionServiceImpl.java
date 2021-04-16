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
		System.out.println(q);
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
		q_reply.setC_like(Integer.parseInt(request.getParameter("c_like")));
		
		return dao.insertQuestionReply(q_reply);
	}
	
	public List<QuestionReplyVO> listQuestionReplyService(String q_num){
		return dao.listQuestionReply(q_num);
	}
	
	
	//좋아요 해도되는지 체크해도 되겠습니까?
	
	
	//추천하는 서비스
	
	public int recUpdateService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		QuestionDAO dao = QuestionDAO.getInstance();
		QuestionReplyVO q = new QuestionReplyVO();
		q.setC_like(Integer.parseInt(request.getParameter("c_like")));
			
		return dao.recUpdate(q);

	}
	
	//추천 취소~
	/*public int recDeleteService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		QuestionDAO dao = QuestionDAO.getInstance();
		RecDTO q = new RecDTO();
		q.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		q.setRec_id(request.getParameter("rec_id"));
		
		
	
		return dao.recDelete(q);
		
	}*/
	
		//추천수 세기 서비스
	public int recCountService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		QuestionReplyVO q = new QuestionReplyVO();
		int no = Integer.parseInt(request.getParameter("no"));
		
		QuestionDAO dao = QuestionDAO.getInstance();
		response.setContentType("text/html;charset=utf-8");
		
		 request.setAttribute("QuestionReplyVO", q);
		 
		int count = dao.recCount(no);
	
		
		return count;
	}
	//이미지 첨부 
	
}
