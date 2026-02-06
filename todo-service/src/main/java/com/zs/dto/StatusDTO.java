package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class StatusDTO {
	@Min(value = 1, message = "Todo ID cannot be zero")
	private int tid;
	@Pattern(regexp = "Completed|Pending")
	private String status;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
