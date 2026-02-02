package com.zs.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity @Table(name = "movies")
@NamedQueries(value = {@NamedQuery(name = "releaseBetween", 
		query = "SELECT m FROM Movie m WHERE m.release BETWEEN :start AND :end")		
})
public class Movie {
	@Id @Column(name = "mov_id")
	private int movId;
	@Column(length = 30)
	private String title;
	@Column(name = "release_date")
	private LocalDate release;
	
	@ManyToMany
	@JoinTable(name = "shows", joinColumns = {@JoinColumn(name = "mov_id")},
		inverseJoinColumns = {@JoinColumn(name = "mpex_id")})
	private List<Multiplex> multiplexs = new ArrayList<Multiplex>();

	@Override
	public String toString() {
		return "Id=" + movId + ", Title=" + title + ", Released=" + release;
	}

	public int getMovId() {
		return movId;
	}
	public void setMovId(int movId) {
		this.movId = movId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public List<Multiplex> getMultiplexs() {
		return multiplexs;
	}
	public void setMultiplexs(List<Multiplex> multiplexs) {
		this.multiplexs = multiplexs;
	}

	public LocalDate getRelease() {
		return release;
	}
	public void setRelease(LocalDate release) {
		this.release = release;
	}
}
