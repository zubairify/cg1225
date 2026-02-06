package com.zs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.StatusDTO;
import com.zs.dto.TodoDTO;
import com.zs.entity.Todo;
import com.zs.entity.User;
import com.zs.error.InvalidTodoException;
import com.zs.repo.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository repo;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Todo save(TodoDTO dto, int uid) {
		User usr = userService.find(uid);
		Todo td = TodoService.transform(dto);
		td.setUsr(usr);
		return repo.save(td);
	}

	@Override
	public Todo find(int tid) {
		return repo.findById(tid).orElseThrow(
				() -> new InvalidTodoException("Todo not found with Id: " + tid));
	}

	@Override
	public List<Todo> listByStatus(String status) {
		return repo.findByStatus(status);
	}

	@Override
	public List<Todo> listByUser(int uid) {
		return repo.findByUsr_Uid(uid);
	}

	@Override
	public List<Todo> listByAssigned(LocalDate start, LocalDate end) {
		return repo.findByAssignDateBetween(start, end);
	}

	@Override
	public Todo update(StatusDTO dto) {
		Todo td = repo.findById(dto.getTid()).orElseThrow(
				() -> new InvalidTodoException("Todo not found with Id: " + dto.getTid()));
		
		td.setStatus(dto.getStatus());
		if(dto.getStatus().equals("Completed"))
			td.setFinishDate(LocalDate.now());
		
		return repo.save(td);
	}
}
