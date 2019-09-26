package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artist {
	
	private int artist_id;
	private String artist_name;
	private String artist_city;
	private String artist_state;
	private String genre;
	private int artist_rank;
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getArtist_city() {
		return artist_city;
	}
	public void setArtist_city(String artist_city) {
		this.artist_city = artist_city;
	}
	public String getArtist_state() {
		return artist_state;
	}
	public void setArtist_state(String artist_state) {
		this.artist_state = artist_state;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getArtist_rank() {
		return artist_rank;
	}
	public void setArtist_rank(int artist_rank) {
		this.artist_rank = artist_rank;
	}

}
