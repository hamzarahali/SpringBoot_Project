package com.example.demo.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table ( name = "user" )
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {

	@Id 
	@GeneratedValue
	private long id ; 
	
	@Column ( name = "login" )
	private String login ; 
	
	@Column ( name = "password" ) 
	private String password ;

	public User(long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	public User ( String login , String password ) {
		this.login = login ; 
		this.password = password ; 
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}