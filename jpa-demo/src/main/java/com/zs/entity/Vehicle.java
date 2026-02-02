package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id
	private int vid;
	@Column(length = 30)
	private String model;
	private double price;
	
	@OneToOne
	@JoinColumn(name = "reg_no")
	private Registration reg;
	
	public Vehicle() {
	}

	public Vehicle(int vid, String model, double price) {
		this.vid = vid;
		this.model = model;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", model=" + model + ", price=" + price + "]";
	}

	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Registration getReg() {
		return reg;
	}
	public void setReg(Registration reg) {
		this.reg = reg;
	}
}
