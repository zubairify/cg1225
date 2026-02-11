package com.zs.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "orders")
public class Order {
	@Id @GeneratedValue @Column(name = "ord_no")
	private int ordNo;
	@Column(name = "cust_id")
	private int custId;
	@Column(name = "ord_date")
	private LocalDate ordDate = LocalDate.now();
	@Column(length = 10)
	private String status = "Pending";
	@Column(name = "dlvry_date")
	private LocalDate dlvryDate;
	private double amount;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderedProduct> products;

	// Getters and Setters
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

	public LocalDate getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDlvryDate() {
		return dlvryDate;
	}
	public void setDlvryDate(LocalDate dlvryDate) {
		this.dlvryDate = dlvryDate;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<OrderedProduct> getProducts() {
		return products;
	}
	public void setProducts(List<OrderedProduct> products) {
		this.products = products;
	}
}
