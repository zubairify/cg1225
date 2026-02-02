package com.zs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id @Column(name = "dno")
	private int deptNo;
	@Column(name = "dname", length = 15, nullable = false, unique = true)
	private String deptName;
	@Column(length = 20)
	private String location;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private List<Employee> emps;
	
	public Department() {
	}
	public Department(int deptNo, String deptName, String location) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Dept No=" + deptNo + ", Name=" + deptName + ", Location=" + location;
	}
	
	// Getters and Setters
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}
