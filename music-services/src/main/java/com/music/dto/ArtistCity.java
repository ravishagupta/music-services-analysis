package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArtistCity { //Defining attributes of table ArtistCity
	
	private String City;
	private String Genre;
	private String ArtistID;
	private String ArtistFamiliarity;
	private String ArtistHotness;
	private String OverallValue;
	private double Rank;
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getArtistID() {
		return ArtistID;
	}
	public void setArtistID(String artistID) {
		ArtistID = artistID;
	}
	public String getArtistFamiliarity() {
		return ArtistFamiliarity;
	}
	public void setArtistFamiliarity(String artistFamiliarity) {
		ArtistFamiliarity = artistFamiliarity;
	}
	public String getArtistHotness() {
		return ArtistHotness;
	}
	public void setArtistHotness(String artistHotness) {
		ArtistHotness = artistHotness;
	}
	public String getOverallValue() {
		return OverallValue;
	}
	public void setOverallValue(String overallValue) {
		OverallValue = overallValue;
	}
	public double getRank() {
		return Rank;
	}
	public void setRank(double rank) {
		Rank = rank;
	}

}
