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
	    dataSource.setServerName("18.189.129.189");//Enter IP Address of the machine that holds the database here
	    dataSource.setPortNumber(3306);//Port of MySql server
	    dataSource.setDatabaseName("project");//Name of the Database
	    dataSource.setUser("msd");//Username
	    dataSource.setPassword("some_pass");//Password
	    return dataSource;
	  }
	
	public List<ArtistState> getArtistState(String state, String genre){ //Takes state and genre input
		try {
			Connection myCon = getMysqlDataSource().getConnection(); //Connection with AWS SQL server
			
			Statement statement = myCon.createStatement(); //Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from ArtistState where State = '" + state + "' and Genre in ('" 
			+ genre + "') order by Rank limit 3" ); //SQL query to get data from a particular state in the genre given
			
			List<ArtistState> artists = new ArrayList<ArtistState>(); //Create a new list of ArtistSate to store details
			
			while (myRs.next()) {
				ArtistState artist = new ArtistState(); //Create a new object of ArtistSate to get details
				artist.setState(myRs.getString("State"));
				artist.setGenre(myRs.getString("Genre"));
				artist.setArtistID(myRs.getString("ArtistID"));
				artist.setArtistFamiliarity(myRs.getString("ArtistFamiliarity"));
				artist.setArtistHotness(myRs.getString("ArtistHotness"));
				artist.setOverallValue(myRs.getString("OverallValue"));
				artist.setRank(myRs.getInt("Rank"));
			
				artists.add(artist); //adding ArtistSate object to the ArtistSate list
			}
			
			return artists;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<ArtistState> artists = new ArrayList<ArtistState>();
		return artists;
	}
	
	public List<ArtistCity> getArtistCity(String city, String genre){ //Takes city and genre input
		try {
			Connection myCon = getMysqlDataSource().getConnection(); //Connection with AWS SQL server
			
			Statement statement = myCon.createStatement(); //Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from ArtistCity where City = '" + city + "' and Genre in ('" 
			+ genre + "') order by Rank limit 3" ); //SQL query to get data from a particular city in the genre given
			
			List<ArtistCity> artistSCity = new ArrayList<ArtistCity>(); //Create a new list of ArtistCity to store details
			
			while (myRs.next()) {
				ArtistCity artistCity = new ArtistCity(); //Create a new object of ArtistCity to get details
				artistCity.setCity(myRs.getString("City"));
				artistCity.setGenre(myRs.getString("Genre"));
				artistCity.setArtistID(myRs.getString("ArtistID"));
				artistCity.setArtistFamiliarity(myRs.getString("ArtistFamiliarity"));
				artistCity.setArtistHotness(myRs.getString("ArtistHotness"));
				artistCity.setOverallValue(myRs.getString("OverallValue"));
				artistCity.setRank(myRs.getInt("Rank"));
			
				artistSCity.add(artistCity); //adding ArtistCity object to the ArtistCity list
			}
			
			return artistSCity;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<ArtistCity> artistSCity = new ArrayList<ArtistCity>();
		return artistSCity;
	}
	
	public List<User> getUsers(String userId){ //Takes user ID as input
		try {
			Connection myCon = getMysqlDataSource().getConnection(); //Connection with AWS SQL server
			
			Statement statement = myCon.createStatement();//Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from Users where UserID = '" + userId + "' order by Rank");
			//SQL query to get data from a particular user ID and sort it by Rank
			
			List<User> users = new ArrayList<User>(); //Create a new list of User to store details
			
			while (myRs.next()) {
				User user = new User(); //Create a new object of User to get details
				user.setUserID(myRs.getString("UserID"));
				user.setGenre(myRs.getString("genre"));
				user.setCount(myRs.getInt("Count"));
				user.setRank(myRs.getInt("Rank"));
			
				users.add(user); //adding User object to the User list
			}
			
			return users;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<User> users = new ArrayList<User>();
		return users;
	}

	public List<Event> getEventsCity(String city, String genre){ //Takes city and genre input for the Event
		try {
			Connection myCon = getMysqlDataSource().getConnection(); //Connection with AWS SQL server
			
			Statement statement = myCon.createStatement(); //Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from Events where VenueCity = '" + city + "' and Genre = '" 
			+ genre + "' order by EventDate"); 
			//SQL query to get data from a particular city in the genre given for Events and sort by EventDate
			
			List<Event> eventSCity = new ArrayList<Event>(); //Create a new list of Event to store details
			
			while (myRs.next()) {
				Event eventCity = new Event(); //Create a new object of Event to get details
				eventCity.setArtistMBID(myRs.getString("ArtistMBID"));
				eventCity.setArtistName(myRs.getString("ArtistName"));
				eventCity.setTourName(myRs.getString("TourName"));
				eventCity.setVenueCity(myRs.getString("VenueCity"));
				eventCity.setVenueState(myRs.getString("VenueState"));
				eventCity.setEventDate(myRs.getString("EventDate"));
				eventCity.setVenueStateCode(myRs.getString("VenueStateCode"));
				eventCity.setVenueName(myRs.getString("VenueName"));
				eventCity.setGenre(myRs.getString("Genre"));
							
				eventSCity.add(eventCity); //adding Event object to the Event list
			}
			
			return eventSCity;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Event> eventSCity = new ArrayList<Event>();
		return eventSCity;
	}
	
	public List<Event> getEventsState(String state, String genre){ //Takes state and genre input for the Event
		try {
			Connection myCon = getMysqlDataSource().getConnection(); //Connection with AWS SQL server
			
			Statement statement = myCon.createStatement(); //Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from Events where VenueState = '" + state + "' and Genre = '" 
			+ genre + "' order by EventDate"); 
			//SQL query to get data from a particular state in the genre given for Events and sort by EventDate
			
			List<Event> eventSState = new ArrayList<Event>(); //Create a new list of Event to store details
			
			while (myRs.next()) {
				Event eventState = new Event(); //Create a new object of Event to get details
				eventState.setArtistMBID(myRs.getString("ArtistMBID"));
				eventState.setArtistName(myRs.getString("ArtistName"));
				eventState.setTourName(myRs.getString("TourName"));
				eventState.setVenueCity(myRs.getString("VenueCity"));
				eventState.setVenueState(myRs.getString("VenueState"));
				eventState.setEventDate(myRs.getString("EventDate"));
				eventState.setVenueStateCode(myRs.getString("VenueStateCode"));
				eventState.setVenueName(myRs.getString("VenueName"));
				eventState.setGenre(myRs.getString("Genre"));
							
				eventSState.add(eventState); //adding Event object to the Event list
			}
			
			return eventSState;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Event> eventSState = new ArrayList<Event>();
		return eventSState;
	}
	
	public List<Track> getTracks(String artistId){ //Takes artist ID as input
		try {
			Connection myCon = getMysqlDataSource().getConnection();//Connection with AWS SQL server
			
			Statement statement = myCon.createStatement();//Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from Tracks where ArtistID = '" + artistId 
					+ "' order by ArtistFamiliarity,ArtistHotness desc  limit 3");
			//SQL query to get data from a particular artist ID and sort it by ArtistFamiliarity and ArtistHotness with 3 output
			
			List<Track> tracks = new ArrayList<Track>(); //Create a new list of Track to store details
			
			while (myRs.next()) {
				Track track = new Track(); //Create a new object of Track to get details
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
			
				tracks.add(track); //adding Track object to the Track list
			}
			
			return tracks;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Track> tracks = new ArrayList<Track>();
		return tracks;
	}
	
	public List<Track> getTracksForSearch(String keyword){ //Takes keyword for search as input
		try {
			Connection myCon = getMysqlDataSource().getConnection(); //Connection with AWS SQL server
			
			Statement statement = myCon.createStatement(); //Connection with AWS SQL server
			
			ResultSet myRs = statement.executeQuery("select * from Tracks where lower(Genre) like '%" 
			+ keyword + "%' or lower(ArtistName) like '%" 
			+ keyword + "%' or lower(TrackTitle) like '%" 
			+ keyword + "%' or lower(AlbumName) like '%" 
			+ keyword + "%' limit 10");
			//SQL query to get matching results with the keyword and displaying 10 output
			
			List<Track> tracks = new ArrayList<Track>(); //Create a new list of Track to store details
			
			while (myRs.next()) {
				Track track = new Track(); //Create a new object of Track to get details
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
			
				tracks.add(track); //adding Track object to the Track list
			}
			
			return tracks; 
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Track> tracks = new ArrayList<Track>();
		return tracks;
	}

}
