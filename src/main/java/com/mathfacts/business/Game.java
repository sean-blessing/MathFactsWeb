package com.mathfacts.business;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	private String type;
	private Timestamp datePlayed;
	private long startTime;
	private long endTime;
	private double elapsedTime;
	private int numRight = 0;
	private int numWrong = 0;
	
	
	public Game(User u, String t) {
		user = u;
		type = t;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(Timestamp datePlayed) {
		this.datePlayed = datePlayed;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public double getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(double elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public int getNumRight() {
		return numRight;
	}
	public void setNumRight(int numRight) {
		this.numRight = numRight;
	}
	public int getNumWrong() {
		return numWrong;
	}
	public void setNumWrong(int numWrong) {
		this.numWrong = numWrong;
	}

}
