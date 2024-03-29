package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Track { //Defining attributes of table Tracks
	private String TrackID;
	private String TrackTitle;
	private String SongID;
	private String AlbumName;
	private String ArtistID;
	private String ArtistMBID;
	private String ArtistName;
	private double Duration;
	private double ArtistFamiliarity;
	private double ArtistHotness;
	private int Year;
	private String Location;
	private String City;
	private String State;
	private String Genre;
	
	public String getTrackID() {
		return TrackID;
	}
	public void setTrackID(String trackID) {
		this.TrackID = trackID;
	}
	public String getTrackTitle() {
		return TrackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.TrackTitle = trackTitle;
	}
	public String getSongID() {
		return SongID;
	}
	public void setSongID(String songID) {
		this.SongID = songID;
	}
	public String getAlbumName() {
		return AlbumName;
	}
	public void setAlbumName(String albumName) {
		this.AlbumName = albumName;
	}
	public String getArtistID() {
		return ArtistID;
	}
	public void setArtistID(String artistID) {
		this.ArtistID = artistID;
	}
	public String getArtistMBID() {
		return ArtistMBID;
	}
	public void setArtistMBID(String artistMBID) {
		this.ArtistMBID = artistMBID;
	}
	public String getArtistName() {
		return ArtistName;
	}
	public void setArtistName(String artistName) {
		this.ArtistName = artistName;
	}
	public double getDuration() {
		return Duration;
	}
	public void setDuration(double duration) {
		this.Duration = duration;
	}
	public double getArtistFamiliarity() {
		return ArtistFamiliarity;
	}
	public void setArtistFamiliarity(double artistFamiliarity) {
		this.ArtistFamiliarity = artistFamiliarity;
	}
	public double getArtistHotness() {
		return ArtistHotness;
	}
	public void setArtistHotness(double artistHotness) {
		this.ArtistHotness = artistHotness;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		this.Year = year;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		this.Location = location;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		this.State = state;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		this.Genre = genre;
	}
	
	
	

}
