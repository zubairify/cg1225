package com.zs.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	List<Todo> findByUsr_Uid(int uid);
	
	List<Todo> findByStatus(String status);
	
	List<Todo> findByAssignDateBetween(LocalDate start, LocalDate end);
}
