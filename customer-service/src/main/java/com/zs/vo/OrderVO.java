package com.zs.vo;

import java.time.LocalDate;
import java.util.List;

public class OrderVO {
	private int ordNo;
	private int custId;
	private LocalDate ordDate = LocalDate.now();
	private String status = "Pending";
	private LocalDate dlvryDate;
	private double amount;
	private List<OrderedProductVO> products;
	
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
	public List<OrderedProductVO> getProducts() {
		return products;
	}
	public void setProducts(List<OrderedProductVO> products) {
		this.products = products;
	}
}
