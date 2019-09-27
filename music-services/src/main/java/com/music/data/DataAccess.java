package com.music.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.music.dto.Artist;
import com.music.dto.Event;
import com.music.dto.User;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DataAccess {
	
	public static DataSource getMysqlDataSource() {
	    MysqlDataSource dataSource = new MysqlDataSource();

	    // Set dataSource Properties
	    //dataSource.setServerName("172.17.100.216");//Enter IP Address of the machine that holds the database here
	    dataSource.setServerName("127.0.0.1");
	    dataSource.setPortNumber(3306);//Port of MySql server
	    dataSource.setDatabaseName("musiclibrary");//Name of the Database
	    dataSource.setUser("root");//Username
	    dataSource.setPassword("Sweety123");//Password
	    return dataSource;
	  }
	
	public List<Artist> getArtists(String city){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from artist where artist_city = '" + city + "'");
			
			List<Artist> artists = new ArrayList<Artist>();
			
			while (myRs.next()) {
				Artist artist = new Artist();
				artist.setArtist_id(myRs.getInt("artist_id"));
				artist.setArtist_name(myRs.getString("artist_name"));
				artist.setArtist_city(myRs.getString("artist_city"));
				artist.setArtist_state(myRs.getString("artist_state"));
				artist.setGenre(myRs.getString("genre"));
				artist.setArtist_rank(myRs.getInt("artist_rank"));
			
				artists.add(artist);
			}
			
			return artists;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Artist> artists = new ArrayList<Artist>();
		return artists;
	}
	
	public List<User> getUsers(int userId){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from user where user_id = '" + userId + "'");
			
			List<User> users = new ArrayList<User>();
			
			while (myRs.next()) {
				User user = new User();
				user.setUser_id(myRs.getInt("user_id"));
				user.setGenre(myRs.getString("genre"));
				user.setRank_for_genre(myRs.getInt("rank_for_genre"));
			
				users.add(user);
			}
			
			return users;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<User> users = new ArrayList<User>();
		return users;
	}

	public List<Event> getEvents(String eventCity){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from events where event_city = '" + eventCity + "' ");
			
			List<Event> events = new ArrayList<Event>();
			
			while (myRs.next()) {
				Event event = new Event();
				event.setEvent_name(myRs.getString("event_name"));
				event.setGenre(myRs.getString("genre"));
				event.setEvent_city(myRs.getString("event_city"));
				event.setEvent_state(myRs.getString("event_state"));
				event.setEvent_venue(myRs.getString("event_venue"));
				event.setEvent_date(myRs.getDate("event_date"));
				event.setArtist_name(myRs.getString("artist_name"));
			
			
				events.add(event);
			}
			
			return events;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		List<Event> events = new ArrayList<Event>();
		return events;
	}

}
