package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String UserID;
	private String Genre;
	private int Count;
	private int Rank;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public int getRank() {
		return Rank;
	}
	public void setRank(int rank) {
		Rank = rank;
	}
	
	
	

}
