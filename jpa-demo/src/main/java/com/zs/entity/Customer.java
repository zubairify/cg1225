package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cust")
@NamedQueries({
	@NamedQuery(name = "enames", query = "SELECT c FROM Customer c WHERE c.custName LIKE 'E%'"),
	@NamedQuery(name = "allCust", query = "SELECT c FROM Customer c")
})
public class Customer {
	@Id
	@Column(name = "cust_id")
	private int custId;
	@Column(name = "cname", length = 30, nullable = false)
	private String custName;
	@Column(length = 14, nullable = false, unique = true)
	private String mobile;
	
	public Customer() {
	}
	public Customer(int custId, String custName, String mobile) {
		this.custId = custId;
		this.custName = custName;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "CustId=" + custId + ", CustName=" + custName + ", Mobile=" + mobile;
	}
	
	// Getters and Setters
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
