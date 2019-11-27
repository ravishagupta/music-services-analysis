package com.music.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.music.data.DataAccess;
import com.music.data.DataAccessMongo;
import com.music.dto.ArtistCity;
import com.music.dto.ArtistState;
import com.music.dto.Event;
import com.music.dto.Track;
import com.music.dto.TrackMongo;
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
    
    //*******************************************************MONGO ENDPOINTS*************************************************
    
    
    @GET
    @Path("/artistsStateMongo/{state}/{genre}")  //Path to search artist details with state and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArtistState> getArtistStateMongo(@PathParam("state") String state, @PathParam("genre") String genre) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<ArtistState> artists = dataAccessMongo.getArtistState(state, genre);
    	return artists; 	
    }
    
    @GET
    @Path("/artistsCityMongo/{city}/{genre}")  //Path to search artist details with state and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArtistCity> getArtistCityMongo(@PathParam("city") String city, @PathParam("genre") String genre) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<ArtistCity> artists = dataAccessMongo.getArtistCity(city, genre);
    	return artists; 	
    }
    
    @GET
    @Path("/usersMongo/{userId}") //Path to search user details with user ID
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersMongo(@PathParam("userId") String userId) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<User> users = dataAccessMongo.getUsers(userId);
    	return users;
    	
    }
    
    @GET
    @Path("/eventsCityMongo/{city}/{genre}") //Path to search events details with city and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsCityMongo(@PathParam("city") String city, @PathParam("genre") String genre) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<Event> eventSCity = dataAccessMongo.getEventsCity(city, genre);
    	return eventSCity;
    	
    }
    
    @GET
    @Path("/eventsStateMongo/{state}/{genre}") //Path to search events details with state and genre
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsStateMongo(@PathParam("state") String state, @PathParam("genre") String genre) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<Event> eventSState = dataAccessMongo.getEventsState(state, genre);
    	return eventSState;
    	
    }
    
    @GET
    @Path("/tracksMongo/{artistId}") //Path to search tracks details with artist ID
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracksMongo(@PathParam("artistId") String artistId) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<Track> tracks = dataAccessMongo.getTracks(artistId);
    	return tracks;
    	
    }
    
    @GET
    @Path("/tracksSearchMongo/{keyword}") //Path to search tracks details with keyword
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracksForSearchMongo(@PathParam("keyword") String keyword) {
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	List<Track> tracks = dataAccessMongo.getTracksForSearch(keyword);
    	return tracks;
    	
    }
    
    @POST
    @Path("/insertTrackMongo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertTrackMongo(TrackMongo track) {
    	System.out.println("trackId = " + track.getTrackID());
    	DataAccessMongo dataAccessMongo = new DataAccessMongo();
    	return dataAccessMongo.insertTrackMongo(track);    	
    }
}
