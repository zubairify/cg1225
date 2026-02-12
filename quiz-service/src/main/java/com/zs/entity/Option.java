package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity @Table(name = "options")
public class Option {
	@Id @Column(name = "opt_id")
	private int optId;
	@Column(name="opt_text", length = 100)
	private String option;
	
	@JsonBackReference
	@ManyToOne @JoinColumn(name = "quest_id")
	private Question quest;
	
}
