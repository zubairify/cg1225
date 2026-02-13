package com.zs.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "users")
public class User {
	@Id @Column(length = 15)
	private String userid;
	@Column(length = 15)
	private String passwd;
	@Column(length = 30)
	private String email;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Result> results = new ArrayList<Result>();
}
