package com.zs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Multiplex {
	@Id @Column(name = "mpex_id")
	private int mpexId;
	@Column(length = 20)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "shows", joinColumns = {@JoinColumn(name = "mpex_id")},
			inverseJoinColumns = {@JoinColumn(name="mov_id")})
	private List<Movie> movies = new ArrayList<Movie>();

	@Override
	public String toString() {
		return "Multiplex [mpexId=" + mpexId + ", name=" + name + "]";
	}

	public int getMpexId() {
		return mpexId;
	}
	public void setMpexId(int mpexId) {
		this.mpexId = mpexId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
