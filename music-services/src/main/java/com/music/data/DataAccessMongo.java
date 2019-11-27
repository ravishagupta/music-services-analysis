package com.music.data;

import static com.mongodb.client.model.Sorts.ascending;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.music.dto.ArtistCity;
import com.music.dto.ArtistState;
import com.music.dto.Event;
import com.music.dto.Track;
import com.music.dto.TrackMongo;
import com.music.dto.User;

public class DataAccessMongo {
	
	public static MongoClient getMongoDataSource() {
		//Establishing connection with MongoDB
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
		return mongoClient;
	
	  }
	
	public List<ArtistState> getArtistState(String state, String genre){ //Takes state and genre input
		MongoClient mongoClient = getMongoDataSource();
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("ArtistState");

		//"select * from ArtistState where State = '" + state + "' and Genre in ('" 
		//+ genre + "') order by Rank limit 3" ); 
	    //SQL query to get data from a particular state in the genre given
		
	    List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("state", state));
		criteria.add(new BasicDBObject("Genre", genre));
		
		Bson sort = ascending("rank");
		FindIterable<Document> documents = collection.find(new BasicDBObject("$and", criteria)).sort(sort).limit(3);
		
		List<ArtistState> artists = new ArrayList<ArtistState>(); //Create a new list of ArtistSate to store details
		
		for(Document doc : documents) {
			ArtistState artist = new ArtistState(); //Create a new object of ArtistSate to get details

			artist.setState((String) doc.get("state"));
			artist.setGenre((String) doc.get("Genre"));
			artist.setArtistID((String) doc.get("artist_id"));
			artist.setArtistFamiliarity(String.valueOf(doc.get("artist_familiarity")) );
			artist.setArtistHotness(String.valueOf(doc.get("artist_hotness")));
			artist.setOverallValue(String.valueOf(doc.get("overall_value")));
			artist.setRank((double) (doc.get("rank")));
		
			artists.add(artist); //adding ArtistSate object to the ArtistSate list
		}
		
