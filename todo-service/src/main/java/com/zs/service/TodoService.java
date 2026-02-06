package com.zs.service;

import java.time.LocalDate;
import java.util.List;

import com.zs.dto.StatusDTO;
import com.zs.dto.TodoDTO;
import com.zs.entity.Todo;

public interface TodoService {

	Todo save(TodoDTO dto, int uid);
	
	Todo find(int tid);
	
	List<Todo> listByStatus(String status);
	
	List<Todo> listByUser(int uid);
	
	List<Todo> listByAssigned(LocalDate start, LocalDate end);
	
	Todo update(StatusDTO dto);
	
	static Todo transform(TodoDTO dto) {
		Todo td = new Todo();
		td.setTask(dto.getTask());
		return td;
	}
}
