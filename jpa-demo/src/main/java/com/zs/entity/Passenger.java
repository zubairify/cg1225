package com.zs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "passengers")
public class Passenger {
	@Id @GeneratedValue
	private int pid;
	@Column(length = 30)
	private String name;
	
	@ManyToOne @JoinColumn(name = "rid")
	private Route route;

	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", name=" + name + "]";
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
}
