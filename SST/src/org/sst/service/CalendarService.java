package org.sst.service;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.sst.domain.Todo;
import org.sst.repository.CalendarDao;

public class CalendarService {
	private static CalendarService service = new CalendarService();
	private static CalendarDao dao;
	
	public static CalendarService getInstance() {
		dao = CalendarDao.getInstance();
		return service;
	}
	public int insertTodoService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Todo todo = new Todo();
		
		todo.setT_category(request.getParameter("t_category"));
		todo.setT_title(request.getParameter("t_title"));
		todo.setT_contents(request.getParameter("t_contents"));
		String stdate = request.getParameter("t_startdate");
		
		SimpleDateFormat st_transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate = st_transFormat.parse(stdate);
		todo.setT_startdate(startdate);
		//오류가 나버리누.. ;;
		if(request.getParameter("t_enddate")!=null) {
			String endate = request.getParameter("t_enddate");
			SimpleDateFormat en_transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date enddate = en_transFormat.parse(endate);
			todo.setT_enddate(enddate);
		}
		System.out.println(todo + "인서트서비스 todo입니다.");
		return dao.insertTodo(todo);
	}
	
	public List<Todo> listTodo()throws Exception{
		List<Todo> list = dao.listTodo();
		System.out.println(list + "서비스 list입니다.");
		return list;
	}
}
