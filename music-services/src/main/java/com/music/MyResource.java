package com.music;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	public static DataSource getMysqlDataSource() {
	    MysqlDataSource dataSource = new MysqlDataSource();

	    // Set dataSource Properties
//	    System.setProperty("https.proxyHost", "myProxy");
//	    System.setProperty("https.proxyPort", "80");
	    dataSource.setServerName("172.17.100.216");//172.17.105.75
	    dataSource.setPortNumber(3306);
	    dataSource.setDatabaseName("testtable");
	    dataSource.setUser("root");
	    dataSource.setPassword("");
	    return dataSource;
	  }
	

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
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
    	
    	
    	return "Got It!";
    }
}
