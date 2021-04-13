package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.CalendarTodoVO;
import org.sst.service.CalendarService;

public class Calendar_MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CalendarService service = CalendarService.getInstance();
		
		List<CalendarTodoVO> toDoList = service.listTodo();
		request.setAttribute("toDoList", toDoList);
		System.out.println(toDoList +"액션 toDoList입니다.");
		forward.setRedirect(false);
		forward.setPath("/views/fullcalendar-5.6.0/Calendar/calendar_main.jsp");
		
		return forward;
	}

}
