package com.cg.ofd.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min=2, message="userName should have at least 2 character")
	@Column
	private String username;
	
	@NotBlank
	@Column
	@JsonIgnore
	@Size(min=2, message="password should have at least 2 character")
	private String password;
	
	@NotBlank
	@Column
	private String role;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int id,@NotBlank String username,@NotBlank String password ,@NotBlank String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	    this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}