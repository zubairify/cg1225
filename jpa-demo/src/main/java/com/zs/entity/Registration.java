package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Registration {
	@Id @Column(name = "reg_no", length = 12)
	private String regNo;
	@Column(length = 20)
	private String rto;
	
	@OneToOne(mappedBy = "reg")
	private Vehicle vehicle;
	
	public Registration() {
	}
	public Registration(String regNo, String rto) {
		this.regNo = regNo;
		this.rto = rto;
	}
	
	@Override
	public String toString() {
		return "Registration [regNo=" + regNo + ", rto=" + rto + "]";
	}
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getRto() {
		return rto;
	}
	public void setRto(String rto) {
		this.rto = rto;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
