package org.sst.service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RecCount implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO manager = BoardDAO.getInstance();
		// �Խñ� �� ��õ���� ����
		int count = manager.recCount(no);
		// ��������(boardContent.jsp)�� ��õ���� ����ϵ��� �ϴ� ����
		out.println(count);
		out.close();
		
		return null;
	}
}