package com.zs.ipl;

public class Team {
	private int teamId;
	private String name;
	private String city;
	private double budget;
	
	public Team() {
	}
	public Team(int teamId, String name, String city, double budget) {
		this.teamId = teamId;
		this.name = name;
		this.city = city;
		this.budget = budget;
	}
	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", city=" + city + ", budget=" + budget + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Team) {
			Team t = (Team) obj;
			if(t.teamId == this.teamId)
				return true;
		}
		return false;
	}
	
	// Getters and Setters
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
}
