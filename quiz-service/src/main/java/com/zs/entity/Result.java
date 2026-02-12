package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity @Table(name = "results")
public class Result {
	@Id @GeneratedValue @Column(name = "res_id")
	private int resultId;
	private double score;
	@Column(length = 10)
	private String result;
	
	@JsonBackReference
	@ManyToOne @JoinColumn(name = "userid")
	private User user;
	
	@JsonBackReference
	@OneToOne @JoinColumn(name = "quiz_id")
	private Quiz quiz;
}
