package org.sst.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.repository.QuestionDAO;
import org.sst.service.QuestionServiceImpl;

public class Question_RecReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		QuestionServiceImpl service = QuestionServiceImpl.getInstance();
		request.setCharacterEncoding("utf-8");
		// no와 id값을 map에 저장
		Map<String, Object> m = new HashMap<>();
		m.put("c_like", request.getParameter("c_like"));
		m.put("gm_num", request.getParameter("gm_num"));
		
		QuestionDAO dao = QuestionDAO.getInstance();
		// 동일 게시글에 대한 이전 추천 여부 검색
		int result = dao.recCheck(m);
		
		if(result == 0){ // 추천하지 않았다면 추천 추가
			dao.recUpdate(m);
		}else{ // 추천을 하였다면 추천 삭제
			dao.recDelete(m);
		}
		return forward;
	}

}
