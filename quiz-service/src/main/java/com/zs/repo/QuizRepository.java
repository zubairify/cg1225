package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
