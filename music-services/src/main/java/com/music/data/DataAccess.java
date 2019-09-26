package com.music.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.music.dto.Artist;
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
	
	public static String returnData(){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from testtable");
			
			String data = "";
			while (myRs.next()) {
				data = data + "" + myRs.getString("UIN") + ", " + myRs.getString("Name");
			}
			
			return data;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		
		return "Error!";
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

}
