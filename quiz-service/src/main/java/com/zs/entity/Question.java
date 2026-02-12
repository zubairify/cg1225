package com.zs.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity @Table(name = "questions")
public class Question {
	@Id @Column(name = "quest_id")
	private int questId;
	@Column(length = 100)
	private String question;
	@Column(name = "ans")
	private int rightAns;
	
	@JsonBackReference
	@ManyToOne @JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "quest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Option> options;
}
