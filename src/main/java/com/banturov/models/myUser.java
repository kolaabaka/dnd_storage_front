package com.banturov.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class myUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String role;

	public String getRoles() {
		// TODO Auto-generated method stub
		return role;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}
}
