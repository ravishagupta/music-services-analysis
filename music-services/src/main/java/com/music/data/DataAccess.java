package com.music.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.music.dto.ArtistCity;
import com.music.dto.ArtistState;
import com.music.dto.Event;
import com.music.dto.Track;
import com.music.dto.User;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DataAccess {
	
	public static DataSource getMysqlDataSource() {
	    MysqlDataSource dataSource = new MysqlDataSource();

	    // Set dataSource Properties
	    //dataSource.setServerName("172.17.100.216");//Enter IP Address of the machine that holds the database here
	    dataSource.setServerName("18.189.129.189");
	    dataSource.setPortNumber(3306);//Port of MySql server
	    dataSource.setDatabaseName("project");//Name of the Database
	    dataSource.setUser("msd");//Username
	    dataSource.setPassword("some_pass");//Password
	    return dataSource;
	  }
	
	public List<ArtistState> getArtistState(String state, String genre){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from ArtistState where State = '" + state + "' and Genre in ('" 
			+ genre + "')" );
			
			List<ArtistState> artists = new ArrayList<ArtistState>();
			
			while (myRs.next()) {
				ArtistState artist = new ArtistState();
				artist.setState(myRs.getString("State"));
				artist.setGenre(myRs.getString("Genre"));
				artist.setArtistID(myRs.getString("ArtistID"));
				artist.setArtistFamiliarity(myRs.getString("ArtistFamiliarity"));
				artist.setArtistHotness(myRs.getString("ArtistHotness"));
				artist.setOverallValue(myRs.getString("OverallValue"));
				artist.setRank(myRs.getInt("Rank"));
			
				artists.add(artist);
			}
			
			return artists;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<ArtistState> artists = new ArrayList<ArtistState>();
		return artists;
	}
	
	public List<ArtistCity> getArtistCity(String city, String genre){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from ArtistCity where City = '" + city + "' and Genre in ('" 
			+ genre + "')" );
			
			List<ArtistCity> artistSCity = new ArrayList<ArtistCity>();
			
			while (myRs.next()) {
				ArtistCity artistCity = new ArtistCity();
				artistCity.setCity(myRs.getString("City"));
				artistCity.setGenre(myRs.getString("Genre"));
				artistCity.setArtistID(myRs.getString("ArtistID"));
				artistCity.setArtistFamiliarity(myRs.getString("ArtistFamiliarity"));
				artistCity.setArtistHotness(myRs.getString("ArtistHotness"));
				artistCity.setOverallValue(myRs.getString("OverallValue"));
				artistCity.setRank(myRs.getInt("Rank"));
			
				artistSCity.add(artistCity);
			}
			
			return artistSCity;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<ArtistCity> artistSCity = new ArrayList<ArtistCity>();
		return artistSCity;
	}
	
	public List<User> getUsers(String userId){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from Users where UserID = '" + userId + "' order by Rank");
			
			List<User> users = new ArrayList<User>();
			
			while (myRs.next()) {
				User user = new User();
				user.setUserID(myRs.getString("UserID"));
				user.setGenre(myRs.getString("genre"));
				user.setCount(myRs.getInt("Count"));
				user.setRank(myRs.getInt("Rank"));
			
				users.add(user);
			}
			
			return users;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<User> users = new ArrayList<User>();
		return users;
	}

	public List<Event> getEventsCity(String city, String genre){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from Events where VenueCity = '" + city + "' and Genre = '" 
			+ genre + "'");
			
			List<Event> eventSCity = new ArrayList<Event>();
			
			while (myRs.next()) {
				Event eventCity = new Event();
				eventCity.setArtistMBID(myRs.getString("ArtistMBID"));
				eventCity.setArtistName(myRs.getString("ArtistName"));
				eventCity.setTourName(myRs.getString("TourName"));
				eventCity.setVenueCity(myRs.getString("VenueCity"));
				eventCity.setVenueState(myRs.getString("VenueState"));
				eventCity.setEventDate(myRs.getString("EventDate"));
				eventCity.setVenueStateCode(myRs.getString("VenueStateCode"));
				eventCity.setVenueName(myRs.getString("VenueName"));
				eventCity.setGenre(myRs.getString("Genre"));
							
				eventSCity.add(eventCity);
			}
			
			return eventSCity;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Event> eventSCity = new ArrayList<Event>();
		return eventSCity;
	}
	
	public List<Event> getEventsState(String state, String genre){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from Events where VenueState = '" + state + "' and Genre = '" 
			+ genre + "'");
			
			List<Event> eventSState = new ArrayList<Event>();
			
			while (myRs.next()) {
				Event eventState = new Event();
				eventState.setArtistMBID(myRs.getString("ArtistMBID"));
				eventState.setArtistName(myRs.getString("ArtistName"));
				eventState.setTourName(myRs.getString("TourName"));
				eventState.setVenueCity(myRs.getString("VenueCity"));
				eventState.setVenueState(myRs.getString("VenueState"));
				eventState.setEventDate(myRs.getString("EventDate"));
				eventState.setVenueStateCode(myRs.getString("VenueStateCode"));
				eventState.setVenueName(myRs.getString("VenueName"));
				eventState.setGenre(myRs.getString("Genre"));
							
				eventSState.add(eventState);
			}
			
			return eventSState;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Event> eventSState = new ArrayList<Event>();
		return eventSState;
	}
	
	public List<Track> getTracks(String artistId){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from Tracks where ArtistID = '" + artistId 
					+ "' order by ArtistFamiliarity,ArtistHotness desc");
			
			List<Track> tracks = new ArrayList<Track>();
			
			while (myRs.next()) {
				Track track = new Track();
				track.setTrackID(myRs.getString("TrackID"));
				track.setTrackTitle(myRs.getString("TrackTitle"));
				track.setSongID(myRs.getString("SongID"));
				track.setAlbumName(myRs.getString("AlbumName"));
				track.setArtistID(myRs.getString("ArtistID"));
				track.setArtistMBID(myRs.getString("ArtistMBID"));
				track.setArtistName(myRs.getString("ArtistName"));
				track.setDuration(myRs.getFloat("Duration"));
				track.setArtistFamiliarity(myRs.getFloat("ArtistFamiliarity"));
				track.setArtistHotness(myRs.getFloat("ArtistHotness"));
				track.setYear(myRs.getInt("Year"));
				track.setLocation(myRs.getString("Location"));
				track.setCity(myRs.getString("City"));
				track.setState(myRs.getString("State"));
				track.setGenre(myRs.getString("Genre"));
			
				tracks.add(track);
			}
			
			return tracks;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Track> tracks = new ArrayList<Track>();
		return tracks;
	}
	
	public List<Track> getTracksForSearch(String keyword){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from Tracks where lower(Genre) like '%" 
			+ keyword + "%' limit 10");
			
			List<Track> tracks = new ArrayList<Track>();
			
			while (myRs.next()) {
				Track track = new Track();
				track.setTrackID(myRs.getString("TrackID"));
				track.setTrackTitle(myRs.getString("TrackTitle"));
				track.setSongID(myRs.getString("SongID"));
				track.setAlbumName(myRs.getString("AlbumName"));
				track.setArtistID(myRs.getString("ArtistID"));
				track.setArtistMBID(myRs.getString("ArtistMBID"));
				track.setArtistName(myRs.getString("ArtistName"));
				track.setDuration(myRs.getFloat("Duration"));
				track.setArtistFamiliarity(myRs.getFloat("ArtistFamiliarity"));
				track.setArtistHotness(myRs.getFloat("ArtistHotness"));
				track.setYear(myRs.getInt("Year"));
				track.setLocation(myRs.getString("Location"));
				track.setCity(myRs.getString("City"));
				track.setState(myRs.getString("State"));
				track.setGenre(myRs.getString("Genre"));
			
				tracks.add(track);
			}
			
			return tracks;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Track> tracks = new ArrayList<Track>();
		return tracks;
	}

}
