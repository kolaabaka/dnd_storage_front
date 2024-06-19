package com.banturov.models;

import java.util.List;

import org.hibernate.validator.constraints.Normalized;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Username cannot be empty")
	@Size(min = 3, message = "ARRRR")
	@Column(unique = true)
	private String name;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 5, message = "Size more than 5")
	@Column(nullable = false)
	private String password;

	@Column
	private String role;

	@OneToMany(mappedBy = "myUser", cascade = CascadeType.REMOVE)
	private List<MyHeroes> heroes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
