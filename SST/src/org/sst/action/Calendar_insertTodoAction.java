package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.CalendarService;

public class insertTodoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CalendarService service = CalendarService.getInstance();
		
		service.insertTodoService(request);
		
		forward.setRedirect(true);
		forward.setPath("/PrivateSteudy/fullcalendar-5.6.0/Calendar2/CalendarForm.do");
		
		return forward;
	}

}
