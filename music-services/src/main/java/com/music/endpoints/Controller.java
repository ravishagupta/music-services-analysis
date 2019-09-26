package com.music.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.music.data.DataAccess;
import com.music.dto.Artist;
import com.music.dto.User;




/**
 * Root resource (exposed at "musicresources" path)
 */
@Path("musicresources")
public class Controller {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
      	String textResponse = DataAccess.returnData();
    	return textResponse;
    }
    
    @GET
    @Path("/artists/{city}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Artist> getArtists(@PathParam("city") String city) {
    	DataAccess dataAccess = new DataAccess();
    	List<Artist> artists = dataAccess.getArtists(city);
    	return artists;
    	
    }
    
    @GET
    @Path("/users/{userId}")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers(@PathParam("userId") int userId) {
    	DataAccess dataAccess = new DataAccess();
    	List<User> artists = dataAccess.getUsers(userId);
    	return artists;
    	
    }
}
