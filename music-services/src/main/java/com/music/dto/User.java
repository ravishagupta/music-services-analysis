package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private int user_id;
	private String genre;
	private int rank_for_genre;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRank_for_genre() {
		return rank_for_genre;
	}
	public void setRank_for_genre(int rank_for_genre) {
		this.rank_for_genre = rank_for_genre;
	}
	
	
	

}
