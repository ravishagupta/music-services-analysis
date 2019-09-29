package com.music.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.music.data.DataAccess;
import com.music.dto.ArtistCity;
import com.music.dto.ArtistState;
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
    @Path("/artists/{state}/{genre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArtistState> getArtistState(@PathParam("state") String state, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<ArtistState> artists = dataAccess.getArtistState(state, genre);
    	return artists; 	
    }
    
    @GET
    @Path("/artists/{city}/{genre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArtistCity> getArtistCity(@PathParam("city") String city, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<ArtistCity> artistSCity = dataAccess.getArtistCity(city, genre);
    	return artistSCity; 	
    }
    
    @GET
    @Path("/users/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@PathParam("userId") String userId) {
    	DataAccess dataAccess = new DataAccess();
    	List<User> artists = dataAccess.getUsers(userId);
    	return artists;
    	
    }
    
    @GET
    @Path("/events/{city}/{genre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsCity(@PathParam("city") String city, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<Event> eventSCity = dataAccess.getEventsCity(city, genre);
    	return eventSCity;
    	
    }
}
