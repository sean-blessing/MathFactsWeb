package com.mathfacts.business;

import java.sql.Date;

public class Game {
	private int id = 0;
	private int userID;
	private String type;
	private Date datePlayed;
	private long startTime;
	private long endTime;
	private double elapsedTime;
	private int numRight = 0;
	private int numWrong = 0;
	
	
	public Game(int uid, String t) {
		userID = uid;
		type = t;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(Date datePlayed) {
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
