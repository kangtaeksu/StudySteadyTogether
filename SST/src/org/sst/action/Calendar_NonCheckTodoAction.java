package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.service.CalendarServiceImpl;

public class Calendar_NonCheckTodoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==1-1==");
		ActionForward forward = new ActionForward();
		System.out.println("==1-2==");
		CalendarServiceImpl service = CalendarServiceImpl.getInstance();
		System.out.println("==1-3==");
		service.updateNonCheckService(request);
		System.out.println("==1-4==");
		forward.setRedirect(true);
		System.out.println("==1-5==");
		forward.setPath("/SST/fullcalendar-5.6.0/Calendar2/CalendarForm.do");
		System.out.println("==1-6==");
		return forward;
	}

}
