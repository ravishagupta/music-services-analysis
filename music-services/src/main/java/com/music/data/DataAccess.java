package com.music.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataAccess {
	
	public static DataSource getMysqlDataSource() {
	    MysqlDataSource dataSource = new MysqlDataSource();

	    // Set dataSource Properties
	    dataSource.setServerName("172.17.100.216");//Enter IP Address of the machine that holds the database here
	    dataSource.setPortNumber(3306);//Port of MySql server
	    dataSource.setDatabaseName("testtable");//Name of the Database
	    dataSource.setUser("root");//Username
	    dataSource.setPassword("");//Password
	    return dataSource;
	  }
	
	public static String returnData(){
		try {
			Connection myCon = getMysqlDataSource().getConnection();
			
			Statement statement = myCon.createStatement();
			
			ResultSet myRs = statement.executeQuery("select * from testtable");
			
			String data = "";
			while (myRs.next()) {
				data = data + "" + myRs.getString("IUCR") + ", " + myRs.getString("PD");
			}
			
			return data;
			
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		
		return "Error!";
	}

}
