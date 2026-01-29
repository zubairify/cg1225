package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "allStudents", query = "SELECT s FROM Student s"),
	@NamedQuery(name = "byBranch", query = "SELECT s FROM Student s WHERE s.branch=:br")
})
public class Student {
	@Id @GeneratedValue @Column(name = "roll_no")
	private int rollNo;
	@Column(length = 40, nullable = false)
	private String name;
	@Column(length = 10, nullable = false)
	private String branch;
	private double gpa;

	public Student() {
	}
	public Student(String name, String branch, double gpa) {
		this.name = name;
		this.branch = branch;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "RollNo=" + rollNo + ", Name=" + name + ", Branch=" + branch + ", GPA=" + gpa;
	}
	
	// Getters and Setters
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
