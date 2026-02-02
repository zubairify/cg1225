package com.zs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name = "busses")
public class Bus {
	@Id
	private int bid;
	@Column(length = 20)
	private String travel;

	@ManyToMany
	@JoinTable(name = "bus_route", joinColumns = {@JoinColumn(name = "bid")}, 
			inverseJoinColumns = {@JoinColumn(name = "rid")})
	private List<Route> routes = new ArrayList<Route>();

	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", travel=" + travel + "]";
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}

	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
}
