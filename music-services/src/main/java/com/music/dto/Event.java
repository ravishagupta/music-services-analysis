package com.music.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event {
	private String ArtistMBID;
	private String ArtistName;
	private String TourName;
	private String VenueCity;
	private String VenueState;
	private Date EventDate;
	private String VenueStateCode;
	private String VenueName;
	private String Genre;
	
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
	public String getTourName() {
		return TourName;
	}
	public void setTourName(String tourName) {
		TourName = tourName;
	}
	public String getVenueCity() {
		return VenueCity;
	}
	public void setVenueCity(String venueCity) {
		VenueCity = venueCity;
	}
	public String getVenueState() {
		return VenueState;
	}
	public void setVenueState(String venueState) {
		VenueState = venueState;
	}
	public Date getEventDate() {
		return EventDate;
	}
	public void setEventDate(Date eventDate) {
		EventDate = eventDate;
	}
	public String getVenueStateCode() {
		return VenueStateCode;
	}
	public void setVenueStateCode(String venueStateCode) {
		VenueStateCode = venueStateCode;
	}
	public String getVenueName() {
		return VenueName;
	}
	public void setVenueName(String venueName) {
		VenueName = venueName;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	

}
