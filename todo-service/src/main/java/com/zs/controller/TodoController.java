package com.zs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.StatusDTO;
import com.zs.dto.TodoDTO;
import com.zs.entity.Todo;
import com.zs.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@PostMapping("/add/{uid}")
	public ResponseEntity<Todo> save(@RequestBody @Valid TodoDTO dto, @PathVariable int uid) {
		Todo td = service.save(dto, uid);
		return new ResponseEntity<Todo>(td, HttpStatus.OK);
	}

	@GetMapping("/{tid}")
	public ResponseEntity<Todo> find(@PathVariable int tid) {
		Todo td = service.find(tid);
		return new ResponseEntity<Todo>(td, HttpStatus.FOUND);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Todo>> listByStatus(@PathVariable String status) {
		List<Todo> todos = service.listByStatus(status);
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.FOUND);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<Todo>> listByUser(@PathVariable int uid) {
		List<Todo> todos = service.listByUser(uid);
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.FOUND);
	}
	
	@GetMapping("/dates")
	public ResponseEntity<List<Todo>> listByAssignDates(@RequestParam LocalDate start, 
													@RequestParam LocalDate end) {
		List<Todo> todos = service.listByAssigned(start, end);
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.FOUND);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Todo> update(@RequestBody @Valid StatusDTO dto) {
		Todo td = service.update(dto);
		return new ResponseEntity<Todo>(td, HttpStatus.OK);
	}
}
