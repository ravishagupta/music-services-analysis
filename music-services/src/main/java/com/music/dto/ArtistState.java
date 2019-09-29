package com.music.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArtistState {
	
	private String State;
	private String Genre;
	private String ArtistID;
	private String ArtistFamiliarity;
	private String ArtistHotness;
	private String OverallValue;
	private int Rank;
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
	public int getRank() {
		return Rank;
	}
	public void setRank(int rank) {
		Rank = rank;
	}
	
	
}
