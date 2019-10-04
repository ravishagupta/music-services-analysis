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
import com.music.dto.Track;
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
    @Path("/artistsState/{state}/{genre}")  //Path to search artist details with state and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArtistState> getArtistState(@PathParam("state") String state, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<ArtistState> artists = dataAccess.getArtistState(state, genre);
    	return artists; 	
    }
    
    @GET
    @Path("/artistsCity/{city}/{genre}") //Path to search artist details with city and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArtistCity> getArtistCity(@PathParam("city") String city, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<ArtistCity> artistSCity = dataAccess.getArtistCity(city, genre);
    	return artistSCity; 	
    }
    
    @GET
    @Path("/users/{userId}") //Path to search user details with user ID
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@PathParam("userId") String userId) {
    	DataAccess dataAccess = new DataAccess();
    	List<User> users = dataAccess.getUsers(userId);
    	return users;
    	
    }
    
    @GET
    @Path("/eventsCity/{city}/{genre}") //Path to search events details with city and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsCity(@PathParam("city") String city, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<Event> eventSCity = dataAccess.getEventsCity(city, genre);
    	return eventSCity;
    	
    }
    
    @GET
    @Path("/eventsState/{state}/{genre}") //Path to search events details with state and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsState(@PathParam("state") String state, @PathParam("genre") String genre) {
    	DataAccess dataAccess = new DataAccess();
    	List<Event> eventSState = dataAccess.getEventsState(state, genre);
    	return eventSState;
    	
    }
    
    @GET
    @Path("/tracks/{artistId}") //Path to search tracks details with artist ID
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracks(@PathParam("artistId") String artistId) {
    	DataAccess dataAccess = new DataAccess();
    	List<Track> tracks = dataAccess.getTracks(artistId);
    	return tracks;
    	
    }
    
    @GET
    @Path("/tracksSearch/{keyword}") //Path to search tracks details with keyword
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracksForSearch(@PathParam("keyword") String keyword) {
    	DataAccess dataAccess = new DataAccess();
    	List<Track> tracks = dataAccess.getTracksForSearch(keyword);
    	return tracks;
    	
    }
    
    
}
