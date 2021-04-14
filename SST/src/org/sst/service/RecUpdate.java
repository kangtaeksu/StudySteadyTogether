package org.sst.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.joker.board.db.BoardDAO;
import com.joker.member.service.Action;
import com.joker.member.service.ActionForward;

public class RecUpdate implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		// no�� id���� map�� ����
		Map<String, Object> m = new HashMap<>();
		m.put("no", request.getParameter("no"));
		m.put("id", request.getParameter("id"));
		
		BoardDAO manager = BoardDAO.getInstance();
		// ���� �Խñۿ� ���� ���� ��õ ���� �˻�
		int result = manager.recCheck(m);
		
		if(result == 0){ // ��õ���� �ʾҴٸ� ��õ �߰�
			manager.recUpdate(m);
		}else{ // ��õ�� �Ͽ��ٸ� ��õ ����
			manager.recDelete(m);
		}
		return null;
	}
}