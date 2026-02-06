package com.zs.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "todos")
public class Todo {
	@Id @GeneratedValue
	private int tid;
	@Column(length = 30)
	private String task;
	@Column(length = 10)
	private String status = "Pending";
	private LocalDate assignDate = LocalDate.now();
	private LocalDate finishDate;
	
	@JsonBackReference
	@ManyToOne @JoinColumn(name = "uid")
	private User usr;

	// Getters and Setters
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
}
