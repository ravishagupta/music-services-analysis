package com.music.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.music.data.DataAccess;
import com.music.dto.Artist;
import com.music.dto.Event;
import com.music.dto.User;




/**
 * Root resource (exposed at "musicresources" path)
 */
@Path("musicresources")
public class Controller {

    /**
     * Methods handling HTTP GET requests. The returned object will be sent
     * to the client as "APPLICATION_JSON" media type.
     */
   
    @GET
    @Path("/artists/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getArtists(@PathParam("city") String city) {
    	DataAccess dataAccess = new DataAccess();
    	List<Artist> artists = dataAccess.getArtists(city);
    	return artists;
    	
    }
    
    @GET
    @Path("/users/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@PathParam("userId") int userId) {
    	DataAccess dataAccess = new DataAccess();
    	List<User> artists = dataAccess.getUsers(userId);
    	return artists;
    	
    }
    
    @GET
    @Path("/events/{eventCity}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEvents(@PathParam("eventCity") String eventCity) {
    	DataAccess dataAccess = new DataAccess();
    	List<Event> events = dataAccess.getEvents(eventCity);
    	return events;
    	
    }
}
