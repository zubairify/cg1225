package com.zs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "routes")
public class Route {
	@Id
	private int rid;
	@Column(length = 20, name = "src")
	private String source;
	@Column(length = 20, name = "dest")
	private String destination;
	
	@ManyToMany
	@JoinTable(name = "bus_route", joinColumns = {@JoinColumn(name = "rid")}, 
			inverseJoinColumns = {@JoinColumn(name = "bid")})
	private List<Bus> busses = new ArrayList<Bus>();
	
	@OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
	private List<Passenger> passengers = new ArrayList<Passenger>();

	@Override
	public String toString() {
		return "Route [rid=" + rid + ", source=" + source + ", destination=" + destination + "]";
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Bus> getBusses() {
		return busses;
	}
	public void setBusses(List<Bus> busses) {
		this.busses = busses;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}
