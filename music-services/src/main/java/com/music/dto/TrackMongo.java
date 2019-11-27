package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TrackMongo { //Defining attributes of table Tracks
	private String trackID;
	private String trackTitle;
	private String songID;
	private String albumName;
	private String artistID;
	private String artistMBID;
	private String artistName;
	private double duration;
	private double artistFamiliarity;
	private double artistHotness;
	private int year;
	private String location;
	private String city;
	private String state;
	private String genre;
	
	public String getTrackID() {
		return trackID;
	}
	public void setTrackID(String trackID) {
		this.trackID = trackID;
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	public String getSongID() {
		return songID;
	}
	public void setSongID(String songID) {
		this.songID = songID;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getArtistID() {
		return artistID;
	}
	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}
	public String getArtistMBID() {
		return artistMBID;
	}
	public void setArtistMBID(String artistMBID) {
		this.artistMBID = artistMBID;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getArtistFamiliarity() {
		return artistFamiliarity;
	}
	public void setArtistFamiliarity(double artistFamiliarity) {
		this.artistFamiliarity = artistFamiliarity;
	}
	public double getArtistHotness() {
		return artistHotness;
	}
	public void setArtistHotness(double artistHotness) {
		this.artistHotness = artistHotness;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
