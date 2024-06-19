package com.banturov.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "heroes")
public class MyHeroes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 4, max = 20, message = "Minimal size 4, maximum size 20")
	@Column(unique = true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "author")
	private MyUser myUser;
	
	public MyUser getUser(){
		return this.myUser;
	}
	
	public void setUser(MyUser user){
		this.myUser = user;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "myHeroes [id=" + id + ", name=" + name + ", myUser=" + myUser + "]";
	}

}
