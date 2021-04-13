package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		System.out.println(request.getParameter("sn_contents"));
		
		System.out.println("샘플 액션");
		
		forward.setPath("");
		forward.setRedirect(true);
		
		return forward;
	}

}
