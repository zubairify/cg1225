package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
