package com.zs.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity @Table(name = "quizes")
public class Quiz {
	@Id @Column(name = "quiz_id")
	private int quizId;
	@Column(length = 50)
	private String title;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
	private List<Question> quests;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "quiz")
	private Result result;
}
