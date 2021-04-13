package org.sst.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.repository.QuestionDAO;

public class Question_RecCountReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		QuestionDAO dao = QuestionDAO.getInstance();
		// 게시글 총 추천수를 구함
		int count = dao.recCount(no);
		// 뷰페이지(boardContent.jsp)에 추천수를 출력하도록 하는 역할
		out.println(count);
		out.close();
		
		return null;
	}
	}


