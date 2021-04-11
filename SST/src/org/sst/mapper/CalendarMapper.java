package org.sst.mapper;

import java.util.List;

import org.sst.domain.Todo;

public interface CalendarMapper {
	int insertTodo(Todo todo);
	List<Todo> listTodo();
}
