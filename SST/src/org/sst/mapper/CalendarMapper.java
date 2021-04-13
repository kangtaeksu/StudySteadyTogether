package org.sst.mapper;

import java.util.List;

import org.sst.domain.CalendarTodoVO;

public interface CalendarMapper {
	int insertTodo(CalendarTodoVO todo);
	List<CalendarTodoVO> listTodo();
}
