package com.mathfacts.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	
	public User() {
		id = 0;
		userName = "";
		password = "";
		firstName = "";
		lastName = "";
	}
	
	public User(int iD, String userName, String password, String firstName, String lastName) {
		super();
		id = iD;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getID() {
		return id;
	}
	public void setID(int inID) {
		id = inID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
