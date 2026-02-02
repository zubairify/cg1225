package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id @Column(name = "eno")
	private int empNo;
	@Column(name = "ename", length = 30, nullable = false)
	private String empName;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "dno")
	private Department dept;
	
	public Employee() {
	}
	public Employee(int empNo, String empName, double salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Emp No=" + empNo + ", Name=" + empName + ", Salary=" + salary;
	}
	
	// Getters and Setters
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}