		return artists;
		
	}
	
	public List<ArtistCity> getArtistCity(String city, String genre){ //Takes city and genre input
	
			MongoClient mongoClient = getMongoDataSource();
			
			MongoDatabase database = mongoClient.getDatabase("music");
	
		    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("ArtistCity");
			
			//"select * from ArtistCity where City = '" + city + "' and Genre in ('" 
			//+ genre + "') order by Rank limit 3" 
			//SQL query to get data from a particular city in the genre given
			
		    List<DBObject> criteria = new ArrayList<DBObject>();
			criteria.add(new BasicDBObject("city", city));
			criteria.add(new BasicDBObject("Genre", genre));
			
			//MongoCursor<Document> cursor = collection.find(new BasicDBObject("$and", criteria)).iterator();
			Bson sort = ascending("rank");
			
			FindIterable<Document> documents = collection.find(new BasicDBObject("$and", criteria)).sort(sort).limit(3);
			
			List<ArtistCity> artistSCity = new ArrayList<ArtistCity>(); //Create a new list of ArtistCity to store details
			
			for(Document document : documents)  {
				ArtistCity artist = new ArtistCity(); //Create a new object of ArtistCity to get details

				artist.setCity((String) document.get("city"));
				artist.setGenre((String) document.get("Genre"));
				artist.setArtistID((String) document.get("artist_id"));
				artist.setArtistFamiliarity(String.valueOf(document.get("artist_familiarity")));
				artist.setArtistHotness(String.valueOf(document.get("artist_hotness")));
				artist.setOverallValue(String.valueOf(document.get("overall_value")));
				artist.setRank((int) (document.get("rank")));
			
				artistSCity.add(artist); //adding ArtistSate object to the ArtistSate list
			}
			
		
		return artistSCity;
	}
	
	public List<User> getUsers(String userId){ //Takes user ID as input
		MongoClient mongoClient = getMongoDataSource();
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("Users");
		
	    //"select * from Users where UserID = '" + userId + "' order by Rank");
		//SQL query to get data from a particular user ID and sort it by Rank
		
	    List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("uuid", userId));
		
		Bson sort = ascending("rank");
		
		FindIterable<Document> documents = collection.find(new BasicDBObject("$and", criteria)).sort(sort);
	    
		List<User> users = new ArrayList<User>(); //Create a new list of User to store details
		
		for(Document document : documents)  {
			User user = new User(); //Create a new object of User to get details
			
			user.setUserID((String) document.get("uuid"));
			user.setGenre((String) document.get("Genre"));
			user.setCount((int) document.get("count"));
			user.setRank((double) document.get("rank"));

			users.add(user); //adding User object to the User list
		}
	
	return users;
		
	}

	public List<Event> getEventsCity(String city, String genre){ //Takes city and genre input for the Event
		
		MongoClient mongoClient = getMongoDataSource();
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("Events");
		
	    //"select * from Events where VenueCity = '" + city + "' and Genre = '" 
		//+ genre + "' order by EventDate"); 
		//SQL query to get data from a particular city in the genre given for Events and sort by EventDate
		
	    List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("venue_city_name", city));
		criteria.add(new BasicDBObject("genre", genre));
		
		Bson sort = ascending("eventDate");
		
		FindIterable<Document> documents = collection.find(new BasicDBObject("$and", criteria)).sort(sort);
	    
		List<Event> eventSCity = new ArrayList<Event>(); //Create a new list of Event to store details
		
		for(Document document : documents)  {
			Event eventCity = new Event(); ////Create a new object of Event to get details
			
			eventCity.setArtistMBID((String) document.get("artist_mbid"));
			eventCity.setArtistName((String) document.get("artist_name"));
			eventCity.setTourName((String) document.get("tour_name"));
			eventCity.setVenueCity((String) document.get("venue_city_name"));
			eventCity.setVenueState((String) document.get("venue_city_state"));
			eventCity.setEventDate((String) document.get("eventDate"));
			eventCity.setVenueStateCode((String) document.get("venue_city_stateCode"));
			eventCity.setVenueName((String) document.get("venue_name"));
			eventCity.setGenre((String) document.get("genre"));
			
		
			eventSCity.add(eventCity); //adding Event object to the Event list
		}
	
		return eventSCity;
	}
	
	public List<Event> getEventsState(String state, String genre){ //Takes state and genre input for the Event
		
		MongoClient mongoClient = getMongoDataSource();
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("Events");
		
	    //select * from Events where VenueState = '" + state + "' and Genre = '" 
		//+ genre + "' order by EventDate"); 
		//SQL query to get data from a particular state in the genre given for Events and sort by EventDate
		
	    List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("venue_city_state", state));
		criteria.add(new BasicDBObject("genre", genre));
		
		Bson sort = ascending("eventDate");
		
		FindIterable<Document> documents = collection.find(new BasicDBObject("$and", criteria)).sort(sort);
	    
		List<Event> eventSState = new ArrayList<Event>(); //Create a new list of Event to store details
		
		for(Document document : documents)  {
			Event eventState = new Event(); ////Create a new object of Event to get details
			
			eventState.setArtistMBID((String) document.get("artist_mbid"));
			eventState.setArtistName((String) document.get("artist_name"));
			eventState.setTourName((String) document.get("tour_name"));
			eventState.setVenueCity((String) document.get("venue_city_name"));
			eventState.setVenueState((String) document.get("venue_city_state"));
			eventState.setEventDate((String) document.get("eventDate"));
			eventState.setVenueStateCode((String) document.get("venue_city_stateCode"));
			eventState.setVenueName((String) document.get("venue_name"));
			eventState.setGenre((String) document.get("genre"));
			
		
			eventSState.add(eventState); //adding Event object to the Event list
		}
	
		return eventSState;
		
	}
	
	public List<Track> getTracks(String artistId){ //Takes artist ID as input
		
		MongoClient mongoClient = getMongoDataSource();
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("Tracks");
		
	    //select * from Tracks where ArtistID = '" + artistId 
		//+ "' order by ArtistFamiliarity,ArtistHotness desc  limit 3");
		//SQL query to get data from a particular artist ID and sort it 
				//by ArtistFamiliarity and ArtistHotness with 3 output
		
	    List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("artist_id", artistId));
		
		FindIterable<Document> documents =  collection.find(new BasicDBObject("$and", criteria))
				.sort(new BasicDBObject("artist_familiarity", 1).append("artist_hotness", -1)).limit(3);
	    
		List<Track> tracks = new ArrayList<Track>(); //Create a new list of Track to store details
		
		for(Document document : documents) {
			Track track = new Track(); ////Create a new object of Track to get details
			
			track.setTrackID((String) document.get("track_id"));
			track.setTrackTitle((String) document.get("track_title"));
			track.setSongID((String) document.get("song_id"));
			track.setAlbumName((String) document.get("album_name"));
			track.setArtistID((String) document.get("artist_id"));
			track.setArtistMBID((String) document.get("artist_mbid"));
			track.setArtistName((String) document.get("artist_name"));
			track.setDuration((double) document.get("duration"));
			track.setArtistFamiliarity((double) document.get("artist_familiarity"));
			track.setArtistHotness((double) document.get("artist_hotness"));
			track.setYear((int) document.get("year"));
			track.setLocation((String) document.get("location"));
			track.setCity((String) document.get("city"));
			track.setState((String) document.get("state"));
			track.setGenre((String) document.get("Genre"));
		
			tracks.add(track); //adding Track object to the Track list
		}
	
		return tracks;
		
	}
	
	public List<Track> getTracksForSearch(String keyword){ //Takes keyword for search as input
		
		MongoClient mongoClient = getMongoDataSource();
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("Tracks");
		
	    //select * from Tracks where lower(Genre) like '%" 
		//+ keyword + "%' or lower(ArtistName) like '%" 
		//+ keyword + "%' or lower(TrackTitle) like '%" 
		//+ keyword + "%' or lower(AlbumName) like '%" 
		//+ keyword + "%' limit 10");
		//SQL query to get matching results with the keyword and displaying 10 output
		
	    List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("Genre", Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)));
		criteria.add(new BasicDBObject("artist_name", Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)));
		criteria.add(new BasicDBObject("track_title", Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)));
		criteria.add(new BasicDBObject("album_name", Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)));
		
		FindIterable<Document> documents = collection.find(new BasicDBObject("$or", criteria)).limit(10);
	    
		List<Track> tracks = new ArrayList<Track>(); //Create a new list of Track to store details
		
		for(Document document : documents) {
			Track track = new Track(); ////Create a new object of Track to get details
						
			track.setTrackID((String) document.get("track_id"));
			track.setTrackTitle((String) document.get("track_title"));
			track.setSongID((String) document.get("song_id"));
			track.setAlbumName((String) document.get("album_name"));
			track.setArtistID((String) document.get("artist_id"));
			track.setArtistMBID((String) document.get("artist_mbid"));
			track.setArtistName((String) document.get("artist_name"));
			track.setDuration((double) document.get("duration"));
			track.setArtistFamiliarity((double) document.get("artist_familiarity"));
			track.setArtistHotness((double) document.get("artist_hotness"));
			track.setYear((int) document.get("year"));
			track.setLocation((String) document.get("location"));
			track.setCity((String) document.get("city"));
			track.setState((String) document.get("state"));
			track.setGenre((String) document.get("Genre"));
		
			tracks.add(track); //adding Track object to the Track list
		}
	
		return tracks;
	}

	
	public String insertTrackMongo(TrackMongo track) {
		
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
		
		MongoDatabase database = mongoClient.getDatabase("music");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("Tracks");

	    Document document = new Document("track_id", track.getTrackID())
	    		.append("track_title", track.getTrackTitle())
	    		.append("song_id", track.getSongID())
	    		.append("album_name", track.getAlbumName())
	    		.append("artist_id", track.getArtistID())
	    		.append("artist_mbid", track.getArtistMBID())
	    		.append("artist_name", track.getArtistName())
	    		.append("duration", track.getDuration())
	    		.append("artist_familiarity", track.getArtistFamiliarity())
	    		.append("artist_hotness", track.getArtistHotness())
	    		.append("year", track.getYear())
	    		.append("location", track.getLocation())
	    		.append("city", track.getCity())
	    		.append("state", track.getState())
	    		.append("Genre", track.getGenre());

	    collection.insertOne(document);
		
		return "Inserted one document succesfully";
	}
}
	
