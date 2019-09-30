package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Track {
	private String TrackID;
	private String TrackTitle;
	private String SongID;
	private String AlbumName;
	private String ArtistID;
	private String ArtistMBID;
	private String ArtistName;
	private float Duration;
	private float ArtistFamiliarity;
	private float ArtistHotness;
	private int Year;
	private String Location;
	private String City;
	private String State;
	private String Genre;
	public String getTrackID() {
		return TrackID;
	}
	public void setTrackID(String trackID) {
		TrackID = trackID;
	}
	public String getTrackTitle() {
		return TrackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		TrackTitle = trackTitle;
	}
	public String getSongID() {
		return SongID;
	}
	public void setSongID(String songID) {
		SongID = songID;
	}
	public String getAlbumName() {
		return AlbumName;
	}
	public void setAlbumName(String albumName) {
		AlbumName = albumName;
	}
	public String getArtistID() {
		return ArtistID;
	}
	public void setArtistID(String artistID) {
		ArtistID = artistID;
	}
	public String getArtistMBID() {
		return ArtistMBID;
	}
	public void setArtistMBID(String artistMBID) {
		ArtistMBID = artistMBID;
	}
	public String getArtistName() {
		return ArtistName;
	}
	public void setArtistName(String artistName) {
		ArtistName = artistName;
	}
	public float getDuration() {
		return Duration;
	}
	public void setDuration(float duration) {
		Duration = duration;
	}
	public float getArtistFamiliarity() {
		return ArtistFamiliarity;
	}
	public void setArtistFamiliarity(float artistFamiliarity) {
		ArtistFamiliarity = artistFamiliarity;
	}
	public float getArtistHotness() {
		return ArtistHotness;
	}
	public void setArtistHotness(float artistHotness) {
		ArtistHotness = artistHotness;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	
	
	

}
